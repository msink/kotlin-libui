import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Date / Time",
    width = 320,
    height = 240
) {
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

        add(xspan = 2,
            hexpand = true,
            widget = pickerBoth)
        add(y = 1,
            hexpand = true,
            widget = pickerDate)
        add(y = 1,
            x = 1,
            hexpand = true,
            widget = pickerTime)
        add(y = 2,
            xspan = 2,
            hexpand = true,
            halign = uiAlignCenter,
            widget = labelBoth)
        add(y = 3,
            hexpand = true,
            halign = uiAlignCenter,
            widget = labelDate)
        add(y = 3,
            x = 1,
            hexpand = true,
            halign = uiAlignCenter,
            widget = labelTime)
        add(y = 4,
            hexpand = true,
            vexpand = true,
            valign = uiAlignEnd,
            widget = buttonNow)
        add(y = 4,
            x = 1,
            hexpand = true,
            vexpand = true,
            valign = uiAlignEnd,
            widget = buttonUnix)
    })
}
