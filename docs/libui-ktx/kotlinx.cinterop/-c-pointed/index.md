[libui-ktx](../../index.md) / [kotlinx.cinterop](../index.md) / [CPointed](./index.md)

# CPointed

`abstract class CPointed : `[`NativePointed`](../-native-pointed/index.md)

C data or code.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CPointed(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`<br>C data or code. |

### Inherited Properties

| Name | Summary |
|---|---|
| [rawPtr](../-native-pointed/raw-ptr.md) | `var rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Properties

| Name | Summary |
|---|---|
| [ptr](../ptr.md) | `val <T : `[`CPointed`](./index.md)`> `[`T`](../ptr.md#T)`.ptr: `[`CPointer`](../-c-pointer/index.md)`<`[`T`](../ptr.md#T)`>`<br>Returns the pointer to this data or code. |
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [readValue](../read-value.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](./index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](./index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |

### Inheritors

| Name | Summary |
|---|---|
| [CFunction](../-c-function/index.md) | `class CFunction<T : `[`Function`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-function/index.html)`<*>> : `[`CPointed`](./index.md)<br>The C function. |
| [COpaque](../-c-opaque/index.md) | `abstract class COpaque : `[`CPointed`](./index.md)<br>The [CPointed](./index.md) without any specified interpretation. |
| [CVariable](../-c-variable/index.md) | `abstract class CVariable : `[`CPointed`](./index.md)<br>The C data variable located in memory. |
