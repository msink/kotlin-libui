package libui                                                                  

import kotlinx.cinterop.*

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

/** Function to be executed when the OS wants the program to quit
 *  or when a Quit menu item has been clicked.
 *  Only one function may be registered at a time.
 *  @returns [true] when Quit will be called. */
fun onShouldQuit(proc: () -> Boolean) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiOnShouldQuit(staticCFunction(::_onShouldQuit), ref.asCPointer())
}

internal fun _onShouldQuit(ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<() -> Boolean>().get()
    return if (proc()) 1 else 0
}

fun Window.OpenFileDialog(): String? {
    val rawName = uiOpenFile(this)
    if (rawName == null) return null
    val strName = rawName.toKString()
    uiFreeText(rawName)
    return strName
}

fun Window.SaveFileDialog(): String? {
    val rawName = uiSaveFile(this)
    if (rawName == null) return null
    val strName = rawName.toKString()
    uiFreeText(rawName)
    return strName
}

fun Window.MsgBox(text: String, details: String = "")
    = uiMsgBox(this, text, details)

fun Window.MsgBoxError(text: String, details: String = "")
    = uiMsgBoxError(this, text, details)
