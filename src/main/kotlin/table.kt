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

internal sealed class Value

internal class StringValue(
    val get: (row: Int) -> String,
    val set: ((row: Int, value: String?) -> Unit)? = null
) : Value()

internal class IntValue(
    val get: (row: Int) -> Int,
    val set: ((row: Int, value: Int) -> Unit)? = null
) : Value()

internal class ImageValue(
    val get: (row: Int) -> Image?
) : Value()

internal class ColorValue(
    val get: (row: Int) -> Color?
) : Value()

///////////////////////////////////////////////////////////////////////////////

class Table<T>(val data: List<T>) {
    internal val ptr: CPointer<uiTableModel>
    internal val ref = StableRef.create(this)
    internal val handler = nativeHeap.alloc<ktTableHandler>().ptr
    internal val disposable = mutableListOf<Disposable<*>>()
    internal val values = mutableListOf<Value>()
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
                values.size
            }
        }

        handler.pointed.ui.ColumnType = staticCFunction { handler, _, column ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                if (column >= 0 && column < values.size) values[column].let {
                    when (it) {
                        is StringValue -> uiTableValueTypeString
                        is IntValue -> uiTableValueTypeInt
                        is ImageValue -> uiTableValueTypeImage
                        is ColorValue -> uiTableValueTypeColor
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
                if (column >= 0 && column < values.size) values[column].let {
                    when (it) {
                        is StringValue -> it.get(row).let { TableValueString(it) }
                        is IntValue -> it.get(row).let { TableValueInt(it) }
                        is ImageValue -> it.get(row)?.let { TableValueImage(it) }
                        is ColorValue -> it.get(row)?.let { TableValueColor(it) }
                    }
                } else null
            }
        }

        handler.pointed.ui.SetCellValue = staticCFunction { handler, _, row, column, value ->
            with (handler!!.reinterpret<ktTableHandler>().pointed.ref!!.asStableRef<Table<T>>().get()) {
                if (column >= 0 && column < values.size) values[column].let {
                    when (it) {
                        is StringValue -> it.set?.invoke(row, value?.string)
                        is IntValue -> it.set?.invoke(row, value?.int ?: 0)
                        else -> {}
                    }
                }
            }
        }

        handler.pointed.ref = ref.asCPointer()
        ptr = uiNewTableModel(handler.pointed.ui.ptr) ?: throw Error()
    }

    internal fun StringValue(
        get: (row: Int) -> String,
        set: ((row: Int, value: String?) -> Unit)? = null
    ): Int {
        val id = values.size
        values += libui.StringValue(get, set)
        return id
    }

    internal fun IntValue(
        get: (row: Int) -> Int,
        set: ((row: Int, value: Int) -> Unit)? = null
    ): Int {
        val id = values.size
        values += libui.IntValue(get, set)
        return id
    }

    internal fun ImageValue(get: (row: Int) -> Image?): Int {
        val id = values.size
        values += libui.ImageValue(get)
        return id
    }

    internal fun ColorValue(get: (row: Int) -> Color?): Int {
        val id = values.size
        values += libui.ColorValue(get)
        return id
    }

    fun textColumn(name: String, get: (row: Int) -> String) {
        columns += TextColumn(name, StringValue(get), uiTableModelColumnNeverEditable)
    }

    fun textColumn(name: String, property: KProperty1<T, String>) {
        columns += TextColumn(name,
            StringValue({ row -> property.get(data[row])}), uiTableModelColumnNeverEditable)
    }

    fun textColumn(name: String, property: KMutableProperty1<T, String>) {
        columns += TextColumn(name, StringValue(
            get = { row -> property.get(data[row]) },
            set = { row, value -> property.set(data[row], value!!) }),
            uiTableModelColumnAlwaysEditable)
    }

    fun imageTextColumn(name: String, image: (row: Int) -> Image?, text: (row: Int) -> String, color: (row: Int) -> Color?) {
        columns += ImageTextColumn(name,
            ImageValue(image),
            StringValue(text), uiTableModelColumnNeverEditable,
            ColorValue(color))
    }

    fun checkboxColumn(name: String, property: KMutableProperty1<T, Boolean>) {
        columns += CheckboxColumn(name, IntValue(
            get = { row -> if (property.get(data[row])) 1 else 0 },
            set = { row, value -> property.set(data[row], (value != 0)) }),
            uiTableModelColumnAlwaysEditable)
    }

    fun progressBarColumn(name: String, get: (row: Int) -> Int) {
        columns += ProgressBarColumn(name, IntValue(get))
    }

    fun buttonColumn(name: String, text: String, set: (row: Int, value: String?) -> Unit) {
        columns += ButtonColumn(name, StringValue({ text }, set), uiTableModelColumnAlwaysEditable)
    }

    fun background(get: (row: Int) -> Color?) {
        background = ColorValue(get)
    }

    fun rowInserted(newIndex: Int) = uiTableModelRowInserted(ptr, newIndex)

    fun rowChanged(index: Int) = uiTableModelRowChanged(ptr, index)

    fun rowDeleted(oldIndex: Int) = uiTableModelRowDeleted(ptr, oldIndex)
}

///////////////////////////////////////////////////////////////////////////////

private fun TextColumn(name: String, textModel: Int, textEdit: Int,
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

private fun ImageColumn(name: String, imageModel: Int): TablePane.() -> Unit = {
    uiTableAppendImageColumn(ptr, name, imageModel)
}

private fun ImageTextColumn(name: String, imageModel: Int, textModel: Int, textEdit: Int,
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

private fun CheckboxColumn(name: String, checkboxModel: Int, checkboxEdit: Int): TablePane.() -> Unit = {
    uiTableAppendCheckboxColumn(ptr, name, checkboxModel, checkboxEdit)
}

private fun CheckboxTextColumn(name: String, checkboxModel: Int, checkboxEdit: Int,
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

private fun ProgressBarColumn(name: String, progressModel: Int): TablePane.() -> Unit = {
    uiTableAppendProgressBarColumn(ptr, name, progressModel)
}

private fun ButtonColumn(name: String, buttonTextModel: Int, buttonClickable: Int): TablePane.() -> Unit = {
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
