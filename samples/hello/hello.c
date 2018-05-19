#include <string.h>
#include <stdlib.h>
#include <time.h>
#include "../../ui.h"

int onClosing(uiWindow *w, void *data)
{
	uiQuit();
	return 1;
}

void saySomething(uiButton *b, void *e)
{
	uiMultilineEntryAppend(uiMultilineEntry(e),
        "Hello, World!  Ciao, mondo!\n"
        "Привет, мир!  你好，世界！\n\n");
}

int main(void)
{
	uiInitOptions o;
	uiWindow *w;
	uiBox *b;
	uiButton *btn;
    uiMultilineEntry *e;

	memset(&o, 0, sizeof (uiInitOptions));
	if (uiInit(&o) != NULL)
		abort();

	w = uiNewWindow("Hello", 320, 240, 0);
	uiWindowSetMargined(w, 1);

	b = uiNewVerticalBox();
	uiBoxSetPadded(b, 1);
	uiWindowSetChild(w, uiControl(b));

	e = uiNewMultilineEntry();
	uiMultilineEntrySetReadOnly(e, 1);

	btn = uiNewButton("libui говорит: click me!");
	uiButtonOnClicked(btn, saySomething, e);
	uiBoxAppend(b, uiControl(btn), 0);

	uiBoxAppend(b, uiControl(e), 1);

	uiWindowOnClosing(w, onClosing, NULL);
	uiControlShow(uiControl(w));
	uiMain();
	return 0;
}
