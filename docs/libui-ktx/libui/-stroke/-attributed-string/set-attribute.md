[libui-ktx](../../../index.md) / [libui](../../index.md) / [Stroke](../index.md) / [AttributedString](index.md) / [setAttribute](./set-attribute.md)

# setAttribute

`fun setAttribute(a: `[`Attribute`](../-attribute/index.md)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, end: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets a in the byte range [start, end). Any existing attributes in that byte range of the same type are
removed. Takes ownership of [a](set-attribute.md#libui.Stroke.AttributedString$setAttribute(libui.Stroke.Attribute, kotlin.Int, kotlin.Int)/a) you should not use it after uiAttributedStringSetAttribute() returns.

