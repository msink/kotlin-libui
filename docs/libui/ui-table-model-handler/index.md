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
