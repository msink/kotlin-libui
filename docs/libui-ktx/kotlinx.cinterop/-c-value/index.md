[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CValue](./index.md)

# CValue

`abstract class CValue<T : `[`CVariable`](../-c-variable/index.md)`> : `[`CValues`](../-c-values/index.md)`<`[`T`](index.md#T)`>`

The single immutable C value.
It is self-contained and doesn't depend on native memory.

TODO: consider providing an adapter instead of subtyping [CValues](../-c-values/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CValue()`<br>The single immutable C value. It is self-contained and doesn't depend on native memory. |

### Inherited Properties

| Name | Summary |
|---|---|
| [size](../-c-values/size.md) | `abstract val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [equals](../-c-values/equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getPointer](../-c-values/get-pointer.md) | `abstract fun getPointer(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../-c-values/index.md#T)`>`<br>Copies the values to [placement](#) and returns the pointer to the copy. |
| [hashCode](../-c-values/hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [copy](../copy.md) | `fun <T : `[`CStructVar`](../-c-struct-var/index.md)`> `[`CValue`](./index.md)`<`[`T`](../copy.md#T)`>.copy(modify: `[`T`](../copy.md#T)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`CValue`](./index.md)`<`[`T`](../copy.md#T)`>` |
| [getBytes](../get-bytes.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](../-c-values/index.md)`<`[`T`](../get-bytes.md#T)`>.getBytes(): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html) |
| [placeTo](../place-to.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CValues`](../-c-values/index.md)`<`[`T`](../place-to.md#T)`>.placeTo(scope: `[`AutofreeScope`](../-autofree-scope/index.md)`): `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../place-to.md#T)`>` |
| [useContents](../use-contents.md) | `fun <T : `[`CStructVar`](../-c-struct-var/index.md)`, R> `[`CValue`](./index.md)`<`[`T`](../use-contents.md#T)`>.useContents(block: `[`T`](../use-contents.md#T)`.() -> `[`R`](../use-contents.md#R)`): `[`R`](../use-contents.md#R)<br>Calls the [block](../use-contents.md#kotlinx.cinterop$useContents(kotlinx.cinterop.CValue((kotlinx.cinterop.useContents.T)), kotlin.Function1((kotlinx.cinterop.useContents.T, kotlinx.cinterop.useContents.R)))/block) with temporary copy if this value as receiver. |
| [write](../write.md) | `fun `[`CValue`](./index.md)`<*>.write(location: `[`NativePtr`](../-native-ptr.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
