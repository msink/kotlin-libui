package libui

import kotlinx.cinterop.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Group]
// - [HBox]
// - [VBox]
// - [Form]
// - [TabPane]
// - [GridPane]
//
///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(title: String) : Control<uiGroup>(uiNewGroup(title)), Container {

    /** Set the child widget of the Group. */
    override fun <T : Control<*>> add(widget: T): T {
        uiGroupSetChild(ptr, widget.ctl)
        return widget
    }
}

/** A container for a single widget that provide a caption and visually group it's children. */
inline fun Container.group(
    title: String,
    margined: Boolean = true,
    init: Group.() -> Unit = {}
) = add(Group(title)
        .apply { if (margined) this.margined = margined }
        .apply(init))

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr).uiText()
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its children horizontally or vertically. */
abstract class Box(alloc: CPointer<uiBox>?) : Control<uiBox>(alloc), Container {

    /** adapter for DSL builders */
    inner class Stretchy : Container {
        override fun <T : Control<*>> add(widget: T): T {
            uiBoxAppend(ptr, widget.ctl, 1)
            return widget
        }
    }

    /** Adds the given widget to the end of the Box. */
    override fun <T : Control<*>> add(widget: T): T {
        uiBoxAppend(ptr, widget.ctl, 0)
        return widget
    }
}

/** A container that stack its children horizontally. */
inline fun Container.hbox(
    padded: Boolean = true,
    init: HBox.() -> Unit = {}
) = add(HBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

/** A container that stack its children vertically. */
inline fun Container.vbox(
    padded: Boolean = true,
    init: VBox.() -> Unit = {}
) = add(VBox()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Box.stretchy(
    init: Box.Stretchy.() -> Unit = {}
) = Stretchy().apply(init)

/** A container that stack its children horizontally. */
class HBox : Box(uiNewHorizontalBox())

/** A container that stack its children vertically. */
class VBox : Box(uiNewVerticalBox())

/** If `true`, the container insert some space between children. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form : Control<uiForm>(uiNewForm()) {

    /** adapter for DSL builders */
    inner class Field(val label: String) : Container {
        val form: Form get() = this@Form
        override fun <T : Control<*>> add(widget: T): T {
            form.add(label, widget, false)
            return widget
        }
        inner class Stretchy : Container {
            override fun <T : Control<*>> add(widget: T): T {
                form.add(label, widget, true)
                return widget
            }
        }
    }
}

/** A container that organize children as labeled fields. */
inline fun Container.form(
    padded: Boolean = true,
    init: Form.() -> Unit = {}
) = add(Form()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun Form.field(
    label: String,
    init: Form.Field.() -> Unit = {}
) = Field(label).apply(init)

inline fun Form.Field.stretchy(
    init: Form.Field.Stretchy.() -> Unit = {}
) = Stretchy().apply(init)

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun Form.add(label: String, widget: Control<*>, stretchy: Boolean = false) =
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each children in a separate tab. */
class TabPane : Control<uiTab>(uiNewTab()) {

    /** adapter for DSL builders */
    inner class Page(val label: String) : Container {
        private val pane: TabPane get() = this@TabPane
        private val page = pane.numPages // last page
        override fun <T : Control<*>> add(widget: T): T {
            pane.add(label, widget)
            return widget
        }
        var margined: Boolean
            get() = pane.getMargined(page)
            set(margined) = pane.setMargined(page, margined)
    }
}

/** A container that show each children in a separate tab. */
inline fun Container.tabpane(init: TabPane.() -> Unit = {}) =
    add(TabPane().apply(init))

inline fun TabPane.page(
    label: String,
    margined: Boolean = true,
    init: TabPane.Page.() -> Unit = {}
) = Page(label)
        .apply(init)
        .apply { if (margined) this.margined = true }

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun TabPane.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun TabPane.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Number of pages in the TabPane. */
val TabPane.numPages: Int get() = uiTabNumPages(ptr)

/** Adds the given page to the end of the TabPane. */
fun TabPane.add(label: String, widget: Control<*>) {
    uiTabAppend(ptr, label, widget.ctl)
}

/** Adds the given page to the TabPane such that it is the nth page of the TabPane (starting at 0). */
fun TabPane.insert(page: Int, name: String, widget: Control<*>) = uiTabInsertAt(ptr, name, page, widget.ctl)

/** Delete deletes the nth page of the TabPane. */
fun TabPane.delete(page: Int) = uiTabDelete(ptr, page)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class GridPane : Control<uiGrid>(uiNewGrid()) {

    /** adapter for DSL builders */
    inner class Cell(
        private val x: Int = 0,
        private val y: Int = 0,
        private val xspan: Int = 1,
        private val yspan: Int = 1,
        private val hexpand: Boolean = false,
        private val halign: uiAlign = uiAlignFill,
        private val vexpand: Boolean = false,
        private val valign: uiAlign = uiAlignFill
    ) : Container {
        private val pane: GridPane get() = this@GridPane
        override fun <T : Control<*>> add(widget: T): T {
            pane.add(widget, x, y, xspan, yspan, hexpand, halign, vexpand, valign)
            return widget
        }
    }
}

/** A powerful container that allow to specify size and position of each children. */
inline fun Container.gridpane(
    padded: Boolean = true,
    init: GridPane.() -> Unit = {}
) = add(GridPane()
        .apply { if (padded) this.padded = padded }
        .apply(init))

inline fun GridPane.cell(
    x: Int = 0,
    y: Int = 0,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill,
    init: GridPane.Cell.() -> Unit = {}
) = Cell(x, y, xspan, yspan, hexpand, halign, vexpand, valign)
        .apply(init)

/** If true, the container insert some space between children. */
var GridPane.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the GridPane.
 *
 *  @param[widget] The Control to be added.
 *  @param[x] The x-coordinate of the Control's location.
 *  @param[y] The y-coordinate of the Control's location.
 *  @param[xspan] The width of the Control.
 *  @param[yspan] The height of the Control.
 *  @param[hexpand] The horizontal expand of Control.
 *  @param[halign] The horizontal alignment of Control.
 *  @param[vexpand] The vertical expand of Control.
 *  @param[valign] The vertical alignment of Control.
 */
fun GridPane.add(
    widget: Control<*>,
    x: Int = 0,
    y: Int = 0,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
) = uiGridAppend(ptr, widget.ctl,
        x, y, xspan, yspan,
        if (hexpand) 1 else 0, halign,
        if (vexpand) 1 else 0, valign)

/** Insert the given Control after existing Control.
 *
 *  @param[widget] The Control to be added.
 *  @param[existing] The existing Control at which Control be inserted.
 *  @param[at] The relative placement of the Control to the existing one.
 *  @param[xspan] The width of the Control.
 *  @param[yspan] The height of the Control.
 *  @param[hexpand] The horizontal expand of Control.
 *  @param[halign] The horizontal alignment of Control.
 *  @param[vexpand] The vertical expand of Control.
 *  @param[valign] The vertical alignment of Control.
 */
fun GridPane.insert(
    widget: Control<*>,
    existing: Control<*>,
    at: uiAt,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
) {
    uiGridInsertAt(ptr, widget.ctl, existing.ctl,
        at, xspan, yspan,
        if (hexpand) 1 else 0, halign,
        if (vexpand) 1 else 0, valign)
}
