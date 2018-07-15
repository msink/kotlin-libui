[libui-ktx](../../index.md) / [libui](../index.md) / [DatePicker](./index.md)

# DatePicker

`class DatePicker : `[`DateTimePicker`](../-date-time-picker/index.md)

### Constructors

| [&lt;init&gt;](-init-.md) | `DatePicker()` |

### Extension Properties

| [value](../value.md) | `var `[`DateTimePicker`](../-date-time-picker/index.md)`.value: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The current value in Unix epoch |

### Extension Functions

| [action](../action.md) | `fun `[`DateTimePicker`](../-date-time-picker/index.md)`.action(block: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function to be run when the user makes a change to the Picker. Only one function can be registered at a time. |
| [getValue](../get-value.md) | `fun `[`DateTimePicker`](../-date-time-picker/index.md)`.getValue(value: <ERROR CLASS><<ERROR CLASS>>): <ERROR CLASS>`<br>The current value as posix `struct tm` |
| [setValue](../set-value.md) | `fun `[`DateTimePicker`](../-date-time-picker/index.md)`.setValue(value: <ERROR CLASS><<ERROR CLASS>>): <ERROR CLASS>`<br>Set current value from posix `struct tm` |
| [textValue](../text-value.md) | `fun `[`DateTimePicker`](../-date-time-picker/index.md)`.textValue(format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = defaultFormat): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The current value as String. |

