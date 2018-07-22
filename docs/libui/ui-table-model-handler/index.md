[libui](../index.md) / [uiTableModelHandler](./index.md)

# uiTableModelHandler

`class uiTableModelHandler : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiTableModelHandler(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [CellValue](-cell-value.md) | `var CellValue: CPointer<CFunction<(CPointer<`[`uiTableModelHandler`](./index.md)`>?, CPointer<`[`uiTableModel`](../ui-table-model.md)`>?, Int, Int) -> CPointer<`[`uiTableValue`](../ui-table-value.md)`>?>>?` |
| [ColumnType](-column-type.md) | `var ColumnType: CPointer<CFunction<(CPointer<`[`uiTableModelHandler`](./index.md)`>?, CPointer<`[`uiTableModel`](../ui-table-model.md)`>?, Int) -> `[`uiTableValueType`](../ui-table-value-type.md)`>>?` |
| [NumColumns](-num-columns.md) | `var NumColumns: CPointer<CFunction<(CPointer<`[`uiTableModelHandler`](./index.md)`>?, CPointer<`[`uiTableModel`](../ui-table-model.md)`>?) -> Int>>?` |
| [NumRows](-num-rows.md) | `var NumRows: CPointer<CFunction<(CPointer<`[`uiTableModelHandler`](./index.md)`>?, CPointer<`[`uiTableModel`](../ui-table-model.md)`>?) -> Int>>?` |
| [SetCellValue](-set-cell-value.md) | `var SetCellValue: CPointer<CFunction<(CPointer<`[`uiTableModelHandler`](./index.md)`>?, CPointer<`[`uiTableModel`](../ui-table-model.md)`>?, Int, Int, CPointer<`[`uiTableValue`](../ui-table-value.md)`>?) -> Unit>>?` |

### Extension Functions

| Name | Summary |
|---|---|
| [fill](../../libui.ktx.draw/fill.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path filled with a color.`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit` |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../ui-draw-fill-mode.md)`, brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit`<br>Draw a path in the context.`fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](../../libui.ktx.draw/-brush/index.md)`, stroke: `[`Stroke`](../../libui.ktx.draw/-stroke/index.md)`, block: `[`Path`](../../libui.ktx.draw/-path/index.md)`.() -> Unit): Unit` |
| [text](../../libui.ktx.draw/text.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](../../libui.ktx.draw/-attributed-string/index.md)`, defaultFont: `[`Font`](../../libui.ktx.draw/-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](../../libui.ktx.draw/transform.md) | `fun `[`DrawContext`](../../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](../../libui.ktx.draw/-matrix/index.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
