package libui

import kotlinx.cinterop.*

typealias TableValue = CPointer<uiTableValue>

fun TableValue.dispose() = uiFreeTableValue(this)

val TableValue.type: uiTableValueType get() = uiTableValueGetType(this)

fun TableValueString(value: String): TableValue = uiNewTableValueString(value) ?: throw Error()

val TableValue.string: String get() = uiTableValueString(this)?.toKString() ?: throw Error()

fun TableValueImage(value: Image): TableValue = uiNewTableValueImage(value.ptr) ?: throw Error()

//TODO val TableValue.image: Image get() = uiTableValueImage(this) ?: throw Error()

fun TableValueInt(value: Int): TableValue = uiNewTableValueInt(value) ?: throw Error()

val TableValue.int: Int get() = uiTableValueInt(this)

fun TableValueColor(value: Color): TableValue =
    uiNewTableValueColor(value.r, value.g, value.b, value.a) ?: throw Error()

val TableValue.color: Color get() = memScoped {
        val r = alloc<DoubleVar>()
        val g = alloc<DoubleVar>()
        val b = alloc<DoubleVar>()
        val a = alloc<DoubleVar>()
        uiTableValueColor(this@color, r.ptr, g.ptr, b.ptr, a.ptr)
        Color(r.value, g.value, b.value, a.value)
    }

///////////////////////////////////////////////////////////////////////////////

class TableModel(block: TableModel.() -> Unit = {}) {
    internal val ptr: CPointer<uiTableModel>
    internal val ref = StableRef.create(this)
    internal val handler = nativeHeap.alloc<ktTableModelHandler>().ptr

    internal var numColumns: TableModel.() -> Int = { 0 }
    internal var columnType: TableModel.(col: Int) -> uiTableValueType = { uiTableValueTypeString }
    internal var numRows: TableModel.() -> Int = { 0 }
    internal var getCellValue: TableModel.(row: Int, col: Int) -> TableValue? = { _, _ -> null }
    internal var setCellValue: TableModel.(row: Int, col: Int, value: TableValue?) -> Unit = { _, _, _ -> }

    internal val disposables = mutableListOf<Disposable<*>>()

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

    fun free() {
        disposables.forEach { it.dispose() }
        disposables.clear()
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

fun TableModel.columnType(proc: TableModel.(column: Int) -> uiTableValueType) {
    columnType = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _ColumnType(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    column: Int
): uiTableValueType {
    with (handler!!.reinterpret<ktTableModelHandler>().pointed.ref!!.asStableRef<TableModel>().get()) {
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
    with (handler!!.reinterpret<ktTableModelHandler>().pointed.ref!!.asStableRef<TableModel>().get()) {
        return numRows.invoke(this)
    }
}

fun TableModel.getCellValue(proc: TableModel.(row: Int, column: Int) -> TableValue?) {
    getCellValue = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _CellValue(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    row: Int,
    column: Int
): TableValue? {
    with (handler!!.reinterpret<ktTableModelHandler>().pointed.ref!!.asStableRef<TableModel>().get()) {
        return getCellValue.invoke(this, row, column)
    }
}

fun TableModel.setCellValue(proc: TableModel.(row: Int, column: Int, value: TableValue?) -> Unit) {
    setCellValue = proc
}

@Suppress("UNUSED_PARAMETER")
private fun _SetCellValue(
    handler: CPointer<uiTableModelHandler>?,
    model: CPointer<uiTableModel>?,
    row: Int,
    column: Int,
    value: TableValue?
) {
    with (handler!!.reinterpret<ktTableModelHandler>().pointed.ref!!.asStableRef<TableModel>().get()) {
        setCellValue.invoke(this, row, column, value)
    }
}

///////////////////////////////////////////////////////////////////////////////

class Table(val model: TableModel, val bgModel: Int, block: Table.() -> Unit = {}) : Control<uiTable>(
    alloc = memScoped {
        val params = alloc<uiTableParams>().apply {
            Model = model.ptr
            RowBackgroundColorModelColumn = bgModel
        }
        uiNewTable(params.ptr)}) {
    init { apply(block) }
    override fun free() {
        model.free()
        super.free()
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
