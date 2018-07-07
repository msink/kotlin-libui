package libui

import kotlinx.cinterop.*
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

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

class Table<T>(val data: List<T>) {
    internal val ptr: CPointer<uiTableModel>
    internal val ref = StableRef.create(this)
    internal val handler = nativeHeap.alloc<ktTableHandler>().ptr
    internal val disposable = mutableListOf<Disposable<*>>()
    internal val controls = mutableListOf<TableControl>()
    internal val columns = mutableListOf<TablePane.() -> Unit>()
    internal var background: Int = -1

    fun free() {
        disposable.forEach { it.dispose() }
        disposable.clear()
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
                if (column >= 0 && column < controls.size) controls[column].let {
                    when (it) {
                        is TableString -> uiTableValueTypeString
                        is TableInt -> uiTableValueTypeInt
                        is TableImage -> uiTableValueTypeImage
                        is TableColor -> uiTableValueTypeColor
                    }
                } else uiTableValueTypeString
            }
        }

        handler.pointed.ui.NumRows = staticCFunction { handler, _ ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                data.size
            }
        }

        handler.pointed.ui.CellValue = staticCFunction { handler, _, row, column ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                if (column >= 0 && column < controls.size) controls[column].let {
                    when (it) {
                        is TableString -> it.get(row).let { TableValueString(it) }
                        is TableInt -> it.get(row).let { TableValueInt(it) }
                        is TableImage -> it.get(row)?.let { TableValueImage(it) }
                        is TableColor -> it.get(row)?.let { TableValueColor(it) }
                    }
                } else null
            }
        }

        handler.pointed.ui.SetCellValue = staticCFunction { handler, _, row, column, value ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                if (column >= 0 && column < controls.size) controls[column].let {
                    when (it) {
                        is TableString -> it.set?.invoke(row, value?.string)
                        is TableInt -> it.set?.invoke(row, value?.int ?: 0)
                        else -> {}
                    }
                }
            }
        }

        handler.pointed.ref = ref.asCPointer()
        ptr = uiNewTableModel(handler.pointed.ui.ptr) ?: throw Error()
    }

    internal fun TableString(
        get: (row: Int) -> String
    ): Int {
        val id = controls.size
        controls += libui.TableString(get, null)
        return id
    }

    internal fun TableString(
        get: (row: Int) -> String,
        set: (row: Int, value: String?) -> Unit
    ): Int {
        val id = controls.size
        controls += libui.TableString(get, set)
        return id
    }

    internal fun TableInt(
        get: (row: Int) -> Int
    ): Int {
        val id = controls.size
        controls += libui.TableInt(get, null)
        return id
    }

    internal fun TableInt(
        get: (row: Int) -> Int,
        set: (row: Int, value: Int) -> Unit
    ): Int {
        val id = controls.size
        controls += libui.TableInt(get, set)
        return id
    }

    internal fun TableImage(get: (row: Int) -> Image?): Int {
        val id = controls.size
        controls += libui.TableImage(get)
        return id
    }

    internal fun TableColor(get: (row: Int) -> Color?): Int {
        val id = controls.size
        controls += libui.TableColor(get)
        return id
    }

    fun textColumn(name: String, get: (row: Int) -> String) {
        columns += TableColumnText(name,
            TableString(get), uiTableModelColumnNeverEditable)
    }

    fun textColumn(name: String, property: KProperty1<T, String>) {
        columns += TableColumnText(name,
            TableString({ row -> property.get(data[row])}), uiTableModelColumnNeverEditable)
    }

    fun textColumn(name: String, property: KMutableProperty1<T, String>) {
        columns += TableColumnText(name, TableString(
            get = { row -> property.get(data[row]) },
            set = { row, value -> property.set(data[row], value!!) }),
            uiTableModelColumnAlwaysEditable)
    }

    fun imageTextColumn(name: String, image: (row: Int) -> Image?, text: (row: Int) -> String, color: (row: Int) -> Color?) {
        columns += TableColumnImageText(name,
            TableImage(image),
            TableString(text), uiTableModelColumnNeverEditable,
            TableColor(color))
    }

    fun checkboxColumn(name: String, property: KMutableProperty1<T, Boolean>) {
        columns += TableColumnCheckbox(name, TableInt(
            get = { row -> if (property.get(data[row])) 1 else 0 },
            set = { row, value -> property.set(data[row], (value != 0)) }),
            uiTableModelColumnAlwaysEditable)
    }

    fun progressBarColumn(name: String, get: (row: Int) -> Int) {
        columns += TableColumnProgressBar(name,
            TableInt(get))
    }

    fun buttonColumn(name: String, text: String, set: (row: Int, value: String?) -> Unit) {
        columns += TableColumnButton(name,
            TableString({ text }, set), uiTableModelColumnAlwaysEditable)
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
    override fun free() {
        table.free()
        super.free()
    }
    init {
        table.columns.forEach { it() }
        table.columns.clear()
    }
}

inline fun <T> Stretchy.table(
    data: List<T>,
    stretchy: Boolean = false,
    init: Table<T>.() -> Unit = {}
) = add(TablePane(Table<T>(data).apply(init)), stretchy)
