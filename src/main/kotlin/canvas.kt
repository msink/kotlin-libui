package libui

import kotlinx.cinterop.*

/** A canvas you can draw on. It also receives keyboard and mouse events,
 *  is DPI aware, and has several other useful features. */
fun DrawArea() : Area {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return Area(uiNewArea(handler.ui.ptr), handler.ptr)
}

/** Area with horziontal and vertical scrollbars. */
fun ScrollingArea(width: Int, height: Int) : Area {
    val handler = nativeHeap.alloc<ktAreaHandler>()
    return Area(uiNewScrollingArea(handler.ui.ptr, width, height), handler.ptr)
}

typealias AreaDrawParams = CPointer<uiAreaDrawParams>
typealias AreaMouseEvent = CPointer<uiAreaMouseEvent>
typealias AreaKeyEvent = CPointer<uiAreaKeyEvent>

class Area(_ptr: CPointer<uiArea>?, var handler: CPointer<ktAreaHandler>) : Control(_ptr) {
    internal val ptr: CPointer<uiArea> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    internal var draw: Area.(params: AreaDrawParams) -> Unit = {}
    internal var mouseEvent: Area.(event: AreaMouseEvent) -> Unit = {}
    internal var mouseCrossed: Area.(left: Boolean) -> Unit = {}
    internal var dragBroken: Area.() -> Unit = {}
    internal var keyEvent: Area.(event: AreaKeyEvent) -> Boolean = { false }
    init {
        handler.pointed.ui.Draw = staticCFunction(::_onDraw)
        handler.pointed.ui.MouseEvent = staticCFunction(::_onMouseEvent)
        handler.pointed.ui.MouseCrossed = staticCFunction(::_onMouseCrossed)
        handler.pointed.ui.DragBroken = staticCFunction(::_onDragBroken)
        handler.pointed.ui.KeyEvent = staticCFunction(::_onKeyEvent)
        handler.pointed.ref = ref.asCPointer()
    }
    override fun dispose() {
        nativeHeap.free(handler)
        super.dispose()
    }
}

fun Area.queueRedrawAll() = uiAreaQueueRedrawAll(ptr)

fun Area.setSize(width: Int, height: Int) =
    uiAreaSetSize(ptr, width, height)

fun Area.scrollTo(x: Double, y: Double, width: Double, height: Double) =
    uiAreaScrollTo(ptr, x, y, width, height)

//// TODO document these can only be called within Mouse() handlers
//// TODO should these be allowed on scrolling areas?
//// TODO decide which mouse events should be accepted Down is the only one guaranteed to work right now
//// TODO what happens to events after calling this up to and including the next mouse up?
//// TODO release capture?
//void uiAreaBeginUserWindowMove(uiArea *a)
//void uiAreaBeginUserWindowResize(uiArea *a, uiWindowResizeEdge edge)

/** Funcion to be run when the area was created or got resized with [AreaDrawParams] as parameter.
 *  Only one function can be registered at a time. */
fun Area.draw(proc: Area.(params: AreaDrawParams) -> Unit) {
    draw = proc
}
@Suppress("UNUSED_PARAMETER")
private fun _onDraw(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, params: AreaDrawParams?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        draw.invoke(this, params!!)
    }
}

/** Funcion to be run when the mouse was moved or clicked over the area with [AreaMouseEvent] as parameter.
 *  Only one function can be registered at a time. */
fun Area.mouseEvent(proc: Area.(event: AreaMouseEvent) -> Unit) {
    mouseEvent = proc
}
@Suppress("UNUSED_PARAMETER")
private fun _onMouseEvent(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, params: AreaMouseEvent?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        mouseEvent.invoke(this, params!!)
    }
}

/** Funcion to be run when the mouse entered (`left == false`) or left the area.
 *  Only one function can be registered at a time. */
fun Area.mouseCrossed(proc: Area.(left: Boolean) -> Unit) {
    mouseCrossed = proc
}
@Suppress("UNUSED_PARAMETER")
private fun _onMouseCrossed(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, left: Int) {
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
private fun _onDragBroken(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?) {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        dragBroken.invoke(this)
    }
}

/** Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled.
 *  (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [AreaKeyEvent]
 *  Only one function can be registered at a time. */
fun Area.keyEvent(proc: Area.(event: AreaKeyEvent) -> Boolean) {
    keyEvent = proc
}
@Suppress("UNUSED_PARAMETER")
private fun _onKeyEvent(handler: CPointer<uiAreaHandler>?, area: CPointer<uiArea>?, event: AreaKeyEvent?): Int {
    val h: CPointer<ktAreaHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<Area>().get()) {
        return if (keyEvent.invoke(this, event!!)) 1 else 0
    }
}

///////////////////////////////////////////////////////////////////////////////

typealias DrawBrush = CPointer<uiDrawBrush>
typealias DrawBrushGradientStop = CPointer<uiDrawBrushGradientStop>
typealias DrawStrokeParams = CPointer<uiDrawStrokeParams>
typealias DrawPath = CPointer<uiDrawPath>

fun DrawBrush.solid(rgba: RGBA, opacity: Double = 1.0): DrawBrush {
    pointed.Type = uiDrawBrushTypeSolid
    pointed.R = rgba.R
    pointed.G = rgba.G
    pointed.B = rgba.B
    pointed.A = rgba.A * opacity
    return this
}

fun DrawBrush.solid(color: Int, alpha: Double = 1.0): DrawBrush {
    pointed.Type = uiDrawBrushTypeSolid
    val rgba = RGBA(color, alpha)
    pointed.R = rgba.R
    pointed.G = rgba.G
    pointed.B = rgba.B
    pointed.A = alpha
    return this
}

fun DrawPath.figure(x: Double, y: Double) = uiDrawPathNewFigure(this, x, y)

fun DrawPath.lineTo(x: Double, y: Double) = uiDrawPathLineTo(this, x, y)

fun DrawPath.figureWithArc(xCenter: Double, yCenter: Double, radius: Double,
                           startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathNewFigureWithArc(this, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

fun DrawPath.arcTo(xCenter: Double, yCenter: Double, radius: Double,
                           startAngle: Double, sweep: Double, negative: Boolean = false) =
    uiDrawPathArcTo(this, xCenter, yCenter, radius, startAngle, sweep, if (negative) 1 else 0)

fun DrawPath.arcTo(c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double) =
    uiDrawPathBezierTo(this, c1x, c1y, c2x, c2y, endX, endY)

fun DrawPath.closeFigure() = uiDrawPathCloseFigure(this)

fun DrawPath.rectangle(x: Double, y: Double, width: Double, height: Double) =
    uiDrawPathAddRectangle(this, x, y, width, height)

///////////////////////////////////////////////////////////////////////////////

typealias DrawMatrix = CPointer<uiDrawMatrix>

fun DrawMatrix.translate(x: Double, y: Double) =
    uiDrawMatrixTranslate(this, x, y)

fun DrawMatrix.scale(xCenter: Double, yCenter: Double, x: Double, y: Double) =
    uiDrawMatrixScale(this, xCenter, yCenter, x, y)

fun DrawMatrix.scale(x: Double, y: Double, amount: Double) =
    uiDrawMatrixRotate(this, x, y, amount)

fun DrawMatrix.skew(x: Double, y: Double, xamount: Double, yamount: Double) =
    uiDrawMatrixSkew(this, x, y, xamount, yamount)

fun DrawMatrix.skew(other: DrawMatrix) =
    uiDrawMatrixMultiply(this, other)

fun DrawMatrix.invertible() =
    uiDrawMatrixInvertible(this)

fun DrawMatrix.invert() =
    uiDrawMatrixInvert(this)

//void uiDrawMatrixTransformPoint(uiDrawMatrix *m, double *x, double *y)
//void uiDrawMatrixTransformSize(uiDrawMatrix *m, double *x, double *y)

///////////////////////////////////////////////////////////

/** Stores information about an attribute in a AttributedString. */
typealias Attribute = CPointer<uiAttribute>

/** Frees a uiAttribute. You generally do not need to call this yourself,
 *  as uiAttributedString does this for you. */
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

/** Creates a new uiAttribute that changes the weight of the text it is applied to. */
fun WeightAttribute(weight: uiTextWeight): Attribute = uiNewWeightAttribute(weight) ?: throw Error()

/** uiAttributeWeight() returns the font weight stored in Attribute. */
val Attribute.weight: uiTextWeight get() = uiAttributeWeight(this)

/** Creates a new uiAttribute that changes the italic mode of the text it is applied to. */
fun ItalicAttribute(italic: uiTextItalic): Attribute = uiNewItalicAttribute(italic) ?: throw Error()

/** uiAttributeItalic() returns the font italic mode stored in Attribute. */
val Attribute.italic: uiTextItalic get() = uiAttributeItalic(this)

/** Creates a new uiAttribute that changes the stretch of the text it is applied to. */
fun StretchAttribute(stretch: uiTextStretch): Attribute = uiNewStretchAttribute(stretch) ?: throw Error()

/** Returns the font stretch stored in Attribute. */
val Attribute.stretch: uiTextStretch get() = uiAttributeStretch(this)

/** Creates a new uiAttribute that changes the color of the text it is applied to. */
fun ColorAttribute(color: RGBA): Attribute =
    uiNewColorAttribute(color.R, color.G, color.B, color.A) ?: throw Error()

/** Returns the text color stored in Attribute. */
val Attribute.color: RGBA get() = memScoped {
    val r = alloc<DoubleVar>()
    val g = alloc<DoubleVar>()
    val b = alloc<DoubleVar>()
    val a = alloc<DoubleVar>()
    uiAttributeColor(this@color, r.ptr, g.ptr, b.ptr, a.ptr)
    RGBA(r.value, g.value, b.value, a.value)
}

/** Creates a new uiAttribute that changes the background color of the text it is applied to. */
fun BackgroundAttribute(color: RGBA): Attribute =
    uiNewBackgroundAttribute(color.R, color.G, color.B, color.A) ?: throw Error()

/** Creates a new uiAttribute that changes the type of underline on the text it is applied to. */
fun UnderlineAttribute(u: uiUnderline): Attribute = uiNewUnderlineAttribute(u) ?: throw Error()

/** Returns the underline type stored in Attribute. */
val Attribute.underline: uiUnderline get() = uiAttributeUnderline(this)

/** creates a new uiAttribute that changes the color of the underline on the text it is applied to. */
fun UnderlineColorAttribute(u: uiUnderlineColor, color: RGBA): Attribute =
    uiNewUnderlineColorAttribute(u, color.R, color.G, color.B, color.A) ?: throw Error()

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

/** Creates a new uiAttribute that changes the font family of the text it is applied to.
 *  otf is copied you may free it after uiNewFeaturesAttribute() returns. */
fun FeaturesAttribute(otf: OpenTypeFeatures): Attribute = uiNewFeaturesAttribute(otf) ?: throw Error()

/** Returns the OpenType features stored in Attribute. */
val Attribute.features: OpenTypeFeatures? get() = uiAttributeFeatures(this)

///////////////////////////////////////////////////////////////////////////////

/** represents a string of UTF-8 text that can be embellished with formatting attributes. */
typealias AttributedString = CPointer<uiAttributedString>

/** Creates a new uiAttributedString from initialString. The string will be entirely unattributed. */
fun AttributedString(initString: String): AttributedString =
    uiNewAttributedString(initString) ?: throw Error()

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
fun AttributedString.insertAt(str: String, at: Int) =
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

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringNumGraphemes(uiAttributedString *s)

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringByteIndexToGrapheme(uiAttributedString *s, size_t pos)

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringGraphemeToByteIndex(uiAttributedString *s, size_t pos)

///////////////////////////////////////////////////////////////////////////////

/** Concrete representation of a AttributedString that can be displayed in a uiDrawContext. */
typealias DrawTextLayout = CPointer<uiDrawTextLayout>

/** Provides a complete description of a font where one is needed.  */
typealias FontDescriptor = CPointer<uiFontDescriptor>

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

/** Returns the width and height in width and height. */
//TODO void uiDrawTextLayoutExtents(uiDrawTextLayout *tl, double *width, double *height)

///////////////////////////////////////////////////////////////////////////////

typealias DrawContext = CPointer<uiDrawContext>

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

fun DrawContext.transform(block: DrawMatrix.() -> Unit) = memScoped {
    val matrix = alloc<uiDrawMatrix>().ptr
    uiDrawMatrixSetIdentity(matrix)
    matrix.block()
    uiDrawTransform(this@transform, matrix)
}

/** draws formatted text with the top-left point at ([x], [y]). */
fun DrawContext.text(
    string: AttributedString,
    defaultFont: FontDescriptor,
	width: Double,
    align: uiDrawTextAlign,
    x: Double, y: Double
) {
    val layout = DrawTextLayout(string, defaultFont, width, align)
    uiDrawText(this, layout, x, y)
    uiDrawFreeTextLayout(layout)
}

//TODO fun DrawContext.clip(path: DrawPath) = uiDrawClip(this, path)

//TODO fun DrawContext.save() = uiDrawSave(this)

//TODO fun DrawContext.restore() = uiDrawRestore(this)
