import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Table",
    width = 800,
    height = 480
) {
    val model = TableModel {
        var yellowRow = -1
        var col2text = Array<String>(15) { "Part" }
        var checkStates = IntArray(15)
        val image0 = Image(16.0, 16.0) {
            add(`andlabs_16x16test_24june2016.png`, 16, 16, 64)
            add(`andlabs_32x32test_24june2016.png`, 32, 32, 128)
        }
        val image1 = Image(16.0, 16.0) {
            add(`tango-icon-theme-0.8.90_16x16_x-office-spreadsheet.png`, 16, 16, 64)
            add(`tango-icon-theme-0.8.90_32x32_x-office-spreadsheet.png`, 32, 32, 128)
        }

        numColumns { 9 }
        columnType { when (it) {
            3, 4 -> uiTableValueTypeColor
            5    -> uiTableValueTypeImage
            7, 8 -> uiTableValueTypeInt
            else -> uiTableValueTypeString
        }}
        numRows { 15 }
        getCellValue { row, col -> when (col) {
            0 -> TableValueString("Row $row")
            1 -> TableValueString("Part")
            2 -> TableValueString(col2text[row])
            3 -> when (row) {
                     yellowRow -> TableValueColor(Color(r=1.0, g=1.0, b=0.0))
                     3         -> TableValueColor(Color(r=1.0, g=0.0, b=0.0))
                     11        -> TableValueColor(Color(r=0.0, g=0.5, b=1.0, a=0.5))
                     else      -> null
                 }
            4 -> if ((row % 2) == 1) TableValueColor(Color(r=0.5, g=0.0, b=0.75)) else null
            5 -> if (row < 8) TableValueImage(image0) else TableValueImage(image1)
            6 -> TableValueString("Make Yellow")
            7 -> TableValueInt(checkStates[row])
            8 -> when (row) {
                 0    -> TableValueInt(0)
                 13   -> TableValueInt(100)
                 14   -> TableValueInt(-1)
                 else -> TableValueInt(50)
            }
            else -> null
        }}
        setCellValue { row, col, value -> when (col) {
            2 -> col2text[row] = value!!.string
            6 -> {
                val prevYellowRow = yellowRow
                yellowRow = row
                if (prevYellowRow != -1)
                    rowChanged(prevYellowRow)
                rowChanged(yellowRow)
            }
            7 -> checkStates[row] = value!!.int
        }}
    }

    add(widget = VerticalBox {
        padded = true
        add(stretchy = true, widget = Table(model, 3, {
            textColumn("Column 1", 0, uiTableModelColumnNeverEditable)
            imageTextColumn("Column 2", 5, 1, uiTableModelColumnNeverEditable, 4)
            textColumn("Editable", 2, uiTableModelColumnAlwaysEditable)
            checkboxColumn("Checkboxes", 7, uiTableModelColumnAlwaysEditable)
            buttonColumn("Buttons", 6, uiTableModelColumnAlwaysEditable)
            progressBarColumn("Progress Bar", 8)
        }))
    })
}
