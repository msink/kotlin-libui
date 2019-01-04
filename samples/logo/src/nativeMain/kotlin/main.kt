import kotlin.math.PI
import libui.*
import libui.ktx.*
import libui.ktx.draw.*

fun main(args: Array<String>) = appWindow(
    title = "Kotlin Logo (click to rotate)",
    width = 500,
    height = 500,
    margined = false
) {
    vbox {
        drawarea {
            stretchy = true

            val brush = brush()
            var angle = 0.0

            mouseEvent {
                if (it.Down != 0) {
                    angle += PI / 2.0
                    redraw()
                }
            }

            draw {
                fill(uiDrawFillModeWinding, brush.solid(0xFFFFFF)) {
                    rectangle(0.0, 0.0, it.AreaWidth, it.AreaHeight)
                }

                transform { scale(0.0, 0.0, it.AreaWidth / 60.0, it.AreaHeight / 60.0) }
                transform { rotate(30.0, 30.0, angle) }

                fill(
                    uiDrawFillModeWinding,
                    brush.linear(
                        Point(0.0, 60.0),
                        Point(30.0, 30.0),
                        0.0968 to Color(0x0095D5),
                        0.3007 to Color(0x238AD9),
                        0.6211 to Color(0x557BDE),
                        0.8643 to Color(0x7472E2),
                        1.0000 to Color(0x806EE3)
                    )
                ) {
                    figure(0.0, 60.0)
                    lineTo(30.1, 29.9)
                    lineTo(60.0, 60.0)
                    closeFigure()
                }

                fill(
                    uiDrawFillModeWinding,
                    brush.linear(
                        Point(10.0, 20.0),
                        Point(30.0, 0.0),
                        0.1183 to Color(0x0095D5),
                        0.4178 to Color(0x3C83DC),
                        0.6962 to Color(0x6D74E1),
                        0.8333 to Color(0x806EE3)
                    )
                ) {
                    figure(0.0, 0.0)
                    lineTo(30.1, 0.0)
                    lineTo(0.0, 32.5)
                    closeFigure()
                }

                fill(
                    uiDrawFillModeWinding,
                    brush.linear(
                        Point(0.0, 60.0),
                        Point(50.0, 10.0),
                        0.1075 to Color(0xC757BC),
                        0.2138 to Color(0xD0609A),
                        0.4254 to Color(0xE1725C),
                        0.6048 to Color(0xEE7E2F),
                        0.7430 to Color(0xF58613),
                        0.8232 to Color(0xF88909)
                    )
                ) {
                    figure(30.1, 0.0)
                    lineTo(0.0, 31.7)
                    lineTo(0.0, 60.0)
                    lineTo(30.1, 29.9)
                    lineTo(60.0, 0.0)
                    closeFigure()
                }
            }
        }
    }
}
