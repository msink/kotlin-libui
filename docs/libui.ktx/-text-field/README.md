[libui.ktx](../README.md) / [TextField](README.md)

# TextField

`open class TextField : `[`Control`](../-control/README.md)`<`[`uiEntry`](../../libui/ui-entry.md)`>`

Wrapper class for [uiEntry](../../libui/ui-entry.md) - a simple single line text entry widget

### Constructors

| Name | Summary |
|---|---|
| [TextField](-text-field.md) | `TextField()` |

### Properties

| Name | Summary |
|---|---|
| [readonly](readonly.md) | `var readonly: Boolean`<br>Whether the text is read-only or not. Defaults to `false`. |
| [value](value.md) | `var value: String`<br>The current text of the TextField. |

### Inherited properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(block: TextField.() -> Unit)`<br>Function to be run when the user makes a change to the TextField. Only one function can be registered at a time. |

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

### Inheritors

| Name | Summary |
|---|---|
| [PasswordField](../-password-field/README.md) | `class PasswordField : `[`TextField`](README.md)<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [SearchField](../-search-field/README.md) | `class SearchField : `[`TextField`](README.md)<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget to search text. |
