[libui-ktx](../../index.md) / [libui](../index.md) / [AttributedString](./index.md)

# AttributedString

`class AttributedString : `[`Disposable`](../-disposable/index.md)`<`[`uiAttributedString`](../ui-attributed-string.md)`>`

Represents a string of UTF-8 text that can be embellished with formatting attributes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AttributedString(init: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |

### Properties

| Name | Summary |
|---|---|
| [length](length.md) | `val length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the number of UTF-8 bytes in the textual content, excluding the terminating '\0'. |
| [string](string.md) | `val string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the textual content of AttributedString. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [append](append.md) | `fun append(str: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the '\0'-terminated UTF-8 string str to the end. The new substring will be unattributed. |
| [delete](delete.md) | `fun delete(start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes the characters and attributes in the byte range [start, end). |
| [insert](insert.md) | `fun insert(str: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, at: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the '\0'-terminated UTF-8 string str to s at the byte position specified by [at](insert.md#libui.AttributedString$insert(kotlin.String, kotlin.Int)/at). The new substring will be unattributed existing attributes will be moved along with their text. |
| [setAttribute](set-attribute.md) | `fun setAttribute(a: `[`Attribute`](../-attribute/index.md)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets a in the byte range [start, end). Any existing attributes in that byte range of the same type are removed. Takes ownership of [a](set-attribute.md#libui.AttributedString$setAttribute(libui.Attribute, kotlin.Int, kotlin.Int)/a) you should not use it after uiAttributedStringSetAttribute() returns. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
