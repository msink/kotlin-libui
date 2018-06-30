import kotlinx.cinterop.*
import platform.posix.*
import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Hello",
    width = 320,
    height = 240
) {
    add(widget = VerticalBox().apply {
        padded = true

        val scroll = MultilineField().apply { readonly = true }
        val button = Button("Say Something").apply {
            action { scroll.append("Saying something\n") }
        }

        onTimer(1000) {
            memScoped {
                val now = alloc<time_tVar>().apply { value = time(null) }
                val str = ctime(now.ptr)!!.toKString()
                if (!scroll.disposed) scroll.append(str)
            }
            true
        }

        add(widget = button)
        add(widget = scroll, stretchy = true)
    })
}
