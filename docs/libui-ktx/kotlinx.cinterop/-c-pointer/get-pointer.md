[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CPointer](index.md) / [getPointer](./get-pointer.md)

# getPointer

`fun getPointer(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](index.md)`<`[`T`](index.md#T)`>`

Overrides [CValuesRef.getPointer](../-c-values-ref/get-pointer.md)

If this reference is [CPointer](index.md), returns this pointer.
Otherwise copies the referenced values to [placement](#) and returns the pointer to the copy.

