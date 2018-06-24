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

    Window(title, width, height) {
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
fun onShouldQuit(proc: () -> Boolean) {
    val ref = StableRef.create(proc).also { actions.add(it) }
    uiOnShouldQuit(staticCFunction(::_onBoolHandler), ref.asCPointer())
}

/** Function to be executed on a timer on the main thread.
 *  @returns `true` to continue and `false` to stop. */
fun onTimer(milliseconds: Int, proc: () -> Boolean) {
    val ref = StableRef.create(proc).also { actions.add(it) }
    uiTimer(milliseconds, staticCFunction(::_onBoolHandler), ref.asCPointer())
}

private fun _onBoolHandler(ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<() -> Boolean>().get()
    return if (proc()) 1 else 0
}
