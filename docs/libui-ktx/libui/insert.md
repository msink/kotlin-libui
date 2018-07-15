[libui-ktx](../index.md) / [libui](index.md) / [insert](./insert.md)

# insert

`fun `[`AttributedString`](-attributed-string/index.md)`.insert(str: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, at: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>`

Adds the '\0'-terminated UTF-8 string str to s at the byte position specified by [at](insert.md#libui$insert(libui.AttributedString, kotlin.String, kotlin.Int)/at).
The new substring will be unattributed existing attributes will be moved along with their text.

`fun `[`TabPane`](-tab-pane/index.md)`.insert(page: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, widget: `[`Control`](-control/index.md)`<*>): <ERROR CLASS>`

Adds the given page to the TabPane such that it is the nth page of the TabPane (starting at 0).

`fun `[`GridPane`](-grid-pane/index.md)`.insert(widget: `[`Control`](-control/index.md)`<*>, existing: `[`Control`](-control/index.md)`<*>, at: <ERROR CLASS>, xspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, hexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, halign: <ERROR CLASS> = uiAlignFill, vexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, valign: <ERROR CLASS> = uiAlignFill): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Insert the given Control after existing Control.

### Parameters

`widget` - The Control to be added.

`existing` - The existing Control at which Control be inserted.

`at` - The relative placement of the Control to the existing one.

`xspan` - The width of the Control.

`yspan` - The height of the Control.

`hexpand` - The horizontal expand of Control.

`halign` - The horizontal alignment of Control.

`vexpand` - The vertical expand of Control.

`valign` - The vertical alignment of Control.