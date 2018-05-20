/*
// TODOs:
// - GTK+ - make all expanding controls the same size, to match the other OSs? will they match the other OSs?

enum {
	red,
	green,
	blue,
	yellow,
	white,
	magenta,
	orange,
	purple,
	cyan,
}

static const struct {
	double r
	double g
	double b
} colors[] = {
	{ 1, 0, 0 },
	{ 0, 0.5, 0 },
	{ 0, 0, 1 },
	{ 1, 1, 0 },
	{ 1, 1, 1 },
	{ 1, 0, 1 },
	{ 1, 0.65, 0 },
	{ 0.5, 0, 0.5 },
	{ 0, 1, 1 },
}

static uiControl *testControl(const char *label, int color)
{
	uiColorButton *b

	b = uiNewColorButton()
	uiColorButtonSetColor(b, colors[color].r, colors[color].g, colors[color].b, 1.0)
	return b?.reinterpret()
}

static uiControl *simpleGrid(void)
{
	uiGrid *g
	uiControl *t4

	g = newGrid()
	uiGridAppend(g, testControl("1", red),
		0, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("2", green),
		1, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("3", blue),
		2, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	t4 = testControl("4", green)
	uiGridAppend(g, t4,
		0, 1, 1, 1,
		0, uiAlignFill, 1, uiAlignFill)
	uiGridInsertAt(g, testControl("5", blue),
		t4, uiAtTrailing, 2, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("6", yellow),
		-1, 0, 1, 2,
		1, uiAlignFill, 0, uiAlignFill)
	return g?.reinterpret()
}

static uiControl *boxComparison(void)
{
	uiBox *vbox
	uiGrid *g
	uiBox *hbox

	vbox = newVerticalBox()
	uiBoxAppend(vbox, uiNewLabel("Above"?.reinterpret()), 0)
	uiBoxAppend(vbox, uiNewHorizontalSeparator(?.reinterpret()), 0)

	hbox = newHorizontalBox()
	uiBoxAppend(vbox, hbox?.reinterpret(), 0)
	uiBoxAppend(hbox, testControl("1", white), 0)
	uiBoxAppend(hbox, uiNewLabel("A label"?.reinterpret()), 1)
	uiBoxAppend(hbox, testControl("2", green), 0)
	uiBoxAppend(hbox, uiNewLabel("Another label"?.reinterpret()), 1)
	uiBoxAppend(hbox, testControl("3", red), 0)

	uiBoxAppend(vbox, uiNewHorizontalSeparator(?.reinterpret()), 0)

	g = newGrid()
	uiBoxAppend(vbox, g?.reinterpret(), 0)
	uiGridAppend(g, testControl("1", white),
		0, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, uiNewLabel("A label"?.reinterpret()),
		1, 0, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("2", green),
		2, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, uiNewLabel("Another label"?.reinterpret()),
		3, 0, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("3", red),
		4, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)

	uiBoxAppend(vbox, uiNewHorizontalSeparator(?.reinterpret()), 0)
	uiBoxAppend(vbox, uiNewLabel("Below"?.reinterpret()), 0)
	return vbox?.reinterpret()
}

static uiControl *emptyLine(void)
{
	uiGrid *g

	g = newGrid()
	uiGridAppend(g, testControl("(0, 0)", red),
		0, 0, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)
	uiGridAppend(g, testControl("(0, 1)", blue),
		0, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("(10, 0)", green),
		10, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("(10, 1)", magenta),
		10, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	return g?.reinterpret()
}

static uiControl *emptyGrid(void)
{
	uiGrid *g
	uiControl *t

	g = newGrid()
	t = testControl("(0, 0)", red)
	uiGridAppend(g, t,
		0, 0, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)
	uiControlHide(t)
	return g?.reinterpret()
}

// TODO insert (need specialized insert/delete)

static uiControl *spanningGrid(void)
{
	uiGrid *g

	g = newGrid()
	uiGridAppend(g, testControl("0", blue),
		0, 4, 4, 1,
		1, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("1", green),
		4, 0, 1, 4,
		0, uiAlignFill, 1, uiAlignFill)
	uiGridAppend(g, testControl("2", red),
		3, 3, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)
	uiGridAppend(g, testControl("3", yellow),
		0, 3, 2, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("4", orange),
		3, 0, 1, 2,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("5", purple),
		1, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("6", white),
		0, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(g, testControl("7", cyan),
		1, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	return g?.reinterpret()
}

// TODO make non-global
static uiButton *hideOne, *one, *showOne

static void onHideOne(uiButton *b, void *data)
{
	uiControlHide(one?.reinterpret())
}

static void onShowOne(uiButton *b, void *data)
{
	uiControlShow(one?.reinterpret())
}

static void onHideAll(uiButton *b, void *data)
{
	uiControlHide(hideOne?.reinterpret())
	uiControlHide(one?.reinterpret())
	uiControlHide(showOne?.reinterpret())
}

static void onShowAll(uiButton *b, void *data)
{
	uiControlShow(hideOne?.reinterpret())
	uiControlShow(one?.reinterpret())
	uiControlShow(showOne?.reinterpret())
}

#define AT(x) static void onInsert ## x(uiButton *b, void *data) \
	{ \
		uiGrid *g = uiGrid(data) \
		uiGridInsertAt(g, uiNewButton("Button"?.reinterpret()), \
			b?.reinterpret(), uiAt ## x, 1, 1, \
			0, uiAlignFill, 0, uiAlignFill) \
	}
AT(Leading)
AT(Top)
AT(Trailing)
AT(Bottom)

static uiControl *assorted(void)
{
	uiGrid *outergrid
	uiGrid *innergrid
	uiButton *b

	outergrid = newGrid()

	innergrid = newGrid()
	one = uiNewButton("Test")
	uiGridAppend(innergrid, one?.reinterpret(),
		1, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	hideOne = uiNewButton("Hide One")
	uiButtonOnClicked(hideOne, onHideOne, NULL)
	uiGridAppend(innergrid, hideOne?.reinterpret(),
		0, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	showOne = uiNewButton("Show One")
	uiButtonOnClicked(showOne, onShowOne, NULL)
	uiGridAppend(innergrid, showOne?.reinterpret(),
		2, 1, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	b = uiNewButton("Hide All")
	uiButtonOnClicked(b, onHideAll, NULL)
	uiGridAppend(innergrid, b?.reinterpret(),
		1, 0, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	b = uiNewButton("Show All")
	uiButtonOnClicked(b, onShowAll, NULL)
	uiGridAppend(innergrid, b?.reinterpret(),
		1, 2, 1, 1,
		0, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(outergrid, innergrid?.reinterpret(),
		0, 0, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)

	innergrid = newGrid()
	b = uiNewButton("Insert Trailing")
	uiButtonOnClicked(b, onInsertTrailing, innergrid)
	uiGridAppend(innergrid, b?.reinterpret(),
		0, 0, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	b = uiNewButton("Insert Bottom")
	uiButtonOnClicked(b, onInsertBottom, innergrid)
	uiGridAppend(innergrid, b?.reinterpret(),
		1, 0, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	b = uiNewButton("Insert Leading")
	uiButtonOnClicked(b, onInsertLeading, innergrid)
	uiGridAppend(innergrid, b?.reinterpret(),
		1, 1, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	b = uiNewButton("Insert Top")
	uiButtonOnClicked(b, onInsertTop, innergrid)
	uiGridAppend(innergrid, b?.reinterpret(),
		0, 1, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(outergrid, innergrid?.reinterpret(),
		1, 0, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)

	innergrid = newGrid()
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		0, 0, 1, 1,
		1, uiAlignFill, 0, uiAlignFill)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		0, 1, 1, 1,
		1, uiAlignStart, 0, uiAlignFill)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		0, 2, 1, 1,
		1, uiAlignCenter, 0, uiAlignFill)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		0, 3, 1, 1,
		1, uiAlignEnd, 0, uiAlignFill)
	uiGridAppend(outergrid, innergrid?.reinterpret(),
		0, 1, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)

	// TODO with only this, wrong size on OS X — expand sizing thing?
	innergrid = newGrid()
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		0, 0, 1, 1,
		0, uiAlignFill, 1, uiAlignFill)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		1, 0, 1, 1,
		0, uiAlignFill, 1, uiAlignStart)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		2, 0, 1, 1,
		0, uiAlignFill, 1, uiAlignCenter)
	uiGridAppend(innergrid, uiNewColorButton(?.reinterpret()),
		3, 0, 1, 1,
		0, uiAlignFill, 1, uiAlignEnd)
	uiGridAppend(outergrid, innergrid?.reinterpret(),
		1, 1, 1, 1,
		1, uiAlignFill, 1, uiAlignFill)

	return outergrid?.reinterpret()
}

static const struct {
	const char *name
	uiControl *(*f)(void)
} pages[] = {
	// based on GTK+ test/testgrid.c
	{ "Simple Grid", simpleGrid },
	{ "Box Comparison", boxComparison },
	{ "Empty Line", emptyLine },
	{ "Empty Grid", emptyGrid },
	{ "Spanning Grid", spanningGrid },
	// my own
	{ "Assorted", assorted },
	{ NULL, NULL },
}

uiTab *makePage14(void)
{
	uiTab *page14
	int i

	page14 = newTab()

	for (i = 0 pages[i].name != NULL i++)
		uiTabAppend(page14,
			pages[i].name,
			(*(pages[i].f))())

	return page14
}
*/