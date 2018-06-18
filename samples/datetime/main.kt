import libui.*

fun main(args: Array<String>) = libuiApplication {

    Window("Date / Time", width = 320, height = 240, hasMenubar = false) {
        margined = true

        add(Grid {
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

            add(pickerBoth, 0, 0, 2, 1, 1, uiAlignFill, 0, uiAlignFill)
            add(pickerDate, 0, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)
            add(pickerTime, 1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)
            add(labelBoth,  0, 2, 2, 1, 1, uiAlignCenter, 0, uiAlignFill)
            add(labelDate,  0, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill)
            add(labelTime,  1, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill)
            add(buttonNow,  0, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd)
            add(buttonUnix, 1, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd)
        })

        onClose { uiQuit(); true }
        show()
    }
}
