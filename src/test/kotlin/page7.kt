/*
uiBox *makePage7(void)
{
	uiBox *page7
	uiGroup *group
	uiBox *box2

	page7 = newHorizontalBox()

	group = makePage7a()
	uiBoxAppend(page7, group?.reinterpret(), 1)

	box2 = newVerticalBox()
	uiBoxAppend(page7, box2?.reinterpret(), 1)

	group = makePage7b()
	uiBoxAppend(box2, group?.reinterpret(), 1)

	group = makePage7c()
	uiBoxAppend(box2, group?.reinterpret(), 1)

	return page7
}
*/