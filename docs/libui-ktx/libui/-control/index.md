[libui-ktx](../../index.md) / [libui](../index.md) / [Control](./index.md)

# Control

`abstract class Control<T> : `[`Disposable`](../-disposable/index.md)`<`[`T`](index.md#T)`>`

Base class for all GUI controls (widgets).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Control(alloc: <ERROR CLASS><`[`T`](index.md#T)`>?)`<br>Base class for all GUI controls (widgets). |

### Properties

| Name | Summary |
|---|---|
| [ctl](ctl.md) | `val ctl: <ERROR CLASS><<ERROR CLASS>>` |
| [enabled](enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](parent.md) | `var parent: `[`Control`](./index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: <ERROR CLASS><`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [disable](disable.md) | `fun disable(): <ERROR CLASS>`<br>Disables the Control. |
| [dispose](dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated resources. |
| [enable](enable.md) | `fun enable(): <ERROR CLASS>`<br>Enables the Control. |
| [getHandle](get-handle.md) | `fun getHandle(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the OS-level handle associated with this Control. |
| [hide](hide.md) | `fun hide(): <ERROR CLASS>`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](is-enabled.md) | `fun isEnabled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is enabled. |
| [isEnabledToUser](is-enabled-to-user.md) | `fun isEnabledToUser(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control and all parents are enabled. |
| [isVisible](is-visible.md) | `fun isVisible(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is visible. |
| [show](show.md) | `fun show(): <ERROR CLASS>`<br>Shows the Control. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](./index.md)`<<ERROR CLASS>>, `[`Container`](../-container/index.md) |
| [Button](../-button/index.md) | `class Button : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Checkbox](../-checkbox/index.md) | `class Checkbox : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [ColorButton](../-color-button/index.md) | `class ColorButton : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Combobox](../-combobox/index.md) | `class Combobox : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [DateTimePicker](../-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [DrawArea](../-draw-area/index.md) | `open class DrawArea : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [EditableCombobox](../-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [FontButton](../-font-button/index.md) | `class FontButton : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Form](../-form/index.md) | `class Form : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [GridPane](../-grid-pane/index.md) | `class GridPane : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Group](../-group/index.md) | `class Group : `[`Control`](./index.md)`<<ERROR CLASS>>, `[`Container`](../-container/index.md) |
| [Label](../-label/index.md) | `class Label : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [ProgressBar](../-progress-bar/index.md) | `class ProgressBar : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [RadioButtons](../-radio-buttons/index.md) | `class RadioButtons : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Separator](../-separator/index.md) | `abstract class Separator : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Slider](../-slider/index.md) | `class Slider : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Spinbox](../-spinbox/index.md) | `class Spinbox : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [TabPane](../-tab-pane/index.md) | `class TabPane : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [TableView](../-table-view/index.md) | `class TableView : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [TextArea](../-text-area/index.md) | `class TextArea : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [TextField](../-text-field/index.md) | `open class TextField : `[`Control`](./index.md)`<<ERROR CLASS>>` |
| [Window](../-window/index.md) | `class Window : `[`Control`](./index.md)`<<ERROR CLASS>>, `[`Container`](../-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
