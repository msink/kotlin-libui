[libui.ktx](index.md) / [appWindow](./app-window.md)

# appWindow

`fun appWindow(title: String, width: Int, height: Int, margined: Boolean = true, init: `[`Window`](-window/index.md)`.() -> Unit = {}): Unit`

Initializes package ui, runs [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) to set up the program,
and executes the GUI main loop. [init](app-window.md#libui.ktx$appWindow(kotlin.String, kotlin.Int, kotlin.Int, kotlin.Boolean, kotlin.Function1((libui.ktx.Window, kotlin.Unit)))/init) should set up the program's
initial state: open the main window, create controls, and set up
events.

