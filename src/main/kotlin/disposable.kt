package libui

import kotlinx.cinterop.*

/** Manages and owns all its native resources.
 *  - Allocates one resource during construction,
 *    and may allocate some additional resources during operation.
 *  - Must free all its resource once [dispose] is invoked.
 *  - [disposed] is a final state of the class, it is not supposed
 *    to be used after being disposed.
 */
abstract class Disposable<T : CPointed>(alloc: CPointer<T>?) {
    internal var _ptr: CPointer<T>? = alloc ?: throw Error("Resource not allocated")
    internal val ptr: CPointer<T> get() = _ptr ?: throw Error("Resource is disposed")

    /** Free all allocated native resources. */
    internal abstract fun free()

    /** Frees all additional native resources, except one allocated during construction. */
    internal open fun clear() {}

    /** Returns `true` if object was disposed - in this case [disposed] will do nothing,
     *  all other operations are invalid and will `throw Error("Resource is disposed")`. */
    val disposed: Boolean get() = _ptr == null

    /** Dispose and free all allocated native resources. */
    open fun dispose() {
        if (!disposed) {
            free()
            _ptr = null
        }
    }
}
