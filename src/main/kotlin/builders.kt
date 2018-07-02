package libui

import kotlinx.cinterop.*

/** Container for child controls. */
interface Container {
    fun <T : Control<*>> add(widget: T): T
}

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

inline fun Container.drawarea(
    init: DrawArea.() -> Unit = {}
) = add(DrawArea().apply(init))

inline fun Container.scrollingarea(
    width: Int,
    height: Int,
    init: ScrollingArea.() -> Unit = {}
) = add(ScrollingArea(width, height).apply(init))

inline fun Container.hbox(
    padded: Boolean = true,
    init: HBox.() -> Unit = {}
) = add(HBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Container.vbox(
    padded: Boolean = true,
    init: VBox.() -> Unit = {}
) = add(VBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Container.form(
    padded: Boolean = true,
    init: Form.() -> Unit = {}
) = add(Form()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Container.tabpane(
    init: TabPane.() -> Unit = {}
) = add(TabPane().apply(init))

inline fun Container.gridpane(
    padded: Boolean = true,
    init: GridPane.() -> Unit = {}
) = add(GridPane()
        .apply { if (padded) this.padded = padded }
        .apply(init))

///////////////////////////////////////////////////////////////////////////////

/** Container for child controls that can stretch when container size change. */
interface Stretchy {
    fun <T : Control<*>> add(widget: T, stretchy: Boolean = false): T
}

/** Container that can stretch horizontally. */
interface StretchyHorizontal : Stretchy

/** Container that can stretch vertically. */
interface StretchyVertical : Stretchy

inline fun Stretchy.textfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(TextField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Stretchy.passwordfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(PasswordField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Stretchy.searchfield(
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(SearchField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Stretchy.textarea(
    wrap: Boolean = true,
    readonly: Boolean = false,
    stretchy: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap)
        .apply { if (readonly) this.readonly = readonly }
        .apply(init), stretchy)

inline fun Stretchy.checkbox(
    label: String,
    stretchy: Boolean = false,
    init: Checkbox.() -> Unit = {}
) = add(Checkbox(label).apply(init), stretchy)

inline fun Stretchy.combobox(
    stretchy: Boolean = false,
    init: Combobox.() -> Unit = {}
) = add(Combobox().apply(init), stretchy)

inline fun Stretchy.editablecombobox(
    stretchy: Boolean = false,
    init: EditableCombobox.() -> Unit = {}
) = add(EditableCombobox().apply(init), stretchy)

inline fun Stretchy.spinbox(
    min: Int,
    max: Int,
    stretchy: Boolean = false,
    init: Spinbox.() -> Unit = {}
) = add(Spinbox(min, max).apply(init), stretchy)

inline fun Stretchy.slider(
    min: Int,
    max: Int,
    stretchy: Boolean = false,
    init: Slider.() -> Unit = {}
) = add(Slider(min, max).apply(init), stretchy)

inline fun Stretchy.radiobuttons(
    stretchy: Boolean = false,
    init: RadioButtons.() -> Unit = {}
) = add(RadioButtons().apply(init), stretchy)

inline fun Stretchy.datetimepicker(
    stretchy: Boolean = false,
    init: DateTimePicker.() -> Unit = {}
) = add(DateTimePicker().apply(init), stretchy)

inline fun Stretchy.datepicker(
    stretchy: Boolean = false,
    init: DatePicker.() -> Unit = {}
) = add(DatePicker().apply(init), stretchy)

inline fun Stretchy.timepicker(
    stretchy: Boolean = false,
    init: TimePicker.() -> Unit = {}
) = add(TimePicker().apply(init), stretchy)

inline fun Stretchy.label(
    text: String,
    stretchy: Boolean = false,
    init: Label.() -> Unit = {}
) = add(Label(text).apply(init), stretchy)

inline fun StretchyHorizontal.separator(
    stretchy: Boolean = false,
    init: VerticalSeparator.() -> Unit = {}
) = add(VerticalSeparator().apply(init), stretchy)

inline fun StretchyVertical.separator(
    stretchy: Boolean = false,
    init: HorizontalSeparator.() -> Unit = {}
) = add(HorizontalSeparator().apply(init), stretchy)

inline fun Stretchy.progressbar(
    stretchy: Boolean = false,
    init: ProgressBar.() -> Unit = {}
) = add(ProgressBar().apply(init), stretchy)

inline fun Stretchy.button(
    text: String,
    stretchy: Boolean = false,
    init: Button.() -> Unit = {}
) = add(Button(text).apply(init), stretchy)

inline fun Stretchy.colorbutton(
    stretchy: Boolean = false,
    init: ColorButton.() -> Unit = {}
) = add(ColorButton().apply(init), stretchy)

inline fun Stretchy.fontbutton(
    stretchy: Boolean = false,
    init: FontButton.() -> Unit = {}
) = add(FontButton().apply(init), stretchy)

inline fun Stretchy.drawarea(
    stretchy: Boolean = true,
    init: DrawArea.() -> Unit = {}
) = add(DrawArea().apply(init), stretchy)

inline fun Stretchy.scrollingarea(
    width: Int,
    height: Int,
    stretchy: Boolean = false,
    init: ScrollingArea.() -> Unit = {}
) = add(ScrollingArea(width, height).apply(init), stretchy)

inline fun Stretchy.group(
    title: String,
    margined: Boolean = true,
    stretchy: Boolean = false,
    init: Group.() -> Unit = {}
) = add(Group(title)
        .apply { if (margined) this.margined = margined }
        .apply(init), stretchy)

inline fun Stretchy.vbox(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: VBox.() -> Unit = {}
) = add(VBox()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

inline fun Stretchy.hbox(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: HBox.() -> Unit = {}
) = add(HBox()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

inline fun Stretchy.form(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: Form.() -> Unit = {}
) = add(Form()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

inline fun Stretchy.tabpane(
    stretchy: Boolean = false,
    init: TabPane.() -> Unit = {}
) = add(TabPane().apply(init), stretchy)

inline fun Stretchy.gridpane(
    padded: Boolean = true,
    stretchy: Boolean = false,
    init: GridPane.() -> Unit = {}
) = add(GridPane()
        .apply { if (padded) this.padded = padded }
        .apply(init), stretchy)

///////////////////////////////////////////////////////////////////////////////

inline fun Form.field(
    label: String,
    stretchy: Boolean = false,
    init: Form.Field.() -> Unit = {}
) = Field(label, stretchy).apply(init)

///////////////////////////////////////////////////////////////////////////////

inline fun TabPane.page(
    label: String,
    margined: Boolean = true,
    init: TabPane.Page.() -> Unit = {}
) = Page(label)
        .apply(init)
        .apply { if (margined) this.margined = true }

///////////////////////////////////////////////////////////////////////////////

inline fun GridPane.cell(
    x: Int = 0,
    y: Int = 0,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill,
    init: GridPane.Cell.() -> Unit = {}
) = Cell(x, y, xspan, yspan, hexpand, halign, vexpand, valign)
        .apply(init)
