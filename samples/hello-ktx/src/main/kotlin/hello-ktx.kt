import libui.ktx.*

fun main(args: Array<String>) = appWindow(
    title = "Hello",
    width = 320,
    height = 240
) {
    vbox {
        lateinit var scroll: TextArea

        button("libui говорит: click me!") {
            action {
                scroll.append("""
                    |Hello, World!  Ciao, mondo!
                    |Привет, мир!  你好，世界！
                    |
                    |""".trimMargin())
            }
        }
        scroll = stretchy.textarea(readonly = true)
    }
}
