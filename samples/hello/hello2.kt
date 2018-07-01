import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Hello", width = 320, height = 240) {
    vbox {
        val button = button("libui говорит: click me!")
        val scroll = textarea(readonly = true, stretchy = true)
        button.action {
            scroll.append("Hello, World!  Ciao, mondo!\nПривет, мир!  你好，世界！\n\n")
        }
    }
}
