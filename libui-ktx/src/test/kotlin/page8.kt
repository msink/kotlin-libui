/*
static void onListFonts(uiButton *b, void *data)
{
	uiDrawFontFamilies *ff
	char *this
	int i, n

	uiMultilineEntrySetText(uiMultilineEntry(data), "")
	ff = uiDrawListFontFamilies()
	n = uiDrawFontFamiliesNumFamilies(ff)
	for (i = 0 i < n i++) {
		this = uiDrawFontFamiliesFamily(ff, i)
		uiMultilineEntryAppend(uiMultilineEntry(data), this)
		uiMultilineEntryAppend(uiMultilineEntry(data), "\n")
		uiFreeText(this)
	}
	uiDrawFreeFontFamilies(ff)
}

uiBox *makePage8(void)
{
	uiBox *page8
	uiGroup *group
	uiBox *vbox
	uiMultilineEntry *me
	uiButton *button

	page8 = newHorizontalBox()

	group = newGroup("Font Families")
	uiBoxAppend(page8, group?.reinterpret(), 1)

	vbox = newVerticalBox()
	uiGroupSetChild(group, vbox?.reinterpret())

	me = uiNewMultilineEntry()
	uiBoxAppend(vbox, me?.reinterpret(), 1)

	button = uiNewButton("List Font Families")
	uiButtonOnClicked(button, onListFonts, me)
	uiBoxAppend(vbox, button?.reinterpret(), 0)

	return page8
}
*/