import kotlinx.cinterop.*
import platform.posix.*
import libui.*

fun main(args: Array<String>) = application {
    Window("Hello", width = 320, height = 240, hasMenubar = false) {
        margined = true

        setChild(VerticalBox {
            padded = true
            val scroll = WrappingMultilineEntry {
                readOnly = true
            }
            val button = Button("Say Something") {
                action { scroll.append("Saying something\n") }
            }

            onTimer(1000) {
                memScoped {
                    var now = alloc<time_tVar>()
                    now.value = time(null)
                    scroll.append(ctime(now.ptr)!!.toKString())
                }
                true
            }

            append(button)
            append(scroll, stretchy = true)
        })

        onClose { uiQuit(); true }
        show()
    }
}
