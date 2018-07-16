[kotlinx.cinterop](../index.md) / [CStructVar](./index.md)

# CStructVar

`abstract class CStructVar : `[`CVariable`](../-c-variable/index.md)

The C struct-typed variable located in memory.

### Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | `open class Type : `[`Type`](../-c-variable/-type/index.md) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CStructVar(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`<br>The C struct-typed variable located in memory. |

### Extension Properties

| Name | Summary |
|---|---|
| [rawPtr](../raw-ptr.md) | `val `[`NativePointed`](../-native-pointed/index.md)`?.rawPtr: `[`NativePtr`](../-native-ptr.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [arrayMemberAt](../array-member-at.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CStructVar`](./index.md)`.arrayMemberAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`CArrayPointer`](../-c-array-pointer.md)`<`[`T`](../array-member-at.md#T)`>` |
| [memberAt](../member-at.md) | `fun <T : `[`CPointed`](../-c-pointed/index.md)`> `[`CStructVar`](./index.md)`.memberAt(offset: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`T`](../member-at.md#T)<br>Returns the member of this [CStructVar](./index.md) which is located by given offset in bytes. |
| [readValue](../read-value.md) | `fun <T : `[`CStructVar`](./index.md)`> `[`T`](../read-value.md#T)`.readValue(): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>`<br>`fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValue(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValue`](../-c-value/index.md)`<`[`T`](../read-value.md#T)`>` |
| [readValues](../read-values.md) | `fun <T : `[`CVariable`](../-c-variable/index.md)`> `[`CPointed`](../-c-pointed/index.md)`.readValues(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CValues`](../-c-values/index.md)`<`[`T`](../read-values.md#T)`>` |
| [reinterpret](../reinterpret.md) | `fun <T : `[`NativePointed`](../-native-pointed/index.md)`> `[`NativePointed`](../-native-pointed/index.md)`.reinterpret(): `[`T`](../reinterpret.md#T)<br>Changes the interpretation of the pointed data or code. |

### Inheritors

| Name | Summary |
|---|---|
| [ktAreaHandler](../../libui/kt-area-handler/index.md) | `class ktAreaHandler : `[`CStructVar`](./index.md) |
| [ktTableHandler](../../libui/kt-table-handler/index.md) | `class ktTableHandler : `[`CStructVar`](./index.md) |
| [uiAreaDrawParams](../../libui/ui-area-draw-params/index.md) | `class uiAreaDrawParams : `[`CStructVar`](./index.md) |
| [uiAreaHandler](../../libui/ui-area-handler/index.md) | `class uiAreaHandler : `[`CStructVar`](./index.md) |
| [uiAreaKeyEvent](../../libui/ui-area-key-event/index.md) | `class uiAreaKeyEvent : `[`CStructVar`](./index.md) |
| [uiAreaMouseEvent](../../libui/ui-area-mouse-event/index.md) | `class uiAreaMouseEvent : `[`CStructVar`](./index.md) |
| [uiControl](../../libui/ui-control/index.md) | `class uiControl : `[`CStructVar`](./index.md) |
| [uiDrawBrush](../../libui/ui-draw-brush/index.md) | `class uiDrawBrush : `[`CStructVar`](./index.md) |
| [uiDrawBrushGradientStop](../../libui/ui-draw-brush-gradient-stop/index.md) | `class uiDrawBrushGradientStop : `[`CStructVar`](./index.md) |
| [uiDrawMatrix](../../libui/ui-draw-matrix/index.md) | `class uiDrawMatrix : `[`CStructVar`](./index.md) |
| [uiDrawStrokeParams](../../libui/ui-draw-stroke-params/index.md) | `class uiDrawStrokeParams : `[`CStructVar`](./index.md) |
| [uiDrawTextLayoutParams](../../libui/ui-draw-text-layout-params/index.md) | `class uiDrawTextLayoutParams : `[`CStructVar`](./index.md) |
| [uiFontDescriptor](../../libui/ui-font-descriptor/index.md) | `class uiFontDescriptor : `[`CStructVar`](./index.md) |
| [uiInitOptions](../../libui/ui-init-options/index.md) | `class uiInitOptions : `[`CStructVar`](./index.md) |
| [uiTableModelHandler](../../libui/ui-table-model-handler/index.md) | `class uiTableModelHandler : `[`CStructVar`](./index.md) |
| [uiTableParams](../../libui/ui-table-params/index.md) | `class uiTableParams : `[`CStructVar`](./index.md) |
| [uiTableTextColumnOptionalParams](../../libui/ui-table-text-column-optional-params/index.md) | `class uiTableTextColumnOptionalParams : `[`CStructVar`](./index.md) |
