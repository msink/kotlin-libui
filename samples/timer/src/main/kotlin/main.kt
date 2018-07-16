import kotlinx.cinterop.*
import platform.posix.*
import libui.ktx.*

fun main(args: Array<String>) = appWindow(
    title = "Hello",
    width = 320,
    height = 240
) {
    vbox {
        lateinit var scroll: TextArea

        button("Say Something") {
            action {
                scroll.append("Saying something\n")
            }
        }
        scroll = stretchy.textarea(readonly = true)
        onTimer(1000) {
            memScoped {
                val now = alloc<time_tVar>().apply { value = time(null) }
                val str = ctime(now.ptr)!!.toKString()
                if (!scroll.disposed) scroll.append(str)
            }
            true
        }
    }
}
