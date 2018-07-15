[libui-ktx](../index.md) / [kotlinx.cinterop](index.md) / [allocArray](./alloc-array.md)

# allocArray

`inline fun <reified T : `[`CVariable`](-c-variable/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArray(length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`T`](alloc-array.md#T)`>`
`inline fun <reified T : `[`CVariable`](-c-variable/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArray(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`T`](alloc-array.md#T)`>`

Allocates C array of given elements type and length.

### Parameters

`T` - must not be abstract`inline fun <reified T : `[`CVariable`](-c-variable/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArray(length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, initializer: `[`T`](alloc-array.md#T)`.(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`T`](alloc-array.md#T)`>`
`inline fun <reified T : `[`CVariable`](-c-variable/index.md)`> `[`NativePlacement`](-native-placement/index.md)`.allocArray(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, initializer: `[`T`](alloc-array.md#T)`.(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`CArrayPointer`](-c-array-pointer.md)`<`[`T`](alloc-array.md#T)`>`

Allocates C array of given elements type and length, and initializes its elements applying given block.

### Parameters

`T` - must not be abstract