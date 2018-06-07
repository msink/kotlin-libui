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

data class DateTime(//posix struct tm
    val sec: Int,	// seconds after the minute	0-61*
    val min: Int,	// minutes after the hour	0-59
    val hour: Int,	// hours since midnight	0-23
    val mday: Int,	// day of the month	1-31
    val mon: Int,	// months since January	0-11
    val year: Int,	// years since 1900
    val wday: Int,	// days since Sunday	0-6
    val yday: Int,	// days since January 1	0-365
    val isdst: Int)	// Daylight Saving Time flag

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
