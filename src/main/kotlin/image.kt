package libui

import kotlinx.cinterop.*

class ImageData(val width: Int, val height: Int, val stride: Int, val pixels: CValuesRef<IntVar>)

class Image(width: Double, height: Double) : Disposable<uiImage>(
    alloc = uiNewImage(width, height)) {
    override fun free() = uiFreeImage(ptr)
}

fun TableModel.Image(width: Double, height: Double, block: Image.() -> Unit = {}): Image =
    libui.Image(width, height).also {
        disposables.add(it)
        block.invoke(it)
    }

fun Image.add(data: ImageData) =
    uiImageAppend(ptr, data.pixels, data.width, data.height, data.stride)
