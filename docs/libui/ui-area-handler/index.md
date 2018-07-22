[libui](../index.md) / [uiAreaHandler](./index.md)

# uiAreaHandler

`class uiAreaHandler : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiAreaHandler(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [DragBroken](-drag-broken.md) | `var DragBroken: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?) -> Unit>>?` |
| [Draw](-draw.md) | `var Draw: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaDrawParams`](../ui-area-draw-params/index.md)`>?) -> Unit>>?` |
| [KeyEvent](-key-event.md) | `var KeyEvent: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaKeyEvent`](../ui-area-key-event/index.md)`>?) -> Int>>?` |
| [MouseCrossed](-mouse-crossed.md) | `var MouseCrossed: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, Int) -> Unit>>?` |
| [MouseEvent](-mouse-event.md) | `var MouseEvent: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaMouseEvent`](../ui-area-mouse-event/index.md)`>?) -> Unit>>?` |

### Extension Functions

| Name | Summary |
|---|---|
| [fill](../../libui.ktx.draw/fill.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path filled with a color. |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path in the context. |
| [text](../../libui.ktx.draw/text.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](../../libui.ktx.draw/-attributed-string/index.md)`, defaultFont: `[`Font`](../../libui.ktx.draw/-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](../../libui.ktx.draw/transform.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](../../libui.ktx.draw/-matrix/index.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
