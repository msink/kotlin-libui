package libui

import kotlinx.cinterop.*

///////////////////////////////////////////////////////////////////////////////
//
// Container widgets:
// - [Group]
// - [HorizontalBox]
// - [VerticalBox]
// - [Form]
// - [Grid]
// - [Tab]
//
///////////////////////////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
class Group(text: String, block: Group.() -> Unit = {}) : Control(uiNewGroup(text)) {
    internal val ptr: CPointer<uiGroup> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Specify the caption of the group. */
var Group.title: String
    get() = uiGroupTitle(ptr)?.toKString() ?: ""
    set(title) = uiGroupSetTitle(ptr, title)

/** Specify if the group content area should have a margin or not. */
var Group.margined: Boolean
    get() = uiGroupMargined(ptr) != 0
    set(margined) = uiGroupSetMargined(ptr, if (margined) 1 else 0)

/** sets the group's child. If child is null, the group will not have a child. */
fun Group.add(child: Control?) = uiGroupSetChild(ptr, child?.ctl)

///////////////////////////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally. */
class HorizontalBox(block: HorizontalBox.() -> Unit = {}) : Box(uiNewHorizontalBox()) {
    init { apply(block) }
}

/** A container that stack its chidren vertically. */
class VerticalBox(block: VerticalBox.() -> Unit = {}) : Box(uiNewVerticalBox()) {
    init { apply(block) }
}

/** A container that stack its chidren horizontally or vertically. */
abstract class Box(_ptr: CPointer<uiBox>?) : Control(_ptr) {
    internal val ptr: CPointer<uiBox> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
}

/** If `true`, the container insert some space between children. Defaults to `false`. */
var Box.padded: Boolean
    get() = uiBoxPadded(ptr) != 0
    set(padded) = uiBoxSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the Box. */
fun Box.add(widget: Control, stretchy: Boolean = false) =
    uiBoxAppend(ptr, widget.ctl, if (stretchy) 1 else 0)

/** Deletes the nth control of the Box. */
fun Box.delete(index: Int) = uiBoxDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
class Form(block: Form.() -> Unit = {}) : Control(uiNewForm()) {
    internal val ptr: CPointer<uiForm> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Form.padded: Boolean
    get() = uiFormPadded(ptr) != 0
    set(padded) = uiFormSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given widget to the end of the form. */
fun Form.add(label: String, widget: Control, stretchy: Boolean = false) =
    uiFormAppend(ptr, label, widget.ctl, if (stretchy) 1 else 0)

/** deletes the nth control of the form. */
fun Form.delete(index: Int) = uiFormDelete(ptr, index)

///////////////////////////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
class Tab(block: Tab.() -> Unit = {}) : Control(uiNewTab()) {
    internal val ptr: CPointer<uiTab> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** Whether page n (starting at 0) of the Tab has margins around its child. */
fun Tab.getMargined(page: Int): Boolean = uiTabMargined(ptr, page) != 0
fun Tab.setMargined(page: Int, margined: Boolean) = uiTabSetMargined(ptr, page, if (margined) 1 else 0)

/** Adds the given page to the end of the Tab. */
fun Tab.add(name: String, widget: Control) = uiTabAppend(ptr, name, widget.ctl)

/** Adds the given page to the Tab such that it is the nth page of the Tab (starting at 0). */
fun Tab.insert(index: Int, name: String, widget: Control) = uiTabInsertAt(ptr, name, index, widget.ctl)

/** Delete deletes the nth page of the Tab. */
fun Tab.delete(index: Int) = uiTabDelete(ptr, index)

/** Number of pages in the Tab. */
val Tab.numPages: Int get() = uiTabNumPages(ptr)

///////////////////////////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
class Grid(block: Grid.() -> Unit = {}) : Control(uiNewGrid()) {
    internal val ptr: CPointer<uiGrid> get() = _ptr?.reinterpret() ?: throw Error("Control is destroyed")
    init { apply(block) }
}

/** If true, the container insert some space between children. */
var Grid.padded: Boolean
    get() = uiGridPadded(ptr) != 0
    set(padded) = uiGridSetPadded(ptr, if (padded) 1 else 0)

/** Adds the given Control to the end of the Grid. */
fun Grid.add(
    widget: Control,
    left: Int,
    top: Int,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridAppend(ptr, widget.ctl, left, top, xspan, yspan, hexpand, halign, vexpand, valign)

/** Insert the given Control after existing Control. */
fun Grid.insert(
    widget: Control,
    existing: Control,
    at: uiAt,
    xspan: Int,
    yspan: Int,
    hexpand: Int,
    halign: Int,
    vexpand: Int,
    valign: Int) =
    uiGridInsertAt(ptr, widget.ctl, existing.ctl, at, xspan, yspan, hexpand, halign, vexpand, valign)
