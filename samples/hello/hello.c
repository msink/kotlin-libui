#include <string.h>
#include <stdlib.h>
#include "ui.h"

static int onClosing(uiWindow *window, void *data)
{
    uiQuit();
    return 1;
}

static void saySomething(uiButton *button, void *data)
{
    uiMultilineEntryAppend(uiMultilineEntry(data),
        "Hello, World!  Ciao, mondo!\n"
        "Привет, мир!  你好，世界！\n\n");
}

int main(void)
{
    uiInitOptions options;
    uiWindow *window;
    uiBox *box;
    uiButton *button;
    uiMultilineEntry *scroll;

    memset(&options, 0, sizeof(options));
    if (uiInit(&options) != NULL)
        abort();

    window = uiNewWindow("Hello", 320, 240, 0);
    uiWindowSetMargined(window, 1);

    box = uiNewVerticalBox();
    uiBoxSetPadded(box, 1);
    uiWindowSetChild(window, uiControl(box));

    scroll = uiNewMultilineEntry();
    uiMultilineEntrySetReadOnly(scroll, 1);

    button = uiNewButton("libui говорит: click me!");
    uiButtonOnClicked(button, saySomething, scroll);
    uiBoxAppend(box, uiControl(button), 0);

    uiBoxAppend(box, uiControl(scroll), 1);

    uiWindowOnClosing(window, onClosing, NULL);
    uiControlShow(uiControl(window));
    uiMain();
    return 0;
}
