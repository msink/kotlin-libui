import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Hello",
    width = 320,
    height = 240
) {
    add(widget = VerticalBox {
        padded = true
        val button = add(widget = Button("libui говорит: click me!"))
        val scroll = add(stretchy = true, widget = MultilineEntry { readonly = true })
        button.action {
            scroll.append("Hello, World!  Ciao, mondo!\nПривет, мир!  你好，世界！\n\n")
        }
    })
}
