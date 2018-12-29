[libui.ktx](./index.md)

## Package libui.ktx

### Types

| Name | Summary |
|---|---|
| [Box](-box/index.md) | `abstract class Box : `[`Control`](-control/index.md)`<`[`uiBox`](../libui/ui-box.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) - a container that stack its children horizontally or vertically. |
| [Button](-button/index.md) | `class Button : `[`Control`](-control/index.md)`<`[`uiButton`](../libui/ui-button.md)`>`<br>Wrapper class for [uiButton](../libui/ui-button.md) - a simple button. |
| [Checkbox](-checkbox/index.md) | `class Checkbox : `[`Control`](-control/index.md)`<`[`uiCheckbox`](../libui/ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../libui/ui-checkbox.md) - a checkbox widget. |
| [ColorButton](-color-button/index.md) | `class ColorButton : `[`Control`](-control/index.md)`<`[`uiColorButton`](../libui/ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../libui/ui-color-button.md) - a button that opens a color palette popup. |
| [Combobox](-combobox/index.md) | `class Combobox : `[`Control`](-control/index.md)`<`[`uiCombobox`](../libui/ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../libui/ui-combobox.md) - a drop down combo box that allow list selection only. |
| [Container](-container/index.md) | `interface Container`<br>Container for child controls. |
| [Control](-control/index.md) | `abstract class Control<T : CPointed> : `[`Disposable`](-disposable/index.md)`<`[`T`](-control/index.md#T)`>`<br>Base class for all GUI controls (widgets). |
| [DatePicker](-date-picker/index.md) | `class DatePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) - a widget to edit date. |
| [DateTimePicker](-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](-control/index.md)`<`[`uiDateTimePicker`](../libui/ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) - a widget to edit date and time. |
| [Disposable](-disposable/index.md) | `abstract class Disposable<T : CPointed>`<br>Base class for all objects that have a holder reference to the native C resource(s). |
| [DrawArea](-draw-area/index.md) | `open class DrawArea : `[`Control`](-control/index.md)`<`[`uiArea`](../libui/ui-area.md)`>`<br>Wrapper class for [uiArea](../libui/ui-area.md) - a canvas you can draw on. |
| [EditableCombobox](-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](-control/index.md)`<`[`uiEditableCombobox`](../libui/ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../libui/ui-editable-combobox.md) - a drop down combo box that allow selection from list or free text entry. |
| [FontButton](-font-button/index.md) | `class FontButton : `[`Control`](-control/index.md)`<`[`uiFontButton`](../libui/ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../libui/ui-font-button.md) - a button that allows users to choose a font. |
| [Form](-form/index.md) | `class Form : `[`Control`](-control/index.md)`<`[`uiForm`](../libui/ui-form.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiForm](../libui/ui-form.md) - a container that organize children as labeled fields. |
| [GridPane](-grid-pane/index.md) | `class GridPane : `[`Control`](-control/index.md)`<`[`uiGrid`](../libui/ui-grid.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiGrid](../libui/ui-grid.md) - a powerful container that allow to specify size and position of each children. |
| [Group](-group/index.md) | `class Group : `[`Control`](-control/index.md)`<`[`uiGroup`](../libui/ui-group.md)`>, `[`Container`](-container/index.md)<br>Wrapper class for [uiGroup](../libui/ui-group.md) - a container for a single widget that provide a caption and visually group it's children. |
| [HBox](-h-box/index.md) | `class HBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) - a container that stack its children horizontally. |
| [HorizontalSeparator](-horizontal-separator/index.md) | `class HorizontalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) - an horizontal line to visually separate widgets. |
| [Label](-label/index.md) | `class Label : `[`Control`](-control/index.md)`<`[`uiLabel`](../libui/ui-label.md)`>`<br>Wrapper class for [uiLabel](../libui/ui-label.md) - a static text label. |
| [PasswordField](-password-field/index.md) | `class PasswordField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) - a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [ProgressBar](-progress-bar/index.md) | `class ProgressBar : `[`Control`](-control/index.md)`<`[`uiProgressBar`](../libui/ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../libui/ui-progress-bar.md) - a progress bar widget. |
| [RadioButtons](-radio-buttons/index.md) | `class RadioButtons : `[`Control`](-control/index.md)`<`[`uiRadioButtons`](../libui/ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../libui/ui-radio-buttons.md) - a widget that represent a group of radio options. |
| [ScrollingArea](-scrolling-area/index.md) | `class ScrollingArea : `[`DrawArea`](-draw-area/index.md)<br>Wrapper class for [uiArea](../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars. |
| [SearchField](-search-field/index.md) | `class SearchField : `[`TextField`](-text-field/index.md)<br>Wrapper class for [uiEntry](../libui/ui-entry.md) - a text entry widget to search text. |
| [Separator](-separator/index.md) | `abstract class Separator : `[`Control`](-control/index.md)`<`[`uiSeparator`](../libui/ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) |
| [Slider](-slider/index.md) | `class Slider : `[`Control`](-control/index.md)`<`[`uiSlider`](../libui/ui-slider.md)`>`<br>Wrapper class for [uiSlider](../libui/ui-slider.md) - an horizontal slide to set numerical values. |
| [Spinbox](-spinbox/index.md) | `class Spinbox : `[`Control`](-control/index.md)`<`[`uiSpinbox`](../libui/ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../libui/ui-spinbox.md) - an entry widget for numerical values. |
| [TabPane](-tab-pane/index.md) | `class TabPane : `[`Control`](-control/index.md)`<`[`uiTab`](../libui/ui-tab.md)`>`<br>Wrapper class for [uiTab](../libui/ui-tab.md) - a container that show each children in a separate tab. |
| [Table](-table/index.md) | `class Table<T> : `[`Disposable`](-disposable/index.md)`<`[`uiTableModel`](../libui/ui-table-model.md)`>`<br>Wrapper class for [uiTableModel](../libui/ui-table-model.md) |
| [TableView](-table-view/index.md) | `class TableView : `[`Control`](-control/index.md)`<`[`uiTable`](../libui/ui-table.md)`>`<br>Wrapper class for [uiTable](../libui/ui-table.md) |
| [TextArea](-text-area/index.md) | `class TextArea : `[`Control`](-control/index.md)`<`[`uiMultilineEntry`](../libui/ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../libui/ui-multiline-entry.md) - a multiline plain text editing widget |
| [TextField](-text-field/index.md) | `open class TextField : `[`Control`](-control/index.md)`<`[`uiEntry`](../libui/ui-entry.md)`>`<br>Wrapper class for [uiEntry](../libui/ui-entry.md) - a simple single line text entry widget |
| [TimePicker](-time-picker/index.md) | `class TimePicker : `[`DateTimePicker`](-date-time-picker/index.md)<br>Wrapper class for [uiDateTimePicker](../libui/ui-date-time-picker.md) - a widget to edit time. |
| [VBox](-v-box/index.md) | `class VBox : `[`Box`](-box/index.md)<br>Wrapper class for [uiBox](../libui/ui-box.md) - a container that stack its children vertically. |
| [VerticalSeparator](-vertical-separator/index.md) | `class VerticalSeparator : `[`Separator`](-separator/index.md)<br>Wrapper class for [uiSeparator](../libui/ui-separator.md) - a vertical line to visually separate widgets. |
| [Window](-window/index.md) | `class Window : `[`Control`](-control/index.md)`<`[`uiWindow`](../libui/ui-window.md)`>, `[`Container`](-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |

### Type Aliases

| Name | Summary |
|---|---|
| [AreaDrawParams](-area-draw-params.md) | `typealias AreaDrawParams = `[`uiAreaDrawParams`](../libui/ui-area-draw-params/index.md) |
| [AreaMouseEvent](-area-mouse-event.md) | `typealias AreaMouseEvent = `[`uiAreaMouseEvent`](../libui/ui-area-mouse-event/index.md) |
| [DrawContext](-draw-context.md) | `typealias DrawContext = `[`uiDrawContext`](../libui/ui-draw-context.md) |
| [Menu](-menu.md) | `typealias Menu = CPointer<`[`uiMenu`](../libui/ui-menu.md)`>` |
| [MenuItem](-menu-item.md) | `typealias MenuItem = CPointer<`[`uiMenuItem`](../libui/ui-menu-item.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [hbox](hbox.md) | `val `[`Container`](-container/index.md)`.hbox: `[`HBox`](-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [vbox](vbox.md) | `val `[`Container`](-container/index.md)`.vbox: `[`VBox`](-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |

### Functions

| Name | Summary |
|---|---|
| [MsgBox](-msg-box.md) | `fun MsgBox(text: String, details: String = ""): Unit`<br>Displays a modal Message Box. |
| [MsgBoxError](-msg-box-error.md) | `fun MsgBoxError(text: String, details: String = ""): Unit`<br>Displays a modal Error Message Box. |
| [OpenFileDialog](-open-file-dialog.md) | `fun OpenFileDialog(): String?`<br>Displays a modal Open File Dialog. |
| [OpenFolderDialog](-open-folder-dialog.md) | `fun OpenFolderDialog(): String?`<br>Displays a modal Open Folder Dialog. |
| [SaveFileDialog](-save-file-dialog.md) | `fun SaveFileDialog(): String?`<br>Displays a modal Save File Dialog. |
| [appWindow](app-window.md) | `fun appWindow(title: String, width: Int, height: Int, margined: Boolean = true, init: `[`Window`](-window/index.md)`.() -> Unit = {}): Unit`<br>Initializes package ui, runs `init` to set up the program, and executes the GUI main loop. `init` should set up the program's initial state: open the main window, create controls, and set up events. |
| [button](button.md) | `fun `[`Container`](-container/index.md)`.button(text: String, init: `[`Button`](-button/index.md)`.() -> Unit = {}): `[`Button`](-button/index.md)<br>DSL builder for a simple button. |
| [checkbox](checkbox.md) | `fun `[`Container`](-container/index.md)`.checkbox(label: String, init: `[`Checkbox`](-checkbox/index.md)`.() -> Unit = {}): `[`Checkbox`](-checkbox/index.md)<br>DSL builder for a checkbox widget. |
| [colorbutton](colorbutton.md) | `fun `[`Container`](-container/index.md)`.colorbutton(init: `[`ColorButton`](-color-button/index.md)`.() -> Unit = {}): `[`ColorButton`](-color-button/index.md)<br>DSL builder for a button that opens a color palette popup. |
| [combobox](combobox.md) | `fun `[`Container`](-container/index.md)`.combobox(init: `[`Combobox`](-combobox/index.md)`.() -> Unit = {}): `[`Combobox`](-combobox/index.md)<br>DSL builder for a drop down combo box that allow list selection only. |
| [datepicker](datepicker.md) | `fun `[`Container`](-container/index.md)`.datepicker(init: `[`DatePicker`](-date-picker/index.md)`.() -> Unit = {}): `[`DatePicker`](-date-picker/index.md)<br>DSL builder for a widget to edit date. |
| [datetimepicker](datetimepicker.md) | `fun `[`Container`](-container/index.md)`.datetimepicker(init: `[`DateTimePicker`](-date-time-picker/index.md)`.() -> Unit = {}): `[`DateTimePicker`](-date-time-picker/index.md)<br>DSL builder for a widget to edit date and time. |
| [drawarea](drawarea.md) | `fun `[`Container`](-container/index.md)`.drawarea(init: `[`DrawArea`](-draw-area/index.md)`.() -> Unit = {}): `[`DrawArea`](-draw-area/index.md)<br>DSL builder for a canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](editablecombobox.md) | `fun `[`Container`](-container/index.md)`.editablecombobox(init: `[`EditableCombobox`](-editable-combobox/index.md)`.() -> Unit = {}): `[`EditableCombobox`](-editable-combobox/index.md)<br>DSL builder for a drop down combo box that allow selection from list or free text entry. |
| [fontbutton](fontbutton.md) | `fun `[`Container`](-container/index.md)`.fontbutton(init: `[`FontButton`](-font-button/index.md)`.() -> Unit = {}): `[`FontButton`](-font-button/index.md)<br>DSL builder for a button that allows users to choose a font when they click on it. |
| [form](form.md) | `fun `[`Container`](-container/index.md)`.form(padded: Boolean = true, init: `[`Form`](-form/index.md)`.() -> Unit = {}): `[`Form`](-form/index.md)<br>DSL builder for a container that organize children as labeled fields. |
| [gridpane](gridpane.md) | `fun `[`Container`](-container/index.md)`.gridpane(padded: Boolean = true, init: `[`GridPane`](-grid-pane/index.md)`.() -> Unit = {}): `[`GridPane`](-grid-pane/index.md)<br>DSL builder for a powerful container that allow to specify size and position of each children. |
| [group](group.md) | `fun `[`Container`](-container/index.md)`.group(title: String, margined: Boolean = true, init: `[`Group`](-group/index.md)`.() -> Unit = {}): `[`Group`](-group/index.md)<br>DSL builder for a container for a single widget that provide a caption and visually group it's children. |
| [hbox](hbox.md) | `fun `[`Container`](-container/index.md)`.hbox(padded: Boolean = true, init: `[`HBox`](-h-box/index.md)`.() -> Unit = {}): `[`HBox`](-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [label](label.md) | `fun `[`Container`](-container/index.md)`.label(text: String, init: `[`Label`](-label/index.md)`.() -> Unit = {}): `[`Label`](-label/index.md)<br>DSL builder for a static text label. |
| [onShouldQuit](on-should-quit.md) | `fun onShouldQuit(block: () -> Boolean): Unit`<br>Function to be executed when the OS wants the program to quit or when a Quit menu item has been clicked. Only one function may be registered at a time. |
| [onTimer](on-timer.md) | `fun onTimer(milliseconds: Int, block: () -> Boolean): Unit`<br>Function to be executed on a timer on the main thread. |
| [page](page.md) | `fun `[`TabPane`](-tab-pane/index.md)`.page(label: String, margined: Boolean = true, init: `[`Page`](-tab-pane/-page/index.md)`.() -> Unit = {}): `[`Page`](-tab-pane/-page/index.md) |
| [passwordfield](passwordfield.md) | `fun `[`Container`](-container/index.md)`.passwordfield(readonly: Boolean = false, init: `[`PasswordField`](-password-field/index.md)`.() -> Unit = {}): `[`PasswordField`](-password-field/index.md)<br>DSL builder for a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](progressbar.md) | `fun `[`Container`](-container/index.md)`.progressbar(init: `[`ProgressBar`](-progress-bar/index.md)`.() -> Unit = {}): `[`ProgressBar`](-progress-bar/index.md)<br>DSL builder for a progress bar widget. |
| [radiobuttons](radiobuttons.md) | `fun `[`Container`](-container/index.md)`.radiobuttons(init: `[`RadioButtons`](-radio-buttons/index.md)`.() -> Unit = {}): `[`RadioButtons`](-radio-buttons/index.md)<br>DSL builder for a widget that represent a group of radio options. |
| [random](random.md) | `fun random(): Int` |
| [scrollingarea](scrollingarea.md) | `fun `[`Container`](-container/index.md)`.scrollingarea(width: Int, height: Int, init: `[`ScrollingArea`](-scrolling-area/index.md)`.() -> Unit = {}): `[`ScrollingArea`](-scrolling-area/index.md)<br>DSL builder for a canvas with horziontal and vertical scrollbars. |
| [searchfield](searchfield.md) | `fun `[`Container`](-container/index.md)`.searchfield(readonly: Boolean = false, init: `[`SearchField`](-search-field/index.md)`.() -> Unit = {}): `[`SearchField`](-search-field/index.md)<br>DSL builder for a text entry widget to search text. |
| [separator](separator.md) | `fun `[`VBox`](-v-box/index.md)`.separator(init: `[`HorizontalSeparator`](-horizontal-separator/index.md)`.() -> Unit = {}): `[`HorizontalSeparator`](-horizontal-separator/index.md)<br>DSL builder for an horizontal line to visually separate widgets.`fun `[`HBox`](-h-box/index.md)`.separator(init: `[`VerticalSeparator`](-vertical-separator/index.md)`.() -> Unit = {}): `[`VerticalSeparator`](-vertical-separator/index.md)<br>DSL builder for a vertical line to visually separate widgets. |
| [slider](slider.md) | `fun `[`Container`](-container/index.md)`.slider(min: Int, max: Int, init: `[`Slider`](-slider/index.md)`.() -> Unit = {}): `[`Slider`](-slider/index.md)<br>DSL builder for an horizontal slide to set numerical values. |
| [spinbox](spinbox.md) | `fun `[`Container`](-container/index.md)`.spinbox(min: Int, max: Int, init: `[`Spinbox`](-spinbox/index.md)`.() -> Unit = {}): `[`Spinbox`](-spinbox/index.md)<br>DSL builder for an entry widget for numerical values. |
| [tableview](tableview.md) | `fun <T> `[`Container`](-container/index.md)`.tableview(data: List<`[`T`](tableview.md#T)`>, init: `[`Table`](-table/index.md)`<`[`T`](tableview.md#T)`>.() -> Unit = {}): `[`TableView`](-table-view/index.md)<br>DSL builder to visualize data in a tabular form. |
| [tabpane](tabpane.md) | `fun `[`Container`](-container/index.md)`.tabpane(init: `[`TabPane`](-tab-pane/index.md)`.() -> Unit = {}): `[`TabPane`](-tab-pane/index.md)<br>DSL builder for a container that show each children in a separate tab. |
| [textarea](textarea.md) | `fun `[`Container`](-container/index.md)`.textarea(wrap: Boolean = true, init: `[`TextArea`](-text-area/index.md)`.() -> Unit = {}): `[`TextArea`](-text-area/index.md)<br>DSL builder for a multiline plain text editing widget. |
| [textfield](textfield.md) | `fun `[`Container`](-container/index.md)`.textfield(readonly: Boolean = false, init: `[`TextField`](-text-field/index.md)`.() -> Unit = {}): `[`TextField`](-text-field/index.md)<br>DSL builder for a simple single line text entry widget. |
| [timepicker](timepicker.md) | `fun `[`Container`](-container/index.md)`.timepicker(init: `[`TimePicker`](-time-picker/index.md)`.() -> Unit = {}): `[`TimePicker`](-time-picker/index.md)<br>DSL builder for a widget to edit time. |
| [vbox](vbox.md) | `fun `[`Container`](-container/index.md)`.vbox(padded: Boolean = true, init: `[`VBox`](-v-box/index.md)`.() -> Unit = {}): `[`VBox`](-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |
