import libui.*
import libui.ktx.*

fun main(args: Array<String>) = appWindow(
    title = "Date / Time",
    width = 320,
    height = 240
) {
    gridpane {
        lateinit var labelBoth: Label
        lateinit var labelDate: Label
        lateinit var labelTime: Label

        val pickerBoth = cell(y = 0, xspan = 2, hexpand = true).datetimepicker {
            action {
                labelBoth.text = textValue()
            }
        }
        val pickerDate = cell(y = 1, hexpand = true).datepicker {
            action {
                labelDate.text = textValue()
            }
        }
        val pickerTime = cell(y = 1, x = 1, hexpand = true).timepicker {
            action {
                labelTime.text = textValue()
            }
        }

        labelBoth = cell(y = 2, xspan = 2, hexpand = true, halign = uiAlignCenter).label("")
        labelDate = cell(y = 3, x = 0, hexpand = true, halign = uiAlignCenter).label("")
        labelTime = cell(y = 3, x = 1, hexpand = true, halign = uiAlignCenter).label("")

        cell(y = 4, hexpand = true, vexpand = true, valign = uiAlignEnd).button("Now") {
            action {
                val now = platform.posix.time(null)
                pickerDate.value = now
                pickerTime.value = now
            }
        }
        cell(y = 4, x = 1, hexpand = true, vexpand = true, valign = uiAlignEnd).button("Unix epoch") {
            action {
                pickerBoth.value = 0
            }
        }
    }
}
