[libui-ktx](../index.md) / [libui](index.md) / [ScrollingArea](./-scrolling-area.md)

# ScrollingArea

`class ScrollingArea : `[`DrawArea`](-draw-area/index.md)

### Inherited Properties

| Name | Summary |
|---|---|
| [handler](-draw-area/handler.md) | `val handler: <ERROR CLASS><<ERROR CLASS>>` |

### Extension Functions

| Name | Summary |
|---|---|
| [brush](brush.md) | `fun `[`DrawArea`](-draw-area/index.md)`.brush(): <ERROR CLASS>`<br>Creates a new Brush with lifecycle delegated to DrawArea. |
| [dragBroken](drag-broken.md) | `fun `[`DrawArea`](-draw-area/index.md)`.dragBroken(block: `[`DrawArea`](-draw-area/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](draw.md) | `fun `[`DrawArea`](-draw-area/index.md)`.draw(block: <ERROR CLASS><<ERROR CLASS>>.(<ERROR CLASS>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the area was created or got resized with [uiAreaDrawParams](#) as parameter. Only one function can be registered at a time. |
| [keyEvent](key-event.md) | `fun `[`DrawArea`](-draw-area/index.md)`.keyEvent(block: `[`DrawArea`](-draw-area/index.md)`.(<ERROR CLASS>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](#) Only one function can be registered at a time. |
| [mouseCrossed](mouse-crossed.md) | `fun `[`DrawArea`](-draw-area/index.md)`.mouseCrossed(block: `[`DrawArea`](-draw-area/index.md)`.(left: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](mouse-event.md) | `fun `[`DrawArea`](-draw-area/index.md)`.mouseEvent(block: `[`DrawArea`](-draw-area/index.md)`.(<ERROR CLASS>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent](#) as parameter. Only one function can be registered at a time. |
| [redraw](redraw.md) | `fun `[`DrawArea`](-draw-area/index.md)`.redraw(): <ERROR CLASS>`<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |
| [scrollTo](scroll-to.md) | `fun `[`ScrollingArea`](./-scrolling-area.md)`.scrollTo(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, width: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, height: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): <ERROR CLASS>`<br>Scrolls the ScrollingArea to show the given rectangle. |
| [setSize](set-size.md) | `fun `[`ScrollingArea`](./-scrolling-area.md)`.setSize(width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): <ERROR CLASS>`<br>Sets the size of a ScrollingArea to the given size, in points. |
| [string](string.md) | `fun `[`DrawArea`](-draw-area/index.md)`.string(init: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): <ERROR CLASS>`<br>Creates a new AttributedString from initial String. The string will be entirely unattributed. |
| [stroke](stroke.md) | `fun `[`DrawArea`](-draw-area/index.md)`.stroke(block: <ERROR CLASS>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Creates a new Stroke with lifecycle delegated to DrawArea. |
