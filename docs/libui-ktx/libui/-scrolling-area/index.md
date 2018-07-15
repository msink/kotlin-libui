[libui-ktx](../../index.md) / [libui](../index.md) / [ScrollingArea](./index.md)

# ScrollingArea

`class ScrollingArea : `[`DrawArea`](../-draw-area/index.md)

Wrapper class for [uiArea](../ui-area.md) with scrollbars.

### Inherited Properties

| Name | Summary |
|---|---|
| [handler](../-draw-area/handler.md) | `val handler: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`ktAreaHandler`](../kt-area-handler/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [scrollTo](scroll-to.md) | `fun scrollTo(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, width: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, height: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Scrolls the ScrollingArea to show the given rectangle. |
| [setSize](set-size.md) | `fun setSize(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the size of a ScrollingArea to the given size, in points. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dragBroken](../-draw-area/drag-broken.md) | `fun dragBroken(block: `[`DrawArea`](../-draw-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](../-draw-area/draw.md) | `fun draw(block: `[`DrawContext`](../-draw-context.md)`.(params: `[`uiAreaDrawParams`](../ui-area-draw-params/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the area was created or got resized with [uiAreaDrawParams](../ui-area-draw-params/index.md) as parameter. Only one function can be registered at a time. |
| [keyEvent](../-draw-area/key-event.md) | `fun keyEvent(block: `[`DrawArea`](../-draw-area/index.md)`.(event: `[`uiAreaKeyEvent`](../ui-area-key-event/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](../ui-area-key-event/index.md) Only one function can be registered at a time. |
| [mouseCrossed](../-draw-area/mouse-crossed.md) | `fun mouseCrossed(block: `[`DrawArea`](../-draw-area/index.md)`.(left: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](../-draw-area/mouse-event.md) | `fun mouseEvent(block: `[`DrawArea`](../-draw-area/index.md)`.(event: `[`uiAreaMouseEvent`](../ui-area-mouse-event/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent](../ui-area-mouse-event/index.md) as parameter. Only one function can be registered at a time. |
| [redraw](../-draw-area/redraw.md) | `fun redraw(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |

### Extension Functions

| Name | Summary |
|---|---|
| [brush](../brush.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.brush(): `[`Brush`](../-brush/index.md)<br>Creates a new Brush with lifecycle delegated to DrawArea. |
| [string](../string.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.string(init: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`AttributedString`](../-attributed-string/index.md)<br>Creates a new AttributedString from initial String. The string will be entirely unattributed. |
| [stroke](../stroke.md) | `fun `[`DrawArea`](../-draw-area/index.md)`.stroke(block: `[`uiDrawStrokeParams`](../ui-draw-stroke-params/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Stroke`](../-stroke/index.md)<br>Creates a new Stroke with lifecycle delegated to DrawArea. |
