[libui](../index.md) / [uiControl](./index.md)

# uiControl

`class uiControl : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiControl(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [Destroy](-destroy.md) | `var Destroy: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [Disable](-disable.md) | `var Disable: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [Enable](-enable.md) | `var Enable: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [Enabled](-enabled.md) | `var Enabled: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Int>>?` |
| [Handle](-handle.md) | `var Handle: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> uintptr_t>>?` |
| [Hide](-hide.md) | `var Hide: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [OSSignature](-o-s-signature.md) | `var OSSignature: uint32_t` |
| [Parent](-parent.md) | `var Parent: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> CPointer<`[`uiControl`](./index.md)`>?>>?` |
| [SetParent](-set-parent.md) | `var SetParent: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?, CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [Show](-show.md) | `var Show: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Unit>>?` |
| [Signature](-signature.md) | `var Signature: uint32_t` |
| [Toplevel](-toplevel.md) | `var Toplevel: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Int>>?` |
| [TypeSignature](-type-signature.md) | `var TypeSignature: uint32_t` |
| [Visible](-visible.md) | `var Visible: CPointer<CFunction<(CPointer<`[`uiControl`](./index.md)`>?) -> Int>>?` |

### Extension Functions

| Name | Summary |
|---|---|
| [fill](../../libui.ktx.draw/fill.md) | `fun `[`uiDrawContext`](../ui-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path filled with a color.`fun `[`uiDrawContext`](../ui-draw-context.md)`.fill(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit` |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`uiDrawContext`](../ui-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path in the context.`fun `[`uiDrawContext`](../ui-draw-context.md)`.stroke(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit` |
| [text](../../libui.ktx.draw/text.md) | `fun `[`uiDrawContext`](../ui-draw-context.md)`.text(string: `[`AttributedString`](../../libui.ktx.draw/-attributed-string/index.md)`, defaultFont: `[`Font`](../../libui.ktx.draw/-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](../../libui.ktx.draw/transform.md) | `fun `[`uiDrawContext`](../ui-draw-context.md)`.transform(block: `[`Matrix`](../../libui.ktx.draw/-matrix/index.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
