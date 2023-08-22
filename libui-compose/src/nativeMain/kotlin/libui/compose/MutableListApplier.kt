package libui.compose

import androidx.compose.runtime.AbstractApplier

internal class MutableListApplier<T>(
    private val list: MutableList<T>
) : AbstractApplier<T?>(null) {
    override fun insertTopDown(index: Int, instance: T?) {
        list.add(index, instance!!)
    }

    override fun insertBottomUp(index: Int, instance: T?) {
        // Ignore, we have plain list
    }

    override fun remove(index: Int, count: Int) {
        for (i in index + count - 1 downTo index) {
            list.removeAt(i)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun move(from: Int, to: Int, count: Int) {
        (list as MutableList<T?>).move(from, to, count)
    }

    override fun onClear() {
        list.clear()
    }
}
