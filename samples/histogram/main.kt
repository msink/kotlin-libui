import libui.*

// histogram margins
const val xoffLeft          = 20.0
const val yoffTop           = 20.0
const val xoffRight         = 20.0
const val yoffBottom        = 20.0
const val pointRadius       = 5.0

// and some colors
const val colorWhite        = 0xFFFFFF
const val colorBlack        = 0x000000
const val colorDodgerBlue   = 0x1E90FF

fun graphWidth(clientWidth: Double): Double = clientWidth - xoffLeft - xoffRight
fun graphHeight(clientHeight: Double): Double = clientHeight - yoffTop - yoffBottom

fun main(args: Array<String>) = appWindow(
    title = "libui Histogram Example",
    width = 640,
    height = 480
) {
    add(widget = HorizontalBox {
        padded = true

        val datapoints = Array(10) { Spinbox(0, 100) { value = random() % 101 } }
        val colorButton = ColorButton() { value = Color(colorDodgerBlue) }
        var currentPoint = -1

        fun pointLocations(width: Double, height: Double, xs: DoubleArray, ys: DoubleArray) {
            val xincr = width / 9  // 10 - 1 to make the last point be at the end
            val yincr = height / 100
            for (i in 0 until 10) {
                // because y=0 is the top but n=0 is the bottom, we need to flip
                val n = 100 - datapoints[i].value
                xs[i] = xincr * i
                ys[i] = yincr * n
            }
        }

        val histogram = Area {
            val brush = DrawBrush()

            // make a stroke for both the axes and the histogram line
            val stroke = DrawStrokeParams {
                Cap = uiDrawLineCapFlat
                Join = uiDrawLineJoinMiter
                Thickness = 2.0
                MiterLimit = uiDrawDefaultMiterLimit
            }

            draw {
                val context = it.Context!!
                val graphWidth = graphWidth(it.AreaWidth)
                val graphHeight = graphHeight(it.AreaHeight)
                val graphColor = colorButton.value
                val xs = DoubleArray(10)
                val ys = DoubleArray(10)
                pointLocations(graphWidth, graphHeight, xs, ys)

                // fill the area with white
                context.fill(uiDrawFillModeWinding, brush.solid(colorWhite)) {
                    rectangle(0.0, 0.0, it.AreaWidth, it.AreaHeight)
                }

                // draw the axes
                context.stroke(uiDrawFillModeWinding, brush.solid(colorBlack), stroke) {
                    figure(xoffLeft, yoffTop)
                    lineTo(xoffLeft, yoffTop + graphHeight)
                    lineTo(xoffLeft + graphWidth, yoffTop + graphHeight)
                }

                // now transform the coordinate space so (0, 0) is the top-left corner of the graph
                context.transform {
                    translate(xoffLeft, yoffTop)
                }

                // now create the fill for the graph below the graph line
                context.fill(uiDrawFillModeWinding, brush.solid(graphColor, opacity = 0.5)) {
                    figure(xs[0], ys[0])
                    for (i in 1 until 10)
                        lineTo(xs[i], ys[i])
                    lineTo(graphWidth, graphHeight)
                    lineTo(0.0, graphHeight)
                    closeFigure()
                }

                // now draw the histogram line
                context.stroke(uiDrawFillModeWinding, brush.solid(graphColor), stroke) {
                    figure(xs[0], ys[0])
                    for (i in 1 until 10)
                        lineTo(xs[i], ys[i])
                }

                // now draw the point being hovered over
                if (currentPoint != -1) {
                    context.fill(uiDrawFillModeWinding, brush) {
                        figureWithArc(xs[currentPoint], ys[currentPoint], pointRadius,
                                      startAngle = 0.0, sweep = 6.23)
                    }
                }
            }

            mouseEvent {
                val graphWidth = graphWidth(it.AreaWidth)
                val graphHeight = graphHeight(it.AreaHeight)
                val x = it.X - xoffLeft
                val y = it.Y - yoffTop
                val xs = DoubleArray(10)
                val ys = DoubleArray(10)
                pointLocations(graphWidth, graphHeight, xs, ys)

                currentPoint = -1
                for (i in 0 until 10) {
                    if ((x >= xs[i] - pointRadius) &&
                        (x <= xs[i] + pointRadius) &&
                        (y >= ys[i] - pointRadius) &&
                        (y <= ys[i] + pointRadius)) {
                        currentPoint = i
                        break
                    }
                }

                queueRedrawAll()
            }
        }

        add(widget = VerticalBox {
            padded = true
            datapoints.forEach {
                it.action { histogram.queueRedrawAll() }
                add(widget = it)
            }
            colorButton.action { histogram.queueRedrawAll() }
            add(widget = colorButton)
        })

        add(widget = histogram, stretchy = true)
    })
}
