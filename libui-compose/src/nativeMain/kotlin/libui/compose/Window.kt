package libui.compose

import androidx.compose.runtime.*
import cnames.structs.uiWindow
import kotlinx.cinterop.*
import libui.*

class WindowState(contentSize: SizeInt) {
    var contentSize by mutableStateOf(contentSize)
}

class WindowScope internal constructor() {
    @Composable
    fun Window(
        onCloseRequest: () -> Unit,
        state: WindowState,
        title: String,
        hasMenubar: Boolean = false,
        borderless: Boolean = false,
        margined: Boolean = false,
        fullscreen: Boolean = false,
        isVisible: Boolean = true,
        enabled: Boolean = true,
        content: @Composable () -> Unit,
    ) {
        val control = rememberControl {
            uiNewWindow(
                title,
                state.contentSize.width,
                state.contentSize.height,
                if (hasMenubar) 1 else 0
            )!!
        }

        handleChildren(content) {
            object : SingletonApplier<CPointer<uiControl>>() {
                override fun setItem(item: CPointer<uiControl>?) {
                    uiWindowSetChild(control.ptr, item)
                }
            }
        }

        val onCloseRef = rememberStableRef(onCloseRequest)
        val stateRef = rememberStableRef(state)

        ComposeNode<CPointer<uiWindow>, MutableListApplier<CPointer<uiWindow>>>(
            factory = { control.ptr },
            update = {
                update(state.contentSize) { (w, h) -> uiWindowSetContentSize(this, w, h) }
                update(title) { uiWindowSetTitle(this, it) }
                set(borderless) { uiWindowSetBorderless(this, if (it) 1 else 0) }
                set(margined) { uiWindowSetMargined(this, if (it) 1 else 0) }
                set(fullscreen) { uiWindowSetFullscreen(this, if (it) 1 else 0) }
                set(onCloseRef) {
                    uiWindowOnClosing(
                        this,
                        staticCFunction { _, senderData ->
                            val ref = senderData!!.asStableRef<() -> Unit>()
                            ref.get()()
                            0
                        },
                        it.asCPointer()
                    )
                }
                set(stateRef) {
                    uiWindowOnContentSizeChanged(
                        this,
                        staticCFunction { sender, senderData ->
                            val ref = senderData!!.asStableRef<WindowState>()

                            val array = IntArray(2)
                            array.usePinned { pin ->
                                uiWindowContentSize(sender, pin.addressOf(0), pin.addressOf(1))
                            }

                            ref.get().contentSize = SizeInt(array[0], array[1])
                        },
                        it.asCPointer()
                    )
                }
                setCommon(enabled, isVisible)
            }
        )
    }
}
