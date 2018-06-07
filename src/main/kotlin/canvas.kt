package libui

import kotlinx.cinterop.*

/** A canvas you can draw on. It also receives keyboard and mouse events,
 *  supports scrolling, is DPI aware, and has several other useful features. */
typealias Area = CPointer<uiArea>

/** Create a new simple rectangular area without scrollbars. */
fun Area(handler: AreaHandler, block: Area.() -> Unit = {}): Area =
    uiNewArea(handler)?.apply(block) ?: throw Error()

/** Create a new scrolling area with horziontal and vertical scrollbars. */
fun ScrollingArea(handler: AreaHandler, width: Int, height: Int, block: Area.() -> Unit = {}): Area =
    uiNewScrollingArea(handler, width, height)?.apply(block) ?: throw Error()

fun Area.setSize(width: Int, height: Int) =
    uiAreaSetSize(this, width, height)

fun Area.queueRedrawAll() =
    uiAreaQueueRedrawAll(this)

fun Area.scrollTo(x: Double, y: Double, width: Double, height: Double) =
    uiAreaScrollTo(this, x, y, width, height)

//// TODO document these can only be called within Mouse() handlers
//// TODO should these be allowed on scrolling areas?
//// TODO decide which mouse events should be accepted Down is the only one guaranteed to work right now
//// TODO what happens to events after calling this up to and including the next mouse up?
//// TODO release capture?
//void uiAreaBeginUserWindowMove(uiArea *a)
//void uiAreaBeginUserWindowResize(uiArea *a, uiWindowResizeEdge edge)

///////////////////////////////////////////////////////////////////////////////

/** An object with several methods that Area calls to do certain tasks. */
typealias AreaHandler = CPointer<uiAreaHandler>

typealias AreaDrawParams = CPointer<uiAreaDrawParams>
typealias AreaMouseEvent = CPointer<uiAreaMouseEvent>
typealias AreaKeyEvent = CPointer<uiAreaKeyEvent>

/** Create a new AreaHandler.
 *  @param[draw] called when the area was created or got resized with [AreaDrawParams] as parameter.
 *  @param[mouseEvent] called when the mouse was moved or clicked over the area with [AreaMouseEvent] as parameter.
 *  @param[mouseCrossed] called when the mouse entered (`left == false`) or left the area.
 *  @param[dragBroken] called to indicate that a drag should be ended. Only implemented on Windows.
 *  @param[keyEvent] called when a key was pressed. Return `true` to indicate that the key event was handled
 *    (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [AreaKeyEvent] */
fun Window.AreaHandler(
    draw: Area.(params: AreaDrawParams) -> Unit,
    mouseEvent: Area.(event: AreaMouseEvent) -> Unit = {},
    mouseCrossed: Area.(left: Boolean) -> Unit = {},
    dragBroken: Area.() -> Unit = {},
    keyEvent: Area.(event: AreaKeyEvent) -> Boolean = { false }
) : AreaHandler {
    val handler = nativeHeap.alloc<ktAreaHandler>().apply {
        ui.Draw = staticCFunction(::_onDraw)
        ui.MouseEvent = staticCFunction(::_onMouseEvent)
        ui.MouseCrossed = staticCFunction(::_onMouseCrossed)
        ui.DragBroken = staticCFunction(::_onDragBroken)
        ui.KeyEvent = staticCFunction(::_onKeyEvent)
        kt.draw = StableRef.create(draw).also{ actions.add(it) }.asCPointer()
        kt.mouseEvent = StableRef.create(mouseEvent).also{ actions.add(it) }.asCPointer()
        kt.mouseCrossed = StableRef.create(mouseCrossed).also{ actions.add(it) }.asCPointer()
        kt.dragBroken = StableRef.create(dragBroken).also{ actions.add(it) }.asCPointer()
        kt.keyEvent = StableRef.create(keyEvent).also{ actions.add(it) }.asCPointer()
    }
    handlers.add(handler.ptr)
    return handler.ui.ptr
}

private fun _onDraw(handler: AreaHandler?, area: Area?, params: AreaDrawParams?) {
    val refs: CPointer<ktAreaHandler> = handler!!.reinterpret()
    val proc = refs.pointed.kt.draw!!.asStableRef<Area.(params: AreaDrawParams) -> Unit>().get()
    area!!.proc(params!!)
}

private fun _onMouseEvent(handler: AreaHandler?, area: Area?, event: AreaMouseEvent?) {
    val refs: CPointer<ktAreaHandler> = handler!!.reinterpret()
    val proc = refs.pointed.kt.mouseEvent!!.asStableRef<Area.(event: AreaMouseEvent) -> Unit>().get()
    area!!.proc(event!!)
}

private fun _onMouseCrossed(handler: AreaHandler?, area: Area?, left: Int) {
    val refs: CPointer<ktAreaHandler> = handler!!.reinterpret()
    val proc = refs.pointed.kt.mouseCrossed!!.asStableRef<Area.(left: Boolean) -> Unit>().get()
    area!!.proc(left != 0)
}

private fun _onDragBroken(handler: AreaHandler?, area: Area?) {
    val refs: CPointer<ktAreaHandler> = handler!!.reinterpret()
    val proc = refs.pointed.kt.dragBroken!!.asStableRef<Area.() -> Unit>().get()
    area!!.proc()
}

private fun _onKeyEvent(handler: AreaHandler?, area: Area?, event: AreaKeyEvent?) : Int {
    val refs: CPointer<ktAreaHandler> = handler!!.reinterpret()
    val proc = refs.pointed.kt.keyEvent!!.asStableRef<Area.(event: AreaKeyEvent) -> Boolean>().get()
    return if (area!!.proc(event!!)) 1 else 0
}
