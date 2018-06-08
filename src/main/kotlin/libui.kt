package libui

import kotlinx.cinterop.*

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

///////////////////////////////////////////////////////////

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
