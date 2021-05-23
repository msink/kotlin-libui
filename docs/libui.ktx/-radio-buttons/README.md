[libui.ktx](../README.md) / [RadioButtons](README.md)

# RadioButtons

`class RadioButtons : `[`Control`](../-control/README.md)`<`[`uiRadioButtons`](../../libui/ui-radio-buttons.md)`>`

Wrapper class for [uiRadioButtons](../../libui/ui-radio-buttons.md) - a widget that represent a group of radio options.

### Constructors

| Name | Summary |
|---|---|
| [RadioButtons](-radio-buttons.md) | `RadioButtons()`<br>Wrapper class for [uiRadioButtons](../../libui/ui-radio-buttons.md) - a widget that represent a group of radio options. |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: Int`<br>Return or set the current selected option by index. |

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
| [action](action.md) | `fun action(block: `[`RadioButtons`](README.md)`.() -> Unit)`<br>Function to be run when the user makes a change to the RadioButtons. Only one function can be registered at a time. |
| [item](item.md) | `fun item(text: String)`<br>Adds the named button to the end of the radiobuttons. If it is the first button, it is automatically selected. |

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
