// SPDX-License-Identifier: Apache-2.0

package androidx.compose

class ViewAdapters {
    private val adapters = mutableListOf<(parent: Any, child: Any) -> Any?>()

    fun register(adapter: (parent: Any, child: Any) -> Any?) = adapters.add(adapter)
    fun adapt(parent: Any, child: Any): Any? =
        adapters.map { it(parent, child) }.filterNotNull().firstOrNull()
}

internal class ViewApplyAdapter(private val adapters: ViewAdapters? = null) :
    ApplyAdapter<Any> {

    override fun Any.start(instance: Any) {}
    override fun Any.insertAt(index: Int, instance: Any) {}
    override fun Any.removeAt(index: Int, count: Int) {}
    override fun Any.move(from: Int, to: Int, count: Int) {}
    override fun Any.end(instance: Any, parent: Any) {}
}

internal actual fun UiComposer(
    context: Context,
    root: Any,
    slots: SlotTable,
    recomposer: Recomposer
): Composer<*> = ViewComposer(context, root, slots, recomposer)

class ViewComposer(
    val context: Context,
    val root: Any,
    slotTable: SlotTable,
    recomposer: Recomposer,
    val adapters: ViewAdapters? = ViewAdapters()
) : Composer<Any>(
    slotTable,
    Applier(root, ViewApplyAdapter(adapters)),
    recomposer
)

actual val currentComposerNonNull: Composer<*>
    get() = currentComposer ?: emptyComposition()

private fun emptyComposition(): Nothing =
    error("Composition requires an active composition context")

val composer get() = currentComposerNonNull

internal actual var currentComposer: Composer<*>? = null
    private set

actual fun <T> Composer<*>.runWithCurrent(block: () -> T): T {
    val prev = currentComposer
    try {
        currentComposer = this
        return block()
    } finally {
        currentComposer = prev
    }
}

actual fun <T> Composer<*>.runWithComposing(block: () -> T): T {
    val wasComposing = isComposing
    try {
        isComposing = true
        return block()
    } finally {
        isComposing = wasComposing
    }
}
