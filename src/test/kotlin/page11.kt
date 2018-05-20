/*
// TODO add a test for childless windows
// TODO add tests for contianers with all controls hidden

static uiGroup *newg(const char *n, int s)
{
	uiGroup *g

	g = uiNewGroup(n)
	if (s)
		uiGroupSetChild(g, NULL)
	return g
}

static uiTab *newt(int tt)
{
	uiTab *t

	t = uiNewTab()
	if (tt)
		uiTabAppend(t, "Test", NULL)
	return t
}

uiBox *makePage11(void)
{
	uiBox *page11
	uiBox *ns
	uiBox *s

	page11 = newHorizontalBox()

	ns = newVerticalBox()
	uiBoxAppend(ns, newg("", 0?.reinterpret()), 0)
	uiBoxAppend(ns, newg("", 1?.reinterpret()), 0)
	uiBoxAppend(ns, newg("Group", 0?.reinterpret()), 0)
	uiBoxAppend(ns, newg("Group", 1?.reinterpret()), 0)
	uiBoxAppend(ns, newt(0?.reinterpret()), 0)
	uiBoxAppend(ns, newt(1?.reinterpret()), 0)
	uiBoxAppend(page11, ns?.reinterpret(), 1)

	s = newVerticalBox()
	uiBoxAppend(s, newg("", 0?.reinterpret()), 1)
	uiBoxAppend(s, newg("", 1?.reinterpret()), 1)
	uiBoxAppend(s, newg("Group", 0?.reinterpret()), 1)
	uiBoxAppend(s, newg("Group", 1?.reinterpret()), 1)
	uiBoxAppend(s, newt(0?.reinterpret()), 1)
	uiBoxAppend(s, newt(1?.reinterpret()), 1)
	uiBoxAppend(page11, s?.reinterpret(), 1)

	return page11
}
*/