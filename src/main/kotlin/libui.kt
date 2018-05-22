package libui

import kotlinx.cinterop.*

//const char *uiInit(uiInitOptions *options)
//void uiUninit(void)
//void uiFreeInitError(const char *err)

//void uiMain(void)
//void uiMainSteps(void)
//int uiMainStep(int wait)
//void uiQuit(void)

//void uiQueueMain(void (*f)(void *data), void *data)

//// TODO standardize the looping behavior return type, either with some enum or something, and the test expressions throughout the code
//// TODO figure out what to do about looping and the exact point that the timer is rescheduled so we can document it see https://github.com/andlabs/libui/pull/277
//// TODO (also in the above link) document that this cannot be called from any thread, unlike uiQueueMain()
//// TODO document that the minimum exact timing, either accuracy (timer burst, etc.) or granularity (15ms on Windows, etc.), is OS-defined
//// TODO also figure out how long until the initial tick is registered on all platforms to document
//// TODO also add a comment about how useful this could be in bindings, depending on the language being bound to
//void uiTimer(int milliseconds, int (*f)(void *data), void *data)

//void uiOnShouldQuit(int (*f)(void *data), void *data)

//void uiFreeText(char *text)

///////////////////////////////////////////////////////////

typealias Control = CPointer<uiControl>

//uintptr_t uiControlHandle(uiControl *)

//uiControl *uiControlParent(uiControl *)
//void uiControlSetParent(uiControl *, uiControl *)

//int uiControlToplevel(uiControl *)

//uiControl *uiAllocControl(size_t n, uint32_t OSsig, uint32_t typesig, const char *typenamestr)
//void uiFreeControl(uiControl *)

//// TODO make sure all controls have these
//void uiControlVerifySetParent(uiControl *, uiControl *)
//int uiControlEnabledToUser(uiControl *)

//void uiUserBugCannotSetParentOnToplevel(const char *type)

///////////////////////////////////////////////////////////

/** Represents a top-level window.
 *  Contains one child control that occupies the entirety of the window. */
typealias Window = CPointer<uiWindow>

/** Create a new Window. */
fun Window(title: String, width: Int, height: Int, hasMenubar: Boolean = true) : Window
    = uiNewWindow(title, width, height, if (hasMenubar) 1 else 0) ?: throw Error()

/** Destroy and free the Window. */
fun Window.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Window.
 *  On Windows this is an HWND of a libui-internal class.
 *  On GTK+ this is a pointer to a GtkWindow.
 *  On macOS this is a pointer to a NSWindow. */
val Window.handle: Long get() = uiControlHandle(reinterpret())

/** Set or return the text to show in window title bar. */
var Window.title: String
    get() = uiWindowTitle(this)?.toKString() ?: ""
    set(title) = uiWindowSetTitle(this, title)

/** Allow to specify that the window is a frameless one, without borders,
    title bar and OS window control widgets. */
var Window.borderless: Boolean
    get() = uiWindowBorderless(this) != 0
    set(borderless) = uiWindowSetBorderless(this, if (borderless) 1 else 0)

/** Specify if the Window content should have a margin or not. Sefaults to `false`. */
var Window.margined: Boolean
    get() = uiWindowMargined(this) != 0
    set(margined) = uiWindowSetMargined(this, if (margined) 1 else 0)

/** Whether the window should show in fullscreen or not. */
var Window.fullscreen: Boolean
    get() = uiWindowFullscreen(this) != 0
    set(fullscreen) = uiWindowSetFullscreen(this, if (fullscreen) 1 else 0)

//void uiWindowContentSize(uiWindow *w, int *width, int *height)
//void uiWindowSetContentSize(uiWindow *w, int width, int height)

//void uiWindowSetChild(uiWindow *w, uiControl *child)

/** Show the window. */
fun Window.show() = uiControlShow(reinterpret())

//void uiWindowOnContentSizeChanged(uiWindow *w, void (*f)(uiWindow *, void *), void *data)
//void uiWindowOnClosing(uiWindow *w, int (*f)(uiWindow *w, void *data), void *data)

///////////////////////////////////////////////////////////

typealias Button = CPointer<uiButton>

/** Create a new Button. */
fun Button(text: String) : Button = uiNewButton(text) ?: throw Error()

/** Destroy and free the Button. */
fun Button.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Button. */
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

//void uiButtonOnClicked(uiButton *b, void (*f)(uiButton *b, void *data), void *data)

///////////////////////////////////////////////////////////

/** A container that stack its chidren horizontally or vertically. */
typealias Box = CPointer<uiBox>

/** Create a new Box object that stack its chidren horizontally. */
fun HorizontalBox() : Box = uiNewHorizontalBox() ?: throw Error()

/** Create a new Box object that stack its chidren vertically. */
fun VerticalBox() : Box = uiNewVerticalBox() ?: throw Error()

/** Destroy and free the Box. */
fun Box.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Box. */
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

//void uiBoxAppend(uiBox *b, uiControl *child, int stretchy)
//void uiBoxDelete(uiBox *b, int index)

///////////////////////////////////////////////////////////

/** A checkbox widget. */
typealias Checkbox = CPointer<uiCheckbox>

/** Create a new Checkbox. */
fun Checkbox(text: String) : Checkbox = uiNewCheckbox(text) ?: throw Error()

/** Destroy and free the Checkbox. */
fun Checkbox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Checkbox. */
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

//void uiCheckboxOnToggled(uiCheckbox *c, void (*f)(uiCheckbox *c, void *data), void *data)

///////////////////////////////////////////////////////////

/** A simple, single line text entry widget. */
typealias Entry = CPointer<uiEntry>

/** Create a new simple text Entry. */
fun Entry() : Entry = uiNewEntry() ?: throw Error()

/** Create a new text Entry widget that mask the input,
    useful to edit passwords or other sensible data. */
fun PasswordEntry() : Entry = uiNewPasswordEntry() ?: throw Error()

/** Create a new text Entry to search text. */
fun SearchEntry() : Entry = uiNewSearchEntry() ?: throw Error()

/** Destroy and free the Entry. */
fun Entry.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Entry. */
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
var Entry.readonly: Boolean
    get() = uiEntryReadOnly(this) != 0
    set(readonly) = uiEntrySetReadOnly(this, if (readonly) 1 else 0)

//void uiEntryOnChanged(uiEntry *e, void (*f)(uiEntry *e, void *data), void *data)

///////////////////////////////////////////////////////////

/** A static text label. */
typealias Label = CPointer<uiLabel>

/** Create a new Label. */
fun Label(text: String) : Label = uiNewLabel(text) ?: throw Error()

/** Destroy and free the Label. */
fun Label.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Label. */
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

///////////////////////////////////////////////////////////

/** A container that show each chidren in a separate tab. */
typealias Tab = CPointer<uiTab>

/** Create a new Tab. */
fun Tab() : Tab = uiNewTab() ?: throw Error()

/** Destroy and free the Tab. */
fun Tab.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Tab. */
val Tab.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Tab should be enabled or disabled. Defaults to `true`. */
var Tab.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Tab should be visible or hidden. Defaults to `true`. */
var Tab.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

//int uiTabMargined(uiTab *t, int page)
//void uiTabSetMargined(uiTab *t, int page, int margined)
//void uiTabAppend(uiTab *t, const char *name, uiControl *c)
//void uiTabInsertAt(uiTab *t, const char *name, int before, uiControl *c)
//void uiTabDelete(uiTab *t, int index)
//int uiTabNumPages(uiTab *t)

///////////////////////////////////////////////////////////

/** A container for a single widget that provide a caption and visually group it's children. */
typealias Group = CPointer<uiGroup>

/** Create a new Group. */
fun Group(text: String) : Group = uiNewGroup(text) ?: throw Error()

/** Destroy and free the Group. */
fun Group.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Group. */
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

//void uiGroupSetChild(uiGroup *g, uiControl *c)

///////////////////////////////////////////////////////////

//// spinbox/slider rules:
//// setting value outside of range will automatically clamp
//// initial value is minimum
//// complaint if min >= max?

/** An entry widget for numerical values. */
typealias Spinbox = CPointer<uiSpinbox>

/** Create a new Spinbox. */
fun Spinbox(min: Int, max: Int) : Spinbox = uiNewSpinbox(min, max) ?: throw Error()

/** Destroy and free the Spinbox. */
fun Spinbox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Spinbox. */
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

//void uiSpinboxOnChanged(uiSpinbox *s, void (*f)(uiSpinbox *s, void *data), void *data)

///////////////////////////////////////////////////////////

/** Horizontal slide to set numerical values. */
typealias Slider = CPointer<uiSlider>

/** Create a new UiSlider. */
fun Slider(min: Int, max: Int) : Slider = uiNewSlider(min, max) ?: throw Error()

/** Destroy and free the Slider. */
fun Slider.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Slider. */
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

//void uiSliderOnChanged(uiSlider *s, void (*f)(uiSlider *s, void *data), void *data)

///////////////////////////////////////////////////////////

/** Progress bar widget. */
typealias ProgressBar = CPointer<uiProgressBar>

/** Create a new ProgressBar. */
fun ProgressBar() : ProgressBar = uiNewProgressBar() ?: throw Error()

/** Destroy and free the ProgressBar. */
fun ProgressBar.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this ProgressBar. */
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
    Could be setted to -1 to create an indeterminate progress bar. */
var ProgressBar.value: Int
    get() = uiProgressBarValue(this)
    set(value) = uiProgressBarSetValue(this, value)

///////////////////////////////////////////////////////////

/** A vertical or an horizontal line to visually separate widgets. */
typealias Separator = CPointer<uiSeparator>

/** Create a new Separator object - an horizontal line to visually separate widgets. */
fun HorizontalSeparator() : Separator = uiNewHorizontalSeparator() ?: throw Error()

/** Create a new Separator object - a vertical line to visually separate widgets. */
fun VerticalSeparator() : Separator = uiNewVerticalSeparator() ?: throw Error()

/** Destroy and free the Separator. */
fun Separator.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Separator. */
val Separator.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Separator should be enabled or disabled. Defaults to `true`. */
var Separator.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Separator should be visible or hidden. Defaults to `true`. */
var Separator.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

///////////////////////////////////////////////////////////

/** A drop down combo box that allow list selection only. */
typealias Combobox = CPointer<uiCombobox>

/** Create a new Combobox. */
fun Combobox() : Combobox = uiNewCombobox() ?: throw Error()

/** Destroy and free the Combobox. */
fun Combobox.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this Combobox. */
val Combobox.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the Combobox should be enabled or disabled. Defaults to `true`. */
var Combobox.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the Combobox should be visible or hidden. Defaults to `true`. */
var Combobox.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

//int uiComboboxSelected(uiCombobox *c)
//void uiComboboxSetSelected(uiCombobox *c, int n)

//void uiComboboxAppend(uiCombobox *c, const char *text)
//void uiComboboxOnSelected(uiCombobox *c, void (*f)(uiCombobox *c, void *data), void *data)

///////////////////////////////////////////////////////////

/** A drop down combo box that allow selection from list or free text entry. */
typealias EditableCombobox = CPointer<uiEditableCombobox>

/** Create a new EditableCombobox. */
fun EditableCombobox() : EditableCombobox = uiNewEditableCombobox() ?: throw Error()

/** Return or set the current selected text or the text value of the selected item in the list. */
var EditableCombobox.text: String
    get() = uiEditableComboboxText(this)?.toKString() ?: ""
    set(text) = uiEditableComboboxSetText(this, text)

//void uiEditableComboboxAppend(uiEditableCombobox *c, const char *text)
//// TODO what do we call a function that sets the currently selected item and fills the text field with it? editable comboboxes have no consistent concept of selected item
//void uiEditableComboboxOnChanged(uiEditableCombobox *c, void (*f)(uiEditableCombobox *c, void *data), void *data)

///////////////////////////////////////////////////////////

/** A widget that represent a group of radio options. */
typealias RadioButtons = CPointer<uiRadioButtons>

/** Create a new RadioButtons. */
fun RadioButtons() : RadioButtons = uiNewRadioButtons() ?: throw Error()

/** Destroy and free the RadioButtons. */
fun RadioButtons.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this RadioButtons. */
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

//void uiRadioButtonsAppend(uiRadioButtons *r, const char *text)
//void uiRadioButtonsOnSelected(uiRadioButtons *r, void (*f)(uiRadioButtons *, void *), void *data)

///////////////////////////////////////////////////////////

/** A widgets to edit date/times. */
typealias DateTimePicker = CPointer<uiDateTimePicker>

/** Create a new DateTimePicker object to edit date/times. */
fun DateTimePicker() : DateTimePicker = uiNewDateTimePicker() ?: throw Error()

/** Create a new DateTimePicker object to edit dates. */
fun DatePicker() : DateTimePicker = uiNewDatePicker() ?: throw Error()

/** Create a new DateTimePicker object to edit times. */
fun TimePicker() : DateTimePicker = uiNewTimePicker() ?: throw Error()

/** Destroy and free the DateTimePicker. */
fun DateTimePicker.destroy() = uiControlDestroy(reinterpret())

/** Returns the OS-level handle associated with this DateTimePicker. */
val DateTimePicker.handle: Long get() = uiControlHandle(reinterpret())

/** Whether the DateTimePicker should be enabled or disabled. Defaults to `true`. */
var DateTimePicker.enabled: Boolean
    get() = uiControlEnabled(reinterpret()) != 0
    set(enabled) = if (enabled) uiControlEnable(reinterpret()) else uiControlDisable(reinterpret())

/** Whether the DateTimePicker should be visible or hidden. Defaults to `true`. */
var DateTimePicker.visible: Boolean
    get() = uiControlVisible(reinterpret()) != 0
    set(visible) = if (visible) uiControlShow(reinterpret()) else uiControlHide(reinterpret())

//struct tm
//// TODO document that tm_wday and tm_yday are undefined, and tm_isdst should be -1
//void uiDateTimePickerTime(uiDateTimePicker *d, struct tm *time)
//void uiDateTimePickerSetTime(uiDateTimePicker *d, const struct tm *time)
//void uiDateTimePickerOnChanged(uiDateTimePicker *d, void (*f)(uiDateTimePicker *, void *), void *data)

//// TODO provide a facility for entering tab stops?

///////////////////////////////////////////////////////////

/** A multiline text entry widget. */
typealias MultilineEntry = CPointer<uiMultilineEntry>

/** Create a new MultilineEntry. */
fun MultilineEntry() : MultilineEntry = uiNewMultilineEntry() ?: throw Error()

/** Create a new non wrapping MultilineEntry. */
fun NonWrappingMultilineEntry() : MultilineEntry = uiNewNonWrappingMultilineEntry() ?: throw Error()

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

//void uiMultilineEntryAppend(uiMultilineEntry *e, const char *text)
//void uiMultilineEntryOnChanged(uiMultilineEntry *e, void (*f)(uiMultilineEntry *e, void *data), void *data)

///////////////////////////////////////////////////////////

typealias MenuItem = CPointer<uiMenuItem>

//void uiMenuItemEnable(uiMenuItem *m)
//void uiMenuItemDisable(uiMenuItem *m)
//void uiMenuItemOnClicked(uiMenuItem *m, void (*f)(uiMenuItem *sender, uiWindow *window, void *data), void *data)
//int uiMenuItemChecked(uiMenuItem *m)
//void uiMenuItemSetChecked(uiMenuItem *m, int checked)

typealias Menu = CPointer<uiMenu>

//uiMenuItem *uiMenuAppendItem(uiMenu *m, const char *name)
//uiMenuItem *uiMenuAppendCheckItem(uiMenu *m, const char *name)
//uiMenuItem *uiMenuAppendQuitItem(uiMenu *m)
//uiMenuItem *uiMenuAppendPreferencesItem(uiMenu *m)
//uiMenuItem *uiMenuAppendAboutItem(uiMenu *m)
//void uiMenuAppendSeparator(uiMenu *m)
//uiMenu *uiNewMenu(const char *name)

//char *uiOpenFile(uiWindow *parent)
//char *uiSaveFile(uiWindow *parent)
//void uiMsgBox(uiWindow *parent, const char *title, const char *description)
//void uiMsgBoxError(uiWindow *parent, const char *title, const char *description)

///////////////////////////////////////////////////////////

typealias Area = CPointer<uiArea>
typealias AreaHandler = CPointer<uiAreaHandler>
typealias AreaDrawParams = CPointer<uiAreaDrawParams>
typealias AreaMouseEvent = CPointer<uiAreaMouseEvent>
typealias AreaKeyEvent = CPointer<uiAreaKeyEvent>

typealias DrawContext = CPointer<uiDrawContext>

//// TODO RTL layouts?
//// TODO reconcile edge and corner naming

//// TODO give a better name
//// TODO document the types of width and height
//void uiAreaSetSize(uiArea *a, int width, int height)
//// TODO uiAreaQueueRedraw()
//void uiAreaQueueRedrawAll(uiArea *a)
//void uiAreaScrollTo(uiArea *a, double x, double y, double width, double height)
//// TODO document these can only be called within Mouse() handlers
//// TODO should these be allowed on scrolling areas?
//// TODO decide which mouse events should be accepted Down is the only one guaranteed to work right now
//// TODO what happens to events after calling this up to and including the next mouse up?
//// TODO release capture?
//void uiAreaBeginUserWindowMove(uiArea *a)
//void uiAreaBeginUserWindowResize(uiArea *a, uiWindowResizeEdge edge)
//uiArea *uiNewArea(uiAreaHandler *ah)
//uiArea *uiNewScrollingArea(uiAreaHandler *ah, int width, int height)

typealias DrawPath = CPointer<uiDrawPath>
typealias DrawBrush = CPointer<uiDrawBrush>
typealias DrawStrokeParams = CPointer<uiDrawStrokeParams>
typealias DrawMatrix = CPointer<uiDrawMatrix>

typealias DrawBrushGradientStop = CPointer<uiDrawBrushGradientStop>

//// this is the default for botoh cairo and Direct2D (in the latter case, from the C++ helper functions)
//// Core Graphics doesn't explicitly specify a default, but NSBezierPath allows you to choose one, and this is the initial value
//// so we're good to use it too!
//#define uiDrawDefaultMiterLimit 10.0

//uiDrawPath *uiDrawNewPath(uiDrawFillMode fillMode)
//void uiDrawFreePath(uiDrawPath *p)

//void uiDrawPathNewFigure(uiDrawPath *p, double x, double y)
//void uiDrawPathNewFigureWithArc(uiDrawPath *p, double xCenter, double yCenter, double radius, double startAngle, double sweep, int negative)
//void uiDrawPathLineTo(uiDrawPath *p, double x, double y)
//// notes: angles are both relative to 0 and go counterclockwise
//// TODO is the initial line segment on cairo and OS X a proper join?
//// TODO what if sweep < 0?
//void uiDrawPathArcTo(uiDrawPath *p, double xCenter, double yCenter, double radius, double startAngle, double sweep, int negative)
//void uiDrawPathBezierTo(uiDrawPath *p, double c1x, double c1y, double c2x, double c2y, double endX, double endY)
//// TODO quadratic bezier
//void uiDrawPathCloseFigure(uiDrawPath *p)

//// TODO effect of these when a figure is already started
//void uiDrawPathAddRectangle(uiDrawPath *p, double x, double y, double width, double height)

//void uiDrawPathEnd(uiDrawPath *p)

//void uiDrawStroke(uiDrawContext *c, uiDrawPath *path, uiDrawBrush *b, uiDrawStrokeParams *p)
//void uiDrawFill(uiDrawContext *c, uiDrawPath *path, uiDrawBrush *b)

//// TODO primitives:
//// - rounded rectangles
//// - elliptical arcs
//// - quadratic bezier curves

//void uiDrawMatrixSetIdentity(uiDrawMatrix *m)
//void uiDrawMatrixTranslate(uiDrawMatrix *m, double x, double y)
//void uiDrawMatrixScale(uiDrawMatrix *m, double xCenter, double yCenter, double x, double y)
//void uiDrawMatrixRotate(uiDrawMatrix *m, double x, double y, double amount)
//void uiDrawMatrixSkew(uiDrawMatrix *m, double x, double y, double xamount, double yamount)
//void uiDrawMatrixMultiply(uiDrawMatrix *dest, uiDrawMatrix *src)
//int uiDrawMatrixInvertible(uiDrawMatrix *m)
//int uiDrawMatrixInvert(uiDrawMatrix *m)
//void uiDrawMatrixTransformPoint(uiDrawMatrix *m, double *x, double *y)
//void uiDrawMatrixTransformSize(uiDrawMatrix *m, double *x, double *y)

//void uiDrawTransform(uiDrawContext *c, uiDrawMatrix *m)

//// TODO add a uiDrawPathStrokeToFill() or something like that
//void uiDrawClip(uiDrawContext *c, uiDrawPath *path)

//void uiDrawSave(uiDrawContext *c)
//void uiDrawRestore(uiDrawContext *c)

//// uiAttribute stores information about an attribute in a
//// uiAttributedString.
////
//// You do not create uiAttributes directly instead, you create a
//// uiAttribute of a given type using the specialized constructor
//// functions. For every Unicode codepoint in the uiAttributedString,
//// at most one value of each attribute type can be applied.
////
//// uiAttributes are immutable and the uiAttributedString takes
//// ownership of the uiAttribute object once assigned, copying its
//// contents as necessary.
typealias Attribute = CPointer<uiAttribute>

//// uiFreeAttribute() frees a uiAttribute. You generally do not need to
//// call this yourself, as uiAttributedString does this for you. In fact,
//// it is an error to call this function on a uiAttribute that has been
//// given to a uiAttributedString. You can call this, however, if you
//// created a uiAttribute that you aren't going to use later.
//void uiFreeAttribute(uiAttribute *a)

//// uiAttributeGetType() returns the type of a.
//// TODO I don't like this name
//uiAttributeType uiAttributeGetType(const uiAttribute *a)

//// uiNewFamilyAttribute() creates a new uiAttribute that changes the
//// font family of the text it is applied to. family is copied you do not
//// need to keep it alive after uiNewFamilyAttribute() returns. Font
//// family names are case-insensitive.
//uiAttribute *uiNewFamilyAttribute(const char *family)

//// uiAttributeFamily() returns the font family stored in a. The
//// returned string is owned by a. It is an error to call this on a
//// uiAttribute that does not hold a font family.
//const char *uiAttributeFamily(const uiAttribute *a)

//// uiNewSizeAttribute() creates a new uiAttribute that changes the
//// size of the text it is applied to, in typographical points.
//uiAttribute *uiNewSizeAttribute(double size)

//// uiAttributeSize() returns the font size stored in a. It is an error to
//// call this on a uiAttribute that does not hold a font size.
//double uiAttributeSize(const uiAttribute *a)

//// uiNewWeightAttribute() creates a new uiAttribute that changes the
//// weight of the text it is applied to. It is an error to specify a weight
//// outside the range [uiTextWeightMinimum,
//// uiTextWeightMaximum].
//uiAttribute *uiNewWeightAttribute(uiTextWeight weight)

//// uiAttributeWeight() returns the font weight stored in a. It is an error
//// to call this on a uiAttribute that does not hold a font weight.
//uiTextWeight uiAttributeWeight(const uiAttribute *a)

//// uiNewItalicAttribute() creates a new uiAttribute that changes the
//// italic mode of the text it is applied to. It is an error to specify an
//// italic mode not specified in uiTextItalic.
//uiAttribute *uiNewItalicAttribute(uiTextItalic italic)

//// uiAttributeItalic() returns the font italic mode stored in a. It is an
//// error to call this on a uiAttribute that does not hold a font italic
//// mode.
//uiTextItalic uiAttributeItalic(const uiAttribute *a)

//// uiNewStretchAttribute() creates a new uiAttribute that changes the
//// stretch of the text it is applied to. It is an error to specify a strech
//// not specified in uiTextStretch.
//uiAttribute *uiNewStretchAttribute(uiTextStretch stretch)

//// uiAttributeStretch() returns the font stretch stored in a. It is an
//// error to call this on a uiAttribute that does not hold a font stretch.
//uiTextStretch uiAttributeStretch(const uiAttribute *a)

//// uiNewColorAttribute() creates a new uiAttribute that changes the
//// color of the text it is applied to. It is an error to specify an invalid
//// color.
//uiAttribute *uiNewColorAttribute(double r, double g, double b, double a)

//// uiAttributeColor() returns the text color stored in a. It is an
//// error to call this on a uiAttribute that does not hold a text color.
//void uiAttributeColor(const uiAttribute *a, double *r, double *g, double *b, double *alpha)

//// uiNewBackgroundAttribute() creates a new uiAttribute that
//// changes the background color of the text it is applied to. It is an
//// error to specify an invalid color.
//uiAttribute *uiNewBackgroundAttribute(double r, double g, double b, double a)

//// TODO reuse uiAttributeColor() for background colors, or make a new function...

//// uiNewUnderlineAttribute() creates a new uiAttribute that changes
//// the type of underline on the text it is applied to. It is an error to
//// specify an underline type not specified in uiUnderline.
//uiAttribute *uiNewUnderlineAttribute(uiUnderline u)

//// uiAttributeUnderline() returns the underline type stored in a. It is
//// an error to call this on a uiAttribute that does not hold an underline
//// style.
//uiUnderline uiAttributeUnderline(const uiAttribute *a)

//// uiNewUnderlineColorAttribute() creates a new uiAttribute that
//// changes the color of the underline on the text it is applied to.
//// It is an error to specify an underline color not specified in
//// uiUnderlineColor.
////
//// If the specified color type is uiUnderlineColorCustom, it is an
//// error to specify an invalid color value. Otherwise, the color values
//// are ignored and should be specified as zero.
//uiAttribute *uiNewUnderlineColorAttribute(uiUnderlineColor u, double r, double g, double b, double a)

//// uiAttributeUnderlineColor() returns the underline color stored in
//// a. It is an error to call this on a uiAttribute that does not hold an
//// underline color.
//void uiAttributeUnderlineColor(const uiAttribute *a, uiUnderlineColor *u, double *r, double *g, double *b, double *alpha)

//// uiOpenTypeFeatures represents a set of OpenType feature
//// tag-value pairs, for applying OpenType features to text.
//// OpenType feature tags are four-character codes defined by
//// OpenType that cover things from design features like small
//// caps and swashes to language-specific glyph shapes and
//// beyond. Each tag may only appear once in any given
//// uiOpenTypeFeatures instance. Each value is a 32-bit integer,
//// often used as a Boolean flag, but sometimes as an index to choose
//// a glyph shape to use.
//// 
//// If a font does not support a certain feature, that feature will be
//// ignored. (TODO verify this on all OSs)
//// 
//// See the OpenType specification at
//// https://www.microsoft.com/typography/otspec/featuretags.htm
//// for the complete list of available features, information on specific
//// features, and how to use them.
//// TODO invalid features
typealias OpenTypeFeatures = CPointer<uiOpenTypeFeatures>

//// uiOpenTypeFeaturesForEachFunc is the type of the function
//// invoked by uiOpenTypeFeaturesForEach() for every OpenType
//// feature in otf. Refer to that function's documentation for more
//// details.
//typedef uiForEach (*uiOpenTypeFeaturesForEachFunc)(const uiOpenTypeFeatures *otf, char a, char b, char c, char d, uint32_t value, void *data)

//// @role uiOpenTypeFeatures constructor
//// uiNewOpenTypeFeatures() returns a new uiOpenTypeFeatures
//// instance, with no tags yet added.
//uiOpenTypeFeatures *uiNewOpenTypeFeatures(void)

//// @role uiOpenTypeFeatures destructor
//// uiFreeOpenTypeFeatures() frees otf.
//void uiFreeOpenTypeFeatures(uiOpenTypeFeatures *otf)

//// uiOpenTypeFeaturesClone() makes a copy of otf and returns it.
//// Changing one will not affect the other.
//uiOpenTypeFeatures *uiOpenTypeFeaturesClone(const uiOpenTypeFeatures *otf)

//// uiOpenTypeFeaturesAdd() adds the given feature tag and value
//// to otf. The feature tag is specified by a, b, c, and d. If there is
//// already a value associated with the specified tag in otf, the old
//// value is removed.
//void uiOpenTypeFeaturesAdd(uiOpenTypeFeatures *otf, char a, char b, char c, char d, uint32_t value)

//// uiOpenTypeFeaturesRemove() removes the given feature tag
//// and value from otf. If the tag is not present in otf,
//// uiOpenTypeFeaturesRemove() does nothing.
//void uiOpenTypeFeaturesRemove(uiOpenTypeFeatures *otf, char a, char b, char c, char d)

//// uiOpenTypeFeaturesGet() determines whether the given feature
//// tag is present in otf. If it is, *value is set to the tag's value and
//// nonzero is returned. Otherwise, zero is returned.
//// 
//// Note that if uiOpenTypeFeaturesGet() returns zero, value isn't
//// changed. This is important: if a feature is not present in a
//// uiOpenTypeFeatures, the feature is NOT treated as if its
//// value was zero anyway. Script-specific font shaping rules and
//// font-specific feature settings may use a different default value
//// for a feature. You should likewise not treat a missing feature as
//// having a value of zero either. Instead, a missing feature should
//// be treated as having some unspecified default value.
//int uiOpenTypeFeaturesGet(const uiOpenTypeFeatures *otf, char a, char b, char c, char d, uint32_t *value)

//// uiOpenTypeFeaturesForEach() executes f for every tag-value
//// pair in otf. The enumeration order is unspecified. You cannot
//// modify otf while uiOpenTypeFeaturesForEach() is running.
//void uiOpenTypeFeaturesForEach(const uiOpenTypeFeatures *otf, uiOpenTypeFeaturesForEachFunc f, void *data)

//// uiNewFeaturesAttribute() creates a new uiAttribute that changes
//// the font family of the text it is applied to. otf is copied you may
//// free it after uiNewFeaturesAttribute() returns.
//uiAttribute *uiNewFeaturesAttribute(const uiOpenTypeFeatures *otf)

//// uiAttributeFeatures() returns the OpenType features stored in a.
//// The returned uiOpenTypeFeatures object is owned by a. It is an
//// error to call this on a uiAttribute that does not hold OpenType
//// features.
//const uiOpenTypeFeatures *uiAttributeFeatures(const uiAttribute *a)

//// uiAttributedString represents a string of UTF-8 text that can
//// optionally be embellished with formatting attributes. libui
//// provides the list of formatting attributes, which cover common
//// formatting traits like boldface and color as well as advanced
//// typographical features provided by OpenType like superscripts
//// and small caps. These attributes can be combined in a variety of
//// ways.
////
//// Attributes are applied to runs of Unicode codepoints in the string.
//// Zero-length runs are elided. Consecutive runs that have the same
//// attribute type and value are merged. Each attribute is independent
//// of each other attribute overlapping attributes of different types
//// do not split each other apart, but different values of the same
//// attribute type do.
////
//// The empty string can also be represented by uiAttributedString,
//// but because of the no-zero-length-attribute rule, it will not have
//// attributes.
////
//// A uiAttributedString takes ownership of all attributes given to
//// it, as it may need to duplicate or delete uiAttribute objects at
//// any time. By extension, when you free a uiAttributedString,
//// all uiAttributes within will also be freed. Each method will
//// describe its own rules in more details.
////
//// In addition, uiAttributedString provides facilities for moving
//// between grapheme clusters, which represent a character
//// from the point of view of the end user. The cursor of a text editor
//// is always placed on a grapheme boundary, so you can use these
//// features to move the cursor left or right by one "character".
//// TODO does uiAttributedString itself need this
////
//// uiAttributedString does not provide enough information to be able
//// to draw itself onto a uiDrawContext or respond to user actions.
//// In order to do that, you'll need to use a uiDrawTextLayout, which
//// is built from the combination of a uiAttributedString and a set of
//// layout-specific properties.
typealias AttributedString = CPointer<uiAttributedString>

//// uiAttributedStringForEachAttributeFunc is the type of the function
//// invoked by uiAttributedStringForEachAttribute() for every
//// attribute in s. Refer to that function's documentation for more
//// details.
//typedef uiForEach (*uiAttributedStringForEachAttributeFunc)(const uiAttributedString *s, const uiAttribute *a, size_t start, size_t end, void *data)

//// @role uiAttributedString constructor
//// uiNewAttributedString() creates a new uiAttributedString from
//// initialString. The string will be entirely unattributed.
//uiAttributedString *uiNewAttributedString(const char *initialString)

//// @role uiAttributedString destructor
//// uiFreeAttributedString() destroys the uiAttributedString s.
//// It will also free all uiAttributes within.
//void uiFreeAttributedString(uiAttributedString *s)

//// uiAttributedStringString() returns the textual content of s as a
//// '\0'-terminated UTF-8 string. The returned pointer is valid until
//// the next change to the textual content of s.
//const char *uiAttributedStringString(const uiAttributedString *s)

//// uiAttributedStringLength() returns the number of UTF-8 bytes in
//// the textual content of s, excluding the terminating '\0'.
//size_t uiAttributedStringLen(const uiAttributedString *s)

//// uiAttributedStringAppendUnattributed() adds the '\0'-terminated
//// UTF-8 string str to the end of s. The new substring will be
//// unattributed.
//void uiAttributedStringAppendUnattributed(uiAttributedString *s, const char *str)

//// uiAttributedStringInsertAtUnattributed() adds the '\0'-terminated
//// UTF-8 string str to s at the byte position specified by at. The new
//// substring will be unattributed existing attributes will be moved
//// along with their text.
//void uiAttributedStringInsertAtUnattributed(uiAttributedString *s, const char *str, size_t at)

//// TODO add the Append and InsertAtExtendingAttributes functions
//// TODO and add functions that take a string + length

//// uiAttributedStringDelete() deletes the characters and attributes of
//// s in the byte range [start, end).
//void uiAttributedStringDelete(uiAttributedString *s, size_t start, size_t end)

//// TODO add a function to uiAttributedString to get an attribute's value at a specific index or in a specific range, so we can edit

//// uiAttributedStringSetAttribute() sets a in the byte range [start, end)
//// of s. Any existing attributes in that byte range of the same type are
//// removed. s takes ownership of a you should not use it after
//// uiAttributedStringSetAttribute() returns.
//void uiAttributedStringSetAttribute(uiAttributedString *s, uiAttribute *a, size_t start, size_t end)

//// uiAttributedStringForEachAttribute() enumerates all the
//// uiAttributes in s. It is an error to modify s in f. Within f, s still
//// owns the attribute you can neither free it nor save it for later
//// use.
//// TODO reword the above for consistency (TODO and find out what I meant by that)
//// TODO define an enumeration order (or mark it as undefined) also define how consecutive runs of identical attributes are handled here and sync with the definition of uiAttributedString itself
//void uiAttributedStringForEachAttribute(const uiAttributedString *s, uiAttributedStringForEachAttributeFunc f, void *data)

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringNumGraphemes(uiAttributedString *s)

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringByteIndexToGrapheme(uiAttributedString *s, size_t pos)

//// TODO const correct this somehow (the implementation needs to mutate the structure)
//size_t uiAttributedStringGraphemeToByteIndex(uiAttributedString *s, size_t pos)

//// uiFontDescriptor provides a complete description of a font where
//// one is needed. Currently, this means as the default font of a
//// uiDrawTextLayout and as the data returned by uiFontButton.
//// All the members operate like the respective uiAttributes.
typealias FontDescriptor = CPointer<uiFontDescriptor>

//// uiDrawTextLayout is a concrete representation of a
//// uiAttributedString that can be displayed in a uiDrawContext.
//// It includes information important for the drawing of a block of
//// text, including the bounding box to wrap the text within, the
//// alignment of lines of text within that box, areas to mark as
//// being selected, and other things.
////
//// Unlike uiAttributedString, the content of a uiDrawTextLayout is
//// immutable once it has been created.
////
//// TODO talk about OS-specific differences with text drawing that libui can't account for...
typealias DrawTextLayout = CPointer<uiDrawTextLayout>

//// uiDrawTextLayoutParams describes a uiDrawTextLayout.
//// DefaultFont is used to render any text that is not attributed
//// sufficiently in String. Width determines the width of the bounding
//// box of the text the height is determined automatically.
typealias DrawTextLayoutParams = CPointer<uiDrawTextLayoutParams>

//// @role uiDrawTextLayout constructor
//// uiDrawNewTextLayout() creates a new uiDrawTextLayout from
//// the given parameters.
////
//// TODO
//// - allow creating a layout out of a substring
//// - allow marking compositon strings
//// - allow marking selections, even after creation
//// - add the following functions:
//// 	- uiDrawTextLayoutHeightForWidth() (returns the height that a layout would need to be to display the entire string at a given width)
//// 	- uiDrawTextLayoutRangeForSize() (returns what substring would fit in a given size)
//// 	- uiDrawTextLayoutNewWithHeight() (limits amount of string used by the height)
//// - some function to fix up a range (for text editing)
//uiDrawTextLayout *uiDrawNewTextLayout(uiDrawTextLayoutParams *params)

//// @role uiDrawFreeTextLayout destructor
//// uiDrawFreeTextLayout() frees tl. The underlying
//// uiAttributedString is not freed.
//void uiDrawFreeTextLayout(uiDrawTextLayout *tl)

//// uiDrawText() draws tl in c with the top-left point of tl at (x, y).
//void uiDrawText(uiDrawContext *c, uiDrawTextLayout *tl, double x, double y)

//// uiDrawTextLayoutExtents() returns the width and height of tl
//// in width and height. The returned width may be smaller than
//// the width passed into uiDrawNewTextLayout() depending on
//// how the text in tl is wrapped. Therefore, you can use this
//// function to get the actual size of the text layout.
//void uiDrawTextLayoutExtents(uiDrawTextLayout *tl, double *width, double *height)

//// TODO metrics functions

//// TODO number of lines visible for clipping rect, range visible for clipping rect?

///////////////////////////////////////////////////////////

/** A button that allows users to choose a font when they click on it. */
typealias FontButton = CPointer<uiFontButton>

/** Creates a new uiFontButton. The default font is OS-defined. */
fun FontButton() : FontButton = uiNewFontButton() ?: throw Error()

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

//// TOOD SetFont, mechanics
//// uiFontButtonOnChanged() sets the function that is called when the font in the uiFontButton is changed.
//void uiFontButtonOnChanged(uiFontButton *b, void (*f)(uiFontButton *, void *), void *data)

//// uiFreeFontButtonFont() frees resources allocated in desc by uiFontButtonFont().
//// After calling uiFreeFontButtonFont(), the contents of desc should be assumed to be undefined (though since you allocate desc itself, you can safely reuse desc for other font descriptors).
//// Calling uiFreeFontButtonFont() on a uiFontDescriptor not returned by uiFontButtonFont() results in undefined behavior.
//void uiFreeFontButtonFont(uiFontDescriptor *desc)

///////////////////////////////////////////////////////////

/** A button that opens a color palette popup. */
typealias ColorButton = CPointer<uiColorButton>

/** Create a new ColorButton. */
fun ColorButton() : ColorButton = uiNewColorButton() ?: throw Error()

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
//void uiColorButtonOnChanged(uiColorButton *b, void (*f)(uiColorButton *, void *), void *data)

///////////////////////////////////////////////////////////

/** A container that organize children as labeled fields. */
typealias Form = CPointer<uiForm>

/** Create a new Form. */
fun Form() : Form = uiNewForm() ?: throw Error()

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

//void uiFormAppend(uiForm *f, const char *label, uiControl *c, int stretchy)
//void uiFormDelete(uiForm *f, int index)

///////////////////////////////////////////////////////////

/** A powerful container that allow to specify size and position of each children. */
typealias Grid = CPointer<uiGrid>

/** Create a new Grid. */
fun Grid() : Grid = uiNewGrid() ?: throw Error()

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

//void uiGridAppend(uiGrid *g, uiControl *c, int left, int top, int xspan, int yspan, int hexpand, uiAlign halign, int vexpand, uiAlign valign)
//void uiGridInsertAt(uiGrid *g, uiControl *c, uiControl *existing, uiAt at, int xspan, int yspan, int hexpand, uiAlign halign, int vexpand, uiAlign valign)
