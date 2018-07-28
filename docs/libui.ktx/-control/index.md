[libui.ktx](../index.md) / [Control](./index.md)

# Control

`abstract class Control<T : CPointed> : `[`Disposable`](../-disposable/index.md)`<`[`T`](index.md#T)`>`

Base class for all GUI controls (widgets).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Control(alloc: CPointer<`[`T`](index.md#T)`>?)`<br>Base class for all GUI controls (widgets). |

### Properties

| Name | Summary |
|---|---|
| [enabled](enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](parent.md) | `var parent: `[`Control`](./index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [disable](disable.md) | `fun disable(): Unit`<br>Disables the Control. |
| [dispose](dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated resources. |
| [enable](enable.md) | `fun enable(): Unit`<br>Enables the Control. |
| [getHandle](get-handle.md) | `fun getHandle(): Long`<br>Returns the OS-level handle associated with this Control. |
| [hide](hide.md) | `fun hide(): Unit`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](show.md) | `fun show(): Unit`<br>Shows the Control. |

### Inheritors

| Name | Summary |
|---|---|
| [Box](../-box/index.md) | `abstract class Box : `[`Control`](./index.md)`<`[`uiBox`](../../libui/ui-box.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiBox](../../libui/ui-box.md) - a container that stack its children horizontally or vertically. |
| [Button](../-button/index.md) | `class Button : `[`Control`](./index.md)`<`[`uiButton`](../../libui/ui-button.md)`>`<br>Wrapper class for [uiButton](../../libui/ui-button.md) - a simple button. |
| [Checkbox](../-checkbox/index.md) | `class Checkbox : `[`Control`](./index.md)`<`[`uiCheckbox`](../../libui/ui-checkbox.md)`>`<br>Wrapper class for [uiCheckbox](../../libui/ui-checkbox.md) - a checkbox widget. |
| [ColorButton](../-color-button/index.md) | `class ColorButton : `[`Control`](./index.md)`<`[`uiColorButton`](../../libui/ui-color-button.md)`>`<br>Wrapper class for [uiColorButton](../../libui/ui-color-button.md) - a button that opens a color palette popup. |
| [Combobox](../-combobox/index.md) | `class Combobox : `[`Control`](./index.md)`<`[`uiCombobox`](../../libui/ui-combobox.md)`>`<br>Wrapper class for [uiCombobox](../../libui/ui-combobox.md) - a drop down combo box that allow list selection only. |
| [DateTimePicker](../-date-time-picker/index.md) | `open class DateTimePicker : `[`Control`](./index.md)`<`[`uiDateTimePicker`](../../libui/ui-date-time-picker.md)`>`<br>Wrapper class for [uiDateTimePicker](../../libui/ui-date-time-picker.md) - a widget to edit date and time. |
| [DrawArea](../-draw-area/index.md) | `open class DrawArea : `[`Control`](./index.md)`<`[`uiArea`](../../libui/ui-area.md)`>`<br>Wrapper class for [uiArea](../../libui/ui-area.md) - a canvas you can draw on. |
| [EditableCombobox](../-editable-combobox/index.md) | `class EditableCombobox : `[`Control`](./index.md)`<`[`uiEditableCombobox`](../../libui/ui-editable-combobox.md)`>`<br>Wrapper class for [uiEditableCombobox](../../libui/ui-editable-combobox.md) - a drop down combo box that allow selection from list or free text entry. |
| [FontButton](../-font-button/index.md) | `class FontButton : `[`Control`](./index.md)`<`[`uiFontButton`](../../libui/ui-font-button.md)`>`<br>Wrapper class for [uiFontButton](../../libui/ui-font-button.md) - a button that allows users to choose a font. |
| [Form](../-form/index.md) | `class Form : `[`Control`](./index.md)`<`[`uiForm`](../../libui/ui-form.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiForm](../../libui/ui-form.md) - a container that organize children as labeled fields. |
| [GridPane](../-grid-pane/index.md) | `class GridPane : `[`Control`](./index.md)`<`[`uiGrid`](../../libui/ui-grid.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiGrid](../../libui/ui-grid.md) - a powerful container that allow to specify size and position of each children. |
| [Group](../-group/index.md) | `class Group : `[`Control`](./index.md)`<`[`uiGroup`](../../libui/ui-group.md)`>, `[`Container`](../-container/index.md)<br>Wrapper class for [uiGroup](../../libui/ui-group.md) - a container for a single widget that provide a caption and visually group it's children. |
| [Label](../-label/index.md) | `class Label : `[`Control`](./index.md)`<`[`uiLabel`](../../libui/ui-label.md)`>`<br>Wrapper class for [uiLabel](../../libui/ui-label.md) - a static text label. |
| [ProgressBar](../-progress-bar/index.md) | `class ProgressBar : `[`Control`](./index.md)`<`[`uiProgressBar`](../../libui/ui-progress-bar.md)`>`<br>Wrapper class for [uiProgressBar](../../libui/ui-progress-bar.md) - a progress bar widget. |
| [RadioButtons](../-radio-buttons/index.md) | `class RadioButtons : `[`Control`](./index.md)`<`[`uiRadioButtons`](../../libui/ui-radio-buttons.md)`>`<br>Wrapper class for [uiRadioButtons](../../libui/ui-radio-buttons.md) - a widget that represent a group of radio options. |
| [Separator](../-separator/index.md) | `abstract class Separator : `[`Control`](./index.md)`<`[`uiSeparator`](../../libui/ui-separator.md)`>`<br>Wrapper class for [uiSeparator](../../libui/ui-separator.md) |
| [Slider](../-slider/index.md) | `class Slider : `[`Control`](./index.md)`<`[`uiSlider`](../../libui/ui-slider.md)`>`<br>Wrapper class for [uiSlider](../../libui/ui-slider.md) - an horizontal slide to set numerical values. |
| [Spinbox](../-spinbox/index.md) | `class Spinbox : `[`Control`](./index.md)`<`[`uiSpinbox`](../../libui/ui-spinbox.md)`>`<br>Wrapper class for [uiSpinbox](../../libui/ui-spinbox.md) - an entry widget for numerical values. |
| [TabPane](../-tab-pane/index.md) | `class TabPane : `[`Control`](./index.md)`<`[`uiTab`](../../libui/ui-tab.md)`>`<br>Wrapper class for [uiTab](../../libui/ui-tab.md) - a container that show each children in a separate tab. |
| [TableView](../-table-view/index.md) | `class TableView : `[`Control`](./index.md)`<`[`uiTable`](../../libui/ui-table.md)`>`<br>Wrapper class for [uiTable](../../libui/ui-table.md) |
| [TextArea](../-text-area/index.md) | `class TextArea : `[`Control`](./index.md)`<`[`uiMultilineEntry`](../../libui/ui-multiline-entry.md)`>`<br>Wrapper class for [uiMultilineEntry](../../libui/ui-multiline-entry.md) - a multiline plain text editing widget |
| [TextField](../-text-field/index.md) | `open class TextField : `[`Control`](./index.md)`<`[`uiEntry`](../../libui/ui-entry.md)`>`<br>Wrapper class for [uiEntry](../../libui/ui-entry.md) - a simple single line text entry widget |
| [Window](../-window/index.md) | `class Window : `[`Control`](./index.md)`<`[`uiWindow`](../../libui/ui-window.md)`>, `[`Container`](../-container/index.md)<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |
