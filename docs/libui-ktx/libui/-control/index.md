[libui-ktx](../../index.md) / [libui](../index.md) / [Control](./index.md)

# Control

`abstract class Control<T : `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`> : `[`Disposable`](../-disposable/index.md)`<`[`T`](index.md#T)`>`

Base class for all GUI controls (widgets).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Control(alloc: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](index.md#T)`>?)`<br>Base class for all GUI controls (widgets). |

### Properties

| Name | Summary |
|---|---|
| [ctl](ctl.md) | `val ctl: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](../ui-control/index.md)`>` |
| [enabled](enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](parent.md) | `var parent: `[`Control`](./index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [disable](disable.md) | `fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disables the Control. |
| [dispose](dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated resources. |
| [enable](enable.md) | `fun enable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Enables the Control. |
| [getHandle](get-handle.md) | `fun getHandle(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the OS-level handle associated with this Control. |
| [hide](hide.md) | `fun hide(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](is-enabled.md) | `fun isEnabled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is enabled. |
| [isEnabledToUser](is-enabled-to-user.md) | `fun isEnabledToUser(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control and all parents are enabled. |
| [isVisible](is-visible.md) | `fun isVisible(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is visible. |
| [show](show.md) | `fun show(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Shows the Control. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](./index.md)`<`[`uiBox`](../ui-box.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiBox](../ui-box.md) |
| [Button](../-button/index.md) | `class Button : `[`Control`](./index.md)`<`[`uiButton`](../ui-button.md)`>`<br>Wrapper class for [uiButton](../ui-button.md) |
| [Checkbox](../-checkbox/index.md) | `class Checkbox : `[`Control`](./index.md)`<`[`uiCheckbox`](../ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../ui-checkbox.md) |
| [ColorButton](../-color-button/index.md) | `class ColorButton : `[`Control`](./index.md)`<`[`uiColorButton`](../ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../ui-color-button.md) |
| [Combobox](../-combobox/index.md) | `class Combobox : `[`Control`](./index.md)`<`[`uiCombobox`](../ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../ui-combobox.md) |
| [DateTimePicker](../-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](./index.md)`<`[`uiDateTimePicker`](../ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../ui-date-time-picker.md) to edit date and time. |
| [DrawArea](../-draw-area/index.md) | `open class DrawArea : `[`Control`](./index.md)`<`[`uiArea`](../ui-area.md)`>`<br>Wrapper class for [uiArea](../ui-area.md) |
| [EditableCombobox](../-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](./index.md)`<`[`uiEditableCombobox`](../ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../ui-editable-combobox.md) |
| [FontButton](../-font-button/index.md) | `class FontButton : `[`Control`](./index.md)`<`[`uiFontButton`](../ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../ui-font-button.md) |
| [Form](../-form/index.md) | `class Form : `[`Control`](./index.md)`<`[`uiForm`](../ui-form.md)`>`<br>Wrapper class for [uiForm](../ui-form.md) |
| [GridPane](../-grid-pane/index.md) | `class GridPane : `[`Control`](./index.md)`<`[`uiGrid`](../ui-grid.md)`>`<br>Wrapper class for [uiGrid](../ui-grid.md) |
| [Group](../-group/index.md) | `class Group : `[`Control`](./index.md)`<`[`uiGroup`](../ui-group.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiGroup](../ui-group.md) |
| [Label](../-label/index.md) | `class Label : `[`Control`](./index.md)`<`[`uiLabel`](../ui-label.md)`>`<br>Wrapper class for [uiLabel](../ui-label.md) |
| [ProgressBar](../-progress-bar/index.md) | `class ProgressBar : `[`Control`](./index.md)`<`[`uiProgressBar`](../ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../ui-progress-bar.md) |
| [RadioButtons](../-radio-buttons/index.md) | `class RadioButtons : `[`Control`](./index.md)`<`[`uiRadioButtons`](../ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../ui-radio-buttons.md) |
| [Separator](../-separator/index.md) | `abstract class Separator : `[`Control`](./index.md)`<`[`uiSeparator`](../ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../ui-separator.md) |
| [Slider](../-slider/index.md) | `class Slider : `[`Control`](./index.md)`<`[`uiSlider`](../ui-slider.md)`>`<br>Wrapper class for [uiSlider](../ui-slider.md) |
| [Spinbox](../-spinbox/index.md) | `class Spinbox : `[`Control`](./index.md)`<`[`uiSpinbox`](../ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../ui-spinbox.md) |
| [TabPane](../-tab-pane/index.md) | `class TabPane : `[`Control`](./index.md)`<`[`uiTab`](../ui-tab.md)`>`<br>Wrapper class for [uiTab](../ui-tab.md) |
| [TableView](../-table-view/index.md) | `class TableView : `[`Control`](./index.md)`<`[`uiTable`](../ui-table.md)`>`<br>Wrapper class for [uiTable](../ui-table.md) |
| [TextArea](../-text-area/index.md) | `class TextArea : `[`Control`](./index.md)`<`[`uiMultilineEntry`](../ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../ui-multiline-entry.md) |
| [TextField](../-text-field/index.md) | `open class TextField : `[`Control`](./index.md)`<`[`uiEntry`](../ui-entry.md)`>`<br>Wrapper class for [uiEntry](../ui-entry.md) |
| [Window](../-window/index.md) | `class Window : `[`Control`](./index.md)`<`[`uiWindow`](../ui-window.md)`>, `[`Container`](../-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
