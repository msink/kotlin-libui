[libui.ktx](../index.md) / [Path](./index.md)

# Path

`class Path : `[`Disposable`](../-disposable/index.md)`<`[`uiDrawPath`](../../libui/ui-draw-path.md)`>`

Represent a path that could be drawed on a [DrawContext](../-draw-context.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Path(mode: `[`uiDrawFillMode`](../../libui/ui-draw-fill-mode.md)`)`<br>Represent a path that could be drawed on a [DrawContext](../-draw-context.md) |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [arcTo](arc-to.md) | `fun arcTo(xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Boolean = false): Unit`<br>Adds an arc to the path which is centered at ([xCenter](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/xCenter), [yCenter](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/yCenter)) position with radius [radius](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/radius) starting at [startAngle](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/startAngle) and with sweep angle [sweep](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/sweep) going in the given direction by anticlockwise (defaulting to clockwise) as specified by [negative](arc-to.md#libui.ktx.Path$arcTo(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/negative). |
| [bezierTo](bezier-to.md) | `fun bezierTo(c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double): Unit`<br>Adds a cubic Bézier curve to the path. It requires three points. The first two points are control points and the third one is the end point. The starting point is the last point in the current path. |
| [closeFigure](close-figure.md) | `fun closeFigure(): Unit`<br>Causes the point of the pen to move back to the start of the current sub-path. It tries to draw a straight line from the current point to the start. If the shape has already been closed or has only one point, this function does nothing. It end the path. |
| [figure](figure.md) | `fun figure(x: Double, y: Double): Unit`<br>Starts a new figure at the specified point. Call this method when you want to create a new path. |
| [figureWithArc](figure-with-arc.md) | `fun figureWithArc(xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Boolean = false): Unit`<br>Starts a new figure and adds an arc to the path which is centered at ([xCenter](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/xCenter), [yCenter](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/yCenter)) position with radius [radius](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/radius) starting at [startAngle](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/startAngle) and with sweep angle [sweep](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/sweep) going in the given direction by anticlockwise (defaulting to clockwise) as specified by [negative](figure-with-arc.md#libui.ktx.Path$figureWithArc(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Boolean)/negative). |
| [lineTo](line-to.md) | `fun lineTo(x: Double, y: Double): Unit`<br>Connects the last point in the subpath to the x, y coordinates with a straight line. |
| [rectangle](rectangle.md) | `fun rectangle(x: Double, y: Double, width: Double, height: Double): Unit`<br>Creates a path for a rectangle at position (x, y) with a size that is determined by width and height. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
