package libui

import kotlinx.cinterop.*
import platform.posix.*

///////////////////////////////////////////////////////////////////////////////
//
// Data entry widgets:
// - [TextField]
// - [PasswordField]
// - [SearchField]
// - [TextArea]
// - [Checkbox]
// - [Combobox]
// - [EditableCombobox]
// - [Spinbox]
// - [Slider]
// - [RadioButtons]
// - [DatePicker]
// - [TimePicker]
// - [DateTimePicker]
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

/** A simple single line text entry widget. */
open class TextField internal constructor(alloc: CPointer<uiEntry>?) : Control<uiEntry>(alloc) {
    constructor(): this(uiNewEntry())
    internal var action: (TextField.() -> Unit)? = null
}

/** Text entry widget that mask the input, useful to edit passwords or other sensible data. */
class PasswordField : TextField(uiNewPasswordEntry())

/** Text entry widget to search text. */
class SearchField : TextField(uiNewSearchEntry())

/** The current text of the TextField. */
var TextField.value: String
    get() = uiEntryText(ptr)?.toKString() ?: ""
    set(value) = uiEntrySetText(ptr, value)

/** Whether the text is read-only or not. Defaults to `false`. */
var TextField.readonly: Boolean
    get() = uiEntryReadOnly(ptr) != 0
    set(readonly) = uiEntrySetReadOnly(ptr, if (readonly) 1 else 0)

/** Funcion to be run when the user makes a change to the TextField.
 *  Only one function can be registered at a time. */
fun TextField.action(block: TextField.() -> Unit) {
    action = block
    uiEntryOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<TextField>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline plain text editing widget.
 *  [wrap] enables the wrapping of the text when it reaches the edge of the area */
class TextArea(wrap: Boolean = true) : Control<uiMultilineEntry>(
    if (wrap) uiNewMultilineEntry() else uiNewNonWrappingMultilineEntry()) {
    internal var action: (TextArea.() -> Unit)? = null
}

/** The current text of the area. */
var TextArea.value: String
    get() = uiMultilineEntryText(ptr)?.toKString() ?: ""
    set(value) = uiMultilineEntrySetText(ptr, value)

/** Whether the text is read-only or not. Defaults to `false` */
var TextArea.readonly: Boolean
    get() = uiMultilineEntryReadOnly(ptr) != 0
    set(readonly) = uiMultilineEntrySetReadOnly(ptr, if (readonly) 1 else 0)

/** Adds the text to the end of the area. */
fun TextArea.append(text: String) = uiMultilineEntryAppend(ptr, text)

/** Funcion to be run when the user makes a change to the TextArea.
 *  Only one function can be registered at a time. */
fun TextArea.action(block: TextArea.() -> Unit) {
    action = block
    uiMultilineEntryOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<TextArea>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
class Checkbox(label: String) : Control<uiCheckbox>(uiNewCheckbox(label)) {
    internal var action: (Checkbox.() -> Unit)? = null
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
fun Checkbox.action(block: Checkbox.() -> Unit) {
    action = block
    uiCheckboxOnToggled(ptr, staticCFunction { _, ref -> with(ref.to<Checkbox>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
class Combobox : Control<uiCombobox>(uiNewCombobox()) {
    internal var action: (Combobox.() -> Unit)? = null
}

/** Adds the named entry to the end of the combobox.
 *  If it is the first entry, it is automatically selected. */
fun Combobox.item(text: String) = uiComboboxAppend(ptr, text)

/** Return or set the current choosed option by index. */
var Combobox.value: Int
    get() = uiComboboxSelected(ptr)
    set(value) = uiComboboxSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(block: Combobox.() -> Unit) {
    action = block
    uiComboboxOnSelected(ptr, staticCFunction { _, ref -> with(ref.to<Combobox>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
class EditableCombobox : Control<uiEditableCombobox>(uiNewEditableCombobox()) {
    internal var action: (EditableCombobox.() -> Unit)? = null
}

/** Adds the named entry to the end of the editable combobox.
 *  If it is the first entry, it is automatically selected. */
fun EditableCombobox.item(text: String) = uiEditableComboboxAppend(ptr, text)

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.value: String
    get() = uiEditableComboboxText(ptr)?.toKString() ?: ""
    set(value) = uiEditableComboboxSetText(ptr, value)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
fun EditableCombobox.action(block: EditableCombobox.() -> Unit) {
    action = block
    uiEditableComboboxOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<EditableCombobox>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** An entry widget for numerical values. */
class Spinbox(min: Int, max: Int) : Control<uiSpinbox>(uiNewSpinbox(min, max)) {
    internal var action: (Spinbox.() -> Unit)? = null
}

/** The current numeric value of the spinbox. */
var Spinbox.value: Int
    get() = uiSpinboxValue(ptr)
    set(value) = uiSpinboxSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Spinbox.
 *  Only one function can be registered at a time. */
fun Spinbox.action(block: Spinbox.() -> Unit) {
    action = block
    uiSpinboxOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<Spinbox>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
class Slider(min: Int, max: Int) : Control<uiSlider>(uiNewSlider(min, max)) {
    internal var action: (Slider.() -> Unit)? = null
}

/** The current numeric value of the slider. */
var Slider.value: Int
    get() = uiSliderValue(ptr)
    set(value) = uiSliderSetValue(ptr, value)

/** Funcion to be run when the user makes a change to the Slider.
 *  Only one function can be registered at a time. */
fun Slider.action(block: Slider.() -> Unit) {
    action = block
    uiSliderOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<Slider>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
class RadioButtons : Control<uiRadioButtons>(uiNewRadioButtons()) {
    internal var action: (RadioButtons.() -> Unit)? = null
}

/** Adds the named button to the end of the radiobuttons.
 *  If it is the first button, it is automatically selected. */
fun RadioButtons.item(text: String) = uiRadioButtonsAppend(ptr, text)

/** Return or set the current choosed option by index. */
var RadioButtons.value: Int
    get() = uiRadioButtonsSelected(ptr)
    set(value) = uiRadioButtonsSetSelected(ptr, value)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(block: RadioButtons.() -> Unit) {
    action = block
    uiRadioButtonsOnSelected(ptr, staticCFunction { _, ref -> with(ref.to<RadioButtons>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A widget to edit date and time. */
open class DateTimePicker internal constructor(alloc: CPointer<uiDateTimePicker>?
) : Control<uiDateTimePicker>(alloc) {
    constructor(): this(uiNewDateTimePicker())
    internal var action: (DateTimePicker.() -> Unit)? = null
    internal open var defaultFormat = "%c"
}

/** A widget to edit date. */
class DatePicker : DateTimePicker(uiNewDatePicker()) {
    override var defaultFormat = "%x"
}

/** A widget to edit time. */
class TimePicker : DateTimePicker(uiNewTimePicker()) {
    override var defaultFormat = "%X"
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
fun DateTimePicker.action(block: DateTimePicker.() -> Unit) {
    action = block
    uiDateTimePickerOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<DateTimePicker>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
class Label(text: String) : Control<uiLabel>(uiNewLabel(text))

/** The static text of the label. */
var Label.text: String
    get() = uiLabelText(ptr)?.toKString() ?: ""
    set(value) = uiLabelSetText(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
abstract class Separator(alloc: CPointer<uiSeparator>?
) : Control<uiSeparator>(alloc)

/** An horizontal line to visually separate widgets. */
class HorizontalSeparator() : Separator(uiNewHorizontalSeparator())

/** A vertical line to visually separate widgets. */
class VerticalSeparator() : Separator(uiNewVerticalSeparator())

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
class ProgressBar() : Control<uiProgressBar>(uiNewProgressBar())

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(ptr)
    set(value) = uiProgressBarSetValue(ptr, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
class Button(text: String) : Control<uiButton>(uiNewButton(text)) {
    internal var action: (Button.() -> Unit)? = null
}

/** The static text of the button. */
var Button.text: String
    get() = uiButtonText(ptr)?.toKString() ?: ""
    set(text) = uiButtonSetText(ptr, text)

/** Funcion to be run when the user clicks the Button.
 *  Only one function can be registered at a time. */
fun Button.action(block: Button.() -> Unit) {
    action = block
    uiButtonOnClicked(ptr, staticCFunction { _, ref -> with(ref.to<Button>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton : Control<uiColorButton>(uiNewColorButton()) {
    internal var action: (ColorButton.() -> Unit)? = null
}

/** Return or set the currently selected color */
var ColorButton.value: Color
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

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(block: ColorButton.() -> Unit) {
    action = block
    uiColorButtonOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<ColorButton>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton : Control<uiFontButton>(uiNewFontButton()) {
    internal var action: (FontButton.() -> Unit)? = null
    internal val font = Font()
    override fun free() {
        font.dispose()
        super.free()
    }
}

/** Returns the font currently selected in the FontButton. */
val FontButton.value: Font
    get() {
        font.clear()
        uiFontButtonFont(ptr, font.ptr)
        return font
    }
//TODO: set

/** Funcion to be run when the font in the FontButton is changed.
 *  Only one function can be registered at a time. */
fun FontButton.action(block: FontButton.() -> Unit) {
    action = block
    uiFontButtonOnChanged(ptr, staticCFunction { _, ref -> with(ref.to<FontButton>()) {
        action?.invoke(this)
    }}, ref.asCPointer())
}
