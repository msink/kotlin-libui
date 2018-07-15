[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [kotlin.Array](./index.md)

### Extensions for kotlin.Array

| Name | Summary |
|---|---|
| [toCStringArray](to-c-string-array.md) | `fun `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.toCStringArray(autofreeScope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`CPointerVar`](../-c-pointer-var.md)`<`[`ByteVar`](../-byte-var.md)`>>`<br>Convert this array of Kotlin strings to C array of C strings, allocating memory for the array and C strings with given [AutofreeScope](../-autofree-scope/index.md). |
| [toCValues](to-c-values.md) | `fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CPointer`](../-c-pointer/index.md)`<`[`T`](to-c-values.md#T)`>?>.toCValues(): `[`CValues`](../-c-values/index.md)`<`[`CPointerVar`](../-c-pointer-var.md)`<`[`T`](to-c-values.md#T)`>>` |
