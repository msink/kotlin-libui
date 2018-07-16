[libui.ktx](../index.md) / [Combobox](./index.md)

# Combobox

`class Combobox : `[`Control`](../-control/index.md)`<`[`uiCombobox`](../../libui/ui-combobox.md)`>`

Wrapper class for [uiCombobox](../../libui/ui-combobox.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Combobox()`<br>Wrapper class for [uiCombobox](../../libui/ui-combobox.md) |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Return or set the current selected option by index. |

### Inherited Properties

| Name | Summary |
|---|---|
| [ctl](../-control/ctl.md) | `val ctl: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](../../libui/ui-control/index.md)`>` |
| [enabled](../-control/enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(block: `[`Combobox`](./index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be run when the user makes a change to the Combobox. Only one function can be registered at a time. |
| [item](item.md) | `fun item(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the named entry to the end of the combobox. If it is the first entry, it is automatically selected. |

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
