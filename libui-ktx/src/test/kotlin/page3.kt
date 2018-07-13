/*
static uiBox *makeSet(int omit, int hidden, int stretch)
{
	uiBox *hbox
	uiButton *buttons[4]

	// don't use newHorizontalBox()
	// the point of this test is to test hidden controls and padded
	hbox = (*newhbox)()
	uiBoxSetPadded(hbox, 1)
	if (omit != 0) {
		buttons[0] = uiNewButton("First")
		uiBoxAppend(hbox, buttons[0]?.reinterpret(), stretch)
	}
	if (omit != 1) {
		buttons[1] = uiNewButton("Second")
		uiBoxAppend(hbox, buttons[1]?.reinterpret(), stretch)
	}
	if (omit != 2) {
		buttons[2] = uiNewButton("Third")
		uiBoxAppend(hbox, buttons[2]?.reinterpret(), stretch)
	}
	if (omit != 3) {
		buttons[3] = uiNewButton("Fourth")
		uiBoxAppend(hbox, buttons[3]?.reinterpret(), stretch)
	}
	if (hidden != -1)
		uiControlHide(buttons[hidden]?.reinterpret())
	return hbox
}

uiBox *makePage3(void)
{
	uiBox *page3
	uiBox *hbox
	uiBox *hbox2
	uiBox *vbox
	int hidden

	page3 = newVerticalBox()

	// first the non-stretchy type
	for (hidden = 0 hidden < 4 hidden++) {
		// these two must stay unpadded as well, otherwise the test isn't meaningful
		hbox2 = (*newhbox)()
		vbox = (*newvbox)()
		// reference set
		hbox = makeSet(hidden, -1, 0)
		uiBoxAppend(vbox, hbox?.reinterpret(), 0)
		// real thing
		hbox = makeSet(-1, hidden, 0)
		uiBoxAppend(vbox, hbox?.reinterpret(), 0)
		// pack vbox in
		uiBoxAppend(hbox2, vbox?.reinterpret(), 0)
		// and have a button in there for showing right margins
		uiBoxAppend(hbox2, uiNewButton("Right Margin Test"?.reinterpret()), 1)
		uiBoxAppend(page3, hbox2?.reinterpret(), 0)
	}

	// then the stretchy type
	for (hidden = 0 hidden < 4 hidden++) {
		hbox = makeSet(-1, hidden, 1)
		uiBoxAppend(page3, hbox?.reinterpret(), 0)
	}

	return page3
}
*/