[libui](../README.md) / [uiDrawBrush](README.md)

# uiDrawBrush

`class uiDrawBrush : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [uiDrawBrush](ui-draw-brush.md) | `uiDrawBrush(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [A](-a.md) | `var A: Double` |
| [B](-b.md) | `var B: Double` |
| [G](-g.md) | `var G: Double` |
| [NumStops](-num-stops.md) | `var NumStops: size_t` |
| [OuterRadius](-outer-radius.md) | `var OuterRadius: Double` |
| [R](-r.md) | `var R: Double` |
| [Stops](-stops.md) | `var Stops: CPointer<`[`uiDrawBrushGradientStop`](../ui-draw-brush-gradient-stop/README.md)`>?` |
| [Type](-type.md) | `var Type: `[`uiDrawBrushType`](../ui-draw-brush-type.md) |
| [X0](-x0.md) | `var X0: Double` |
| [X1](-x1.md) | `var X1: Double` |
| [Y0](-y0.md) | `var Y0: Double` |
| [Y1](-y1.md) | `var Y1: Double` |

### Extension functions

| Name | Summary |
|---|---|
| [fill](../../libui.ktx.draw/fill.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit)`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit)`<br>Draw a path filled with a color. |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit)`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](../../libui.ktx.draw/-brush/README.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)`, block: `[`Path`](../../libui.ktx.draw/-path/README.md)`.() -> Unit)`<br>Draw a path in the context. |
| [text](../../libui.ktx.draw/text.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](../../libui.ktx.draw/-attributed-string/README.md)`, defaultFont: `[`Font`](../../libui.ktx.draw/-font/README.md)`, width: Double, align: `[`uiDrawTextAlign`](../ui-draw-text-align.md)`, x: Double, y: Double)`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](../../libui.ktx.draw/transform.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](../../libui.ktx.draw/-matrix/README.md)`.() -> Unit)`<br>Apply a different transform matrix to the context. |
