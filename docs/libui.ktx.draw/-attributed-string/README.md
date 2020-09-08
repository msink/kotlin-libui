[libui.ktx.draw](../README.md) / [AttributedString](README.md)

# AttributedString

`class AttributedString : `[`Disposable`](../../libui.ktx/-disposable/README.md)`<`[`uiAttributedString`](../../libui/ui-attributed-string.md)`>`

Represents a string of UTF-8 text that can be embellished with formatting attributes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AttributedString(init: String)`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |

### Properties

| Name | Summary |
|---|---|
| [length](length.md) | `val length: Int`<br>Returns the number of UTF-8 bytes in the textual content, excluding the terminating '\\0'. |
| [string](string.md) | `val string: String`<br>Returns the textual content of AttributedString. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [append](append.md) | `fun append(str: String): Unit`<br>Adds the '\\0'-terminated UTF-8 string `str` to the end. The new substring will be unattributed. |
| [delete](delete.md) | `fun delete(start: Int, end: Int): Unit`<br>Deletes the characters and attributes in the byte range \[`start`, `end`). |
| [insert](insert.md) | `fun insert(str: String, at: Int): Unit`<br>Adds the '\\0'-terminated UTF-8 string `str` at the byte position specified by `at`. The new substring will be unattributed existing attributes will be moved along with their text. |
| [setAttribute](set-attribute.md) | `fun setAttribute(a: `[`Attribute`](../-attribute/README.md)`, start: Int, end: Int): Unit`<br>Sets a in the byte range \[`start`, `end`). Any existing attributes in that byte range of the same type are removed. Takes ownership of `a` you should not use it after `setAttribute()` returns. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
