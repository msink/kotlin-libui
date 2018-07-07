package libui

import kotlinx.cinterop.*
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

internal sealed class TableControl

internal class TableString(
    val get: (row: Int) -> String,
    val set: ((row: Int, value: String?) -> Unit)? = null
) : TableControl()

internal class TableInt(
    val get: (row: Int) -> Int,
    val set: ((row: Int, value: Int) -> Unit)? = null
) : TableControl()

internal class TableImage(
    val get: (row: Int) -> Image?
) : TableControl()

internal class TableColor(
    val get: (row: Int) -> Color?
) : TableControl()

///////////////////////////////////////////////////////////////////////////////

fun <T> Table(data: List<T>): Table<T> {
    val handler = nativeHeap.alloc<ktTableHandler>()
    return Table(data, uiNewTableModel(handler.ui.ptr), handler.ptr)
}

class Table<T> internal constructor(
    val data: List<T>,
    alloc: CPointer<uiTableModel>?,
    val handler: CPointer<ktTableHandler>
) : Disposable<uiTableModel>(alloc) {
    internal val ref = StableRef.create(this)
    internal val disposables = mutableListOf<Disposable<*>>()
    internal val controls = mutableListOf<TableControl>()
    internal val columns = mutableListOf<TablePane.() -> Unit>()
    internal var background: Int = -1

    override fun free() {
        disposables.forEach { it.dispose() }
        disposables.clear()
        uiFreeTableModel(ptr)
        nativeHeap.free(handler)
        ref.dispose()
    }

    init {
        handler.pointed.ui.NumColumns = staticCFunction { handler, _ ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                controls.size
            }
        }
        handler.pointed.ui.ColumnType = staticCFunction { handler, _, column ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                controls.getOrNull(column)?.let {
                    when (it) {
                        is TableString -> uiTableValueTypeString
                        is TableInt -> uiTableValueTypeInt
                        is TableImage -> uiTableValueTypeImage
                        is TableColor -> uiTableValueTypeColor
                    }
                } ?: uiTableValueTypeString
            }
        }
        handler.pointed.ui.NumRows = staticCFunction { handler, _ ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                data.size
            }
        }
        handler.pointed.ui.CellValue = staticCFunction { handler, _, row, column ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                controls.getOrNull(column)?.let {
                    when (it) {
                        is TableString -> it.get(row).let { uiNewTableValueString(it) }
                        is TableInt -> it.get(row).let { uiNewTableValueInt(it) }
                        is TableImage -> it.get(row)?.let { uiNewTableValueImage(it.ptr) }
                        is TableColor -> it.get(row)?.let { uiNewTableValueColor(it.r, it.g, it.b, it.a) }
                    }
                }
            }
        }
        handler.pointed.ui.SetCellValue = staticCFunction { handler, _, row, column, value ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                controls.getOrNull(column)?.let {
                    when (it) {
                        is TableString -> it.set?.invoke(row, value?.let { uiTableValueString(it)?.toKString() })
                        is TableInt -> it.set?.invoke(row, uiTableValueInt(value))
                        is TableImage -> {}
                        is TableColor -> {}
                    }
                }
            }
        }
        handler.pointed.ref = ref.asCPointer()
    }

    private fun TableString(
        get: (row: Int) -> String
    ): Int {
        val id = controls.size
        controls += libui.TableString(get, null)
        return id
    }

    private fun TableString(
        get: (row: Int) -> String,
        set: (row: Int, value: String?) -> Unit
    ): Int {
        val id = controls.size
        controls += libui.TableString(get, set)
        return id
    }

    private fun TableInt(
        get: (row: Int) -> Int
    ): Int {
        val id = controls.size
        controls += libui.TableInt(get, null)
        return id
    }

    private fun TableInt(
        get: (row: Int) -> Int,
        set: (row: Int, value: Int) -> Unit
    ): Int {
        val id = controls.size
        controls += libui.TableInt(get, set)
        return id
    }

    private fun TableImage(get: (row: Int) -> Image?): Int {
        val id = controls.size
        controls += libui.TableImage(get)
        return id
    }

    private fun TableColor(get: (row: Int) -> Color?): Int {
        val id = controls.size
        controls += libui.TableColor(get)
        return id
    }

    inner class TableColumn() {
        internal inner class ColumnLabel(val get: (row: Int) -> String)
        internal var label: ColumnLabel? = null
        fun label(get: (row: Int) -> String) {
            label = ColumnLabel(get)
        }
        fun label(property: KProperty1<T, String>) {
            label = ColumnLabel({ row -> property.get(data[row])})
        }

        internal inner class ColumnTextField(
            val get: (row: Int) -> String,
            val set: (row: Int, value: String?) -> Unit)
        internal var textfield: ColumnTextField? = null
        fun textfield(property: KMutableProperty1<T, String>) {
            textfield = ColumnTextField(
                get = { row -> property.get(data[row]) },
                set = { row, value -> property.set(data[row], value!!) })
        }

        internal inner class ColumnCheckbox(
            val get: (row: Int) -> Int,
            val set: (row: Int, value: Int) -> Unit) {
        }
        internal var checkbox: ColumnCheckbox? = null
        fun checkbox(property: KMutableProperty1<T, Boolean>) {
            checkbox = ColumnCheckbox(
                get = { row -> if (property.get(data[row])) 1 else 0 },
                set = { row, value -> property.set(data[row], value != 0) })
        }

        internal inner class ColumnImage(
            val get: (row: Int) -> Image?)
        internal var image: ColumnImage? = null
        fun image(get: (row: Int) -> Image?) {
            image = ColumnImage(get)
        }

        internal inner class ColumnColor(
            val get: (row: Int) -> Color?)
        internal var color: ColumnColor? = null
        fun color(get: (row: Int) -> Color?) {
            color = ColumnColor(get)
        }

        internal inner class ColumnProgressBar(
            val get: (row: Int) -> Int)
        internal var progressbar: ColumnProgressBar? = null
        fun progressbar(get: (row: Int) -> Int) {
            progressbar = ColumnProgressBar(get)
        }

        internal inner class ColumnButton(
            val text: (row: Int) -> String,
            val action: (row: Int) -> Unit)
        internal var button: ColumnButton? = null
        fun button(text: (row: Int) -> String, action: (row: Int) -> Unit) {
            button = ColumnButton(text, action)
        }
        fun button(text: String, action: (row: Int) -> Unit) {
            button = ColumnButton({ text }, action)
        }
    }

    fun column(name: String, init: TableColumn.() -> Unit) {
        val column = TableColumn().apply(init)
        columns += when {
            column.image != null && column.label != null ->
                TableColumnImageText(name,
                    TableImage(column.image!!.get),
                    TableString(column.label!!.get), uiTableModelColumnNeverEditable,
                    column.color?.let { TableColor(it.get) } ?: -1
                )
            column.label != null ->
                TableColumnText(name,
                    TableString(column.label!!.get), uiTableModelColumnNeverEditable)
            column.textfield != null ->
                TableColumnText(name,
                    TableString(column.textfield!!.get, column.textfield!!.set),
                    uiTableModelColumnAlwaysEditable)
            column.checkbox != null ->
                TableColumnCheckbox(name,
                    TableInt(column.checkbox!!.get, column.checkbox!!.set),
                    uiTableModelColumnAlwaysEditable)
            column.progressbar != null ->
                TableColumnProgressBar(name,
                    TableInt(column.progressbar!!.get))
            column.button != null ->
                TableColumnButton(name,
                    TableString(column.button!!.text, { row, _-> column.button!!.action(row) }),
                    uiTableModelColumnAlwaysEditable)
            else -> throw Error()
        }
    }

    fun background(get: (row: Int) -> Color?) {
        background = TableColor(get)
    }

    fun rowInserted(newIndex: Int) = uiTableModelRowInserted(ptr, newIndex)

    fun rowChanged(index: Int) = uiTableModelRowChanged(ptr, index)

    fun rowDeleted(oldIndex: Int) = uiTableModelRowDeleted(ptr, oldIndex)
}

///////////////////////////////////////////////////////////////////////////////

private fun TableColumnText(name: String, textModel: Int, textEdit: Int,
                            colorModel: Int = -1): TablePane.() -> Unit = {
    if (colorModel >= 0) memScoped {
        val params = alloc<uiTableTextColumnOptionalParams>().apply {
            ColorModelColumn = colorModel
        }
        uiTableAppendTextColumn(ptr, name, textModel, textEdit, params.ptr)
    } else {
        uiTableAppendTextColumn(ptr, name, textModel, textEdit, null)
    }
}

private fun TableColumnImage(name: String, imageModel: Int): TablePane.() -> Unit = {
    uiTableAppendImageColumn(ptr, name, imageModel)
}

private fun TableColumnImageText(name: String, imageModel: Int, textModel: Int, textEdit: Int,
                                 colorModel: Int = -1): TablePane.() -> Unit = {
    if (colorModel >= 0) memScoped {
        val params = alloc<uiTableTextColumnOptionalParams>().apply {
            ColorModelColumn = colorModel
        }
        uiTableAppendImageTextColumn(ptr, name, imageModel, textModel, textEdit, params.ptr)
    } else {
        uiTableAppendImageTextColumn(ptr, name, imageModel, textModel, textEdit, null)
    }
}

private fun TableColumnCheckbox(name: String, checkboxModel: Int, checkboxEdit: Int): TablePane.() -> Unit = {
    uiTableAppendCheckboxColumn(ptr, name, checkboxModel, checkboxEdit)
}

private fun TableColumnCheckboxText(name: String, checkboxModel: Int, checkboxEdit: Int,
                                    textModel: Int, textEdit: Int, colorModel: Int = -1): TablePane.() -> Unit = {
    if (colorModel >= 0) memScoped {
        val params = alloc<uiTableTextColumnOptionalParams>().apply {
            ColorModelColumn = colorModel
        }
        uiTableAppendCheckboxTextColumn(ptr, name, checkboxModel, checkboxEdit, textModel, textEdit, params.ptr)
    } else {
        uiTableAppendCheckboxTextColumn(ptr, name, checkboxModel, checkboxEdit, textModel, textEdit, null)
    }
}

private fun TableColumnProgressBar(name: String, progressModel: Int): TablePane.() -> Unit = {
    uiTableAppendProgressBarColumn(ptr, name, progressModel)
}

private fun TableColumnButton(name: String, buttonTextModel: Int, buttonClickable: Int): TablePane.() -> Unit = {
    uiTableAppendButtonColumn(ptr, name, buttonTextModel, buttonClickable)
}

///////////////////////////////////////////////////////////////////////////////

class TablePane(val table: Table<*>) : Control<uiTable>(
    alloc = memScoped {
        val params = alloc<uiTableParams>().apply {
            Model = table.ptr
            RowBackgroundColorModelColumn = table.background
        }
        uiNewTable(params.ptr)}) {
    init {
        table.columns.forEach { it() }
        table.columns.clear()
    }
    override fun free() {
        table.dispose()
        super.free()
    }
}

inline fun <T> Stretchy.table(
    data: List<T>,
    stretchy: Boolean = false,
    init: Table<T>.() -> Unit = {}
) = add(TablePane(Table<T>(data).apply(init)), stretchy)
