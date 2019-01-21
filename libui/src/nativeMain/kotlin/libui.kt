// SPDX-License-Identifier: MIT OR Apache-2.0

package libui.ktx

import kotlinx.cinterop.*
import libui.*

//void uiMain(void)
//void uiMainSteps(void)
//int uiMainStep(int wait)
//void uiQuit(void)

//void uiQueueMain(void (*f)(void *data), void *data)

//void uiFreeText(char *text);

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
