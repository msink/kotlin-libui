[libui.ktx.draw](../README.md) / [Image](README.md)

# Image

`class Image : `[`Disposable`](../../libui.ktx/-disposable/README.md)`<`[`uiImage`](../../libui/ui-image.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Image(width: Double, height: Double)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |

### Extension Functions

| Name | Summary |
|---|---|
| [bitmap](../bitmap.md) | `fun `[`Image`](README.md)`.bitmap(data: `[`ImageData`](../-image-data/README.md)`): Unit` |
