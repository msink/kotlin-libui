[kotlinx.cinterop](index.md) / [readValue](./read-value.md)

# readValue

`fun <T : `[`CVariable`](-c-variable/index.md)`> `[`CPointed`](-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](-c-value/index.md)`<`[`T`](read-value.md#T)`>`
`inline fun <reified T : `[`CStructVar`](-c-struct-var/index.md)`> `[`T`](read-value.md#T)`.readValue(): `[`CValue`](-c-value/index.md)`<`[`T`](read-value.md#T)`>`