package libui.compose

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.cinterop.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import libui.*

inline fun withLibUI(block: () -> Unit) {
    platform.posix.srand(platform.posix.time(null).toUInt())

    val error = memScoped {
        val options = alloc<uiInitOptions>()
        uiInit(options.ptr)
    }
    if (error != null) {
        val errorString: String
        try {
            errorString = error.toKString()
        } finally {
            uiFreeInitError(error)
        }
        throw Error("error initializing ui: '$errorString'")
    }

    try {
        block()
    } finally {
        // Shutdown libui
        uiUninit()
    }
}

internal fun Snapshot.Companion.globalWrites(): Flow<Any> {
    return callbackFlow {
        val handle = registerGlobalWriteObserver { trySend(it) }
        awaitClose { handle.dispose() }
    }
}

internal fun CPointer<ByteVar>.uiText(): String {
    try {
        return toKString()
    } finally {
        uiFreeText(this)
    }
}

@Composable
internal fun <T: CPointed> rememberControl(block: () -> CPointer<T>): Control<T> {
    return remember { Control(block()) }
}

internal class Control<T: CPointed>(val ptr: CPointer<T>) : RememberObserver {
    override fun onAbandoned() {
        uiControlDestroy(ptr.reinterpret())
    }

    override fun onForgotten() {
        uiControlDestroy(ptr.reinterpret())
    }

    override fun onRemembered() {
    }
}

@Composable
internal fun handleChildren(
    content: @Composable () -> Unit,
    applier: () -> Applier<*>
) {
    val compContext = rememberCompositionContext()
    DisposableEffect(content) {
        val composition = Composition(applier(), compContext)
        composition.setContent(content)
        onDispose {
            composition.dispose()
        }
    }
}

internal fun <T: CPointed> Updater<CPointer<T>>.setCommon(enabled: Boolean, visible: Boolean) {
    set(visible) {
        if (it) {
            uiControlShow(this.reinterpret())
        } else {
            uiControlHide(this.reinterpret())
        }
    }
    set(enabled) {
        if (it) {
            uiControlEnable(this.reinterpret())
        } else {
            uiControlDisable(this.reinterpret())
        }
    }
}

@Composable
internal fun <T: Any> rememberStableRef(data: T): StableRef<T> {
    class Wrapper(val ref: StableRef<T>) : RememberObserver {
        override fun onAbandoned() {
            ref.dispose()
        }

        override fun onForgotten() {
            ref.dispose()
        }

        override fun onRemembered() {}
    }

    return remember(data) { Wrapper(StableRef.create(data)) }.ref
}

abstract class SingletonApplier<T> : AbstractApplier<T?>(null) {
    protected abstract fun setItem(item: T?)

    override fun insertTopDown(index: Int, instance: T?) {
        setItem(instance)
    }

    override fun insertBottomUp(index: Int, instance: T?) {
        // Ignore, we have a single value
    }

    override fun remove(index: Int, count: Int) {
        require(index == 0)
        require(count <= 1)
        if (count > 0) {
            setItem(null)
        }
    }

    override fun move(from: Int, to: Int, count: Int) {
        require(count == 0)
    }

    override fun onClear() {
        setItem(null)
    }
}

abstract class AppendDeleteApplier : Applier<CPointer<uiControl>?> {
    abstract fun deleteItem(index: Int)
    abstract fun appendItem(instance: CPointer<uiControl>?)

    open fun insertItemAt(index: Int, instance: CPointer<uiControl>?) {
        for (i in controls.lastIndex downTo index) {
            deleteItem(i)
        }
        appendItem(instance)
        for (control in controls.drop(index)) {
            appendItem(control)
        }
    }


    private val controls = mutableListOf<CPointer<uiControl>>()
    private val listApplier = MutableListApplier(controls)

    override fun clear() {
        for (i in controls.lastIndex downTo 0) {
            deleteItem(i)
        }
        listApplier.clear()
    }

    override fun remove(index: Int, count: Int) {
        listApplier.remove(index, count)
        repeat(count) {
            deleteItem(index)
        }
    }

    override fun move(from: Int, to: Int, count: Int) {
        listApplier.move(from, to, count)

        // TODO: This could be optimised to not remove everything.

        for (i in controls.lastIndex downTo 0) {
            deleteItem(i)
        }
        for (control in controls) {
            appendItem(control)
        }
    }

    override fun insertTopDown(index: Int, instance: CPointer<uiControl>?) {
        insertItemAt(index, instance)
        listApplier.insertTopDown(index, instance)
    }

    override fun insertBottomUp(index: Int, instance: CPointer<uiControl>?) {
        listApplier.insertBottomUp(index, instance)
    }

    override val current: CPointer<uiControl>? get() = listApplier.current

    override fun up() {
        listApplier.up()
    }

    override fun down(node: CPointer<uiControl>?) {
        listApplier.down(node)
    }
}