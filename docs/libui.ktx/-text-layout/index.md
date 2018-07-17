[libui.ktx](../index.md) / [TextLayout](./index.md)

# TextLayout

`class TextLayout : `[`Disposable`](../-disposable/index.md)`<`[`uiDrawTextLayout`](../../libui/ui-draw-text-layout.md)`>`

Representation of a [AttributedString](../-attributed-string/index.md) that can be displayed in a [DrawContext](../-draw-context.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TextLayout(string: `[`AttributedString`](../-attributed-string/index.md)`, defaultFont: `[`Font`](../-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../../libui/ui-draw-text-align.md)`)`<br>Representation of a [AttributedString](../-attributed-string/index.md) that can be displayed in a [DrawContext](../-draw-context.md). |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `val size: `[`Size`](../-size/index.md)<br>Returns the size of [TextLayout](./index.md). |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: CPointer<`[`T`](../-disposable/index.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
