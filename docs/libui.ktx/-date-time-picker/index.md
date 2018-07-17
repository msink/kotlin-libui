[libui.ktx](../index.md) / [DateTimePicker](./index.md)

# DateTimePicker

`open class DateTimePicker : `[`Control`](../-control/index.md)`<`[`uiDateTimePicker`](../../libui/ui-date-time-picker.md)`>`

Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit date and time.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DateTimePicker()` |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: Long`<br>The current value in Unix epoch |

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
| [action](action.md) | `fun action(block: `[`DateTimePicker`](./index.md)`.() -> Unit): Unit`<br>Function to be run when the user makes a change to the Picker. Only one function can be registered at a time. |
| [getValue](get-value.md) | `fun getValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): Unit`<br>The current value as posix `struct tm` |
| [setValue](set-value.md) | `fun setValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): Unit`<br>Set current value from posix `struct tm` |
| [textValue](text-value.md) | `fun textValue(format: String = defaultFormat): String`<br>The current value as String. |

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

### Inheritors

| Name | Summary |
|---|---|
| [DatePicker](../-date-picker/index.md) | `class DatePicker : `[`DateTimePicker`](./index.md)<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit date. |
| [TimePicker](../-time-picker/index.md) | `class TimePicker : `[`DateTimePicker`](./index.md)<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) to edit time. |
