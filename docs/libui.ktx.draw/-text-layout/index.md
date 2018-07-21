[libui.ktx.draw](../index.md) / [TextLayout](./index.md)

# TextLayout

`class TextLayout : `[`Disposable`](../../libui.ktx/-disposable/index.md)`<`[`uiDrawTextLayout`](../../libui/ui-draw-text-layout.md)`>`

Representation of a [AttributedString](../-attributed-string/index.md) that can be displayed in a [uiDrawContext](../../libui/ui-draw-context.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TextLayout(string: `[`AttributedString`](../-attributed-string/index.md)`, defaultFont: `[`Font`](../-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../../libui/ui-draw-text-align.md)`)`<br>Representation of a [AttributedString](../-attributed-string/index.md) that can be displayed in a [uiDrawContext](../../libui/ui-draw-context.md). |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `val size: `[`Size`](../-size/index.md)<br>Returns the size of TextLayout. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
