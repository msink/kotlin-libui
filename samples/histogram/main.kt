import kotlinx.cinterop.*
import platform.posix.*
import libui.*

// histogram margins
const val xoffLeft          = 20            
const val yoffTop           = 20
const val xoffRight         = 20
const val yoffBottom        = 20
const val pointRadius       = 5

// and some colors
const val colorWhite        = 0xFFFFFF
const val colorBlack        = 0x000000
const val colorDodgerBlue   = 0x1E90FF

fun main(args: Array<String>) = application {

    Window("libui Histogram Example", 640, 480) {
        margined = true
        onClose { uiQuit(); true }
        onShouldQuit { destroy(); true }

        setChild(HorizontalBox() {
            padded = true

            srand(time(null).narrow())
            val datapoints = Array(10) { Spinbox(0, 100) { value = rand() % 101 } }
            val colorButton = ColorButton() { color = RGBA(colorDodgerBlue) }
//          var currentPoint = -1

            val histogram = Area(AreaHandler(
            draw = { /*params ->
                fun setSolidBrush(uiDrawBrush *brush, uint32_t color, double alpha) {
                    uint8_t component

                    brush->Type = uiDrawBrushTypeSolid
                    component = (uint8_t) ((color >> 16) & 0xFF)
                    brush->R = ((double) component) / 255
                    component = (uint8_t) ((color >> 8) & 0xFF)
                    brush->G = ((double) component) / 255
                    component = (uint8_t) (color & 0xFF)
                    brush->B = ((double) component) / 255
                    brush->A = alpha
                }

                fun pointLocations(double width, double height, double *xs, double *ys) {
                    double xincr, yincr
                    int i, n

                    xincr = width / 9        // 10 - 1 to make the last point be at the end
                    yincr = height / 100

                    for (i = 0 i < 10 i++) {
                        // get the value of the point
                        n = uiSpinboxValue(datapoints[i])
                        // because y=0 is the top but n=0 is the bottom, we need to flip
                        n = 100 - n
                        xs[i] = xincr * i
                        ys[i] = yincr * n
                    }
                }

                fun constructGraph(double width, double height, int extend): CPointer<uiDrawPath> {
                    uiDrawPath *path
                    double xs[10], ys[10]
                    int i

                    pointLocations(width, height, xs, ys)

                    path = uiDrawNewPath(uiDrawFillModeWinding)

                    uiDrawPathNewFigure(path, xs[0], ys[0])
                    for (i = 1 i < 10 i++)
                        uiDrawPathLineTo(path, xs[i], ys[i])

                    if (extend) {
                        uiDrawPathLineTo(path, width, height)
                        uiDrawPathLineTo(path, 0, height)
                        uiDrawPathCloseFigure(path)
                    }

                    uiDrawPathEnd(path)
                    return path
                }

                fun graphSize(double clientWidth, double clientHeight, double *graphWidth, double *graphHeight) {
                    *graphWidth = clientWidth - xoffLeft - xoffRight
                    *graphHeight = clientHeight - yoffTop - yoffBottom
                }

                uiDrawPath *path
                uiDrawBrush brush
                uiDrawStrokeParams sp
                uiDrawMatrix m
                double graphWidth, graphHeight
                double graphR, graphG, graphB, graphA

                // fill the area with white
                setSolidBrush(&brush, colorWhite, 1.0)
                path = uiDrawNewPath(uiDrawFillModeWinding)
                uiDrawPathAddRectangle(path, 0, 0, params.AreaWidth, params.AreaHeight)
                uiDrawPathEnd(path)
                uiDrawFill(params.Context, path, &brush)
                uiDrawFreePath(path)

                // figure out dimensions
                graphSize(params.AreaWidth, params.AreaHeight, &graphWidth, &graphHeight)

                // clear sp to avoid passing garbage to uiDrawStroke()
                // for example, we don't use dashing
                memset(&sp, 0, sizeof (uiDrawStrokeParams))

                // make a stroke for both the axes and the histogram line
                sp.Cap = uiDrawLineCapFlat
                sp.Join = uiDrawLineJoinMiter
                sp.Thickness = 2
                sp.MiterLimit = uiDrawDefaultMiterLimit

                // draw the axes
                setSolidBrush(&brush, colorBlack, 1.0)
                path = uiDrawNewPath(uiDrawFillModeWinding)
                uiDrawPathNewFigure(path,
                    xoffLeft, yoffTop)
                uiDrawPathLineTo(path,
                    xoffLeft, yoffTop + graphHeight)
                uiDrawPathLineTo(path,
                    xoffLeft + graphWidth, yoffTop + graphHeight)
                uiDrawPathEnd(path)
                uiDrawStroke(params.Context, path, &brush, &sp)
                uiDrawFreePath(path)

                // now transform the coordinate space so (0, 0) is the top-left corner of the graph
                uiDrawMatrixSetIdentity(&m)
                uiDrawMatrixTranslate(&m, xoffLeft, yoffTop)
                uiDrawTransform(params.Context, &m)

                // now get the color for the graph itself and set up the brush
                uiColorButtonColor(colorButton, &graphR, &graphG, &graphB, &graphA)
                brush.Type = uiDrawBrushTypeSolid
                brush.R = graphR
                brush.G = graphG
                brush.B = graphB
                // we set brush->A below to different values for the fill and stroke

                // now create the fill for the graph below the graph line
                path = constructGraph(graphWidth, graphHeight, 1)
                brush.A = graphA / 2
                uiDrawFill(params.Context, path, &brush)
                uiDrawFreePath(path)

                // now draw the histogram line
                path = constructGraph(graphWidth, graphHeight, 0)
                brush.A = graphA
                uiDrawStroke(params.Context, path, &brush, &sp)
                uiDrawFreePath(path)

                // now draw the point being hovered over
                if (currentPoint != -1) {
                    double xs[10], ys[10]
                
                    pointLocations(graphWidth, graphHeight, xs, ys)
                    path = uiDrawNewPath(uiDrawFillModeWinding)
                    uiDrawPathNewFigureWithArc(path,
                        xs[currentPoint], ys[currentPoint],
                        pointRadius,
                        0, 6.23,        // TODO pi
                        0)
                    uiDrawPathEnd(path)
                    // use the same brush as for the histogram lines
                    uiDrawFill(params.Context, path, &brush)
                    uiDrawFreePath(path)
                }
*/
            },

            mouseEvent = { /*event ->
                double graphWidth, graphHeight
                double xs[10], ys[10]
                int i

                fun inPoint(x: Double, y: Double, xtest: Double, ytest: Double): Boolean {
                    val xx = x - xoffLeft
                    val yy = y - yoffTop
                    return (xx >= xtest - pointRadius)
                        && (xx <= xtest + pointRadius)
                        && (yy >= ytest - pointRadius)
                        && (yy <= ytest + pointRadius)
                }
                
                graphSize(event.AreaWidth, event.AreaHeight, &graphWidth, &graphHeight)
                pointLocations(graphWidth, graphHeight, xs, ys)
                
                for (i = 0 i < 10 i++)
                    if (inPoint(event.X, event.Y, xs[i], ys[i]))
                        break
                if (i == 10)        // not in a point
                    i = -1
                
                currentPoint = i
*/
                queueRedrawAll()
            }))

            append(VerticalBox() {
                padded = true
                datapoints.forEach {
                    it.action { histogram.queueRedrawAll() }
                    append(it)
                }
                colorButton.action { histogram.queueRedrawAll() }
                append(colorButton)
            })

            append(histogram, stretchy = true)
        })

        show()
    }
}
