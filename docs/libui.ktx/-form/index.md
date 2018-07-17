[libui.ktx](../index.md) / [Form](./index.md)

# Form

`class Form : `[`Control`](../-control/index.md)`<`[`uiForm`](../../libui/ui-form.md)`>`

Wrapper class for [uiForm](../../libui/ui-form.md)

### Types

| Name | Summary |
|---|---|
| [Field](-field/index.md) | `inner class Field : `[`Container`](../-container/index.md)<br>adapter for DSL builders |
| [Stretchy](-stretchy/index.md) | `inner class Stretchy`<br>adapter for DSL builders |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Form()`<br>Wrapper class for [uiForm](../../libui/ui-form.md) |

### Properties

| Name | Summary |
|---|---|
| [padded](padded.md) | `var padded: Boolean`<br>If true, the container insert some space between children. |

### Inherited Properties

| Name | Summary |
|---|---|
| [ctl](../-control/ctl.md) | `val ctl: CPointer<`[`uiControl`](../../libui/ui-control/index.md)`>` |
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(label: String, widget: `[`Control`](../-control/index.md)`<*>, stretchy: Boolean = false): Unit`<br>Adds the given widget to the end of the form. |
| [delete](delete.md) | `fun delete(index: Int): Unit`<br>deletes the nth control of the form. |

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

### Extension Properties

| Name | Summary |
|---|---|
| [stretchy](../stretchy.md) | `val `[`Form`](./index.md)`.stretchy: `[`Stretchy`](-stretchy/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [field](../field.md) | `fun `[`Form`](./index.md)`.field(label: String): `[`Field`](-field/index.md) |
