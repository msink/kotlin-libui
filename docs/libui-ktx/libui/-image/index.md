[libui-ktx](../../index.md) / [libui](../index.md) / [Image](./index.md)

# Image

`class Image : `[`Disposable`](../-disposable/index.md)`<<ERROR CLASS>>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Image(width: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, height: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: <ERROR CLASS><`[`T`](../-disposable/index.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |

### Extension Functions

| Name | Summary |
|---|---|
| [bitmap](../bitmap.md) | `fun `[`Image`](./index.md)`.bitmap(data: `[`ImageData`](../-image-data/index.md)`): <ERROR CLASS>` |
