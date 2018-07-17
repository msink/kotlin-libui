[libui.ktx](../index.md) / [GridPane](./index.md)

# GridPane

`class GridPane : `[`Control`](../-control/index.md)`<`[`uiGrid`](../../libui/ui-grid.md)`>`

Wrapper class for [uiGrid](../../libui/ui-grid.md) - a powerful container that allow to specify
size and position of each children.

### Types

| Name | Summary |
|---|---|
| [Cell](-cell/index.md) | `inner class Cell : `[`Container`](../-container/index.md)<br>adapter for DSL builders |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GridPane()`<br>Wrapper class for [uiGrid](../../libui/ui-grid.md) - a powerful container that allow to specify size and position of each children. |

### Properties

| Name | Summary |
|---|---|
| [padded](padded.md) | `var padded: Boolean`<br>If true, the container insert some space between children. |

### Inherited Properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(widget: `[`Control`](../-control/index.md)`<*>, x: Int = 0, y: Int = 0, xspan: Int = 1, yspan: Int = 1, hexpand: Boolean = false, halign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill, vexpand: Boolean = false, valign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill): Unit`<br>Adds the given Control to the end of the GridPane. |
| [insert](insert.md) | `fun insert(widget: `[`Control`](../-control/index.md)`<*>, existing: `[`Control`](../-control/index.md)`<*>, at: `[`uiAt`](../../libui/ui-at.md)`, xspan: Int = 1, yspan: Int = 1, hexpand: Boolean = false, halign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill, vexpand: Boolean = false, valign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill): Unit`<br>Insert the given Control after existing Control. |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): Unit`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): Unit`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): Long`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): Unit`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): Unit`<br>Shows the Control. |

### Extension Functions

| Name | Summary |
|---|---|
| [cell](../cell.md) | `fun `[`GridPane`](./index.md)`.cell(x: Int = 0, y: Int = 0, xspan: Int = 1, yspan: Int = 1, hexpand: Boolean = false, halign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill, vexpand: Boolean = false, valign: `[`uiAlign`](../../libui/ui-align.md)` = uiAlignFill): `[`Cell`](-cell/index.md) |
