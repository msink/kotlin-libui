[kotlinx.cinterop](index.md) / [interpretNullablePointed](./interpret-nullable-pointed.md)

# interpretNullablePointed

`inline fun <reified T : `[`NativePointed`](-native-pointed/index.md)`> interpretNullablePointed(ptr: `[`NativePtr`](-native-ptr.md)`): `[`T`](interpret-nullable-pointed.md#T)`?`

Returns interpretation of entity with given pointer, or `null` if it is null.

### Parameters

`T` - must not be abstract