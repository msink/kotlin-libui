[libui.ktx](../README.md) / [Slider](README.md)

# Slider

`class Slider : `[`Control`](../-control/README.md)`<`[`uiSlider`](../../libui/ui-slider.md)`>`

Wrapper class for [uiSlider](../../libui/ui-slider.md) - an horizontal slide to set numerical values.

### Constructors

| Name | Summary |
|---|---|
| [Slider](-slider.md) | `Slider(min: Int, max: Int)` |

### Properties

| Name | Summary |
|---|---|
| [hasToolTip](has-tool-tip.md) | `var hasToolTip: Boolean`<br>Whether or not the slider has a tool tip. |
| [value](value.md) | `var value: Int`<br>The current numeric value of the slider. |

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
| [action](action.md) | `fun action(block: Slider.() -> Unit)`<br>Function to be run when the user makes a change to the Slider. Only one function can be registered at a time. |
| [onReleased](on-released.md) | `fun onReleased(block: Slider.() -> Unit)`<br>Function to be run when the slider is released from dragging. Only one function can be registered at a time. |
| [setRange](set-range.md) | `fun setRange(min: Int, max: Int)`<br>Sets the slider range. |

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
