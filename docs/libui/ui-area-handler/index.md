[libui](../index.md) / [uiAreaHandler](./index.md)

# uiAreaHandler

`class uiAreaHandler : CStructVar`

### Types

| Name | Summary |
|---|---|
| [Companion](-companion.md) | `companion object Companion : Type` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `uiAreaHandler(rawPtr: NativePtr)` |

### Properties

| Name | Summary |
|---|---|
| [DragBroken](-drag-broken.md) | `var DragBroken: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?) -> Unit>>?` |
| [Draw](-draw.md) | `var Draw: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaDrawParams`](../ui-area-draw-params/index.md)`>?) -> Unit>>?` |
| [KeyEvent](-key-event.md) | `var KeyEvent: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaKeyEvent`](../ui-area-key-event/index.md)`>?) -> Int>>?` |
| [MouseCrossed](-mouse-crossed.md) | `var MouseCrossed: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, Int) -> Unit>>?` |
| [MouseEvent](-mouse-event.md) | `var MouseEvent: CPointer<CFunction<(CPointer<`[`uiAreaHandler`](./index.md)`>?, CPointer<`[`uiArea`](../ui-area.md)`>?, CPointer<`[`uiAreaMouseEvent`](../ui-area-mouse-event/index.md)`>?) -> Unit>>?` |
