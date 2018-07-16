[kotlinx.cinterop](../index.md) / [CVariable](./index.md)

# CVariable

`abstract class CVariable : `[`CPointed`](../-c-pointed/index.md)

The C data variable located in memory.

The non-abstract subclasses should represent the (complete) C data type and thus specify size and alignment.
Each such subclass must have a companion object which is a [Type](-type/index.md).

### Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | `open class Type`<br>The (complete) C data type. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CVariable(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`<br>The C data variable located in memory. |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [readValue](../read-value.md) | `fun <T : `[`CVariable`](./index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](./index.md)`> `[`T`](../read-values.md#T)`.readValues(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>`<br>`fun <T : `[`CVariable`](./index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |

### Inheritors

| Name | Summary |
|---|---|
| [CPointerVarOf](../-c-pointer-var-of/index.md) | `class CPointerVarOf<T : `[`CPointer`](../-c-pointer/index.md)`<*>> : `[`CVariable`](./index.md) |
| [CPrimitiveVar](../-c-primitive-var/index.md) | `sealed class CPrimitiveVar : `[`CVariable`](./index.md)<br>The C primitive-typed variable located in memory. |
| [CStructVar](../-c-struct-var/index.md) | `abstract class CStructVar : `[`CVariable`](./index.md)<br>The C struct-typed variable located in memory. |
