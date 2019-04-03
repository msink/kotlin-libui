// SPDX-License-Identifier: MIT OR Apache-2.0

package libui.ktx

import kotlinx.cinterop.*
import libui.*

/** Container for child controls. */
interface Container {
    fun <T : Control<*>> add(widget: T): T
}

/** Base class for all GUI controls (widgets). */
abstract class Control<T : CPointed>(alloc: CPointer<T>?) : Disposable<T>(alloc) {
    internal val ctl: CPointer<uiControl> get() = ptr.reinterpret()
    internal val ctlDestroy = ctl.pointed.Destroy
    internal val ref = StableRef.create(this)

    init {
        controls[ctl] = this
        ctl.pointed.Destroy = staticCFunction { ctl ->
            with(controls[ctl!!] ?: throw Error("Control is disposed")) {
                ctlDestroy?.invoke(ctl)
                controls.remove(ctl)
                free()
            }
        }
    }

    /** *INTERNAL* Free all allocated resources.
     *  NOTE: Must be called *only* from libui callback Destroy */
    override fun free() {
        ref.dispose()
        _ptr = null
    }

    /** Dispose and free all allocated resources. */
    override fun dispose() {
        if (!disposed) uiControlDestroy(ctl)
    }

    /** Returns the OS-level handle associated with this Control. */
    fun getHandle(): ULong = uiControlHandle(ctl).convert()

    /** Returns whether the control is a top level one or not. */
    val toplevel: Boolean
        get() = uiControlToplevel(ctl) != 0

    /** Returns parent of the control or `null` for detached. */
    var parent: Control<*>?
        get() = controls[uiControlParent(ctl)]
        set(parent) = uiControlSetParent(ctl, parent?.ctl)

    /** Whether the Control is enabled. */
    fun isEnabled(): Boolean = uiControlEnabled(ctl) != 0

    /** Whether the Control and all parents are enabled. */
    fun isEnabledToUser(): Boolean = uiControlEnabledToUser(ctl) != 0

    /** Enables the Control. */
    fun enable() = uiControlEnable(ctl)

    /** Disables the Control. */
    fun disable() = uiControlDisable(ctl)

    /** Whether the Control should be enabled or disabled. Defaults to `true`. */
    var enabled: Boolean
        get() = isEnabled()
        set(enabled) = if (enabled) enable() else disable()

    /** Whether the Control is visible. */
    fun isVisible(): Boolean = uiControlVisible(ctl) != 0

    /** Shows the Control. */
    fun show() = uiControlShow(ctl)

    /** Hides the Control. Hidden controls do not participate in layout
     *  (that is, Box, GridPane, etc. does not reserve space for hidden controls). */
    fun hide() = uiControlHide(ctl)

    /** Whether the Control should be visible or hidden. Defaults to `true`. */
    var visible: Boolean
        get() = isVisible()
        set(visible) = if (visible) show() else hide()
}

//TODO: remove this intermediate map
private var controls = mutableMapOf<CPointer<uiControl>, Control<*>>()

internal inline fun <reified T : Control<*>> COpaquePointer?.to() = this!!.asStableRef<T>().get()

internal fun CPointer<ByteVar>?.uiText(): String {
    if (this == null) return ""
    val string = this.toKString()
    uiFreeText(this)
    return string
}
