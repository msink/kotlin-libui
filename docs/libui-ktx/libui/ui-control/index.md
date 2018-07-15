[libui-ktx](../../index.md) / [libui](../index.md) / [uiControl](./index.md)

# uiControl

`class uiControl : `[`CStructVar`](../../kotlinx.cinterop/-c-struct-var/index.md)

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : `[`Type`](../../kotlinx.cinterop/-c-struct-var/-type/index.md) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiControl(rawPtr: `[`NativePtr`](../../kotlinx.cinterop/-native-ptr.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [Destroy](-destroy.md) | `var Destroy: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [Disable](-disable.md) | `var Disable: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [Enable](-enable.md) | `var Enable: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [Enabled](-enabled.md) | `var Enabled: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>>?` |
| [Handle](-handle.md) | `var Handle: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`uintptr_t`](../../platform.posix/uintptr_t.md)`>>?` |
| [Hide](-hide.md) | `var Hide: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [OSSignature](-o-s-signature.md) | `var OSSignature: `[`uint32_t`](../../platform.posix/uint32_t.md) |
| [Parent](-parent.md) | `var Parent: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?>>?` |
| [SetParent](-set-parent.md) | `var SetParent: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?, `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [Show](-show.md) | `var Show: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>?` |
| [Signature](-signature.md) | `var Signature: `[`uint32_t`](../../platform.posix/uint32_t.md) |
| [Toplevel](-toplevel.md) | `var Toplevel: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>>?` |
| [TypeSignature](-type-signature.md) | `var TypeSignature: `[`uint32_t`](../../platform.posix/uint32_t.md) |
| [Visible](-visible.md) | `var Visible: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`CFunction`](../../kotlinx.cinterop/-c-function/index.md)`<(`[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](./index.md)`>?) -> `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>>?` |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../../kotlinx.cinterop/raw-ptr.md) | `val `[`NativePointed`](../../kotlinx.cinterop/-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../../kotlinx.cinterop/-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [arrayMemberAt](../../kotlinx.cinterop/array-member-at.md) | `fun <T : `[`CVariable`](../../kotlinx.cinterop/-c-variable/index.md)`> `[`CStructVar`](../../kotlinx.cinterop/-c-struct-var/index.md)`.arrayMemberAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`CArrayPointer`](../../kotlinx.cinterop/-c-array-pointer.md)`<`[`T`](../../kotlinx.cinterop/array-member-at.md#T)`>` |
| [memberAt](../../kotlinx.cinterop/member-at.md) | `fun <T : `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`> `[`CStructVar`](../../kotlinx.cinterop/-c-struct-var/index.md)`.memberAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`T`](../../kotlinx.cinterop/member-at.md#T)<br>Returns the member of this [CStructVar](../../kotlinx.cinterop/-c-struct-var/index.md) which is located by given offset in bytes. |
| [readValue](../../kotlinx.cinterop/read-value.md) | `fun <T : `[`CVariable`](../../kotlinx.cinterop/-c-variable/index.md)`> `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../../kotlinx.cinterop/-c-value/index.md)`<`[`T`](../../kotlinx.cinterop/read-value.md#T)`>` |
| [readValues](../../kotlinx.cinterop/read-values.md) | `fun <T : `[`CVariable`](../../kotlinx.cinterop/-c-variable/index.md)`> `[`CPointed`](../../kotlinx.cinterop/-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../../kotlinx.cinterop/-c-values/index.md)`<`[`T`](../../kotlinx.cinterop/read-values.md#T)`>` |
| [reinterpret](../../kotlinx.cinterop/reinterpret.md) | `fun <T : `[`NativePointed`](../../kotlinx.cinterop/-native-pointed/index.md)`> `[`NativePointed`](../../kotlinx.cinterop/-native-pointed/index.md)`.reinterpret(): `[`T`](../../kotlinx.cinterop/reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |
