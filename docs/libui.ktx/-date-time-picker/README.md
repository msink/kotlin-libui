[libui.ktx](../README.md) / [DateTimePicker](README.md)

# DateTimePicker

`open class DateTimePicker : `[`Control`](../-control/README.md)`<`[`uiDateTimePicker`](../../libui/ui-date-time-picker.md)`>`

Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit date and time.

### Constructors

| Name | Summary |
|---|---|
| [DateTimePicker](-date-time-picker.md) | `DateTimePicker()` |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: time_t`<br>The current value in Unix epoch |

### Inherited properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/README.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `fun action(block: DateTimePicker.() -> Unit)`<br>Function to be run when the user makes a change to the Picker. Only one function can be registered at a time. |
| [getValue](get-value.md) | `fun getValue(value: CPointer<`[`tm`](../../libui/tm.md)`>)`<br>The current value as posix `struct tm` |
| [setValue](set-value.md) | `fun setValue(value: CPointer<`[`tm`](../../libui/tm.md)`>)`<br>Set current value from posix `struct tm` |
| [textValue](text-value.md) | `fun textValue(format: String = defaultFormat): String`<br>The current value as String. |

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
| [DatePicker](../-date-picker/README.md) | `class DatePicker : `[`DateTimePicker`](README.md)<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit date. |
| [TimePicker](../-time-picker/README.md) | `class TimePicker : `[`DateTimePicker`](README.md)<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit time. |
