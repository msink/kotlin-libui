import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = memScoped {
    val options = alloc<uiInitOptions>()
    val error = uiInit(options.ptr)
    if (error != null) throw Error("Error: '${error.toKString()}'")

    val window = Window("Hello",
            width = 320, height = 240, hasMenubar = false).apply { margined = true }

    val box = VerticalBox().apply { padded = true }
    uiWindowSetChild(window, box.reinterpret())

    val scroll = MultilineEntry().apply { readOnly = true }
    val button = Button("libui говорит: click me!")
    fun saySomething(box: Button?, scroll: COpaquePointer?) {
        uiMultilineEntryAppend(scroll?.reinterpret(),
            "Hello, World!  Ciao, mondo!\n" +
            "Привет, мир!  你好，世界！\n\n")
    }
    uiButtonOnClicked(button, staticCFunction(::saySomething), scroll)
    uiBoxAppend(box, button.reinterpret(), 0)
    uiBoxAppend(box, scroll.reinterpret(), 1)

    fun onClosing(window: Window?, data: COpaquePointer?): Int {
        uiQuit()
        return 1
    }
    uiWindowOnClosing(window, staticCFunction(::onClosing), null)
    uiControlShow(window.reinterpret())
    uiMain()
    uiUninit()
}
