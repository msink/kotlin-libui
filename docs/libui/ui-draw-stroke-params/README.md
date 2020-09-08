[libui](../README.md) / [uiDrawStrokeParams](README.md)

# uiDrawStrokeParams

`class uiDrawStrokeParams : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiDrawStrokeParams(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [Cap](-cap.md) | `var Cap: `[`uiDrawLineCap`](../ui-draw-line-cap.md) |
| [DashPhase](-dash-phase.md) | `var DashPhase: Double` |
| [Dashes](-dashes.md) | `var Dashes: CPointer<DoubleVar>?` |
| [Join](-join.md) | `var Join: `[`uiDrawLineJoin`](../ui-draw-line-join.md) |
| [MiterLimit](-miter-limit.md) | `var MiterLimit: Double` |
| [NumDashes](-num-dashes.md) | `var NumDashes: size_t` |
| [Thickness](-thickness.md) | `var Thickness: Double` |

### Extension Functions

| Name | Summary |
|---|---|
| [fill](../../libui.ktx.draw/fill.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit): Unit`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit): Unit`<br>Draw a path filled with a color. |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit): Unit`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit): Unit`<br>Draw a path in the context. |
| [text](../../libui.ktx.draw/text.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](../../libui.ktx.draw/-attributed-string/README.md)`, defaultFont: `[`Font`](../../libui.ktx.draw/-font/README.md)`, width: Double, align: `[`uiDrawTextAlign`](../ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](../../libui.ktx.draw/transform.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](../../libui.ktx.draw/-matrix/README.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
