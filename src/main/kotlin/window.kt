package libui

import kotlinx.cinterop.*
import platform.posix.tm

typealias CWindow = CPointer<uiWindow>

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
    val ptr: CWindow = uiNewWindow(title, width, height, if (hasMenubar) 1 else 0) ?: throw Error()

    init {
        apply(block)
    }

    fun dispose() {
        ref.dispose()
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
fun Window.setChild(child: Form) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Grid) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Box) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Tab) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Group) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Entry) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: MultilineEntry) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Checkbox) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Combobox) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: EditableCombobox) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Spinbox) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Slider) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: RadioButtons) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: DateTimePicker) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Label) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Separator) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: ProgressBar) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: Button) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: ColorButton) = uiWindowSetChild(ptr, child.asControl())
fun Window.setChild(child: FontButton) = uiWindowSetChild(ptr, child.asControl())

/** Show the window. */
fun Window.show() = uiControlShow(ptr.reinterpret())

/** Function to be run when window content size change. */
//fun Window.onSizeChanged(proc: Window.() -> Unit) {
//    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
//    uiWindowOnContentSizeChanged(ptr, staticCFunction(::_onWindow), ref.asCPointer())
//}

//internal fun _onWindow(window: CWindow?, ref: COpaquePointer?) {
//    val proc = ref!!.asStableRef<Window.() -> Unit>().get()
//    window!!.proc()
//}

/** Function to be run when the user clicks the Window's close button.
 *  Only one function can be registered at a time.
 *  @returns [true] if window is destroyed */
fun Window.onClose(proc: Window.() -> Boolean) {
    uiWindowOnClosing(ptr, staticCFunction(::_onClose), ref.asCPointer())
}

internal fun _onClose(window: CWindow?, ref: COpaquePointer?): Int {
    val window = ref!!.asStableRef<Window>().get()
//  return if (window.proc()) 1 else 0
    uiQuit()
    window.dispose()
    return 1
}
