[libui-ktx](../../../index.md) / [libui](../../index.md) / [Stroke](../index.md) / [OpenTypeFeatures](./index.md)

# OpenTypeFeatures

`class OpenTypeFeatures : `[`Disposable`](../../-disposable/index.md)`<`[`uiOpenTypeFeatures`](../../ui-open-type-features.md)`>`

Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OpenTypeFeatures(copy: `[`CPointer`](../../../kotlinx.cinterop/-c-pointer/index.md)`<`[`uiOpenTypeFeatures`](../../ui-open-type-features.md)`>? = null)`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../-disposable/disposed.md) | `val disposed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if object was disposed - in this case [disposed](../../-disposable/disposed.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |
| [ptr](../../-disposable/ptr.md) | `val ptr: `[`CPointer`](../../../kotlinx.cinterop/-c-pointer/index.md)`<`[`T`](../../-disposable/index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the given feature tag and value to OpenTypeFeatures. If there is already a value associated with the specified tag in otf, the old value is removed. |
| [copy](copy.md) | `fun copy(): `[`OpenTypeFeatures`](./index.md)<br>Makes a copy of otf and returns it. Changing one will not affect the other. |
| [get](get.md) | `fun get(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Determines whether the given feature tag is present in OpenTypeFeatures. |
| [remove](remove.md) | `fun remove(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes the given feature tag and value from OpenTypeFeatures. If the tag is not present in OpenTypeFeatures, it does nothing. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../-disposable/dispose.md) | `open fun dispose(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Dispose and free all allocated native resources. |
