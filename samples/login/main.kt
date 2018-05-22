import kotlinx.cinterop.*
import libui.*

fun main(args: Array<String>) = memScoped {
    val options = alloc<uiInitOptions>()
    val error = uiInit(options.ptr)
    if (error != null) throw Error("Error: '${error.toKString()}'")

    val window = Window(
        title = "Authentication required",
        width = 320,
        height = 200,
        hasMenubar = false)
    window.margined = true

    val box = VerticalBox().apply { padded = true }

    val (username, password) = Entry() to PasswordEntry()

    val button = Button(text = "Login")
    uiButtonOnClicked(
         button,
         staticCFunction { _, _ -> /* TODO: Get text from username and password */ },
         button)

    val form = Form().apply { padded = true }
    uiFormAppend(form, "Username", username.reinterpret(), 0)
    uiFormAppend(form, "Password", password.reinterpret(), 0)

    uiBoxAppend(box, form.reinterpret(), 0)
    uiBoxAppend(box, button.reinterpret(), 0)

    uiWindowSetChild(window, box.reinterpret())
    uiWindowOnClosing(window, staticCFunction { _, _ -> uiQuit(); 1 }, null)
    uiControlShow(window.reinterpret())
    uiMain()
    uiUninit()
}
