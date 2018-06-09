package libui                                                                  

import kotlinx.cinterop.*

data class RGBA(
    val R: Double,
    val G: Double,
    val B: Double,
    val A: Double = 1.0
)

fun RGBA(color: Int, alpha: Double = 1.0) = RGBA(
    R = ((color shr 16) and 255).toDouble() / 255,
    G = ((color shr 8) and 255).toDouble() / 255,
    B = ((color) and 255).toDouble() / 255,
    A = alpha
)

data class Size2D(val width: Int, val height: Int)

/**
 * Initializes package ui, runs [init] to set up the program,
 * and executes the GUI main loop. [init] should set up the program's
 * initial state: open the main window, create controls, and set up
 * events.
 */
fun application(init: () -> Unit) {
    memScoped {
        val options = alloc<uiInitOptions>()
        val error = uiInit(options.ptr)
        if (error != null) {
            val errorString = error.toKString()
            uiFreeInitError(error)
            throw Error("error initializing ui: '$errorString'")
        }
    }

    init()

    uiMain()
    uiUninit()
}
