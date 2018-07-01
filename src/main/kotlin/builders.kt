package libui

import kotlinx.cinterop.*

///////////////////////////////////////////////////////////////////////////////

inline fun Group.textfield(
    init: TextField.() -> Unit = {}
) = add(TextField().apply(init))

inline fun Group.passwordfield(
    init: PasswordField.() -> Unit = {}
) = add(PasswordField().apply(init))

inline fun Group.searchfield(
    init: SearchField.() -> Unit = {}
) = add(SearchField().apply(init))

inline fun Group.textarea(
    wrap: Boolean = true,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap).apply(init))

inline fun Group.checkbox(
    label: String,
    init: Checkbox.() -> Unit = {}
) = add(Checkbox(label).apply(init))

inline fun Group.combobox(
    init: Combobox.() -> Unit = {}
) = add(Combobox().apply(init))

inline fun Group.editablecombobox(
    init: EditableCombobox.() -> Unit = {}
) = add(EditableCombobox().apply(init))

inline fun Group.spinbox(
    min: Int,
    max: Int,
    init: Spinbox.() -> Unit = {}
) = add(Spinbox(min, max).apply(init))

inline fun Group.slider(
    min: Int,
    max: Int,
    init: Slider.() -> Unit = {}
) = add(Slider(min, max).apply(init))

inline fun Group.radiobuttons(
    init: RadioButtons.() -> Unit = {}
) = add(RadioButtons().apply(init))

inline fun Group.datetimepicker(
    init: DateTimePicker.() -> Unit = {}
) = add(DateTimePicker().apply(init))

inline fun Group.datepicker(
    init: DatePicker.() -> Unit = {}
) = add(DatePicker().apply(init))

inline fun Group.timepicker(
    init: TimePicker.() -> Unit = {}
) = add(TimePicker().apply(init))

inline fun Group.label(
    text: String,
    init: Label.() -> Unit = {}
) = add(Label(text).apply(init))

inline fun Group.progressbar(
    init: ProgressBar.() -> Unit = {}
) = add(ProgressBar().apply(init))

inline fun Group.button(
    text: String,
    init: Button.() -> Unit = {}
) = add(Button(text).apply(init))

inline fun Group.colorbutton(
    init: ColorButton.() -> Unit = {}
) = add(ColorButton().apply(init))

inline fun Group.fontbutton(
    init: FontButton.() -> Unit = {}
) = add(FontButton().apply(init))

inline fun Group.hbox(
    init: HorizontalBox.() -> Unit = {}
) = add(HorizontalBox().apply(init))

inline fun Group.vbox(
    init: VerticalBox.() -> Unit = {}
) = add(VerticalBox().apply(init))

inline fun Group.form(
    init: Form.() -> Unit = {}
) = add(Form().apply(init))

///////////////////////////////////////////////////////////////////////////////

inline fun Box.textfield(
    stretchy: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(TextField().apply(init), stretchy)

inline fun Box.passwordfield(
    stretchy: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(PasswordField().apply(init), stretchy)

inline fun Box.searchfield(
    stretchy: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(SearchField().apply(init), stretchy)

inline fun Box.textarea(
    wrap: Boolean = true,
    stretchy: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap).apply(init), stretchy)

inline fun Box.checkbox(
    label: String,
    stretchy: Boolean = false,
    init: Checkbox.() -> Unit = {}
) = add(Checkbox(label).apply(init), stretchy)

inline fun Box.combobox(
    stretchy: Boolean = false,
    init: Combobox.() -> Unit = {}
) = add(Combobox().apply(init), stretchy)

inline fun Box.editablecombobox(
    stretchy: Boolean = false,
    init: EditableCombobox.() -> Unit = {}
) = add(EditableCombobox().apply(init), stretchy)

inline fun Box.spinbox(
    min: Int,
    max: Int,
    stretchy: Boolean = false,
    init: Spinbox.() -> Unit = {}
) = add(Spinbox(min, max).apply(init), stretchy)

inline fun Box.slider(
    min: Int,
    max: Int,
    stretchy: Boolean = false,
    init: Slider.() -> Unit = {}
) = add(Slider(min, max).apply(init), stretchy)

inline fun Box.radiobuttons(
    stretchy: Boolean = false,
    init: RadioButtons.() -> Unit = {}
) = add(RadioButtons().apply(init), stretchy)

inline fun Box.datetimepicker(
    stretchy: Boolean = false,
    init: DateTimePicker.() -> Unit = {}
) = add(DateTimePicker().apply(init), stretchy)

inline fun Box.datepicker(
    stretchy: Boolean = false,
    init: DatePicker.() -> Unit = {}
) = add(DatePicker().apply(init), stretchy)

inline fun Box.timepicker(
    stretchy: Boolean = false,
    init: TimePicker.() -> Unit = {}
) = add(TimePicker().apply(init), stretchy)

inline fun Box.label(
    text: String,
    stretchy: Boolean = false,
    init: Label.() -> Unit = {}
) = add(Label(text).apply(init), stretchy)

inline fun HorizontalBox.separator(
    stretchy: Boolean = false,
    init: VerticalSeparator.() -> Unit = {}
) = add(VerticalSeparator().apply(init), stretchy)

inline fun VerticalBox.separator(
    stretchy: Boolean = false,
    init: HorizontalSeparator.() -> Unit = {}
) = add(HorizontalSeparator().apply(init), stretchy)

inline fun Box.progressbar(
    stretchy: Boolean = false,
    init: ProgressBar.() -> Unit = {}
) = add(ProgressBar().apply(init), stretchy)

inline fun Box.button(
    text: String,
    stretchy: Boolean = false,
    init: Button.() -> Unit = {}
) = add(Button(text).apply(init), stretchy)

inline fun Box.colorbutton(
    stretchy: Boolean = false,
    init: ColorButton.() -> Unit = {}
) = add(ColorButton().apply(init), stretchy)

inline fun Box.fontbutton(
    stretchy: Boolean = false,
    init: FontButton.() -> Unit = {}
) = add(FontButton().apply(init), stretchy)

inline fun Box.group(
    title: String,
    margined: Boolean = true,
    stretchy: Boolean = false,
    init: Group.() -> Unit = {}
) = add(Group(title, margined).apply(init), stretchy)

inline fun HorizontalBox.vbox(
    stretchy: Boolean = false,
    init: VerticalBox.() -> Unit = {}
) = add(VerticalBox().apply(init), stretchy)

inline fun VerticalBox.hbox(
    stretchy: Boolean = false,
    init: HorizontalBox.() -> Unit = {}
) = add(HorizontalBox().apply(init), stretchy)

inline fun Box.form(
    stretchy: Boolean = false,
    init: Form.() -> Unit = {}
) = add(Form().apply(init), stretchy)

///////////////////////////////////////////////////////////////////////////////

inline fun Form.textfield(
    label: String,
    stretchy: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(label, TextField().apply(init), stretchy)

inline fun Form.passwordfield(
    label: String,
    stretchy: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(label, PasswordField().apply(init), stretchy)

inline fun Form.searchfield(
    label: String,
    stretchy: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(label, SearchField().apply(init), stretchy)

inline fun Form.textarea(
    label: String,
    wrap: Boolean = true,
    stretchy: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(label, TextArea(wrap).apply(init), stretchy)
