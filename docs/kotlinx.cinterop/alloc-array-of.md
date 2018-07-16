[kotlinx.cinterop](index.md) / [allocArrayOf](./alloc-array-of.md)

# allocArrayOf

`inline fun <reified T : `[`CPointer`](-c-pointer/index.md)`<*>> `[`NativePlacement`](-native-placement/index.md)`.allocArrayOf(vararg elements: `[`T`](alloc-array-of.md#T)`?): `[`CArrayPointer`](-c-array-pointer.md)`<`[`CPointerVarOf`](-c-pointer-var-of/index.md)`<`[`T`](alloc-array-of.md#T)`>>`
`inline fun <reified T : `[`CPointer`](-c-pointer/index.md)`<*>> `[`NativePlacement`](-native-placement/index.md)`.allocArrayOf(elements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](alloc-array-of.md#T)`?>): `[`CArrayPointer`](-c-array-pointer.md)`<`[`CPointerVarOf`](-c-pointer-var-of/index.md)`<`[`T`](alloc-array-of.md#T)`>>`

Allocates C array of given values.

`fun `[`NativePlacement`](-native-placement/index.md)`.allocArrayOf(elements: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`ByteVar`](-byte-var.md)`>`
`fun `[`NativePlacement`](-native-placement/index.md)`.allocArrayOf(vararg elements: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`FloatVar`](-float-var.md)`>`