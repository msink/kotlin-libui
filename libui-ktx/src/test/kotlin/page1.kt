/*
static uiEntry *entry
static uiCheckbox *spaced

#define TEXT(name, type, getter, setter) \
	static void get ## name ## Text(uiButton *b, void *data) \
	{ \
		char *text \
		text = getter(type(data)) \
		uiEntrySetText(entry, text) \
		uiFreeText(text) \
	} \
	static void set ## name ## Text(uiButton *b, void *data) \
	{ \
		char *text \
		text = uiEntryText(entry) \
		setter(type(data), text) \
		uiFreeText(text) \
	}
TEXT(Window, uiWindow, uiWindowTitle, uiWindowSetTitle)
TEXT(Button, uiButton, uiButtonText, uiButtonSetText)
TEXT(Checkbox, uiCheckbox, uiCheckboxText, uiCheckboxSetText)
TEXT(Label, uiLabel, uiLabelText, uiLabelSetText)
TEXT(Group, uiGroup, uiGroupTitle, uiGroupSetTitle)

static void onChanged(uiEntry *e, void *data)
{
	printf("onChanged()\n")
}

static void toggleSpaced(uiCheckbox *c, void *data)
{
	setSpaced(uiCheckboxChecked(spaced))
}

static void forceSpaced(uiButton *b, void *data)
{
	uiCheckboxSetChecked(spaced, data != NULL)
}

static void showSpaced(uiButton *b, void *data)
{
	char s[12]

	querySpaced(s)
	uiEntrySetText(entry, s)
}

#define SHED(method, Method) \
	static void method ## Control(uiButton *b, void *data) \
	{ \
		uiControl ## Method(data?.reinterpret()) \
	}
SHED(show, Show)
SHED(hide, Hide)
SHED(enable, Enable)
SHED(disable, Disable)

uiBox *page1

void makePage1(uiWindow *w)
{
	uiButton *getButton, *setButton
	uiBox *hbox
	uiBox *testBox
	uiLabel *label

	page1 = newVerticalBox()

	entry = uiNewEntry()
	uiEntryOnChanged(entry, onChanged, NULL)
	uiBoxAppend(page1, entry?.reinterpret(), 0)

	spaced = uiNewCheckbox("Spaced")
	uiCheckboxOnToggled(spaced, toggleSpaced, NULL)
	label = uiNewLabel("Label")

	hbox = newHorizontalBox()
	getButton = uiNewButton("Get Window Text")
	uiButtonOnClicked(getButton, getWindowText, w)
	setButton = uiNewButton("Set Window Text")
	uiButtonOnClicked(setButton, setWindowText, w)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(hbox, setButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	getButton = uiNewButton("Get Button Text")
	uiButtonOnClicked(getButton, getButtonText, getButton)
	setButton = uiNewButton("Set Button Text")
	uiButtonOnClicked(setButton, setButtonText, getButton)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(hbox, setButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	getButton = uiNewButton("Get Checkbox Text")
	uiButtonOnClicked(getButton, getCheckboxText, spaced)
	setButton = uiNewButton("Set Checkbox Text")
	uiButtonOnClicked(setButton, setCheckboxText, spaced)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(hbox, setButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	getButton = uiNewButton("Get Label Text")
	uiButtonOnClicked(getButton, getLabelText, label)
	setButton = uiNewButton("Set Label Text")
	uiButtonOnClicked(setButton, setLabelText, label)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(hbox, setButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	getButton = uiNewButton("Get Group Text")
	uiButtonOnClicked(getButton, getGroupText, page2group)
	setButton = uiNewButton("Set Group Text")
	uiButtonOnClicked(setButton, setGroupText, page2group)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(hbox, setButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	uiBoxAppend(hbox, spaced?.reinterpret(), 1)
	getButton = uiNewButton("On")
	uiButtonOnClicked(getButton, forceSpaced, getButton)
	uiBoxAppend(hbox, getButton?.reinterpret(), 0)
	getButton = uiNewButton("Off")
	uiButtonOnClicked(getButton, forceSpaced, NULL)
	uiBoxAppend(hbox, getButton?.reinterpret(), 0)
	getButton = uiNewButton("Show")
	uiButtonOnClicked(getButton, showSpaced, NULL)
	uiBoxAppend(hbox, getButton?.reinterpret(), 0)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	testBox = newHorizontalBox()
	setButton = uiNewButton("Button")
	uiBoxAppend(testBox, setButton?.reinterpret(), 1)
	getButton = uiNewButton("Show")
	uiButtonOnClicked(getButton, showControl, setButton)
	uiBoxAppend(testBox, getButton?.reinterpret(), 0)
	getButton = uiNewButton("Hide")
	uiButtonOnClicked(getButton, hideControl, setButton)
	uiBoxAppend(testBox, getButton?.reinterpret(), 0)
	getButton = uiNewButton("Enable")
	uiButtonOnClicked(getButton, enableControl, setButton)
	uiBoxAppend(testBox, getButton?.reinterpret(), 0)
	getButton = uiNewButton("Disable")
	uiButtonOnClicked(getButton, disableControl, setButton)
	uiBoxAppend(testBox, getButton?.reinterpret(), 0)
	uiBoxAppend(page1, testBox?.reinterpret(), 0)

	hbox = newHorizontalBox()
	getButton = uiNewButton("Show Box")
	uiButtonOnClicked(getButton, showControl, testBox)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	getButton = uiNewButton("Hide Box")
	uiButtonOnClicked(getButton, hideControl, testBox)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	getButton = uiNewButton("Enable Box")
	uiButtonOnClicked(getButton, enableControl, testBox)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	getButton = uiNewButton("Disable Box")
	uiButtonOnClicked(getButton, disableControl, testBox)
	uiBoxAppend(hbox, getButton?.reinterpret(), 1)
	uiBoxAppend(page1, hbox?.reinterpret(), 0)

	uiBoxAppend(page1, label?.reinterpret(), 0)
}
*/