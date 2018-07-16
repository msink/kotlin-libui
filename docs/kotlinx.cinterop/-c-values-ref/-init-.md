[kotlinx.cinterop](../index.md) / [CValuesRef](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CValuesRef()`

Represents a reference to (possibly empty) sequence of C values.
It can be either a stable pointer [CPointer](../-c-pointer/index.md) or a sequence of immutable values [CValues](../-c-values/index.md).

[CValuesRef](index.md) is designed to be used as Kotlin representation of pointer-typed parameters of C functions.
When passing [CPointer](../-c-pointer/index.md) as [CValuesRef](index.md) to the Kotlin binding method, the C function receives exactly this pointer.
Passing [CValues](../-c-values/index.md) has nearly the same semantics as passing by value: the C function receives
the pointer to the temporary copy of these values, and the caller can't observe the modifications to this copy.
The copy is valid until the C function returns.
There are also other implementations of [CValuesRef](index.md) that provide temporary pointer,
e.g. Kotlin Native specific [refTo](#) functions to pass primitive arrays directly to native.

