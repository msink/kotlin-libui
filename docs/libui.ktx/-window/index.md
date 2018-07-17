[libui.ktx](../index.md) / [Window](./index.md)

# Window

`class Window : `[`Control`](../-control/index.md)`<`[`uiWindow`](../../libui/ui-window.md)`>, `[`Container`](../-container/index.md)

Represents a top-level window.
Contains one child control that occupies the entirety of the window.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Window(title: String, width: Int, height: Int, hasMenubar: Boolean = false)`<br>Represents a top-level window. Contains one child control that occupies the entirety of the window. |

### Properties

| Name | Summary |
|---|---|
| [borderless](borderless.md) | `var borderless: Boolean`<br>Allow to specify that the window is a frameless one, without borders, title bar and OS window control widgets. |
| [contentSize](content-size.md) | `var contentSize: `[`SizeInt`](../-size-int/index.md)<br>Size in pixel of the content area of the window. Window decoration size are excluded. This mean that if you set window size to 0,0 you still see title bar and OS window buttons. |
| [fullscreen](fullscreen.md) | `var fullscreen: Boolean`<br>Whether the window should show in fullscreen or not. |
| [margined](margined.md) | `var margined: Boolean`<br>Specify if the Window content should have a margin or not. |
| [title](title.md) | `var title: String`<br>Set or return the text to show in window title bar. |

### Inherited Properties

| Name | Summary |
|---|---|
| [enabled](../-control/enabled.md) | `var enabled: Boolean`<br>Whether the Control should be enabled or disabled. Defaults to `true`. |
| [parent](../-control/parent.md) | `var parent: `[`Control`](../-control/index.md)`<*>?`<br>Returns parent of the control or `null` for detached. |
| [toplevel](../-control/toplevel.md) | `val toplevel: Boolean`<br>Returns whether the control is a top level one or not. |
| [visible](../-control/visible.md) | `var visible: Boolean`<br>Whether the Control should be visible or hidden. Defaults to `true`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun <T : `[`Control`](../-control/index.md)`<*>> add(widget: `[`T`](add.md#T)`): `[`T`](add.md#T)<br>Specify the control to show in content area. Window can contain only one control, if you need more use layouts like Box or GridPane |
| [onClose](on-close.md) | `fun onClose(block: `[`Window`](./index.md)`.() -> Boolean): Unit`<br>Function to be run when the user clicks the Window's close button. Only one function can be registered at a time. |
| [onResize](on-resize.md) | `fun onResize(block: `[`Window`](./index.md)`.() -> Unit): Unit`<br>Function to be run when window content size change. |

### Inherited Functions

| Name | Summary |
|---|---|
| [disable](../-control/disable.md) | `fun disable(): Unit`<br>Disables the Control. |
| [dispose](../-control/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated resources. |
| [enable](../-control/enable.md) | `fun enable(): Unit`<br>Enables the Control. |
| [getHandle](../-control/get-handle.md) | `fun getHandle(): Long`<br>Returns the OS-level handle associated with this Control. |
| [hide](../-control/hide.md) | `fun hide(): Unit`<br>Hides the Control. Hidden controls do not participate in layout (that is, Box, GridPane, etc. does not reserve space for hidden controls). |
| [isEnabled](../-control/is-enabled.md) | `fun isEnabled(): Boolean`<br>Whether the Control is enabled. |
| [isEnabledToUser](../-control/is-enabled-to-user.md) | `fun isEnabledToUser(): Boolean`<br>Whether the Control and all parents are enabled. |
| [isVisible](../-control/is-visible.md) | `fun isVisible(): Boolean`<br>Whether the Control is visible. |
| [show](../-control/show.md) | `fun show(): Unit`<br>Shows the Control. |

### Extension Properties

| Name | Summary |
|---|---|
| [hbox](../hbox.md) | `val `[`Container`](../-container/index.md)`.hbox: `[`HBox`](../-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [vbox](../vbox.md) | `val `[`Container`](../-container/index.md)`.vbox: `[`VBox`](../-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |

### Extension Functions

| Name | Summary |
|---|---|
| [button](../button.md) | `fun `[`Container`](../-container/index.md)`.button(text: String, init: `[`Button`](../-button/index.md)`.() -> Unit = {}): `[`Button`](../-button/index.md)<br>DSL builder for a simple button. |
| [checkbox](../checkbox.md) | `fun `[`Container`](../-container/index.md)`.checkbox(label: String, init: `[`Checkbox`](../-checkbox/index.md)`.() -> Unit = {}): `[`Checkbox`](../-checkbox/index.md)<br>DSL builder for a checkbox widget. |
| [colorbutton](../colorbutton.md) | `fun `[`Container`](../-container/index.md)`.colorbutton(init: `[`ColorButton`](../-color-button/index.md)`.() -> Unit = {}): `[`ColorButton`](../-color-button/index.md)<br>DSL builder for a button that opens a color palette popup. |
| [combobox](../combobox.md) | `fun `[`Container`](../-container/index.md)`.combobox(init: `[`Combobox`](../-combobox/index.md)`.() -> Unit = {}): `[`Combobox`](../-combobox/index.md)<br>DSL builder for a drop down combo box that allow list selection only. |
| [datepicker](../datepicker.md) | `fun `[`Container`](../-container/index.md)`.datepicker(init: `[`DatePicker`](../-date-picker/index.md)`.() -> Unit = {}): `[`DatePicker`](../-date-picker/index.md)<br>DSL builder for a widget to edit date. |
| [datetimepicker](../datetimepicker.md) | `fun `[`Container`](../-container/index.md)`.datetimepicker(init: `[`DateTimePicker`](../-date-time-picker/index.md)`.() -> Unit = {}): `[`DateTimePicker`](../-date-time-picker/index.md)<br>DSL builder for a widget to edit date and time. |
| [drawarea](../drawarea.md) | `fun `[`Container`](../-container/index.md)`.drawarea(init: `[`DrawArea`](../-draw-area/index.md)`.() -> Unit = {}): `[`DrawArea`](../-draw-area/index.md)<br>DSL builder for a canvas you can draw on. It also receives keyboard and mouse events, is DPI aware, and has several other useful features. |
| [editablecombobox](../editablecombobox.md) | `fun `[`Container`](../-container/index.md)`.editablecombobox(init: `[`EditableCombobox`](../-editable-combobox/index.md)`.() -> Unit = {}): `[`EditableCombobox`](../-editable-combobox/index.md)<br>DSL builder for a drop down combo box that allow selection from list or free text entry. |
| [fontbutton](../fontbutton.md) | `fun `[`Container`](../-container/index.md)`.fontbutton(init: `[`FontButton`](../-font-button/index.md)`.() -> Unit = {}): `[`FontButton`](../-font-button/index.md)<br>DSL builder for a button that allows users to choose a font when they click on it. |
| [form](../form.md) | `fun `[`Container`](../-container/index.md)`.form(padded: Boolean = true, init: `[`Form`](../-form/index.md)`.() -> Unit = {}): `[`Form`](../-form/index.md)<br>DSL builder for a container that organize children as labeled fields. |
| [gridpane](../gridpane.md) | `fun `[`Container`](../-container/index.md)`.gridpane(padded: Boolean = true, init: `[`GridPane`](../-grid-pane/index.md)`.() -> Unit = {}): `[`GridPane`](../-grid-pane/index.md)<br>DSL builder for a powerful container that allow to specify size and position of each children. |
| [group](../group.md) | `fun `[`Container`](../-container/index.md)`.group(title: String, margined: Boolean = true): `[`Group`](../-group/index.md)<br>DSL builder for a container for a single widget that provide a caption and visually group it's children. |
| [hbox](../hbox.md) | `fun `[`Container`](../-container/index.md)`.hbox(padded: Boolean = true, init: `[`HBox`](../-h-box/index.md)`.() -> Unit = {}): `[`HBox`](../-h-box/index.md)<br>DSL builder for a container that stack its children horizontally. |
| [label](../label.md) | `fun `[`Container`](../-container/index.md)`.label(text: String, init: `[`Label`](../-label/index.md)`.() -> Unit = {}): `[`Label`](../-label/index.md)<br>DSL builder for a static text label. |
| [passwordfield](../passwordfield.md) | `fun `[`Container`](../-container/index.md)`.passwordfield(readonly: Boolean = false, init: `[`PasswordField`](../-password-field/index.md)`.() -> Unit = {}): `[`PasswordField`](../-password-field/index.md)<br>DSL builder for a text entry widget that mask the input, useful to edit passwords or other sensible data. |
| [progressbar](../progressbar.md) | `fun `[`Container`](../-container/index.md)`.progressbar(init: `[`ProgressBar`](../-progress-bar/index.md)`.() -> Unit = {}): `[`ProgressBar`](../-progress-bar/index.md)<br>DSL builder for a progress bar widget. |
| [radiobuttons](../radiobuttons.md) | `fun `[`Container`](../-container/index.md)`.radiobuttons(init: `[`RadioButtons`](../-radio-buttons/index.md)`.() -> Unit = {}): `[`RadioButtons`](../-radio-buttons/index.md)<br>DSL builder for a widget that represent a group of radio options. |
| [scrollingarea](../scrollingarea.md) | `fun `[`Container`](../-container/index.md)`.scrollingarea(width: Int, height: Int, init: `[`ScrollingArea`](../-scrolling-area/index.md)`.() -> Unit = {}): `[`ScrollingArea`](../-scrolling-area/index.md)<br>DSL builder for a canvas with horziontal and vertical scrollbars. |
| [searchfield](../searchfield.md) | `fun `[`Container`](../-container/index.md)`.searchfield(readonly: Boolean = false, init: `[`SearchField`](../-search-field/index.md)`.() -> Unit = {}): `[`SearchField`](../-search-field/index.md)<br>DSL builder for a text entry widget to search text. |
| [slider](../slider.md) | `fun `[`Container`](../-container/index.md)`.slider(min: Int, max: Int, init: `[`Slider`](../-slider/index.md)`.() -> Unit = {}): `[`Slider`](../-slider/index.md)<br>DSL builder for an horizontal slide to set numerical values. |
| [spinbox](../spinbox.md) | `fun `[`Container`](../-container/index.md)`.spinbox(min: Int, max: Int, init: `[`Spinbox`](../-spinbox/index.md)`.() -> Unit = {}): `[`Spinbox`](../-spinbox/index.md)<br>DSL builder for an entry widget for numerical values. |
| [tableview](../tableview.md) | `fun <T> `[`Container`](../-container/index.md)`.tableview(data: List<`[`T`](../tableview.md#T)`>, init: `[`Table`](../-table/index.md)`<`[`T`](../tableview.md#T)`>.() -> Unit = {}): `[`TableView`](../-table-view/index.md) |
| [tabpane](../tabpane.md) | `fun `[`Container`](../-container/index.md)`.tabpane(init: `[`TabPane`](../-tab-pane/index.md)`.() -> Unit = {}): `[`TabPane`](../-tab-pane/index.md)<br>DSL builder for a container that show each children in a separate tab. |
| [textarea](../textarea.md) | `fun `[`Container`](../-container/index.md)`.textarea(wrap: Boolean = true, readonly: Boolean = false, init: `[`TextArea`](../-text-area/index.md)`.() -> Unit = {}): `[`TextArea`](../-text-area/index.md)<br>DSL builder for a multiline plain text editing widget. |
| [textfield](../textfield.md) | `fun `[`Container`](../-container/index.md)`.textfield(readonly: Boolean = false, init: `[`TextField`](../-text-field/index.md)`.() -> Unit = {}): `[`TextField`](../-text-field/index.md)<br>DSL builder for a simple single line text entry widget. |
| [timepicker](../timepicker.md) | `fun `[`Container`](../-container/index.md)`.timepicker(init: `[`TimePicker`](../-time-picker/index.md)`.() -> Unit = {}): `[`TimePicker`](../-time-picker/index.md)<br>DSL builder for a widget to edit time. |
| [vbox](../vbox.md) | `fun `[`Container`](../-container/index.md)`.vbox(padded: Boolean = true, init: `[`VBox`](../-v-box/index.md)`.() -> Unit = {}): `[`VBox`](../-v-box/index.md)<br>DSL builder for a container that stack its children vertically. |
