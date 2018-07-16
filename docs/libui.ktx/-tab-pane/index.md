[libui.ktx](../index.md) / [TabPane](./index.md)

# TabPane

`class TabPane : `[`Control`](../-control/index.md)`<`[`uiTab`](../../libui/ui-tab.md)`>`

Wrapper class for [uiTab](../../libui/ui-tab.md)

### Types

| Name | Summary |
|---|---|
| [Page](-page/index.md) | `inner class Page : `[`Container`](../-container/index.md)<br>adapter for DSL builders |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TabPane()`<br>Wrapper class for [uiTab](../../libui/ui-tab.md) |

### Properties

| Name | Summary |
|---|---|
| [numPages](num-pages.md) | `val numPages: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Number of pages in the TabPane. |

### Inherited Properties

| Name | Summary |
|---|---|
| [ctl](../-control/ctl.md) | `val ctl: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiControl`](../../libui/ui-control/index.md)`>` |
| [enabled](../-control/enabled.md) | `var enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, widget: `[`Control`](../-control/index.md)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the given page to the end of the TabPane. |
| [delete](delete.md) | `fun delete(page: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete deletes the nth page of the TabPane. |
| [getMargined](get-margined.md) | `fun getMargined(page: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether page n (starting at 0) of the Tab has margins around its child. |
| [insert](insert.md) | `fun insert(page: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, widget: `[`Control`](../-control/index.md)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the given page to the TabPane such that it is the nth page of the TabPane (starting at 0). |
| [setMargined](set-margined.md) | `fun setMargined(page: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Shows the Control. |

### Extension Functions

| Name | Summary |
|---|---|
| [page](../page.md) | `fun `[`TabPane`](./index.md)`.page(label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Page`](-page/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Page`](-page/index.md) |
