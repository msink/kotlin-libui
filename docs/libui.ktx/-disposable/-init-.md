[libui.ktx](../index.md) / [Disposable](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Disposable(alloc: CPointer<`[`T`](index.md#T)`>?)`

Base class for all objects that have a holder reference to the native C resource(s).

* Allocates one resource during construction,
    and may allocate some additional resources during operation.
* Must free all its resource once [dispose](dispose.md) is invoked.
* [disposed](disposed.md) is a final state of the class, it is not supposed
    to be used after being disposed.
