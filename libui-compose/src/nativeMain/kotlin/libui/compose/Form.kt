package libui.compose

import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import cnames.structs.uiForm
import kotlinx.cinterop.CPointer
import libui.*


@Composable
fun Form(
    padded: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    val control = rememberControl { uiNewForm()!! }

    handleChildren(content) { FormApplier(control.ptr) }

    ComposeNode<CPointer<uiForm>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            set(padded) { uiFormSetPadded(this, if (it) 1 else 0) }
        }
    )
}


class FormApplier(private val form: CPointer<uiForm>) : AppendDeleteApplier() {
    override fun appendItem(instance: CPointer<uiControl>?) {
        val label = ""
        val isStretchy = false
        uiFormAppend(form, label, instance, if (isStretchy) 1 else 0)
    }

    override fun deleteItem(index: Int) {
        uiFormDelete(form, index)
    }
}
