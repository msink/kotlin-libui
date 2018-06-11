import libui.*

fun main(args: Array<String>) = application {
    Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false) {
        margined = true

        setChild(VerticalBox {
            padded = true
            val scroll = WrappingMultilineEntry {
                readOnly = true
            }
            val button = Button("libui говорит: click me!") {
                action {
                    scroll.append("Hello, World!  Ciao, mondo!\n" +
                                  "Привет, мир!  你好，世界！\n\n")
                }
            }
            append(button)
            append(scroll, stretchy = true)
        })

        onClose { uiQuit(); true }
        show()
    }
}
