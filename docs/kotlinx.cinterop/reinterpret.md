[kotlinx.cinterop](index.md) / [reinterpret](./reinterpret.md)

# reinterpret

`inline fun <reified T : `[`NativePointed`](-native-pointed/index.md)`> `[`NativePointed`](-native-pointed/index.md)`.reinterpret(): `[`T`](reinterpret.md#T)

Changes the interpretation of the pointed data or code.

`fun <T : `[`CPointed`](-c-pointed/index.md)`> `[`CPointer`](-c-pointer/index.md)`<*>.reinterpret(): `[`CPointer`](-c-pointer/index.md)`<`[`T`](reinterpret.md#T)`>`