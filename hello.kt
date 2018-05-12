import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = memScoped {
    val options = alloc<uiInitOptions>()
    uiInit(options.ptr)

    val window = uiNewWindow("Konan говорит: click me!", 320, 60, 1)
    uiWindowSetMargined(window, 1)
    fun onClosing(window: CPointer<uiWindow>?, ptr: COpaquePointer?): Int {
        uiControlDestroy(window?.reinterpret())
        uiQuit()
        return 0
    }
    uiWindowOnClosing(window, staticCFunction(::onClosing), null)

    val box = uiNewVerticalBox()
    uiWindowSetChild(window, box?.reinterpret())

    val button = uiNewButton("Quit")
    fun onButtonClick(button: CPointer<uiButton>?, ptr: COpaquePointer?) {
        println("Hi Kotlin")
    }
    uiButtonOnClicked(button, staticCFunction(::onButtonClick), null)
    uiBoxAppend(box, button?.reinterpret(), 0)

    uiControlShow(window?.reinterpret())
    uiMain()
    uiUninit()
}
