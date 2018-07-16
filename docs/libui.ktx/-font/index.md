[libui.ktx](../index.md) / [Font](./index.md)

# Font

`class Font : `[`Disposable`](../-disposable/index.md)`<`[`uiFontDescriptor`](../../libui/ui-font-descriptor/index.md)`>`

Provides a complete description of a font where one is needed.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Font()`<br>Provides a complete description of a font where one is needed. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../-disposable/index.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
