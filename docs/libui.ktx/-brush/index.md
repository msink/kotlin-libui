[libui.ktx](../index.md) / [Brush](./index.md)

# Brush

`class Brush : `[`Disposable`](../-disposable/index.md)`<`[`uiDrawBrush`](../../libui/ui-draw-brush/index.md)`>`

Defines the color(s) to draw a path with.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Brush()`<br>Defines the color(s) to draw a path with. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [linear](linear.md) | `fun linear(start: `[`Point`](../-point/index.md)`, end: `[`Point`](../-point/index.md)`, vararg stops: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Color`](../-color/index.md)`>): `[`Brush`](./index.md)<br>Helper to quickly create linear brush |
| [radial](radial.md) | `fun radial(start: `[`Point`](../-point/index.md)`, center: `[`Point`](../-point/index.md)`, radius: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, vararg stops: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Color`](../-color/index.md)`>): `[`Brush`](./index.md)<br>Helper to quickly create radial brush |
| [solid](solid.md) | `fun solid(color: `[`Color`](../-color/index.md)`, opacity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0): `[`Brush`](./index.md)<br>`fun solid(rgb: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, alpha: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0): `[`Brush`](./index.md)<br>Helper to quickly set a brush color |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
