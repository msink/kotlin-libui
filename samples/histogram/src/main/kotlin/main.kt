import libui.*
import libui.ktx.*
import libui.ktx.draw.*

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

const val numPoints         = 10

fun main(args: Array<String>) = appWindow(
    title = "libui Histogram Example",
    width = 640,
    height = 480
) {
    hbox {
        lateinit var datapoints: Array<Spinbox>
        lateinit var colorButton: ColorButton
        lateinit var histogram: DrawArea
        var currentPoint = -1

        fun pointLocations(width: Double, height: Double, xs: DoubleArray, ys: DoubleArray) {
            val xincr = width / (numPoints - 1)  // to make the last point be at the end
            val yincr = height / 100
            repeat(numPoints) { i ->
                // because y=0 is the top but n=0 is the bottom, we need to flip
                val n = 100 - datapoints[i].value
                xs[i] = xincr * i
                ys[i] = yincr * n
            }
        }

        vbox {
            datapoints = Array(numPoints) {
                spinbox(0, 100) {
                    value = random() % 101
                    action {
                        histogram.redraw()
                    }
                }
            }
            colorButton = colorbutton {
                value = Color(colorDodgerBlue)
                action {
                    histogram.redraw()
                }
            }
        }

        histogram = drawarea {
            stretchy = true

            val brush = brush()

            // make a stroke for both the axes and the histogram line
            val stroke = stroke {
                Cap = uiDrawLineCapFlat
                Join = uiDrawLineJoinMiter
                Thickness = 2.0
                MiterLimit = uiDrawDefaultMiterLimit
            }

            draw {
                val graphWidth = graphWidth(it.AreaWidth)
                val graphHeight = graphHeight(it.AreaHeight)
                val graphColor = colorButton.value
                val xs = DoubleArray(numPoints)
                val ys = DoubleArray(numPoints)
                pointLocations(graphWidth, graphHeight, xs, ys)

                // fill the area with white
                fill(brush.solid(colorWhite)) {
                    rectangle(0.0, 0.0, it.AreaWidth, it.AreaHeight)
                }

                // draw the axes
                stroke(brush.solid(colorBlack), stroke) {
                    figure(xoffLeft, yoffTop)
                    lineTo(xoffLeft, yoffTop + graphHeight)
                    lineTo(xoffLeft + graphWidth, yoffTop + graphHeight)
                }

                // transform the coordinate space so (0, 0) is the top-left corner of the graph
                transform {
                    translate(xoffLeft, yoffTop)
                }

                // create the fill for the graph below the graph line
                fill(brush.solid(graphColor, opacity = 0.5)) {
                    figure(xs[0], ys[0])
                    for (i in 1 until numPoints)
                        lineTo(xs[i], ys[i])
                    lineTo(graphWidth, graphHeight)
                    lineTo(0.0, graphHeight)
                    closeFigure()
                }

                // draw the histogram line
                stroke(brush.solid(graphColor), stroke) {
                    figure(xs[0], ys[0])
                    for (i in 1 until numPoints)
                        lineTo(xs[i], ys[i])
                }

                // draw the point being hovered over
                if (currentPoint != -1) {
                    fill(brush) {
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
                val xs = DoubleArray(numPoints)
                val ys = DoubleArray(numPoints)
                pointLocations(graphWidth, graphHeight, xs, ys)

                currentPoint = -1
                repeat(numPoints) { i ->
                    if ((x >= xs[i] - pointRadius) &&
                        (x <= xs[i] + pointRadius) &&
                        (y >= ys[i] - pointRadius) &&
                        (y <= ys[i] + pointRadius)) {
                        currentPoint = i
                        return@repeat
                    }
                }

                redraw()
            }
        }
    }
}
