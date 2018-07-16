[libui.ktx](../index.md) / [Control](./index.md)

# Control

`abstract class Control<T : CPointed> : `[`Disposable`](../-disposable/index.md)`<`[`T`](index.md#T)`>`

Base class for all GUI controls (widgets).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Control(alloc: CPointer<`[`T`](index.md#T)`>?)`<br>Base class for all GUI controls (widgets). |

### Properties

| Name | Summary |
|---|---|
| [ctl](ctl.md) | `val ctl: CPointer<`[`uiControl`](../../libui/ui-control/index.md)`>` |
| [enabled](enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](parent.md) | `var parent: `[`Control`](./index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: CPointer<`[`T`](../-disposable/index.md#T)`>` |

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
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](./index.md)`<`[`uiBox`](../../libui/ui-box.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) |
| [Button](../-button/index.md) | `class Button : `[`Control`](./index.md)`<`[`uiButton`](../../libui/ui-button.md)`>`<br>Wrapper class for [uiButton](../../libui/ui-button.md) |
| [Checkbox](../-checkbox/index.md) | `class Checkbox : `[`Control`](./index.md)`<`[`uiCheckbox`](../../libui/ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../../libui/ui-checkbox.md) |
| [ColorButton](../-color-button/index.md) | `class ColorButton : `[`Control`](./index.md)`<`[`uiColorButton`](../../libui/ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../../libui/ui-color-button.md) |
| [Combobox](../-combobox/index.md) | `class Combobox : `[`Control`](./index.md)`<`[`uiCombobox`](../../libui/ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../../libui/ui-combobox.md) |
| [DateTimePicker](../-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](./index.md)`<`[`uiDateTimePicker`](../../libui/ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit date and time. |
| [DrawArea](../-draw-area/index.md) | `open class DrawArea : `[`Control`](./index.md)`<`[`uiArea`](../../libui/ui-area.md)`>`<br>Wrapper class for [uiArea](../../libui/ui-area.md) |
| [EditableCombobox](../-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](./index.md)`<`[`uiEditableCombobox`](../../libui/ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../../libui/ui-editable-combobox.md) |
| [FontButton](../-font-button/index.md) | `class FontButton : `[`Control`](./index.md)`<`[`uiFontButton`](../../libui/ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../../libui/ui-font-button.md) |
| [Form](../-form/index.md) | `class Form : `[`Control`](./index.md)`<`[`uiForm`](../../libui/ui-form.md)`>`<br>Wrapper class for [uiForm](../../libui/ui-form.md) |
| [GridPane](../-grid-pane/index.md) | `class GridPane : `[`Control`](./index.md)`<`[`uiGrid`](../../libui/ui-grid.md)`>`<br>Wrapper class for [uiGrid](../../libui/ui-grid.md) |
| [Group](../-group/index.md) | `class Group : `[`Control`](./index.md)`<`[`uiGroup`](../../libui/ui-group.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiGroup](../../libui/ui-group.md) |
| [Label](../-label/index.md) | `class Label : `[`Control`](./index.md)`<`[`uiLabel`](../../libui/ui-label.md)`>`<br>Wrapper class for [uiLabel](../../libui/ui-label.md) |
| [ProgressBar](../-progress-bar/index.md) | `class ProgressBar : `[`Control`](./index.md)`<`[`uiProgressBar`](../../libui/ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../../libui/ui-progress-bar.md) |
| [RadioButtons](../-radio-buttons/index.md) | `class RadioButtons : `[`Control`](./index.md)`<`[`uiRadioButtons`](../../libui/ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../../libui/ui-radio-buttons.md) |
| [Separator](../-separator/index.md) | `abstract class Separator : `[`Control`](./index.md)`<`[`uiSeparator`](../../libui/ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../../libui/ui-separator.md) |
| [Slider](../-slider/index.md) | `class Slider : `[`Control`](./index.md)`<`[`uiSlider`](../../libui/ui-slider.md)`>`<br>Wrapper class for [uiSlider](../../libui/ui-slider.md) |
| [Spinbox](../-spinbox/index.md) | `class Spinbox : `[`Control`](./index.md)`<`[`uiSpinbox`](../../libui/ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../../libui/ui-spinbox.md) |
| [TabPane](../-tab-pane/index.md) | `class TabPane : `[`Control`](./index.md)`<`[`uiTab`](../../libui/ui-tab.md)`>`<br>Wrapper class for [uiTab](../../libui/ui-tab.md) |
| [TableView](../-table-view/index.md) | `class TableView : `[`Control`](./index.md)`<`[`uiTable`](../../libui/ui-table.md)`>`<br>Wrapper class for [uiTable](../../libui/ui-table.md) |
| [TextArea](../-text-area/index.md) | `class TextArea : `[`Control`](./index.md)`<`[`uiMultilineEntry`](../../libui/ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../../libui/ui-multiline-entry.md) |
| [TextField](../-text-field/index.md) | `open class TextField : `[`Control`](./index.md)`<`[`uiEntry`](../../libui/ui-entry.md)`>`<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) |
| [Window](../-window/index.md) | `class Window : `[`Control`](./index.md)`<`[`uiWindow`](../../libui/ui-window.md)`>, `[`Container`](../-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
