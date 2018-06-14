import libui.*

fun Window.basicControlsPage() = VerticalBox() {
    padded = true

    add(HorizontalBox {
        padded = true
        add(Button("Button"))
        add(Checkbox("Checkbox"))
    })
    add(Label("This is a label. Right now, labels can only span one line."))
    add(HorizontalSeparator())
    add(Group("Entries") {
        margined = true
        add(Form {
            padded = true
            add("Text Entry", TextEntry())
            add("Password Entry", PasswordEntry())
            add("Search Entry", SearchEntry())
            add("Multiline Entry", WrappingMultilineEntry(), stretchy = true)
            add("Multiline Entry No Wrap", NonWrappingMultilineEntry(), stretchy = true)
        })
    }, stretchy = true)
}

fun Window.numbersPage() = HorizontalBox() {
    padded = true

    add(Group("Numbers") {
        margined = true
        add(VerticalBox {
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
            add(spinbox)
            add(slider)
            add(pbar)
            add(ProgressBar {
                value = -1
            })
        })
    }, stretchy = true)

    add(Group("Lists") {
        margined = true
        add(VerticalBox {
            padded = true
            add(Combobox {
                add("Combobox Item 1")
                add("Combobox Item 2")
                add("Combobox Item 3")
            })
            add(EditableCombobox {
                add("Editable Item 1")
                add("Editable Item 2")
                add("Editable Item 3")
            })
            add(RadioButtons {
                add("Radio Button 1")
                add("Radio Button 2")
                add("Radio Button 3")
            })
        })
    }, stretchy = true)
}

fun Window.dataChoosersPage() = HorizontalBox() {
    padded = true

    add(VerticalBox {
        padded = true

        add(DatePicker())
        add(TimePicker())
        add(DateTimePicker())

        add(FontButton())
        add(ColorButton())
    })

    add(VerticalSeparator())

    add(VerticalBox {
        padded = true

        add(Grid {
            padded = true

            val entry1 = TextEntry() {
                readOnly = true
            }
            val button1 = Button("Open File") {
                action {
                    entry1.value = OpenFileDialog() ?: "(cancelled)"
                }
            }
            add(button1, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            add(entry1,  1, 0, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

            val entry2 = TextEntry() {
                readOnly = true
            }
            val button2 = Button("Save File") {
                action {
                    entry2.value = SaveFileDialog() ?: "(cancelled)"
                }
            }
            add(button2, 0, 1, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            add(entry2,  1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

            add(Grid {
                padded = true
                add(Button("Message Box") {
                    action {
                        MsgBox(text = "This is a normal message box.",
                            details = "More detailed information can be shown here.")
                    }
                }, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
                add(Button("Error Box") {
                    action {
                        MsgBoxError(text = "This message box describes an error.",
                            details = "More detailed information can be shown here.")
                    }
                }, 1, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
            }, 0, 2, 2, 1, 0, uiAlignCenter, 0, uiAlignStart)
        })
    }, stretchy = true)
}

fun main(args: Array<String>) = application {
    Window(title = "libui Control Gallery", width = 640, height = 480) {
        onClose { uiQuit(); true }
        onShouldQuit { destroy(); true }
        margined = true

        add(Tab {
            add("Basic Controls", basicControlsPage())
            setMargined(0, true)

            add("Numbers and Lists", numbersPage())
            setMargined(1, true)

            add("Data Choosers", dataChoosersPage())
            setMargined(2, true)
        })

        show()
    }
}
