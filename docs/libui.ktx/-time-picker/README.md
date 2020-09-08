[libui.ktx](../README.md) / [TimePicker](README.md)

# TimePicker

`class TimePicker : `[`DateTimePicker`](../-date-time-picker/README.md)

Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit time.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TimePicker()`<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit time. |

### Inherited Properties

| Name | Summary |
|---|---|
| [value](../-date-time-picker/value.md) | `var value: Long`<br>The current value in Unix epoch |

### Inherited Functions

| Name | Summary |
|---|---|
| [action](../-date-time-picker/action.md) | `fun action(block: `[`DateTimePicker`](../-date-time-picker/README.md)`.() -> Unit): Unit`<br>Function to be run when the user makes a change to the Picker. Only one function can be registered at a time. |
| [getValue](../-date-time-picker/get-value.md) | `fun getValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): Unit`<br>The current value as posix `struct tm` |
| [setValue](../-date-time-picker/set-value.md) | `fun setValue(value: CPointer<`[`tm`](../../libui/tm.md)`>): Unit`<br>Set current value from posix `struct tm` |
| [textValue](../-date-time-picker/text-value.md) | `fun textValue(format: String = defaultFormat): String`<br>The current value as String. |
