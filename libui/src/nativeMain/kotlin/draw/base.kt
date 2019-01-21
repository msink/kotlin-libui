// SPDX-License-Identifier: MIT OR Apache-2.0

package libui.ktx.draw

data class Color(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double = 1.0
) {
    constructor(rgb: Int, alpha: Double = 1.0) : this(
        r = ((rgb shr 16) and 255).toDouble() / 255,
        g = ((rgb shr 8) and 255).toDouble() / 255,
        b = ((rgb) and 255).toDouble() / 255,
        a = alpha
    )
}

data class SizeInt(
    val width: Int,
    val height: Int
)

data class Size(
    val width: Double,
    val height: Double
)

data class Point(
    val x: Double,
    val y: Double
)

