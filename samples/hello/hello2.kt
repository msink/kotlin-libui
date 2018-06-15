import libui.*

fun main(args: Array<String>) = libuiApplication {
    Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false) {
        margined = true

        add(VerticalBox {
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
            add(button)
            add(scroll, stretchy = true)
        })

        onClose { uiQuit(); true }
        show()
    }
}
