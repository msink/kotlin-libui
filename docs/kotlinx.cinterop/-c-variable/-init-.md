[kotlinx.cinterop](../index.md) / [CVariable](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CVariable(rawPtr: `[`NativePtr`](../-native-ptr.md)`)`

The C data variable located in memory.

The non-abstract subclasses should represent the (complete) C data type and thus specify size and alignment.
Each such subclass must have a companion object which is a [Type](-type/index.md).

