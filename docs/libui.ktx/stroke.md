[libui.ktx](index.md) / [stroke](./stroke.md)

# stroke

`fun `[`DrawArea`](-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Stroke`](-stroke/index.md)

Creates a new Stroke with lifecycle delegated to DrawArea.

`fun `[`DrawContext`](-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Draw a path in the context.

`fun `[`DrawContext`](-draw-context.md)`.stroke(brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)