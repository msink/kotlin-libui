[libui.ktx](../index.md) / [Box](./index.md)

# Box

`abstract class Box : `[`Control`](../-control/index.md)`<`[`uiBox`](../../libui/ui-box.md)`>, `[`Container`](../-container/index.md)

Wrapper class for [uiBox](../../libui/ui-box.md)

### Types

| Name | Summary |
|---|---|
| [Stretchy](-stretchy/index.md) | `inner class Stretchy : `[`Container`](../-container/index.md)<br>adapter for DSL builders |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Box(alloc: CPointer<`[`uiBox`](../../libui/ui-box.md)`>?)`<br>Wrapper class for [uiBox](../../libui/ui-box.md) |

### Properties

| Name | Summary |
|---|---|
| [padded](padded.md) | `var padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If `true`, the container insert some space between children. |

### Inherited Properties

| Name | Summary |
|---|---|
| [ctl](../-control/ctl.md) | `val ctl: CPointer<`[`uiControl`](../../libui/ui-control/index.md)`>` |
| [enabled](../-control/enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `open fun <T : `[`Control`](../-control/index.md)`<*>> add(widget: `[`T`](add.md#T)`): `[`T`](add.md#T)<br>Adds the given widget to the end of the Box. |
| [delete](delete.md) | `fun delete(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes the nth control of the Box. |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Shows the Control. |

### Extension Properties

| Name | Summary |
|---|---|
| [hbox](../hbox.md) | `val `[`Container`](../-container/index.md)`.hbox: `[`HBox`](../-h-box/index.md) |
| [stretchy](../stretchy.md) | `val `[`Box`](./index.md)`.stretchy: `[`Stretchy`](-stretchy/index.md) |
| [vbox](../vbox.md) | `val `[`Container`](../-container/index.md)`.vbox: `[`VBox`](../-v-box/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [button](../button.md) | `fun `[`Container`](../-container/index.md)`.button(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Button`](../-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Button`](../-button/index.md)<br>A simple button. |
| [checkbox](../checkbox.md) | `fun `[`Container`](../-container/index.md)`.checkbox(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Checkbox`](../-checkbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Checkbox`](../-checkbox/index.md)<br>A checkbox widget. |
| [colorbutton](../colorbutton.md) | `fun `[`Container`](../-container/index.md)`.colorbutton(init: `[`ColorButton`](../-color-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ColorButton`](../-color-button/index.md)<br>A button that opens a color palette popup. |
| [combobox](../combobox.md) | `fun `[`Container`](../-container/index.md)`.combobox(init: `[`Combobox`](../-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Combobox`](../-combobox/index.md)<br>A drop down combo box that allow list selection only. |
| [datepicker](../datepicker.md) | `fun `[`Container`](../-container/index.md)`.datepicker(init: `[`DatePicker`](../-date-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DatePicker`](../-date-picker/index.md)<br>A widget to edit date. |
| [datetimepicker](../datetimepicker.md) | `fun `[`Container`](../-container/index.md)`.datetimepicker(init: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DateTimePicker`](../-date-time-picker/index.md)<br>A widget to edit date and time. |
| [drawarea](../drawarea.md) | `fun `[`Container`](../-container/index.md)`.drawarea(init: `[`DrawArea`](../-draw-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DrawArea`](../-draw-area/index.md)<br>A canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](../editablecombobox.md) | `fun `[`Container`](../-container/index.md)`.editablecombobox(init: `[`EditableCombobox`](../-editable-combobox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`EditableCombobox`](../-editable-combobox/index.md)<br>A drop down combo box that allow selection from list or free text entry. |
| [fontbutton](../fontbutton.md) | `fun `[`Container`](../-container/index.md)`.fontbutton(init: `[`FontButton`](../-font-button/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`FontButton`](../-font-button/index.md)<br>A button that allows users to choose a font when they click on it. |
| [form](../form.md) | `fun `[`Container`](../-container/index.md)`.form(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Form`](../-form/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Form`](../-form/index.md)<br>A container that organize children as labeled fields. |
| [gridpane](../gridpane.md) | `fun `[`Container`](../-container/index.md)`.gridpane(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`GridPane`](../-grid-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`GridPane`](../-grid-pane/index.md)<br>A powerful container that allow to specify size and position of each children. |
| [group](../group.md) | `fun `[`Container`](../-container/index.md)`.group(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Group`](../-group/index.md)<br>A container for a single widget that provide a caption and visually group it's children. |
| [hbox](../hbox.md) | `fun `[`Container`](../-container/index.md)`.hbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`HBox`](../-h-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`HBox`](../-h-box/index.md)<br>A container that stack its children horizontally. |
| [label](../label.md) | `fun `[`Container`](../-container/index.md)`.label(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`Label`](../-label/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Label`](../-label/index.md)<br>A static text label. |
| [passwordfield](../passwordfield.md) | `fun `[`Container`](../-container/index.md)`.passwordfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`PasswordField`](../-password-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`PasswordField`](../-password-field/index.md)<br>Text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](../progressbar.md) | `fun `[`Container`](../-container/index.md)`.progressbar(init: `[`ProgressBar`](../-progress-bar/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ProgressBar`](../-progress-bar/index.md)<br>Progress bar widget. |
| [radiobuttons](../radiobuttons.md) | `fun `[`Container`](../-container/index.md)`.radiobuttons(init: `[`RadioButtons`](../-radio-buttons/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`RadioButtons`](../-radio-buttons/index.md)<br>A widget that represent a group of radio options. |
| [scrollingarea](../scrollingarea.md) | `fun `[`Container`](../-container/index.md)`.scrollingarea(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`ScrollingArea`](../-scrolling-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`ScrollingArea`](../-scrolling-area/index.md)<br>[DrawArea](../-draw-area/index.md) with horziontal and vertical scrollbars. |
| [searchfield](../searchfield.md) | `fun `[`Container`](../-container/index.md)`.searchfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`SearchField`](../-search-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`SearchField`](../-search-field/index.md)<br>Text entry widget to search text. |
| [slider](../slider.md) | `fun `[`Container`](../-container/index.md)`.slider(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Slider`](../-slider/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Slider`](../-slider/index.md)<br>Horizontal slide to set numerical values. |
| [spinbox](../spinbox.md) | `fun `[`Container`](../-container/index.md)`.spinbox(min: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: `[`Spinbox`](../-spinbox/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Spinbox`](../-spinbox/index.md)<br>An entry widget for numerical values. |
| [stretchy](../stretchy.md) | `fun `[`Box`](./index.md)`.stretchy(init: `[`Stretchy`](-stretchy/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Stretchy`](-stretchy/index.md) |
| [tableview](../tableview.md) | `fun <T> `[`Container`](../-container/index.md)`.tableview(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../tableview.md#T)`>, init: `[`Table`](../-table/index.md)`<`[`T`](../tableview.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TableView`](../-table-view/index.md) |
| [tabpane](../tabpane.md) | `fun `[`Container`](../-container/index.md)`.tabpane(init: `[`TabPane`](../-tab-pane/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TabPane`](../-tab-pane/index.md)<br>A container that show each children in a separate tab. |
| [textarea](../textarea.md) | `fun `[`Container`](../-container/index.md)`.textarea(wrap: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextArea`](../-text-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TextArea`](../-text-area/index.md)<br>A multiline plain text editing widget. |
| [textfield](../textfield.md) | `fun `[`Container`](../-container/index.md)`.textfield(readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, init: `[`TextField`](../-text-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TextField`](../-text-field/index.md)<br>A simple single line text entry widget. |
| [timepicker](../timepicker.md) | `fun `[`Container`](../-container/index.md)`.timepicker(init: `[`TimePicker`](../-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`TimePicker`](../-time-picker/index.md)<br>A widget to edit time. |
| [vbox](../vbox.md) | `fun `[`Container`](../-container/index.md)`.vbox(padded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`VBox`](../-v-box/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`VBox`](../-v-box/index.md)<br>A container that stack its children vertically. |

### Inheritors

| Name | Summary |
|---|---|
| [HBox](../-h-box/index.md) | `class HBox : `[`Box`](./index.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) that stack its children horizontally. |
| [VBox](../-v-box/index.md) | `class VBox : `[`Box`](./index.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) that stack its children vertically. |
