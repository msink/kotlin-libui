import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Authentication required",
    width = 320,
    height = 200
) {
    vbox {
        padded = true

        lateinit var username: TextField
        lateinit var password: PasswordField

        form {
            padded = true
            username = textfield("Username")
            password = passwordfield("Password")
        }

        button("Login") {
            action {
                MsgBox("${username.value}:${password.value}")
            }
        }
    }
}
