import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Authentication required",
    width = 320,
    height = 200
) {
    add(widget = VerticalBox {
        padded = true

        val username = Entry()
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
}
