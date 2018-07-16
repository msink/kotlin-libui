[libui.ktx](../index.md) / [SearchField](./index.md)

# SearchField

`class SearchField : `[`TextField`](../-text-field/index.md)

Wrapper class for [uiEntry](../../libui/ui-entry.md) to search text.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SearchField()`<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) to search text. |

### Inherited Properties

| Name | Summary |
|---|---|
| [readonly](../-text-field/readonly.md) | `var readonly: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the text is read-only or not. Defaults to `false`. |
| [value](../-text-field/value.md) | `var value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The current text of the TextField. |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-text-field/action.md) | `fun action(block: `[`TextField`](../-text-field/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be run when the user makes a change to the TextField. Only one function can be registered at a time. |
