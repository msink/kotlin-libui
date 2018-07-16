[kotlinx.cinterop](../index.md) / [CValuesRef](index.md) / [getPointer](./get-pointer.md)

# getPointer

`abstract fun getPointer(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](index.md#T)`>`

If this reference is [CPointer](../-c-pointer/index.md), returns this pointer.
Otherwise copies the referenced values to [placement](#) and returns the pointer to the copy.

