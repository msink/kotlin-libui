[libui.ktx](../../index.md) / [Table](../index.md) / [TableColumn](./index.md)

# TableColumn

`inner class TableColumn<T>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TableColumn()` |

### Functions

| Name | Summary |
|---|---|
| [button](button.md) | `fun button(text: (row: Int) -> String, action: (row: Int) -> Unit): Unit`<br>`fun button(text: String, action: (row: Int) -> Unit): Unit` |
| [checkbox](checkbox.md) | `fun checkbox(property: KMutableProperty1<`[`T`](index.md#T)`, Boolean>): Unit` |
| [color](color.md) | `fun color(get: (row: Int) -> `[`Color`](../../../libui.ktx.draw/-color/index.md)`?): Unit` |
| [image](image.md) | `fun image(get: (row: Int) -> `[`Image`](../../../libui.ktx.draw/-image/index.md)`?): Unit` |
| [label](label.md) | `fun label(get: (row: Int) -> String): Unit`<br>`fun label(property: KProperty1<`[`T`](index.md#T)`, String>): Unit` |
| [progressbar](progressbar.md) | `fun progressbar(get: (row: Int) -> Int): Unit` |
| [textfield](textfield.md) | `fun textfield(property: KMutableProperty1<`[`T`](index.md#T)`, String>): Unit` |
