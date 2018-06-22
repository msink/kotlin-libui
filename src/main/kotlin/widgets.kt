package libui

import kotlinx.cinterop.*
import platform.posix.*

///////////////////////////////////////////////////////////////////////////////
//
// Data entry widgets:
// - [Entry]
// - [PasswordEntry]
// - [SearchEntry]
// - [MultilineEntry]
// - [NonWrappingMultilineEntry]
// - [Checkbox]
// - [Combobox]
// - [EditableCombobox]
// - [Spinbox]
// - [Slider]
// - [RadioButtons]
// - [DateTimePicker]
// - [DatePicker]
// - [TimePicker]
//
// Static widgets:
// - [Label]
// - [HorizontalSeparator]
// - [VerticalSeparator]
// - [ProgressBar]
//
// Buttons:
// - [Button]
// - [ColorButton]
// - [FontButton]
//
///////////////////////////////////////////////////////////////////////////////

/** Represents a GUI control (widget). It provides methods common to all Controls. */
abstract class Control<T : CPointed> constructor(
    internal var _ptr: CPointer<T>?
) {
    internal val ptr: CPointer<T> get() = _ptr ?: throw Error("Control is destroyed")
    internal val ctl: CPointer<uiControl> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal val ctlDestroy = ctl.pointed.Destroy
    internal val ref = StableRef.create(this)
    init {
        controls[ctl] = this
        ctl.pointed.Destroy = staticCFunction(::_Destroy)
    }
    internal open fun dispose() {
        ref.dispose()
        _ptr = null
    }

    /** Returns `true` if Control was destroyed - in this case all other operations
     *  are invalid and will `throw Error("Control is destroyed")`. */
    val destroyed: Boolean get() = _ptr == null

    /** Destroy and free all allocated resources. */
    fun destroy() = uiControlDestroy(ctl)

    /** Returns the OS-level handle associated with this Control. */
    fun getHandle(): Long = uiControlHandle(ctl)

    /** Returns whether the control is a top level one or not. */
    val toplevel: Boolean
        get() = uiControlToplevel(ctl) != 0

    /** Returns parent of the control or `null` for detached. */
    var parent: Control<*>?
        get() = controls[uiControlParent(ctl)]
        set(parent) = uiControlSetParent(ctl, parent?.ctl)

    /** Whether the Control is enabled. */
    fun isEnabled(): Boolean = uiControlEnabled(ctl) != 0

    /** Whether the Control and all parents are enabled. */
    fun isEnabledToUser(): Boolean = uiControlEnabledToUser(ctl) != 0

    /** Enables the Control. */
    fun enable() = uiControlEnable(ctl)

    /** Disables the Control. */
    fun disable() = uiControlDisable(ctl)

    /** Whether the Control should be enabled or disabled. Defaults to `true`. */
    var enabled: Boolean
        get() = isEnabled()
        set(enabled) = if (enabled) enable() else disable()

    /** Whether the Control is visible. */
    fun isVisible(): Boolean = uiControlVisible(ctl) != 0

    /** Shows the Control. */
    fun show() = uiControlShow(ctl)

    /** Hides the Control. Hidden controls do not participate in layout
     *  (that is, Box, Grid, etc. does not reserve space for hidden controls). */
    fun hide() = uiControlHide(ctl)

    /** Whether the Control should be visible or hidden. Defaults to `true`. */
    var visible: Boolean
        get() = isVisible()
        set(visible) = if (visible) show() else hide()
}

private var controls = mutableMapOf<CPointer<uiControl>, Control<*>>()

private fun _Destroy(ctl: CPointer<uiControl>?) {
    with (controls[ctl!!] ?: throw Error("Control is destroyed")) {
        ctlDestroy?.invoke(ctl)
        controls.remove(ctl)
        dispose()
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A simple single line text entry widget. */
open class Entry internal constructor(_ptr: CPointer<uiEntry>?
) : Control<uiEntry>(_ptr) {
    constructor(block: Entry.() -> Unit = {}): this(uiNewEntry()) { apply(block) }
    internal var action: (Entry.() -> Unit)? = null
}

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
class PasswordEntry(block: PasswordEntry.() -> Unit = {}
) : Entry(uiNewPasswordEntry()) {
    init { apply(block) }
}

/** Text entry widget to search text. */
class SearchEntry(block: SearchEntry.() -> Unit = {}
) : Entry(uiNewSearchEntry()) {
    init { apply(block) }
}

/** The current text of the Entry. */
var Entry.value: String
    get() = uiEntryText(ptr)?.toKString() ?: ""
    set(value) = uiEntrySetText(ptr, value)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var Entry.readOnly: Boolean
    get() = uiEntryReadOnly(ptr) != 0
    set(readOnly) = uiEntrySetReadOnly(ptr, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(proc: Entry.() -> Unit) {
    action = proc
    uiEntryOnChanged(ptr, staticCFunction(::_Entry), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Entry(ptr: CPointer<uiEntry>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Entry>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
open class MultilineEntry internal constructor(_ptr: CPointer<uiMultilineEntry>?
) : Control<uiMultilineEntry>(_ptr) {
    constructor(block: MultilineEntry.() -> Unit = {}): this(uiNewMultilineEntry()) { apply(block) }
    internal var action: (MultilineEntry.() -> Unit)? = null
}

/** A non wrapping multiline text entry widget. */
class NonWrappingMultilineEntry(block: NonWrappingMultilineEntry.() -> Unit = {}
) : MultilineEntry(uiNewNonWrappingMultilineEntry()) {
    init { apply(block) }
}

/** The current text of the multiline entry. */
var MultilineEntry.value: String
    get() = uiMultilineEntryText(ptr)?.toKString() ?: ""
    set(value) = uiMultilineEntrySetText(ptr, value)

/** Whether the user is allowed to change the entry text. */
var MultilineEntry.readOnly: Boolean
    get() = uiMultilineEntryReadOnly(ptr) != 0
    set(readOnly) = uiMultilineEntrySetReadOnly(ptr, if (readOnly) 1 else 0)

/** Adds the text to the end of the multiline entry. */
fun MultilineEntry.append(text: String) = uiMultilineEntryAppend(ptr, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun MultilineEntry.action(proc: MultilineEntry.() -> Unit) {
    action = proc
    uiMultilineEntryOnChanged(ptr, staticCFunction(::_MultilineEntry), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _MultilineEntry(ptr: CPointer<uiMultilineEntry>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<MultilineEntry>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
class Checkbox(label: String, block: Checkbox.() -> Unit = {}
) : Control<uiCheckbox>(uiNewCheckbox(label)) {
    internal var action: (Checkbox.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the checkbox. */
var Checkbox.label: String
    get() = uiCheckboxText(ptr)?.toKString() ?: ""
    set(label) = uiCheckboxSetText(ptr, label)

/** Whether the checkbox is checked or unchecked. Defaults to `false`. */
var Checkbox.value: Boolean
    get() = uiCheckboxChecked(ptr) != 0
    set(value) = uiCheckboxSetChecked(ptr, if (value) 1 else 0)

/** Funcion to be run when the user clicks the Checkbox.
 *  Only one function can be registered at a time. */
fun Checkbox.action(proc: Checkbox.() -> Unit) {
    action = proc
    uiCheckboxOnToggled(ptr, staticCFunction(::_Checkbox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Checkbox(ptr: CPointer<uiCheckbox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Checkbox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
class Combobox(block: Combobox.() -> Unit = {}
) : Control<uiCombobox>(uiNewCombobox()) {
    internal var action: (Combobox.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named entry to the end of the combobox.
 *  If it is the first entry, it is automatically selected. */
fun Combobox.add(text: String) = uiComboboxAppend(ptr, text)

/** Return or set the current choosed option by index. */
var Combobox.value: Int
    get() = uiComboboxSelected(ptr)
    set(value) = uiComboboxSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(proc: Combobox.() -> Unit) {
    action = proc
    uiComboboxOnSelected(ptr, staticCFunction(::_Combobox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Combobox(ptr: CPointer<uiCombobox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Combobox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
class EditableCombobox(block: EditableCombobox.() -> Unit = {}
) : Control<uiEditableCombobox>(uiNewEditableCombobox()) {
    internal var action: (EditableCombobox.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named entry to the end of the editable combobox.
 *  If it is the first entry, it is automatically selected. */
fun EditableCombobox.add(text: String) = uiEditableComboboxAppend(ptr, text)

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.value: String
    get() = uiEditableComboboxText(ptr)?.toKString() ?: ""
    set(value) = uiEditableComboboxSetText(ptr, value)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
    action = proc
    uiEditableComboboxOnChanged(ptr, staticCFunction(::_EditableCombobox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _EditableCombobox(ptr: CPointer<uiEditableCombobox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<EditableCombobox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
class Spinbox(min: Int, max: Int, block: Spinbox.() -> Unit = {}
) : Control<uiSpinbox>(uiNewSpinbox(min, max)) {
    internal var action: (Spinbox.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the spinbox. */
var Spinbox.value: Int
    get() = uiSpinboxValue(ptr)
    set(value) = uiSpinboxSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Spinbox.
 *  Only one function can be registered at a time. */
fun Spinbox.action(proc: Spinbox.() -> Unit) {
    action = proc
    uiSpinboxOnChanged(ptr, staticCFunction(::_Spinbox), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Spinbox(ptr: CPointer<uiSpinbox>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Spinbox>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
class Slider(min: Int, max: Int, block: Slider.() -> Unit = {}
) : Control<uiSlider>(uiNewSlider(min, max)) {
    internal var action: (Slider.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the slider. */
var Slider.value: Int
    get() = uiSliderValue(ptr)
    set(value) = uiSliderSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Slider.
 *  Only one function can be registered at a time. */
fun Slider.action(proc: Slider.() -> Unit) {
    action = proc
    uiSliderOnChanged(ptr, staticCFunction(::_Slider), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Slider(ptr: CPointer<uiSlider>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Slider>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
class RadioButtons(block: RadioButtons.() -> Unit = {}
) : Control<uiRadioButtons>(uiNewRadioButtons()) {
    internal var action: (RadioButtons.() -> Unit)? = null
    init { apply(block) }
}

/** Adds the named button to the end of the radiobuttons.
 *  If it is the first button, it is automatically selected. */
fun RadioButtons.add(text: String) = uiRadioButtonsAppend(ptr, text)

/** Return or set the current choosed option by index. */
var RadioButtons.value: Int
    get() = uiRadioButtonsSelected(ptr)
    set(value) = uiRadioButtonsSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
    action = proc
    uiRadioButtonsOnSelected(ptr, staticCFunction(::_RadioButtons), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _RadioButtons(ptr: CPointer<uiRadioButtons>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<RadioButtons>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A widget to edit date and time. */
open class DateTimePicker internal constructor(_ptr: CPointer<uiDateTimePicker>?
) : Control<uiDateTimePicker>(_ptr) {
    constructor(block: DateTimePicker.() -> Unit = {}): this(uiNewDateTimePicker()) { apply(block) }
    internal var action: (DateTimePicker.() -> Unit)? = null
    internal var defaultFormat = "%c"
}

/** A widget to edit date. */
class DatePicker(block: DateTimePicker.() -> Unit = {}
) : DateTimePicker(uiNewDatePicker()) {
    init {
        defaultFormat = "%x"
        apply(block)
    }
}

/** A widget to edit time. */
class TimePicker(block: DateTimePicker.() -> Unit = {}
) : DateTimePicker(uiNewTimePicker()) {
    init {
        defaultFormat = "%X"
        apply(block)
    }
}

/** The current value as posix `struct tm` */
fun DateTimePicker.getValue(value: CPointer<tm>) = uiDateTimePickerTime(ptr, value)

/** Set current value from posix `struct tm` */
fun DateTimePicker.setValue(value: CPointer<tm>) = uiDateTimePickerSetTime(ptr, value)

/** The current value in Unix epoch */
var DateTimePicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>()
       getValue(tm.ptr)
       mktime(tm.ptr)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       setValue(localtime(time.ptr)!!)
    }

/** The current value as String. */
fun DateTimePicker.textValue(format: String = defaultFormat): String = memScoped {
    var tm = alloc<tm>()
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(ptr, tm.ptr)
    strftime(buf, 64, format, tm.ptr)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the Picker.
 *  Only one function can be registered at a time. */
fun DateTimePicker.action(proc: DateTimePicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(ptr, staticCFunction(::_DateTimePicker), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _DateTimePicker(ptr: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<DateTimePicker>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
class Label(text: String, block: Label.() -> Unit = {}
) : Control<uiLabel>(uiNewLabel(text)) {
    init { apply(block) }
}

/** The static text of the label. */
var Label.text: String
    get() = uiLabelText(ptr)?.toKString() ?: ""
    set(value) = uiLabelSetText(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
abstract class Separator(_ptr: CPointer<uiSeparator>?
) : Control<uiSeparator>(_ptr)

/** An horizontal line to visually separate widgets. */
class HorizontalSeparator(block: HorizontalSeparator.() -> Unit = {}
) : Separator(uiNewHorizontalSeparator()) {
    init { apply(block) }
}

/** A vertical line to visually separate widgets. */
class VerticalSeparator(block: VerticalSeparator.() -> Unit = {}
) : Separator(uiNewVerticalSeparator()) {
    init { apply(block) }
}

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
class ProgressBar(block: ProgressBar.() -> Unit = {}
) : Control<uiProgressBar>(uiNewProgressBar()) {
    init { apply(block) }
}

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(ptr)
    set(value) = uiProgressBarSetValue(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
class Button(text: String, block: Button.() -> Unit = {}
) : Control<uiButton>(uiNewButton(text)) {
    internal var action: (Button.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the button. */
var Button.text: String
    get() = uiButtonText(ptr)?.toKString() ?: ""
    set(text) = uiButtonSetText(ptr, text)

/** Funcion to be run when the user clicks the Button.
 *  Only one function can be registered at a time. */
fun Button.action(proc: Button.() -> Unit) {
    action = proc
    uiButtonOnClicked(ptr, staticCFunction(::_Button), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _Button(ptr: CPointer<uiButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<Button>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton(block: ColorButton.() -> Unit = {}
) : Control<uiColorButton>(uiNewColorButton()) {
    internal var action: (ColorButton.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the currently selected color */
var ColorButton.value: RGBA
    get() = memScoped {
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiColorButtonColor(ptr, r.ptr, g.ptr, b.ptr, a.ptr)
        RGBA(r.value, g.value, b.value, a.value)
    }
    set(value) {
        uiColorButtonSetColor(ptr, value.r, value.g, value.b, value.a)
    }

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(proc: ColorButton.() -> Unit) {
    action = proc
    uiColorButtonOnChanged(ptr, staticCFunction(::_ColorButton), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _ColorButton(ptr: CPointer<uiColorButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<ColorButton>().get()) {
        action?.invoke(this)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton(block: FontButton.() -> Unit = {}
) : Control<uiFontButton>(uiNewFontButton()) {
    internal var action: (FontButton.() -> Unit)? = null
    internal val desc = nativeHeap.alloc<uiFontDescriptor>().ptr
    init { apply(block) }
    override fun dispose() {
        if (desc.pointed.Family != null) desc.dispose()
        nativeHeap.free(desc)
        super.dispose()
    }
}

/** Returns the font currently selected in the FontButton. */
val FontButton.value: FontDescriptor get() {
    if (desc.pointed.Family != null) desc.dispose()
    uiFontButtonFont(ptr, desc)
    return desc
}

/** Funcion to be run when the font in the FontButton is changed.
 *  Only one function can be registered at a time. */
fun FontButton.action(proc: FontButton.() -> Unit) {
    action = proc
    uiFontButtonOnChanged(ptr, staticCFunction(::_FontButton), ref.asCPointer())
}

@Suppress("UNUSED_PARAMETER")
private fun _FontButton(ptr: CPointer<uiFontButton>?, ref: COpaquePointer?) {
    with (ref!!.asStableRef<FontButton>().get()) {
        action?.invoke(this)
    }
}
