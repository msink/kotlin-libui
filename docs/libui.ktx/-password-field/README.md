[libui.ktx](../README.md) / [PasswordField](README.md)

# PasswordField

`class PasswordField : `[`TextField`](../-text-field/README.md)

Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget that mask the input,
useful to edit passwords or other sensible data.

### Constructors

| Name | Summary |
|---|---|
| [PasswordField](-password-field.md) | `PasswordField()`<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a text entry widget that mask the input, useful to edit passwords or other sensible data. |

### Inherited Properties

| Name | Summary |
|---|---|
| [readonly](../-text-field/readonly.md) | `var readonly: Boolean`<br>Whether the text is read-only or not. Defaults to `false`. |
| [value](../-text-field/value.md) | `var value: String`<br>The current text of the TextField. |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-text-field/action.md) | `fun action(block: `[`TextField`](../-text-field/README.md)`.() -> Unit): Unit`<br>Function to be run when the user makes a change to the TextField. Only one function can be registered at a time. |
