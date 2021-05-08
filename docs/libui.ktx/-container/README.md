[libui.ktx](../README.md) / [Container](README.md)

# Container

`interface Container`

Container for child controls.

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `abstract fun <T : `[`Control`](../-control/README.md)`<*>> add(widget: `[`T`](add.md#T)`): `[`T`](add.md#T) |

### Extension properties

| Name | Summary |
|---|---|
| [hbox](../hbox.md) | `val `[`Container`](README.md)`.hbox: `[`HBox`](../-h-box/README.md)<br>DSL builder for a container that stack its children horizontally. |
| [vbox](../vbox.md) | `val `[`Container`](README.md)`.vbox: `[`VBox`](../-v-box/README.md)<br>DSL builder for a container that stack its children vertically. |

### Extension functions

| Name | Summary |
|---|---|
| [button](../button.md) | `fun `[`Container`](README.md)`.button(text: String, init: `[`Button`](../-button/README.md)`.() -> Unit = {}): `[`Button`](../-button/README.md)<br>DSL builder for a simple button. |
| [checkbox](../checkbox.md) | `fun `[`Container`](README.md)`.checkbox(label: String, init: `[`Checkbox`](../-checkbox/README.md)`.() -> Unit = {}): `[`Checkbox`](../-checkbox/README.md)<br>DSL builder for a checkbox widget. |
| [colorbutton](../colorbutton.md) | `fun `[`Container`](README.md)`.colorbutton(init: `[`ColorButton`](../-color-button/README.md)`.() -> Unit = {}): `[`ColorButton`](../-color-button/README.md)<br>DSL builder for a button that opens a color palette popup. |
| [combobox](../combobox.md) | `fun `[`Container`](README.md)`.combobox(init: `[`Combobox`](../-combobox/README.md)`.() -> Unit = {}): `[`Combobox`](../-combobox/README.md)<br>DSL builder for a drop down combo box that allow list selection only. |
| [datepicker](../datepicker.md) | `fun `[`Container`](README.md)`.datepicker(init: `[`DatePicker`](../-date-picker/README.md)`.() -> Unit = {}): `[`DatePicker`](../-date-picker/README.md)<br>DSL builder for a widget to edit date. |
| [datetimepicker](../datetimepicker.md) | `fun `[`Container`](README.md)`.datetimepicker(init: `[`DateTimePicker`](../-date-time-picker/README.md)`.() -> Unit = {}): `[`DateTimePicker`](../-date-time-picker/README.md)<br>DSL builder for a widget to edit date and time. |
| [drawarea](../drawarea.md) | `fun `[`Container`](README.md)`.drawarea(init: `[`DrawArea`](../-draw-area/README.md)`.() -> Unit = {}): `[`DrawArea`](../-draw-area/README.md)<br>DSL builder for a canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](../editablecombobox.md) | `fun `[`Container`](README.md)`.editablecombobox(init: `[`EditableCombobox`](../-editable-combobox/README.md)`.() -> Unit = {}): `[`EditableCombobox`](../-editable-combobox/README.md)<br>DSL builder for a drop down combo box that allow selection from list or free text entry. |
| [fontbutton](../fontbutton.md) | `fun `[`Container`](README.md)`.fontbutton(init: `[`FontButton`](../-font-button/README.md)`.() -> Unit = {}): `[`FontButton`](../-font-button/README.md)<br>DSL builder for a button that allows users to choose a font when they click on it. |
| [form](../form.md) | `fun `[`Container`](README.md)`.form(padded: Boolean = true, init: `[`Form`](../-form/README.md)`.() -> Unit = {}): `[`Form`](../-form/README.md)<br>DSL builder for a container that organize children as labeled fields. |
| [gridpane](../gridpane.md) | `fun `[`Container`](README.md)`.gridpane(padded: Boolean = true, init: `[`GridPane`](../-grid-pane/README.md)`.() -> Unit = {}): `[`GridPane`](../-grid-pane/README.md)<br>DSL builder for a powerful container that allow to specify size and position of each children. |
| [group](../group.md) | `fun `[`Container`](README.md)`.group(title: String, margined: Boolean = true, init: `[`Group`](../-group/README.md)`.() -> Unit = {}): `[`Group`](../-group/README.md)<br>DSL builder for a container for a single widget that provide a caption and visually group it's children. |
| [hbox](../hbox.md) | `fun `[`Container`](README.md)`.hbox(padded: Boolean = true, init: `[`HBox`](../-h-box/README.md)`.() -> Unit = {}): `[`HBox`](../-h-box/README.md)<br>DSL builder for a container that stack its children horizontally. |
| [label](../label.md) | `fun `[`Container`](README.md)`.label(text: String, init: `[`Label`](../-label/README.md)`.() -> Unit = {}): `[`Label`](../-label/README.md)<br>DSL builder for a static text label. |
| [passwordfield](../passwordfield.md) | `fun `[`Container`](README.md)`.passwordfield(readonly: Boolean = false, init: `[`PasswordField`](../-password-field/README.md)`.() -> Unit = {}): `[`PasswordField`](../-password-field/README.md)<br>DSL builder for a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](../progressbar.md) | `fun `[`Container`](README.md)`.progressbar(init: `[`ProgressBar`](../-progress-bar/README.md)`.() -> Unit = {}): `[`ProgressBar`](../-progress-bar/README.md)<br>DSL builder for a progress bar widget. |
| [radiobuttons](../radiobuttons.md) | `fun `[`Container`](README.md)`.radiobuttons(init: `[`RadioButtons`](../-radio-buttons/README.md)`.() -> Unit = {}): `[`RadioButtons`](../-radio-buttons/README.md)<br>DSL builder for a widget that represent a group of radio options. |
| [scrollingarea](../scrollingarea.md) | `fun `[`Container`](README.md)`.scrollingarea(width: Int, height: Int, init: `[`ScrollingArea`](../-scrolling-area/README.md)`.() -> Unit = {}): `[`ScrollingArea`](../-scrolling-area/README.md)<br>DSL builder for a canvas with horziontal and vertical scrollbars. |
| [searchfield](../searchfield.md) | `fun `[`Container`](README.md)`.searchfield(readonly: Boolean = false, init: `[`SearchField`](../-search-field/README.md)`.() -> Unit = {}): `[`SearchField`](../-search-field/README.md)<br>DSL builder for a text entry widget to search text. |
| [slider](../slider.md) | `fun `[`Container`](README.md)`.slider(min: Int, max: Int, init: `[`Slider`](../-slider/README.md)`.() -> Unit = {}): `[`Slider`](../-slider/README.md)<br>DSL builder for an horizontal slide to set numerical values. |
| [spinbox](../spinbox.md) | `fun `[`Container`](README.md)`.spinbox(min: Int, max: Int, init: `[`Spinbox`](../-spinbox/README.md)`.() -> Unit = {}): `[`Spinbox`](../-spinbox/README.md)<br>DSL builder for an entry widget for numerical values. |
| [tableview](../tableview.md) | `fun <T> `[`Container`](README.md)`.tableview(data: List<`[`T`](../tableview.md#T)`>, init: `[`Table`](../-table/README.md)`<`[`T`](../tableview.md#T)`>.() -> Unit = {}): `[`TableView`](../-table-view/README.md)<br>DSL builder to visualize data in a tabular form. |
| [tabpane](../tabpane.md) | `fun `[`Container`](README.md)`.tabpane(init: `[`TabPane`](../-tab-pane/README.md)`.() -> Unit = {}): `[`TabPane`](../-tab-pane/README.md)<br>DSL builder for a container that show each children in a separate tab. |
| [textarea](../textarea.md) | `fun `[`Container`](README.md)`.textarea(wrap: Boolean = true, init: `[`TextArea`](../-text-area/README.md)`.() -> Unit = {}): `[`TextArea`](../-text-area/README.md)<br>DSL builder for a multiline plain text editing widget. |
| [textfield](../textfield.md) | `fun `[`Container`](README.md)`.textfield(readonly: Boolean = false, init: `[`TextField`](../-text-field/README.md)`.() -> Unit = {}): `[`TextField`](../-text-field/README.md)<br>DSL builder for a simple single line text entry widget. |
| [timepicker](../timepicker.md) | `fun `[`Container`](README.md)`.timepicker(init: `[`TimePicker`](../-time-picker/README.md)`.() -> Unit = {}): `[`TimePicker`](../-time-picker/README.md)<br>DSL builder for a widget to edit time. |
| [vbox](../vbox.md) | `fun `[`Container`](README.md)`.vbox(padded: Boolean = true, init: `[`VBox`](../-v-box/README.md)`.() -> Unit = {}): `[`VBox`](../-v-box/README.md)<br>DSL builder for a container that stack its children vertically. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/README.md) | `abstract class Box : `[`Control`](../-control/README.md)`<`[`uiBox`](../../libui/ui-box.md)`>, `[`Container`](README.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) - a container that stack its children horizontally or vertically. |
| [Form](../-form/README.md) | `class Form : `[`Control`](../-control/README.md)`<`[`uiForm`](../../libui/ui-form.md)`>, `[`Container`](README.md)<br>Wrapper class for [uiForm](../../libui/ui-form.md) - a container that organize children as labeled fields. |
| [GridPane](../-grid-pane/README.md) | `class GridPane : `[`Control`](../-control/README.md)`<`[`uiGrid`](../../libui/ui-grid.md)`>, `[`Container`](README.md)<br>Wrapper class for [uiGrid](../../libui/ui-grid.md) - a powerful container that allow to specify size and position of each children. |
| [Group](../-group/README.md) | `class Group : `[`Control`](../-control/README.md)`<`[`uiGroup`](../../libui/ui-group.md)`>, `[`Container`](README.md)<br>Wrapper class for [uiGroup](../../libui/ui-group.md) - a container for a single widget that provide a caption and visually group it's children. |
| [Page](../-tab-pane/-page/README.md) | `inner class Page : `[`Container`](README.md)<br>adapter for DSL builders |
| [Window](../-window/README.md) | `class Window : `[`Control`](../-control/README.md)`<`[`uiWindow`](../../libui/ui-window.md)`>, `[`Container`](README.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
