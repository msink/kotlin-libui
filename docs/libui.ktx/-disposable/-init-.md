[libui.ktx](../index.md) / [Disposable](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Disposable(alloc: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](index.md#T)`>?)`

Manages and owns all its native resources.

* Allocates one resource during construction,
    and may allocate some additional resources during operation.
* Must free all its resource once [dispose](dispose.md) is invoked.
* [disposed](disposed.md) is a final state of the class, it is not supposed
    to be used after being disposed.
