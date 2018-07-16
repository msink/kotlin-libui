[libui.ktx](index.md) / [appWindow](./app-window.md)

# appWindow

`fun appWindow(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, margined: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, init: `[`Window`](-window/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Initializes package ui, runs [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) to set up the program,
and executes the GUI main loop. [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) should set up the program's
initial state: open the main window, create controls, and set up
events.

