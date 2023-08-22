package libui.compose

import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import cnames.structs.uiTab
import kotlinx.cinterop.CPointer
import libui.*


@Composable
fun TabPane(
    enabled: Boolean = true,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    val control = rememberControl { uiNewTab()!! }

    handleChildren(content) { TabApplier(control.ptr) }

    ComposeNode<CPointer<uiTab>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
        }
    )
}

class TabApplier(private val tab: CPointer<uiTab>) : AppendDeleteApplier() {
    override fun appendItem(instance: CPointer<uiControl>?) {
        val name = ""
        uiTabAppend(tab, name, instance)
    }

    override fun deleteItem(index: Int) {
        uiTabDelete(tab, index)
    }

    override fun insertItemAt(index: Int, instance: CPointer<uiControl>?) {
        val name = ""
        uiTabInsertAt(tab, name, index, instance)
    }
}
