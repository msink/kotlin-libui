import kotlinx.cinterop.*
import libui.*

// TODOs
// - blank page affects menus negatively on Windows

var mainTab: CPointer<uiTab>? = null
var mainBox: CPointer<uiBox>? = null

//uiBox *(*newhbox)(void)
//uiBox *(*newvbox)(void)

fun main(args: Array<String>) = memScoped {
//	int nomenus = 0
//	int startspaced = 0
//	int steps = 0
//
//	newhbox = uiNewHorizontalBox
//	newvbox = uiNewVerticalBox
//
//	for (i = 1 i < argc i++)
//		if (strcmp(argv[i], "nomenus") == 0)
//			nomenus = 1
//		else if (strcmp(argv[i], "startspaced") == 0)
//			startspaced = 1
//		else if (strcmp(argv[i], "swaphv") == 0) {
//			newhbox = uiNewVerticalBox
//			newvbox = uiNewHorizontalBox
//		} else if (strcmp(argv[i], "steps") == 0)
//			steps = 1
//		else {
//			fprintf(stderr, "%s: unrecognized option %s\n", argv[0], argv[i])
//			return 1
//		}

	val o = alloc<uiInitOptions>()
	val err = uiInit(o.ptr)
	if (err != null) throw Error("Error: '${err.toKString()}'")

//	if (!nomenus)
//		initMenus()

    val w = uiNewWindow("Main Window", 320, 240, 1)

    fun onClosing(w: CPointer<uiWindow>?, data: COpaquePointer?): Int {
        uiQuit()
        return 1
    }
    uiWindowOnClosing(w, staticCFunction(::onClosing), null)
/*TODO
    fun onShouldQuit(data: COpaquePointer?): Int {
		if (uiMenuItemChecked(shouldQuitItem)) {
			uiControlDestroy(data?.reinterpret())
			return 1
		}
		return 0
	}
	uiOnShouldQuit(staticCFunction(::onShouldQuit), w)
*/
	val mainBox = uiNewHorizontalBox() //TODO newHorizontalBox()
	uiWindowSetChild(w, mainBox?.reinterpret())

	val outerTab = uiNewTab() //TODO newTab()
	uiBoxAppend(mainBox, outerTab?.reinterpret(), 1)

	mainTab = uiNewTab() //TODO newTab()
	uiTabAppend(outerTab, "Pages 1-5", mainTab?.reinterpret())

//	// page 1 uses page 2's uiGroup
//	val page2 = makePage2()
//
//	makePage1(w)
//	uiTabAppend(mainTab, "Page 1", page1?.reinterpret())
//
//	uiTabAppend(mainTab, "Page 2", page2?.reinterpret())

	uiTabAppend(mainTab, "Empty Page", uiNewHorizontalBox()?.reinterpret())

//	val page3 = makePage3()
//	uiTabAppend(mainTab, "Page 3", page3?.reinterpret())
//
//	val page4 = makePage4()
//	uiTabAppend(mainTab, "Page 4", page4?.reinterpret())
//
//	val page5 = makePage5(w)
//	uiTabAppend(mainTab, "Page 5", page5?.reinterpret())

	var innerTab = uiNewTab() //TODO newTab()
	uiTabAppend(outerTab, "Pages 6-10", innerTab?.reinterpret())

//	val page6 = makePage6()
//	uiTabAppend(innerTab, "Page 6", page6?.reinterpret())
//
//	val page7 = makePage7()
//	uiTabAppend(innerTab, "Page 7", page7?.reinterpret())
//
////	val page8 = makePage8()
////	uiTabAppend(innerTab, "Page 8", page8?.reinterpret())
//
////	val page9 = makePage9()
////	uiTabAppend(innerTab, "Page 9", page9?.reinterpret())
//
////	val page10 = makePage10()
////	uiTabAppend(innerTab, "Page 10", page10?.reinterpret())

	innerTab = uiNewTab() //TODO newTab()
	uiTabAppend(outerTab, "Pages 11-15", innerTab?.reinterpret())

////	val page11 = makePage11()
////	uiTabAppend(innerTab, "Page 11", page11?.reinterpret())
//
//	val page12 = makePage12()
//	uiTabAppend(innerTab, "Page 12", page12?.reinterpret())
//
//	val page13 = makePage13()
//	uiTabAppend(innerTab, "Page 13", page13?.reinterpret())
//
//	val page14 = makePage14()
//	uiTabAppend(innerTab, "Page 14", page14?.reinterpret())
//
//	val page15 = makePage15(w)
//	uiTabAppend(innerTab, "Page 15", page15?.reinterpret())

	innerTab = uiNewTab() //TODO newTab()
	uiTabAppend(outerTab, "Pages 16-?", innerTab?.reinterpret())

////	val page16 = makePage16()
////	uiTabAppend(innerTab, "Page 16", page16?.reinterpret())
//
//	if (startspaced)
//		setSpaced(1)
//
	uiControlShow(w?.reinterpret())
//	if (!steps)
		uiMain()
//	else {
//		uiMainSteps()
//		while (uiMainStep(1))
//			
//	}
	uiUninit()
}
