import libui.*

fun main(args: Array<String>) = libuiApplication {

    Window("Date / Time", width = 320, height = 240, hasMenubar = false) {
        margined = true

        add(widget = Grid {
            padded = true

            val labelBoth = Label("")
            val labelDate = Label("")
            val labelTime = Label("")

            val pickerBoth = DateTimePicker() { action { labelBoth.text = textValue() } }
            val pickerDate = DatePicker() { action { labelDate.text = textValue() } }
            val pickerTime = TimePicker() { action { labelTime.text = textValue() } }

            val buttonUnix = Button("Unix epoch") { action { pickerBoth.value = 0 } }
            val buttonNow = Button("Now") {
                action {
                    val now = platform.posix.time(null)
                    pickerDate.value = now
                    pickerTime.value = now
                }
            }

            add(0, 0, 2, 1, 1, uiAlignFill, 0, uiAlignFill, widget = pickerBoth)
            add(0, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill, widget = pickerDate)
            add(1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill, widget = pickerTime)
            add(0, 2, 2, 1, 1, uiAlignCenter, 0, uiAlignFill, widget = labelBoth)
            add(0, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill, widget = labelDate)
            add(1, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill, widget = labelTime)
            add(0, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd, widget = buttonNow)
            add(1, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd, widget = buttonUnix)
        })

        onClose { uiQuit(); true }
        show()
    }
}
