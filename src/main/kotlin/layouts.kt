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

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr).uiText()
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(alloc: CPointer<uiBox>?) : Control<uiBox>(alloc), Stretchy {

    /** Adds the given widget to the end of the Box. */
    override fun <T : Control<*>> add(widget: T, stretchy: Boolean): T {
        uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)
        return widget
    }
}

/** A container that stack its chidren horizontally. */
class HBox : Box(uiNewHorizontalBox()), StretchyHorizontal

/** A container that stack its chidren vertically. */
class VBox : Box(uiNewVerticalBox()), StretchyVertical

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
    inner class Field(val label: String, val stretchy: Boolean = false) : Container {
        val form: Form get() = this@Form
        override fun <T : Control<*>> add(widget: T): T {
            form.add(label, widget, stretchy)
            return widget
        }
    }
}

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

/** A container that show each chidren in a separate tab. */
class TabPane : Control<uiTab>(uiNewTab()) {

    /** adapter for DSL builders */
    inner class Page(val label: String) : Container {
        val pane: TabPane get() = this@TabPane
        val page = pane.numPages // last page
        override fun <T : Control<*>> add(widget: T): T {
            pane.add(label, widget)
            return widget
        }
        var margined: Boolean
            get() = pane.getMargined(page)
            set(margined) = pane.setMargined(page, margined)
    }
}

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
        val x: Int = 0,
        val y: Int = 0,
        val xspan: Int = 1,
        val yspan: Int = 1,
        val hexpand: Boolean = false,
        val halign: uiAlign = uiAlignFill,
        val vexpand: Boolean = false,
        val valign: uiAlign = uiAlignFill
    ) : Container {
        val pane: GridPane get() = this@GridPane
        override fun <T : Control<*>> add(widget: T): T {
            pane.add(widget, x, y, xspan, yspan, hexpand, halign, vexpand, valign)
            return widget
        }
    }
}

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
