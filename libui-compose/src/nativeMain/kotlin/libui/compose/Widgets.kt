@file:Suppress("FunctionName")

package libui.compose

import androidx.compose.runtime.*
import cnames.structs.uiButton
import cnames.structs.uiCheckbox
import cnames.structs.uiColorButton
import cnames.structs.uiCombobox
import cnames.structs.uiDateTimePicker
import cnames.structs.uiEditableCombobox
import cnames.structs.uiEntry
import cnames.structs.uiFontButton
import cnames.structs.uiLabel
import cnames.structs.uiMultilineEntry
import cnames.structs.uiProgressBar
import cnames.structs.uiRadioButtons
import cnames.structs.uiSeparator
import cnames.structs.uiSlider
import cnames.structs.uiSpinbox
import kotlinx.cinterop.*
import libui.*
import kotlin.native.concurrent.Worker

@Composable
fun Label(
    text: String,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewLabel(text)!! }

    ComposeNode<CPointer<uiLabel>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            update(text) { uiLabelSetText(this, it) }
        }
    )
}

// TODO: Only use in HBox
@Composable
fun VerticalSeparator(
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewVerticalSeparator()!! }

    ComposeNode<CPointer<uiSeparator>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
        }
    )
}

// TODO: Only use in VBox
@Composable
fun HorizontalSeparator(
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewHorizontalSeparator()!! }

    ComposeNode<CPointer<uiSeparator>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
        }
    )
}

@Composable
fun ProgressBar(
    value: Int = -1,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewProgressBar()!! }

    ComposeNode<CPointer<uiProgressBar>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            set(value) { uiProgressBarSetValue(this, it) }
            setCommon(enabled, visible)
        }
    )
}

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewButton(text)!! }

    val callback = rememberStableRef(onClick)

    ComposeNode<CPointer<uiButton>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            update(text) { uiButtonSetText(this, it) }
            set(callback) {
                uiButtonOnClicked(
                    this,
                    staticCFunction { _, senderData ->
                        val ref = senderData!!.asStableRef<() -> Unit>()
                        ref.get()()
                    },
                    it.asCPointer()
                )
            }
        }
    )
}

@Composable
fun ColorButton(
    color: MutableState<Color>,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewColorButton()!! }

    val state = rememberStableRef(color)

    ComposeNode<CPointer<uiColorButton>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            set(color.value) { uiColorButtonSetColor(this, it.r, it.g, it.b, it.a) }
            set(state) {
                uiColorButtonOnChanged(
                    this,
                    staticCFunction { ctrl, senderData ->
                        val ref = senderData!!.asStableRef<MutableState<Color>>()
                        val array = DoubleArray(4)
                        array.usePinned { pin ->
                            uiColorButtonColor(
                                ctrl,
                                pin.addressOf(0),
                                pin.addressOf(1),
                                pin.addressOf(2),
                                pin.addressOf(3)
                            )
                        }
                        ref.get().value = Color(array[0], array[1], array[2], array[3])
                    },
                    it.asCPointer()
                )
            }
        }
    )
}

// FontButton



@Composable
private fun Entry(
    control: Control<uiEntry>,
    text: MutableState<String>,
    readOnly: Boolean,
    enabled: Boolean,
    visible: Boolean,
) {
    val state = rememberStableRef(text)

    ComposeNode<CPointer<uiEntry>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            set(text.value) { uiEntrySetText(this, it) }
            set(readOnly) { uiEntrySetReadOnly(this, if (it) 1 else 0) }
            set(state) {
                uiEntryOnChanged(
                    this,
                    staticCFunction { entry, senderData ->
                        val ref = senderData!!.asStableRef<MutableState<String>>()
                        val data = uiEntryText(entry)!!.uiText()
                        ref.get().value = data
                    },
                    it.asCPointer()
                )
            }
        }
    )
}

@Composable
fun TextField(
    text: MutableState<String>,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewEntry()!! }
    Entry(control, text, readOnly, enabled, visible)
}

@Composable
fun PasswordField(
    text: MutableState<String>,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewPasswordEntry()!! }
    Entry(control, text, readOnly, enabled, visible)
}

@Composable
fun SearchField(
    text: MutableState<String>,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewSearchEntry()!! }
    Entry(control, text, readOnly, enabled, visible)
}


@Composable
private fun MultilineEntryBase(
    control: Control<uiMultilineEntry>,
    text: MutableState<String>,
    readOnly: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val state = rememberStableRef(text)

    ComposeNode<CPointer<uiMultilineEntry>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            set(text.value) { uiMultilineEntrySetText(this, it) }
            set(readOnly) { uiMultilineEntrySetReadOnly(this, if (it) 1 else 0) }
            set(state) {
                uiMultilineEntryOnChanged(
                    this,
                    staticCFunction { entry, senderData ->
                        val ref = senderData!!.asStableRef<MutableState<String>>()
                        val data = uiMultilineEntryText(entry)!!.uiText()
                        ref.get().value = data
                    },
                    it.asCPointer()
                )
            }
        }
    )
}

@Composable
fun MultilineEntry(
    text: MutableState<String>,
    readOnly: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewMultilineEntry()!! }
    MultilineEntryBase(control, text, readOnly, enabled, visible)
}

@Composable
fun NonWrappingMultilineEntry(
    text: MutableState<String>,
    readOnly: Boolean = true,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewNonWrappingMultilineEntry()!! }
    MultilineEntryBase(control, text, readOnly, enabled, visible)
}

@Composable
fun Checkbox(
    label: String,
    checked: MutableState<Boolean>,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val control = rememberControl { uiNewCheckbox(label)!! }

    val state = rememberStableRef(checked)

    ComposeNode<CPointer<uiCheckbox>, Applier<CPointer<uiControl>>>(
        factory = { control.ptr },
        update = {
            setCommon(enabled, visible)
            update(label) { uiCheckboxSetText(this, it) }
            set(checked.value) { uiCheckboxSetChecked(this, if (it) 1 else 0) }
            set(state) {
                uiCheckboxOnToggled(
                    this,
                    staticCFunction { entry, senderData ->
                        val ref = senderData!!.asStableRef<MutableState<Boolean>>()
                        val data = uiCheckboxChecked(entry) != 0
                        ref.get().value = data
                    },
                    it.asCPointer()
                )
            }
        }
    )
}

// Combobox

// Spinbox

@Composable
fun Slider(
    value: MutableState<Int>,
    min: Int,
    max: Int,
    enabled: Boolean = true,
    visible: Boolean = true,
) {
    val state = rememberStableRef(value)

    val hack = remember(min, max) {
        movableContentOf {
            val control = rememberControl { uiNewSlider(min, max)!! }

            ComposeNode<CPointer<uiSlider>, Applier<CPointer<uiControl>>>(
                factory = { control.ptr },
                update = {
                    setCommon(enabled, visible)
                    set(value.value) { uiSliderSetValue(this, it) }
                    set(state) {
                        uiSliderOnChanged(
                            this,
                            staticCFunction { entry, senderData ->
                                val ref = senderData!!.asStableRef<MutableState<Int>>()
                                val data = uiSliderValue(entry)
                                ref.get().value = data
                            },
                            it.asCPointer()
                        )
                    }
                    update(min) { throw UnsupportedOperationException("Slider.min cannot be changed!") }
                    update(max) { throw UnsupportedOperationException("Slider.max cannot be changed!") }
                }
            )
        }
    }

    hack()
}

// uiNewRadioButtons()

// uiNewDateTimePicker()

// uiNewDatePicker()

// uiNewTimePicker()
