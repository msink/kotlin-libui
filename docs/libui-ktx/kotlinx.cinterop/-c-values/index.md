[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CValues](./index.md)

# CValues

`abstract class CValues<T : `[`CVariable`](../-c-variable/index.md)`> : `[`CValuesRef`](../-c-values-ref/index.md)`<`[`T`](index.md#T)`>`

The (possibly empty) sequence of immutable C values.
It is self-contained and doesn't depend on native memory.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CValues()`<br>The (possibly empty) sequence of immutable C values. It is self-contained and doesn't depend on native memory. |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `abstract val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getPointer](get-pointer.md) | `abstract fun getPointer(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](index.md#T)`>`<br>Copies the values to [placement](#) and returns the pointer to the copy. |
| [hashCode](hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Extension Properties

| Name | Summary |
|---|---|
| [ptr](../-mem-scope/ptr.md) | `val <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](./index.md)`<`[`T`](../-mem-scope/ptr.md#T)`>.ptr: `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../-mem-scope/ptr.md#T)`>` |

### Extension Functions

| Name | Summary |
|---|---|
| [getBytes](../get-bytes.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](./index.md)`<`[`T`](../get-bytes.md#T)`>.getBytes(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [placeTo](../place-to.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](./index.md)`<`[`T`](../place-to.md#T)`>.placeTo(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../place-to.md#T)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [CValue](../-c-value/index.md) | `abstract class CValue<T : `[`CVariable`](../-c-variable/index.md)`> : `[`CValues`](./index.md)`<`[`T`](../-c-value/index.md#T)`>`<br>The single immutable C value. It is self-contained and doesn't depend on native memory. |
