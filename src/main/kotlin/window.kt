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
) : Control(uiNewWindow(title, width, height, if (hasMenubar) 1 else 0)) {
    internal val ptr: CPointer<uiWindow> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")

    internal var onClose: (Window.() -> Boolean)? = null
    internal var onResize: (Window.() -> Unit)? = null

    init {
        apply(block)
        uiWindowOnClosing(ptr, staticCFunction(::_Close), ref.asCPointer())
        uiWindowOnContentSizeChanged(ptr, staticCFunction(::_Resize), ref.asCPointer())
    }
}

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
var Window.contentSize: SizeInt
    get() = memScoped {
        val width = alloc<IntVar>()
        var height = alloc<IntVar>()
        uiWindowContentSize(ptr, width.ptr, height.ptr)
        SizeInt(width.value, height.value)
    }
    set(size) = uiWindowSetContentSize(ptr, size.width, size.height)

/** Specify the control to show in window content area.
 *  Window instances can contain only one control. If you need more, you have to use Container */
fun Window.add(widget: Control) = uiWindowSetChild(ptr, widget.ctl)

/** Function to be run when window content size change. */
fun Window.onResize(proc: Window.() -> Unit) {
    onResize = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _Resize(ptr: CPointer<uiWindow>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Window>().get()) {
        onResize?.invoke(this)
	}
}

/** Function to be run when the user clicks the Window's close button.
 *  Only one function can be registered at a time.
 *  @returns [true] if window is destroyed */
fun Window.onClose(proc: Window.() -> Boolean) {
    onClose = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _Close(ptr: CPointer<uiWindow>?, ref: COpaquePointer?): Int {
    with (ref!!.asStableRef<Window>().get()) {
    	return if (onClose?.invoke(this) ?: true) 1 else 0
	}
}

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
