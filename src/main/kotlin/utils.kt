package libui

import kotlinx.cinterop.*

fun random() = platform.posix.rand()

/**
 * Initializes package ui, runs [init] to set up the program,
 * and executes the GUI main loop. [init] should set up the program's
 * initial state: open the main window, create controls, and set up
 * events.
 */
fun appWindow(
    title: String,
    width: Int,
    height: Int,
    margined: Boolean = true,
    block: Window.() -> Unit = {}
) {
    platform.posix.srand(platform.posix.time(null).toInt())

    memScoped {
        val options = alloc<uiInitOptions>()
        val error = uiInit(options.ptr)
        if (error != null) {
            val errorString = error.toKString()
            uiFreeInitError(error)
            throw Error("error initializing ui: '$errorString'")
        }
    }

    Window(title, width, height, margined) {
        onClose { uiQuit(); true }
        onShouldQuit { dispose(); true }

        block()

        show()
    }

    uiMain()
    uiUninit()
    actions.forEach { it.dispose() }
}

private val actions = mutableListOf<StableRef<Any>>()

/** Function to be executed when the OS wants the program to quit
 *  or when a Quit menu item has been clicked.
 *  Only one function may be registered at a time.
 *  @returns `true` when Quit will be called. */
fun onShouldQuit(block: () -> Boolean) {
    val ref = StableRef.create(block).also { actions.add(it) }
    uiOnShouldQuit(staticCFunction { _ref ->
        val _block = _ref!!.asStableRef<() -> Boolean>().get()
        if (_block()) 1 else 0 }, ref.asCPointer())
}

/** Function to be executed on a timer on the main thread.
 *  @returns `true` to continue and `false` to stop. */
fun onTimer(milliseconds: Int, block: () -> Boolean) {
    val ref = StableRef.create(block).also { actions.add(it) }
    uiTimer(milliseconds, staticCFunction{ _ref ->
        val _block = _ref!!.asStableRef<() -> Boolean>().get()
        if (_block()) 1 else 0 }, ref.asCPointer())
}

