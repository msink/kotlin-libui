[kotlinx.cinterop](../index.md) / [NativePointed](./index.md)

# NativePointed

`abstract class NativePointed`

The entity which has an associated native pointer.
Subtypes are supposed to represent interpretations of the pointed data or code.

This interface is likely to be handled by compiler magic and shouldn't be subtyped by arbitrary classes.

TODO: the behavior of [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html), [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html) and [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html) differs on Native and JVM backends.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NativePointed(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`<br>The entity which has an associated native pointer. Subtypes are supposed to represent interpretations of the pointed data or code. |

### Properties

| Name | Summary |
|---|---|
| [rawPtr](raw-ptr.md) | `var rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](./index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](./index.md)`> `[`NativePointed`](./index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |

### Inheritors

| Name | Summary |
|---|---|
| [CPointed](../-c-pointed/index.md) | `abstract class CPointed : `[`NativePointed`](./index.md)<br>C data or code. |
