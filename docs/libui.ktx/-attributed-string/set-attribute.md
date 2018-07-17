[libui.ktx](../index.md) / [AttributedString](index.md) / [setAttribute](./set-attribute.md)

# setAttribute

`fun setAttribute(a: `[`Attribute`](../-attribute/index.md)`, start: Int, end: Int): Unit`

Sets a in the byte range \[`start`, `end`). Any existing attributes in that byte range of the same type are
removed. Takes ownership of `a` you should not use it after `setAttribute()` returns.

