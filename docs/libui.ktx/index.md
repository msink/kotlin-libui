[libui.ktx](./index.md)

## Package libui.ktx

### Types

| Name | Summary |
|---|---|
| [Attribute](-attribute/index.md) | `abstract class Attribute : `[`Disposable`](-disposable/index.md)`<`[`uiAttribute`](../libui/ui-attribute.md)`>`<br>Stores information about an attribute in a [AttributedString](-attributed-string/index.md). |
| [AttributedString](-attributed-string/index.md) | `class AttributedString : `[`Disposable`](-disposable/index.md)`<`[`uiAttributedString`](../libui/ui-attributed-string.md)`>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [BackgroundAttribute](-background-attribute/index.md) | `class BackgroundAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the background color of the text it is applied to. |
| [Box](-box/index.md) | `abstract class Box : `[`Control`](-control/index.md)`<`[`uiBox`](../libui/ui-box.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) |
| [Brush](-brush/index.md) | `class Brush : `[`Disposable`](-disposable/index.md)`<`[`uiDrawBrush`](../libui/ui-draw-brush/index.md)`>`<br>Defines the color(s) to draw a path with. |
| [Button](-button/index.md) | `class Button : `[`Control`](-control/index.md)`<`[`uiButton`](../libui/ui-button.md)`>`<br>Wrapper class for [uiButton](../libui/ui-button.md) |
| [Checkbox](-checkbox/index.md) | `class Checkbox : `[`Control`](-control/index.md)`<`[`uiCheckbox`](../libui/ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../libui/ui-checkbox.md) |
| [Color](-color/index.md) | `data class Color` |
| [ColorAttribute](-color-attribute/index.md) | `class ColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the text it is applied to. |
| [ColorButton](-color-button/index.md) | `class ColorButton : `[`Control`](-control/index.md)`<`[`uiColorButton`](../libui/ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../libui/ui-color-button.md) |
| [Combobox](-combobox/index.md) | `class Combobox : `[`Control`](-control/index.md)`<`[`uiCombobox`](../libui/ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../libui/ui-combobox.md) |
| [Container](-container/index.md) | `interface Container`<br>Container for child controls. |
| [Control](-control/index.md) | `abstract class Control<T : CPointed> : `[`Disposable`](-disposable/index.md)`<`[`T`](-control/index.md#T)`>`<br>Base class for all GUI controls (widgets). |
| [DatePicker](-date-picker/index.md) | `class DatePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit date. |
| [DateTimePicker](-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](-control/index.md)`<`[`uiDateTimePicker`](../libui/ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit date and time. |
| [Disposable](-disposable/index.md) | `abstract class Disposable<T : CPointed>`<br>Manages and owns all its native resources. |
| [DrawArea](-draw-area/index.md) | `open class DrawArea : `[`Control`](-control/index.md)`<`[`uiArea`](../libui/ui-area.md)`>`<br>Wrapper class for [uiArea](../libui/ui-area.md) |
| [EditableCombobox](-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](-control/index.md)`<`[`uiEditableCombobox`](../libui/ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../libui/ui-editable-combobox.md) |
| [FamilyAttribute](-family-attribute/index.md) | `class FamilyAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the font family of the text it is applied to. |
| [FeaturesAttribute](-features-attribute/index.md) | `class FeaturesAttribute : `[`Attribute`](-attribute/index.md)<br>Creates a new Attribute that changes the font family of the text it is applied to. otf is copied you may free it. |
| [Font](-font/index.md) | `class Font : `[`Disposable`](-disposable/index.md)`<`[`uiFontDescriptor`](../libui/ui-font-descriptor/index.md)`>`<br>Provides a complete description of a font where one is needed. |
| [FontButton](-font-button/index.md) | `class FontButton : `[`Control`](-control/index.md)`<`[`uiFontButton`](../libui/ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../libui/ui-font-button.md) |
| [Form](-form/index.md) | `class Form : `[`Control`](-control/index.md)`<`[`uiForm`](../libui/ui-form.md)`>`<br>Wrapper class for [uiForm](../libui/ui-form.md) |
| [GridPane](-grid-pane/index.md) | `class GridPane : `[`Control`](-control/index.md)`<`[`uiGrid`](../libui/ui-grid.md)`>`<br>Wrapper class for [uiGrid](../libui/ui-grid.md) |
| [Group](-group/index.md) | `class Group : `[`Control`](-control/index.md)`<`[`uiGroup`](../libui/ui-group.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiGroup](../libui/ui-group.md) |
| [HBox](-h-box/index.md) | `class HBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) that stack its children horizontally. |
| [HorizontalSeparator](-horizontal-separator/index.md) | `class HorizontalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) in VBox |
| [Image](-image/index.md) | `class Image : `[`Disposable`](-disposable/index.md)`<`[`uiImage`](../libui/ui-image.md)`>` |
| [ImageData](-image-data/index.md) | `class ImageData` |
| [ItalicAttribute](-italic-attribute/index.md) | `class ItalicAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the italic mode of the text it is applied to. |
| [Label](-label/index.md) | `class Label : `[`Control`](-control/index.md)`<`[`uiLabel`](../libui/ui-label.md)`>`<br>Wrapper class for [uiLabel](../libui/ui-label.md) |
| [Matrix](-matrix/index.md) | `class Matrix : `[`Disposable`](-disposable/index.md)`<`[`uiDrawMatrix`](../libui/ui-draw-matrix/index.md)`>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](-open-type-features/index.md) | `class OpenTypeFeatures : `[`Disposable`](-disposable/index.md)`<`[`uiOpenTypeFeatures`](../libui/ui-open-type-features.md)`>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [PasswordField](-password-field/index.md) | `class PasswordField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) for passwords. |
| [Path](-path/index.md) | `class Path : `[`Disposable`](-disposable/index.md)`<`[`uiDrawPath`](../libui/ui-draw-path.md)`>`<br>Represent a path that could be drawed on a [DrawContext](-draw-context.md) |
| [Point](-point/index.md) | `data class Point` |
| [ProgressBar](-progress-bar/index.md) | `class ProgressBar : `[`Control`](-control/index.md)`<`[`uiProgressBar`](../libui/ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../libui/ui-progress-bar.md) |
| [RadioButtons](-radio-buttons/index.md) | `class RadioButtons : `[`Control`](-control/index.md)`<`[`uiRadioButtons`](../libui/ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../libui/ui-radio-buttons.md) |
| [ScrollingArea](-scrolling-area/index.md) | `class ScrollingArea : `[`DrawArea`](-draw-area/index.md)<br>Wrapper class for [uiArea](../libui/ui-area.md) with scrollbars. |
| [SearchField](-search-field/index.md) | `class SearchField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) for search text. |
| [Separator](-separator/index.md) | `abstract class Separator : `[`Control`](-control/index.md)`<`[`uiSeparator`](../libui/ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) |
| [Size](-size/index.md) | `data class Size` |
| [SizeAttribute](-size-attribute/index.md) | `class SizeAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the size of the text it is applied to, in typographical points. |
| [SizeInt](-size-int/index.md) | `data class SizeInt` |
| [Slider](-slider/index.md) | `class Slider : `[`Control`](-control/index.md)`<`[`uiSlider`](../libui/ui-slider.md)`>`<br>Wrapper class for [uiSlider](../libui/ui-slider.md) |
| [Spinbox](-spinbox/index.md) | `class Spinbox : `[`Control`](-control/index.md)`<`[`uiSpinbox`](../libui/ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../libui/ui-spinbox.md) |
| [StretchAttribute](-stretch-attribute/index.md) | `class StretchAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the stretch of the text it is applied to. |
| [Stroke](-stroke/index.md) | `class Stroke : `[`Disposable`](-disposable/index.md)`<`[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`>`<br>Describes the stroke to draw with. |
| [TabPane](-tab-pane/index.md) | `class TabPane : `[`Control`](-control/index.md)`<`[`uiTab`](../libui/ui-tab.md)`>`<br>Wrapper class for [uiTab](../libui/ui-tab.md) |
| [Table](-table/index.md) | `class Table<T> : `[`Disposable`](-disposable/index.md)`<`[`uiTableModel`](../libui/ui-table-model.md)`>`<br>Wrapper class for [uiTableModel](../libui/ui-table-model.md) |
| [TableView](-table-view/index.md) | `class TableView : `[`Control`](-control/index.md)`<`[`uiTable`](../libui/ui-table.md)`>`<br>Wrapper class for [uiTable](../libui/ui-table.md) |
| [TextArea](-text-area/index.md) | `class TextArea : `[`Control`](-control/index.md)`<`[`uiMultilineEntry`](../libui/ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../libui/ui-multiline-entry.md) |
| [TextField](-text-field/index.md) | `open class TextField : `[`Control`](-control/index.md)`<`[`uiEntry`](../libui/ui-entry.md)`>`<br>Wrapper class for [uiEntry](../libui/ui-entry.md) |
| [TextLayout](-text-layout/index.md) | `class TextLayout : `[`Disposable`](-disposable/index.md)`<`[`uiDrawTextLayout`](../libui/ui-draw-text-layout.md)`>`<br>Representation of a [AttributedString](-attributed-string/index.md) that can be displayed in a [DrawContext](-draw-context.md). |
| [TimePicker](-time-picker/index.md) | `class TimePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) to edit time. |
| [UnderlineAttribute](-underline-attribute/index.md) | `class UnderlineAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the type of underline on the text it is applied to. |
| [UnderlineColorAttribute](-underline-color-attribute/index.md) | `class UnderlineColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the underline on the text it is applied to. |
| [VBox](-v-box/index.md) | `class VBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) that stack its children vertically. |
| [VerticalSeparator](-vertical-separator/index.md) | `class VerticalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) in HBox |
| [WeightAttribute](-weight-attribute/index.md) | `class WeightAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the weight of the text it is applied to. |
| [Window](-window/index.md) | `class Window : `[`Control`](-control/index.md)`<`[`uiWindow`](../libui/ui-window.md)`>, `[`Container`](-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |

### Type Aliases

| Name | Summary |
|---|---|
| [DrawContext](-draw-context.md) | `typealias DrawContext = CPointer<`[`uiDrawContext`](../libui/ui-draw-context.md)`>` |
| [Menu](-menu.md) | `typealias Menu = CPointer<`[`uiMenu`](../libui/ui-menu.md)`>` |
| [MenuItem](-menu-item.md) | `typealias MenuItem = CPointer<`[`uiMenuItem`](../libui/ui-menu-item.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [hbox](hbox.md) | `val `[`Container`](-container/index.md)`.hbox: `[`HBox`](-h-box/index.md) |
| [stretchy](stretchy.md) | `val `[`Box`](-box/index.md)`.stretchy: `[`Stretchy`](-box/-stretchy/index.md)<br>`val `[`Form`](-form/index.md)`.stretchy: `[`Stretchy`](-form/-stretchy/index.md) |
| [vbox](vbox.md) | `val `[`Container`](-container/index.md)`.vbox: `[`VBox`](-v-box/index.md) |

### Functions

| Name | Summary |
|---|---|
| [Color](-color.md) | `fun Color(rgb: Int, alpha: Double = 1.0): `[`Color`](-color/index.md) |
| [MsgBox](-msg-box.md) | `fun MsgBox(text: String, details: String = ""): Unit`<br>Displays a modal Message Box. |
| [MsgBoxError](-msg-box-error.md) | `fun MsgBoxError(text: String, details: String = ""): Unit`<br>Displays a modal Error Message Box. |
| [OpenFileDialog](-open-file-dialog.md) | `fun OpenFileDialog(): String?`<br>Displays a modal Open File Dialog. |
| [SaveFileDialog](-save-file-dialog.md) | `fun SaveFileDialog(): String?`<br>Displays a modal Save File Dialog. |
| [appWindow](app-window.md) | `fun appWindow(title: String, width: Int, height: Int, margined: Boolean = true, init: `[`Window`](-window/index.md)`.() -> Unit = {}): Unit`<br>Initializes package ui, runs `init` to set up the program, and executes the GUI main loop. `init` should set up the program's initial state: open the main window, create controls, and set up events. |
| [bitmap](bitmap.md) | `fun `[`Image`](-image/index.md)`.bitmap(data: `[`ImageData`](-image-data/index.md)`): Unit` |
| [brush](brush.md) | `fun `[`DrawArea`](-draw-area/index.md)`.brush(): `[`Brush`](-brush/index.md)<br>Creates a new [Brush](-brush/index.md) with lifecycle delegated to [DrawArea](-draw-area/index.md). |
| [button](button.md) | `fun `[`Container`](-container/index.md)`.button(text: String, init: `[`Button`](-button/index.md)`.() -> Unit = {}): `[`Button`](-button/index.md)<br>A simple button. |
| [cell](cell.md) | `fun `[`GridPane`](-grid-pane/index.md)`.cell(x: Int = 0, y: Int = 0, xspan: Int = 1, yspan: Int = 1, hexpand: Boolean = false, halign: `[`uiAlign`](../libui/ui-align.md)` = uiAlignFill, vexpand: Boolean = false, valign: `[`uiAlign`](../libui/ui-align.md)` = uiAlignFill): `[`Cell`](-grid-pane/-cell/index.md) |
| [checkbox](checkbox.md) | `fun `[`Container`](-container/index.md)`.checkbox(label: String, init: `[`Checkbox`](-checkbox/index.md)`.() -> Unit = {}): `[`Checkbox`](-checkbox/index.md)<br>A checkbox widget. |
| [colorbutton](colorbutton.md) | `fun `[`Container`](-container/index.md)`.colorbutton(init: `[`ColorButton`](-color-button/index.md)`.() -> Unit = {}): `[`ColorButton`](-color-button/index.md)<br>A button that opens a color palette popup. |
| [combobox](combobox.md) | `fun `[`Container`](-container/index.md)`.combobox(init: `[`Combobox`](-combobox/index.md)`.() -> Unit = {}): `[`Combobox`](-combobox/index.md)<br>A drop down combo box that allow list selection only. |
| [datepicker](datepicker.md) | `fun `[`Container`](-container/index.md)`.datepicker(init: `[`DatePicker`](-date-picker/index.md)`.() -> Unit = {}): `[`DatePicker`](-date-picker/index.md)<br>A widget to edit date. |
| [datetimepicker](datetimepicker.md) | `fun `[`Container`](-container/index.md)`.datetimepicker(init: `[`DateTimePicker`](-date-time-picker/index.md)`.() -> Unit = {}): `[`DateTimePicker`](-date-time-picker/index.md)<br>A widget to edit date and time. |
| [drawarea](drawarea.md) | `fun `[`Container`](-container/index.md)`.drawarea(init: `[`DrawArea`](-draw-area/index.md)`.() -> Unit = {}): `[`DrawArea`](-draw-area/index.md)<br>A canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](editablecombobox.md) | `fun `[`Container`](-container/index.md)`.editablecombobox(init: `[`EditableCombobox`](-editable-combobox/index.md)`.() -> Unit = {}): `[`EditableCombobox`](-editable-combobox/index.md)<br>A drop down combo box that allow selection from list or free text entry. |
| [field](field.md) | `fun `[`Form`](-form/index.md)`.field(label: String): `[`Field`](-form/-field/index.md)<br>`fun `[`Stretchy`](-form/-stretchy/index.md)`.field(label: String): `[`Field`](-form/-stretchy/-field/index.md) |
| [fill](fill.md) | `fun `[`DrawContext`](-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit`<br>Draw a path filled with a color.`fun `[`DrawContext`](-draw-context.md)`.fill(brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit` |
| [fontbutton](fontbutton.md) | `fun `[`Container`](-container/index.md)`.fontbutton(init: `[`FontButton`](-font-button/index.md)`.() -> Unit = {}): `[`FontButton`](-font-button/index.md)<br>A button that allows users to choose a font when they click on it. |
| [form](form.md) | `fun `[`Container`](-container/index.md)`.form(padded: Boolean = true, init: `[`Form`](-form/index.md)`.() -> Unit = {}): `[`Form`](-form/index.md)<br>A container that organize children as labeled fields. |
| [gridpane](gridpane.md) | `fun `[`Container`](-container/index.md)`.gridpane(padded: Boolean = true, init: `[`GridPane`](-grid-pane/index.md)`.() -> Unit = {}): `[`GridPane`](-grid-pane/index.md)<br>A powerful container that allow to specify size and position of each children. |
| [group](group.md) | `fun `[`Container`](-container/index.md)`.group(title: String, margined: Boolean = true): `[`Group`](-group/index.md)<br>A container for a single widget that provide a caption and visually group it's children. |
| [hbox](hbox.md) | `fun `[`Container`](-container/index.md)`.hbox(padded: Boolean = true, init: `[`HBox`](-h-box/index.md)`.() -> Unit = {}): `[`HBox`](-h-box/index.md)<br>A container that stack its children horizontally. |
| [image](image.md) | `fun `[`Table`](-table/index.md)`<*>.image(width: Int, height: Int, block: `[`Image`](-image/index.md)`.() -> Unit = {}): `[`Image`](-image/index.md) |
| [label](label.md) | `fun `[`Container`](-container/index.md)`.label(text: String, init: `[`Label`](-label/index.md)`.() -> Unit = {}): `[`Label`](-label/index.md)<br>A static text label. |
| [onShouldQuit](on-should-quit.md) | `fun onShouldQuit(block: () -> Boolean): Unit`<br>Function to be executed when the OS wants the program to quit or when a Quit menu item has been clicked. Only one function may be registered at a time. |
| [onTimer](on-timer.md) | `fun onTimer(milliseconds: Int, block: () -> Boolean): Unit`<br>Function to be executed on a timer on the main thread. |
| [page](page.md) | `fun `[`TabPane`](-tab-pane/index.md)`.page(label: String, margined: Boolean = true, init: `[`Page`](-tab-pane/-page/index.md)`.() -> Unit = {}): `[`Page`](-tab-pane/-page/index.md) |
| [passwordfield](passwordfield.md) | `fun `[`Container`](-container/index.md)`.passwordfield(readonly: Boolean = false, init: `[`PasswordField`](-password-field/index.md)`.() -> Unit = {}): `[`PasswordField`](-password-field/index.md)<br>Text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](progressbar.md) | `fun `[`Container`](-container/index.md)`.progressbar(init: `[`ProgressBar`](-progress-bar/index.md)`.() -> Unit = {}): `[`ProgressBar`](-progress-bar/index.md)<br>Progress bar widget. |
| [radiobuttons](radiobuttons.md) | `fun `[`Container`](-container/index.md)`.radiobuttons(init: `[`RadioButtons`](-radio-buttons/index.md)`.() -> Unit = {}): `[`RadioButtons`](-radio-buttons/index.md)<br>A widget that represent a group of radio options. |
| [random](random.md) | `fun random(): Int` |
| [scrollingarea](scrollingarea.md) | `fun `[`Container`](-container/index.md)`.scrollingarea(width: Int, height: Int, init: `[`ScrollingArea`](-scrolling-area/index.md)`.() -> Unit = {}): `[`ScrollingArea`](-scrolling-area/index.md)<br>[DrawArea](-draw-area/index.md) with horziontal and vertical scrollbars. |
| [searchfield](searchfield.md) | `fun `[`Container`](-container/index.md)`.searchfield(readonly: Boolean = false, init: `[`SearchField`](-search-field/index.md)`.() -> Unit = {}): `[`SearchField`](-search-field/index.md)<br>Text entry widget to search text. |
| [separator](separator.md) | `fun `[`VBox`](-v-box/index.md)`.separator(init: `[`HorizontalSeparator`](-horizontal-separator/index.md)`.() -> Unit = {}): `[`HorizontalSeparator`](-horizontal-separator/index.md)<br>An horizontal line to visually separate widgets.`fun `[`HBox`](-h-box/index.md)`.separator(init: `[`VerticalSeparator`](-vertical-separator/index.md)`.() -> Unit = {}): `[`VerticalSeparator`](-vertical-separator/index.md)<br>A vertical line to visually separate widgets. |
| [slider](slider.md) | `fun `[`Container`](-container/index.md)`.slider(min: Int, max: Int, init: `[`Slider`](-slider/index.md)`.() -> Unit = {}): `[`Slider`](-slider/index.md)<br>Horizontal slide to set numerical values. |
| [spinbox](spinbox.md) | `fun `[`Container`](-container/index.md)`.spinbox(min: Int, max: Int, init: `[`Spinbox`](-spinbox/index.md)`.() -> Unit = {}): `[`Spinbox`](-spinbox/index.md)<br>An entry widget for numerical values. |
| [stretchy](stretchy.md) | `fun `[`Box`](-box/index.md)`.stretchy(init: `[`Stretchy`](-box/-stretchy/index.md)`.() -> Unit = {}): `[`Stretchy`](-box/-stretchy/index.md) |
| [string](string.md) | `fun `[`DrawArea`](-draw-area/index.md)`.string(init: String): `[`AttributedString`](-attributed-string/index.md)<br>Creates a new [AttributedString](-attributed-string/index.md) from initial String. The string will be entirely unattributed. |
| [stroke](stroke.md) | `fun `[`DrawArea`](-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`.() -> Unit = {}): `[`Stroke`](-stroke/index.md)<br>Creates a new [Stroke](-stroke/index.md) with lifecycle delegated to [DrawArea](-draw-area/index.md).`fun `[`DrawContext`](-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit`<br>Draw a path in the context.`fun `[`DrawContext`](-draw-context.md)`.stroke(brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit` |
| [table](table.md) | `fun <T> table(data: List<`[`T`](table.md#T)`>): `[`Table`](-table/index.md)`<`[`T`](table.md#T)`>` |
| [tableview](tableview.md) | `fun <T> `[`Container`](-container/index.md)`.tableview(data: List<`[`T`](tableview.md#T)`>, init: `[`Table`](-table/index.md)`<`[`T`](tableview.md#T)`>.() -> Unit = {}): `[`TableView`](-table-view/index.md) |
| [tabpane](tabpane.md) | `fun `[`Container`](-container/index.md)`.tabpane(init: `[`TabPane`](-tab-pane/index.md)`.() -> Unit = {}): `[`TabPane`](-tab-pane/index.md)<br>A container that show each children in a separate tab. |
| [text](text.md) | `fun `[`DrawContext`](-draw-context.md)`.text(string: `[`AttributedString`](-attributed-string/index.md)`, defaultFont: `[`Font`](-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../libui/ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [textarea](textarea.md) | `fun `[`Container`](-container/index.md)`.textarea(wrap: Boolean = true, readonly: Boolean = false, init: `[`TextArea`](-text-area/index.md)`.() -> Unit = {}): `[`TextArea`](-text-area/index.md)<br>A multiline plain text editing widget. |
| [textfield](textfield.md) | `fun `[`Container`](-container/index.md)`.textfield(readonly: Boolean = false, init: `[`TextField`](-text-field/index.md)`.() -> Unit = {}): `[`TextField`](-text-field/index.md)<br>A simple single line text entry widget. |
| [timepicker](timepicker.md) | `fun `[`Container`](-container/index.md)`.timepicker(init: `[`TimePicker`](-time-picker/index.md)`.() -> Unit = {}): `[`TimePicker`](-time-picker/index.md)<br>A widget to edit time. |
| [transform](transform.md) | `fun `[`DrawContext`](-draw-context.md)`.transform(block: `[`Matrix`](-matrix/index.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
| [vbox](vbox.md) | `fun `[`Container`](-container/index.md)`.vbox(padded: Boolean = true, init: `[`VBox`](-v-box/index.md)`.() -> Unit = {}): `[`VBox`](-v-box/index.md)<br>A container that stack its children vertically. |
