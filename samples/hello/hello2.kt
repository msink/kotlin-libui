import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Hello", width = 320, height = 240) {
    vbox {
        padded = true
        val button = button("libui говорит: click me!")
        val scroll = multilinefield(stretchy = true) { readonly = true }
        button.action {
            scroll.append("Hello, World!  Ciao, mondo!\nПривет, мир!  你好，世界！\n\n")
        }
    }
}
