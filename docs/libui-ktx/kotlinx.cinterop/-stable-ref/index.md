[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [StableRef](./index.md)

# StableRef

`data class StableRef<out T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

This class provides a way to create a stable handle to any Kotlin object.
After [converting to CPointer](as-c-pointer.md) it can be safely passed to native code e.g. to be received
in a Kotlin callback.

Any [StableRef](./index.md) should be manually [disposed](dispose.md)

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `val ~~value~~: `[`COpaquePointer`](../-c-opaque-pointer.md) |

### Functions

| Name | Summary |
|---|---|
| [asCPointer](as-c-pointer.md) | `fun asCPointer(): `[`COpaquePointer`](../-c-opaque-pointer.md)<br>Converts the handle to C pointer. |
| [dispose](dispose.md) | `fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disposes the handle. It must not be used after that. |
| [get](get.md) | `fun get(): `[`T`](index.md#T)<br>Returns the object this handle was [created](create.md) for. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> create(any: `[`T`](create.md#T)`): `[`StableRef`](./index.md)`<`[`T`](create.md#T)`>`<br>Creates a handle for given object. |
| [fromValue](from-value.md) | `fun ~~fromValue~~(value: `[`COpaquePointer`](../-c-opaque-pointer.md)`): `[`StableRef`](./index.md)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Creates [StableRef](./index.md) from given raw value. |
