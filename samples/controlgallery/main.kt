import libui.*

fun TabPane.Page.basicControls() = vbox {
    hbox {
        button("Button")
        checkbox("Checkbox")
    }
    label("This is a label. Right now, labels can only span one line.")
    separator()
    stretchy {
        group("Entries") {
            form {
                field("Text Field") { textfield() }
                field("Password Field") { passwordfield() }
                field("Search Field") { searchfield() }
                field("Multiline Field") { stretchy { textarea() }}
                field("Multiline Field No Wrap") { stretchy { textarea(wrap = false) }}
            }
        }
    }
}

fun TabPane.Page.numbers() = hbox {
    stretchy {
        group("Numbers") {
            vbox {
                val spinbox = spinbox(min = 0, max = 100)
                val slider = slider(min = 0, max = 100)
                val pbar = progressbar()
                spinbox.action {
                    slider.value = value
                    pbar.value = value
                }
                slider.action {
                    spinbox.value = value
                    pbar.value = value
                }
                progressbar { value = -1 }
            }
        }
    }
    stretchy {
        group("Lists") {
            vbox {
                combobox {
                    item("Combobox Item 1")
                    item("Combobox Item 2")
                    item("Combobox Item 3")
                }
                editablecombobox {
                    item("Editable Item 1")
                    item("Editable Item 2")
                    item("Editable Item 3")
                }
                radiobuttons {
                    item("Radio Button 1")
                    item("Radio Button 2")
                    item("Radio Button 3")
                }
            }
        }
    }
}

fun TabPane.Page.dataChoosers() = hbox {
    vbox {
        datepicker()
        timepicker()
        datetimepicker()
        fontbutton()
        colorbutton()
    }
    separator()
    stretchy {
        vbox {
            gridpane {
                lateinit var entry1: TextField
                lateinit var entry2: TextField

                cell(y = 0, x = 0) {
                    button("Open File") {
                        action {
                            entry1.value = OpenFileDialog() ?: "(cancelled)"
                        }
                    }
                }
                cell(y = 0, x = 1, hexpand = true) {
                    entry1 = textfield(readonly = true)
                }

                cell(y = 1, x = 0) {
                    button("Save File") {
                        action {
                            entry2.value = SaveFileDialog() ?: "(cancelled)"
                        }
                    }
                }
                cell(y = 1, x = 1, hexpand = true) {
                    entry2 = textfield(readonly = true)
                }

                cell(y = 2, xspan = 2) {
                    gridpane {
                        cell(x = 0) {
                            button("Message Box") {
                                action {
                                    MsgBox(text = "This is a normal message box.",
                                        details = "More detailed information can be shown here.")
                                }
                            }
                        }
                        cell(x = 1) {
                            button("Error Box") {
                                action {
                                    MsgBoxError(text = "This message box describes an error.",
                                        details = "More detailed information can be shown here.")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) = appWindow(
    title = "libui Control Gallery",
    width = 640,
    height = 480
) {
    tabpane {
        page("Basic Controls") {
            basicControls()
        }
        page("Numbers and Lists") {
            numbers()
        }
        page("Data Choosers") {
            dataChoosers()
        }
    }
}
