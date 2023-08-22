@file:Suppress("FunctionName")

package libui.compose

import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import cnames.structs.uiBox
import kotlinx.cinterop.CPointer
import libui.*

@Composable
fun VBox(
    padded: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(ctor = { uiNewVerticalBox()!! }, padded, enabled, visible, content)
}

@Composable
fun HBox(
    padded: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(ctor = { uiNewHorizontalBox()!! }, padded, enabled, visible, content)
}

@Composable
private fun Box(
    ctor: () -> CPointer<uiBox>,
    padded: Boolean,
    enabled: Boolean,
    visible: Boolean,
    content: @Composable () -> Unit
) {
    val control = rememberControl { ctor() }

    handleChildren(content) { BoxApplier(control.ptr) }

    ComposeNode<CPointer<uiBox>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            set(padded) { uiBoxSetPadded(this, if (it) 1 else 0) }
        }
    )
}

class BoxApplier(
    private val box: CPointer<uiBox>,
) : AppendDeleteApplier() {
    override fun deleteItem(index: Int) {
        uiBoxDelete(box, index)
    }

    override fun appendItem(instance: CPointer<uiControl>?) {
        val isStretchy = false
        uiBoxAppend(box, instance, if (isStretchy) 1 else 0)
    }
}
