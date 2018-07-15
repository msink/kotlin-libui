[libui-ktx](../index.md) / [libui](index.md) / [keyEvent](./key-event.md)

# keyEvent

`fun `[`DrawArea`](-draw-area/index.md)`.keyEvent(block: `[`DrawArea`](-draw-area/index.md)`.(<ERROR CLASS>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled.
(a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](#)
Only one function can be registered at a time.

