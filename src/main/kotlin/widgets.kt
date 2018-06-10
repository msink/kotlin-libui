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

/** Represents a GUI control (widget). It provdes methods common to all Controls. */
open class Control(internal var _p: COpaquePointer?) {
    fun isDestroyed(): Boolean = _p == null
    internal val c: CPointer<uiControl> get() = _p?.reinterpret() ?: throw Error("Control is destroyed")
    internal val cDestroy = c.pointed.Destroy
    internal val ref = StableRef.create(this)
    init {
        c.pointed.Destroy = staticCFunction(::onDestroy)
        controls[c] = this
    }
}
private var controls = mutableMapOf<CPointer<uiControl>, Control>()
private fun onDestroy(c: CPointer<uiControl>?) {
    val control = controls[c] ?: throw Error("Control is destroyed")
    control.cDestroy?.invoke(c)
    controls.remove(c)
    control.ref.dispose()
    control._p = null
}

/** Destroy and free the Control. */
fun Control.destroy() = uiControlDestroy(c)

/** Returns the OS-level handle associated with this Control. */
fun Control.getHandle(): Long = uiControlHandle(c)

/** Whether the Control is enabled. */
fun Control.isEnabled(): Boolean = uiControlEnabled(c) != 0

/** Enables the Control. */
fun Control.enable() = uiControlEnable(c)

/** Disables the Control. */
fun Control.disable() = uiControlDisable(c)

/** Whether the Control should be enabled or disabled. Defaults to `true`. */
var Control.enabled: Boolean
    get() = isEnabled()
    set(enabled) = if (enabled) enable() else disable()

/** Whether the Control is visible. */
fun Control.isVisible(): Boolean = uiControlVisible(c) != 0

/** Shows the Control. */
fun Control.show() = uiControlShow(c)

/** Hides the Control. Hidden controls do not participate in layout
 *  (that is, Box, Grid, etc. does not reserve space for hidden controls). */
fun Control.hide() = uiControlHide(c)

/** Whether the Control should be visible or hidden. Defaults to `true`. */
var Control.visible: Boolean
    get() = isVisible()
    set(visible) = if (visible) show() else hide()

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form(block: Form.() -> Unit = {}): Control(uiNewForm()) {
    internal val p: CPointer<uiForm> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(p) != 0
    set(padded) = uiFormSetPadded(p, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun Form.append(label: String, widget: Control, stretchy: Boolean = false) =
    uiFormAppend(p, label, widget.c, if (stretchy) 1 else 0)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(p, index)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid(block: Grid.() -> Unit = {}): Control(uiNewGrid()) {
    internal val p: CPointer<uiGrid> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(p) != 0
    set(padded) = uiGridSetPadded(p, if (padded) 1 else 0)

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
    uiGridAppend(p, widget.c, left, top, xspan, yspan, hexpand, halign, vexpand, valign)

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
    uiGridInsertAt(p, widget.c, existing.c, at, xspan, yspan, hexpand, halign, vexpand, valign)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally. */
class HorizontalBox(block: HorizontalBox.() -> Unit = {}): Control(uiNewHorizontalBox()) {
    internal val p: CPointer<uiBox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** If `true`, the container insert some space between children. Defaults to `false`. */
var HorizontalBox.padded: Boolean
    get() = uiBoxPadded(p) != 0
    set(padded) = uiBoxSetPadded(p, if (padded) 1 else 0)

/** Adds the given widget to the end of the HorizontalBox. */
fun HorizontalBox.append(widget: Control, stretchy: Boolean = false) =
    uiBoxAppend(p, widget.c, if (stretchy) 1 else 0)

/** deletes the nth control of the HorizontalBox. */
fun HorizontalBox.delete(index: Int) = uiBoxDelete(p, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren vertically. */
class VerticalBox(block: VerticalBox.() -> Unit = {}): Control(uiNewVerticalBox()) {
    internal val p: CPointer<uiBox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** If `true`, the container insert some space between children. Defaults to `false`. */
var VerticalBox.padded: Boolean
    get() = uiBoxPadded(p) != 0
    set(padded) = uiBoxSetPadded(p, if (padded) 1 else 0)

/** Adds the given widget to the end of the HorizontalBox. */
fun VerticalBox.append(widget: Control, stretchy: Boolean = false) =
    uiBoxAppend(p, widget.c, if (stretchy) 1 else 0)

/** deletes the nth control of the HorizontalBox. */
fun VerticalBox.delete(index: Int) = uiBoxDelete(p, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab(block: Tab.() -> Unit = {}): Control(uiNewTab()) {
    internal val p: CPointer<uiTab> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(p, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(p, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun Tab.append(name: String, widget: Control) = uiTabAppend(p, name, widget.c)

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insertAt(index: Int, name: String, widget: Control) = uiTabInsertAt(p, name, index, widget.c)

/** Delete deletes the nth page of the Tab. */
fun Tab.deleteAt(index: Int) = uiTabDelete(p, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(p)

///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(text: String, block: Group.() -> Unit = {}): Control(uiNewGroup(text)) {
    internal val p: CPointer<uiGroup> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(p)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(p, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(p) != 0
    set(margined) = uiGroupSetMargined(p, if (margined) 1 else 0)

/** sets the group's child. If child is null, the group will not have a child. */
fun Group.setChild(child: Control?) = uiGroupSetChild(p, child?.c)

///////////////////////////////////////////////////////////////////////////////

/** A simple, single line text entry widget. */
class Entry(block: Entry.() -> Unit = {}): Control(uiNewEntry()) {
    internal val p: CPointer<uiEntry> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Entry.() -> Unit)? = null
    init { apply(block) }
}

/** The current text of the Entry. */
var Entry.text: String
    get() = uiEntryText(p)?.toKString() ?: ""
    set(text) = uiEntrySetText(p, text)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var Entry.readOnly: Boolean
    get() = uiEntryReadOnly(p) != 0
    set(readOnly) = uiEntrySetReadOnly(p, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(proc: Entry.() -> Unit) {
    action = proc
    uiEntryOnChanged(p, staticCFunction(::_onEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onEntry(p: CPointer<uiEntry>?, ref: COpaquePointer?) {
    val entry = ref!!.asStableRef<Entry>().get()
    entry.action?.invoke(entry)
}

///////////////////////////////////////////////////////////////////////////////

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
class PasswordEntry(block: PasswordEntry.() -> Unit = {}): Control(uiNewPasswordEntry()) {
    internal val p: CPointer<uiEntry> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (PasswordEntry.() -> Unit)? = null
    init { apply(block) }
}

/** The current text of the PasswordEntry. */
var PasswordEntry.text: String
    get() = uiEntryText(p)?.toKString() ?: ""
    set(text) = uiEntrySetText(p, text)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var PasswordEntry.readOnly: Boolean
    get() = uiEntryReadOnly(p) != 0
    set(readOnly) = uiEntrySetReadOnly(p, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun PasswordEntry.action(proc: PasswordEntry.() -> Unit) {
    action = proc
    uiEntryOnChanged(p, staticCFunction(::_onPasswordEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onPasswordEntry(p: CPointer<uiEntry>?, ref: COpaquePointer?) {
    val entry = ref!!.asStableRef<PasswordEntry>().get()
    entry.action?.invoke(entry)
}

///////////////////////////////////////////////////////////////////////////////

/** Text entry to search text. */
class SearchEntry(block: SearchEntry.() -> Unit = {}): Control(uiNewSearchEntry()) {
    internal val p: CPointer<uiEntry> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (SearchEntry.() -> Unit)? = null
    init { apply(block) }
}

/** The current text of the Entry. */
var SearchEntry.text: String
    get() = uiEntryText(p)?.toKString() ?: ""
    set(text) = uiEntrySetText(p, text)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var SearchEntry.readOnly: Boolean
    get() = uiEntryReadOnly(p) != 0
    set(readOnly) = uiEntrySetReadOnly(p, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun SearchEntry.action(proc: SearchEntry.() -> Unit) {
    action = proc
    uiEntryOnChanged(p, staticCFunction(::_onSearchEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onSearchEntry(p: CPointer<uiEntry>?, ref: COpaquePointer?) {
    val entry = ref!!.asStableRef<SearchEntry>().get()
    entry.action?.invoke(entry)
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
class MultilineEntry(block: MultilineEntry.() -> Unit = {}): Control(uiNewMultilineEntry()) {
    internal val p: CPointer<uiMultilineEntry> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (MultilineEntry.() -> Unit)? = null
    init { apply(block) }
}

/** The current text of the multiline entry. */
var MultilineEntry.text: String
    get() = uiMultilineEntryText(p)?.toKString() ?: ""
    set(text) = uiMultilineEntrySetText(p, text)

/** Whether the user is allowed to change the entry text. */
var MultilineEntry.readOnly: Boolean
    get() = uiMultilineEntryReadOnly(p) != 0
    set(readOnly) = uiMultilineEntrySetReadOnly(p, if (readOnly) 1 else 0)

/** Adds the text to the end of the multiline entry. */
fun MultilineEntry.append(text: String) = uiMultilineEntryAppend(p, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun MultilineEntry.action(proc: MultilineEntry.() -> Unit) {
    action = proc
    uiMultilineEntryOnChanged(p, staticCFunction(::_onMultilineEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onMultilineEntry(p: CPointer<uiMultilineEntry>?, ref: COpaquePointer?) {
    val entry = ref!!.asStableRef<MultilineEntry>().get()
    entry.action?.invoke(entry)
}

///////////////////////////////////////////////////////////////////////////////

/** A non wrapping multiline text entry widget. */
class NonWrappingMultilineEntry(block: NonWrappingMultilineEntry.() -> Unit = {}):
    Control(uiNewNonWrappingMultilineEntry()) {
    internal val p: CPointer<uiMultilineEntry> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (NonWrappingMultilineEntry.() -> Unit)? = null
    init { apply(block) }
}

/** The current text of the multiline entry. */
var NonWrappingMultilineEntry.text: String
    get() = uiMultilineEntryText(p)?.toKString() ?: ""
    set(text) = uiMultilineEntrySetText(p, text)

/** Whether the user is allowed to change the entry text. */
var NonWrappingMultilineEntry.readOnly: Boolean
    get() = uiMultilineEntryReadOnly(p) != 0
    set(readOnly) = uiMultilineEntrySetReadOnly(p, if (readOnly) 1 else 0)

/** Adds the text to the end of the multiline entry. */
fun NonWrappingMultilineEntry.append(text: String) = uiMultilineEntryAppend(p, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun NonWrappingMultilineEntry.action(proc: NonWrappingMultilineEntry.() -> Unit) {
    action = proc
    uiMultilineEntryOnChanged(p, staticCFunction(::_onNonWrappingMultilineEntry), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onNonWrappingMultilineEntry(p: CPointer<uiMultilineEntry>?, ref: COpaquePointer?) {
    val entry = ref!!.asStableRef<NonWrappingMultilineEntry>().get()
    entry.action?.invoke(entry)
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
class Checkbox(text: String, block: Checkbox.() -> Unit = {}): Control(uiNewCheckbox(text)) {
    internal val p: CPointer<uiCheckbox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Checkbox.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the checkbox. */
var Checkbox.text: String
    get() = uiCheckboxText(p)?.toKString() ?: ""
    set(text) = uiCheckboxSetText(p, text)

/** Whether the checkbox is checked or unchecked. Defaults to `false`. */
var Checkbox.checked: Boolean
    get() = uiCheckboxChecked(p) != 0
    set(checked) = uiCheckboxSetChecked(p, if (checked) 1 else 0)

/** Funcion to be run when the user clicks the Checkbox.
 *  Only one function can be registered at a time. */
fun Checkbox.action(proc: Checkbox.() -> Unit) {
    action = proc
    uiCheckboxOnToggled(p, staticCFunction(::_onCheckbox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onCheckbox(p: CPointer<uiCheckbox>?, ref: COpaquePointer?) {
    val checkbox = ref!!.asStableRef<Checkbox>().get()
    checkbox.action?.invoke(checkbox)
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
class Combobox(block: Combobox.() -> Unit = {}): Control(uiNewCombobox()) {
    internal val p: CPointer<uiCombobox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Combobox.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current choosed option by index. */
var Combobox.selected: Int
    get() = uiComboboxSelected(p)
    set(value) = uiComboboxSetSelected(p, value)

/** Adds the named entry to the end of the combobox.
 *  If it is the first entry, it is automatically selected. */
fun Combobox.append(text: String) = uiComboboxAppend(p, text)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(proc: Combobox.() -> Unit) {
    action = proc
    uiComboboxOnSelected(p, staticCFunction(::_onCombobox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onCombobox(p: CPointer<uiCombobox>?, ref: COpaquePointer?) {
    val combobox = ref!!.asStableRef<Combobox>().get()
    combobox.action?.invoke(combobox)
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
class EditableCombobox(block: EditableCombobox.() -> Unit = {}): Control(uiNewEditableCombobox()) {
    internal val p: CPointer<uiEditableCombobox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (EditableCombobox.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.text: String
    get() = uiEditableComboboxText(p)?.toKString() ?: ""
    set(text) = uiEditableComboboxSetText(p, text)

/** Adds the named entry to the end of the editable combobox.
 *  If it is the first entry, it is automatically selected. */
fun EditableCombobox.append(text: String) = uiEditableComboboxAppend(p, text)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
    action = proc
    uiEditableComboboxOnChanged(p, staticCFunction(::_onEditableCombobox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onEditableCombobox(p: CPointer<uiEditableCombobox>?, ref: COpaquePointer?) {
    val combobox = ref!!.asStableRef<EditableCombobox>().get()
    combobox.action?.invoke(combobox)
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
class Spinbox(min: Int, max: Int, block: Spinbox.() -> Unit = {}): Control(uiNewSpinbox(min, max)) {
    internal val p: CPointer<uiSpinbox> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Spinbox.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the spinbox. */
var Spinbox.value: Int
    get() = uiSpinboxValue(p)
    set(value) = uiSpinboxSetValue(p, value)

/** Funcion to be run when the user makes a change to the Spinbox.
 *  Only one function can be registered at a time. */
fun Spinbox.action(proc: Spinbox.() -> Unit) {
    action = proc
    uiSpinboxOnChanged(p, staticCFunction(::_onSpinbox), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onSpinbox(p: CPointer<uiSpinbox>?, ref: COpaquePointer?) {
    val spinbox = ref!!.asStableRef<Spinbox>().get()
    spinbox.action?.invoke(spinbox)
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
class Slider(min: Int, max: Int, block: Slider.() -> Unit = {}): Control(uiNewSlider(min, max)) {
    internal val p: CPointer<uiSlider> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Slider.() -> Unit)? = null
    init { apply(block) }
}

/** The current numeric value of the slider. */
var Slider.value: Int
    get() = uiSliderValue(p)
    set(value) = uiSliderSetValue(p, value)

/** Funcion to be run when the user makes a change to the Slider.
 *  Only one function can be registered at a time. */
fun Slider.action(proc: Slider.() -> Unit) {
    action = proc
    uiSliderOnChanged(p, staticCFunction(::_onSlider), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onSlider(p: CPointer<uiSlider>?, ref: COpaquePointer?) {
    val slider = ref!!.asStableRef<Slider>().get()
    slider.action?.invoke(slider)
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
class RadioButtons(block: RadioButtons.() -> Unit = {}): Control(uiNewRadioButtons()) {
    internal val p: CPointer<uiRadioButtons> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (RadioButtons.() -> Unit)? = null
    init { apply(block) }
}

/** Return or set the current choosed option by index. */
var RadioButtons.selected: Int
    get() = uiRadioButtonsSelected(p)
    set(value) = uiRadioButtonsSetSelected(p, value)

/** Adds the named button to the end of the radiobuttons.
 *  If it is the first button, it is automatically selected. */
fun RadioButtons.append(text: String) = uiRadioButtonsAppend(p, text)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
    action = proc
    uiRadioButtonsOnSelected(p, staticCFunction(::_onRadioButtons), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onRadioButtons(p: CPointer<uiRadioButtons>?, ref: COpaquePointer?) {
    val radio = ref!!.asStableRef<RadioButtons>().get()
    radio.action?.invoke(radio)
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit date and time. */
class DateTimePicker(block: DateTimePicker.() -> Unit = {}): Control(uiNewDateTimePicker()) {
    internal val p: CPointer<uiDateTimePicker> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (DateTimePicker.() -> Unit)? = null
    init { apply(block) }
}

/** The current value as Unix epoch */
var DateTimePicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>().ptr
       uiDateTimePickerTime(p, tm)
       mktime(tm)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       uiDateTimePickerSetTime(p, localtime(time.ptr))
    }

/** The current value as String. */
fun DateTimePicker.text(format: String): String = memScoped {
    var tm = alloc<tm>().ptr
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(p, tm)
    strftime(buf, 64, format, tm)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the DateTimePicker.
 *  Only one function can be registered at a time. */
fun DateTimePicker.action(proc: DateTimePicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(p, staticCFunction(::_onDateTimePicker), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onDateTimePicker(p: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    val time = ref!!.asStableRef<DateTimePicker>().get()
    time.action?.invoke(time)
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit date. */
class DatePicker(block: DatePicker.() -> Unit = {}): Control(uiNewDatePicker()) {
    internal val p: CPointer<uiDateTimePicker> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (DatePicker.() -> Unit)? = null
    init { apply(block) }
}

/** The current value as Unix epoch */
var DatePicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>().ptr
       uiDateTimePickerTime(p, tm)
       mktime(tm)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       uiDateTimePickerSetTime(p, localtime(time.ptr))
    }

/** The current value as String. */
fun DatePicker.text(format: String): String = memScoped {
    var tm = alloc<tm>().ptr
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(p, tm)
    strftime(buf, 64, format, tm)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the DateTimePicker.
 *  Only one function can be registered at a time. */
fun DatePicker.action(proc: DatePicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(p, staticCFunction(::_onDatePicker), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onDatePicker(p: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    val time = ref!!.asStableRef<DatePicker>().get()
    time.action?.invoke(time)
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit time. */
class TimePicker(block: TimePicker.() -> Unit = {}): Control(uiNewTimePicker()) {
    internal val p: CPointer<uiDateTimePicker> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (TimePicker.() -> Unit)? = null
    init { apply(block) }
}

/** The current value as Unix epoch */
var TimePicker.value: Long
    get() = memScoped {
       var tm = alloc<tm>().ptr
       uiDateTimePickerTime(p, tm)
       mktime(tm)
    }
    set(value) = memScoped {
       var time = alloc<time_tVar>()
       time.value = value
       uiDateTimePickerSetTime(p, localtime(time.ptr))
    }

/** The current value as String. */
fun TimePicker.text(format: String): String = memScoped {
    var tm = alloc<tm>().ptr
    var buf = allocArray<ByteVar>(64)
    uiDateTimePickerTime(p, tm)
    strftime(buf, 64, format, tm)
    return buf.toKString()
}

/** Funcion to be run when the user makes a change to the DateTimePicker.
 *  Only one function can be registered at a time. */
fun TimePicker.action(proc: TimePicker.() -> Unit) {
    action = proc
    uiDateTimePickerOnChanged(p, staticCFunction(::_onTimePicker), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onTimePicker(p: CPointer<uiDateTimePicker>?, ref: COpaquePointer?) {
    val time = ref!!.asStableRef<TimePicker>().get()
    time.action?.invoke(time)
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
class Label(text: String, block: Label.() -> Unit = {}): Control(uiNewLabel(text)) {
    internal val p: CPointer<uiLabel> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** The static text of the label. */
var Label.text: String
    get() = uiLabelText(p)?.toKString() ?: ""
    set(text) = uiLabelSetText(p, text)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
class HorizontalSeparator(block: HorizontalSeparator.() -> Unit = {}): Control(uiNewHorizontalSeparator()) {
    internal val p: CPointer<uiSeparator> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
class VerticalSeparator(block: VerticalSeparator.() -> Unit = {}): Control(uiNewVerticalSeparator()) {
    internal val p: CPointer<uiSeparator> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
class ProgressBar(block: ProgressBar.() -> Unit = {}): Control(uiNewProgressBar()) {
    internal val p: CPointer<uiProgressBar> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    init { apply(block) }
}

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(p)
    set(value) = uiProgressBarSetValue(p, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
class Button(text: String, block: Button.() -> Unit = {}): Control(uiNewButton(text)) {
    internal val p: CPointer<uiButton> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (Button.() -> Unit)? = null
    init { apply(block) }
}

/** The static text of the button. */
var Button.text: String
    get() = uiButtonText(p)?.toKString() ?: ""
    set(text) = uiButtonSetText(p, text)

/** Funcion to be run when the user clicks the Button.
 *  Only one function can be registered at a time. */
fun Button.action(proc: Button.() -> Unit) {
    action = proc
    uiButtonOnClicked(p, staticCFunction(::_onButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onButton(p: CPointer<uiButton>?, ref: COpaquePointer?) {
    val button = ref!!.asStableRef<Button>().get()
    button.action?.invoke(button)
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton(block: ColorButton.() -> Unit = {}): Control(uiNewColorButton()) {
    internal val p: CPointer<uiColorButton> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
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
        uiColorButtonColor(p, r.ptr, g.ptr, b.ptr, a.ptr)
        RGBA(r.value, g.value, b.value, a.value)
    }
    set(color) {
        uiColorButtonSetColor(p, color.R, color.G, color.B, color.A)
    }

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(proc: ColorButton.() -> Unit) {
    action = proc
    uiColorButtonOnChanged(p, staticCFunction(::_onColorButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onColorButton(p: CPointer<uiColorButton>?, ref: COpaquePointer?) {
    val button = ref!!.asStableRef<ColorButton>().get()
    button.action?.invoke(button)
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton(block: FontButton.() -> Unit = {}): Control(uiNewFontButton()) {
    internal val p: CPointer<uiFontButton> get() = _p?.reinterpret() ?: throw Error("Control is disposed")
    internal var action: (FontButton.() -> Unit)? = null
    init { apply(block) }
}

/** Returns the font currently selected in the uiFontButton in desc.
 *  allocates resources in desc when you are done with the font, call uiFreeFontButtonFont() to release them.
 *  does not allocate desc itself you must do so. */
fun FontButton.getFont(desc: FontDescriptor) = uiFontButtonFont(p, desc)

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
    uiFontButtonOnChanged(p, staticCFunction(::_onFontButton), ref.asCPointer())
}
@Suppress("UNUSED_PARAMETER")
private fun _onFontButton(p: CPointer<uiFontButton>?, ref: COpaquePointer?) {
    val button = ref!!.asStableRef<ColorButton>().get()
    button.action?.invoke(button)
}
