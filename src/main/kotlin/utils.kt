package libui                                                                  

import kotlinx.cinterop.*

data class RGBA(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double = 1.0
)

fun RGBA(color: Int, alpha: Double = 1.0) = RGBA(
    r = ((color shr 16) and 255).toDouble() / 255,
    g = ((color shr 8) and 255).toDouble() / 255,
    b = ((color) and 255).toDouble() / 255,
    a = alpha
)

data class SizeInt(val width: Int, val height: Int)

data class Size(val width: Double, val height: Double)

data class Point(val x: Double, val y: Double)

fun random() = platform.posix.rand()

/**
 * Initializes package ui, runs [init] to set up the program,
 * and executes the GUI main loop. [init] should set up the program's
 * initial state: open the main window, create controls, and set up
 * events.
 */
fun libuiApplication(block: () -> Unit) {
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

    block()

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
