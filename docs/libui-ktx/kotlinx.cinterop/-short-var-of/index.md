[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [ShortVarOf](./index.md)

# ShortVarOf

`class ShortVarOf<T : `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`> : `[`CPrimitiveVar`](../-c-primitive-var/index.md)

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : `[`Type`](../-c-primitive-var/-type/index.md) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ShortVarOf(rawPtr: `[`NativePtr`](../-native-ptr.md)`)` |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |
| [value](../value.md) | `var <T : `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`> `[`ShortVarOf`](./index.md)`<`[`T`](../value.md#T)`>.value: `[`T`](../value.md#T) |

### Extension Functions

| Name | Summary |
|---|---|
| [readValue](../read-value.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |
