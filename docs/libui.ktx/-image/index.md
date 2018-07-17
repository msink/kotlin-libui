[libui.ktx](../index.md) / [Image](./index.md)

# Image

`class Image : `[`Disposable`](../-disposable/index.md)`<`[`uiImage`](../../libui/ui-image.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Image(width: Double, height: Double)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: CPointer<`[`T`](../-disposable/index.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |

### Extension Functions

| Name | Summary |
|---|---|
| [bitmap](../bitmap.md) | `fun `[`Image`](./index.md)`.bitmap(data: `[`ImageData`](../-image-data/index.md)`): Unit` |
