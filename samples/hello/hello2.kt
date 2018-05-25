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
    val scroll = MultilineEntry().apply {
        readOnly = true
    }
    val button = Button("libui говорит: click me!")
    button.onClick {
        uiMultilineEntryAppend(scroll,
            "Hello, World!  Ciao, mondo!\n" +
            "Привет, мир!  你好，世界！\n\n")
    }
    uiBoxAppend(box, button.reinterpret(), 0)
    uiBoxAppend(box, scroll.reinterpret(), 1)

    window.setChild(box)
    window.onClose { uiQuit(); true }
    window.show()
    uiMain()
    uiUninit()
    disposeStableRefs()
}
