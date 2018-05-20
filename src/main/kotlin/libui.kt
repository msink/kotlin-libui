package libui

import kotlinx.cinterop.*

//typedef struct uiInitOptions uiInitOptions

//struct uiInitOptions {
//	size_t Size
//}

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

typealias Control = CPointer<uiControl>

//void uiControlDestroy(uiControl *)
//uintptr_t uiControlHandle(uiControl *)
//uiControl *uiControlParent(uiControl *)
//void uiControlSetParent(uiControl *, uiControl *)
//int uiControlToplevel(uiControl *)
//int uiControlVisible(uiControl *)
//void uiControlShow(uiControl *)
//void uiControlHide(uiControl *)
//int uiControlEnabled(uiControl *)
//void uiControlEnable(uiControl *)
//void uiControlDisable(uiControl *)

//uiControl *uiAllocControl(size_t n, uint32_t OSsig, uint32_t typesig, const char *typenamestr)
//void uiFreeControl(uiControl *)

//// TODO make sure all controls have these
//void uiControlVerifySetParent(uiControl *, uiControl *)
//int uiControlEnabledToUser(uiControl *)

//void uiUserBugCannotSetParentOnToplevel(const char *type)

typealias Window = CPointer<uiWindow>

//char *uiWindowTitle(uiWindow *w)
//void uiWindowSetTitle(uiWindow *w, const char *title)
//void uiWindowContentSize(uiWindow *w, int *width, int *height)
//void uiWindowSetContentSize(uiWindow *w, int width, int height)
//int uiWindowFullscreen(uiWindow *w)
//void uiWindowSetFullscreen(uiWindow *w, int fullscreen)
//void uiWindowOnContentSizeChanged(uiWindow *w, void (*f)(uiWindow *, void *), void *data)
//void uiWindowOnClosing(uiWindow *w, int (*f)(uiWindow *w, void *data), void *data)
//int uiWindowBorderless(uiWindow *w)
//void uiWindowSetBorderless(uiWindow *w, int borderless)
//void uiWindowSetChild(uiWindow *w, uiControl *child)
//int uiWindowMargined(uiWindow *w)
//void uiWindowSetMargined(uiWindow *w, int margined)
//uiWindow *uiNewWindow(const char *title, int width, int height, int hasMenubar)

typealias Button = CPointer<uiButton>

//char *uiButtonText(uiButton *b)
//void uiButtonSetText(uiButton *b, const char *text)
//void uiButtonOnClicked(uiButton *b, void (*f)(uiButton *b, void *data), void *data)
//uiButton *uiNewButton(const char *text)

typealias Box = CPointer<uiBox>

//void uiBoxAppend(uiBox *b, uiControl *child, int stretchy)
//void uiBoxDelete(uiBox *b, int index)
//int uiBoxPadded(uiBox *b)
//void uiBoxSetPadded(uiBox *b, int padded)
//uiBox *uiNewHorizontalBox(void)
//uiBox *uiNewVerticalBox(void)

typealias Checkbox = CPointer<uiCheckbox>

//char *uiCheckboxText(uiCheckbox *c)
//void uiCheckboxSetText(uiCheckbox *c, const char *text)
//void uiCheckboxOnToggled(uiCheckbox *c, void (*f)(uiCheckbox *c, void *data), void *data)
//int uiCheckboxChecked(uiCheckbox *c)
//void uiCheckboxSetChecked(uiCheckbox *c, int checked)
//uiCheckbox *uiNewCheckbox(const char *text)

typealias Entry = CPointer<uiEntry>

//char *uiEntryText(uiEntry *e)
//void uiEntrySetText(uiEntry *e, const char *text)
//void uiEntryOnChanged(uiEntry *e, void (*f)(uiEntry *e, void *data), void *data)
//int uiEntryReadOnly(uiEntry *e)
//void uiEntrySetReadOnly(uiEntry *e, int readonly)
//uiEntry *uiNewEntry(void)
//uiEntry *uiNewPasswordEntry(void)
//uiEntry *uiNewSearchEntry(void)

typealias Label = CPointer<uiLabel>

//char *uiLabelText(uiLabel *l)
//void uiLabelSetText(uiLabel *l, const char *text)
//uiLabel *uiNewLabel(const char *text)

typealias Tab = CPointer<uiTab>

//void uiTabAppend(uiTab *t, const char *name, uiControl *c)
//void uiTabInsertAt(uiTab *t, const char *name, int before, uiControl *c)
//void uiTabDelete(uiTab *t, int index)
//int uiTabNumPages(uiTab *t)
//int uiTabMargined(uiTab *t, int page)
//void uiTabSetMargined(uiTab *t, int page, int margined)
//uiTab *uiNewTab(void)

typealias Group = CPointer<uiGroup>

//char *uiGroupTitle(uiGroup *g)
//void uiGroupSetTitle(uiGroup *g, const char *title)
//void uiGroupSetChild(uiGroup *g, uiControl *c)
//int uiGroupMargined(uiGroup *g)
//void uiGroupSetMargined(uiGroup *g, int margined)
//uiGroup *uiNewGroup(const char *title)

//// spinbox/slider rules:
//// setting value outside of range will automatically clamp
//// initial value is minimum
//// complaint if min >= max?

typealias Spinbox = CPointer<uiSpinbox>

//int uiSpinboxValue(uiSpinbox *s)
//void uiSpinboxSetValue(uiSpinbox *s, int value)
//void uiSpinboxOnChanged(uiSpinbox *s, void (*f)(uiSpinbox *s, void *data), void *data)
//uiSpinbox *uiNewSpinbox(int min, int max)

typealias Slider = CPointer<uiSlider>

//int uiSliderValue(uiSlider *s)
//void uiSliderSetValue(uiSlider *s, int value)
//void uiSliderOnChanged(uiSlider *s, void (*f)(uiSlider *s, void *data), void *data)
//uiSlider *uiNewSlider(int min, int max)

typealias ProgressBar = CPointer<uiProgressBar>

//int uiProgressBarValue(uiProgressBar *p)
//void uiProgressBarSetValue(uiProgressBar *p, int n)
//uiProgressBar *uiNewProgressBar(void)

typealias Separator = CPointer<uiSeparator>

//uiSeparator *uiNewHorizontalSeparator(void)
//uiSeparator *uiNewVerticalSeparator(void)

typealias Combobox = CPointer<uiCombobox>

//void uiComboboxAppend(uiCombobox *c, const char *text)
//int uiComboboxSelected(uiCombobox *c)
//void uiComboboxSetSelected(uiCombobox *c, int n)
//void uiComboboxOnSelected(uiCombobox *c, void (*f)(uiCombobox *c, void *data), void *data)
//uiCombobox *uiNewCombobox(void)

typealias EditableCombobox = CPointer<uiEditableCombobox>

//void uiEditableComboboxAppend(uiEditableCombobox *c, const char *text)
//char *uiEditableComboboxText(uiEditableCombobox *c)
//void uiEditableComboboxSetText(uiEditableCombobox *c, const char *text)
//// TODO what do we call a function that sets the currently selected item and fills the text field with it? editable comboboxes have no consistent concept of selected item
//void uiEditableComboboxOnChanged(uiEditableCombobox *c, void (*f)(uiEditableCombobox *c, void *data), void *data)
//uiEditableCombobox *uiNewEditableCombobox(void)

typealias RadioButtons = CPointer<uiRadioButtons>

//void uiRadioButtonsAppend(uiRadioButtons *r, const char *text)
//int uiRadioButtonsSelected(uiRadioButtons *r)
//void uiRadioButtonsSetSelected(uiRadioButtons *r, int n)
//void uiRadioButtonsOnSelected(uiRadioButtons *r, void (*f)(uiRadioButtons *, void *), void *data)
//uiRadioButtons *uiNewRadioButtons(void)

//struct tm
typealias DateTimePicker = CPointer<uiDateTimePicker>

//// TODO document that tm_wday and tm_yday are undefined, and tm_isdst should be -1
//void uiDateTimePickerTime(uiDateTimePicker *d, struct tm *time)
//void uiDateTimePickerSetTime(uiDateTimePicker *d, const struct tm *time)
//void uiDateTimePickerOnChanged(uiDateTimePicker *d, void (*f)(uiDateTimePicker *, void *), void *data)
//uiDateTimePicker *uiNewDateTimePicker(void)
//uiDateTimePicker *uiNewDatePicker(void)
//uiDateTimePicker *uiNewTimePicker(void)

//// TODO provide a facility for entering tab stops?
typealias MultilineEntry = CPointer<uiMultilineEntry>

//char *uiMultilineEntryText(uiMultilineEntry *e)
//void uiMultilineEntrySetText(uiMultilineEntry *e, const char *text)
//void uiMultilineEntryAppend(uiMultilineEntry *e, const char *text)
//void uiMultilineEntryOnChanged(uiMultilineEntry *e, void (*f)(uiMultilineEntry *e, void *data), void *data)
//int uiMultilineEntryReadOnly(uiMultilineEntry *e)
//void uiMultilineEntrySetReadOnly(uiMultilineEntry *e, int readonly)
//uiMultilineEntry *uiNewMultilineEntry(void)
//uiMultilineEntry *uiNewNonWrappingMultilineEntry(void)

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

typealias Area = CPointer<uiArea>
typealias AreaHandler = CPointer<uiAreaHandler>
typealias AreaDrawParams = CPointer<uiAreaDrawParams>
typealias AreaMouseEvent = CPointer<uiAreaMouseEvent>
typealias AreaKeyEvent = CPointer<uiAreaKeyEvent>

typealias DrawContext = CPointer<uiDrawContext>

//struct uiAreaHandler {
//	void (*Draw)(uiAreaHandler *, uiArea *, uiAreaDrawParams *)
//	// TODO document that resizes cause a full redraw for non-scrolling areas implementation-defined for scrolling areas
//	void (*MouseEvent)(uiAreaHandler *, uiArea *, uiAreaMouseEvent *)
//	// TODO document that on first show if the mouse is already in the uiArea then one gets sent with left=0
//	// TODO what about when the area is hidden and then shown again?
//	void (*MouseCrossed)(uiAreaHandler *, uiArea *, int left)
//	void (*DragBroken)(uiAreaHandler *, uiArea *)
//	int (*KeyEvent)(uiAreaHandler *, uiArea *, uiAreaKeyEvent *)
//}

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

//struct uiAreaDrawParams {
//	uiDrawContext *Context

//	// TODO document that this is only defined for nonscrolling areas
//	double AreaWidth
//	double AreaHeight

//	double ClipX
//	double ClipY
//	double ClipWidth
//	double ClipHeight
//}

typealias DrawPath = CPointer<uiDrawPath>
typealias DrawBrush = CPointer<uiDrawBrush>
typealias DrawStrokeParams = CPointer<uiDrawStrokeParams>
typealias DrawMatrix = CPointer<uiDrawMatrix>

typealias DrawBrushGradientStop = CPointer<uiDrawBrushGradientStop>

//// this is the default for botoh cairo and Direct2D (in the latter case, from the C++ helper functions)
//// Core Graphics doesn't explicitly specify a default, but NSBezierPath allows you to choose one, and this is the initial value
//// so we're good to use it too!
//#define uiDrawDefaultMiterLimit 10.0

//struct uiDrawMatrix {
//	double M11
//	double M12
//	double M21
//	double M22
//	double M31
//	double M32
//}

//struct uiDrawBrush {
//	uiDrawBrushType Type

//	// solid brushes
//	double R
//	double G
//	double B
//	double A

//	// gradient brushes
//	double X0		// linear: start X, radial: start X
//	double Y0		// linear: start Y, radial: start Y
//	double X1		// linear: end X, radial: outer circle center X
//	double Y1		// linear: end Y, radial: outer circle center Y
//	double OuterRadius		// radial gradients only
//	uiDrawBrushGradientStop *Stops
//	size_t NumStops
//	// TODO extend mode
//	// cairo: none, repeat, reflect, pad no individual control
//	// Direct2D: repeat, reflect, pad no individual control
//	// Core Graphics: none, pad before and after individually
//	// TODO cairo documentation is inconsistent about pad

//	// TODO images

//	// TODO transforms
//}

//struct uiDrawBrushGradientStop {
//	double Pos
//	double R
//	double G
//	double B
//	double A
//}

//struct uiDrawStrokeParams {
//	uiDrawLineCap Cap
//	uiDrawLineJoin Join
//	// TODO what if this is 0? on windows there will be a crash with dashing
//	double Thickness
//	double MiterLimit
//	double *Dashes
//	// TOOD what if this is 1 on Direct2D?
//	// TODO what if a dash is 0 on Cairo or Quartz?
//	size_t NumDashes
//	double DashPhase
//}

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

//struct uiFontDescriptor {
//	// TODO const-correct this or figure out how to deal with this when getting a value
//	char *Family
//	double Size
//	uiTextWeight Weight
//	uiTextItalic Italic
//	uiTextStretch Stretch
//}

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

//// TODO const-correct this somehow
//struct uiDrawTextLayoutParams {
//	uiAttributedString *String
//	uiFontDescriptor *DefaultFont
//	double Width
//	uiDrawTextAlign Align
//}

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

//// uiFontButton is a button that allows users to choose a font when they click on it.
typealias FontButton = CPointer<uiFontButton>

//// uiFontButtonFont() returns the font currently selected in the uiFontButton in desc.
//// uiFontButtonFont() allocates resources in desc when you are done with the font, call uiFreeFontButtonFont() to release them.
//// uiFontButtonFont() does not allocate desc itself you must do so.
//// TODO have a function that sets an entire font descriptor to a range in a uiAttributedString at once, for SetFont?
//void uiFontButtonFont(uiFontButton *b, uiFontDescriptor *desc)
//// TOOD SetFont, mechanics
//// uiFontButtonOnChanged() sets the function that is called when the font in the uiFontButton is changed.
//void uiFontButtonOnChanged(uiFontButton *b, void (*f)(uiFontButton *, void *), void *data)
//// uiNewFontButton() creates a new uiFontButton. The default font selected into the uiFontButton is OS-defined.
//uiFontButton *uiNewFontButton(void)
//// uiFreeFontButtonFont() frees resources allocated in desc by uiFontButtonFont().
//// After calling uiFreeFontButtonFont(), the contents of desc should be assumed to be undefined (though since you allocate desc itself, you can safely reuse desc for other font descriptors).
//// Calling uiFreeFontButtonFont() on a uiFontDescriptor not returned by uiFontButtonFont() results in undefined behavior.
//void uiFreeFontButtonFont(uiFontDescriptor *desc)

//// TODO document drag captures
//struct uiAreaMouseEvent {
//	// TODO document what these mean for scrolling areas
//	double X
//	double Y

//	// TODO see draw above
//	double AreaWidth
//	double AreaHeight

//	int Down
//	int Up

//	int Count

//	uiModifiers Modifiers

//	uint64_t Held1To64
//}

//struct uiAreaKeyEvent {
//	char Key
//	uiExtKey ExtKey
//	uiModifiers Modifier

//	uiModifiers Modifiers

//	int Up
//}

typealias ColorButton = CPointer<uiColorButton>

//void uiColorButtonColor(uiColorButton *b, double *r, double *g, double *bl, double *a)
//void uiColorButtonSetColor(uiColorButton *b, double r, double g, double bl, double a)
//void uiColorButtonOnChanged(uiColorButton *b, void (*f)(uiColorButton *, void *), void *data)
//uiColorButton *uiNewColorButton(void)

typealias Form = CPointer<uiForm>

//void uiFormAppend(uiForm *f, const char *label, uiControl *c, int stretchy)
//void uiFormDelete(uiForm *f, int index)
//int uiFormPadded(uiForm *f)
//void uiFormSetPadded(uiForm *f, int padded)
//uiForm *uiNewForm(void)

typealias Grid = CPointer<uiGrid>

//void uiGridAppend(uiGrid *g, uiControl *c, int left, int top, int xspan, int yspan, int hexpand, uiAlign halign, int vexpand, uiAlign valign)
//void uiGridInsertAt(uiGrid *g, uiControl *c, uiControl *existing, uiAt at, int xspan, int yspan, int hexpand, uiAlign halign, int vexpand, uiAlign valign)
//int uiGridPadded(uiGrid *g)
//void uiGridSetPadded(uiGrid *g, int padded)
//uiGrid *uiNewGrid(void)
