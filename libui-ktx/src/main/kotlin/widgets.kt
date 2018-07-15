package libui

import kotlinx.cinterop.*
import platform.posix.*

///////////////////////////////////////////////////////////////////////////////
//
// Data entry widgets:
// - [textfield]
// - [passwordfield]
// - [searchfield]
// - [textarea]
// - [checkbox]
// - [combobox]
// - [editablecombobox]
// - [spinbox]
// - [slider]
// - [radiobuttons]
// - [datepicker]
// - [timepicker]
// - [datetimepicker]
//
// Static widgets:
// - [label]
// - [separator]
// - [progressbar]
//
// Buttons:
// - [button]
// - [colorbutton]
// - [fontbutton]
//
///////////////////////////////////////////////////////////////////////////////

/** A simple single line text entry widget. */
inline fun Container.textfield(
    readonly: Boolean = false,
    init: TextField.() -> Unit = {}
) = add(TextField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
inline fun Container.passwordfield(
    readonly: Boolean = false,
    init: PasswordField.() -> Unit = {}
) = add(PasswordField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

/** Text entry widget to search text. */
inline fun Container.searchfield(
    readonly: Boolean = false,
    init: SearchField.() -> Unit = {}
) = add(SearchField()
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

/** Wrapper class for [uiEntry] */
open class TextField internal constructor(alloc: CPointer<uiEntry>?) : Control<uiEntry>(alloc) {
    constructor(): this(uiNewEntry())

    /** The current text of the TextField. */
    var value: String
        get() = uiEntryText(ptr).uiText()
        set(value) = uiEntrySetText(ptr, value)

    /** Whether the text is read-only or not. Defaults to `false`. */
    var readonly: Boolean
        get() = uiEntryReadOnly(ptr) != 0
        set(readonly) = uiEntrySetReadOnly(ptr, if (readonly) 1 else 0)

    /** Function to be run when the user makes a change to the TextField.
     *  Only one function can be registered at a time. */
    fun action(block: TextField.() -> Unit) {
        action = block
        uiEntryOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<TextField>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (TextField.() -> Unit)? = null
}

/** Wrapper class for [uiEntry] to edit passwords. */
class PasswordField : TextField(uiNewPasswordEntry())

/** Wrapper class for [uiEntry] to search text. */
class SearchField : TextField(uiNewSearchEntry())

///////////////////////////////////////////////////////////////////////////////

/** A multiline plain text editing widget.
 *  @param[wrap] enables the wrapping of the text when it reaches the edge of the area */
inline fun Container.textarea(
    wrap: Boolean = true,
    readonly: Boolean = false,
    init: TextArea.() -> Unit = {}
) = add(TextArea(wrap)
        .apply { if (readonly) this.readonly = readonly }
        .apply(init))

/** Wrapper class for [uiMultilineEntry] */
class TextArea(wrap: Boolean = true) : Control<uiMultilineEntry>(
    if (wrap) uiNewMultilineEntry() else uiNewNonWrappingMultilineEntry()) {

    /** The current text of the area. */
    var value: String
        get() = uiMultilineEntryText(ptr).uiText()
        set(value) = uiMultilineEntrySetText(ptr, value)

    /** Whether the text is read-only or not. Defaults to `false` */
    var readonly: Boolean
        get() = uiMultilineEntryReadOnly(ptr) != 0
        set(readonly) = uiMultilineEntrySetReadOnly(ptr, if (readonly) 1 else 0)

    /** Adds the text to the end of the area. */
    fun append(text: String) = uiMultilineEntryAppend(ptr, text)

    /** Function to be run when the user makes a change to the TextArea.
     *  Only one function can be registered at a time. */
    fun action(block: TextArea.() -> Unit) {
        action = block
        uiMultilineEntryOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<TextArea>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (TextArea.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
inline fun Container.checkbox(
    label: String,
    init: Checkbox.() -> Unit = {}
) = add(Checkbox(label).apply(init))

/** Wrapper class for [uiCheckbox] */
class Checkbox(label: String) : Control<uiCheckbox>(uiNewCheckbox(label)) {

    /** The static text of the checkbox. */
    var label: String
        get() = uiCheckboxText(ptr).uiText()
        set(label) = uiCheckboxSetText(ptr, label)

    /** Whether the checkbox is checked or unchecked. Defaults to `false`. */
    var value: Boolean
        get() = uiCheckboxChecked(ptr) != 0
        set(value) = uiCheckboxSetChecked(ptr, if (value) 1 else 0)

    /** Function to be run when the user clicks the Checkbox.
     *  Only one function can be registered at a time. */
    fun action(block: Checkbox.() -> Unit) {
        action = block
        uiCheckboxOnToggled(ptr, staticCFunction { _, ref -> with(ref.to<Checkbox>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (Checkbox.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
inline fun Container.combobox(
    init: Combobox.() -> Unit = {}
) = add(Combobox().apply(init))

/** Wrapper class for [uiCombobox] */
class Combobox : Control<uiCombobox>(uiNewCombobox()) {

    /** Adds the named entry to the end of the combobox.
     *  If it is the first entry, it is automatically selected. */
    fun item(text: String) = uiComboboxAppend(ptr, text)

    /** Return or set the current selected option by index. */
    var value: Int
        get() = uiComboboxSelected(ptr)
        set(value) = uiComboboxSetSelected(ptr, value)

    /** Function to be run when the user makes a change to the Combobox.
     *  Only one function can be registered at a time. */
    fun action(block: Combobox.() -> Unit) {
        action = block
        uiComboboxOnSelected(ptr, staticCFunction { _, ref -> with(ref.to<Combobox>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (Combobox.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
inline fun Container.editablecombobox(
    init: EditableCombobox.() -> Unit = {}
) = add(EditableCombobox().apply(init))

/** Wrapper class for [uiEditableCombobox] */
class EditableCombobox : Control<uiEditableCombobox>(uiNewEditableCombobox()) {

    /** Adds the named entry to the end of the editable combobox.
     *  If it is the first entry, it is automatically selected. */
    fun item(text: String) = uiEditableComboboxAppend(ptr, text)

    /** Return or set the current selected text or the text value of the selected item in the list. */
    var value: String
        get() = uiEditableComboboxText(ptr).uiText()
        set(value) = uiEditableComboboxSetText(ptr, value)

    /** Function to be run when the user makes a change to the EditableCombobox.
     *  Only one function can be registered at a time. */
    fun action(block: EditableCombobox.() -> Unit) {
        action = block
        uiEditableComboboxOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<EditableCombobox>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (EditableCombobox.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
inline fun Container.spinbox(min: Int, max: Int, init: Spinbox.() -> Unit = {}) =
    add(Spinbox(min, max).apply(init))

/** Wrapper class for [uiSpinbox] */
class Spinbox(min: Int, max: Int) : Control<uiSpinbox>(uiNewSpinbox(min, max)) {

    /** The current numeric value of the spinbox. */
    var value: Int
        get() = uiSpinboxValue(ptr)
        set(value) = uiSpinboxSetValue(ptr, value)

    /** Function to be run when the user makes a change to the Spinbox.
     *  Only one function can be registered at a time. */
    fun action(block: Spinbox.() -> Unit) {
        action = block
        uiSpinboxOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<Spinbox>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (Spinbox.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
inline fun Container.slider(min: Int, max: Int, init: Slider.() -> Unit = {}) =
    add(Slider(min, max).apply(init))

/** Wrapper class for [uiSlider] */
class Slider(min: Int, max: Int) : Control<uiSlider>(uiNewSlider(min, max)) {

    /** The current numeric value of the slider. */
    var value: Int
        get() = uiSliderValue(ptr)
        set(value) = uiSliderSetValue(ptr, value)

    /** Function to be run when the user makes a change to the Slider.
     *  Only one function can be registered at a time. */
    fun action(block: Slider.() -> Unit) {
        action = block
        uiSliderOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<Slider>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (Slider.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
inline fun Container.radiobuttons(init: RadioButtons.() -> Unit = {}) =
    add(RadioButtons().apply(init))

/** Wrapper class for [uiRadioButtons] */
class RadioButtons : Control<uiRadioButtons>(uiNewRadioButtons()) {

    /** Adds the named button to the end of the radiobuttons.
     *  If it is the first button, it is automatically selected. */
    fun item(text: String) = uiRadioButtonsAppend(ptr, text)

    /** Return or set the current selected option by index. */
    var value: Int
        get() = uiRadioButtonsSelected(ptr)
        set(value) = uiRadioButtonsSetSelected(ptr, value)

    /** Function to be run when the user makes a change to the RadioButtons.
     *  Only one function can be registered at a time. */
    fun action(block: RadioButtons.() -> Unit) {
        action = block
        uiRadioButtonsOnSelected(ptr, staticCFunction { _, ref -> with(ref.to<RadioButtons>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (RadioButtons.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A widget to edit date and time. */
inline fun Container.datetimepicker(init: DateTimePicker.() -> Unit = {}) =
    add(DateTimePicker().apply(init))

/** A widget to edit date. */
inline fun Container.datepicker(init: DatePicker.() -> Unit = {}) =
    add(DatePicker().apply(init))

/** A widget to edit time. */
inline fun Container.timepicker(init: TimePicker.() -> Unit = {}) =
    add(TimePicker().apply(init))

/** Wrapper class for [uiDateTimePicker] to edit date and time. */
open class DateTimePicker internal constructor(alloc: CPointer<uiDateTimePicker>?
) : Control<uiDateTimePicker>(alloc) {
    constructor(): this(uiNewDateTimePicker())
    internal var action: (DateTimePicker.() -> Unit)? = null
    internal open var defaultFormat = "%c"

    /** The current value as posix `struct tm` */
    fun getValue(value: CPointer<tm>) = uiDateTimePickerTime(ptr, value)

    /** Set current value from posix `struct tm` */
    fun setValue(value: CPointer<tm>) = uiDateTimePickerSetTime(ptr, value)

    /** The current value in Unix epoch */
    var value: Long
        get() = memScoped {
           val tm = alloc<tm>()
           getValue(tm.ptr)
           mktime(tm.ptr)
        }
        set(value) = memScoped {
           val time = alloc<time_tVar>()
           time.value = value
           setValue(localtime(time.ptr)!!)
        }

    /** The current value as String. */
    fun textValue(format: String = defaultFormat): String = memScoped {
        val tm = alloc<tm>()
        val buf = allocArray<ByteVar>(64)
        uiDateTimePickerTime(ptr, tm.ptr)
        strftime(buf, 64, format, tm.ptr)
        return buf.toKString()
    }

    /** Function to be run when the user makes a change to the Picker.
     *  Only one function can be registered at a time. */
    fun action(block: DateTimePicker.() -> Unit) {
        action = block
        uiDateTimePickerOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<DateTimePicker>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
}

/** Wrapper class for [uiDateTimePicker] to edit date. */
class DatePicker : DateTimePicker(uiNewDatePicker()) {
    override var defaultFormat = "%x"
}

/** Wrapper class for [uiDateTimePicker] to edit time. */
class TimePicker : DateTimePicker(uiNewTimePicker()) {
    override var defaultFormat = "%X"
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
inline fun Container.label(text: String, init: Label.() -> Unit = {}) =
    add(Label(text).apply(init))

/** Wrapper class for [uiLabel] */
class Label(text: String) : Control<uiLabel>(uiNewLabel(text)) {

    /** The static text of the label. */
    var text: String
        get() = uiLabelText(ptr).uiText()
        set(value) = uiLabelSetText(ptr, value)
}

///////////////////////////////////////////////////////////////////////////////

/** An horizontal line to visually separate widgets. */
inline fun VBox.separator(init: HorizontalSeparator.() -> Unit = {}) =
    add(HorizontalSeparator().apply(init))

/** A vertical line to visually separate widgets. */
inline fun HBox.separator(init: VerticalSeparator.() -> Unit = {}) =
    add(VerticalSeparator().apply(init))

/** Wrapper class for [uiSeparator] */
abstract class Separator(alloc: CPointer<uiSeparator>?
) : Control<uiSeparator>(alloc)

/** Wrapper class for [uiSeparator] in VBox */
class HorizontalSeparator : Separator(uiNewHorizontalSeparator())

/** Wrapper class for [uiSeparator] in HBox */
class VerticalSeparator : Separator(uiNewVerticalSeparator())

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
inline fun Container.progressbar(init: ProgressBar.() -> Unit = {}) =
    add(ProgressBar().apply(init))

/** Wrapper class for [uiProgressBar] */
class ProgressBar : Control<uiProgressBar>(uiNewProgressBar()) {

    /** The current position of the progress bar.
     *  Could be set to -1 to create an indeterminate progress bar. */
    var value: Int
        get() = uiProgressBarValue(ptr)
        set(value) = uiProgressBarSetValue(ptr, value)
}

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
inline fun Container.button(text: String, init: Button.() -> Unit = {}) =
    add(Button(text).apply(init))

/** Wrapper class for [uiButton] */
class Button(text: String) : Control<uiButton>(uiNewButton(text)) {

    /** The static text of the button. */
    var text: String
        get() = uiButtonText(ptr).uiText()
        set(text) = uiButtonSetText(ptr, text)

    /** Function to be run when the user clicks the Button.
     *  Only one function can be registered at a time. */
    fun action(block: Button.() -> Unit) {
        action = block
        uiButtonOnClicked(ptr, staticCFunction { _, ref -> with(ref.to<Button>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (Button.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
inline fun Container.colorbutton(init: ColorButton.() -> Unit = {}) =
    add(ColorButton().apply(init))

/** Wrapper class for [uiColorButton] */
class ColorButton : Control<uiColorButton>(uiNewColorButton()) {

    /** Return or set the currently selected color */
    var value: Color
        get() = memScoped {
            val r = alloc<DoubleVar>()
            val g = alloc<DoubleVar>()
            val b = alloc<DoubleVar>()
            val a = alloc<DoubleVar>()
            uiColorButtonColor(ptr, r.ptr, g.ptr, b.ptr, a.ptr)
            Color(r.value, g.value, b.value, a.value)
        }
        set(value) {
            uiColorButtonSetColor(ptr, value.r, value.g, value.b, value.a)
        }

    /** Function to be run when the user makes a change to the ColorButton.
     *  Only one function can be registered at a time. */
    fun action(block: ColorButton.() -> Unit) {
        action = block
        uiColorButtonOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<ColorButton>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (ColorButton.() -> Unit)? = null
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
inline fun Container.fontbutton(init: FontButton.() -> Unit = {}) =
    add(FontButton().apply(init))

/** Wrapper class for [uiFontButton] */
class FontButton : Control<uiFontButton>(uiNewFontButton()) {
    internal val font = Font()
    override fun free() {
        font.dispose()
        super.free()
    }

    /** Returns the font currently selected in the FontButton. */
    val value: Font
        get() {
            font.clear()
            uiFontButtonFont(ptr, font.ptr)
            return font
        }
    //TODO: set

    /** Function to be run when the font in the FontButton is changed.
     *  Only one function can be registered at a time. */
    fun action(block: FontButton.() -> Unit) {
        action = block
        uiFontButtonOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<FontButton>()) {
            action?.invoke(this)
        }}, ref.asCPointer())
    }
    internal var action: (FontButton.() -> Unit)? = null
}
