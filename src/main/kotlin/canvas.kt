package libui

import kotlinx.cinterop.*
import platform.posix.*

/** A canvas you can draw on. It also receives keyboard and mouse events,
 *  is DPI aware, and has several other useful features. */
fun Area(block: Area.() -> Unit = {}): Area {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return Area(uiNewArea(handler.ui.ptr), handler.ptr).apply(block)
}

/** Area with horziontal and vertical scrollbars. */
fun ScrollingArea(width: Int, height: Int, block: Area.() -> Unit = {}): Area {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return Area(uiNewScrollingArea(handler.ui.ptr, width, height), handler.ptr).apply(block)
}

typealias AreaDrawParams = CPointer<uiAreaDrawParams>
typealias AreaMouseEvent = CPointer<uiAreaMouseEvent>
typealias AreaKeyEvent = CPointer<uiAreaKeyEvent>

class Area internal constructor(_ptr: CPointer<uiArea>?, handler: CPointer<ktAreaHandler>) : Control(_ptr) {
    internal val ptr: CPointer<uiArea> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")

    internal var draw: Area.(params: uiAreaDrawParams) -> Unit = {}
    internal var mouseEvent: Area.(event: uiAreaMouseEvent) -> Unit = {}
    internal var mouseCrossed: Area.(left: Boolean) -> Unit = {}
    internal var dragBroken: Area.() -> Unit = {}
    internal var keyEvent: Area.(event: uiAreaKeyEvent) -> Boolean = { false }

    internal var astrings = mutableListOf<AttributedString>()
    internal var natives = mutableListOf<CPointer<*>>()

    init {
        handler.pointed.ui.Draw = staticCFunction(::_Draw)
        handler.pointed.ui.MouseEvent = staticCFunction(::_MouseEvent)
        handler.pointed.ui.MouseCrossed = staticCFunction(::_MouseCrossed)
        handler.pointed.ui.DragBroken = staticCFunction(::_DragBroken)
        handler.pointed.ui.KeyEvent = staticCFunction(::_KeyEvent)
        handler.pointed.ref = ref.asCPointer()
        natives.add(handler)
    }

    override fun dispose() {
        astrings.forEach { it.dispose() }
        natives.forEach { nativeHeap.free(it) }
        super.dispose()
    }
}

/** Queues the entire Area for redraw.
 *  The Area is not redrawn before this function returns; it is redrawn when next possible. */
fun Area.queueRedrawAll() = uiAreaQueueRedrawAll(ptr)

/** Sets the size of a ScrollingArea to the given size, in points.
 *  Panics if called on a non-scrolling Area. */
fun Area.setSize(width: Int, height: Int) =
    uiAreaSetSize(ptr, width, height)

/** Scrolls the ScrollingArea to show the given rectangle
 *  Panics if called on a non-scrolling Area. */
fun Area.scrollTo(x: Double, y: Double, width: Double, height: Double) =
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
fun Area.draw(proc: Area.(params: uiAreaDrawParams) -> Unit) {
    draw = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _Draw(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, params: AreaDrawParams?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        draw.invoke(this, params!!.pointed)
    }
}

/** Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent] as parameter.
 *  Only one function can be registered at a time. */
fun Area.mouseEvent(proc: Area.(event: uiAreaMouseEvent) -> Unit) {
    mouseEvent = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _MouseEvent(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, params: AreaMouseEvent?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        mouseEvent.invoke(this, params!!.pointed)
    }
}

/** Funcion to be run when the mouse entered (`left == false`) or left the area.
 *  Only one function can be registered at a time. */
fun Area.mouseCrossed(proc: Area.(left: Boolean) -> Unit) {
    mouseCrossed = proc
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
fun Area.dragBroken(proc: Area.() -> Unit) {
    dragBroken = proc
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
fun Area.keyEvent(proc: Area.(event: uiAreaKeyEvent) -> Boolean) {
    keyEvent = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _KeyEvent(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, event: AreaKeyEvent?): Int {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        return if (keyEvent.invoke(this, event!!.pointed)) 1 else 0
    }
}

///////////////////////////////////////////////////////////////////////////////

/** Defines the color(s) to draw a path with. */
typealias DrawBrush = CPointer<uiDrawBrush>

/** Creates a new DrawBrush with lifecycle delegated to Area. */
fun Area.DrawBrush(): DrawBrush {
    val brush = nativeHeap.alloc<uiDrawBrush>().ptr
    natives.add(brush)
    return brush
}

/** Helper to quickly set a brush color */
fun DrawBrush.solid(rgba: RGBA, opacity: Double = 1.0): DrawBrush {
    memset(this, 0, uiDrawBrush.size)
    pointed.Type = uiDrawBrushTypeSolid
    pointed.R = rgba.r
    pointed.G = rgba.g
    pointed.B = rgba.b
    pointed.A = rgba.a * opacity
    return this
}

/** Helper to quickly set a brush color */
fun DrawBrush.solid(color: Int, alpha: Double = 1.0): DrawBrush {
    memset(this, 0, uiDrawBrush.size)
    pointed.Type = uiDrawBrushTypeSolid
    val rgba = RGBA(color, alpha)
    pointed.R = rgba.r
    pointed.G = rgba.g
    pointed.B = rgba.b
    pointed.A = alpha
    return this
}

/** Represents a color value in a gradient. */
typealias DrawBrushGradientStop = CPointer<uiDrawBrushGradientStop>

/** Describes the stroke to draw with. */
typealias DrawStrokeParams = CPointer<uiDrawStrokeParams>

/** Creates a new DrawStrokeParams with lifecycle delegated to Area. */
fun Area.DrawStrokeParams(block: uiDrawStrokeParams.() -> Unit = {}): DrawStrokeParams {
    val stroke = nativeHeap.alloc<uiDrawStrokeParams>().ptr
    natives.add(stroke)
    block.invoke(stroke.pointed)
    return stroke
}

/** Represent a path that could be drawed on a DrawContext */
typealias DrawPath = CPointer<uiDrawPath>

/** Starts a new figure at the specified point. Call this method when you want to create a new path. */
fun DrawPath.figure(x: Double, y: Double) = uiDrawPathNewFigure(this, x, y)

/** Starts a new figure and adds an arc to the path which is centered at ([xCenter], [yCenter]) position
 *  with radius [radius] starting at [startAngle] and with sweep angle [sweep] going in the given direction
 *  by anticlockwise (defaulting to clockwise) as specified by [negative]. */
fun DrawPath.figureWithArc(xCenter: Double, yCenter: Double, radius: Double,
                           startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathNewFigureWithArc(this, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

/** Connects the last point in the subpath to the x, y coordinates with a straight line. */
fun DrawPath.lineTo(x: Double, y: Double) = uiDrawPathLineTo(this, x, y)

/** Adds an arc to the path which is centered at ([xCenter], [yCenter]) position with radius [radius]
 *  starting at [startAngle] and with sweep angle [sweep] going in the given direction by
 *  anticlockwise (defaulting to clockwise) as specified by [negative]. */
fun DrawPath.arcTo(xCenter: Double, yCenter: Double, radius: Double,
                           startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathArcTo(this, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

/** Adds a cubic Bézier curve to the path. It requires three points. The first two points are control
 *  points and the third one is the end point. The starting point is the last point in the current path. */
fun DrawPath.bezierTo(c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double) =
    uiDrawPathBezierTo(this, c1x, c1y, c2x, c2y, endX, endY)

/** Creates a path for a rectangle at position (x, y) with a size that is determined by width and height. */
fun DrawPath.rectangle(x: Double, y: Double, width: Double, height: Double) =
    uiDrawPathAddRectangle(this, x, y, width, height)

/** Causes the point of the pen to move back to the start of the current sub-path. It tries to draw 
 *  a straight line from the current point to the start. If the shape has already been closed or has
 *  only one point, this function does nothing.
 *  It end the path. */
fun DrawPath.closeFigure() = uiDrawPathCloseFigure(this)

///////////////////////////////////////////////////////////////////////////////

/** Defines a transformation (e.g. rotation, translation) */
typealias DrawMatrix = CPointer<uiDrawMatrix>

/** Moves paths over by [x] to the right and [y] down. */
fun DrawMatrix.translate(x: Double, y: Double) =
    uiDrawMatrixTranslate(this, x, y)

/** Scales pathes by a factor of [x] and [y] with ([xCenter], [yCenter]) as the scale center. */
fun DrawMatrix.scale(xCenter: Double, yCenter: Double, x: Double, y: Double) =
    uiDrawMatrixScale(this, xCenter, yCenter, x, y)

/** Rotates paths by [r] *radians* around ([x], [y]). */
fun DrawMatrix.rotate(x: Double, y: Double, amount: Double) =
    uiDrawMatrixRotate(this, x, y, amount)

/** Skews path by [xAmount] *radians* horizontally and by [yAmount] *radians* vertically around ([x], [y]) */
fun DrawMatrix.skew(x: Double, y: Double, xamount: Double, yamount: Double) =
    uiDrawMatrixSkew(this, x, y, xamount, yamount)

/** Sets the matrix to the product of itself with [other] matrix. */
fun DrawMatrix.multiply(other: DrawMatrix) = uiDrawMatrixMultiply(this, other)

/** Returns `true` if the matrix is invertible. */
val DrawMatrix.invertible: Boolean get() = uiDrawMatrixInvertible(this) != 0

/** Inverts the matrix. */
fun DrawMatrix.invert() = uiDrawMatrixInvert(this)

/** Returns the transformed point. */
val DrawMatrix.transformPoint: Point
    get() = memScoped {
        val x = alloc<DoubleVar>()
        var y = alloc<DoubleVar>()
        uiDrawMatrixTransformPoint(this@transformPoint, x.ptr, y.ptr)
        Point(x.value, y.value)
    }

/** Returns the transformed size. */
val DrawMatrix.transformSize: Size
    get() = memScoped {
        val width = alloc<DoubleVar>()
        var height = alloc<DoubleVar>()
        uiDrawMatrixTransformSize(this@transformSize, width.ptr, height.ptr)
        Size(width.value, height.value)
    }

///////////////////////////////////////////////////////////

/** Stores information about an attribute in a AttributedString. */
typealias Attribute = CPointer<uiAttribute>

/** Frees a Attribute. You generally do not need to call this yourself,
 *  as AttributedString does this for you. */
fun Attribute.dispose() = uiFreeAttribute(this)

/** Returns the type of Attribute. */
val Attribute.type: uiAttributeType get() = uiAttributeGetType(this)

/** Creates a new Attribute that changes the font family of the text it is applied to. */
fun FamilyAttribute(family: String): Attribute = uiNewFamilyAttribute(family) ?: throw Error()

/** Returns the font family stored in Attribute. */
val Attribute.family: String? get() = uiAttributeFamily(this)?.toKString()

/** Creates a new Attribute that changes the size of the text it is applied to, in typographical points. */
fun SizeAttribute(size: Double): Attribute = uiNewSizeAttribute(size) ?: throw Error()

/** Returns the font size stored in Attribute. */
val Attribute.size: Double get() = uiAttributeSize(this)

/** Creates a new Attribute that changes the weight of the text it is applied to. */
fun WeightAttribute(weight: uiTextWeight): Attribute = uiNewWeightAttribute(weight) ?: throw Error()

/** uiAttributeWeight() returns the font weight stored in Attribute. */
val Attribute.weight: uiTextWeight get() = uiAttributeWeight(this)

/** Creates a new Attribute that changes the italic mode of the text it is applied to. */
fun ItalicAttribute(italic: uiTextItalic): Attribute = uiNewItalicAttribute(italic) ?: throw Error()

/** uiAttributeItalic() returns the font italic mode stored in Attribute. */
val Attribute.italic: uiTextItalic get() = uiAttributeItalic(this)

/** Creates a new Attribute that changes the stretch of the text it is applied to. */
fun StretchAttribute(stretch: uiTextStretch): Attribute = uiNewStretchAttribute(stretch) ?: throw Error()

/** Returns the font stretch stored in Attribute. */
val Attribute.stretch: uiTextStretch get() = uiAttributeStretch(this)

/** Creates a new Attribute that changes the color of the text it is applied to. */
fun ColorAttribute(color: RGBA): Attribute =
    uiNewColorAttribute(color.r, color.g, color.b, color.a) ?: throw Error()

/** Returns the text color stored in Attribute. */
val Attribute.color: RGBA get() = memScoped {
    val r = alloc<DoubleVar>()
    val g = alloc<DoubleVar>()
    val b = alloc<DoubleVar>()
    val a = alloc<DoubleVar>()
    uiAttributeColor(this@color, r.ptr, g.ptr, b.ptr, a.ptr)
    RGBA(r.value, g.value, b.value, a.value)
}

/** Creates a new Attribute that changes the background color of the text it is applied to. */
fun BackgroundAttribute(color: RGBA): Attribute =
    uiNewBackgroundAttribute(color.r, color.g, color.b, color.a) ?: throw Error()

/** Creates a new Attribute that changes the type of underline on the text it is applied to. */
fun UnderlineAttribute(u: uiUnderline): Attribute = uiNewUnderlineAttribute(u) ?: throw Error()

/** Returns the underline type stored in Attribute. */
val Attribute.underline: uiUnderline get() = uiAttributeUnderline(this)

/** creates a new Attribute that changes the color of the underline on the text it is applied to. */
fun UnderlineColorAttribute(u: uiUnderlineColor, color: RGBA): Attribute =
    uiNewUnderlineColorAttribute(u, color.r, color.g, color.b, color.a) ?: throw Error()

/** Returns the underline color kind stored in Attribute. */
val Attribute.underlineKind: uiUnderlineColor get() = memScoped {
    val k = alloc<uiUnderlineColorVar>()
    val r = alloc<DoubleVar>()
    val g = alloc<DoubleVar>()
    val b = alloc<DoubleVar>()
    val a = alloc<DoubleVar>()
    uiAttributeUnderlineColor(this@underlineKind, k.ptr, r.ptr, g.ptr, b.ptr, a.ptr)
    k.value
}

/** Returns the underline color stored in Attribute. */
val Attribute.underlineColor: RGBA get() = memScoped {
    val k = alloc<uiUnderlineColorVar>()
    val r = alloc<DoubleVar>()
    val g = alloc<DoubleVar>()
    val b = alloc<DoubleVar>()
    val a = alloc<DoubleVar>()
    uiAttributeUnderlineColor(this@underlineColor, k.ptr, r.ptr, g.ptr, b.ptr, a.ptr)
    RGBA(r.value, g.value, b.value, a.value)
}

///////////////////////////////////////////////////////////////////////////////

/** Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. */
typealias OpenTypeFeatures = CPointer<uiOpenTypeFeatures>

/** Creates a new OpenTypeFeatures instance, with no tags yet added. */
fun OpenTypeFeatures(): OpenTypeFeatures = uiNewOpenTypeFeatures() ?: throw Error()

/** Frees OpenTypeFeatures instance. */
fun OpenTypeFeatures.dispose() = uiFreeOpenTypeFeatures(this)

/** Makes a copy of otf and returns it. Changing one will not affect the other. */
fun OpenTypeFeatures.copy(): OpenTypeFeatures = uiOpenTypeFeaturesClone(this) ?: throw Error()

/** Adds the given feature tag and value to OpenTypeFeatures. If there is already a value
 *  associated with the specified tag in otf, the old value is removed. */
fun OpenTypeFeatures.add(tag: String, value: Int) =
    uiOpenTypeFeaturesAdd(this, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value)

/** Removes the given feature tag and value from OpenTypeFeatures. If the tag is not present
 *  in OpenTypeFeatures, it does nothing. */
fun OpenTypeFeatures.remove(tag: String) =
    uiOpenTypeFeaturesRemove(this, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte())

/** Determines whether the given feature tag is present in OpenTypeFeatures. */
fun OpenTypeFeatures.get(tag: String): Int = memScoped {
    val value = alloc<IntVar>()
    uiOpenTypeFeaturesGet(this@get, tag[0].toByte(), tag[1].toByte(), tag[2].toByte(), tag[3].toByte(), value.ptr)
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

/** Creates a new Attribute that changes the font family of the text it is applied to.
 *  otf is copied you may free it after uiNewFeaturesAttribute() returns. */
fun FeaturesAttribute(otf: OpenTypeFeatures): Attribute = uiNewFeaturesAttribute(otf) ?: throw Error()

/** Returns the OpenType features stored in Attribute. */
val Attribute.features: OpenTypeFeatures? get() = uiAttributeFeatures(this)

///////////////////////////////////////////////////////////////////////////////

/** represents a string of UTF-8 text that can be embellished with formatting attributes. */
typealias AttributedString = CPointer<uiAttributedString>

/** Creates a new AttributedString from initialString. The string will be entirely unattributed. */
fun Area.AttributedString(initString: String): AttributedString =
    (uiNewAttributedString(initString) ?: throw Error()).also { astrings.add(it) }

/** Destroys the AttributedString. It will also free all Attributes within. */
fun AttributedString.dispose() = uiFreeAttributedString(this)

/** Returns the textual content of AttributedString. */
val AttributedString.string: String get() = uiAttributedStringString(this)?.toKString() ?: ""

/** Returns the number of UTF-8 bytes in the textual content, excluding the terminating '\0'. */
val AttributedString.length: Int get() = uiAttributedStringLen(this).narrow()

/** Adds the '\0'-terminated UTF-8 string str to the end. The new substring will be unattributed. */
fun AttributedString.append(str: String) = uiAttributedStringAppendUnattributed(this, str)

/** Adds the '\0'-terminated UTF-8 string str to s at the byte position specified by [at].
 *  The new substring will be unattributed existing attributes will be moved along with their text. */
fun AttributedString.insert(str: String, at: Int) =
    uiAttributedStringInsertAtUnattributed(this, str, at.signExtend())

/** Deletes the characters and attributes in the byte range [start, end). */
fun AttributedString.delete(start: Int, end: Int) =
    uiAttributedStringDelete(this, start.signExtend(), end.signExtend())

/** Sets a in the byte range [start, end). Any existing attributes in that byte range of the same type are
 *  removed. Takes ownership of [a] you should not use it after uiAttributedStringSetAttribute() returns. */
fun AttributedString.setAttribute(a: Attribute, start: Int, end: Int) =
    uiAttributedStringSetAttribute(this, a, start.signExtend(), end.signExtend())

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
typealias FontDescriptor = CPointer<uiFontDescriptor>

/** Frees resources allocated in desc by uiFontButtonFont().
 *  After calling uiFreeFontButtonFont(), the contents of desc should be assumed to be undefined
 *  (though since you allocate desc itself, you can safely reuse desc for other font descriptors).
 *  Calling uiFreeFontButtonFont() on a uiFontDescriptor not returned by uiFontButtonFont()
 * results in undefined behavior. */
fun FontDescriptor.dispose() = uiFreeFontButtonFont(this)

///////////////////////////////////////////////////////////////////////////////

/** Concrete representation of a AttributedString that can be displayed in a uiDrawContext. */
typealias DrawTextLayout = CPointer<uiDrawTextLayout>

/** Creates a new DrawTextLayout from the given parameters. */
fun DrawTextLayout(
    string: AttributedString,
    defaultFont: FontDescriptor,
	width: Double,
    align: uiDrawTextAlign
): DrawTextLayout = memScoped {
    val params = alloc<uiDrawTextLayoutParams>()
	params.String = string
	params.DefaultFont = defaultFont
	params.Width = width
	params.Align = align
    return uiDrawNewTextLayout(params.ptr) ?: throw Error()
}

/** Frees DrawTextLayout. The underlying AttributedString is not freed. */
fun DrawTextLayout.dispose() = uiDrawFreeTextLayout(this);

/** Returns the size of DrawTextLayout. */
val DrawTextLayout.extents: Size
    get() = memScoped {
        val width = alloc<DoubleVar>()
        var height = alloc<DoubleVar>()
        uiDrawTextLayoutExtents(this@extents, width.ptr, height.ptr)
        Size(width.value, height.value)
    }

///////////////////////////////////////////////////////////////////////////////

typealias DrawContext = CPointer<uiDrawContext>

/** Draw a path filled with a color. */
fun DrawContext.fill(
    mode: uiDrawFillMode,
    brush: DrawBrush,
    block: DrawPath.() -> Unit
) {
    val path = uiDrawNewPath(mode) ?: throw Error()
    path.block()
    uiDrawPathEnd(path)
    uiDrawFill(this, path, brush)
    uiDrawFreePath(path)
}

/** Draw a path in the context. */
fun DrawContext.stroke(
    mode: uiDrawFillMode,
    brush: DrawBrush,
    stroke: DrawStrokeParams,
    block: DrawPath.() -> Unit
) {
    val path = uiDrawNewPath(mode) ?: throw Error()
    path.block()
    uiDrawPathEnd(path)
    uiDrawStroke(this, path, brush, stroke)
    uiDrawFreePath(path)
}

/** Apply a different transform matrix to the context. */
fun DrawContext.transform(block: DrawMatrix.() -> Unit) = memScoped {
    val matrix = alloc<uiDrawMatrix>().ptr
    uiDrawMatrixSetIdentity(matrix)
    matrix.block()
    uiDrawTransform(this@transform, matrix)
}

/** draws formatted text with the top-left point at ([x], [y]). */
fun DrawContext.draw(
    string: AttributedString,
    defaultFont: FontDescriptor,
	width: Double,
    align: uiDrawTextAlign,
    x: Double,
    y: Double
) {
    val layout = DrawTextLayout(string, defaultFont, width, align)
    uiDrawText(this, layout, x, y)
    uiDrawFreeTextLayout(layout)
}

//TODO fun DrawContext.clip(path: DrawPath) = uiDrawClip(this, path)

//TODO fun DrawContext.save() = uiDrawSave(this)

//TODO fun DrawContext.restore() = uiDrawRestore(this)
