@file:Suppress("FunctionName")

package libui.compose

import androidx.compose.runtime.*
import cnames.structs.uiGroup
//import cnames.structs.uiGrid
import kotlinx.cinterop.CPointer
import libui.*

@Composable
fun Group(
    title: String,
    margined: Boolean = false,
    enabled: Boolean = true,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    val control = rememberControl { uiNewGroup(title)!! }

    handleChildren(content) {
        object : SingletonApplier<CPointer<uiControl>>() {
            override fun setItem(item: CPointer<uiControl>?) {
                uiGroupSetChild(control.ptr, item)
            }
        }
    }

    ComposeNode<CPointer<uiGroup>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            update(title) { uiGroupSetTitle(this, it) }
            set(margined) { uiGroupSetMargined(this, if (it) 1 else 0) }
        }
    )
}

//@Composable
//fun Grid(
//    padded: Boolean = true,
//    enabled: Boolean = true,
//    visible: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val control = rememberControl { uiNewGrid()!! }
//
////    handleChildren(content) {
////        GridApplier(control.ptr)
////    }
//
//    ComposeNode<CPointer<uiGrid>, Applier<CPointer<uiControl>>>(
//        factory = { control.ptr },
//        update = {
//            setCommon(enabled, visible)
//            set(padded) { uiGridSetPadded(this, if (it) 1 else 0) }
//        }
//    )
//}
