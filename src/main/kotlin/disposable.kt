package libui

import kotlinx.cinterop.*

abstract class Disposable<T : CPointed>(alloc: CPointer<T>?) {
    internal var _ptr: CPointer<T>? = alloc
    internal val ptr: CPointer<T> get() = _ptr ?: throw Error("Resource is disposed")
    internal abstract fun free()

    val disposed: Boolean get() = _ptr == null
    fun dispose() {
        if (!disposed) {
            free()
            _ptr = null
        }
    }
}
