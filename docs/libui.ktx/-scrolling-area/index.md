[libui.ktx](../index.md) / [ScrollingArea](./index.md)

# ScrollingArea

`class ScrollingArea : `[`DrawArea`](../-draw-area/index.md)

Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ScrollingArea(width: Int, height: Int, handler: CPointer<`[`ktAreaHandler`](../../libui/kt-area-handler/index.md)`> = nativeHeap.alloc<ktAreaHandler>().ptr, alloc: CPointer<`[`uiArea`](../../libui/ui-area.md)`>? = uiNewScrollingArea(handler.pointed.ui.ptr, width, height))`<br>Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars. |

### Functions

| Name | Summary |
|---|---|
| [scrollTo](scroll-to.md) | `fun scrollTo(x: Double, y: Double, width: Double, height: Double): Unit`<br>Scrolls the ScrollingArea to show the given rectangle. |
| [setSize](set-size.md) | `fun setSize(width: Int, height: Int): Unit`<br>Sets the size of a ScrollingArea to the given size, in points. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dragBroken](../-draw-area/drag-broken.md) | `fun dragBroken(block: `[`DrawArea`](../-draw-area/index.md)`.() -> Unit): Unit`<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](../-draw-area/draw.md) | `fun draw(block: `[`DrawContext`](../-draw-context.md)`.(params: `[`uiAreaDrawParams`](../../libui/ui-area-draw-params/index.md)`) -> Unit): Unit`<br>Funcion to be run when the area was created or got resized with [uiAreaDrawParams](../../libui/ui-area-draw-params/index.md) as parameter. Only one function can be registered at a time. |
| [keyEvent](../-draw-area/key-event.md) | `fun keyEvent(block: `[`DrawArea`](../-draw-area/index.md)`.(event: `[`uiAreaKeyEvent`](../../libui/ui-area-key-event/index.md)`) -> Boolean): Unit`<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](../../libui/ui-area-key-event/index.md) Only one function can be registered at a time. |
| [mouseCrossed](../-draw-area/mouse-crossed.md) | `fun mouseCrossed(block: `[`DrawArea`](../-draw-area/index.md)`.(left: Boolean) -> Unit): Unit`<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](../-draw-area/mouse-event.md) | `fun mouseEvent(block: `[`DrawArea`](../-draw-area/index.md)`.(event: `[`uiAreaMouseEvent`](../../libui/ui-area-mouse-event/index.md)`) -> Unit): Unit`<br>Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent](../../libui/ui-area-mouse-event/index.md) as parameter. Only one function can be registered at a time. |
| [redraw](../-draw-area/redraw.md) | `fun redraw(): Unit`<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |

### Extension Functions

| Name | Summary |
|---|---|
| [brush](../brush.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.brush(): `[`Brush`](../-brush/index.md)<br>Creates a new [Brush](../-brush/index.md) with lifecycle delegated to [DrawArea](../-draw-area/index.md). |
| [string](../string.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.string(init: String): `[`AttributedString`](../-attributed-string/index.md)<br>Creates a new [AttributedString](../-attributed-string/index.md) from initial String. The string will be entirely unattributed. |
| [stroke](../stroke.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../../libui/ui-draw-stroke-params/index.md)`.() -> Unit = {}): `[`Stroke`](../-stroke/index.md)<br>Creates a new [Stroke](../-stroke/index.md) with lifecycle delegated to [DrawArea](../-draw-area/index.md). |
