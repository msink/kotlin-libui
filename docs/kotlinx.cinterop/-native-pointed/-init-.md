[kotlinx.cinterop](../index.md) / [NativePointed](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`NativePointed(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`

The entity which has an associated native pointer.
Subtypes are supposed to represent interpretations of the pointed data or code.

This interface is likely to be handled by compiler magic and shouldn't be subtyped by arbitrary classes.

TODO: the behavior of [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html), [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html) and [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html) differs on Native and JVM backends.

