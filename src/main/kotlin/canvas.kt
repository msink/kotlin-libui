package libui

import kotlinx.cinterop.*

data class RGBA(
    val R: Double,
    val G: Double,
    val B: Double,
    val A: Double = 1.0
)

fun RGBA(color: Int, alpha: Double = 1.0) = RGBA(
    R = ((color shr 16) and 255).toDouble() / 255,
    G = ((color shr 8) and 255).toDouble() / 255,
    B = ((color) and 255).toDouble() / 255,
    A = alpha
)

/*
static void handlerMouseCrossed(uiAreaHandler *ah, uiArea *a, int left)
{
    // do nothing
}

static void handlerDragBroken(uiAreaHandler *ah, uiArea *a)
{
    // do nothing
}

static int handlerKeyEvent(uiAreaHandler *ah, uiArea *a, uiAreaKeyEvent *e)
{
    // reject all keys
    return 0
}

    handler.Draw = 
    handler.MouseEvent = 
    handler.MouseCrossed = handlerMouseCrossed
    handler.DragBroken = handlerDragBroken
    handler.KeyEvent = handlerKeyEvent
*/
