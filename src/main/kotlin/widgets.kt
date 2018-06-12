package libui

import kotlinx.cinterop.*
import platform.posix.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Form]
// - [Grid]
// - [HorizontalBox]
// - [VerticalBox]
// - [Tab]
// - [Group]
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
abstract class Control(internal var _ptr: COpaquePointer?) {
    internal val ctl: CPointer<uiControl> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal val ctlDestroy = ctl.pointed.Destroy
    init {
        ctl.pointed.Destroy = staticCFunction(::onDestroy)
        controls[ctl] = this
    }
    internal val ref = StableRef.create(this)
    internal open fun dispose() {
        ref.dispose()
        _ptr = null
    }
}
private var controls = mutableMapOf<CPointer<uiControl>, Control>()
private fun onDestroy(ctl: CPointer<uiControl>?) {
    with (controls[ctl!!] ?: throw Error("Control is destroyed")) {
        ctlDestroy?.invoke(ctl)
        controls.remove(ctl)
        dispose()
    }
}

/** Returns `true` if Control was destroyed - in this case all other operations
 *  are invalid and will `throw Error("Control is destroyed")`. */
val Control.destroyed: Boolean get() = _ptr == null

/** Destroy and free all allocated resources. */
fun Control.destroy() = uiControlDestroy(ctl)

/** Returns the OS-level handle associated with this Control. */
fun Control.getHandle(): Long = uiControlHandle(ctl)

/** Whether the Control is enabled. */
fun Control.isEnabled(): Boolean = uiControlEnabled(ctl) != 0

/** Enables the Control. */
fun Control.enable() = uiControlEnable(ctl)

/** Disables the Control. */
fun Control.disable() = uiControlDisable(ctl)

/** Whether the Control should be enabled or disabled. Defaults to `true`. */
var Control.enabled: Boolean
    get() = isEnabled()
    set(enabled) = if (enabled) enable() else disable()

/** Whether the Control is visible. */
fun Control.isVisible(): Boolean = uiControlVisible(ctl) != 0

/** Shows the Control. */
fun Control.show() = uiControlShow(ctl)

/** Hides the Control. Hidden controls do not participate in layout
 *  (that is, Box, Grid, etc. does not reserve space for hidden controls). */
fun Control.hide() = uiControlHide(ctl)

/** Whether the Control should be visible or hidden. Defaults to `true`. */
var Control.visible: Boolean
    get() = isVisible()
    set(visible) = if (visible) show() else hide()

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form(block: Form.() -> Unit = {}) : Control(uiNewForm()) {
    internal val ptr: CPointer<uiForm> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun Form.append(label: String, widget: Control, stretchy: Boolean = false) =
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid(block: Grid.() -> Unit = {}) : Control(uiNewGrid()) {
    internal val ptr: CPointer<uiGrid> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the Grid. */
fun Grid.append(
    widget: Control,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(ptr, widget.ctl, left, top, xspan, yspan, hexpand, halign, vexpand, valign)

fun Grid.insertAt(
    widget: Control,
    existing: Control,
    at: uiAt,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridInsertAt(ptr, widget.ctl, existing.ctl, at, xspan, yspan, hexpand, halign, vexpand, valign)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(_ptr: CPointer<uiBox>?) : Control(_ptr) {
    internal val ptr: CPointer<uiBox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
}

/** A container that stack its chidren horizontally. */
class HorizontalBox(block: HorizontalBox.() -> Unit = {}) : Box(uiNewHorizontalBox()) {
    init { apply(block) }
}

/** A container that stack its chidren vertically. */
class VerticalBox(block: VerticalBox.() -> Unit = {}) : Box(uiNewVerticalBox()) {
    init { apply(block) }
}

/** If `true`, the container insert some space between children. Defaults to `false`. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the HorizontalBox. */
fun Box.append(widget: Control, stretchy: Boolean = false) =
    uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)

/** deletes the nth control of the HorizontalBox. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab(block: Tab.() -> Unit = {}) : Control(uiNewTab()) {
    internal val ptr: CPointer<uiTab> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun Tab.append(name: String, widget: Control) = uiTabAppend(ptr, name, widget.ctl)

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insertAt(index: Int, name: String, widget: Control) = uiTabInsertAt(ptr, name, index, widget.ctl)

/** Delete deletes the nth page of the Tab. */
fun Tab.deleteAt(index: Int) = uiTabDelete(ptr, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(ptr)

///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(text: String, block: Group.() -> Unit = {}) : Control(uiNewGroup(text)) {
    internal val ptr: CPointer<uiGroup> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

/** sets the group's child. If child is null, the group will not have a child. */
fun Group.setChild(child: Control?) = uiGroupSetChild(ptr, child?.ctl)

///////////////////////////////////////////////////////////////////////////////

/** Single line text entry widget. */
abstract class Entry(_ptr: CPointer<uiEntry>?) : Control(_ptr) {
    internal val ptr: CPointer<uiEntry> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Entry.() -> Unit)? = null
}

/** A simple single line text entry widget. */
class TextEntry(block: Entry.() -> Unit = {}) : Entry(uiNewEntry()) {
    init { apply(block) }
}

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
class PasswordEntry(block: PasswordEntry.() -> Unit = {}) : Entry(uiNewPasswordEntry()) {
    init { apply(block) }
}

/** Text entry widget to search text. */
class SearchEntry(block: SearchEntry.() -> Unit = {}) : Entry(uiNewSearchEntry()) {
    init { apply(block) }
}

/** The current text of the Entry. */
var Entry.text: String
    get() = uiEntryText(ptr)?.toKString() ?: ""
    set(text) = uiEntrySetText(ptr, text)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var Entry.readOnly: Boolean
    get() = uiEntryReadOnly(ptr) != 0
    set(readOnly) = uiEntrySetReadOnly(ptr, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(proc: Entry.() -> Unit) {
    action = proc
    uiEntryOnChanged(ptr, staticCFunction(::_onEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onEntry(ptr: CPointer<uiEntry>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Entry>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
abstract class MultilineEntry(_ptr: CPointer<uiMultilineEntry>?) : Control(_ptr) {
    internal val ptr: CPointer<uiMultilineEntry> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (MultilineEntry.() -> Unit)? = null
}

/** A wrapping multiline text entry widget. */
class WrappingMultilineEntry(block: MultilineEntry.() -> Unit = {}) :
    MultilineEntry(uiNewMultilineEntry()) {
    init { apply(block) }
}

/** A non wrapping multiline text entry widget. */
class NonWrappingMultilineEntry(block: NonWrappingMultilineEntry.() -> Unit = {}) :
    MultilineEntry(uiNewNonWrappingMultilineEntry()) {
    init { apply(block) }
}

/** The current text of the multiline entry. */
var MultilineEntry.text: String
    get() = uiMultilineEntryText(ptr)?.toKString() ?: ""
    set(text) = uiMultilineEntrySetText(ptr, text)

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
    uiMultilineEntryOnChanged(ptr, staticCFunction(::_onMultilineEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onMultilineEntry(ptr: CPointer<uiMultilineEntry>?, ref: COpaquePointer?) {
    ref!!.asStableRef<MultilineEntry>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
class Checkbox(text: String, block: Checkbox.() -> Unit = {}) : Control(uiNewCheckbox(text)) {
    internal val ptr: CPointer<uiCheckbox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Checkbox.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the checkbox. */
var Checkbox.text: String
    get() = uiCheckboxText(ptr)?.toKString() ?: ""
    set(text) = uiCheckboxSetText(ptr, text)

/** Whether the checkbox is checked or unchecked. Defaults to `false`. */
var Checkbox.checked: Boolean
    get() = uiCheckboxChecked(ptr) != 0
    set(checked) = uiCheckboxSetChecked(ptr, if (checked) 1 else 0)

/** Funcion to be run when the user clicks the Checkbox.
 *  Only one function can be registered at a time. */
fun Checkbox.action(proc: Checkbox.() -> Unit) {
    action = proc
    uiCheckboxOnToggled(ptr, staticCFunction(::_onCheckbox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onCheckbox(ptr: CPointer<uiCheckbox>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Checkbox>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
class Combobox(block: Combobox.() -> Unit = {}) : Control(uiNewCombobox()) {
    internal val ptr: CPointer<uiCombobox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (Combobox.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current choosed option by index. */
var Combobox.selected: Int
    get() = uiComboboxSelected(ptr)
    set(value) = uiComboboxSetSelected(ptr, value)

/** Adds the named entry to the end of the combobox.
 *  If it is the first entry, it is automatically selected. */
fun Combobox.append(text: String) = uiComboboxAppend(ptr, text)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(proc: Combobox.() -> Unit) {
    action = proc
    uiComboboxOnSelected(ptr, staticCFunction(::_onCombobox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onCombobox(ptr: CPointer<uiCombobox>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Combobox>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
class EditableCombobox(block: EditableCombobox.() -> Unit = {}) : Control(uiNewEditableCombobox()) {
    internal val ptr: CPointer<uiEditableCombobox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (EditableCombobox.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.text: String
    get() = uiEditableComboboxText(ptr)?.toKString() ?: ""
    set(text) = uiEditableComboboxSetText(ptr, text)

/** Adds the named entry to the end of the editable combobox.
 *  If it is the first entry, it is automatically selected. */
fun EditableCombobox.append(text: String) = uiEditableComboboxAppend(ptr, text)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
    action = proc
    uiEditableComboboxOnChanged(ptr, staticCFunction(::_onEditableCombobox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onEditableCombobox(ptr: CPointer<uiEditableCombobox>?, ref: COpaquePointer?) {
    ref!!.asStableRef<EditableCombobox>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
class Spinbox(min: Int, max: Int, block: Spinbox.() -> Unit = {}) : Control(uiNewSpinbox(min, max)) {
    internal val ptr: CPointer<uiSpinbox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
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
    uiSpinboxOnChanged(ptr, staticCFunction(::_onSpinbox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onSpinbox(ptr: CPointer<uiSpinbox>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Spinbox>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
class Slider(min: Int, max: Int, block: Slider.() -> Unit = {}) : Control(uiNewSlider(min, max)) {
    internal val ptr: CPointer<uiSlider> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
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
    uiSliderOnChanged(ptr, staticCFunction(::_onSlider), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onSlider(ptr: CPointer<uiSlider>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Slider>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
class RadioButtons(block: RadioButtons.() -> Unit = {}) : Control(uiNewRadioButtons()) {
    internal val ptr: CPointer<uiRadioButtons> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (RadioButtons.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current choosed option by index. */
var RadioButtons.selected: Int
    get() = uiRadioButtonsSelected(ptr)
    set(value) = uiRadioButtonsSetSelected(ptr, value)

/** Adds the named button to the end of the radiobuttons.
 *  If it is the first button, it is automatically selected. */
fun RadioButtons.append(text: String) = uiRadioButtonsAppend(ptr, text)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
    action = proc
    uiRadioButtonsOnSelected(ptr, staticCFunction(::_onRadioButtons), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onRadioButtons(ptr: CPointer<uiRadioButtons>?, ref: COpaquePointer?) {
    ref!!.asStableRef<RadioButtons>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit date and time. */
abstract class TmPicker(_ptr: CPointer<uiDateTimePicker>?) : Control(_ptr) {
    internal val ptr: CPointer<uiDateTimePicker> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (TmPicker.() -> Unit)? = null
}

/** A widgets to edit date and time. */
class DateTimePicker(block: DateTimePicker.() -> Unit = {}) : TmPicker(uiNewDateTimePicker()) {
    init { apply(block) }
}

/** A widgets to edit date. */
class DatePicker(block: DatePicker.() -> Unit = {}) : TmPicker(uiNewDatePicker()) {
    init { apply(block) }
}

/** A widgets to edit time. */
class TimePicker(block: TimePicker.() -> Unit = {}) : TmPicker(uiNewTimePicker()) {
    init { apply(block) }
}

/** The current value as Unix epoch */
var TmPicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>().ptr
       uiDateTimePickerTime(ptr, tm)
       mktime(tm)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       uiDateTimePickerSetTime(ptr, localtime(time.ptr))
    }

/** The current value as String. */
fun TmPicker.text(format: String): String = memScoped {
    var tm = alloc<tm>().ptr
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(ptr, tm)
    strftime(buf, 64, format, tm)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the Picker.
 *  Only one function can be registered at a time. */
fun TmPicker.action(proc: TmPicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(ptr, staticCFunction(::_onDateTimePicker), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onDateTimePicker(ptr: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    ref!!.asStableRef<TmPicker>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
class Label(text: String, block: Label.() -> Unit = {}) : Control(uiNewLabel(text)) {
    internal val ptr: CPointer<uiLabel> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** The static text of the label. */
var Label.text: String
    get() = uiLabelText(ptr)?.toKString() ?: ""
    set(text) = uiLabelSetText(ptr, text)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
abstract class Separator(_ptr: CPointer<uiSeparator>?) : Control(_ptr) {
    internal val ptr: CPointer<uiSeparator> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
}

/** An horizontal line to visually separate widgets. */
class HorizontalSeparator(block: HorizontalSeparator.() -> Unit = {}) : Separator(uiNewHorizontalSeparator()) {
    init { apply(block) }
}

/** A vertical line to visually separate widgets. */
class VerticalSeparator(block: VerticalSeparator.() -> Unit = {}) : Separator(uiNewVerticalSeparator()) {
    init { apply(block) }
}

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
class ProgressBar(block: ProgressBar.() -> Unit = {}) : Control(uiNewProgressBar()) {
    internal val ptr: CPointer<uiProgressBar> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(ptr)
    set(value) = uiProgressBarSetValue(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
class Button(text: String, block: Button.() -> Unit = {}) : Control(uiNewButton(text)) {
    internal val ptr: CPointer<uiButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
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
    uiButtonOnClicked(ptr, staticCFunction(::_onButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onButton(ptr: CPointer<uiButton>?, ref: COpaquePointer?) {
    ref!!.asStableRef<Button>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton(block: ColorButton.() -> Unit = {}) : Control(uiNewColorButton()) {
    internal val ptr: CPointer<uiColorButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (ColorButton.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the currently selected color */
var ColorButton.color: RGBA
    get() = memScoped {
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiColorButtonColor(ptr, r.ptr, g.ptr, b.ptr, a.ptr)
        RGBA(r.value, g.value, b.value, a.value)
    }
    set(color) {
        uiColorButtonSetColor(ptr, color.R, color.G, color.B, color.A)
    }

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(proc: ColorButton.() -> Unit) {
    action = proc
    uiColorButtonOnChanged(ptr, staticCFunction(::_onColorButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onColorButton(ptr: CPointer<uiColorButton>?, ref: COpaquePointer?) {
    ref!!.asStableRef<ColorButton>().get().apply { action?.invoke(this) }
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton(block: FontButton.() -> Unit = {}) : Control(uiNewFontButton()) {
    internal val ptr: CPointer<uiFontButton> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var action: (FontButton.() -> Unit)? = null
    init { apply(block) }
}

/** Returns the font currently selected in the uiFontButton in desc.
 *  allocates resources in desc when you are done with the font, call uiFreeFontButtonFont() to release them.
 *  does not allocate desc itself you must do so. */
fun FontButton.getFont(desc: FontDescriptor) = uiFontButtonFont(ptr, desc)

/** Frees resources allocated in desc by uiFontButtonFont().
 *  After calling uiFreeFontButtonFont(), the contents of desc should be assumed to be undefined
 *  (though since you allocate desc itself, you can safely reuse desc for other font descriptors).
 *  Calling uiFreeFontButtonFont() on a uiFontDescriptor not returned by uiFontButtonFont()
 * results in undefined behavior. */
fun FontDescriptor.destroy() = uiFreeFontButtonFont(this)

/** Funcion to be run when the font in the FontButton is changed.
 *  Only one function can be registered at a time. */
fun FontButton.action(proc: FontButton.() -> Unit) {
    action = proc
    uiFontButtonOnChanged(ptr, staticCFunction(::_onFontButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onFontButton(ptr: CPointer<uiFontButton>?, ref: COpaquePointer?) {
    ref!!.asStableRef<ColorButton>().get().apply { action?.invoke(this) }
}
