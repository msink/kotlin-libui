[libui.ktx.draw](../README.md) / [OpenTypeFeatures](README.md)

# OpenTypeFeatures

`class OpenTypeFeatures : `[`Disposable`](../../libui.ktx/-disposable/README.md)`<`[`uiOpenTypeFeatures`](../../libui/ui-open-type-features.md)`>`

Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text.

### Constructors

| Name | Summary |
|---|---|
| [OpenTypeFeatures](-open-type-features.md) | `OpenTypeFeatures(copy: CPointer<`[`uiOpenTypeFeatures`](../../libui/ui-open-type-features.md)`>? = null)`<br>Represents a set of OpenType feature tag-value pairs, for applying OpenType features to text. |

### Inherited Properties

| Name | Summary |
|---|---|
| [disposed](../../libui.ktx/-disposable/disposed.md) | `val disposed: Boolean`<br>Returns `true` if object was disposed - in this case [dispose](../../libui.ktx/-disposable/dispose.md) will do nothing, all other operations are invalid and will `throw Error("Resource is disposed")`. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(tag: String, value: UInt): Unit`<br>Adds the given feature tag and value to OpenTypeFeatures. If there is already a value associated with the specified tag in otf, the old value is removed. |
| [copy](copy.md) | `fun copy(): `[`OpenTypeFeatures`](README.md)<br>Makes a copy of otf and returns it. Changing one will not affect the other. |
| [get](get.md) | `fun get(tag: String): UInt`<br>Determines whether the given feature tag is present in OpenTypeFeatures. |
| [remove](remove.md) | `fun remove(tag: String): Unit`<br>Removes the given feature tag and value from OpenTypeFeatures. If the tag is not present in OpenTypeFeatures, it does nothing. |

### Inherited Functions

| Name | Summary |
|---|---|
| [dispose](../../libui.ktx/-disposable/dispose.md) | `open fun dispose(): Unit`<br>Dispose and free all allocated native resources. |
