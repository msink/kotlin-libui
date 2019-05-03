// SPDX-License-Identifier: MIT OR Apache-2.0

package libui.ktx.draw

import libui.*
import libui.ktx.*
import kotlinx.cinterop.*

/** draws formatted text with the top-left point at (`x`, `y`). */
fun DrawContext.text(
    string: AttributedString,
    defaultFont: Font,
    width: Double,
    align: uiDrawTextAlign,
    x: Double,
    y: Double
) {
    val layout = TextLayout(string, defaultFont, width, align)
    uiDrawText(ptr, layout.ptr, x, y)
    layout.dispose()
}

/** Representation of a [AttributedString] that can be displayed in a [DrawContext]. */
class TextLayout(
    string: AttributedString,
    defaultFont: Font,
    width: Double,
    align: uiDrawTextAlign
) : Disposable<uiDrawTextLayout>(
    alloc = memScoped {
        val params = alloc<uiDrawTextLayoutParams>().apply {
            String = string.ptr
            DefaultFont = defaultFont.ptr
            Width = width
            Align = align
        }
        uiDrawNewTextLayout(params.ptr)
    }
) {

    /** Frees TextLayout. The underlying [AttributedString] is not freed. */
    override fun free() = uiDrawFreeTextLayout(ptr)

    /** Returns the size of TextLayout. */
    val size: Size
        get() = memScoped {
            val width = alloc<DoubleVar>()
            val height = alloc<DoubleVar>()
            uiDrawTextLayoutExtents(ptr, width.ptr, height.ptr)
            Size(width.value, height.value)
        }
}

///////////////////////////////////////////////////////////////////////////////

/** Creates a new [Font] with lifecycle delegated to [DrawArea]. */
fun DrawArea.font(
    family: String? = null,
    size: Double = 0.0,
    weight: uiTextWeight = uiTextWeightNormal,
    italic: uiTextItalic = uiTextItalicNormal,
    stretch: uiTextStretch = uiTextStretchNormal
): Font = Font(family, size, weight, italic, stretch).also { disposables.add(it) }

/** Provides a complete description of a font where one is needed.  */
open class Font(
    family: String? = null,
    size: Double = 0.0,
    weight: uiTextWeight = uiTextWeightNormal,
    italic: uiTextItalic = uiTextItalicNormal,
    stretch: uiTextStretch = uiTextStretchNormal
) : Disposable<uiFontDescriptor>(
    alloc = nativeHeap.alloc<uiFontDescriptor>().ptr
) {
    init {
        with(ptr.pointed) {
            Family = family?.cstr?.place(nativeHeap.allocArray(family.length * 4))
            Size = size
            Weight = weight
            Italic = italic
            Stretch = stretch
        }
    }

    override fun clear() {
        ptr.pointed.Family?.let { nativeHeap.free(it) }
    }

    override fun free() {
        clear()
        nativeHeap.free(ptr)
    }
}

///////////////////////////////////////////////////////////////////////////////

/** Stores information about an attribute in a [AttributedString]. */
abstract class Attribute(alloc: CPointer<uiAttribute>?) : Disposable<uiAttribute>(alloc) {

    /** Frees a Attribute. You generally do not need to call this yourself,
     *  as [AttributedString] does this for you. */
    override fun free() = uiFreeAttribute(ptr)

    /** Returns the type of Attribute. */
    val type: uiAttributeType get() = uiAttributeGetType(ptr)
}

/** Changes the font family of the text it is applied to. */
class FamilyAttribute(family: String) : Attribute(uiNewFamilyAttribute(family)) {

    /** Returns the font family stored. */
    val value: String? get() = uiAttributeFamily(ptr)?.toKString()
}

/** Changes the size of the text it is applied to, in typographical points. */
class SizeAttribute(size: Double) : Attribute(uiNewSizeAttribute(size)) {

    /** Returns the font size stored. */
    val value: Double get() = uiAttributeSize(ptr)
}

/** Changes the weight of the text it is applied to. */
class WeightAttribute(weight: uiTextWeight) : Attribute(uiNewWeightAttribute(weight)) {

    /** Returns the font weight stored. */
    val value: uiTextWeight get() = uiAttributeWeight(ptr)
}

/** Changes the italic mode of the text it is applied to. */
class ItalicAttribute(italic: uiTextItalic) : Attribute(uiNewItalicAttribute(italic)) {

    /** uiAttributeItalic() returns the font italic mode stored. */
    val value: uiTextItalic get() = uiAttributeItalic(ptr)
}

/** Changes the stretch of the text it is applied to. */
class StretchAttribute(stretch: uiTextStretch) : Attribute(uiNewStretchAttribute(stretch)) {

    /** Returns the font stretch stored in [Attribute]. */
    val value: uiTextStretch get() = uiAttributeStretch(ptr)
}

/** Changes the color of the text it is applied to. */
class ColorAttribute(color: Color) : Attribute(uiNewColorAttribute(color.r, color.g, color.b, color.a)) {

    /** Returns the text color stored. */
    val value: Color
        get() = memScoped {
            val r = alloc<DoubleVar>()
            val g = alloc<DoubleVar>()
            val b = alloc<DoubleVar>()
            val a = alloc<DoubleVar>()
            uiAttributeColor(ptr, r.ptr, g.ptr, b.ptr, a.ptr)
            Color(r.value, g.value, b.value, a.value)
        }
}

/** Changes the background color of the text it is applied to. */
class BackgroundAttribute(color: Color) :
    Attribute(uiNewBackgroundAttribute(color.r, color.g, color.b, color.a)) {

    //TODO: value
}

/** Changes the type of underline on the text it is applied to. */
class UnderlineAttribute(u: uiUnderline) : Attribute(uiNewUnderlineAttribute(u)) {

    /** Returns the underline type stored in [Attribute]. */
    val value: uiUnderline get() = uiAttributeUnderline(ptr)
}

/** Changes the color of the underline on the text it is applied to. */
class UnderlineColorAttribute(kind: uiUnderlineColor, color: Color) : Attribute(
    uiNewUnderlineColorAttribute(kind, color.r, color.g, color.b, color.a)
) {

    /** Returns the underline color kind stored. */
    val kind: uiUnderlineColor
        get() = memScoped {
            val kind = alloc<uiUnderlineColorVar>()
            val r = alloc<DoubleVar>()
            val g = alloc<DoubleVar>()
            val b = alloc<DoubleVar>()
            val a = alloc<DoubleVar>()
            uiAttributeUnderlineColor(ptr, kind.ptr, r.ptr, g.ptr, b.ptr, a.ptr)
            kind.value
        }

    /** Returns the underline color stored. */
    val color: Color
        get() = memScoped {
            val kind = alloc<uiUnderlineColorVar>()
            val r = alloc<DoubleVar>()
            val g = alloc<DoubleVar>()
            val b = alloc<DoubleVar>()
            val a = alloc<DoubleVar>()
            uiAttributeUnderlineColor(ptr, kind.ptr, r.ptr, g.ptr, b.ptr, a.ptr)
            Color(r.value, g.value, b.value, a.value)
        }
}

///////////////////////////////////////////////////////////////////////////////

/** Creates a new Attribute that changes the font family of the text it is applied to.
 *  otf is copied you may free it. */
class FeaturesAttribute(otf: OpenTypeFeatures) : Attribute(uiNewFeaturesAttribute(otf.ptr)) {

    /** Returns the OpenType features stored. */
    val value: OpenTypeFeatures get() = OpenTypeFeatures(uiAttributeFeatures(ptr))
}

/** Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. */
class OpenTypeFeatures(copy: CPointer<uiOpenTypeFeatures>? = null) : Disposable<uiOpenTypeFeatures>(
    alloc = copy ?: uiNewOpenTypeFeatures()
) {
    override fun free() = uiFreeOpenTypeFeatures(ptr)

    /** Makes a copy of otf and returns it. Changing one will not affect the other. */
    fun copy() = OpenTypeFeatures(uiOpenTypeFeaturesClone(ptr))

    /** Adds the given feature tag and value to OpenTypeFeatures. If there is already a value
     *  associated with the specified tag in otf, the old value is removed. */
    fun add(tag: String, value: UInt) =
        uiOpenTypeFeaturesAdd(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value)

    /** Removes the given feature tag and value from OpenTypeFeatures. If the tag is not present
     *  in OpenTypeFeatures, it does nothing. */
    fun remove(tag: String) =
        uiOpenTypeFeaturesRemove(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte())

    /** Determines whether the given feature tag is present in OpenTypeFeatures. */
    fun get(tag: String): UInt = memScoped {
        val value = alloc<UIntVar>()
        uiOpenTypeFeaturesGet(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value.ptr)
        value.value
    }
}

//// uiOpenTypeFeaturesForEachFunc is the type of the function
//// invoked by uiOpenTypeFeaturesForEach() for every OpenType
//// feature in otf. Refer to that function's documentation for more
//// details.
//typedef uiForEach (*uiOpenTypeFeaturesForEachFunc)(const uiOpenTypeFeatures *otf, char a, char b, char c, char d, uint32_t value, void *data)

//// uiOpenTypeFeaturesForEach() executes f for every tag-value
//// pair in otf. The enumeration order is unspecified. You cannot
//// modify otf while uiOpenTypeFeaturesForEach() is running.
//void uiOpenTypeFeaturesForEach(const uiOpenTypeFeatures *otf, uiOpenTypeFeaturesForEachFunc f, void *data)

///////////////////////////////////////////////////////////////////////////////

/** Creates a new [AttributedString] from initial String. The string will be entirely unattributed. */
fun DrawArea.string(init: String): AttributedString =
    AttributedString(init).also { disposables.add(it) }

/** Represents a string of UTF-8 text that can be embellished with formatting attributes. */
class AttributedString(init: String) : Disposable<uiAttributedString>(
    alloc = uiNewAttributedString(init)
) {
    override fun free() = uiFreeAttributedString(ptr)

    /** Returns the textual content of AttributedString. */
    val string: String get() = uiAttributedStringString(ptr).uiText()

    /** Returns the number of UTF-8 bytes in the textual content, excluding the terminating '\\0'. */
    val length: Int get() = uiAttributedStringLen(ptr).convert()

    /** Adds the '\\0'-terminated UTF-8 string `str` to the end. The new substring will be unattributed. */
    fun append(str: String) = uiAttributedStringAppendUnattributed(ptr, str)

    /** Adds the '\\0'-terminated UTF-8 string `str` at the byte position specified by `at`.
     *  The new substring will be unattributed existing attributes will be moved along with their text. */
    fun insert(str: String, at: Int) =
        uiAttributedStringInsertAtUnattributed(ptr, str, at.convert())

    /** Deletes the characters and attributes in the byte range \[`start`, `end`). */
    fun delete(start: Int, end: Int) =
        uiAttributedStringDelete(ptr, start.convert(), end.convert())

    /** Sets a in the byte range \[`start`, `end`). Any existing attributes in that byte range of the same type are
     *  removed. Takes ownership of `a` you should not use it after `setAttribute()` returns. */
    fun setAttribute(a: Attribute, start: Int, end: Int) =
        uiAttributedStringSetAttribute(ptr, a.ptr, start.convert(), end.convert())
}

//// uiAttributedStringForEachAttributeFunc is the type of the function
//// invoked by uiAttributedStringForEachAttribute() for every
//// attribute in s. Refer to that function's documentation for more
//// details.
//typedef uiForEach (*uiAttributedStringForEachAttributeFunc)(const uiAttributedString *s, const uiAttribute *a, size_t start, size_t end, void *data)

//// uiAttributedStringForEachAttribute() enumerates all the
//// uiAttributes in s. It is an error to modify s in f. Within f, s still
//// owns the attribute you can neither free it nor save it for later
//// use.
//// TODO reword the above for consistency (TODO and find out what I meant by that)
//// TODO define an enumeration order (or mark it as undefined) also define how consecutive runs of identical attributes are handled here and sync with the definition of uiAttributedString itself
//void uiAttributedStringForEachAttribute(const uiAttributedString *s, uiAttributedStringForEachAttributeFunc f, void *data)

//** Returns the number of graphemes (characters from the point of view of the user). */
//size_t uiAttributedStringNumGraphemes(uiAttributedString *s)

//** Converts a byte index in the string to a grapheme index. */
//size_t uiAttributedStringByteIndexToGrapheme(uiAttributedString *s, size_t pos)

//** Converts a graphmeme index in the string to a byte index. */
//size_t uiAttributedStringGraphemeToByteIndex(uiAttributedString *s, size_t pos)
