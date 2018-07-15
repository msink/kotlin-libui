[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CPointerVarOf](./index.md)

# CPointerVarOf

`class CPointerVarOf<T : `[`CPointer`](../-c-pointer/index.md)`<*>> : `[`CVariable`](../-c-variable/index.md)

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : `[`Type`](../-c-variable/-type/index.md) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CPointerVarOf(rawPtr: `[`NativePtr`](../-native-ptr.md)`)` |

### Inherited Companion Object Properties

| Name | Summary |
|---|---|
| [align](../-c-variable/-type/align.md) | `val align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>the alignments in bytes that is enough for this data type. It may be greater than actually required for simplicity. |
| [size](../-c-variable/-type/size.md) | `val size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the size in bytes of data of this type |

### Extension Properties

| Name | Summary |
|---|---|
| [pointed](../pointed.md) | `var <T : `[`CPointed`](../-c-pointed/index.md)`, P : `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../pointed.md#T)`>> `[`CPointerVarOf`](./index.md)`<`[`P`](../pointed.md#P)`>.pointed: `[`T`](../pointed.md#T)`?`<br>The code or data pointed by the value of this variable. |
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |
| [value](../value.md) | `var <P : `[`CPointer`](../-c-pointer/index.md)`<*>> `[`CPointerVarOf`](./index.md)`<`[`P`](../value.md#P)`>.value: `[`P`](../value.md#P)`?`<br>The value of this variable. |

### Extension Functions

| Name | Summary |
|---|---|
| [readValue](../read-value.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |
