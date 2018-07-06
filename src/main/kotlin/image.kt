package libui

import kotlinx.cinterop.*

class ImageData(val width: Int, val height: Int, val stride: Int, val pixels: CValuesRef<IntVar>)

class Image(width: Double, height: Double) : Disposable<uiImage>(
    alloc = uiNewImage(width, height)) {
    override fun free() = uiFreeImage(ptr)
}

fun Table<*>.Image(width: Int, height: Int, block: Image.() -> Unit = {}): Image =
    libui.Image(width.toDouble(), height.toDouble()).also {
        disposable.add(it)
        block.invoke(it)
    }

fun Image.bitmap(data: ImageData) =
    uiImageAppend(ptr, data.pixels, data.width, data.height, data.stride)
