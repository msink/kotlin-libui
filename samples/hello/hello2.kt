import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = memScoped {
    val options = alloc<uiInitOptions>()
    val error = uiInit(options.ptr)
    if (error != null) throw Error("Error: '${error.toKString()}'")

    val window = Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false).apply {
        margined = true
    }

    val box = VerticalBox().apply {
        padded = true
    }
    uiWindowSetChild(window, box.reinterpret())

    val scroll = MultilineEntry().apply {
        readOnly = true
    }
    val button = Button(
        text = "libui говорит: click me!"
    )
    uiButtonOnClicked(button, staticCFunction { _, _scroll ->
        uiMultilineEntryAppend(_scroll?.reinterpret(),
            "Hello, World!  Ciao, mondo!\n" +
            "Привет, мир!  你好，世界！\n\n")
        }, scroll)
    uiBoxAppend(box, button.reinterpret(), 0)
    uiBoxAppend(box, scroll.reinterpret(), 1)

    window.onClosing { uiQuit(); 1 }
    uiControlShow(window.reinterpret())
    uiMain()
    uiUninit()
}
