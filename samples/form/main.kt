import libui.*

fun main(args: Array<String>) = application {

    Window(
        title = "Authentication required",
        width = 320,
        height = 200,
        hasMenubar = false) {
        margined = true

        setChild(VerticalBox {
            padded = true

            val username = TextEntry()
            val password = PasswordEntry()

            append(Form {
                padded = true
                append("Username", username)
                append("Password", password)
            })

            append(Button(text = "Login") {
                action {
                    MsgBox("${username.text}:${password.text}")
                }
            })
        })

        onClose { uiQuit(); true }
        show()
    }
}
