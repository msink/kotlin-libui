/*
uiGroup *page2group

static uiLabel *movingLabel
static uiBox *movingBoxes[2]
static int movingCurrent

static void moveLabel(uiButton *b, void *data)
{
	int from, to

	from = movingCurrent
	to = 0
	if (from == 0)
		to = 1
	uiBoxDelete(movingBoxes[from], 0)
	uiBoxAppend(movingBoxes[to], movingLabel?.reinterpret(), 0)
	movingCurrent = to
}

static int moveBack
#define moveOutText "Move Page 1 Out"
#define moveBackText "Move Page 1 Back"

static void movePage1(uiButton *b, void *data)
{
	if (moveBack) {
		uiBoxDelete(mainBox, 1)
		uiTabInsertAt(mainTab, "Page 1", 0, page1?.reinterpret())
		uiButtonSetText(b, moveOutText)
		moveBack = 0
		return
	}
	uiTabDelete(mainTab, 0)
	uiBoxAppend(mainBox, page1?.reinterpret(), 1)
	uiButtonSetText(b, moveBackText)
	moveBack = 1
}

static void openAnotherWindow(uiButton *bb, void *data)
{
	uiWindow *w
	uiBox *b

	w = uiNewWindow("Another Window", 100, 100, data != NULL)
	if (data != NULL) {
		b = uiNewVerticalBox()
		uiBoxAppend(b, uiNewEntry(?.reinterpret()), 0)
		uiBoxAppend(b, uiNewButton("Button"?.reinterpret()), 0)
		uiBoxSetPadded(b, 1)
		uiWindowSetChild(w, b?.reinterpret())
	} else
		uiWindowSetChild(w, makePage6(?.reinterpret()))
	uiWindowSetMargined(w, 1)
	uiControlShow(w?.reinterpret())
}

static void openAnotherDisabledWindow(uiButton *b, void *data)
{
	uiWindow *w

	w = uiNewWindow("Another Window", 100, 100, data != NULL)
	uiControlDisable(w?.reinterpret())
	uiControlShow(w?.reinterpret())
}

#define SHED(method, Method) \
	static void method ## Control(uiButton *b, void *data) \
	{ \
		uiControl ## Method(data?.reinterpret()) \
	}
SHED(show, Show)
SHED(enable, Enable)
SHED(disable, Disable)

static void echoReadOnlyText(uiEntry *e, void *data)
{
	char *text

	text = uiEntryText(e)
	uiEntrySetText(uiEntry(data), text)
	uiFreeText(text)
}

uiBox *makePage2(void)
{
	uiBox *page2
	uiBox *hbox
	uiGroup *group
	uiBox *vbox
	uiButton *button
	uiBox *nestedBox
	uiBox *innerhbox
	uiBox *innerhbox2
	uiBox *innerhbox3
	uiTab *disabledTab
	uiEntry *entry
	uiEntry *readonly
	uiButton *button2

	page2 = newVerticalBox()

	group = newGroup("Moving Label")
	page2group = group
	uiBoxAppend(page2, group?.reinterpret(), 0)
	vbox = newVerticalBox()
	uiGroupSetChild(group, vbox?.reinterpret())

	hbox = newHorizontalBox()
	button = uiNewButton("Move the Label!")
	uiButtonOnClicked(button, moveLabel, NULL)
	uiBoxAppend(hbox, button?.reinterpret(), 1)
	// have a blank label for space
	uiBoxAppend(hbox, uiNewLabel(""?.reinterpret()), 1)
	uiBoxAppend(vbox, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	movingBoxes[0] = newVerticalBox()
	uiBoxAppend(hbox, movingBoxes[0]?.reinterpret(), 1)
	movingBoxes[1] = newVerticalBox()
	uiBoxAppend(hbox, movingBoxes[1]?.reinterpret(), 1)
	uiBoxAppend(vbox, hbox?.reinterpret(), 0)

	movingCurrent = 0
	movingLabel = uiNewLabel("This label moves!")
	uiBoxAppend(movingBoxes[movingCurrent], movingLabel?.reinterpret(), 0)

	hbox = newHorizontalBox()
	button = uiNewButton(moveOutText)
	uiButtonOnClicked(button, movePage1, NULL)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	uiBoxAppend(page2, hbox?.reinterpret(), 0)
	moveBack = 0

	hbox = newHorizontalBox()
	uiBoxAppend(hbox, uiNewLabel("Label Alignment Test"?.reinterpret()), 0)
	button = uiNewButton("Open Menued Window")
	uiButtonOnClicked(button, openAnotherWindow, button)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	button = uiNewButton("Open Menuless Window")
	uiButtonOnClicked(button, openAnotherWindow, NULL)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	button = uiNewButton("Disabled Menued")
	uiButtonOnClicked(button, openAnotherDisabledWindow, button)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	button = uiNewButton("Disabled Menuless")
	uiButtonOnClicked(button, openAnotherDisabledWindow, NULL)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	uiBoxAppend(page2, hbox?.reinterpret(), 0)

	nestedBox = newHorizontalBox()
	innerhbox = newHorizontalBox()
	uiBoxAppend(innerhbox, uiNewButton("These"?.reinterpret()), 0)
	button = uiNewButton("buttons")
	uiControlDisable(button?.reinterpret())
	uiBoxAppend(innerhbox, button?.reinterpret(), 0)
	uiBoxAppend(nestedBox, innerhbox?.reinterpret(), 0)
	innerhbox = newHorizontalBox()
	uiBoxAppend(innerhbox, uiNewButton("are"?.reinterpret()), 0)
	innerhbox2 = newHorizontalBox()
	button = uiNewButton("in")
	uiControlDisable(button?.reinterpret())
	uiBoxAppend(innerhbox2, button?.reinterpret(), 0)
	uiBoxAppend(innerhbox, innerhbox2?.reinterpret(), 0)
	uiBoxAppend(nestedBox, innerhbox?.reinterpret(), 0)
	innerhbox = newHorizontalBox()
	innerhbox2 = newHorizontalBox()
	uiBoxAppend(innerhbox2, uiNewButton("nested"?.reinterpret()), 0)
	innerhbox3 = newHorizontalBox()
	button = uiNewButton("boxes")
	uiControlDisable(button?.reinterpret())
	uiBoxAppend(innerhbox3, button?.reinterpret(), 0)
	uiBoxAppend(innerhbox2, innerhbox3?.reinterpret(), 0)
	uiBoxAppend(innerhbox, innerhbox2?.reinterpret(), 0)
	uiBoxAppend(nestedBox, innerhbox?.reinterpret(), 0)
	uiBoxAppend(page2, nestedBox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	button = uiNewButton("Enable Nested Box")
	uiButtonOnClicked(button, enableControl, nestedBox)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	button = uiNewButton("Disable Nested Box")
	uiButtonOnClicked(button, disableControl, nestedBox)
	uiBoxAppend(hbox, button?.reinterpret(), 0)
	uiBoxAppend(page2, hbox?.reinterpret(), 0)

	disabledTab = newTab()
	uiTabAppend(disabledTab, "Disabled", uiNewButton("Button"?.reinterpret()))
	uiTabAppend(disabledTab, "Tab", uiNewLabel("Label"?.reinterpret()))
	uiControlDisable(disabledTab?.reinterpret())
	uiBoxAppend(page2, disabledTab?.reinterpret(), 1)

	entry = uiNewEntry()
	readonly = uiNewEntry()
	uiEntryOnChanged(entry, echoReadOnlyText, readonly)
	uiEntrySetText(readonly, "If you can see this, uiEntryReadOnly() isn't working properly.")
	uiEntrySetReadOnly(readonly, 1)
	if (uiEntryReadOnly(readonly))
		uiEntrySetText(readonly, "")
	uiBoxAppend(page2, entry?.reinterpret(), 0)
	uiBoxAppend(page2, readonly?.reinterpret(), 0)

	hbox = newHorizontalBox()
	button = uiNewButton("Show Button 2")
	button2 = uiNewButton("Button 2")
	uiButtonOnClicked(button, showControl, button2)
	uiControlHide(button2?.reinterpret())
	uiBoxAppend(hbox, button?.reinterpret(), 1)
	uiBoxAppend(hbox, button2?.reinterpret(), 0)
	uiBoxAppend(page2, hbox?.reinterpret(), 0)

	return page2
}
*/