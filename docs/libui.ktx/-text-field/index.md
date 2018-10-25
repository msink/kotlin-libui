[libui.ktx](../index.md) / [TextField](./index.md)

# TextField

`open class TextField : `[`Control`](../-control/index.md)`<`[`uiEntry`](../../libui/ui-entry.md)`>`

Wrapper class for [uiEntry](../../libui/ui-entry.md) - a simple single line text entry widget

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TextField()` |

### Properties

| Name | Summary |
|---|---|
| [readonly](readonly.md) | `var readonly: Boolean`<br>Whether the text is read-only or not. Defaults to `false`. |
| [value](value.md) | `var value: String`<br>The current text of the TextField. |

### Inherited Properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(block: `[`TextField`](./index.md)`.() -> Unit): Unit`<br>Function to be run when the user makes a change to the TextField. Only one function can be registered at a time. |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): Unit`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): Unit`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): ULong`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): Unit`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): Unit`<br>Shows the Control. |

### Inheritors

| Name | Summary |
|---|---|
| [PasswordField](../-password-field/index.md) | `class PasswordField : `[`TextField`](./index.md)<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [SearchField](../-search-field/index.md) | `class SearchField : `[`TextField`](./index.md)<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget to search text. |
