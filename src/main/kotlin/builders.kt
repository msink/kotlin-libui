package libui

import kotlinx.cinterop.*

inline fun Container.textfield(
    readonly: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(TextField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

inline fun Container.passwordfield(
    readonly: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(PasswordField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

inline fun Container.searchfield(
    readonly: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(SearchField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

inline fun Container.textarea(
    wrap: Boolean = true,
    readonly: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap)
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

inline fun Container.checkbox(
    label: String,
    init: Checkbox.() -> Unit = {}
) = add(Checkbox(label).apply(init))

inline fun Container.combobox(
    init: Combobox.() -> Unit = {}
) = add(Combobox().apply(init))

inline fun Container.editablecombobox(
    init: EditableCombobox.() -> Unit = {}
) = add(EditableCombobox().apply(init))

inline fun Container.spinbox(
    min: Int,
    max: Int,
    init: Spinbox.() -> Unit = {}
) = add(Spinbox(min, max).apply(init))

inline fun Container.slider(
    min: Int,
    max: Int,
    init: Slider.() -> Unit = {}
) = add(Slider(min, max).apply(init))

inline fun Container.radiobuttons(
    init: RadioButtons.() -> Unit = {}
) = add(RadioButtons().apply(init))

inline fun Container.datetimepicker(
    init: DateTimePicker.() -> Unit = {}
) = add(DateTimePicker().apply(init))

inline fun Container.datepicker(
    init: DatePicker.() -> Unit = {}
) = add(DatePicker().apply(init))

inline fun Container.timepicker(
    init: TimePicker.() -> Unit = {}
) = add(TimePicker().apply(init))

inline fun Container.label(
    text: String,
    init: Label.() -> Unit = {}
) = add(Label(text).apply(init))

inline fun Container.progressbar(
    init: ProgressBar.() -> Unit = {}
) = add(ProgressBar().apply(init))

inline fun Container.button(
    text: String,
    init: Button.() -> Unit = {}
) = add(Button(text).apply(init))

inline fun Container.colorbutton(
    init: ColorButton.() -> Unit = {}
) = add(ColorButton().apply(init))

inline fun Container.fontbutton(
    init: FontButton.() -> Unit = {}
) = add(FontButton().apply(init))

inline fun Container.hbox(
    padded: Boolean = true,
    init: HorizontalBox.() -> Unit = {}
) = add(HorizontalBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Container.vbox(
    padded: Boolean = true,
    init: VerticalBox.() -> Unit = {}
) = add(VerticalBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Container.form(
    padded: Boolean = true,
    init: Form.() -> Unit = {}
) = add(Form()
        .apply { if (padded) this.padded = padded }
        .apply(init))

///////////////////////////////////////////////////////////////////////////////

inline fun Box.textfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(TextField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Box.passwordfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(PasswordField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Box.searchfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(SearchField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Box.textarea(
    wrap: Boolean = true,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap)
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

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
) = add(Group(title)
        .apply { if (margined) this.margined = margined }
        .apply(init), stretchy)

inline fun HorizontalBox.vbox(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: VerticalBox.() -> Unit = {}
) = add(VerticalBox()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

inline fun VerticalBox.hbox(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: HorizontalBox.() -> Unit = {}
) = add(HorizontalBox()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

inline fun Box.form(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: Form.() -> Unit = {}
) = add(Form()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

///////////////////////////////////////////////////////////////////////////////

inline fun Form.textfield(
    label: String,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(label, TextField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Form.passwordfield(
    label: String,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(label, PasswordField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Form.searchfield(
    label: String,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(label, SearchField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Form.textarea(
    label: String,
    wrap: Boolean = true,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(label, TextArea(wrap)
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)
