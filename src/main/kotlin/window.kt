package libui

import kotlinx.cinterop.*
import platform.posix.tm

/** Represents a top-level window.
 *  Contains one child control that occupies the entirety of the window. */
class Window(
    title: String,
    width: Int,
    height: Int,
    hasMenubar: Boolean = true,
    block: Window.() -> Unit = {}
) {
    val ref = StableRef.create(this)
    val ptr: CPointer<uiWindow> = uiNewWindow(title, width, height, if (hasMenubar) 1 else 0) ?: throw Error()

    internal var onResize: (Window.() -> Unit)? = null
    internal var onClose: (Window.() -> Boolean)? = null
    internal var actions = mutableListOf<StableRef<Any>>()
    internal var handlers = mutableListOf<CPointer<*>>()
    /*internal*/ var astrings = mutableListOf<AttributedString>()

    init {
        apply(block)
        uiWindowOnContentSizeChanged(ptr, staticCFunction(::_onResize), ref.asCPointer())
        uiWindowOnClosing(ptr, staticCFunction(::_onClose), ref.asCPointer())
    }

    fun dispose() {
        astrings.forEach { it.dispose() }
        actions.forEach { it.dispose() }
        ref.dispose()
    }

    /** Function to be run when window content size change. */
    fun onResize(proc: Window.() -> Unit) {
        onResize = proc
    }

    /** Function to be run when the user clicks the Window's close button.
     *  Only one function can be registered at a time.
     *  @returns [true] if window is destroyed */
    fun onClose(proc: Window.() -> Boolean) {
        onClose = proc
    }

    /** Function to be executed when the OS wants the program to quit
     *  or when a Quit menu item has been clicked.
     *  Only one function may be registered at a time.
     *  @returns `true` when Quit will be called. */
    fun onShouldQuit(proc: () -> Boolean) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiOnShouldQuit(staticCFunction(::_onBoolHandler), ref.asCPointer())
    }

    /** Function to be executed on a timer on the main thread.
     *  @returns `true` to continue and `false` to stop. */
    fun onTimer(milliseconds: Int, proc: () -> Boolean) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiTimer(milliseconds, staticCFunction(::_onBoolHandler), ref.asCPointer())
    }
}

/** Destroy and free the Window. */
fun Window.destroy() = uiControlDestroy(ptr.reinterpret())

/** Returns the OS-level handle associated with this Window.
 *  - On Windows this is an HWND of a libui-internal class.
 *  - On GTK+ this is a pointer to a GtkWindow.
 *  - On macOS this is a pointer to a NSWindow. */
val Window.handle: Long get() = uiControlHandle(ptr.reinterpret())

/** Set or return the text to show in window title bar. */
var Window.title: String
    get() = uiWindowTitle(ptr)?.toKString() ?: ""
    set(title) = uiWindowSetTitle(ptr, title)

/** Allow to specify that the window is a frameless one, without borders,
 *  title bar and OS window control widgets. */
var Window.borderless: Boolean
    get() = uiWindowBorderless(ptr) != 0
    set(borderless) = uiWindowSetBorderless(ptr, if (borderless) 1 else 0)

/** Specify if the Window content should have a margin or not. Defaults to `false`. */
var Window.margined: Boolean
    get() = uiWindowMargined(ptr) != 0
    set(margined) = uiWindowSetMargined(ptr, if (margined) 1 else 0)

/** Whether the window should show in fullscreen or not. */
var Window.fullscreen: Boolean
    get() = uiWindowFullscreen(ptr) != 0
    set(fullscreen) = uiWindowSetFullscreen(ptr, if (fullscreen) 1 else 0)

/** Size in pixel of the content area of the window.
 *  Window decoration size are excluded. This mean that if you set window size to 0,0
 *  you still see title bar and OS window buttons. */
var Window.contentSize: Size2D
    get() = memScoped {
        val width = alloc<IntVar>()
        var height = alloc<IntVar>()
        uiWindowContentSize(ptr, width.ptr, height.ptr)
        Size2D(width = width.value, height = height.value)
    }
    set(size) = uiWindowSetContentSize(ptr, size.width, size.height)

/** Specify the control to show in window content area.
 *  Window instances can contain only one control. If you need more, you have to use Container */
fun Window.setChild(widget: Control) = uiWindowSetChild(ptr, widget.ctl)

/** Show the window. */
fun Window.show() = uiControlShow(ptr.reinterpret())

fun Window.OpenFileDialog(): String? {
    val rawName = uiOpenFile(ptr)
    if (rawName == null) return null
    val strName = rawName.toKString()
    uiFreeText(rawName)
    return strName
}

fun Window.SaveFileDialog(): String? {
    val rawName = uiSaveFile(ptr)
    if (rawName == null) return null
    val strName = rawName.toKString()
    uiFreeText(rawName)
    return strName
}

fun Window.MsgBox(text: String, details: String = "")
    = uiMsgBox(ptr, text, details)

fun Window.MsgBoxError(text: String, details: String = "")
    = uiMsgBoxError(ptr, text, details)

///////////////////////////////////////////////////////////////////////////////

@Suppress("UNUSED_PARAMETER")
private fun _onResize(ptr: CPointer<uiWindow>?, ref: COpaquePointer?) {
    val window = ref!!.asStableRef<Window>().get()
    window.onResize?.invoke(window)
}

@Suppress("UNUSED_PARAMETER")
private fun _onClose(ptr: CPointer<uiWindow>?, ref: COpaquePointer?): Int {
    val window = ref!!.asStableRef<Window>().get()
    val close = window.onClose?.invoke(window) ?: true
    if (close) window.dispose()
    return if (close) 1 else 0
}

internal fun _onBoolHandler(ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<() -> Boolean>().get()
    return if (proc()) 1 else 0
}
