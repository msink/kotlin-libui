import libui.ktx.*

fun TabPane.Page.basicControls() = vbox {
    hbox {
        button("Button")
        checkbox("Checkbox")
    }
    label("This is a label. Right now, labels can only span one line.")
    separator()
    group("Entries") { stretchy = true }.form {
        textfield {
            label = "Text Field"
        }
        passwordfield {
            label = "Password Field"
        }
        searchfield {
            label = "Search Field"
        }
        textarea {
            label = "Multiline Field"
            stretchy = true
        }
        textarea(wrap = false) {
            label = "Multiline Field No Wrap"
            stretchy = true
        }
    }
}

fun TabPane.Page.numbers() = hbox {
    group("Numbers") { stretchy = true }.vbox {
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
    group("Lists") { stretchy = true }.vbox {
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

fun TabPane.Page.dataChoosers() = hbox {
    vbox {
        datepicker()
        timepicker()
        datetimepicker()
        fontbutton()
        colorbutton()
    }
    separator()
    stretchy = true
    vbox.gridpane {
        lateinit var file: TextField
        lateinit var folder: TextField
        lateinit var save: TextField

        button("Open File") {
            action {
                file.value = OpenFileDialog() ?: "(cancelled)"
            }
        }
        file = textfield {
            readonly = true
            hexpand = true
        }

        row()
        button("Open Folder") {
            action {
                folder.value = OpenFolderDialog() ?: "(cancelled)"
            }
        }
        folder = textfield {
            readonly = true
            hexpand = true
        }

        row()
        button("Save File") {
            action {
                save.value = SaveFileDialog() ?: "(cancelled)"
            }
        }
        save = textfield {
            readonly = true
            hexpand = true
        }

        row()
        xspan = 2
        halign = libui.uiAlignCenter
        valign = libui.uiAlignStart

        gridpane {
            button("Message Box") {
                action {
                    MsgBox(
                        text = "This is a normal message box.",
                        details = "More detailed information can be shown here."
                    )
                }
            }
            button("Error Box") {
                action {
                    MsgBoxError(
                        text = "This message box describes an error.",
                        details = "More detailed information can be shown here."
                    )
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
