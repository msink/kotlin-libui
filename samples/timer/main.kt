import kotlinx.cinterop.*
import platform.posix.*
import libui.*

fun main(args: Array<String>) = libuiApplication {
    Window("Hello", width = 320, height = 240, hasMenubar = false) {
        margined = true

        add(widget = VerticalBox {
            padded = true
            val scroll = WrappingMultilineEntry { readOnly = true }
            val button = Button("Say Something") {
                action { scroll.append("Saying something\n") }
            }

            onTimer(1000) {
                memScoped {
                    var now = alloc<time_tVar>()
                    now.value = time(null)
                    if (!scroll.destroyed)
                        scroll.append(ctime(now.ptr)!!.toKString())
                }
                true
            }

            add(widget = button)
            add(widget = scroll, stretchy = true)
        })

        onClose { uiQuit(); true }
        show()
    }
}
