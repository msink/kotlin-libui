[libui.ktx](../index.md) / [Container](./index.md)

# Container

`interface Container`

Container for child controls.

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `abstract fun <T : `[`Control`](../-control/index.md)`<*>> add(widget: `[`T`](add.md#T)`): `[`T`](add.md#T) |

### Extension Properties

| Name | Summary |
|---|---|
| [hbox](../hbox.md) | `val `[`Container`](./index.md)`.hbox: `[`HBox`](../-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [vbox](../vbox.md) | `val `[`Container`](./index.md)`.vbox: `[`VBox`](../-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |

### Extension Functions

| Name | Summary |
|---|---|
| [button](../button.md) | `fun `[`Container`](./index.md)`.button(text: String, init: `[`Button`](../-button/index.md)`.() -> Unit = {}): `[`Button`](../-button/index.md)<br>DSL builder for a simple button. |
| [checkbox](../checkbox.md) | `fun `[`Container`](./index.md)`.checkbox(label: String, init: `[`Checkbox`](../-checkbox/index.md)`.() -> Unit = {}): `[`Checkbox`](../-checkbox/index.md)<br>DSL builder for a checkbox widget. |
| [colorbutton](../colorbutton.md) | `fun `[`Container`](./index.md)`.colorbutton(init: `[`ColorButton`](../-color-button/index.md)`.() -> Unit = {}): `[`ColorButton`](../-color-button/index.md)<br>DSL builder for a button that opens a color palette popup. |
| [combobox](../combobox.md) | `fun `[`Container`](./index.md)`.combobox(init: `[`Combobox`](../-combobox/index.md)`.() -> Unit = {}): `[`Combobox`](../-combobox/index.md)<br>DSL builder for a drop down combo box that allow list selection only. |
| [datepicker](../datepicker.md) | `fun `[`Container`](./index.md)`.datepicker(init: `[`DatePicker`](../-date-picker/index.md)`.() -> Unit = {}): `[`DatePicker`](../-date-picker/index.md)<br>DSL builder for a widget to edit date. |
| [datetimepicker](../datetimepicker.md) | `fun `[`Container`](./index.md)`.datetimepicker(init: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> Unit = {}): `[`DateTimePicker`](../-date-time-picker/index.md)<br>DSL builder for a widget to edit date and time. |
| [drawarea](../drawarea.md) | `fun `[`Container`](./index.md)`.drawarea(init: `[`DrawArea`](../-draw-area/index.md)`.() -> Unit = {}): `[`DrawArea`](../-draw-area/index.md)<br>DSL builder for a canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](../editablecombobox.md) | `fun `[`Container`](./index.md)`.editablecombobox(init: `[`EditableCombobox`](../-editable-combobox/index.md)`.() -> Unit = {}): `[`EditableCombobox`](../-editable-combobox/index.md)<br>DSL builder for a drop down combo box that allow selection from list or free text entry. |
| [fontbutton](../fontbutton.md) | `fun `[`Container`](./index.md)`.fontbutton(init: `[`FontButton`](../-font-button/index.md)`.() -> Unit = {}): `[`FontButton`](../-font-button/index.md)<br>DSL builder for a button that allows users to choose a font when they click on it. |
| [form](../form.md) | `fun `[`Container`](./index.md)`.form(padded: Boolean = true, init: `[`Form`](../-form/index.md)`.() -> Unit = {}): `[`Form`](../-form/index.md)<br>DSL builder for a container that organize children as labeled fields. |
| [gridpane](../gridpane.md) | `fun `[`Container`](./index.md)`.gridpane(padded: Boolean = true, init: `[`GridPane`](../-grid-pane/index.md)`.() -> Unit = {}): `[`GridPane`](../-grid-pane/index.md)<br>DSL builder for a powerful container that allow to specify size and position of each children. |
| [group](../group.md) | `fun `[`Container`](./index.md)`.group(title: String, margined: Boolean = true, init: `[`Group`](../-group/index.md)`.() -> Unit = {}): `[`Group`](../-group/index.md)<br>DSL builder for a container for a single widget that provide a caption and visually group it's children. |
| [hbox](../hbox.md) | `fun `[`Container`](./index.md)`.hbox(padded: Boolean = true, init: `[`HBox`](../-h-box/index.md)`.() -> Unit = {}): `[`HBox`](../-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [label](../label.md) | `fun `[`Container`](./index.md)`.label(text: String, init: `[`Label`](../-label/index.md)`.() -> Unit = {}): `[`Label`](../-label/index.md)<br>DSL builder for a static text label. |
| [passwordfield](../passwordfield.md) | `fun `[`Container`](./index.md)`.passwordfield(readonly: Boolean = false, init: `[`PasswordField`](../-password-field/index.md)`.() -> Unit = {}): `[`PasswordField`](../-password-field/index.md)<br>DSL builder for a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](../progressbar.md) | `fun `[`Container`](./index.md)`.progressbar(init: `[`ProgressBar`](../-progress-bar/index.md)`.() -> Unit = {}): `[`ProgressBar`](../-progress-bar/index.md)<br>DSL builder for a progress bar widget. |
| [radiobuttons](../radiobuttons.md) | `fun `[`Container`](./index.md)`.radiobuttons(init: `[`RadioButtons`](../-radio-buttons/index.md)`.() -> Unit = {}): `[`RadioButtons`](../-radio-buttons/index.md)<br>DSL builder for a widget that represent a group of radio options. |
| [scrollingarea](../scrollingarea.md) | `fun `[`Container`](./index.md)`.scrollingarea(width: Int, height: Int, init: `[`ScrollingArea`](../-scrolling-area/index.md)`.() -> Unit = {}): `[`ScrollingArea`](../-scrolling-area/index.md)<br>DSL builder for a canvas with horziontal and vertical scrollbars. |
| [searchfield](../searchfield.md) | `fun `[`Container`](./index.md)`.searchfield(readonly: Boolean = false, init: `[`SearchField`](../-search-field/index.md)`.() -> Unit = {}): `[`SearchField`](../-search-field/index.md)<br>DSL builder for a text entry widget to search text. |
| [slider](../slider.md) | `fun `[`Container`](./index.md)`.slider(min: Int, max: Int, init: `[`Slider`](../-slider/index.md)`.() -> Unit = {}): `[`Slider`](../-slider/index.md)<br>DSL builder for an horizontal slide to set numerical values. |
| [spinbox](../spinbox.md) | `fun `[`Container`](./index.md)`.spinbox(min: Int, max: Int, init: `[`Spinbox`](../-spinbox/index.md)`.() -> Unit = {}): `[`Spinbox`](../-spinbox/index.md)<br>DSL builder for an entry widget for numerical values. |
| [tableview](../tableview.md) | `fun <T> `[`Container`](./index.md)`.tableview(data: List<`[`T`](../tableview.md#T)`>, init: `[`Table`](../-table/index.md)`<`[`T`](../tableview.md#T)`>.() -> Unit = {}): `[`TableView`](../-table-view/index.md)<br>DSL builder to visualize data in a tabular form. |
| [tabpane](../tabpane.md) | `fun `[`Container`](./index.md)`.tabpane(init: `[`TabPane`](../-tab-pane/index.md)`.() -> Unit = {}): `[`TabPane`](../-tab-pane/index.md)<br>DSL builder for a container that show each children in a separate tab. |
| [textarea](../textarea.md) | `fun `[`Container`](./index.md)`.textarea(wrap: Boolean = true, init: `[`TextArea`](../-text-area/index.md)`.() -> Unit = {}): `[`TextArea`](../-text-area/index.md)<br>DSL builder for a multiline plain text editing widget. |
| [textfield](../textfield.md) | `fun `[`Container`](./index.md)`.textfield(readonly: Boolean = false, init: `[`TextField`](../-text-field/index.md)`.() -> Unit = {}): `[`TextField`](../-text-field/index.md)<br>DSL builder for a simple single line text entry widget. |
| [timepicker](../timepicker.md) | `fun `[`Container`](./index.md)`.timepicker(init: `[`TimePicker`](../-time-picker/index.md)`.() -> Unit = {}): `[`TimePicker`](../-time-picker/index.md)<br>DSL builder for a widget to edit time. |
| [vbox](../vbox.md) | `fun `[`Container`](./index.md)`.vbox(padded: Boolean = true, init: `[`VBox`](../-v-box/index.md)`.() -> Unit = {}): `[`VBox`](../-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](../-control/index.md)`<`[`uiBox`](../../libui/ui-box.md)`>, `[`Container`](./index.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) - a container that stack its children horizontally or vertically. |
| [Form](../-form/index.md) | `class Form : `[`Control`](../-control/index.md)`<`[`uiForm`](../../libui/ui-form.md)`>, `[`Container`](./index.md)<br>Wrapper class for [uiForm](../../libui/ui-form.md) - a container that organize children as labeled fields. |
| [GridPane](../-grid-pane/index.md) | `class GridPane : `[`Control`](../-control/index.md)`<`[`uiGrid`](../../libui/ui-grid.md)`>, `[`Container`](./index.md)<br>Wrapper class for [uiGrid](../../libui/ui-grid.md) - a powerful container that allow to specify size and position of each children. |
| [Group](../-group/index.md) | `class Group : `[`Control`](../-control/index.md)`<`[`uiGroup`](../../libui/ui-group.md)`>, `[`Container`](./index.md)<br>Wrapper class for [uiGroup](../../libui/ui-group.md) - a container for a single widget that provide a caption and visually group it's children. |
| [Page](../-tab-pane/-page/index.md) | `inner class Page : `[`Container`](./index.md)<br>adapter for DSL builders |
| [Window](../-window/index.md) | `class Window : `[`Control`](../-control/index.md)`<`[`uiWindow`](../../libui/ui-window.md)`>, `[`Container`](./index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
