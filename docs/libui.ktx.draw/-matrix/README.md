[libui.ktx.draw](../README.md) / [Matrix](README.md)

# Matrix

`class Matrix : `[`Disposable`](../../libui.ktx/-disposable/README.md)`<`[`uiDrawMatrix`](../../libui/ui-draw-matrix/README.md)`>`

Defines a transformation (e.g. rotation, translation)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Matrix()`<br>Defines a transformation (e.g. rotation, translation) |

### Properties

| Name | Summary |
|---|---|
| [invertible](invertible.md) | `val invertible: Boolean`<br>Returns `true` if the matrix is invertible. |
| [point](point.md) | `val point: `[`Point`](../-point/README.md)<br>Returns the transformed point. |
| [size](size.md) | `val size: `[`Size`](../-size/README.md)<br>Returns the transformed size. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [invert](invert.md) | `fun invert(): Int`<br>Inverts the matrix. |
| [multiply](multiply.md) | `fun multiply(other: `[`Matrix`](README.md)`): Unit`<br>Sets the matrix to the product of itself with `other` matrix. |
| [rotate](rotate.md) | `fun rotate(x: Double, y: Double, amount: Double): Unit`<br>Rotates paths by `amount` **radians** around (`x`, `y`). |
| [scale](scale.md) | `fun scale(xCenter: Double, yCenter: Double, x: Double, y: Double): Unit`<br>Scales pathes by a factor of `x` and `y` with (`xCenter`, `yCenter`) as the scale center. |
| [skew](skew.md) | `fun skew(x: Double, y: Double, xamount: Double, yamount: Double): Unit`<br>Skews path by `xamount` **radians** horizontally and by `yamount` **radians** vertically around (`x`, `y`) |
| [translate](translate.md) | `fun translate(x: Double, y: Double): Unit`<br>Moves paths over by `x` to the right and `y` down. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
