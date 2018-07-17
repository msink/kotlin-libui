[libui.ktx](../index.md) / [Path](index.md) / [arcTo](./arc-to.md)

# arcTo

`fun arcTo(xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Boolean = false): Unit`

Adds an arc to the path which is centered at (`xCenter`, `yCenter`) position with radius `radius`
starting at `startAngle` and with sweep angle `sweep` going in the given direction by
anticlockwise (defaulting to clockwise) as specified by `negative`.

