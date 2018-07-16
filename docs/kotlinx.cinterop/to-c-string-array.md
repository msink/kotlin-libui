[kotlinx.cinterop](index.md) / [toCStringArray](./to-c-string-array.md)

# toCStringArray

`fun `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>.toCStringArray(autofreeScope: `[`AutofreeScope`](-autofree-scope/index.md)`): `[`CPointer`](-c-pointer/index.md)`<`[`CPointerVar`](-c-pointer-var.md)`<`[`ByteVar`](-byte-var.md)`>>`

Convert this array of Kotlin strings to C array of C strings,
allocating memory for the array and C strings with given [AutofreeScope](-autofree-scope/index.md).

