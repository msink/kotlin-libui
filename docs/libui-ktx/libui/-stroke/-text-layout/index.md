[libui-ktx](../../../index.md) / [libui](../../index.md) / [Stroke](../index.md) / [TextLayout](./index.md)

# TextLayout

`class TextLayout : `[`Disposable`](../../-disposable/index.md)`<`[`uiDrawTextLayout`](../../ui-draw-text-layout.md)`>`

Representation of a [string](../string.md) that can be displayed in a [DrawContext](../-draw-context.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TextLayout(string: `[`AttributedString`](../-attributed-string/index.md)`, defaultFont: `[`Font`](../-font/index.md)`, width: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, align: `[`uiDrawTextAlign`](../../ui-draw-text-align.md)`)`<br>Representation of a [string](../string.md) that can be displayed in a [DrawContext](../-draw-context.md). |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `val size: `[`Size`](../-size/index.md)<br>Returns the size of [TextLayout](./index.md). |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../../-disposable/index.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
