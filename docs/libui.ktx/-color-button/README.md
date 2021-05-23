[libui.ktx](../README.md) / [ColorButton](README.md)

# ColorButton

`class ColorButton : `[`Control`](../-control/README.md)`<`[`uiColorButton`](../../libui/ui-color-button.md)`>`

Wrapper class for [uiColorButton](../../libui/ui-color-button.md) - a button that opens a color palette popup.

### Constructors

| Name | Summary |
|---|---|
| [ColorButton](-color-button.md) | `ColorButton()`<br>Wrapper class for [uiColorButton](../../libui/ui-color-button.md) - a button that opens a color palette popup. |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: `[`Color`](../../libui.ktx.draw/-color/README.md)<br>Return or set the currently selected color |

### Inherited properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(block: ColorButton.() -> Unit)`<br>Function to be run when the user makes a change to the ColorButton. Only one function can be registered at a time. |

### Inherited functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable()`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose()`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable()`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): ULong`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide()`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show()`<br>Shows the Control. |
