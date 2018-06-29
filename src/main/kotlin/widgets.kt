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

/** A simple single line text entry widget. */
open class Entry internal constructor(alloc: CPointer<uiEntry>?
) : Control<uiEntry>(alloc) {
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

/** Whether the text is read-only or not. Defaults to `false`. */
var Entry.readonly: Boolean
    get() = uiEntryReadOnly(ptr) != 0
    set(readonly) = uiEntrySetReadOnly(ptr, if (readonly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(block: Entry.() -> Unit) {
    action = block
    uiEntryOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Entry>().get()) { action?.invoke(this) }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
open class MultilineEntry internal constructor(alloc: CPointer<uiMultilineEntry>?
) : Control<uiMultilineEntry>(alloc) {
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

/** Whether the text is read-only or not. Defaults to `false` */
var MultilineEntry.readonly: Boolean
    get() = uiMultilineEntryReadOnly(ptr) != 0
    set(readonly) = uiMultilineEntrySetReadOnly(ptr, if (readonly) 1 else 0)

/** Adds the text to the end of the multiline entry. */
fun MultilineEntry.append(text: String) = uiMultilineEntryAppend(ptr, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun MultilineEntry.action(block: MultilineEntry.() -> Unit) {
    action = block
    uiMultilineEntryOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<MultilineEntry>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun Checkbox.action(block: Checkbox.() -> Unit) {
    action = block
    uiCheckboxOnToggled(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Checkbox>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun Combobox.action(block: Combobox.() -> Unit) {
    action = block
    uiComboboxOnSelected(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Combobox>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun EditableCombobox.action(block: EditableCombobox.() -> Unit) {
    action = block
    uiEditableComboboxOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<EditableCombobox>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun Spinbox.action(block: Spinbox.() -> Unit) {
    action = block
    uiSpinboxOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Spinbox>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun Slider.action(block: Slider.() -> Unit) {
    action = block
    uiSliderOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Slider>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
fun RadioButtons.action(block: RadioButtons.() -> Unit) {
    action = block
    uiRadioButtonsOnSelected(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<RadioButtons>().get()) { action?.invoke(this) }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A widget to edit date and time. */
open class DateTimePicker internal constructor(alloc: CPointer<uiDateTimePicker>?
) : Control<uiDateTimePicker>(alloc) {
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
fun DateTimePicker.action(block: DateTimePicker.() -> Unit) {
    action = block
    uiDateTimePickerOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<DateTimePicker>().get()) { action?.invoke(this) }}, ref.asCPointer())
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
abstract class Separator(alloc: CPointer<uiSeparator>?
) : Control<uiSeparator>(alloc)

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
fun Button.action(block: Button.() -> Unit) {
    action = block
    uiButtonOnClicked(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<Button>().get()) { action?.invoke(this) }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
class ColorButton(block: ColorButton.() -> Unit = {}
) : Control<uiColorButton>(uiNewColorButton()) {
    internal var action: (ColorButton.() -> Unit)? = null
    init { apply(block) }
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
    uiColorButtonOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<ColorButton>().get()) { action?.invoke(this) }}, ref.asCPointer())
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
class FontButton(block: FontButton.() -> Unit = {}
) : Control<uiFontButton>(uiNewFontButton()) {
    internal var action: (FontButton.() -> Unit)? = null
    internal val font = Font()
    init { apply(block) }
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
    uiFontButtonOnChanged(ptr, staticCFunction { _, ref ->
        with (ref!!.asStableRef<FontButton>().get()) { action?.invoke(this) }}, ref.asCPointer())
}
