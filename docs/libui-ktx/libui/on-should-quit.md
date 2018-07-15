[libui-ktx](../index.md) / [libui](index.md) / [onShouldQuit](./on-should-quit.md)

# onShouldQuit

`fun onShouldQuit(block: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Function to be executed when the OS wants the program to quit
or when a Quit menu item has been clicked.
Only one function may be registered at a time.

**Returns**
`true` when Quit will be called.

