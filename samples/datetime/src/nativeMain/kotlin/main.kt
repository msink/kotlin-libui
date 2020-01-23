import libui.*
import libui.ktx.*

fun main() = appWindow(
    title = "Date / Time",
    width = 320,
    height = 240
) {
    gridpane {
        lateinit var labelBoth: Label
        lateinit var labelDate: Label
        lateinit var labelTime: Label

        val pickerBoth = datetimepicker {
            xspan = 2
            hexpand = true
            action {
                labelBoth.text = textValue()
            }
        }

        row()
        val pickerDate = datepicker {
            hexpand = true
            action {
                labelDate.text = textValue()
            }
        }
        val pickerTime = timepicker {
            hexpand = true
            action {
                labelTime.text = textValue()
            }
        }

        row()
        labelBoth = label("") {
            xspan = 2
            hexpand = true
            halign = uiAlignCenter
        }

        row()
        labelDate = label("") {
            hexpand = true
            halign = uiAlignCenter
        }
        labelTime = label("") {
            hexpand = true
            halign = uiAlignCenter
        }

        row()
        button("Now") {
            hexpand = true
            vexpand = true
            valign = uiAlignEnd
            action {
                val now = platform.posix.time(null)
                pickerDate.value = now
                pickerTime.value = now
            }
        }
        button("Unix epoch") {
            hexpand = true
            vexpand = true
            valign = uiAlignEnd
            action {
                pickerBoth.value = 0
            }
        }
    }
}
