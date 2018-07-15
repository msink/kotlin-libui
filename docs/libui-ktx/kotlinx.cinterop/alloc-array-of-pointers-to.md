[libui-ktx](../index.md) / [kotlinx.cinterop](index.md) / [allocArrayOfPointersTo](./alloc-array-of-pointers-to.md)

# allocArrayOfPointersTo

`fun <T : `[`CPointed`](-c-pointed/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArrayOfPointersTo(elements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](alloc-array-of-pointers-to.md#T)`?>): `[`CArrayPointer`](-c-array-pointer.md)`<`[`CPointerVar`](-c-pointer-var.md)`<`[`T`](alloc-array-of-pointers-to.md#T)`>>`
`fun <T : `[`CPointed`](-c-pointed/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArrayOfPointersTo(vararg elements: `[`T`](alloc-array-of-pointers-to.md#T)`?): <ERROR CLASS>`

Allocates C array of pointers to given elements.

