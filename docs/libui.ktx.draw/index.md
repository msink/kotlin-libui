[libui.ktx.draw](./index.md)

## Package libui.ktx.draw

### Types

| Name | Summary |
|---|---|
| [Attribute](-attribute/index.md) | `abstract class Attribute : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiAttribute`](../libui/ui-attribute.md)`>`<br>Stores information about an attribute in a [AttributedString](-attributed-string/index.md). |
| [AttributedString](-attributed-string/index.md) | `class AttributedString : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiAttributedString`](../libui/ui-attributed-string.md)`>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [BackgroundAttribute](-background-attribute/index.md) | `class BackgroundAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the background color of the text it is applied to. |
| [Brush](-brush/index.md) | `class Brush : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiDrawBrush`](../libui/ui-draw-brush/index.md)`>`<br>Defines the color(s) to draw a path with. |
| [Color](-color/index.md) | `data class Color` |
| [ColorAttribute](-color-attribute/index.md) | `class ColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the text it is applied to. |
| [FamilyAttribute](-family-attribute/index.md) | `class FamilyAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the font family of the text it is applied to. |
| [FeaturesAttribute](-features-attribute/index.md) | `class FeaturesAttribute : `[`Attribute`](-attribute/index.md)<br>Creates a new Attribute that changes the font family of the text it is applied to. otf is copied you may free it. |
| [Font](-font/index.md) | `class Font : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiFontDescriptor`](../libui/ui-font-descriptor/index.md)`>`<br>Provides a complete description of a font where one is needed. |
| [Image](-image/index.md) | `class Image : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiImage`](../libui/ui-image.md)`>` |
| [ImageData](-image-data/index.md) | `class ImageData` |
| [ItalicAttribute](-italic-attribute/index.md) | `class ItalicAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the italic mode of the text it is applied to. |
| [Matrix](-matrix/index.md) | `class Matrix : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiDrawMatrix`](../libui/ui-draw-matrix/index.md)`>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](-open-type-features/index.md) | `class OpenTypeFeatures : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiOpenTypeFeatures`](../libui/ui-open-type-features.md)`>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [Path](-path/index.md) | `class Path : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiDrawPath`](../libui/ui-draw-path.md)`>`<br>Represent a path that could be drawed on a [DrawContext](../libui.ktx/-draw-context.md) |
| [Point](-point/index.md) | `data class Point` |
| [Size](-size/index.md) | `data class Size` |
| [SizeAttribute](-size-attribute/index.md) | `class SizeAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the size of the text it is applied to, in typographical points. |
| [SizeInt](-size-int/index.md) | `data class SizeInt` |
| [StretchAttribute](-stretch-attribute/index.md) | `class StretchAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the stretch of the text it is applied to. |
| [Stroke](-stroke/index.md) | `class Stroke : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`>`<br>Describes the stroke to draw with. |
| [TextLayout](-text-layout/index.md) | `class TextLayout : `[`Disposable`](../libui.ktx/-disposable/index.md)`<`[`uiDrawTextLayout`](../libui/ui-draw-text-layout.md)`>`<br>Representation of a [AttributedString](-attributed-string/index.md) that can be displayed in a [DrawContext](../libui.ktx/-draw-context.md). |
| [UnderlineAttribute](-underline-attribute/index.md) | `class UnderlineAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the type of underline on the text it is applied to. |
| [UnderlineColorAttribute](-underline-color-attribute/index.md) | `class UnderlineColorAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the color of the underline on the text it is applied to. |
| [WeightAttribute](-weight-attribute/index.md) | `class WeightAttribute : `[`Attribute`](-attribute/index.md)<br>Changes the weight of the text it is applied to. |

### Functions

| Name | Summary |
|---|---|
| [bitmap](bitmap.md) | `fun `[`Image`](-image/index.md)`.bitmap(data: `[`ImageData`](-image-data/index.md)`): Unit` |
| [brush](brush.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/index.md)`.brush(): `[`Brush`](-brush/index.md)<br>Creates a new [Brush](-brush/index.md) with lifecycle delegated to [DrawArea](../libui.ktx/-draw-area/index.md). |
| [fill](fill.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit`<br>Draw a path filled with a color.`fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](-brush/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit` |
| [image](image.md) | `fun `[`Table`](../libui.ktx/-table/index.md)`<*>.image(width: Int, height: Int, block: `[`Image`](-image/index.md)`.() -> Unit = {}): `[`Image`](-image/index.md) |
| [string](string.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/index.md)`.string(init: String): `[`AttributedString`](-attributed-string/index.md)<br>Creates a new [AttributedString](-attributed-string/index.md) from initial String. The string will be entirely unattributed. |
| [stroke](stroke.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit`<br>Draw a path in the context.`fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](-brush/index.md)`, stroke: `[`Stroke`](-stroke/index.md)`, block: `[`Path`](-path/index.md)`.() -> Unit): Unit``fun `[`DrawArea`](../libui.ktx/-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/index.md)`.() -> Unit = {}): `[`Stroke`](-stroke/index.md)<br>Creates a new [Stroke](-stroke/index.md) with lifecycle delegated to [DrawArea](../libui.ktx/-draw-area/index.md). |
| [text](text.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](-attributed-string/index.md)`, defaultFont: `[`Font`](-font/index.md)`, width: Double, align: `[`uiDrawTextAlign`](../libui/ui-draw-text-align.md)`, x: Double, y: Double): Unit`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](transform.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](-matrix/index.md)`.() -> Unit): Unit`<br>Apply a different transform matrix to the context. |
