[libui-ktx](../index.md) / [libui](index.md) / [add](./add.md)

# add

`fun `[`OpenTypeFeatures`](-open-type-features/index.md)`.add(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>`

Adds the given feature tag and value to OpenTypeFeatures. If there is already a value
associated with the specified tag in otf, the old value is removed.

`fun `[`Form`](-form/index.md)`.add(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, widget: `[`Control`](-control/index.md)`<*>, stretchy: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): <ERROR CLASS>`

Adds the given widget to the end of the form.

`fun `[`TabPane`](-tab-pane/index.md)`.add(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, widget: `[`Control`](-control/index.md)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds the given page to the end of the TabPane.

`fun `[`GridPane`](-grid-pane/index.md)`.add(widget: `[`Control`](-control/index.md)`<*>, x: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, y: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, xspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, yspan: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, hexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, halign: <ERROR CLASS> = uiAlignFill, vexpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, valign: <ERROR CLASS> = uiAlignFill): <ERROR CLASS>`

Adds the given Control to the end of the GridPane.

### Parameters

`widget` - The Control to be added.

`x` - The x-coordinate of the Control's location.

`y` - The y-coordinate of the Control's location.

`xspan` - The width of the Control.

`yspan` - The height of the Control.

`hexpand` - The horizontal expand of Control.

`halign` - The horizontal alignment of Control.

`vexpand` - The vertical expand of Control.

`valign` - The vertical alignment of Control.