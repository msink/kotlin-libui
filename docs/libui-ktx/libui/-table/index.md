[libui-ktx](../../index.md) / [libui](../index.md) / [Table](./index.md)

# Table

`class Table<T> : `[`Disposable`](../-disposable/index.md)`<<ERROR CLASS>>`

### Types

| Name | Summary |
|---|---|
| [TableColumn](-table-column/index.md) | `inner class TableColumn<T>` |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](-table-column/index.md#T)`>` |
| [handler](handler.md) | `val handler: <ERROR CLASS><<ERROR CLASS>>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: <ERROR CLASS><`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [background](background.md) | `fun background(get: (row: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Color`](../-color/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [column](column.md) | `fun column(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, init: `[`TableColumn`](-table-column/index.md)`<`[`T`](-table-column/index.md#T)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [rowChanged](row-changed.md) | `fun rowChanged(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>` |
| [rowDeleted](row-deleted.md) | `fun rowDeleted(oldIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>` |
| [rowInserted](row-inserted.md) | `fun rowInserted(newIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |

### Extension Functions

| Name | Summary |
|---|---|
| [image](../image.md) | `fun `[`Table`](./index.md)`<*>.image(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, block: `[`Image`](../-image/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Image`](../-image/index.md) |
