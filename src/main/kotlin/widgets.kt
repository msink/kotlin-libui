package libui

import kotlinx.cinterop.*
import platform.posix.tm

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Window]
// - [Form]
// - [Grid]
// - [Box]
// - [Tab]
// - [Group]
//
// Data entry widgets:
// - [Entry]
// - [MultilineEntry]
// - [Checkbox]
// - [Combobox]
// - [EditableCombobox]
// - [Spinbox]
// - [Slider]
// - [RadioButtons]
// - [DateTimePicker]
//
// Static widgets:
// - [Label]
// - [Separator]
// - [ProgressBar]
//
// Buttons:
// - [Button]
// - [ColorButton]
// - [FontButton]
//
///////////////////////////////////////////////////////////////////////////////

/** Represents a top-level window.
 *  Contains one child control that occupies the entirety of the window. */
typealias Window = CPointer<uiWindow>

/** Create a new Window. */
fun Window(
    title: String,
    width: Int,
    height: Int,
    hasMenubar: Boolean = true,
    block: Window.() -> Unit = {}
) : Window =
    uiNewWindow(title, width, height, if (hasMenubar) 1 else 0)?.apply(block) ?: throw Error()

/** Destroy and free the Window. */
fun Window.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Window.
 *  - On Windows this is an HWND of a libui-internal class.
 *  - On GTK+ this is a pointer to a GtkWindow.
 *  - On macOS this is a pointer to a NSWindow. */
val Window.handle: Long get() = uiControlHandle(reinterpret())

/** Set or return the text to show in window title bar. */
var Window.title: String
    get() = uiWindowTitle(this)?.toKString() ?: ""
    set(title) = uiWindowSetTitle(this, title)

/** Allow to specify that the window is a frameless one, without borders,
 *  title bar and OS window control widgets. */
var Window.borderless: Boolean
    get() = uiWindowBorderless(this) != 0
    set(borderless) = uiWindowSetBorderless(this, if (borderless) 1 else 0)

/** Specify if the Window content should have a margin or not. Defaults to `false`. */
var Window.margined: Boolean
    get() = uiWindowMargined(this) != 0
    set(margined) = uiWindowSetMargined(this, if (margined) 1 else 0)

/** Whether the window should show in fullscreen or not. */
var Window.fullscreen: Boolean
    get() = uiWindowFullscreen(this) != 0
    set(fullscreen) = uiWindowSetFullscreen(this, if (fullscreen) 1 else 0)

/** Size in pixel of the content area of the window.
 *  Window decoration size are excluded. This mean that if you set window size to 0,0
 *  you still see title bar and OS window buttons. */
var Window.contentSize: Size2D
    get() = memScoped {
        val width = alloc<IntVar>()
        var height = alloc<IntVar>()
        uiWindowContentSize(this@contentSize, width.ptr, height.ptr)
        Size2D(width = width.value, height = height.value)
    }
    set(size) = uiWindowSetContentSize(this, size.width, size.height)

/** Specify the control to show in window content area.
 *  Window instances can contain only one control. If you need more, you have to use Container */
fun Window.setChild(child: Form) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Grid) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Box) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Tab) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Group) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Entry) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: MultilineEntry) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Checkbox) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Combobox) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: EditableCombobox) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Spinbox) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Slider) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: RadioButtons) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: DateTimePicker) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Label) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Separator) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: ProgressBar) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: Button) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: ColorButton) =
    uiWindowSetChild(this, child.reinterpret())
fun Window.setChild(child: FontButton) =
    uiWindowSetChild(this, child.reinterpret())

/** Show the window. */
fun Window.show() = uiControlShow(reinterpret())

/** Function to be run when window content size change. */
fun Window.onSizeChanged(proc: Window.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiWindowOnContentSizeChanged(this, staticCFunction(::_onWindow), ref.asCPointer())
}

internal fun _onWindow(window: Window?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Window.() -> Unit>().get()
    window!!.proc()
}

/** Function to be run when the user clicks the Window's close button.
 *  Only one function can be registered at a time.
 *  @returns [true] if window is destroyed */
fun Window.onClose(proc: Window.() -> Boolean) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiWindowOnClosing(this, staticCFunction(::_onClose), ref.asCPointer())
}

internal fun _onClose(window: Window?, ref: COpaquePointer?): Int {
    val proc = ref!!.asStableRef<Window.() -> Boolean>().get()
    return if (window!!.proc()) 1 else 0
}

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
typealias Form = CPointer<uiForm>

/** Create a new Form. */
fun Form(block: Form.() -> Unit = {}): Form = uiNewForm()?.apply(block) ?: throw Error()

/** Destroy and free the Form. */
fun Form.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Form. */
val Form.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Form should be enabled or disabled. Defaults to `true`. */
var Form.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Form should be visible or hidden. Defaults to `true`. */
var Form.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(this) != 0
    set(padded) = uiFormSetPadded(this, if (padded) 1 else 0)

/** Adds the given widget to the end of the Form. */
fun Form.append(label: String, widget: Form, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Grid, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Box, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Tab, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Group, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Entry, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: MultilineEntry, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Checkbox, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Combobox, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: EditableCombobox, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Spinbox, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Slider, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: RadioButtons, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: DateTimePicker, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Label, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Separator, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: ProgressBar, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: Button, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: ColorButton, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)
fun Form.append(label: String, widget: FontButton, stretchy: Boolean = false) =
    uiFormAppend(this, label, widget.reinterpret(), if (stretchy) 1 else 0)

/** deletes the nth control of the Form. */
fun Form.delete(index: Int) = uiFormDelete(this, index)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
typealias Grid = CPointer<uiGrid>

/** Create a new Grid. */
fun Grid(block: Grid.() -> Unit = {}): Grid = uiNewGrid()?.apply(block) ?: throw Error()

/** Destroy and free the Grid. */
fun Grid.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Grid. */
val Grid.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Grid should be enabled or disabled. Defaults to `true`. */
var Grid.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Grid should be visible or hidden. Defaults to `true`. */
var Grid.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(this) != 0
    set(padded) = uiGridSetPadded(this, if (padded) 1 else 0)

/** Adds the given page to the end of the Grid. */
fun Grid.append(
    widget: Form,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Grid,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Box,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Tab,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Group,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Entry,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: MultilineEntry,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Checkbox,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Combobox,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: EditableCombobox,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Spinbox,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Slider,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: RadioButtons,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: DateTimePicker,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Label,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Separator,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: ProgressBar,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: Button,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: ColorButton,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)
fun Grid.append(
    widget: FontButton,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(this, widget.reinterpret(), left, top, xspan, yspan, hexpand, halign, vexpand, valign)

//TODO void uiGridInsertAt(uiGrid *g, uiControl *c, uiControl *existing, uiAt at, int xspan, int yspan, int hexpand, uiAlign halign, int vexpand, uiAlign valign)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
typealias Box = CPointer<uiBox>

/** Create a new Box object that stack its chidren horizontally. */
fun HorizontalBox(block: Box.() -> Unit = {}): Box = uiNewHorizontalBox()?.apply(block) ?: throw Error()

/** Create a new Box object that stack its chidren vertically. */
fun VerticalBox(block: Box.() -> Unit = {}): Box = uiNewVerticalBox()?.apply(block) ?: throw Error()

/** Destroy and free the Box. */
fun Box.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Box.
 *  - On Windows this is an HWND of a libui-internal class.
 *  - On GTK+ this is a pointer to a GtkBox.
 *  - On OS X this is a pointer to a NSView. */
val Box.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Box should be enabled or disabled. Defaults to `true`. */
var Box.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Box should be visible or hidden. Defaults to `true`. */
var Box.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** If true, the container insert some space between children. Defaults to false. */
var Box.padded: Boolean
    get() = uiBoxPadded(this) != 0
    set(padded) = uiBoxSetPadded(this, if (padded) 1 else 0)

/** Adds the given widget to the end of the Box. */
fun Box.append(widget: Form, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Grid, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Box, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Tab, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Group, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Entry, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: MultilineEntry, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Checkbox, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Combobox, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: EditableCombobox, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Spinbox, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Slider, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: RadioButtons, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: DateTimePicker, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Label, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Separator, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: ProgressBar, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: Button, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: ColorButton, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)
fun Box.append(widget: FontButton, stretchy: Boolean = false) =
    uiBoxAppend(this, widget.reinterpret(), if (stretchy) 1 else 0)

/** deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(this, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
typealias Tab = CPointer<uiTab>

/** Create a new Tab. */
fun Tab(block: Tab.() -> Unit = {}): Tab = uiNewTab()?.apply(block) ?: throw Error()

/** Destroy and free the Tab. */
fun Tab.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Tab.
 *  - On Windows this is an HWND of a standard Windows API WC_TABCONTROL class
 *    (as provided by Common Controls version 6).
 *    The pages are not children of this window and there currently
 *    is no way to directly access them.
 *  - On GTK+ this is a pointer to a GtkNotebook.
 *  - On OS X this is a pointer to a NSTabView. */
val Tab.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Tab should be enabled or disabled. Defaults to `true`. */
var Tab.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Tab should be visible or hidden. Defaults to `true`. */
var Tab.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(this, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(this, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun Tab.append(name: String, widget: Form) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Grid) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Box) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Tab) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Group) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Entry) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: MultilineEntry) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Checkbox) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Combobox) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: EditableCombobox) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Spinbox) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Slider) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: RadioButtons) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: DateTimePicker) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Label) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Separator) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: ProgressBar) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: Button) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: ColorButton) =
    uiTabAppend(this, name, widget.reinterpret())
fun Tab.append(name: String, widget: FontButton) =
    uiTabAppend(this, name, widget.reinterpret())

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insertAt(index: Int, name: String, widget: Form) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Grid) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Box) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Tab) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Group) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Entry) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: MultilineEntry) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Checkbox) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Combobox) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: EditableCombobox) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Spinbox) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Slider) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: RadioButtons) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: DateTimePicker) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Label) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Separator) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: ProgressBar) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: Button) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: ColorButton) =
    uiTabInsertAt(this, name, index, widget.reinterpret())
fun Tab.insertAt(index: Int, name: String, widget: FontButton) =
    uiTabInsertAt(this, name, index, widget.reinterpret())

/** Delete deletes the nth page of the Tab. */
fun Tab.deleteAt(index: Int) = uiTabDelete(this, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int
    get() = uiTabNumPages(this)

///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
typealias Group = CPointer<uiGroup>

/** Create a new Group. */
fun Group(text: String, block: Group.() -> Unit = {}): Group =
    uiNewGroup(text)?.apply(block) ?: throw Error()

/** Destroy and free the Group. */
fun Group.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Group.
 *  - On Windows this is an HWND of a standard Windows API BUTTON class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkFrame.
 *  - On OS X this is a pointer to a NSBox. */
val Group.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Group should be enabled or disabled. Defaults to `true`. */
var Group.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Group should be visible or hidden. Defaults to `true`. */
var Group.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(this)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(this, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(this) != 0
    set(margined) = uiGroupSetMargined(this, if (margined) 1 else 0)

/** sets the Group's child to child. If child is nil, the Group
 *  will not have a child. */
fun Group.setChild(child: Form) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Grid) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Box) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Tab) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Group) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Entry) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: MultilineEntry) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Checkbox) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Combobox) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: EditableCombobox) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Spinbox) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Slider) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: RadioButtons) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: DateTimePicker) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Label) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Separator) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: ProgressBar) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: Button) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: ColorButton) =
    uiGroupSetChild(this, child.reinterpret())
fun Group.setChild(child: FontButton) =
    uiGroupSetChild(this, child.reinterpret())

///////////////////////////////////////////////////////////////////////////////

/** A simple, single line text entry widget. */
typealias Entry = CPointer<uiEntry>

/** Create a new simple text Entry. */
fun Entry(block: Entry.() -> Unit = {}): Entry = uiNewEntry()?.apply(block) ?: throw Error()

/** Create a new text Entry widget that mask the input,
 *  useful to edit passwords or other sensible data. */
fun PasswordEntry(): Entry = uiNewPasswordEntry() ?: throw Error()

/** Create a new text Entry to search text. */
fun SearchEntry(): Entry = uiNewSearchEntry() ?: throw Error()

/** Destroy and free the Entry. */
fun Entry.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Entry.
 *  - On Windows this is an HWND of a standard Windows API EDIT class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkEntry.
 *  - On OS X this is a pointer to a NSTextField. */
val Entry.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Entry should be enabled or disabled. Defaults to `true`. */
var Entry.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Entry should be visible or hidden. Defaults to `true`. */
var Entry.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current text of the Entry. */
var Entry.text: String
    get() = uiEntryText(this)?.toKString() ?: ""
    set(text) = uiEntrySetText(this, text)

/** Whether the user is allowed to change the entry text. Defaults to `true`. */
var Entry.readOnly: Boolean
    get() = uiEntryReadOnly(this) != 0
    set(readOnly) = uiEntrySetReadOnly(this, if (readOnly) 1 else 0)

/** Funcion to be run when the user makes a change to the Entry.
 *  Only one function can be registered at a time. */
fun Entry.action(proc: Entry.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiEntryOnChanged(this, staticCFunction(::_onEntry), ref.asCPointer())
}

internal fun _onEntry(widget: Entry?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Entry.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A multiline text entry widget. */
typealias MultilineEntry = CPointer<uiMultilineEntry>

/** Create a new MultilineEntry. */
fun MultilineEntry(block: MultilineEntry.() -> Unit = {}): MultilineEntry =
    uiNewMultilineEntry()?.apply(block) ?: throw Error()

/** Create a new non wrapping MultilineEntry. */
fun NonWrappingMultilineEntry(block: MultilineEntry.() -> Unit = {}): MultilineEntry =
    uiNewNonWrappingMultilineEntry()?.apply(block) ?: throw Error()

/** Destroy and free the MultilineEntry. */
fun MultilineEntry.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this MultilineEntry. */
val MultilineEntry.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the MultilineEntry should be enabled or disabled. Defaults to `true`. */
var MultilineEntry.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the MultilineEntry should be visible or hidden. Defaults to `true`. */
var MultilineEntry.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current text of the multiline entry. */
var MultilineEntry.text: String
    get() = uiMultilineEntryText(this)?.toKString() ?: ""
    set(text) = uiMultilineEntrySetText(this, text)

/** Whether the user is allowed to change the entry text. */
var MultilineEntry.readOnly: Boolean
    get() = uiMultilineEntryReadOnly(this) != 0
    set(readOnly) = uiMultilineEntrySetReadOnly(this, if (readOnly) 1 else 0)

/** Adds the text to the end of the MultilineEntry. */
fun MultilineEntry.append(text: String) = uiMultilineEntryAppend(this, text)

/** Funcion to be run when the user makes a change to the MultilineEntry.
 *  Only one function can be registered at a time. */
fun MultilineEntry.action(proc: MultilineEntry.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiMultilineEntryOnChanged(this, staticCFunction(::_onMultilineEntry), ref.asCPointer())
}

internal fun _onMultilineEntry(widget: MultilineEntry?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<MultilineEntry.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A checkbox widget. */
typealias Checkbox = CPointer<uiCheckbox>

/** Create a new Checkbox. */
fun Checkbox(text: String, block: Checkbox.() -> Unit = {}): Checkbox =
    uiNewCheckbox(text)?.apply(block) ?: throw Error()

/** Destroy and free the Checkbox. */
fun Checkbox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Checkbox.
 *  - On Windows this is an HWND of a standard Windows API BUTTON class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkCheckButton.
 *  - On OS X this is a pointer to a NSButton. */
val Checkbox.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Checkbox should be enabled or disabled. Defaults to `true`. */
var Checkbox.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Checkbox should be visible or hidden. Defaults to `true`. */
var Checkbox.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The static text of the checkbox. */
var Checkbox.text: String
    get() = uiCheckboxText(this)?.toKString() ?: ""
    set(text) = uiCheckboxSetText(this, text)

/** Whether the checkbox is checked or unchecked. Defaults to `false`. */
var Checkbox.checked: Boolean
    get() = uiCheckboxChecked(this) != 0
    set(checked) = uiCheckboxSetChecked(this, if (checked) 1 else 0)

/** Funcion to be run when the user clicks the Checkbox.
 *  Only one function can be registered at a time. */
fun Checkbox.action(proc: Checkbox.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiCheckboxOnToggled(this, staticCFunction(::_onCheckbox), ref.asCPointer())
}

internal fun _onCheckbox(widget: Checkbox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Checkbox.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
typealias Combobox = CPointer<uiCombobox>

/** Create a new Combobox. */
fun Combobox(block: Combobox.() -> Unit = {}): Combobox =
    uiNewCombobox()?.apply(block) ?: throw Error()

/** Destroy and free the Combobox. */
fun Combobox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Combobox.
 *  - On Windows this is an HWND of a standard Windows API COMBOBOX class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkComboBoxText.
 *  - On OS X this is a pointer to a NSComboBox for editable Comboboxes
 *    and to a NSPopUpButton for noneditable Comboboxes. */
val Combobox.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Combobox should be enabled or disabled. Defaults to `true`. */
var Combobox.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Combobox should be visible or hidden. Defaults to `true`. */
var Combobox.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** Return or set the current choosed option by index. */
var Combobox.selected: Int
    get() = uiComboboxSelected(this)
    set(value) = uiComboboxSetSelected(this, value)

/** Adds the named entry to the end of the Combobox.
 *  If this entry is the first entry, it is automatically selected. */
fun Combobox.append(text: String) = uiComboboxAppend(this, text)

/** Funcion to be run when the user makes a change to the Combobox.
 *  Only one function can be registered at a time. */
fun Combobox.action(proc: Combobox.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiComboboxOnSelected(this, staticCFunction(::_onCombobox), ref.asCPointer())
}

internal fun _onCombobox(widget: Combobox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Combobox.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
typealias EditableCombobox = CPointer<uiEditableCombobox>

/** Create a new EditableCombobox. */
fun EditableCombobox(block: EditableCombobox.() -> Unit = {}): EditableCombobox =
    uiNewEditableCombobox()?.apply(block) ?: throw Error()

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.text: String
    get() = uiEditableComboboxText(this)?.toKString() ?: ""
    set(text) = uiEditableComboboxSetText(this, text)

/** Adds the named entry to the end of the EditableCombobox.
 *  If this entry is the first entry, it is automatically selected. */
fun EditableCombobox.append(text: String) = uiEditableComboboxAppend(this, text)

/** Funcion to be run when the user makes a change to the EditableCombobox.
 *  Only one function can be registered at a time. */
//TODO what do we call a function that sets the currently selected item and fills the text field with it?
//TODO editable comboboxes have no consistent concept of selected item
fun EditableCombobox.action(proc: EditableCombobox.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiEditableComboboxOnChanged(this, staticCFunction(::_onEditableCombobox), ref.asCPointer())
}

internal fun _onEditableCombobox(widget: EditableCombobox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<EditableCombobox.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

//// spinbox/slider rules:
//// setting value outside of range will automatically clamp
//// initial value is minimum
//// complaint if min >= max?

/** An entry widget for numerical values. */
typealias Spinbox = CPointer<uiSpinbox>

/** Create a new Spinbox. */
fun Spinbox(min: Int, max: Int, block: Spinbox.() -> Unit = {}): Spinbox =
    uiNewSpinbox(min, max)?.apply(block) ?: throw Error()

/** Destroy and free the Spinbox. */
fun Spinbox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Spinbox.
 *  - On Windows this is an HWND of a standard Windows API EDIT class
 *    (as provided by Common Controls version 6).
 *    Due to various limitations which affect the lifetime of the associated
 *    Common Controls version 6 UPDOWN_CLASS window that provides the buttons,
 *    there is no way to access it.
 *  - On GTK+ this is a pointer to a GtkSpinButton.
 *  - On OS X this is a pointer to a NSView that contains a NSTextField
 *    and a NSStepper as subviews. */
val Spinbox.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Spinbox should be enabled or disabled. Defaults to `true`. */
var Spinbox.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Spinbox should be visible or hidden. Defaults to `true`. */
var Spinbox.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current numeric value of the spinbox. */
var Spinbox.value: Int
    get() = uiSpinboxValue(this)
    set(value) = uiSpinboxSetValue(this, value)

/** Funcion to be run when the user makes a change to the Spinbox.
 *  Only one function can be registered at a time. */
fun Spinbox.action(proc: Spinbox.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiSpinboxOnChanged(this, staticCFunction(::_onSpinbox), ref.asCPointer())
}

internal fun _onSpinbox(widget: Spinbox?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Spinbox.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
typealias Slider = CPointer<uiSlider>

/** Create a new Slider. */
fun Slider(min: Int, max: Int, block: Slider.() -> Unit = {}): Slider =
    uiNewSlider(min, max)?.apply(block) ?: throw Error()

/** Destroy and free the Slider. */
fun Slider.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Slider.
 *  - On Windows this is an HWND of a standard Windows API TRACKBAR_CLASS class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkScale.
 *  - On OS X this is a pointer to a NSSlider. */
val Slider.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Slider should be enabled or disabled. Defaults to `true`. */
var Slider.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Slider should be visible or hidden. Defaults to `true`. */
var Slider.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current numeric value of the slider. */
var Slider.value: Int
    get() = uiSliderValue(this)
    set(value) = uiSliderSetValue(this, value)

/** Funcion to be run when the user makes a change to the Slider.
 *  Only one function can be registered at a time. */
fun Slider.action(proc: Slider.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiSliderOnChanged(this, staticCFunction(::_onSlider), ref.asCPointer())
}

internal fun _onSlider(widget: Slider?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Slider.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
typealias RadioButtons = CPointer<uiRadioButtons>

/** Create a new RadioButtons. */
fun RadioButtons(block: RadioButtons.() -> Unit = {}): RadioButtons =
    uiNewRadioButtons()?.apply(block) ?: throw Error()

/** Destroy and free the RadioButtons. */
fun RadioButtons.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this RadioButtons.
 *  - On Windows this is an HWND of a libui-internal class;
 *    its child windows are instances of the standard Windows API BUTTON class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkBox containing GtkRadioButtons.
 *  - On OS X this is a pointer to a NSView with each radio button as a NSButton subview. */
val RadioButtons.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the RadioButtons should be enabled or disabled. Defaults to `true`. */
var RadioButtons.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the RadioButtons should be visible or hidden. Defaults to `true`. */
var RadioButtons.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** Return or set the current choosed option by index. */
var RadioButtons.selected: Int
    get() = uiRadioButtonsSelected(this)
    set(value) = uiRadioButtonsSetSelected(this, value)

/** Adds the named button to the end of the RadioButtons.
 *  If this button is the first button, it is automatically selected. */
fun RadioButtons.append(text: String) = uiRadioButtonsAppend(this, text)

/** Funcion to be run when the user makes a change to the RadioButtons.
 *  Only one function can be registered at a time. */
fun RadioButtons.action(proc: RadioButtons.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiRadioButtonsOnSelected(this, staticCFunction(::_onRadioButtons), ref.asCPointer())
}

internal fun _onRadioButtons(widget: RadioButtons?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<RadioButtons.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A widgets to edit date/times. */
typealias DateTimePicker = CPointer<uiDateTimePicker>

/** Create a new DateTimePicker to edit date/times. */
fun DateTimePicker(block: DateTimePicker.() -> Unit = {}): DateTimePicker =
    uiNewDateTimePicker()?.apply(block) ?: throw Error()

/** Create a new DateTimePicker to edit dates. */
fun DatePicker(): DateTimePicker = uiNewDatePicker() ?: throw Error()

/** Create a new DateTimePicker to edit times. */
fun TimePicker(): DateTimePicker = uiNewTimePicker() ?: throw Error()

/** Destroy and free the DateTimePicker. */
fun DateTimePicker.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this DateTimePicker.
 *  - On Windows this is an HWND of a standard Windows API DATETIMEPICK_CLASS class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a libui-internal class.
 *  - On OS X this is a pointer to a NSDatePicker. */
val DateTimePicker.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the DateTimePicker should be enabled or disabled. Defaults to `true`. */
var DateTimePicker.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the DateTimePicker should be visible or hidden. Defaults to `true`. */
var DateTimePicker.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current value of the DateTimePicker. */
/*TODO var DateTimePicker.value: DateTime
    get() = memScoped {
       var tm = alloc<tm>()
       uiDateTimePickerTime(this@value, tm.ptr)
       DateTime(
           sec   = tm.sec,
           min   = tm.min,
           hour  = tm.hour,
           mday  = tm.mday,
           mon   = tm.mon,
           year  = tm.year,
           wday  = tm.wday,
           yday  = tm.yday,
           isdst = tm.isdst
       )
    }
    set(value) = memScoped {
       var tm = alloc<tm>()
       tm.sec   = value.sec
       tm.min   = value.min
       tm.hour  = value.hour
       tm.mday  = value.mday
       tm.mon   = value.mon
       tm.year  = value.year
       tm.wday  = value.wday
       tm.yday  = value.yday
       tm.isdst = value.isdst
       uiDateTimePickerSetTime(this@value, tm.ptr)
    }*/

/** Funcion to be run when the user makes a change to the DateTimePicker.
 *  Only one function can be registered at a time. */
fun DateTimePicker.action(proc: DateTimePicker.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiDateTimePickerOnChanged(this, staticCFunction(::_onDateTimePicker), ref.asCPointer())
}

internal fun _onDateTimePicker(widget: DateTimePicker?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<DateTimePicker.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A static text label. */
typealias Label = CPointer<uiLabel>

/** Create a new Label. */
fun Label(text: String, block: Label.() -> Unit = {}): Label =
    uiNewLabel(text)?.apply(block) ?: throw Error()

/** Destroy and free the Label. */
fun Label.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Label.
 *  - On Windows this is an HWND of a standard Windows API STATIC class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkLabel.
 *  - On OS X this is a pointer to a NSTextField. */
val Label.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Label should be enabled or disabled. Defaults to `true`. */
var Label.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Label should be visible or hidden. Defaults to `true`. */
var Label.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The static text of the label. */
var Label.text: String
    get() = uiLabelText(this)?.toKString() ?: ""
    set(text) = uiLabelSetText(this, text)

///////////////////////////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
typealias Separator = CPointer<uiSeparator>

/** Create a new Separator object - an horizontal line to visually separate widgets. */
fun HorizontalSeparator(block: Separator.() -> Unit = {}): Separator =
    uiNewHorizontalSeparator()?.apply(block) ?: throw Error()

/** Create a new Separator object - a vertical line to visually separate widgets. */
fun VerticalSeparator(block: Separator.() -> Unit = {}): Separator =
    uiNewVerticalSeparator()?.apply(block) ?: throw Error()

/** Destroy and free the Separator. */
fun Separator.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Separator.
 *  - On Windows this is an HWND of a standard Windows API STATIC class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkSeparator.
 *  - On OS X this is a pointer to a NSBox. */
val Separator.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Separator should be enabled or disabled. Defaults to `true`. */
var Separator.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Separator should be visible or hidden. Defaults to `true`. */
var Separator.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

///////////////////////////////////////////////////////////////////////////////

/** Progress bar widget. */
typealias ProgressBar = CPointer<uiProgressBar>

/** Create a new ProgressBar. */
fun ProgressBar(block: ProgressBar.() -> Unit = {}): ProgressBar =
    uiNewProgressBar()?.apply(block) ?: throw Error()

/** Destroy and free the ProgressBar. */
fun ProgressBar.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this ProgressBar.
 *  - On Windows this is an HWND of a standard Windows API PROGRESS_CLASS class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkProgressBar.
 *  - On OS X this is a pointer to a NSProgressIndicator. */
val ProgressBar.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the ProgressBar should be enabled or disabled. Defaults to `true`. */
var ProgressBar.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the ProgressBar should be visible or hidden. Defaults to `true`. */
var ProgressBar.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The current position of the progress bar.
 *  Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(this)
    set(value) = uiProgressBarSetValue(this, value)

///////////////////////////////////////////////////////////////////////////////

/** A simple button. */
typealias Button = CPointer<uiButton>

/** Create a new Button. */
fun Button(text: String, block: Button.() -> Unit = {}): Button =
    uiNewButton(text)?.apply(block) ?: throw Error()

/** Destroy and free the Button. */
fun Button.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Button.
 *  - On Windows this is an HWND of a standard Windows API BUTTON class
 *    (as provided by Common Controls version 6).
 *  - On GTK+ this is a pointer to a GtkButton.
 *  - On OS X this is a pointer to a NSButton. */
val Button.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Button should be enabled or disabled. Defaults to `true`. */
var Button.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Button should be visible or hidden. Defaults to `true`. */
var Button.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

/** The static text of the Button. */
var Button.text: String
    get() = uiButtonText(this)?.toKString() ?: ""
    set(text) = uiButtonSetText(this, text)

/** Funcion to be run when the user clicks the Button.
 *  Only one function can be registered at a time. */
fun Button.action(proc: Button.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiButtonOnClicked(this, staticCFunction(::_onButton), ref.asCPointer())
}

internal fun _onButton(button: Button?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<Button.() -> Unit>().get()
    button!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
typealias ColorButton = CPointer<uiColorButton>

/** Create a new ColorButton. */
fun ColorButton(block: ColorButton.() -> Unit = {}): ColorButton =
    uiNewColorButton()?.apply(block) ?: throw Error()

/** Destroy and free the ColorButton. */
fun ColorButton.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this ColorButton. */
val ColorButton.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the ColorButton should be enabled or disabled. Defaults to `true`. */
var ColorButton.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the ColorButton should be visible or hidden. Defaults to `true`. */
var ColorButton.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

//void uiColorButtonColor(uiColorButton *b, double *r, double *g, double *bl, double *a)
//void uiColorButtonSetColor(uiColorButton *b, double r, double g, double bl, double a)

/** Funcion to be run when the user makes a change to the ColorButton.
 *  Only one function can be registered at a time. */
fun ColorButton.action(proc: ColorButton.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiColorButtonOnChanged(this, staticCFunction(::_onColorButton), ref.asCPointer())
}

internal fun _onColorButton(widget: ColorButton?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<ColorButton.() -> Unit>().get()
    widget!!.proc()
}

///////////////////////////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
typealias FontButton = CPointer<uiFontButton>

/** Creates a new FontButton. The default font is OS-defined. */
fun FontButton(block: FontButton.() -> Unit = {}): FontButton =
    uiNewFontButton()?.apply(block) ?: throw Error()

/** Destroy and free the FontButton. */
fun FontButton.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this FontButton. */
val FontButton.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the FontButton should be enabled or disabled. Defaults to `true`. */
var FontButton.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the FontButton should be visible or hidden. Defaults to `true`. */
var FontButton.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

//// uiFontButtonFont() returns the font currently selected in the uiFontButton in desc.
//// uiFontButtonFont() allocates resources in desc when you are done with the font, call uiFreeFontButtonFont() to release them.
//// uiFontButtonFont() does not allocate desc itself you must do so.
//// TODO have a function that sets an entire font descriptor to a range in a uiAttributedString at once, for SetFont?
//void uiFontButtonFont(uiFontButton *b, uiFontDescriptor *desc)

/** Funcion to be run when the font in the FontButton is changed.
 *  Only one function can be registered at a time. */
fun FontButton.action(proc: FontButton.() -> Unit) {
    val ref = StableRef.create(proc).also { _stableRefs.add(it) }
    uiFontButtonOnChanged(this, staticCFunction(::_onFontButton), ref.asCPointer())
}

internal fun _onFontButton(widget: FontButton?, ref: COpaquePointer?) {
    val proc = ref!!.asStableRef<FontButton.() -> Unit>().get()
    widget!!.proc()
}

//// uiFreeFontButtonFont() frees resources allocated in desc by uiFontButtonFont().
//// After calling uiFreeFontButtonFont(), the contents of desc should be assumed to be undefined (though since you allocate desc itself, you can safely reuse desc for other font descriptors).
//// Calling uiFreeFontButtonFont() on a uiFontDescriptor not returned by uiFontButtonFont() results in undefined behavior.
//void uiFreeFontButtonFont(uiFontDescriptor *desc)
