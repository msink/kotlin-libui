[libui.ktx](../index.md) / [DrawArea](index.md) / [keyEvent](./key-event.md)

# keyEvent

`fun keyEvent(block: `[`DrawArea`](index.md)`.(event: `[`uiAreaKeyEvent`](../../libui/ui-area-key-event/index.md)`) -> Boolean): Unit`

Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled.
(a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](../../libui/ui-area-key-event/index.md)
Only one function can be registered at a time.

