[libui.ktx](../README.md) / [DrawArea](README.md)

# DrawArea

`open class DrawArea : `[`Control`](../-control/README.md)`<`[`uiArea`](../../libui/ui-area.md)`>`

Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas you can draw on.

### Constructors

| Name | Summary |
|---|---|
| [DrawArea](-draw-area.md) | `DrawArea(handler: CPointer<`[`ktAreaHandler`](../../libui/kt-area-handler/README.md)`> = nativeHeap.alloc<ktAreaHandler>().ptr, alloc: CPointer<`[`uiArea`](../../libui/ui-area.md)`>? = uiNewArea(handler.pointed.ui.ptr))` |

### Inherited properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [dragBroken](drag-broken.md) | `fun dragBroken(block: DrawArea.() -> Unit)`<br>Funcion to be run to indicate that a drag should be ended. Only implemented on Windows. Only one function can be registered at a time. |
| [draw](draw.md) | `fun draw(block: `[`DrawContext`](../-draw-context.md)`.(`[`AreaDrawParams`](../-area-draw-params.md)`) -> Unit)`<br>Funcion to be run when the area was created or got resized with [AreaDrawParams](../-area-draw-params.md) as parameter. Only one function can be registered at a time. |
| [keyEvent](key-event.md) | `fun keyEvent(block: DrawArea.(event: `[`uiAreaKeyEvent`](../../libui/ui-area-key-event/README.md)`) -> Boolean)`<br>Funcion to be run when a key was pressed. Return `true` to indicate that the key event was handled. (a menu item with that accelerator won't activate, no error sound on macOS). Event is an [uiAreaKeyEvent](../../libui/ui-area-key-event/README.md) Only one function can be registered at a time. |
| [mouseCrossed](mouse-crossed.md) | `fun mouseCrossed(block: DrawArea.(left: Boolean) -> Unit)`<br>Funcion to be run when the mouse entered (`left == false`) or left the area. Only one function can be registered at a time. |
| [mouseEvent](mouse-event.md) | `fun mouseEvent(block: DrawArea.(`[`AreaMouseEvent`](../-area-mouse-event.md)`) -> Unit)`<br>Funcion to be run when the mouse was moved or clicked over the area with [AreaMouseEvent](../-area-mouse-event.md) as parameter. Only one function can be registered at a time. |
| [redraw](redraw.md) | `fun redraw()`<br>Queues the entire DrawArea for redraw. The DrawArea is not redrawn before this function returns; it is redrawn when next possible. |

### Inherited functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable()`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose()`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable()`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): ULong`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide()`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show()`<br>Shows the Control. |

### Inheritors

| Name | Summary |
|---|---|
| [ScrollingArea](../-scrolling-area/README.md) | `class ScrollingArea : `[`DrawArea`](README.md)<br>Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas with horziontal and vertical scrollbars. |

### Extensions

| Name | Summary |
|---|---|
| [brush](../../libui.ktx.draw/brush.md) | `fun DrawArea.brush(): `[`Brush`](../../libui.ktx.draw/-brush/README.md)<br>Creates a new [Brush](../../libui.ktx.draw/-brush/README.md) with lifecycle delegated to [DrawArea](README.md). |
| [font](../../libui.ktx.draw/font.md) | `fun DrawArea.font(family: String? = null, size: Double = 0.0, weight: `[`uiTextWeight`](../../libui/ui-text-weight.md)` = uiTextWeightNormal, italic: `[`uiTextItalic`](../../libui/ui-text-italic.md)` = uiTextItalicNormal, stretch: `[`uiTextStretch`](../../libui/ui-text-stretch.md)` = uiTextStretchNormal): `[`Font`](../../libui.ktx.draw/-font/README.md)<br>Creates a new [Font](../../libui.ktx.draw/-font/README.md) with lifecycle delegated to [DrawArea](README.md). |
| [string](../../libui.ktx.draw/string.md) | `fun DrawArea.string(init: String): `[`AttributedString`](../../libui.ktx.draw/-attributed-string/README.md)<br>Creates a new [AttributedString](../../libui.ktx.draw/-attributed-string/README.md) from initial String. The string will be entirely unattributed. |
| [stroke](../../libui.ktx.draw/stroke.md) | `fun DrawArea.stroke(block: `[`uiDrawStrokeParams`](../../libui/ui-draw-stroke-params/README.md)`.() -> Unit = {}): `[`Stroke`](../../libui.ktx.draw/-stroke/README.md)<br>Creates a new [Stroke](../../libui.ktx.draw/-stroke/README.md) with lifecycle delegated to [DrawArea](README.md). |
