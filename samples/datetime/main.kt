import libui.*

fun main(args: Array<String>) = application {

    Window("Date / Time", width = 320, height = 240, hasMenubar = false) {
        margined = true

        setChild(Grid {
            padded = true

            val labelBoth = Label("")
            val labelDate = Label("")
            val labelTime = Label("")

            val pickerBoth = DateTimePicker() { action { labelBoth.text = text("%c") } }
            val pickerDate = DatePicker() { action { labelDate.text = text("%x") } }
            val pickerTime = TimePicker() { action { labelTime.text = text("%X") } }

            val buttonUnix = Button("Unix epoch") { action { pickerBoth.value = 0 } }
            val buttonNow = Button("Now") {
                action {
                    val now = platform.posix.time(null)
                    pickerDate.value = now
                    pickerTime.value = now
                }
            }

            append(pickerBoth, 0, 0, 2, 1, 1, uiAlignFill, 0, uiAlignFill)
            append(pickerDate, 0, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)
            append(pickerTime, 1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)
            append(labelBoth,  0, 2, 2, 1, 1, uiAlignCenter, 0, uiAlignFill)
            append(labelDate,  0, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill)
            append(labelTime,  1, 3, 1, 1, 1, uiAlignCenter, 0, uiAlignFill)
            append(buttonNow,  0, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd)
            append(buttonUnix, 1, 4, 1, 1, 1, uiAlignFill, 1, uiAlignEnd)
        })

        onClose { uiQuit(); true }
        show()
    }
}
