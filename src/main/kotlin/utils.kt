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

data class SizeInt(
    val width: Int,
    val height: Int
)

/**
 * Initializes package ui, runs [init] to set up the program,
 * and executes the GUI main loop. [init] should set up the program's
 * initial state: open the main window, create controls, and set up
 * events.
 */
fun libuiApplication(init: () -> Unit) {
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
