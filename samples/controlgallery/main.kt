import libui.*

//TODO: make it singleton or part of Application singleton
lateinit var mainWindow: Window

fun makeBasicControlsPage() = VerticalBox() {
    padded = true

    append(HorizontalBox() {
        padded = true
        append(Button("Button"))
        append(Checkbox("Checkbox"))
    })
    append(Label("This is a label. Right now, labels can only span one line."))
    append(HorizontalSeparator())
    append(Group("Entries") {
        margined = true
        setChild(Form() {
            padded = true
            append("Entry", Entry())
            append("Password Entry", PasswordEntry())
            append("Search Entry", SearchEntry())
            append("Multiline Entry", MultilineEntry(), stretchy = true)
            append("Multiline Entry No Wrap", NonWrappingMultilineEntry(), stretchy = true)
        })
    }, stretchy = true)
}

fun makeNumbersPage() = HorizontalBox() {
    padded = true

    append(Group("Numbers") {
        margined = true
        setChild(VerticalBox() {
            padded = true
            val spinbox = Spinbox(min = 0, max = 100)
            val slider = Slider(min = 0, max = 100)
            val pbar = ProgressBar()
            spinbox.action {
                slider.value = value
                pbar.value = value
            }
            slider.action {
                spinbox.value = value
                pbar.value = value
            }
            append(spinbox)
            append(slider)
            append(pbar)
            append(ProgressBar() {
                value = -1
            })
        })
    }, stretchy = true)

    append(Group("Lists") {
        margined = true
        setChild(VerticalBox() {
            padded = true
            append(Combobox() {
                append("Combobox Item 1")
                append("Combobox Item 2")
                append("Combobox Item 3")
            })
            append(EditableCombobox() {
                append("Editable Item 1")
                append("Editable Item 2")
                append("Editable Item 3")
            })
            append(RadioButtons() {
                append("Radio Button 1")
                append("Radio Button 2")
                append("Radio Button 3")
            })
        })
    }, stretchy = true)
}

fun makeDataChoosersPage() = HorizontalBox() {
    padded = true

    append(VerticalBox() {
        padded = true

        append(DatePicker())
        append(TimePicker())
        append(DateTimePicker())

        append(FontButton())
        append(ColorButton())
    })

    append(VerticalSeparator())

    append(VerticalBox() {
        padded = true

        append(Grid() {
            padded = true

            val entry1 = Entry() {
                readOnly = true
            }
            val button1 = Button("Open File") {
                action {
                    entry1.text = OpenFileDialog(mainWindow) ?: "(cancelled)"
                }
            }
            append(button1, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            append(entry1,  1, 0, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

            val entry2 = Entry() {
                readOnly = true
            }
            val button2 = Button("Save File") {
                action {
                    entry2.text = SaveFileDialog(mainWindow) ?: "(cancelled)"
                }
            }
            append(button2, 0, 1, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            append(entry2,  1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

            append(Grid() {
                padded = true
                append(Button("Message Box") {
                    action {
                        uiMsgBox(mainWindow,
                            "This is a normal message box.",
                            "More detailed information can be shown here.")
                    }
                }, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
                append(Button("Error Box") {
                    action {
                        uiMsgBoxError(mainWindow,
                            "This message box describes an error.",
                            "More detailed information can be shown here.")
                    }
                }, 1, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            }, 0, 2, 2, 1, 0, uiAlignCenter, 0, uiAlignStart)
        })
    }, stretchy = true)
}

fun main(args: Array<String>) = application {
    mainWindow = Window(title = "libui Control Gallery", width = 640, height = 480)
    mainWindow.onClose { uiQuit(); true }
    onShouldQuit { mainWindow.destroy(); true }

    val tab = Tab()
    mainWindow.setChild(tab)
    mainWindow.margined = true

    tab.append("Basic Controls", makeBasicControlsPage())
    tab.setMargined(0, true)

    tab.append("Numbers and Lists", makeNumbersPage())
    tab.setMargined(1, true)

    tab.append("Data Choosers", makeDataChoosersPage())
    tab.setMargined(2, true)

    mainWindow.show()
}
