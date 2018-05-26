import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = application {
    Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false).apply {
        margined = true

        val box = VerticalBox().apply {
            padded = true
            val scroll = MultilineEntry().apply {
                readOnly = true
            }
            val button = Button("libui говорит: click me!").apply {
                action {
                    scroll.append("Hello, World!  Ciao, mondo!\n" +
                                  "Привет, мир!  你好，世界！\n\n")
                }
            }
            append(button)
            append(scroll, stretchy = true)
        }
        setChild(box)

        onClose { uiQuit(); true }
        show()
    }
}
