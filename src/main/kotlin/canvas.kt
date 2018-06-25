package libui

import kotlinx.cinterop.*
import platform.posix.*

data class Color(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double = 1.0
)

fun Color(rgb: Int, alpha: Double = 1.0) = Color(
    r = ((rgb shr 16) and 255).toDouble() / 255,
    g = ((rgb shr 8) and 255).toDouble() / 255,
    b = ((rgb) and 255).toDouble() / 255,
    a = alpha
)

data class SizeInt(val width: Int, val height: Int)

data class Size(val width: Double, val height: Double)

data class Point(val x: Double, val y: Double)

/** A canvas you can draw on. It also receives keyboard and mouse events,
 *  is DPI aware, and has several other useful features. */
fun Area(block: Area.() -> Unit = {}): Area {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return Area(uiNewArea(handler.ui.ptr), handler.ptr).apply(block)
}

/** [Area] with horziontal and vertical scrollbars. */
fun ScrollingArea(width: Int, height: Int, block: ScrollingArea.() -> Unit = {}): ScrollingArea {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return ScrollingArea(uiNewScrollingArea(handler.ui.ptr, width, height), handler.ptr).apply(block)
}

open class Area internal constructor(
    alloc: CPointer<uiArea>?,
    val handler: CPointer<ktAreaHandler>
) : Control<uiArea>(alloc) {

    internal var draw: Area.(params: uiAreaDrawParams) -> Unit = {}
    internal var mouseEvent: Area.(event: uiAreaMouseEvent) -> Unit = {}
    internal var mouseCrossed: Area.(left: Boolean) -> Unit = {}
    internal var dragBroken: Area.() -> Unit = {}
    internal var keyEvent: Area.(event: uiAreaKeyEvent) -> Boolean = { false }
    init {
        handler.pointed.ui.Draw = staticCFunction(::_Draw)
        handler.pointed.ui.MouseEvent = staticCFunction(::_MouseEvent)
        handler.pointed.ui.MouseCrossed = staticCFunction(::_MouseCrossed)
        handler.pointed.ui.DragBroken = staticCFunction(::_DragBroken)
        handler.pointed.ui.KeyEvent = staticCFunction(::_KeyEvent)
        handler.pointed.ref = ref.asCPointer()
    }

    internal val disposables = mutableListOf<Disposable<*>>()
    override fun free() {
        disposables.forEach { it.dispose() }
        disposables.clear()
        nativeHeap.free(handler)
        super.free()
    }
}

class ScrollingArea internal constructor(
    alloc: CPointer<uiArea>?,
    handler: CPointer<ktAreaHandler>
) : Area(alloc, handler)

/** Queues the entire Area for redraw.
 *  The Area is not redrawn before this function returns; it is redrawn when next possible. */
fun Area.queueRedrawAll() = uiAreaQueueRedrawAll(ptr)

/** Sets the size of a ScrollingArea to the given size, in points. */
fun ScrollingArea.setSize(width: Int, height: Int) =
    uiAreaSetSize(ptr, width, height)

/** Scrolls the ScrollingArea to show the given rectangle. */
fun ScrollingArea.scrollTo(x: Double, y: Double, width: Double, height: Double) =
    uiAreaScrollTo(ptr, x, y, width, height)

//// TODO document these can only be called within Mouse() handlers
//// TODO should these be allowed on scrolling areas?
//// TODO decide which mouse events should be accepted Down is the only one guaranteed to work right now
//// TODO what happens to events after calling this up to and including the next mouse up?
//// TODO release capture?
//void uiAreaBeginUserWindowMove(uiArea *a)
//void uiAreaBeginUserWindowResize(uiArea *a, uiWindowResizeEdge edge)

/** Funcion to be run when the area was created or got resized with [uiAreaDrawParams] as parameter.
 *  Only one function can be registered at a time. */
fun Area.draw(block: Area.(params: uiAreaDrawParams) -> Unit) {
    draw = block
}

@Suppress("UNUSED_PARAMETER")
private fun _Draw(
    handler: CPointer<uiAreaHandler>?,
    area: CPointer<uiArea>?,
    params: CPointer<uiAreaDrawParams>?
) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        draw.invoke(this, params!!.pointed)
    }
}

/** Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent] as parameter.
 *  Only one function can be registered at a time. */
fun Area.mouseEvent(block: Area.(event: uiAreaMouseEvent) -> Unit) {
    mouseEvent = block
}

@Suppress("UNUSED_PARAMETER")
private fun _MouseEvent(
    handler: CPointer<uiAreaHandler>?,
    area: CPointer<uiArea>?,
    params: CPointer<uiAreaMouseEvent>?
) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        mouseEvent.invoke(this, params!!.pointed)
    }
}

/** Funcion to be run when the mouse entered (`left == false`) or left the area.
 *  Only one function can be registered at a time. */
fun Area.mouseCrossed(block: Area.(left: Boolean) -> Unit) {
    mouseCrossed = block
}

@Suppress("UNUSED_PARAMETER")
private fun _MouseCrossed(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, left: Int) {
        val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        mouseCrossed.invoke(this, left != 0)
    }
}

/** Funcion to be run to indicate that a drag should be ended. Only implemented on Windows.
 *  Only one function can be registered at a time. */
fun Area.dragBroken(block: Area.() -> Unit) {
    dragBroken = block
}

@Suppress("UNUSED_PARAMETER")
private fun _DragBroken(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        dragBroken.invoke(this)
    }
}

/** Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled.
 *  (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent]
 *  Only one function can be registered at a time. */
fun Area.keyEvent(block: Area.(event: uiAreaKeyEvent) -> Boolean) {
    keyEvent = block
}

@Suppress("UNUSED_PARAMETER")
private fun _KeyEvent(
    handler: CPointer<uiAreaHandler>?,
    area: CPointer<uiArea>?,
    event: CPointer<uiAreaKeyEvent>?
): Int {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        return if (keyEvent.invoke(this, event!!.pointed)) 1 else 0
    }
}

///////////////////////////////////////////////////////////////////////////////

/** Defines the color(s) to draw a path with. */
class Brush : Disposable<uiDrawBrush>(
    alloc = nativeHeap.alloc<uiDrawBrush>().ptr) {
    override fun clear() {
        ptr.pointed.Stops?.let { nativeHeap.free(it) }
        memset(ptr, 0, uiDrawBrush.size)
    }
    override fun free() {
        clear()
        nativeHeap.free(ptr)
    }
}

/** Creates a new Brush with lifecycle delegated to Area. */
fun Area.Brush() = libui.Brush().also { disposables.add(it) }

/** Helper to quickly set a brush color */
fun Brush.solid(color: Color, opacity: Double = 1.0): Brush {
    clear()
    with (ptr.pointed) {
        Type = uiDrawBrushTypeSolid
        R = color.r
        G = color.g
        B = color.b
        A = color.a * opacity
    }
    return this
}

/** Helper to quickly set a brush color */
fun Brush.solid(rgb: Int, alpha: Double = 1.0): Brush {
    clear()
    val color = Color(rgb, alpha)
    with (ptr.pointed) {
        Type = uiDrawBrushTypeSolid
        R = color.r
        G = color.g
        B = color.b
        A = alpha
    }
    return this
}

/** Helper to quickly create linear brush */
fun Brush.linear(start: Point, end: Point, vararg stops: Pair<Double, Color>): Brush {
    clear()
    with (ptr.pointed) {
        Type = uiDrawBrushTypeLinearGradient
        X0 = start.x
        Y0 = start.y
        X1 = end.x
        Y1 = end.y
        NumStops = stops.size.signExtend()
        Stops = nativeHeap.allocArray<uiDrawBrushGradientStop>(stops.size)
        stops.forEachIndexed { i, (pos, color) ->
            with (Stops!![i]) {
                Pos = pos
                R = color.r
                G = color.g
                B = color.b
                A = color.a
            }
        }
    }
    return this
}

/** Helper to quickly create radial brush */
fun Brush.radial(start: Point, center: Point, radius: Double, vararg stops: Pair<Double, Color>): Brush {
    clear()
    with (ptr.pointed) {
        Type = uiDrawBrushTypeRadialGradient
        X0 = start.x
        Y0 = start.y
        X1 = center.x
        Y1 = center.y
        OuterRadius = radius
        NumStops = stops.size.signExtend()
        Stops = nativeHeap.allocArray<uiDrawBrushGradientStop>(stops.size)
        stops.forEachIndexed { i, (pos, color) ->
            with (Stops!![i]) {
                Pos = pos
                R = color.r
                G = color.g
                B = color.b
                A = color.a
            }
        }
    }
    return this
}

///////////////////////////////////////////////////////////////////////////////

/** Describes the stroke to draw with. */
class Stroke : Disposable<uiDrawStrokeParams>(
    alloc = nativeHeap.alloc<uiDrawStrokeParams>().ptr) {
    override fun free() = nativeHeap.free(ptr)
}

/** Creates a new Stroke with lifecycle delegated to Area. */
fun Area.Stroke(block: uiDrawStrokeParams.() -> Unit = {}) =
    libui.Stroke().also {
        disposables.add(it)
        block.invoke(it.ptr.pointed)
    }

///////////////////////////////////////////////////////////////////////////////

/** Represent a path that could be drawed on a [DrawContext] */
class Path(mode: uiDrawFillMode) : Disposable<uiDrawPath>(
    alloc = uiDrawNewPath(mode)) {
    override fun free() = uiDrawFreePath(ptr)
}

/** Starts a new figure at the specified point. Call this method when you want to create a new path. */
fun Path.figure(x: Double, y: Double) = uiDrawPathNewFigure(ptr, x, y)

/** Starts a new figure and adds an arc to the path which is centered at ([xCenter], [yCenter]) position
 *  with radius [radius] starting at [startAngle] and with sweep angle [sweep] going in the given direction
 *  by anticlockwise (defaulting to clockwise) as specified by [negative]. */
fun Path.figureWithArc(xCenter: Double, yCenter: Double, radius: Double,
                       startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathNewFigureWithArc(ptr, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

/** Connects the last point in the subpath to the x, y coordinates with a straight line. */
fun Path.lineTo(x: Double, y: Double) = uiDrawPathLineTo(ptr, x, y)

/** Adds an arc to the path which is centered at ([xCenter], [yCenter]) position with radius [radius]
 *  starting at [startAngle] and with sweep angle [sweep] going in the given direction by
 *  anticlockwise (defaulting to clockwise) as specified by [negative]. */
fun Path.arcTo(xCenter: Double, yCenter: Double, radius: Double,
               startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathArcTo(ptr, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

/** Adds a cubic Bézier curve to the path. It requires three points. The first two points are control
 *  points and the third one is the end point. The starting point is the last point in the current path. */
fun Path.bezierTo(c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double) =
    uiDrawPathBezierTo(ptr, c1x, c1y, c2x, c2y, endX, endY)

/** Creates a path for a rectangle at position (x, y) with a size that is determined by width and height. */
fun Path.rectangle(x: Double, y: Double, width: Double, height: Double) =
    uiDrawPathAddRectangle(ptr, x, y, width, height)

/** Causes the point of the pen to move back to the start of the current sub-path. It tries to draw
 *  a straight line from the current point to the start. If the shape has already been closed or has
 *  only one point, this function does nothing.
 *  It end the path. */
fun Path.closeFigure() = uiDrawPathCloseFigure(ptr)

///////////////////////////////////////////////////////////////////////////////

/** Defines a transformation (e.g. rotation, translation) */
class Matrix : Disposable<uiDrawMatrix>(
    alloc = nativeHeap.alloc<uiDrawMatrix>().ptr) {
    override fun free() = nativeHeap.free(ptr)
}

/** Moves paths over by [x] to the right and [y] down. */
fun Matrix.translate(x: Double, y: Double) =
    uiDrawMatrixTranslate(ptr, x, y)

/** Scales pathes by a factor of [x] and [y] with ([xCenter], [yCenter]) as the scale center. */
fun Matrix.scale(xCenter: Double, yCenter: Double, x: Double, y: Double) =
    uiDrawMatrixScale(ptr, xCenter, yCenter, x, y)

/** Rotates paths by [r] *radians* around ([x], [y]). */
fun Matrix.rotate(x: Double, y: Double, amount: Double) =
    uiDrawMatrixRotate(ptr, x, y, amount)

/** Skews path by [xAmount] *radians* horizontally and by [yAmount] *radians* vertically around ([x], [y]) */
fun Matrix.skew(x: Double, y: Double, xamount: Double, yamount: Double) =
    uiDrawMatrixSkew(ptr, x, y, xamount, yamount)

/** Sets the matrix to the product of itself with [other] matrix. */
fun Matrix.multiply(other: Matrix) = uiDrawMatrixMultiply(ptr, other.ptr)

/** Returns `true` if the matrix is invertible. */
val Matrix.invertible: Boolean get() = uiDrawMatrixInvertible(ptr) != 0

/** Inverts the matrix. */
fun Matrix.invert() = uiDrawMatrixInvert(ptr)

/** Returns the transformed point. */
val Matrix.point: Point
    get() = memScoped {
        val x = alloc<DoubleVar>()
        var y = alloc<DoubleVar>()
        uiDrawMatrixTransformPoint(ptr, x.ptr, y.ptr)
        Point(x.value, y.value)
    }

/** Returns the transformed size. */
val Matrix.size: Size
    get() = memScoped {
        val width = alloc<DoubleVar>()
        var height = alloc<DoubleVar>()
        uiDrawMatrixTransformSize(ptr, width.ptr, height.ptr)
        Size(width.value, height.value)
    }

///////////////////////////////////////////////////////////

/** Stores information about an attribute in a [AttributedString]. */
abstract class Attribute(alloc: CPointer<uiAttribute>?) : Disposable<uiAttribute>(alloc) {

    /** Frees a [Attribute]. You generally do not need to call this yourself,
     *  as [AttributedString] does this for you. */
    override fun free() = uiFreeAttribute(ptr)

    /** Returns the type of [Attribute]. */
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
    val value: Color get() = memScoped {
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
    uiNewUnderlineColorAttribute(kind, color.r, color.g, color.b, color.a)) {

    /** Returns the underline color kind stored. */
    val kind: uiUnderlineColor get() = memScoped {
        val kind = alloc<uiUnderlineColorVar>()
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiAttributeUnderlineColor(ptr, kind.ptr, r.ptr, g.ptr, b.ptr, a.ptr)
        kind.value
    }

    /** Returns the underline color stored. */
    val color: Color get() = memScoped {
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
 *  otf is copied you may free it after uiNewFeaturesAttribute() returns. */
class FeaturesAttribute(otf: OpenTypeFeatures) : Attribute(uiNewFeaturesAttribute(otf.ptr)) {

    /** Returns the OpenType features stored. */
    val value: OpenTypeFeatures get() = OpenTypeFeatures(uiAttributeFeatures(ptr))
}

/** Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. */
class OpenTypeFeatures(copy: CPointer<uiOpenTypeFeatures>? = null) : Disposable<uiOpenTypeFeatures>(
    alloc = copy ?: uiNewOpenTypeFeatures()) {
    override fun free() = uiFreeOpenTypeFeatures(ptr)
}

/** Makes a copy of otf and returns it. Changing one will not affect the other. */
fun OpenTypeFeatures.copy() = OpenTypeFeatures(uiOpenTypeFeaturesClone(ptr))

/** Adds the given feature tag and value to OpenTypeFeatures. If there is already a value
 *  associated with the specified tag in otf, the old value is removed. */
fun OpenTypeFeatures.add(tag: String, value: Int) =
    uiOpenTypeFeaturesAdd(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value)

/** Removes the given feature tag and value from OpenTypeFeatures. If the tag is not present
 *  in OpenTypeFeatures, it does nothing. */
fun OpenTypeFeatures.remove(tag: String) =
    uiOpenTypeFeaturesRemove(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte())

/** Determines whether the given feature tag is present in OpenTypeFeatures. */
fun OpenTypeFeatures.get(tag: String): Int = memScoped {
    val value = alloc<IntVar>()
    uiOpenTypeFeaturesGet(ptr, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value.ptr)
    value.value
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

/** Represents a string of UTF-8 text that can be embellished with formatting attributes. */
class AttributedString(init: String) : Disposable<uiAttributedString>(
    alloc = uiNewAttributedString(init)) {
    override fun free() = uiFreeAttributedString(ptr)
}

/** Creates a new AttributedString from initial String. The string will be entirely unattributed. */
fun Area.AttributedString(init: String) = libui.AttributedString(init).also { disposables.add(it) }

/** Returns the textual content of AttributedString. */
val AttributedString.string: String get() = uiAttributedStringString(ptr)?.toKString() ?: ""

/** Returns the number of UTF-8 bytes in the textual content, excluding the terminating '\0'. */
val AttributedString.length: Int get() = uiAttributedStringLen(ptr).narrow()

/** Adds the '\0'-terminated UTF-8 string str to the end. The new substring will be unattributed. */
fun AttributedString.append(str: String) = uiAttributedStringAppendUnattributed(ptr, str)

/** Adds the '\0'-terminated UTF-8 string str to s at the byte position specified by [at].
 *  The new substring will be unattributed existing attributes will be moved along with their text. */
fun AttributedString.insert(str: String, at: Int) =
    uiAttributedStringInsertAtUnattributed(ptr, str, at.signExtend())

/** Deletes the characters and attributes in the byte range [start, end). */
fun AttributedString.delete(start: Int, end: Int) =
    uiAttributedStringDelete(ptr, start.signExtend(), end.signExtend())

/** Sets a in the byte range [start, end). Any existing attributes in that byte range of the same type are
 *  removed. Takes ownership of [a] you should not use it after uiAttributedStringSetAttribute() returns. */
fun AttributedString.setAttribute(a: Attribute, start: Int, end: Int) =
    uiAttributedStringSetAttribute(ptr, a.ptr, start.signExtend(), end.signExtend())

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

///////////////////////////////////////////////////////////////////////////////

/** Provides a complete description of a font where one is needed.  */
class Font : Disposable<uiFontDescriptor>(
    alloc = nativeHeap.alloc<uiFontDescriptor>().ptr) {
    override fun clear() {
        if (ptr.pointed.Family != null) uiFreeFontButtonFont(ptr)
    }
    override fun free() {
        clear()
        nativeHeap.free(ptr)
    }
}

///////////////////////////////////////////////////////////////////////////////

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

    /** Frees [TextLayout]. The underlying [AttributedString] is not freed. */
    override fun free() = uiDrawFreeTextLayout(ptr)

    /** Returns the size of [TextLayout]. */
    val size: Size get() = memScoped {
        val width = alloc<DoubleVar>()
        val height = alloc<DoubleVar>()
        uiDrawTextLayoutExtents(ptr, width.ptr, height.ptr)
        Size(width.value, height.value)
    }
}

///////////////////////////////////////////////////////////////////////////////

typealias DrawContext = CPointer<uiDrawContext>

/** Draw a path filled with a color. */
fun DrawContext.fill(
    mode: uiDrawFillMode,
    brush: Brush,
    block: Path.() -> Unit
) {
    val path = Path(mode)
    path.block()
    uiDrawPathEnd(path.ptr)
    uiDrawFill(this, path.ptr, brush.ptr)
    path.dispose()
}

/** Draw a path in the context. */
fun DrawContext.stroke(
    mode: uiDrawFillMode,
    brush: Brush,
    stroke: Stroke,
    block: Path.() -> Unit
) {
    val path = Path(mode)
    path.block()
    uiDrawPathEnd(path.ptr)
    uiDrawStroke(this, path.ptr, brush.ptr, stroke.ptr)
    path.dispose()
}

/** Apply a different transform matrix to the context. */
fun DrawContext.transform(block: Matrix.() -> Unit) {
    val matrix = Matrix()
    uiDrawMatrixSetIdentity(matrix.ptr)
    matrix.block()
    uiDrawTransform(this, matrix.ptr)
    matrix.dispose()
}

/** draws formatted text with the top-left point at ([x], [y]). */
fun DrawContext.draw(
    string: AttributedString,
    defaultFont: Font,
    width: Double,
    align: uiDrawTextAlign,
    x: Double,
    y: Double
) {
    val layout = TextLayout(string, defaultFont, width, align)
    uiDrawText(this, layout.ptr, x, y)
    layout.dispose()
}

//TODO fun DrawContext.clip(path: Path) = uiDrawClip(this, path)

//TODO fun DrawContext.save() = uiDrawSave(this)

//TODO fun DrawContext.restore() = uiDrawRestore(this)
