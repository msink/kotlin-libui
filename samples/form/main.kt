import libui.*

fun main(args: Array<String>) = libuiApplication {

    Window(
        title = "Authentication required",
        width = 320,
        height = 200,
        hasMenubar = false) {
        margined = true

        add(VerticalBox {
            padded = true

            val username = TextEntry()
            val password = PasswordEntry()

            add(widget = Form {
                padded = true
                add(label = "Username", widget = username)
                add(label = "Password", widget = password)
            })

            add(widget = Button(text = "Login") {
                action {
                    MsgBox("${username.value}:${password.value}")
                }
            })
        })

        onClose { uiQuit(); true }
        show()
    }
}
