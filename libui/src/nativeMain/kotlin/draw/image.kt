// SPDX-License-Identifier: MIT OR Apache-2.0

package libui.ktx.draw

import kotlinx.cinterop.*
import libui.*
import libui.ktx.*

class ImageData(val width: Int, val height: Int, val stride: Int, val pixels: CValuesRef<UIntVar>)

class Image(width: Double, height: Double) : Disposable<uiImage>(
    alloc = uiNewImage(width, height)
) {
    override fun free() = uiFreeImage(ptr)
}

fun Table<*>.image(width: Int, height: Int, block: Image.() -> Unit = {}): Image =
    Image(width.toDouble(), height.toDouble()).also {
        disposables.add(it)
        block.invoke(it)
    }

fun Image.bitmap(data: ImageData) =
    uiImageAppend(ptr, data.pixels, data.width, data.height, data.stride)
