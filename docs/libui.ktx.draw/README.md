[libui.ktx.draw](README.md)

## Package libui.ktx.draw

### Types

| Name | Summary |
|---|---|
| [Attribute](-attribute/README.md) | `abstract class Attribute : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiAttribute`](../libui/ui-attribute.md)`>`<br>Stores information about an attribute in a [AttributedString](-attributed-string/README.md). |
| [AttributedString](-attributed-string/README.md) | `class AttributedString : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiAttributedString`](../libui/ui-attributed-string.md)`>`<br>Represents a string of UTF-8 text that can be embellished with formatting attributes. |
| [BackgroundAttribute](-background-attribute/README.md) | `class BackgroundAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the background color of the text it is applied to. |
| [Brush](-brush/README.md) | `class Brush : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiDrawBrush`](../libui/ui-draw-brush/README.md)`>`<br>Defines the color(s) to draw a path with. |
| [Color](-color/README.md) | `data class Color` |
| [ColorAttribute](-color-attribute/README.md) | `class ColorAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the color of the text it is applied to. |
| [FamilyAttribute](-family-attribute/README.md) | `class FamilyAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the font family of the text it is applied to. |
| [FeaturesAttribute](-features-attribute/README.md) | `class FeaturesAttribute : `[`Attribute`](-attribute/README.md)<br>Creates a new Attribute that changes the font family of the text it is applied to. otf is copied you may free it. |
| [Font](-font/README.md) | `class Font : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiFontDescriptor`](../libui/ui-font-descriptor/README.md)`>`<br>Provides a complete description of a font where one is needed. |
| [Image](-image/README.md) | `class Image : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiImage`](../libui/ui-image.md)`>` |
| [ImageData](-image-data/README.md) | `class ImageData` |
| [ItalicAttribute](-italic-attribute/README.md) | `class ItalicAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the italic mode of the text it is applied to. |
| [Matrix](-matrix/README.md) | `class Matrix : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiDrawMatrix`](../libui/ui-draw-matrix/README.md)`>`<br>Defines a transformation (e.g. rotation, translation) |
| [OpenTypeFeatures](-open-type-features/README.md) | `class OpenTypeFeatures : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiOpenTypeFeatures`](../libui/ui-open-type-features.md)`>`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |
| [Path](-path/README.md) | `class Path : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiDrawPath`](../libui/ui-draw-path.md)`>`<br>Represent a path that could be drawed on a [DrawContext](../libui.ktx/-draw-context.md) |
| [Point](-point/README.md) | `data class Point` |
| [Size](-size/README.md) | `data class Size` |
| [SizeAttribute](-size-attribute/README.md) | `class SizeAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the size of the text it is applied to, in typographical points. |
| [SizeInt](-size-int/README.md) | `data class SizeInt` |
| [StretchAttribute](-stretch-attribute/README.md) | `class StretchAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the stretch of the text it is applied to. |
| [Stroke](-stroke/README.md) | `class Stroke : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/README.md)`>`<br>Describes the stroke to draw with. |
| [TextLayout](-text-layout/README.md) | `class TextLayout : `[`Disposable`](../libui.ktx/-disposable/README.md)`<`[`uiDrawTextLayout`](../libui/ui-draw-text-layout.md)`>`<br>Representation of a [AttributedString](-attributed-string/README.md) that can be displayed in a [DrawContext](../libui.ktx/-draw-context.md). |
| [UnderlineAttribute](-underline-attribute/README.md) | `class UnderlineAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the type of underline on the text it is applied to. |
| [UnderlineColorAttribute](-underline-color-attribute/README.md) | `class UnderlineColorAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the color of the underline on the text it is applied to. |
| [WeightAttribute](-weight-attribute/README.md) | `class WeightAttribute : `[`Attribute`](-attribute/README.md)<br>Changes the weight of the text it is applied to. |

### Functions

| Name | Summary |
|---|---|
| [bitmap](bitmap.md) | `fun `[`Image`](-image/README.md)`.bitmap(data: `[`ImageData`](-image-data/README.md)`)` |
| [brush](brush.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/README.md)`.brush(): `[`Brush`](-brush/README.md)<br>Creates a new [Brush](-brush/README.md) with lifecycle delegated to [DrawArea](../libui.ktx/-draw-area/README.md). |
| [fill](fill.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.fill(brush: `[`Brush`](-brush/README.md)`, block: `[`Path`](-path/README.md)`.() -> Unit)`<br>`fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.fill(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/README.md)`, block: `[`Path`](-path/README.md)`.() -> Unit)`<br>Draw a path filled with a color. |
| [font](font.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/README.md)`.font(family: String? = null, size: Double = 0.0, weight: `[`uiTextWeight`](../libui/ui-text-weight.md)` = uiTextWeightNormal, italic: `[`uiTextItalic`](../libui/ui-text-italic.md)` = uiTextItalicNormal, stretch: `[`uiTextStretch`](../libui/ui-text-stretch.md)` = uiTextStretchNormal): `[`Font`](-font/README.md)<br>Creates a new [Font](-font/README.md) with lifecycle delegated to [DrawArea](../libui.ktx/-draw-area/README.md). |
| [image](image.md) | `fun `[`Table`](../libui.ktx/-table/README.md)`<*>.image(width: Int, height: Int, block: `[`Image`](-image/README.md)`.() -> Unit = {}): `[`Image`](-image/README.md) |
| [string](string.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/README.md)`.string(init: String): `[`AttributedString`](-attributed-string/README.md)<br>Creates a new [AttributedString](-attributed-string/README.md) from initial String. The string will be entirely unattributed. |
| [stroke](stroke.md) | `fun `[`DrawArea`](../libui.ktx/-draw-area/README.md)`.stroke(block: `[`uiDrawStrokeParams`](../libui/ui-draw-stroke-params/README.md)`.() -> Unit = {}): `[`Stroke`](-stroke/README.md)<br>Creates a new [Stroke](-stroke/README.md) with lifecycle delegated to [DrawArea](../libui.ktx/-draw-area/README.md).<br>`fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.stroke(brush: `[`Brush`](-brush/README.md)`, stroke: `[`Stroke`](-stroke/README.md)`, block: `[`Path`](-path/README.md)`.() -> Unit)`<br>`fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.stroke(mode: `[`uiDrawFillMode`](../libui/ui-draw-fill-mode.md)`, brush: `[`Brush`](-brush/README.md)`, stroke: `[`Stroke`](-stroke/README.md)`, block: `[`Path`](-path/README.md)`.() -> Unit)`<br>Draw a path in the context. |
| [text](text.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.text(string: `[`AttributedString`](-attributed-string/README.md)`, defaultFont: `[`Font`](-font/README.md)`, width: Double, align: `[`uiDrawTextAlign`](../libui/ui-draw-text-align.md)`, x: Double, y: Double)`<br>draws formatted text with the top-left point at (`x`, `y`). |
| [transform](transform.md) | `fun `[`DrawContext`](../libui.ktx/-draw-context.md)`.transform(block: `[`Matrix`](-matrix/README.md)`.() -> Unit)`<br>Apply a different transform matrix to the context. |
