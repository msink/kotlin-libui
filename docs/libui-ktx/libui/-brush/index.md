[libui-ktx](../../index.md) / [libui](../index.md) / [Brush](./index.md)

# Brush

`class Brush : `[`Disposable`](../-disposable/index.md)`<<ERROR CLASS>>`

Defines the color(s) to draw a path with.

### Constructors

| [&lt;init&gt;](-init-.md) | `Brush()`<br>Defines the color(s) to draw a path with. |

### Inherited Properties

| [disposed](../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../-disposable/ptr.md) | `val ptr: <ERROR CLASS><`[`T`](../-disposable/index.md#T)`>` |

### Inherited Functions

| [dispose](../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |

### Extension Functions

| [linear](../linear.md) | `fun `[`Brush`](./index.md)`.linear(start: `[`Point`](../-point/index.md)`, end: `[`Point`](../-point/index.md)`, vararg stops: <ERROR CLASS><`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Color`](../-color/index.md)`>): `[`Brush`](./index.md)<br>Helper to quickly create linear brush |
| [radial](../radial.md) | `fun `[`Brush`](./index.md)`.radial(start: `[`Point`](../-point/index.md)`, center: `[`Point`](../-point/index.md)`, radius: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, vararg stops: <ERROR CLASS><`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, `[`Color`](../-color/index.md)`>): `[`Brush`](./index.md)<br>Helper to quickly create radial brush |
| [solid](../solid.md) | `fun `[`Brush`](./index.md)`.solid(color: `[`Color`](../-color/index.md)`, opacity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0): `[`Brush`](./index.md)<br>`fun `[`Brush`](./index.md)`.solid(rgb: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, alpha: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0): `[`Brush`](./index.md)<br>Helper to quickly set a brush color |

