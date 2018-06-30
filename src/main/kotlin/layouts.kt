package libui

import kotlinx.cinterop.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Group]
// - [HorizontalBox]
// - [VerticalBox]
// - [Form]
// - [Tab]
// - [Grid]
//
///////////////////////////////////////////////////////////////////////////////

/** Represents a Control that contains a container for child controls. */
abstract class Layout<T : CPointed>(alloc: CPointer<T>?) : Control<T>(alloc)

///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(
    title: String,
    margined: Boolean = true
) : Layout<uiGroup>(uiNewGroup(title)) {
    init {
        if (margined) this.margined = margined
    }
}

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

/** Sets the group's child. If child is null, the group will not have a child. */
fun <T : Control<*>?> Group.add(widget: T): T {
    uiGroupSetChild(ptr, widget?.ctl)
    return widget
}

/** DSL builders */
fun Group.textfield(init: TextField.() -> Unit = {}) = add(TextField().apply(init))
fun Group.passwordfield(init: PasswordField.() -> Unit = {}) = add(PasswordField().apply(init))
fun Group.searchfield(init: SearchField.() -> Unit = {}) = add(SearchField().apply(init))
fun Group.multilinefield(init: MultilineField.() -> Unit = {}) = add(MultilineField().apply(init))
fun Group.nowrapmultilinefield(init: NowrapMultilineField.() -> Unit = {}) = add(NowrapMultilineField().apply(init))
fun Group.checkbox(label: String, init: Checkbox.() -> Unit = {}) = add(Checkbox(label).apply(init))
fun Group.combobox(init: Combobox.() -> Unit = {}) = add(Combobox().apply(init))
fun Group.editablecombobox(init: EditableCombobox.() -> Unit = {}) = add(EditableCombobox().apply(init))
fun Group.spinbox(min: Int, max: Int, init: Spinbox.() -> Unit = {}) = add(Spinbox(min, max).apply(init))
fun Group.slider(min: Int, max: Int, init: Slider.() -> Unit = {}) = add(Slider(min, max).apply(init))
fun Group.radiobuttons(init: RadioButtons.() -> Unit = {}) = add(RadioButtons().apply(init))
fun Group.datetimepicker(init: DateTimePicker.() -> Unit = {}) = add(DateTimePicker().apply(init))
fun Group.datepicker(init: DatePicker.() -> Unit = {}) = add(DatePicker().apply(init))
fun Group.timepicker(init: TimePicker.() -> Unit = {}) = add(TimePicker().apply(init))
fun Group.label(text: String, init: Label.() -> Unit = {}) = add(Label(text).apply(init))
fun Group.progressbar(init: ProgressBar.() -> Unit = {}) = add(ProgressBar().apply(init))
fun Group.button(text: String, init: Button.() -> Unit = {}) = add(Button(text).apply(init))
fun Group.colorbutton(init: ColorButton.() -> Unit = {}) = add(ColorButton().apply(init))
fun Group.fontbutton(init: FontButton.() -> Unit = {}) = add(FontButton().apply(init))
fun Group.hbox(init: HorizontalBox.() -> Unit = {}) = add(HorizontalBox().apply(init))
fun Group.vbox(init: VerticalBox.() -> Unit = {}) = add(VerticalBox().apply(init))
fun Group.form(init: Form.() -> Unit = {}) = add(Form().apply(init))

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(alloc: CPointer<uiBox>?) : Layout<uiBox>(alloc)

/** A container that stack its chidren horizontally. */
class HorizontalBox : Box(uiNewHorizontalBox())

/** A container that stack its chidren vertically. */
class VerticalBox : Box(uiNewVerticalBox())

/** If `true`, the container insert some space between children. Defaults to `false`. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the Box. */
fun <T : Control<*>> Box.add(widget: T, stretchy: Boolean = false): T {
    uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)
    return widget
}

/** DSL builders */
fun Box.textfield(stretchy: Boolean = false, init: TextField.() -> Unit = {}) =
    add(TextField().apply(init), stretchy)
fun Box.passwordfield(stretchy: Boolean = false, init: PasswordField.() -> Unit = {}) =
    add(PasswordField().apply(init), stretchy)
fun Box.searchfield(stretchy: Boolean = false, init: SearchField.() -> Unit = {}) =
    add(SearchField().apply(init), stretchy)
fun Box.multilinefield(stretchy: Boolean = false, init: MultilineField.() -> Unit = {}) =
    add(MultilineField().apply(init), stretchy)
fun Box.nowrapmultilinefield(stretchy: Boolean = false, init: NowrapMultilineField.() -> Unit = {}) =
    add(NowrapMultilineField().apply(init), stretchy)
fun Box.checkbox(label: String, stretchy: Boolean = false, init: Checkbox.() -> Unit = {}) =
    add(Checkbox(label).apply(init), stretchy)
fun Box.combobox(stretchy: Boolean = false, init: Combobox.() -> Unit = {}) =
    add(Combobox().apply(init), stretchy)
fun Box.editablecombobox(stretchy: Boolean = false, init: EditableCombobox.() -> Unit = {}) =
    add(EditableCombobox().apply(init), stretchy)
fun Box.spinbox(min: Int, max: Int, stretchy: Boolean = false, init: Spinbox.() -> Unit = {}) =
    add(Spinbox(min, max).apply(init), stretchy)
fun Box.slider(min: Int, max: Int, stretchy: Boolean = false, init: Slider.() -> Unit = {}) =
    add(Slider(min, max).apply(init), stretchy)
fun Box.radiobuttons(stretchy: Boolean = false, init: RadioButtons.() -> Unit = {}) =
    add(RadioButtons().apply(init), stretchy)
fun Box.datetimepicker(stretchy: Boolean = false, init: DateTimePicker.() -> Unit = {}) =
    add(DateTimePicker().apply(init), stretchy)
fun Box.datepicker(stretchy: Boolean = false, init: DatePicker.() -> Unit = {}) =
    add(DatePicker().apply(init), stretchy)
fun Box.timepicker(stretchy: Boolean = false, init: TimePicker.() -> Unit = {}) =
    add(TimePicker().apply(init), stretchy)
fun Box.label(text: String, stretchy: Boolean = false, init: Label.() -> Unit = {}) =
    add(Label(text).apply(init), stretchy)
fun HorizontalBox.separator(stretchy: Boolean = false, init: VerticalSeparator.() -> Unit = {}) =
    add(VerticalSeparator().apply(init), stretchy)
fun VerticalBox.separator(stretchy: Boolean = false, init: HorizontalSeparator.() -> Unit = {}) =
    add(HorizontalSeparator().apply(init), stretchy)
fun Box.progressbar(stretchy: Boolean = false, init: ProgressBar.() -> Unit = {}) =
    add(ProgressBar().apply(init), stretchy)
fun Box.button(text: String, stretchy: Boolean = false, init: Button.() -> Unit = {}) =
    add(Button(text).apply(init), stretchy)
fun Box.colorbutton(stretchy: Boolean = false, init: ColorButton.() -> Unit = {}) =
    add(ColorButton().apply(init), stretchy)
fun Box.fontbutton(stretchy: Boolean = false, init: FontButton.() -> Unit = {}) =
    add(FontButton().apply(init), stretchy)
fun Box.group(title: String, margined: Boolean = true, stretchy: Boolean = false, init: Group.() -> Unit = {}) =
    add(Group(title, margined).apply(init), stretchy)
fun HorizontalBox.vbox(stretchy: Boolean = false, init: VerticalBox.() -> Unit = {}) =
    add(VerticalBox().apply(init), stretchy)
fun VerticalBox.hbox(stretchy: Boolean = false, init: HorizontalBox.() -> Unit = {}) =
    add(HorizontalBox().apply(init), stretchy)
fun Box.form(stretchy: Boolean = false, init: Form.() -> Unit = {}) =
    add(Form().apply(init), stretchy)

/** Deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form : Layout<uiForm>(uiNewForm())

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun <T : Control<*>> Form.add(label: String, widget: T, stretchy: Boolean = false): T {
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)
    return widget
}

fun Form.textfield(label: String, stretchy: Boolean = false, init: TextField.() -> Unit = {}) =
    add(label, TextField().apply(init), stretchy)
fun Form.passwordfield(label: String, stretchy: Boolean = false, init: PasswordField.() -> Unit = {}) =
    add(label, PasswordField().apply(init), stretchy)
fun Form.searchfield(label: String, stretchy: Boolean = false, init: SearchField.() -> Unit = {}) =
    add(label, SearchField().apply(init), stretchy)
fun Form.multilinefield(label: String, stretchy: Boolean = false, init: MultilineField.() -> Unit = {}) =
    add(label, MultilineField().apply(init), stretchy)
fun Form.nowrapmultilinefield(label: String, stretchy: Boolean = false, init: NowrapMultilineField.() -> Unit = {}) =
    add(label, NowrapMultilineField().apply(init), stretchy)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab : Layout<uiTab>(uiNewTab())

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun <T : Control<*>> Tab.add(label: String, widget: T, margined: Boolean = true): T {
    uiTabAppend(ptr, label, widget.ctl)
    if (margined) setMargined(numPages - 1, true)
    return widget
}

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insert(index: Int, name: String, widget: Control<*>) = uiTabInsertAt(ptr, name, index, widget.ctl)

/** Delete deletes the nth page of the Tab. */
fun Tab.delete(index: Int) = uiTabDelete(ptr, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(ptr)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid : Layout<uiGrid>(uiNewGrid())

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the Grid.
 *
 *  @param[widget] The Control to be added.
 *  @param[x] The x-coordinate of the Control's location.
 *  @param[y] The y-coordinate of the Control's location.
 *  @param[xspan] The width of the Control.
 *  @param[yspan] The height of the Control.
 *  @param[hexpand] The horizontal expand of Control.
 *  @param[halign] The horizontal alignment of Control.
 *  @param[vexpand] The vertical expand of Control.
 *  @param[valign] The vertical alignment of Control.
 */
fun <T : Control<*>> Grid.add(
    widget: T,
    x: Int = 0,
    y: Int = 0,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
): T {
    uiGridAppend(ptr, widget.ctl,
        x, y, xspan, yspan,
        if (hexpand) 1 else 0, halign,
        if (vexpand) 1 else 0, valign)
    return widget
}

/** Insert the given Control after existing Control.
 *
 *  @param[widget] The Control to be added.
 *  @param[existing] The existing Control at which Control be inserted.
 *  @param[at] The relative placement of the Control to the existing one.
 *  @param[xspan] The width of the Control.
 *  @param[yspan] The height of the Control.
 *  @param[hexpand] The horizontal expand of Control.
 *  @param[halign] The horizontal alignment of Control.
 *  @param[vexpand] The vertical expand of Control.
 *  @param[valign] The vertical alignment of Control.
 */
fun <T : Control<*>> Grid.insert(
    widget: T,
    existing: Control<*>,
    at: uiAt,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
): T {
    uiGridInsertAt(ptr, widget.ctl, existing.ctl,
    at, xspan, yspan,
    if (hexpand) 1 else 0, halign,
    if (vexpand) 1 else 0, valign)
    return widget
}
