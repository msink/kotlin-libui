[kotlinx.cinterop](../index.md) / [MemScope](./index.md)

# MemScope

`class MemScope : `[`ArenaBase`](../-arena-base/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MemScope()` |

### Properties

| Name | Summary |
|---|---|
| [memScope](mem-scope.md) | `val memScope: `[`MemScope`](./index.md) |
| [ptr](ptr.md) | `val <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](../-c-values/index.md)`<`[`T`](ptr.md#T)`>.ptr: `[`CPointer`](../-c-pointer/index.md)`<`[`T`](ptr.md#T)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [alloc](../-arena-base/alloc.md) | `fun alloc(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`NativePointed`](../-native-pointed/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [alloc](../alloc.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.alloc(): `[`T`](../alloc.md#T)<br>Allocates variable of given type. |
| [allocArray](../alloc-array.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArray(length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`T`](../alloc-array.md#T)`>`<br>`fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArray(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`T`](../alloc-array.md#T)`>`<br>Allocates C array of given elements type and length.`fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArray(length: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, initializer: `[`T`](../alloc-array.md#T)`.(index: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`T`](../alloc-array.md#T)`>`<br>`fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArray(length: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, initializer: `[`T`](../alloc-array.md#T)`.(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`T`](../alloc-array.md#T)`>`<br>Allocates C array of given elements type and length, and initializes its elements applying given block. |
| [allocArrayOf](../alloc-array-of.md) | `fun <T : `[`CPointer`](../-c-pointer/index.md)`<*>> `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOf(vararg elements: `[`T`](../alloc-array-of.md#T)`?): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`CPointerVarOf`](../-c-pointer-var-of/index.md)`<`[`T`](../alloc-array-of.md#T)`>>`<br>`fun <T : `[`CPointer`](../-c-pointer/index.md)`<*>> `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOf(elements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../alloc-array-of.md#T)`?>): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`CPointerVarOf`](../-c-pointer-var-of/index.md)`<`[`T`](../alloc-array-of.md#T)`>>`<br>Allocates C array of given values.`fun `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOf(elements: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`ByteVar`](../-byte-var.md)`>`<br>`fun `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOf(vararg elements: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`FloatVar`](../-float-var.md)`>` |
| [allocArrayOfPointersTo](../alloc-array-of-pointers-to.md) | `fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOfPointersTo(elements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../alloc-array-of-pointers-to.md#T)`?>): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`CPointerVar`](../-c-pointer-var.md)`<`[`T`](../alloc-array-of-pointers-to.md#T)`>>`<br>`fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocArrayOfPointersTo(vararg elements: `[`T`](../alloc-array-of-pointers-to.md#T)`?): <ERROR CLASS>`<br>Allocates C array of pointers to given elements. |
| [allocPointerTo](../alloc-pointer-to.md) | `fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`NativePlacement`](../-native-placement/index.md)`.allocPointerTo(): `[`CPointerVar`](../-c-pointer-var.md)`<`[`T`](../alloc-pointer-to.md#T)`>` |