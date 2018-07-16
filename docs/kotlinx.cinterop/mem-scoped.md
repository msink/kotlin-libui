[kotlinx.cinterop](index.md) / [memScoped](./mem-scoped.md)

# memScoped

`inline fun <R> memScoped(block: `[`MemScope`](-mem-scope/index.md)`.() -> `[`R`](mem-scoped.md#R)`): `[`R`](mem-scoped.md#R)

Runs given [block](mem-scoped.md#kotlinx.cinterop$memScoped(kotlin.Function1((kotlinx.cinterop.MemScope, kotlinx.cinterop.memScoped.R)))/block) providing allocation of memory
which will be automatically disposed at the end of this scope.

