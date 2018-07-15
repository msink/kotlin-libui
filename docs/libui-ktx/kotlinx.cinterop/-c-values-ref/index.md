[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CValuesRef](./index.md)

# CValuesRef

`abstract class CValuesRef<T : `[`CPointed`](../-c-pointed/index.md)`>`

Represents a reference to (possibly empty) sequence of C values.
It can be either a stable pointer [CPointer](../-c-pointer/index.md) or a sequence of immutable values [CValues](../-c-values/index.md).

[CValuesRef](./index.md) is designed to be used as Kotlin representation of pointer-typed parameters of C functions.
When passing [CPointer](../-c-pointer/index.md) as [CValuesRef](./index.md) to the Kotlin binding method, the C function receives exactly this pointer.
Passing [CValues](../-c-values/index.md) has nearly the same semantics as passing by value: the C function receives
the pointer to the temporary copy of these values, and the caller can't observe the modifications to this copy.
The copy is valid until the C function returns.
There are also other implementations of [CValuesRef](./index.md) that provide temporary pointer,
e.g. Kotlin Native specific [refTo](#) functions to pass primitive arrays directly to native.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CValuesRef()`<br>Represents a reference to (possibly empty) sequence of C values. It can be either a stable pointer [CPointer](../-c-pointer/index.md) or a sequence of immutable values [CValues](../-c-values/index.md). |

### Functions

| Name | Summary |
|---|---|
| [getPointer](get-pointer.md) | `abstract fun getPointer(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](index.md#T)`>`<br>If this reference is [CPointer](../-c-pointer/index.md), returns this pointer. Otherwise copies the referenced values to [placement](#) and returns the pointer to the copy. |

### Inheritors

| Name | Summary |
|---|---|
| [CPointer](../-c-pointer/index.md) | `class CPointer<T : `[`CPointed`](../-c-pointed/index.md)`> : `[`CValuesRef`](./index.md)`<`[`T`](../-c-pointer/index.md#T)`>`<br>C pointer. |
| [CValues](../-c-values/index.md) | `abstract class CValues<T : `[`CVariable`](../-c-variable/index.md)`> : `[`CValuesRef`](./index.md)`<`[`T`](../-c-values/index.md#T)`>`<br>The (possibly empty) sequence of immutable C values. It is self-contained and doesn't depend on native memory. |
