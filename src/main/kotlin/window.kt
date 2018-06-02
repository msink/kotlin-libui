package libui

import kotlinx.cinterop.*
import platform.posix.tm

/** Represents a top-level window.
 *  Contains one child control that occupies the entirety of the window. */
typealias Window = CPointer<uiWindow>

/** Create a new Window. */
fun Window(
    title: String,
    width: Int,
    height: Int,
    hasMenubar: Boolean = true,
    block: Window.() -> Unit = {}
) : Window =
    uiNewWindow(title, width, height, if (hasMenubar) 1 else 0)?.apply(block) ?: throw Error()

/** Destroy and free the Window. */
fun Window.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Window.
 *  - On Windows this is an HWND of a libui-internal class.
 *  - On GTK+ this is a pointer to a GtkWindow.
 *  - On macOS this is a pointer to a NSWindow. */
val Window.handle: Long get() = uiControlHandle(reinterpret())

/** Set or return the text to show in window title bar. */
var Window.title: String
    get() = uiWindowTitle(this)?.toKString() ?: ""
    set(title) = uiWindowSetTitle(this, title)

/** Allow to specify that the window is a frameless one, without borders,
 *  title bar and OS window control widgets. */
var Window.borderless: Boolean
    get() = uiWindowBorderless(this) != 0
    set(borderless) = uiWindowSetBorderless(this, if (borderless) 1 else 0)

/** Specify if the Window content should have a margin or not. Defaults to `false`. */
var Window.margined: Boolean
    get() = uiWindowMargined(this) != 0
    set(margined) = uiWindowSetMargined(this, if (margined) 1 else 0)

/** Whether the window should show in fullscreen or not. */
var Window.fullscreen: Boolean
    get() = uiWindowFullscreen(this) != 0
    set(fullscreen) = uiWindowSetFullscreen(this, if (fullscreen) 1 else 0)

/** Size in pixel of the content area of the window.
 *  Window decoration size are excluded. This mean that if you set window size to 0,0
 *  you still see title bar and OS window buttons. */
var Window.contentSize: Size2D
    get() = memScoped {
        val width = alloc<IntVar>()
        var height = alloc<IntVar>()
        uiWindowContentSize(this@contentSize, width.ptr, height.ptr)
        Size2D(width = width.value, height = height.value)
    }
    set(size) = uiWindowSetContentSize(this, size.width, size.height)

/** Specify the control to show in window content area.
 *  Window instances can contain only one control. If you need more, you have to use Container */
fun Window.setChild(child: Form) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Grid) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Box) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Tab) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Group) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Entry) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: MultilineEntry) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Checkbox) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Combobox) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: EditableCombobox) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Spinbox) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Slider) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: RadioButtons) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: DateTimePicker) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Label) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Separator) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: ProgressBar) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: Button) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: ColorButton) = uiWindowSetChild(this, child.asControl())
fun Window.setChild(child: FontButton) = uiWindowSetChild(this, child.asControl())

/** Show the window. */
fun Window.show() = uiControlShow(reinterpret())

/** Function to be run when window content size change. */
fun Window.onSizeChanged(proc: Window.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiWindowOnContentSizeChanged(this, staticCFunction(::_onWindow), ref.asCPointer())
}

internal fun _onWindow(window: Window?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Window.() -> Unit>().get()
    window!!.proc()
}

/** Function to be run when the user clicks the Window's close button.
 *  Only one function can be registered at a time.
 *  @returns [true] if window is destroyed */
fun Window.onClose(proc: Window.() -> Boolean) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiWindowOnClosing(this, staticCFunction(::_onClose), ref.asCPointer())
}

internal fun _onClose(window: Window?, ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<Window.() -> Boolean>().get()
    return if (window!!.proc()) 1 else 0
}
