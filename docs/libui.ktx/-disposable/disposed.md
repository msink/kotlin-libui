[libui.ktx](../index.md) / [Disposable](index.md) / [disposed](./disposed.md)

# disposed

`val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if object was disposed - in this case [disposed](./disposed.md) will do nothing,
all other operations are invalid and will `throw Error("Resource is disposed")`.

