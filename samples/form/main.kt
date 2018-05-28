import libui.*

//TODO: make it singleton or part of Application singleton
lateinit var mainWindow: Window

fun main(args: Array<String>) = application {

    mainWindow = Window(
        title = "Authentication required",
        width = 320,
        height = 200,
        hasMenubar = false) {
        margined = true

        setChild(VerticalBox {
            padded = true

            val username = Entry()
            val password = PasswordEntry()

            append(Form {
                padded = true
                append("Username", username)
                append("Password", password)
            })

            append(Button(text = "Login") {
                action {
                    uiMsgBox(mainWindow, "${username.text}:${password.text}", "")
                }
            })
        })

        onClose { uiQuit(); true }
        show()
    }
}
