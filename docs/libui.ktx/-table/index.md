[libui.ktx](../index.md) / [Table](./index.md)

# Table

`class Table<T> : `[`Disposable`](../-disposable/index.md)`<`[`uiTableModel`](../../libui/ui-table-model.md)`>`

Wrapper class for [uiTableModel](../../libui/ui-table-model.md)

### Types

| Name | Summary |
|---|---|
| [TableColumn](-table-column/index.md) | `inner class TableColumn<T>` |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: List<`[`T`](-table-column/index.md#T)`>` |
| [handler](handler.md) | `val handler: CPointer<`[`ktTableHandler`](../../libui/kt-table-handler/index.md)`>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [background](background.md) | `fun background(get: (row: Int) -> `[`Color`](../-color/index.md)`?): Unit` |
| [column](column.md) | `fun column(name: String, init: `[`TableColumn`](-table-column/index.md)`<`[`T`](-table-column/index.md#T)`>.() -> Unit): Unit` |
| [rowChanged](row-changed.md) | `fun rowChanged(index: Int): Unit` |
| [rowDeleted](row-deleted.md) | `fun rowDeleted(oldIndex: Int): Unit` |
| [rowInserted](row-inserted.md) | `fun rowInserted(newIndex: Int): Unit` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |

### Extension Functions

| Name | Summary |
|---|---|
| [image](../image.md) | `fun `[`Table`](./index.md)`<*>.image(width: Int, height: Int, block: `[`Image`](../-image/index.md)`.() -> Unit = {}): `[`Image`](../-image/index.md) |
