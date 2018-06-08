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
        handlers.forEach { nativeHeap.free(it) }

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
     *  @returns [true] when Quit will be called. */
    fun onShouldQuit(proc: () -> Boolean) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiOnShouldQuit(staticCFunction(::_onShouldQuit), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the Entry.
     *  Only one function can be registered at a time. */
    fun Entry.action(proc: Entry.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiEntryOnChanged(this, staticCFunction(::_onEntry), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the MultilineEntry.
     *  Only one function can be registered at a time. */
    fun MultilineEntry.action(proc: MultilineEntry.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiMultilineEntryOnChanged(this, staticCFunction(::_onMultilineEntry), ref.asCPointer())
    }

    /** Funcion to be run when the user clicks the Checkbox.
     *  Only one function can be registered at a time. */
    fun Checkbox.action(proc: Checkbox.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiCheckboxOnToggled(this, staticCFunction(::_onCheckbox), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the Combobox.
     *  Only one function can be registered at a time. */
    fun Combobox.action(proc: Combobox.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiComboboxOnSelected(this, staticCFunction(::_onCombobox), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the EditableCombobox.
     *  Only one function can be registered at a time. */
    //TODO what do we call a function that sets the currently selected item and fills the text field with it?
    //TODO editable comboboxes have no consistent concept of selected item
    fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiEditableComboboxOnChanged(this, staticCFunction(::_onEditableCombobox), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the Spinbox.
     *  Only one function can be registered at a time. */
    fun Spinbox.action(proc: Spinbox.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiSpinboxOnChanged(this, staticCFunction(::_onSpinbox), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the Slider.
     *  Only one function can be registered at a time. */
    fun Slider.action(proc: Slider.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiSliderOnChanged(this, staticCFunction(::_onSlider), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the RadioButtons.
     *  Only one function can be registered at a time. */
    fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiRadioButtonsOnSelected(this, staticCFunction(::_onRadioButtons), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the DateTimePicker.
     *  Only one function can be registered at a time. */
    fun DateTimePicker.action(proc: DateTimePicker.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiDateTimePickerOnChanged(this, staticCFunction(::_onDateTimePicker), ref.asCPointer())
    }

    /** Funcion to be run when the user clicks the Button.
     *  Only one function can be registered at a time. */
    fun Button.action(proc: Button.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiButtonOnClicked(this, staticCFunction(::_onButton), ref.asCPointer())
    }

    /** Funcion to be run when the user makes a change to the ColorButton.
     *  Only one function can be registered at a time. */
    fun ColorButton.action(proc: ColorButton.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiColorButtonOnChanged(this, staticCFunction(::_onColorButton), ref.asCPointer())
    }

    /** Funcion to be run when the font in the FontButton is changed.
     *  Only one function can be registered at a time. */
    fun FontButton.action(proc: FontButton.() -> Unit) {
        val ref = StableRef.create(proc).also { actions.add(it) }
        uiFontButtonOnChanged(this, staticCFunction(::_onFontButton), ref.asCPointer())
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
private fun _onResize(ptr: CWindow?, ref: COpaquePointer?) {
    val window = ref!!.asStableRef<Window>().get()
    window.onResize?.invoke(window)
}

@Suppress("UNUSED_PARAMETER")
private fun _onClose(ptr: CWindow?, ref: COpaquePointer?): Int {
    val window = ref!!.asStableRef<Window>().get()
    val close = window.onClose?.invoke(window) ?: true
    if (close) window.dispose()
    return if (close) 1 else 0
}

internal fun _onShouldQuit(ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<() -> Boolean>().get()
    return if (proc()) 1 else 0
}

private fun _onEntry(widget: Entry?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Entry.() -> Unit>().get()
    widget!!.proc()
}

private fun _onMultilineEntry(widget: MultilineEntry?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<MultilineEntry.() -> Unit>().get()
    widget!!.proc()
}

private fun _onCheckbox(widget: Checkbox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Checkbox.() -> Unit>().get()
    widget!!.proc()
}

private fun _onCombobox(widget: Combobox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Combobox.() -> Unit>().get()
    widget!!.proc()
}

private fun _onEditableCombobox(widget: EditableCombobox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<EditableCombobox.() -> Unit>().get()
    widget!!.proc()
}

private fun _onSpinbox(widget: Spinbox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Spinbox.() -> Unit>().get()
    widget!!.proc()
}

private fun _onSlider(widget: Slider?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Slider.() -> Unit>().get()
    widget!!.proc()
}

private fun _onRadioButtons(widget: RadioButtons?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<RadioButtons.() -> Unit>().get()
    widget!!.proc()
}

private fun _onDateTimePicker(widget: DateTimePicker?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<DateTimePicker.() -> Unit>().get()
    widget!!.proc()
}

private fun _onButton(button: Button?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Button.() -> Unit>().get()
    button!!.proc()
}

private fun _onColorButton(widget: ColorButton?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<ColorButton.() -> Unit>().get()
    widget!!.proc()
}

private fun _onFontButton(widget: FontButton?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<FontButton.() -> Unit>().get()
    widget!!.proc()
}
