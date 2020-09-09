[libui.ktx](../README.md) / [ScrollingArea](README.md)

# ScrollingArea

`class ScrollingArea : `[`DrawArea`](../-draw-area/README.md)

Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars.

### Constructors

| Name | Summary |
|---|---|
| [ScrollingArea](-scrolling-area.md) | `ScrollingArea(width: Int, height: Int, handler: CPointer<`[`ktAreaHandler`](../../libui/kt-area-handler/README.md)`> = nativeHeap.alloc<ktAreaHandler>().ptr, alloc: CPointer<`[`uiArea`](../../libui/ui-area.md)`>? = uiNewScrollingArea(handler.pointed.ui.ptr, width, height))`<br>Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars. |

### Functions

| Name | Summary |
|---|---|
| [scrollTo](scroll-to.md) | `fun scrollTo(x: Double, y: Double, width: Double, height: Double): Unit`<br>Scrolls the ScrollingArea to show the given rectangle. |
| [setSize](set-size.md) | `fun setSize(width: Int, height: Int): Unit`<br>Sets the size of a ScrollingArea to the given size, in points. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dragBroken](../-draw-area/drag-broken.md) | `fun dragBroken(block: `[`DrawArea`](../-draw-area/README.md)`.() -> Unit): Unit`<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](../-draw-area/draw.md) | `fun draw(block: `[`DrawContext`](../-draw-context.md)`.(`[`AreaDrawParams`](../-area-draw-params.md)`) -> Unit): Unit`<br>Funcion to be run when the area was created or got resized with [AreaDrawParams](../-area-draw-params.md) as parameter. Only one function can be registered at a time. |
| [keyEvent](../-draw-area/key-event.md) | `fun keyEvent(block: `[`DrawArea`](../-draw-area/README.md)`.(event: `[`uiAreaKeyEvent`](../../libui/ui-area-key-event/README.md)`) -> Boolean): Unit`<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](../../libui/ui-area-key-event/README.md) Only one function can be registered at a time. |
| [mouseCrossed](../-draw-area/mouse-crossed.md) | `fun mouseCrossed(block: `[`DrawArea`](../-draw-area/README.md)`.(left: Boolean) -> Unit): Unit`<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](../-draw-area/mouse-event.md) | `fun mouseEvent(block: `[`DrawArea`](../-draw-area/README.md)`.(`[`AreaMouseEvent`](../-area-mouse-event.md)`) -> Unit): Unit`<br>Funcion to be run when the mouse was moved or clicked over the area with [AreaMouseEvent](../-area-mouse-event.md) as parameter. Only one function can be registered at a time. |
| [redraw](../-draw-area/redraw.md) | `fun redraw(): Unit`<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |

### Extension Functions

| Name | Summary |
|---|---|
| [brush](../../libui.ktx.draw/brush.md) | `fun `[`DrawArea`](../-draw-area/README.md)`.brush(): `[`Brush`](../../libui.ktx.draw/-brush/README.md)<br>Creates a new [Brush](../../libui.ktx.draw/-brush/README.md) with lifecycle delegated to [DrawArea](../-draw-area/README.md). |
| [string](../../libui.ktx.draw/string.md) | `fun `[`DrawArea`](../-draw-area/README.md)`.string(init: String): `[`AttributedString`](../../libui.ktx.draw/-attributed-string/README.md)<br>Creates a new [AttributedString](../../libui.ktx.draw/-attributed-string/README.md) from initial String. The string will be entirely unattributed. |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun `[`DrawArea`](../-draw-area/README.md)`.stroke(block: `[`uiDrawStrokeParams`](../../libui/ui-draw-stroke-params/README.md)`.() -> Unit = {}): `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)<br>Creates a new [Stroke](../../libui.ktx.draw/-stroke/README.md) with lifecycle delegated to [DrawArea](../-draw-area/README.md). |
