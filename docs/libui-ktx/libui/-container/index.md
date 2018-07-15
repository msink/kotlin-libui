[libui-ktx](../../index.md) / [libui](../index.md) / [Container](./index.md)

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
| [hbox](../hbox.md) | `val `[`Container`](./index.md)`.hbox: `[`HBox`](../-h-box/index.md) |
| [vbox](../vbox.md) | `val `[`Container`](./index.md)`.vbox: `[`VBox`](../-v-box/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [button](../button.md) | `fun `[`Container`](./index.md)`.button(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Button`](../-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A simple button. |
| [checkbox](../checkbox.md) | `fun `[`Container`](./index.md)`.checkbox(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Checkbox`](../-checkbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A checkbox widget. |
| [colorbutton](../colorbutton.md) | `fun `[`Container`](./index.md)`.colorbutton(init: `[`ColorButton`](../-color-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A button that opens a color palette popup. |
| [combobox](../combobox.md) | `fun `[`Container`](./index.md)`.combobox(init: `[`Combobox`](../-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A drop down combo box that allow list selection only. |
| [datepicker](../datepicker.md) | `fun `[`Container`](./index.md)`.datepicker(init: `[`DatePicker`](../-date-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A widget to edit date. |
| [datetimepicker](../datetimepicker.md) | `fun `[`Container`](./index.md)`.datetimepicker(init: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A widget to edit date and time. |
| [drawarea](../drawarea.md) | `fun `[`Container`](./index.md)`.drawarea(init: `[`DrawArea`](../-draw-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DrawArea`](../-draw-area/index.md)<br>A canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](../editablecombobox.md) | `fun `[`Container`](./index.md)`.editablecombobox(init: `[`EditableCombobox`](../-editable-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A drop down combo box that allow selection from list or free text entry. |
| [fontbutton](../fontbutton.md) | `fun `[`Container`](./index.md)`.fontbutton(init: `[`FontButton`](../-font-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A button that allows users to choose a font when they click on it. |
| [form](../form.md) | `fun `[`Container`](./index.md)`.form(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Form`](../-form/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A container that organize children as labeled fields. |
| [gridpane](../gridpane.md) | `fun `[`Container`](./index.md)`.gridpane(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`GridPane`](../-grid-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A powerful container that allow to specify size and position of each children. |
| [group](../group.md) | `fun `[`Container`](./index.md)`.group(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): <ERROR CLASS>`<br>A container for a single widget that provide a caption and visually group it's children. |
| [hbox](../hbox.md) | `fun `[`Container`](./index.md)`.hbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`HBox`](../-h-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A container that stack its children horizontally. |
| [label](../label.md) | `fun `[`Container`](./index.md)`.label(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Label`](../-label/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A static text label. |
| [passwordfield](../passwordfield.md) | `fun `[`Container`](./index.md)`.passwordfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`PasswordField`](../-password-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](../progressbar.md) | `fun `[`Container`](./index.md)`.progressbar(init: `[`ProgressBar`](../-progress-bar/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Progress bar widget. |
| [radiobuttons](../radiobuttons.md) | `fun `[`Container`](./index.md)`.radiobuttons(init: `[`RadioButtons`](../-radio-buttons/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A widget that represent a group of radio options. |
| [scrollingarea](../scrollingarea.md) | `fun `[`Container`](./index.md)`.scrollingarea(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`ScrollingArea`](../-scrolling-area.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ScrollingArea`](../-scrolling-area.md)<br>[DrawArea](../-draw-area/index.md) with horziontal and vertical scrollbars. |
| [searchfield](../searchfield.md) | `fun `[`Container`](./index.md)`.searchfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`SearchField`](../-search-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Text entry widget to search text. |
| [slider](../slider.md) | `fun `[`Container`](./index.md)`.slider(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Slider`](../-slider/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Horizontal slide to set numerical values. |
| [spinbox](../spinbox.md) | `fun `[`Container`](./index.md)`.spinbox(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Spinbox`](../-spinbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>An entry widget for numerical values. |
| [tableview](../tableview.md) | `fun <T> `[`Container`](./index.md)`.tableview(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../tableview.md#T)`>, init: `[`Table`](../-table/index.md)`<`[`T`](../tableview.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TableView`](../-table-view/index.md) |
| [tabpane](../tabpane.md) | `fun `[`Container`](./index.md)`.tabpane(init: `[`TabPane`](../-tab-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A container that show each children in a separate tab. |
| [textarea](../textarea.md) | `fun `[`Container`](./index.md)`.textarea(wrap: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextArea`](../-text-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A multiline plain text editing widget. |
| [textfield](../textfield.md) | `fun `[`Container`](./index.md)`.textfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextField`](../-text-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A simple single line text entry widget. |
| [timepicker](../timepicker.md) | `fun `[`Container`](./index.md)`.timepicker(init: `[`TimePicker`](../-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A widget to edit time. |
| [vbox](../vbox.md) | `fun `[`Container`](./index.md)`.vbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`VBox`](../-v-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>A container that stack its children vertically. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](../-control/index.md)`<<ERROR CLASS>>, `[`Container`](./index.md) |
| [Cell](../-grid-pane/-cell/index.md) | `inner class Cell : `[`Container`](./index.md)<br>adapter for DSL builders |
| [Field](../-form/-field/index.md) | `inner class Field : `[`Container`](./index.md)<br>adapter for DSL builders |
| [Field](../-form/-stretchy/-field/index.md) | `inner class Field : `[`Container`](./index.md) |
| [Group](../-group/index.md) | `class Group : `[`Control`](../-control/index.md)`<<ERROR CLASS>>, `[`Container`](./index.md) |
| [Page](../-tab-pane/-page/index.md) | `inner class Page : `[`Container`](./index.md)<br>adapter for DSL builders |
| [Stretchy](../-box/-stretchy/index.md) | `inner class Stretchy : `[`Container`](./index.md)<br>adapter for DSL builders |
| [Window](../-window/index.md) | `class Window : `[`Control`](../-control/index.md)`<<ERROR CLASS>>, `[`Container`](./index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
