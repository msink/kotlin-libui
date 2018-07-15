[libui-ktx](../../../index.md) / [kotlinx.cinterop](../../index.md) / [CVariable](../index.md) / [Type](./index.md)

# Type

`open class Type`

The (complete) C data type.

### Parameters

`size` - the size in bytes of data of this type

`align` - the alignments in bytes that is enough for this data type.
It may be greater than actually required for simplicity.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Type(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>The (complete) C data type. |

### Properties

| Name | Summary |
|---|---|
| [align](align.md) | `val align: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>the alignments in bytes that is enough for this data type. It may be greater than actually required for simplicity. |
| [size](size.md) | `val size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the size in bytes of data of this type |

### Inheritors

| Name | Summary |
|---|---|
| [Companion](../../-c-pointer-var-of/-companion.md) | `companion object Companion : `[`Type`](./index.md) |
| [Type](../../-c-struct-var/-type/index.md) | `open class Type : `[`Type`](./index.md) |
| [Type](../../-c-primitive-var/-type/index.md) | `open class Type : `[`Type`](./index.md) |
