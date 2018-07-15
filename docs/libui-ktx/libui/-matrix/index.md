[libui-ktx](../../index.md) / [libui](../index.md) / [Matrix](./index.md)

# Matrix

`class Matrix : `[`Disposable`](../-disposable/index.md)`<`[`uiDrawMatrix`](../ui-draw-matrix/index.md)`>`

Defines a transformation (e.g. rotation, translation)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Matrix()`<br>Defines a transformation (e.g. rotation, translation) |

### Properties

| Name | Summary |
|---|---|
| [invertible](invertible.md) | `val invertible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if the matrix is invertible. |
| [point](point.md) | `val point: `[`Point`](../-point/index.md)<br>Returns the transformed point. |
| [size](size.md) | `val size: `[`Size`](../-size/index.md)<br>Returns the transformed size. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [invert](invert.md) | `fun invert(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Inverts the matrix. |
| [multiply](multiply.md) | `fun multiply(other: `[`Matrix`](./index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the matrix to the product of itself with [other](multiply.md#libui.Matrix$multiply(libui.Matrix)/other) matrix. |
| [rotate](rotate.md) | `fun rotate(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, amount: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Rotates paths by [amount](rotate.md#libui.Matrix$rotate(kotlin.Double, kotlin.Double, kotlin.Double)/amount) *radians* around ([x](rotate.md#libui.Matrix$rotate(kotlin.Double, kotlin.Double, kotlin.Double)/x), [y](rotate.md#libui.Matrix$rotate(kotlin.Double, kotlin.Double, kotlin.Double)/y)). |
| [scale](scale.md) | `fun scale(xCenter: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, yCenter: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Scales pathes by a factor of [x](scale.md#libui.Matrix$scale(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/x) and [y](scale.md#libui.Matrix$scale(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/y) with ([xCenter](scale.md#libui.Matrix$scale(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/xCenter), [yCenter](scale.md#libui.Matrix$scale(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/yCenter)) as the scale center. |
| [skew](skew.md) | `fun skew(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, xamount: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, yamount: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Skews path by [xamount](skew.md#libui.Matrix$skew(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/xamount) *radians* horizontally and by [yamount](skew.md#libui.Matrix$skew(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/yamount) *radians* vertically around ([x](skew.md#libui.Matrix$skew(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/x), [y](skew.md#libui.Matrix$skew(kotlin.Double, kotlin.Double, kotlin.Double, kotlin.Double)/y)) |
| [translate](translate.md) | `fun translate(x: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, y: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Moves paths over by [x](translate.md#libui.Matrix$translate(kotlin.Double, kotlin.Double)/x) to the right and [y](translate.md#libui.Matrix$translate(kotlin.Double, kotlin.Double)/y) down. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
