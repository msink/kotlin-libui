[libui-ktx](../index.md) / [kotlinx.cinterop](index.md) / [useContents](./use-contents.md)

# useContents

`inline fun <reified T : `[`CStructVar`](-c-struct-var/index.md)`, R> `[`CValue`](-c-value/index.md)`<`[`T`](use-contents.md#T)`>.useContents(block: `[`T`](use-contents.md#T)`.() -> `[`R`](use-contents.md#R)`): `[`R`](use-contents.md#R)

Calls the [block](use-contents.md#kotlinx.cinterop$useContents(kotlinx.cinterop.CValue((kotlinx.cinterop.useContents.T)), kotlin.Function1((kotlinx.cinterop.useContents.T, kotlinx.cinterop.useContents.R)))/block) with temporary copy if this value as receiver.

