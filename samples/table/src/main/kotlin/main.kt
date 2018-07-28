import libui.ktx.*
import libui.ktx.draw.*

class Data(
    var editable: String,
    var checkbox: Boolean
)

val data = List(15) {
    Data("Part", false)
}

fun main(args: Array<String>) = appWindow(
    title = "Table",
    width = 800,
    height = 480
) {
    vbox {
        tableview(data) {
            stretchy = true

            val image0 = image(width = 16, height = 16) {
                bitmap(`andlabs_16x16test_24june2016.png`)
                bitmap(`andlabs_32x32test_24june2016.png`)
            }
            val image1 = image(width = 16, height = 16) {
                bitmap(`tango-icon-theme-0.8.90_16x16_x-office-spreadsheet.png`)
                bitmap(`tango-icon-theme-0.8.90_32x32_x-office-spreadsheet.png`)
            }
            var yellowRow = -1

            background { row ->
                when (row) {
                    yellowRow -> Color(r = 1.0, g = 1.0, b = 0.0)
                    3 -> Color(r = 1.0, g = 0.0, b = 0.0)
                    11 -> Color(r = 0.0, g = 0.5, b = 1.0, a = 0.5)
                    else -> null
                }
            }
            column("Column 1") {
                label { row -> "Row $row" }
            }
            column("Column 2") {
                image { row -> if (row < 8) image0 else image1 }
                label { "Part" }
                color { row -> if ((row % 2) == 1) Color(r = 0.5, g = 0.0, b = 0.75) else null }
            }
            column("Editable") {
                textfield(Data::editable)
            }
            column("Checkboxes") {
                checkbox(Data::checkbox)
            }
            column("Buttons") {
                button("Make Yellow") { row ->
                    val prevYellowRow = yellowRow
                    yellowRow = row
                    if (prevYellowRow != -1)
                        rowChanged(prevYellowRow)
                    rowChanged(yellowRow)
                }
            }
            column("Progress Bar") {
                progressbar { row ->
                    when (row) {
                        0 -> 0
                        13 -> 100
                        14 -> -1
                        else -> 50
                    }
                }
            }
        }
    }
}
