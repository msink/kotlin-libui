import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = application {

    val window = Window(
        title = "Authentication required",
        width = 320,
        height = 200,
        hasMenubar = false)
    window.margined = true

    val box = VerticalBox().apply { padded = true }

    val username = Entry()
    val password = PasswordEntry()
    val form = Form().apply { padded = true }
    form.append("Username", username)
    form.append("Password", password)

    val button = Button(text = "Login")
    button.action {
        uiMsgBox(window, title = "Info", description = "${username.text}:${password.text}")
    }

    box.append(form)
    box.append(button)

    window.setChild(box)
    window.onClose { uiQuit(); true }
    window.show()
}
