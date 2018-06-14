import libui.*

fun main(args: Array<String>) = application {

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

            add(Form {
                padded = true
                add("Username", username)
                add("Password", password)
            })

            add(Button(text = "Login") {
                action {
                    MsgBox("${username.value}:${password.value}")
                }
            })
        })

        onClose { uiQuit(); true }
        show()
    }
}
