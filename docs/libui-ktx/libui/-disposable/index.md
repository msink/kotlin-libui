[libui-ktx](../../index.md) / [libui](../index.md) / [Disposable](./index.md)

# Disposable

`abstract class Disposable<T>`

Manages and owns all its native resources.

* Allocates one resource during construction,
    and may allocate some additional resources during operation.
* Must free all its resource once [dispose](dispose.md) is invoked.
* [disposed](disposed.md) is a final state of the class, it is not supposed
    to be used after being disposed.

### Constructors

| [&lt;init&gt;](-init-.md) | `Disposable(alloc: <ERROR CLASS><`[`T`](index.md#T)`>?)`<br>Manages and owns all its native resources. |

### Properties

| [disposed](disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](ptr.md) | `val ptr: <ERROR CLASS><`[`T`](index.md#T)`>` |

### Functions

| [dispose](dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |

### Inheritors

| [Attribute](../-attribute/index.md) | `abstract class Attribute : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Stores information about an attribute in a [string](../string.md). |
| [AttributedString](../-attributed-string/index.md) | `class AttributedString : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [Brush](../-brush/index.md) | `class Brush : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Defines the color(s) to draw a path with. |
| [Control](../-control/index.md) | `abstract class Control<T> : `[`Disposable`](./index.md)`<`[`T`](../-control/index.md#T)`>`<br>Base class for all GUI controls (widgets). |
| [Font](../-font/index.md) | `class Font : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Provides a complete description of a font where one is needed. |
| [Image](../-image/index.md) | `class Image : `[`Disposable`](./index.md)`<<ERROR CLASS>>` |
| [Matrix](../-matrix/index.md) | `class Matrix : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](../-open-type-features/index.md) | `class OpenTypeFeatures : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [Path](../-path/index.md) | `class Path : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Represent a path that could be drawed on a [DrawContext](../-draw-context.md) |
| [Stroke](../-stroke/index.md) | `class Stroke : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Describes the stroke to draw with. |
| [Table](../-table/index.md) | `class Table<T> : `[`Disposable`](./index.md)`<<ERROR CLASS>>` |
| [TextLayout](../-text-layout/index.md) | `class TextLayout : `[`Disposable`](./index.md)`<<ERROR CLASS>>`<br>Representation of a [string](../string.md) that can be displayed in a [DrawContext](../-draw-context.md). |

