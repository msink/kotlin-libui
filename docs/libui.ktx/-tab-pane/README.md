[libui.ktx](../README.md) / [TabPane](README.md)

# TabPane

`class TabPane : `[`Control`](../-control/README.md)`<`[`uiTab`](../../libui/ui-tab.md)`>`

Wrapper class for [uiTab](../../libui/ui-tab.md) - a container that show each children in a separate tab.

### Types

| Name | Summary |
|---|---|
| [Page](-page/README.md) | `inner class Page : `[`Container`](../-container/README.md)<br>adapter for DSL builders |

### Constructors

| Name | Summary |
|---|---|
| [TabPane](-tab-pane.md) | `TabPane()`<br>Wrapper class for [uiTab](../../libui/ui-tab.md) - a container that show each children in a separate tab. |

### Properties

| Name | Summary |
|---|---|
| [numPages](num-pages.md) | `val numPages: Int`<br>Number of pages in the TabPane. |

### Inherited Properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(label: String, widget: `[`Control`](../-control/README.md)`<*>): Unit`<br>Adds the given page to the end of the TabPane. |
| [delete](delete.md) | `fun delete(page: Int): Unit`<br>Delete deletes the nth page of the TabPane. |
| [getMargined](get-margined.md) | `fun getMargined(page: Int): Boolean`<br>Whether page n (starting at 0) of the Tab has margins around its child. |
| [insert](insert.md) | `fun insert(page: Int, name: String, widget: `[`Control`](../-control/README.md)`<*>): Unit`<br>Adds the given page to the TabPane such that it is the nth page of the TabPane (starting at 0). |
| [setMargined](set-margined.md) | `fun setMargined(page: Int, margined: Boolean): Unit` |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): Unit`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): Unit`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): ULong`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): Unit`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): Unit`<br>Shows the Control. |

### Extension Functions

| Name | Summary |
|---|---|
| [page](../page.md) | `fun `[`TabPane`](README.md)`.page(label: String, margined: Boolean = true, init: `[`Page`](-page/README.md)`.() -> Unit = {}): `[`Page`](-page/README.md) |
