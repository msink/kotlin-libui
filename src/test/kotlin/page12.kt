/*
// TODO OS X: if the hboxes are empty, the text views don't show up

static void meChanged(uiMultilineEntry *e, void *data)
{
	printf("%s changed\n", (char *) data)
}

static void setClicked(uiButton *b, void *data)
{
	uiMultilineEntrySetText(uiMultilineEntry(data), "set")
}

static void appendClicked(uiButton *b, void *data)
{
	uiMultilineEntryAppend(uiMultilineEntry(data), "append\n")
}

static uiBox *half(uiMultilineEntry *(*mk)(void), const char *which)
{
	uiBox *vbox, *hbox
	uiMultilineEntry *me
	uiButton *button

	vbox = newVerticalBox()

	me = (*mk)()
	uiMultilineEntryOnChanged(me, meChanged, (void *) which)
	uiBoxAppend(vbox, me?.reinterpret(), 1)

	hbox = newHorizontalBox()
	uiBoxAppend(vbox, hbox?.reinterpret(), 0)

	button = uiNewButton("Set")
	uiButtonOnClicked(button, setClicked, me)
	uiBoxAppend(hbox, button?.reinterpret(), 0)

	button = uiNewButton("Append")
	uiButtonOnClicked(button, appendClicked, me)
	uiBoxAppend(hbox, button?.reinterpret(), 0)

	return vbox
}

uiBox *makePage12(void)
{
	uiBox *page12
	uiBox *b

	page12 = newHorizontalBox()

	b = half(uiNewMultilineEntry, "wrap")
	uiBoxAppend(page12, b?.reinterpret(), 1)
	b = half(uiNewNonWrappingMultilineEntry, "no wrap")
	uiBoxAppend(page12, b?.reinterpret(), 1)

	return page12
}
*/