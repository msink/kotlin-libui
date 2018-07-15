[libui-ktx](../../index.md) / [libui](../index.md) / [DrawArea](./index.md)

# DrawArea

`open class DrawArea : `[`Control`](../-control/index.md)`<<ERROR CLASS>>`

### Properties

| [handler](handler.md) | `val handler: <ERROR CLASS><<ERROR CLASS>>` |

### Inherited Properties

| [ctl](../-control/ctl.md) | `val ctl: <ERROR CLASS><<ERROR CLASS>>` |
| [enabled](../-control/enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Inherited Functions

| [disable](../-control/disable.md) | `fun disable(): <ERROR CLASS>`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): <ERROR CLASS>`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): <ERROR CLASS>`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): <ERROR CLASS>`<br>Shows the Control. |

### Extension Functions

| [brush](../brush.md) | `fun `[`DrawArea`](./index.md)`.brush(): <ERROR CLASS>`<br>Creates a new Brush with lifecycle delegated to DrawArea. |
| [dragBroken](../drag-broken.md) | `fun `[`DrawArea`](./index.md)`.dragBroken(block: `[`DrawArea`](./index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](../draw.md) | `fun `[`DrawArea`](./index.md)`.draw(block: <ERROR CLASS><<ERROR CLASS>>.(<ERROR CLASS>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the area was created or got resized with [uiAreaDrawParams](#) as parameter. Only one function can be registered at a time. |
| [keyEvent](../key-event.md) | `fun `[`DrawArea`](./index.md)`.keyEvent(block: `[`DrawArea`](./index.md)`.(<ERROR CLASS>) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](#) Only one function can be registered at a time. |
| [mouseCrossed](../mouse-crossed.md) | `fun `[`DrawArea`](./index.md)`.mouseCrossed(block: `[`DrawArea`](./index.md)`.(left: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](../mouse-event.md) | `fun `[`DrawArea`](./index.md)`.mouseEvent(block: `[`DrawArea`](./index.md)`.(<ERROR CLASS>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Funcion to be run when the mouse was moved or clicked over the area with [uiAreaMouseEvent](#) as parameter. Only one function can be registered at a time. |
| [redraw](../redraw.md) | `fun `[`DrawArea`](./index.md)`.redraw(): <ERROR CLASS>`<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |
| [string](../string.md) | `fun `[`DrawArea`](./index.md)`.string(init: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): <ERROR CLASS>`<br>Creates a new AttributedString from initial String. The string will be entirely unattributed. |
| [stroke](../stroke.md) | `fun `[`DrawArea`](./index.md)`.stroke(block: <ERROR CLASS>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): <ERROR CLASS>`<br>Creates a new Stroke with lifecycle delegated to DrawArea. |

### Inheritors

| [ScrollingArea](../-scrolling-area.md) | `class ScrollingArea : `[`DrawArea`](./index.md) |

