[kotlinx.cinterop](../index.md) / [CPrimitiveVar](./index.md)

# CPrimitiveVar

`sealed class CPrimitiveVar : `[`CVariable`](../-c-variable/index.md)

The C primitive-typed variable located in memory.

### Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | `open class Type : `[`Type`](../-c-variable/-type/index.md) |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [readValue](../read-value.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanVarOf](../-boolean-var-of/index.md) | `class BooleanVarOf<T : `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [ByteVarOf](../-byte-var-of/index.md) | `class ByteVarOf<T : `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [CEnumVar](../-c-enum-var/index.md) | `abstract class CEnumVar : `[`CPrimitiveVar`](./index.md) |
| [DoubleVarOf](../-double-var-of/index.md) | `class DoubleVarOf<T : `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [FloatVarOf](../-float-var-of/index.md) | `class FloatVarOf<T : `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [IntVarOf](../-int-var-of/index.md) | `class IntVarOf<T : `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [LongVarOf](../-long-var-of/index.md) | `class LongVarOf<T : `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`> : `[`CPrimitiveVar`](./index.md) |
| [ShortVarOf](../-short-var-of/index.md) | `class ShortVarOf<T : `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`> : `[`CPrimitiveVar`](./index.md) |
