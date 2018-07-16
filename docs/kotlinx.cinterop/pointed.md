[kotlinx.cinterop](index.md) / [pointed](./pointed.md)

# pointed

`inline val <reified T : `[`CPointed`](-c-pointed/index.md)`> `[`CPointer`](-c-pointer/index.md)`<`[`T`](pointed.md#T)`>.pointed: `[`T`](pointed.md#T)

Returns the corresponding [CPointed](-c-pointed/index.md).

### Parameters

`T` - must not be abstract`inline var <reified T : `[`CPointed`](-c-pointed/index.md)`, reified P : `[`CPointer`](-c-pointer/index.md)`<`[`T`](pointed.md#T)`>> `[`CPointerVarOf`](-c-pointer-var-of/index.md)`<`[`P`](pointed.md#P)`>.pointed: `[`T`](pointed.md#T)`?`

The code or data pointed by the value of this variable.

### Parameters

`T` - must not be abstract