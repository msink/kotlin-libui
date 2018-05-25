package libui                                                                  

import kotlinx.cinterop.*

data class Size(val width: Int, val height: Int)

fun disposeStableRefs() = _stableRefs.forEach { it.dispose() }

internal var _stableRefs = mutableListOf<StableRef<Any>>()

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
        if (error != null) throw Error("Error: '${error.toKString()}'")
    }

    init()

    uiMain()
    uiUninit()
    disposeStableRefs()
}
