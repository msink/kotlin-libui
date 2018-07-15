[libui-ktx](../../index.md) / [libui](../index.md) / [Disposable](./index.md)

# Disposable

`abstract class Disposable<T : `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`>`

Manages and owns all its native resources.

* Allocates one resource during construction,
    and may allocate some additional resources during operation.
* Must free all its resource once [dispose](dispose.md) is invoked.
* [disposed](disposed.md) is a final state of the class, it is not supposed
    to be used after being disposed.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Disposable(alloc: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](index.md#T)`>?)`<br>Manages and owns all its native resources. |

### Properties

| Name | Summary |
|---|---|
| [disposed](disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [dispose](dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |

### Inheritors

| Name | Summary |
|---|---|
| [Attribute](../-attribute/index.md) | `abstract class Attribute : `[`Disposable`](./index.md)`<`[`uiAttribute`](../ui-attribute.md)`>`<br>Stores information about an attribute in a [string](../string.md). |
| [AttributedString](../-attributed-string/index.md) | `class AttributedString : `[`Disposable`](./index.md)`<`[`uiAttributedString`](../ui-attributed-string.md)`>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [Brush](../-brush/index.md) | `class Brush : `[`Disposable`](./index.md)`<`[`uiDrawBrush`](../ui-draw-brush/index.md)`>`<br>Defines the color(s) to draw a path with. |
| [Control](../-control/index.md) | `abstract class Control<T : `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`> : `[`Disposable`](./index.md)`<`[`T`](../-control/index.md#T)`>`<br>Base class for all GUI controls (widgets). |
| [Font](../-font/index.md) | `class Font : `[`Disposable`](./index.md)`<`[`uiFontDescriptor`](../ui-font-descriptor/index.md)`>`<br>Provides a complete description of a font where one is needed. |
| [Image](../-image/index.md) | `class Image : `[`Disposable`](./index.md)`<`[`uiImage`](../ui-image.md)`>` |
| [Matrix](../-matrix/index.md) | `class Matrix : `[`Disposable`](./index.md)`<`[`uiDrawMatrix`](../ui-draw-matrix/index.md)`>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](../-open-type-features/index.md) | `class OpenTypeFeatures : `[`Disposable`](./index.md)`<`[`uiOpenTypeFeatures`](../ui-open-type-features.md)`>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [Path](../-path/index.md) | `class Path : `[`Disposable`](./index.md)`<`[`uiDrawPath`](../ui-draw-path.md)`>`<br>Represent a path that could be drawed on a [DrawContext](../-draw-context.md) |
| [Stroke](../-stroke/index.md) | `class Stroke : `[`Disposable`](./index.md)`<`[`uiDrawStrokeParams`](../ui-draw-stroke-params/index.md)`>`<br>Describes the stroke to draw with. |
| [Table](../-table/index.md) | `class Table<T> : `[`Disposable`](./index.md)`<`[`uiTableModel`](../ui-table-model.md)`>`<br>Wrapper class for [uiTableModel](../ui-table-model.md) |
| [TextLayout](../-text-layout/index.md) | `class TextLayout : `[`Disposable`](./index.md)`<`[`uiDrawTextLayout`](../ui-draw-text-layout.md)`>`<br>Representation of a [string](../string.md) that can be displayed in a [DrawContext](../-draw-context.md). |
