import libui.*
import kotlinx.cinterop.toKString

//TODO: make it singleton or part of Application singleton
lateinit var mainWindow: Window

fun makeBasicControlsPage() : Box {

    val vbox = VerticalBox()
    vbox.padded = true

    val hbox = HorizontalBox()
    hbox.padded = true
    vbox.append(hbox)

    hbox.append(Button("Button"))
    hbox.append(Checkbox("Checkbox"))
    vbox.append(Label("This is a label. Right now, labels can only span one line."))
    vbox.append(HorizontalSeparator())

    val group = Group("Entries")
    group.margined = true
    vbox.append(group, stretchy = true)

    val entryForm = Form()
    entryForm.padded = true
    group.setChild(entryForm)

    entryForm.append("Entry", Entry())
    entryForm.append("Password Entry", PasswordEntry())
    entryForm.append("Search Entry", SearchEntry())
    entryForm.append("Multiline Entry", MultilineEntry(), stretchy = true)
    entryForm.append("Multiline Entry No Wrap", NonWrappingMultilineEntry(), stretchy = true)

    return vbox
}

fun makeNumbersPage() : Box {

    val hbox = HorizontalBox()
    hbox.padded = true

    val group1 = Group("Numbers")
    group1.margined = true
    hbox.append(group1, stretchy = true)

    val vbox1 = VerticalBox()
    vbox1.padded = true
    group1.setChild(vbox1)

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
    vbox1.append(spinbox)
    vbox1.append(slider)
    vbox1.append(pbar)

    val ip = ProgressBar()
    ip.value = -1
    vbox1.append(ip)

    val group2 = Group("Lists")
    group2.margined = true
    hbox.append(group2, stretchy = true)

    val vbox2 = VerticalBox()
    vbox2.padded = true
    group2.setChild(vbox2)

    val cbox = Combobox()
    cbox.append("Combobox Item 1")
    cbox.append("Combobox Item 2")
    cbox.append("Combobox Item 3")
    vbox2.append(cbox)

    val ecbox = EditableCombobox()
    ecbox.append("Editable Item 1")
    ecbox.append("Editable Item 2")
    ecbox.append("Editable Item 3")
    vbox2.append(ecbox)

    val rb = RadioButtons()
    rb.append("Radio Button 1")
    rb.append("Radio Button 2")
    rb.append("Radio Button 3")
    vbox2.append(rb)

    return hbox
}

fun makeDataChoosersPage() : Box {

    val hbox = HorizontalBox()
    hbox.padded = true

    val vbox1 = VerticalBox()
    vbox1.padded = true
    hbox.append(vbox1)

    vbox1.append(DatePicker())
    vbox1.append(TimePicker())
    vbox1.append(DateTimePicker())

    vbox1.append(FontButton())
    vbox1.append(ColorButton())

    hbox.append(VerticalSeparator())

    val vbox2 = VerticalBox()
    vbox2.padded = true
    hbox.append(vbox2, stretchy = true)

    val grid = Grid()
    grid.padded = true
    vbox2.append(grid)

    val button1 = Button("Open File")
    val entry1 = Entry()
    entry1.readOnly = true
    button1.action {
        val filename = uiOpenFile(mainWindow)
        if (filename == null) {
            entry1.text = "(cancelled)"
        } else {
            entry1.text = filename.toKString()
            uiFreeText(filename)
        }
    }

    grid.append(button1, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
    grid.append(entry1,  1, 0, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

    val button2 = Button("Save File")
    val entry2 = Entry()
    entry2.readOnly = true
    button2.action {
        val filename = uiSaveFile(mainWindow)
        if (filename == null) {
            entry2.text = "(cancelled)"
        } else {
            entry2.text = filename.toKString()
            uiFreeText(filename)
        }
    }

    grid.append(button2, 0, 1, 1, 1, 0, uiAlignFill, 0, uiAlignFill)
    grid.append(entry2,  1, 1, 1, 1, 1, uiAlignFill, 0, uiAlignFill)

    val msggrid = Grid()
    msggrid.padded = true
    grid.append(msggrid, 0, 2, 2, 1, 0, uiAlignCenter, 0, uiAlignStart)

    val button3 = Button("Message Box")
    button3.action {
        uiMsgBox(mainWindow,
            "This is a normal message box.",
            "More detailed information can be shown here.")
    }
    msggrid.append(button3, 0, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)

    val button4 = Button("Error Box")
    button4.action {
        uiMsgBoxError(mainWindow,
            "This message box describes an error.",
            "More detailed information can be shown here.")
    }
    msggrid.append(button4, 1, 0, 1, 1, 0, uiAlignFill, 0, uiAlignFill)

    return hbox
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
