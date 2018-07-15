[libui-ktx](../index.md) / [libui](index.md) / [setAttribute](./set-attribute.md)

# setAttribute

`fun `[`AttributedString`](-attributed-string/index.md)`.setAttribute(a: `[`Attribute`](-attribute/index.md)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>`

Sets a in the byte range [start, end). Any existing attributes in that byte range of the same type are
removed. Takes ownership of [a](set-attribute.md#libui$setAttribute(libui.AttributedString, libui.Attribute, kotlin.Int, kotlin.Int)/a) you should not use it after uiAttributedStringSetAttribute() returns.

