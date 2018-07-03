import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Date / Time",
    width = 320,
    height = 240
) {
    gridpane {
        lateinit var labelBoth: Label
        lateinit var labelDate: Label
        lateinit var labelTime: Label

        lateinit var pickerBoth: DateTimePicker
        lateinit var pickerDate: DatePicker
        lateinit var pickerTime: TimePicker

        cell(xspan = 2, hexpand = true) {
            pickerBoth = datetimepicker {
                action {
                    labelBoth.text = textValue()
                }
            }
        }
        cell(y = 1, hexpand = true) {
            pickerDate = datepicker {
                action {
                    labelDate.text = textValue()
                }
            }
        }
        cell(y = 1, x = 1, hexpand = true) {
            pickerTime = timepicker {
                action {
                    labelTime.text = textValue()
                }
            }
        }
        cell(y = 2, xspan = 2, hexpand = true, halign = uiAlignCenter) {
            labelBoth = label("")
        }
        cell(y = 3, hexpand = true, halign = uiAlignCenter) {
            labelDate = label("")
        }
        cell(y = 3, x = 1, hexpand = true, halign = uiAlignCenter) {
            labelTime = label("")
        }
        cell(y = 4, hexpand = true, vexpand = true, valign = uiAlignEnd) {
            button("Now") {
                action {
                    val now = platform.posix.time(null)
                    pickerDate.value = now
                    pickerTime.value = now
                }
            }
        }
        cell(y = 4, x = 1, hexpand = true, vexpand = true, valign = uiAlignEnd) {
            button("Unix epoch") {
                action {
                    pickerBoth.value = 0
                }
            }
        }
    }
}
