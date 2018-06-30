import libui.*

fun Window.basicControlsPage() = VerticalBox().apply {
    padded = true
    hbox {
        padded = true
        button("Button")
        checkbox("Checkbox")
    }
    label("This is a label. Right now, labels can only span one line.")
    separator()
    group("Entries", stretchy = true) {
        form {
            padded = true
            textfield("Text Field")
            passwordfield("Password Field")
            searchfield("Search Field")
            multilinefield("Multiline Field", stretchy = true)
            nowrapmultilinefield("Multiline Field No Wrap", stretchy = true)
        }
    }
}

fun Window.numbersPage() = HorizontalBox().apply {
    padded = true
    group("Numbers", stretchy = true) {
        vbox {
            padded = true
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
    group("Lists", stretchy = true) {
        vbox {
            padded = true
            combobox {
                add("Combobox Item 1")
                add("Combobox Item 2")
                add("Combobox Item 3")
            }
            editablecombobox {
                add("Editable Item 1")
                add("Editable Item 2")
                add("Editable Item 3")
            }
            radiobuttons {
                add("Radio Button 1")
                add("Radio Button 2")
                add("Radio Button 3")
            }
        }
    }
}

fun Window.dataChoosersPage() = HorizontalBox().apply {
    padded = true
    vbox {
        padded = true
        datepicker()
        timepicker()
        datetimepicker()
        fontbutton()
        colorbutton()
    }
    separator()
    vbox(stretchy = true) {
        padded = true
        add(widget = Grid().apply {
            padded = true

            val entry1 = TextField().apply { readonly = true }
            val button1 = Button("Open File").apply {
                action {
                    entry1.value = OpenFileDialog() ?: "(cancelled)"
                }
            }
            add(widget = button1, y = 0, x = 0)
            add(widget = entry1, y = 0, x = 1, hexpand = true)

            val entry2 = TextField().apply { readonly = true }
            val button2 = Button("Save File").apply {
                action {
                    entry2.value = SaveFileDialog() ?: "(cancelled)"
                }
            }
            add(widget = button2, y = 1, x = 0)
            add(widget = entry2, y = 1, x = 1, hexpand = true)

            add(y = 2, xspan = 2, widget = Grid().apply {
                padded = true
                add(x = 0, widget = Button("Message Box").apply {
                    action {
                        MsgBox(text = "This is a normal message box.",
                            details = "More detailed information can be shown here.")
                    }
                })
                add(x = 1, widget = Button("Error Box").apply {
                    action {
                        MsgBoxError(text = "This message box describes an error.",
                            details = "More detailed information can be shown here.")
                    }
                })
            })
        })
    }
}

fun main(args: Array<String>) = appWindow(
    title = "libui Control Gallery",
    width = 640,
    height = 480
) {
    add(widget = Tab().apply {
        add(label = "Basic Controls",
            widget = basicControlsPage())

        add(label = "Numbers and Lists",
            widget = numbersPage())

        add(label = "Data Choosers",
            widget = dataChoosersPage())
    })
}
