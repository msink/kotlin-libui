import libui.*

fun Window.basicControlsPage() = VerticalBox() {
    padded = true

    add(widget = HorizontalBox {
        padded = true
        add(widget = Button("Button"))
        add(widget = Checkbox("Checkbox"))
    })
    add(widget = Label("This is a label. Right now, labels can only span one line."))
    add(widget = HorizontalSeparator())
    add(stretchy = true, widget = Group("Entries") {
        add(widget = Form {
            padded = true
            add(label = "Text Entry",
                widget = Entry())
            add(label = "Password Entry",
                widget = PasswordEntry())
            add(label = "Search Entry",
                widget = SearchEntry())
            add(stretchy = true,
                label = "Multiline Entry",
                widget = MultilineEntry())
            add(stretchy = true,
                label = "Multiline Entry No Wrap",
                widget = NonWrappingMultilineEntry())
        })
    })
}

fun Window.numbersPage() = HorizontalBox() {
    padded = true

    add(stretchy = true, widget = Group("Numbers") {
        add(widget = VerticalBox {
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
            add(widget = spinbox)
            add(widget = slider)
            add(widget = pbar)
            add(widget = ProgressBar {
                value = -1
            })
        })
    })

    add(stretchy = true, widget = Group("Lists") {
        add(widget = VerticalBox {
            padded = true
            add(widget = Combobox {
                add("Combobox Item 1")
                add("Combobox Item 2")
                add("Combobox Item 3")
            })
            add(widget = EditableCombobox {
                add("Editable Item 1")
                add("Editable Item 2")
                add("Editable Item 3")
            })
            add(widget = RadioButtons {
                add("Radio Button 1")
                add("Radio Button 2")
                add("Radio Button 3")
            })
        })
    })
}

fun Window.dataChoosersPage() = HorizontalBox() {
    padded = true

    add(widget = VerticalBox {
        padded = true

        add(widget = DatePicker())
        add(widget = TimePicker())
        add(widget = DateTimePicker())

        add(widget = FontButton())
        add(widget = ColorButton())
    })

    add(widget = VerticalSeparator())

    add(stretchy = true, widget = VerticalBox {
        padded = true

        add(widget = Grid {
            padded = true

            val entry1 = Entry() { readOnly = true }
            val button1 = Button("Open File") {
                action {
                    entry1.value = OpenFileDialog() ?: "(cancelled)"
                }
            }
            add(widget = button1, y = 0, x = 0)
            add(widget = entry1, y = 0, x = 1, hexpand = true)

            val entry2 = Entry() { readOnly = true }
            val button2 = Button("Save File") {
                action {
                    entry2.value = SaveFileDialog() ?: "(cancelled)"
                }
            }
            add(widget = button2, y = 1, x = 0)
            add(widget = entry2, y = 1, x = 1, hexpand = true)

            add(y = 2, xspan = 2, widget = Grid {
                padded = true
                add(x = 0, widget = Button("Message Box") {
                    action {
                        MsgBox(text = "This is a normal message box.",
                            details = "More detailed information can be shown here.")
                    }
                })
                add(x = 1, widget = Button("Error Box") {
                    action {
                        MsgBoxError(text = "This message box describes an error.",
                            details = "More detailed information can be shown here.")
                    }
                })
            })
        })
    })
}

fun main(args: Array<String>) = appWindow(
    title = "libui Control Gallery",
    width = 640,
    height = 480
) {
    add(widget = Tab {
        add(label = "Basic Controls",
            widget = basicControlsPage())

        add(label = "Numbers and Lists",
            widget = numbersPage())

        add(label = "Data Choosers",
            widget = dataChoosersPage())
    })
}
