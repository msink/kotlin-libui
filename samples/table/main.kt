import libui.*

fun main(args: Array<String>) = libuiApplication {
    Window(
        title = "Hello",
        width = 320,
        height = 240,
        hasMenubar = false) {
        margined = true

        var row9text = "Part"
        var yellowRow = -1
        var checkStates = IntArray(15)

        val image0 = Image(16, 16) {
            add("andlabs_16x16test_24june2016.png")
            add("andlabs_32x32test_24june2016.png")
        }

        val image1 = Image(16, 16) {
            add("tango-icon-theme-0.8.90_16x16_x-office-spreadsheet.png")
            add("tango-icon-theme-0.8.90_32x32_x-office-spreadsheet.png")
        }

        val model = TableModel {
            numColumns = { 9 }
            columnType = { return when (it) {
                3, 4 -> uiTableDataTypeColor
                5    -> uiTableDataTypeImage
                7, 8 -> uiTableDataTypeInt
                else -> uiTableDataTypeString
            }}
            numRows = { 15 }
            cellValue = { row, col -> return when (col) {
                0 -> TableDataString("Row $row")
                1 -> TableDataString("Part")
                2 -> TableDataString(if (row == 9) row9text else "Part")
                3 -> when (row) {
                         yellowRow -> TableDataColor(RGBA(1.0, 1.0, 0.0))
                         3         -> TableDataColor(RGBA(1.0, 0.0, 0.0))
                         11        -> TableDataColor(RGBA(0.0, 0.5, 1.0, 0.5))
                         else      -> null
                     }
                4 -> ((row % 2) == 1) TableDataColor(RGBA(0.5, 0.0, 0.75)) else null
                5 -> if (row < 8) TableDataImage(image0) else TableDataImage(image1)
                6 -> TableDataString("Make Yellow")
                7 -> TableDataInt(checkStates[row])
                8 -> when (row) {
                     0    -> TableDataInt(0)
                     13   -> TableDataInt(100)
                     14   -> TableDataInt(-1)
                     else -> TableDataInt(50)
                }
            }}
            setCellValue = { row, col, value -> when (col) {
                2 -> if (row == 9) row9text = value.string
                6 -> {
                    val prevYellowRow = yellowRow
                    yellowRow = row
                    if (prevYellowRow != -1)
                        rowChanged(prevYellowRow)
                    rowChanged(yellowRow)
                }
                7 -> checkStates[row] = value.int
            }}
        }

        add(VerticalBox {
            padded = true
            append(Table(model, {
                textColumn("Column 1", 0, uiTableModelColumnNeverEditable)
                imageTextColumn(t, "Column 2", 5, 1, uiTableModelColumnNeverEditable, 4)
                textColumn(t, "Editable", 2, uiTableModelColumnAlwaysEditable)
                setRowBackgroundColorModelColumn(3)
                checkboxColumn(t, "Checkboxes", 7, uiTableModelColumnAlwaysEditable)
                buttonColumn(t, "Buttons", 6, uiTableModelColumnAlwaysEditable)
                progressBarColumn(t, "Progress Bar", 8)
            }), stretchy = true)
        })

        onClose { uiQuit() true }
        show()
    }
}
