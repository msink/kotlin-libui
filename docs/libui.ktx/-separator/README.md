[libui.ktx](../README.md) / [Separator](README.md)

# Separator

`abstract class Separator : `[`Control`](../-control/README.md)`<`[`uiSeparator`](../../libui/ui-separator.md)`>`

Wrapper class for [uiSeparator](../../libui/ui-separator.md)

### Constructors

| Name | Summary |
|---|---|
| [Separator](-separator.md) | `Separator(alloc: CPointer<`[`uiSeparator`](../../libui/ui-separator.md)`>?)`<br>Wrapper class for [uiSeparator](../../libui/ui-separator.md) |

### Inherited properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

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
| [HorizontalSeparator](../-horizontal-separator/README.md) | `class HorizontalSeparator : `[`Separator`](README.md)<br>Wrapper class for [uiSeparator](../../libui/ui-separator.md) - an horizontal line to visually separate widgets. |
| [VerticalSeparator](../-vertical-separator/README.md) | `class VerticalSeparator : `[`Separator`](README.md)<br>Wrapper class for [uiSeparator](../../libui/ui-separator.md) - a vertical line to visually separate widgets. |
