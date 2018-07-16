[kotlin](../index.md) / [Pair](./index.md)

# Pair

`data class Pair<out A, out B>`

Represents a generic pair of two values.

There is no meaning attached to values in this class, it can be used for any purpose.
Pair exhibits value semantics, i.e. two pairs are equal if both components are equal.

An example of decomposing it into values:

``` kotlin
//Unresolved: samples.misc.Tuples.pairDestructuring
```

### Parameters

`A` - type of the first value.

`B` - type of the second value.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Pair(first: `[`A`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/-a/index.html)`, second: `[`B`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/-b/index.html)`)`<br>Creates a new instance of Pair. |

### Properties

| Name | Summary |
|---|---|
| [first](first.md) | `val first: `[`A`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/-a/index.html)<br>First value. |
| [second](second.md) | `val second: `[`B`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/-b/index.html)<br>Second value. |

### Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns string representation of the [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html) including its [first](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/first.html) and [second](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/second.html) values. |
