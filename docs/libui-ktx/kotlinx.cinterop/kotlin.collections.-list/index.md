[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [kotlin.collections.List](./index.md)

### Extensions for kotlin.collections.List

| Name | Summary |
|---|---|
| [toCStringArray](to-c-string-array.md) | `fun `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.toCStringArray(autofreeScope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`CPointerVar`](../-c-pointer-var.md)`<`[`ByteVar`](../-byte-var.md)`>>`<br>Convert this list of Kotlin strings to C array of C strings, allocating memory for the array and C strings with given [AutofreeScope](../-autofree-scope/index.md). |
| [toCValues](to-c-values.md) | `fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CPointer`](../-c-pointer/index.md)`<`[`T`](to-c-values.md#T)`>?>.toCValues(): <ERROR CLASS>` |
