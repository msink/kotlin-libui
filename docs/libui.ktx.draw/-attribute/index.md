[libui.ktx.draw](../index.md) / [Attribute](./index.md)

# Attribute

`abstract class Attribute : `[`Disposable`](../../libui.ktx/-disposable/index.md)`<`[`uiAttribute`](../../libui/ui-attribute.md)`>`

Stores information about an attribute in a [AttributedString](../-attributed-string/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Attribute(alloc: CPointer<`[`uiAttribute`](../../libui/ui-attribute.md)`>?)`<br>Stores information about an attribute in a [AttributedString](../-attributed-string/index.md). |

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `val type: `[`uiAttributeType`](../../libui/ui-attribute-type.md)<br>Returns the type of Attribute. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |

### Inheritors

| Name | Summary |
|---|---|
| [BackgroundAttribute](../-background-attribute/index.md) | `class BackgroundAttribute : `[`Attribute`](./index.md)<br>Changes the background color of the text it is applied to. |
| [ColorAttribute](../-color-attribute/index.md) | `class ColorAttribute : `[`Attribute`](./index.md)<br>Changes the color of the text it is applied to. |
| [FamilyAttribute](../-family-attribute/index.md) | `class FamilyAttribute : `[`Attribute`](./index.md)<br>Changes the font family of the text it is applied to. |
| [FeaturesAttribute](../-features-attribute/index.md) | `class FeaturesAttribute : `[`Attribute`](./index.md)<br>Creates a new Attribute that changes the font family of the text it is applied to. otf is copied you may free it. |
| [ItalicAttribute](../-italic-attribute/index.md) | `class ItalicAttribute : `[`Attribute`](./index.md)<br>Changes the italic mode of the text it is applied to. |
| [SizeAttribute](../-size-attribute/index.md) | `class SizeAttribute : `[`Attribute`](./index.md)<br>Changes the size of the text it is applied to, in typographical points. |
| [StretchAttribute](../-stretch-attribute/index.md) | `class StretchAttribute : `[`Attribute`](./index.md)<br>Changes the stretch of the text it is applied to. |
| [UnderlineAttribute](../-underline-attribute/index.md) | `class UnderlineAttribute : `[`Attribute`](./index.md)<br>Changes the type of underline on the text it is applied to. |
| [UnderlineColorAttribute](../-underline-color-attribute/index.md) | `class UnderlineColorAttribute : `[`Attribute`](./index.md)<br>Changes the color of the underline on the text it is applied to. |
| [WeightAttribute](../-weight-attribute/index.md) | `class WeightAttribute : `[`Attribute`](./index.md)<br>Changes the weight of the text it is applied to. |
