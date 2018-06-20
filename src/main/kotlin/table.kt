package libui

import kotlinx.cinterop.*

typealias Image = CPointer<uiImage>

fun Image(width: Double, height: Double, block: Image.() -> Unit = {}): Image =
    uiNewImage(width, height)?.apply(block) ?: throw Error()

fun Image.dispose() = uiFreeImage(this)

fun Image.add(pixels: CValuesRef<IntVar>, width: Int, height: Int, stride: Int) =
    uiImageAppend(this, pixels, width, height, stride)

///////////////////////////////////////////////////////////////////////////////

typealias TableData = CPointer<uiTableData>

fun TableData.dispose() = uiFreeTableData(this)

val TableData.type: uiTableDataType get() = uiTableDataGetType(this)

fun TableDataString(value: String): TableData = uiNewTableDataString(value) ?: throw Error()

val TableData.string: String get() = uiTableDataString(this)?.toKString() ?: throw Error()

fun TableDataImage(value: Image): TableData = uiNewTableDataImage(value) ?: throw Error()

val TableData.image: Image get() = uiTableDataImage(this) ?: throw Error()

fun TableDataInt(value: Int): TableData = uiNewTableDataInt(value) ?: throw Error()

val TableData.int: Int get() = uiTableDataInt(this)

fun TableDataColor(value: RGBA): TableData =
    uiNewTableDataColor(value.r, value.g, value.b, value.a) ?: throw Error()

val TableData.color: RGBA get() = memScoped {
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiTableDataColor(this@color, r.ptr, g.ptr, b.ptr, a.ptr)
        RGBA(r.value, g.value, b.value, a.value)
    }

///////////////////////////////////////////////////////////////////////////////

class TableModel(block: TableModel.() -> Unit = {}) {
    internal val ptr: CPointer<uiTableModel>
    internal val ref = StableRef.create(this)
    internal val handler = nativeHeap.alloc<ktTableModelHandler>().ptr

    internal var numColumns: TableModel.() -> Int = { 0 }
    internal var columnType: TableModel.(col: Int) -> uiTableDataType = { uiTableDataTypeString }
    internal var numRows: TableModel.() -> Int = { 0 }
    internal var getCellValue: TableModel.(row: Int, col: Int) -> TableData? = { _, _ -> null }
    internal var setCellValue: TableModel.(row: Int, col: Int, value: TableData?) -> Unit = { _, _, _ -> }

    init {
        handler.pointed.ui.NumColumns = staticCFunction(::_NumColumns)
        handler.pointed.ui.ColumnType = staticCFunction(::_ColumnType)
        handler.pointed.ui.NumRows = staticCFunction(::_NumRows)
        handler.pointed.ui.CellValue = staticCFunction(::_CellValue)
        handler.pointed.ui.SetCellValue = staticCFunction(::_SetCellValue)
        handler.pointed.ref = ref.asCPointer()
        ptr = uiNewTableModel(handler.pointed.ui.ptr) ?: throw Error()
        apply(block)
    }

    fun dispose() {
        uiFreeTableModel(ptr)
        nativeHeap.free(handler)
        ref.dispose()
    }
}

fun TableModel.rowInserted(newIndex: Int) = uiTableModelRowInserted(ptr, newIndex)

fun TableModel.rowChanged(index: Int) = uiTableModelRowChanged(ptr, index)

fun TableModel.rowDeleted(oldIndex: Int) = uiTableModelRowDeleted(ptr, oldIndex)

fun TableModel.numColumns(proc: TableModel.() -> Int) {
    numColumns = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _NumColumns(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?
): Int {
    val h: CPointer<ktTableModelHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<TableModel>().get()) {
        return numColumns.invoke(this)
    }
}

fun TableModel.columnType(proc: TableModel.(column: Int) -> uiTableDataType) {
    columnType = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _ColumnType(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    column: Int
): uiTableDataType {
    val h: CPointer<ktTableModelHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<TableModel>().get()) {
        return columnType.invoke(this, column)
    }
}

fun TableModel.numRows(proc: TableModel.() -> Int) {
    numRows = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _NumRows(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?
): Int {
    val h: CPointer<ktTableModelHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<TableModel>().get()) {
        return numRows.invoke(this)
    }
}

fun TableModel.getCellValue(proc: TableModel.(row: Int, column: Int) -> TableData?) {
    getCellValue = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _CellValue(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    row: Int,
    column: Int
): TableData? {
    val h: CPointer<ktTableModelHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<TableModel>().get()) {
        return getCellValue.invoke(this, row, column)
    }
}

fun TableModel.setCellValue(proc: TableModel.(row: Int, column: Int, value: TableData?) -> Unit) {
    setCellValue = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _SetCellValue(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    row: Int,
    column: Int,
    value: TableData?
) {
    val h: CPointer<ktTableModelHandler> = handler!!.reinterpret()
    with (h.pointed.ref!!.asStableRef<TableModel>().get()) {
        setCellValue.invoke(this, row, column, value)
    }
}

///////////////////////////////////////////////////////////////////////////////

class Table(val model: TableModel, block: Table.() -> Unit = {}) : Control(uiNewTable(model.ptr)) {
    internal val ptr: CPointer<uiTable> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
    override fun dispose() {
        model.dispose()
        super.dispose()
    }
}

fun Table.textColumn(
    name: String,
    textModelColumn: Int,
    textEditableModelColumn: Int,
    colorModelColumn: Int = -1
) = memScoped {
    if (colorModelColumn >= 0) {
        val params = alloc<uiTableTextColumnOptionalParams>()
        params.ColorModelColumn = colorModelColumn
        uiTableAppendTextColumn(ptr, name, textModelColumn, textEditableModelColumn, params.ptr)
    } else {
        uiTableAppendTextColumn(ptr, name, textModelColumn, textEditableModelColumn, null)
    }
}

fun Table.imageColumn(
    name: String,
    imageModelColumn: Int
) = uiTableAppendImageColumn(ptr, name, imageModelColumn)

fun Table.imageTextColumn(
    name: String,
    imageModelColumn: Int,
    textModelColumn: Int,
    textEditableModelColumn: Int,
    colorModelColumn: Int = -1
) = memScoped {
    if (colorModelColumn >= 0) {
        val params = alloc<uiTableTextColumnOptionalParams>()
        params.ColorModelColumn = colorModelColumn
        uiTableAppendImageTextColumn(ptr, name,
            imageModelColumn, textModelColumn, textEditableModelColumn, params.ptr)
    } else {
        uiTableAppendImageTextColumn(ptr, name,
            imageModelColumn, textModelColumn, textEditableModelColumn, null)
    }
}

fun Table.checkboxColumn(
    name: String,
    checkboxModelColumn: Int,
    checkboxEditableModelColumn: Int
) = uiTableAppendCheckboxColumn(ptr, name, checkboxModelColumn, checkboxEditableModelColumn)

fun Table.checkboxTextColumn(
    name: String,
    checkboxModelColumn: Int,
    checkboxEditableModelColumn: Int,
    textModelColumn: Int,
    textEditableModelColumn: Int,
    colorModelColumn: Int = -1
) = memScoped {
    if (colorModelColumn >= 0) {
        val params = alloc<uiTableTextColumnOptionalParams>()
        params.ColorModelColumn = colorModelColumn
        uiTableAppendCheckboxTextColumn(ptr, name,
            checkboxModelColumn, checkboxEditableModelColumn,
            textModelColumn, textEditableModelColumn, params.ptr)
    } else {
        uiTableAppendCheckboxTextColumn(ptr, name,
            checkboxModelColumn, checkboxEditableModelColumn,
            textModelColumn, textEditableModelColumn, null)
    }
}

fun Table.progressBarColumn(
    name: String,
    progressModelColumn: Int
) = uiTableAppendProgressBarColumn(ptr, name, progressModelColumn)

fun Table.buttonColumn(
    name: String,
    buttonTextModelColumn: Int,
    buttonClickableModelColumn: Int
) = uiTableAppendButtonColumn(ptr, name, buttonTextModelColumn, buttonClickableModelColumn)

fun Table.setRowBackgroundColorModelColumn(modelColumn: Int) =
    uiTableSetRowBackgroundColorModelColumn(ptr, modelColumn)
