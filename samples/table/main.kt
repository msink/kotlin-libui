import libui.*

fun main(args: Array<String>) = appWindow(
    title = "Table",
    width = 800,
    height = 480
) {
    val model = TableModel {
        var row9text = "Part"
        var yellowRow = -1
        var checkStates = IntArray(15)
        val image0 = Image(16.0, 16.0) {
            add(image0_16x16, 16, 16, 64)
            add(image0_32x32, 32, 32, 128)
        }
        val image1 = Image(16.0, 16.0) {
            add(image1_16x16, 16, 16, 64)
            add(image1_32x32, 32, 32, 128)
        }

        numColumns { 9 }
        columnType { when (it) {
            3, 4 -> uiTableDataTypeColor
            5    -> uiTableDataTypeImage
            7, 8 -> uiTableDataTypeInt
            else -> uiTableDataTypeString
        }}
        numRows { 15 }
        getCellValue { row, col -> when (col) {
            0 -> TableDataString("Row $row")
            1 -> TableDataString("Part")
            2 -> TableDataString(if (row == 9) row9text else "Part")
            3 -> when (row) {
                     yellowRow -> TableDataColor(RGBA(1.0, 1.0, 0.0))
                     3         -> TableDataColor(RGBA(1.0, 0.0, 0.0))
                     11        -> TableDataColor(RGBA(0.0, 0.5, 1.0, 0.5))
                     else      -> null
                 }
            4 -> if ((row % 2) == 1) TableDataColor(RGBA(0.5, 0.0, 0.75)) else null
            5 -> if (row < 8) TableDataImage(image0) else TableDataImage(image1)
            6 -> TableDataString("Make Yellow")
            7 -> TableDataInt(checkStates[row])
            8 -> when (row) {
                 0    -> TableDataInt(0)
                 13   -> TableDataInt(100)
                 14   -> TableDataInt(-1)
                 else -> TableDataInt(50)
            }
            else -> null
        }}
        setCellValue { row, col, value -> when (col) {
            2 -> if (row == 9) row9text = value!!.string
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
        add(stretchy = true, widget = Table(model, {
            textColumn("Column 1", 0, uiTableModelColumnNeverEditable)
            imageTextColumn("Column 2", 5, 1, uiTableModelColumnNeverEditable, 4)
            textColumn("Editable", 2, uiTableModelColumnAlwaysEditable)
            setRowBackgroundColorModelColumn(3)
            checkboxColumn("Checkboxes", 7, uiTableModelColumnAlwaysEditable)
            buttonColumn("Buttons", 6, uiTableModelColumnAlwaysEditable)
            progressBarColumn("Progress Bar", 8)
        }))
    })
}
