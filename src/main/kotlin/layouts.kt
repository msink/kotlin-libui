package libui

import kotlinx.cinterop.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Group]
// - [HorizontalBox]
// - [VerticalBox]
// - [Form]
// - [Tab]
// - [Grid]
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
    get() = uiGroupTitle(ptr)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(alloc: CPointer<uiBox>?) : Control<uiBox>(alloc)

/** A container that stack its chidren horizontally. */
class HorizontalBox : Box(uiNewHorizontalBox())

/** A container that stack its chidren vertically. */
class VerticalBox : Box(uiNewVerticalBox())

/** If `true`, the container insert some space between children. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the Box. */
fun <T : Control<*>> Box.add(widget: T, stretchy: Boolean = false): T {
    uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)
    return widget
}

/** Deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form : Control<uiForm>(uiNewForm())

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun <T : Control<*>> Form.add(label: String, widget: T, stretchy: Boolean = false): T {
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)
    return widget
}

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab : Control<uiTab>(uiNewTab())

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun <T : Control<*>> Tab.add(label: String, widget: T, margined: Boolean = true): T {
    uiTabAppend(ptr, label, widget.ctl)
    if (margined) setMargined(numPages - 1, true)
    return widget
}

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insert(index: Int, name: String, widget: Control<*>) = uiTabInsertAt(ptr, name, index, widget.ctl)

/** Delete deletes the nth page of the Tab. */
fun Tab.delete(index: Int) = uiTabDelete(ptr, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(ptr)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid : Control<uiGrid>(uiNewGrid())

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the Grid.
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
fun <T : Control<*>> Grid.add(
    widget: T,
    x: Int = 0,
    y: Int = 0,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
): T {
    uiGridAppend(ptr, widget.ctl,
        x, y, xspan, yspan,
        if (hexpand) 1 else 0, halign,
        if (vexpand) 1 else 0, valign)
    return widget
}

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
fun <T : Control<*>> Grid.insert(
    widget: T,
    existing: Control<*>,
    at: uiAt,
    xspan: Int = 1,
    yspan: Int = 1,
    hexpand: Boolean = false,
    halign: uiAlign = uiAlignFill,
    vexpand: Boolean = false,
    valign: uiAlign = uiAlignFill
): T {
    uiGridInsertAt(ptr, widget.ctl, existing.ctl,
    at, xspan, yspan,
    if (hexpand) 1 else 0, halign,
    if (vexpand) 1 else 0, valign)
    return widget
}
