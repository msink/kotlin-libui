[libui](README.md)

## Package libui

### Types

| Name | Summary |
|---|---|
| [ktAreaHandler](kt-area-handler/README.md) | `class ktAreaHandler : CStructVar` |
| [ktTableHandler](kt-table-handler/README.md) | `class ktTableHandler : CStructVar` |
| [uiAreaDrawParams](ui-area-draw-params/README.md) | `class uiAreaDrawParams : CStructVar` |
| [uiAreaHandler](ui-area-handler/README.md) | `class uiAreaHandler : CStructVar` |
| [uiAreaKeyEvent](ui-area-key-event/README.md) | `class uiAreaKeyEvent : CStructVar` |
| [uiAreaMouseEvent](ui-area-mouse-event/README.md) | `class uiAreaMouseEvent : CStructVar` |
| [uiControl](ui-control/README.md) | `class uiControl : CStructVar` |
| [uiDrawBrush](ui-draw-brush/README.md) | `class uiDrawBrush : CStructVar` |
| [uiDrawBrushGradientStop](ui-draw-brush-gradient-stop/README.md) | `class uiDrawBrushGradientStop : CStructVar` |
| [uiDrawMatrix](ui-draw-matrix/README.md) | `class uiDrawMatrix : CStructVar` |
| [uiDrawStrokeParams](ui-draw-stroke-params/README.md) | `class uiDrawStrokeParams : CStructVar` |
| [uiDrawTextLayoutParams](ui-draw-text-layout-params/README.md) | `class uiDrawTextLayoutParams : CStructVar` |
| [uiFontDescriptor](ui-font-descriptor/README.md) | `class uiFontDescriptor : CStructVar` |
| [uiInitOptions](ui-init-options/README.md) | `class uiInitOptions : CStructVar` |
| [uiTableModelHandler](ui-table-model-handler/README.md) | `class uiTableModelHandler : CStructVar` |
| [uiTableParams](ui-table-params/README.md) | `class uiTableParams : CStructVar` |
| [uiTableTextColumnOptionalParams](ui-table-text-column-optional-params/README.md) | `class uiTableTextColumnOptionalParams : CStructVar` |

### Type Aliases

| Name | Summary |
|---|---|
| [tm](tm.md) | `typealias tm = CPointed` |
| [uiAlign](ui-align.md) | `typealias uiAlign = UInt` |
| [uiAlignVar](ui-align-var.md) | `typealias uiAlignVar = UIntVarOf<`[`uiAlign`](ui-align.md)`>` |
| [uiArea](ui-area.md) | `typealias uiArea = CPointed` |
| [uiAt](ui-at.md) | `typealias uiAt = UInt` |
| [uiAtVar](ui-at-var.md) | `typealias uiAtVar = UIntVarOf<`[`uiAt`](ui-at.md)`>` |
| [uiAttribute](ui-attribute.md) | `typealias uiAttribute = CPointed` |
| [uiAttributeType](ui-attribute-type.md) | `typealias uiAttributeType = UInt` |
| [uiAttributeTypeVar](ui-attribute-type-var.md) | `typealias uiAttributeTypeVar = UIntVarOf<`[`uiAttributeType`](ui-attribute-type.md)`>` |
| [uiAttributedString](ui-attributed-string.md) | `typealias uiAttributedString = CPointed` |
| [uiAttributedStringForEachAttributeFunc](ui-attributed-string-for-each-attribute-func.md) | `typealias uiAttributedStringForEachAttributeFunc = CPointer<CFunction<(CPointer<`[`uiAttributedString`](ui-attributed-string.md)`>?, CPointer<`[`uiAttribute`](ui-attribute.md)`>?, size_t, size_t, COpaquePointer?) -> `[`uiForEach`](ui-for-each.md)`>>` |
| [uiAttributedStringForEachAttributeFuncVar](ui-attributed-string-for-each-attribute-func-var.md) | `typealias uiAttributedStringForEachAttributeFuncVar = CPointerVarOf<`[`uiAttributedStringForEachAttributeFunc`](ui-attributed-string-for-each-attribute-func.md)`>` |
| [uiBox](ui-box.md) | `typealias uiBox = CPointed` |
| [uiButton](ui-button.md) | `typealias uiButton = CPointed` |
| [uiCheckbox](ui-checkbox.md) | `typealias uiCheckbox = CPointed` |
| [uiColorButton](ui-color-button.md) | `typealias uiColorButton = CPointed` |
| [uiCombobox](ui-combobox.md) | `typealias uiCombobox = CPointed` |
| [uiDateTimePicker](ui-date-time-picker.md) | `typealias uiDateTimePicker = CPointed` |
| [uiDrawBrushType](ui-draw-brush-type.md) | `typealias uiDrawBrushType = UInt` |
| [uiDrawBrushTypeVar](ui-draw-brush-type-var.md) | `typealias uiDrawBrushTypeVar = UIntVarOf<`[`uiDrawBrushType`](ui-draw-brush-type.md)`>` |
| [uiDrawContext](ui-draw-context.md) | `typealias uiDrawContext = CPointed` |
| [uiDrawFillMode](ui-draw-fill-mode.md) | `typealias uiDrawFillMode = UInt` |
| [uiDrawFillModeVar](ui-draw-fill-mode-var.md) | `typealias uiDrawFillModeVar = UIntVarOf<`[`uiDrawFillMode`](ui-draw-fill-mode.md)`>` |
| [uiDrawLineCap](ui-draw-line-cap.md) | `typealias uiDrawLineCap = UInt` |
| [uiDrawLineCapVar](ui-draw-line-cap-var.md) | `typealias uiDrawLineCapVar = UIntVarOf<`[`uiDrawLineCap`](ui-draw-line-cap.md)`>` |
| [uiDrawLineJoin](ui-draw-line-join.md) | `typealias uiDrawLineJoin = UInt` |
| [uiDrawLineJoinVar](ui-draw-line-join-var.md) | `typealias uiDrawLineJoinVar = UIntVarOf<`[`uiDrawLineJoin`](ui-draw-line-join.md)`>` |
| [uiDrawPath](ui-draw-path.md) | `typealias uiDrawPath = CPointed` |
| [uiDrawTextAlign](ui-draw-text-align.md) | `typealias uiDrawTextAlign = UInt` |
| [uiDrawTextAlignVar](ui-draw-text-align-var.md) | `typealias uiDrawTextAlignVar = UIntVarOf<`[`uiDrawTextAlign`](ui-draw-text-align.md)`>` |
| [uiDrawTextLayout](ui-draw-text-layout.md) | `typealias uiDrawTextLayout = CPointed` |
| [uiEditableCombobox](ui-editable-combobox.md) | `typealias uiEditableCombobox = CPointed` |
| [uiEntry](ui-entry.md) | `typealias uiEntry = CPointed` |
| [uiExtKey](ui-ext-key.md) | `typealias uiExtKey = UInt` |
| [uiExtKeyVar](ui-ext-key-var.md) | `typealias uiExtKeyVar = UIntVarOf<`[`uiExtKey`](ui-ext-key.md)`>` |
| [uiFontButton](ui-font-button.md) | `typealias uiFontButton = CPointed` |
| [uiForEach](ui-for-each.md) | `typealias uiForEach = UInt` |
| [uiForEachVar](ui-for-each-var.md) | `typealias uiForEachVar = UIntVarOf<`[`uiForEach`](ui-for-each.md)`>` |
| [uiForm](ui-form.md) | `typealias uiForm = CPointed` |
| [uiGrid](ui-grid.md) | `typealias uiGrid = CPointed` |
| [uiGroup](ui-group.md) | `typealias uiGroup = CPointed` |
| [uiImage](ui-image.md) | `typealias uiImage = CPointed` |
| [uiLabel](ui-label.md) | `typealias uiLabel = CPointed` |
| [uiMenu](ui-menu.md) | `typealias uiMenu = CPointed` |
| [uiMenuItem](ui-menu-item.md) | `typealias uiMenuItem = CPointed` |
| [uiModifiers](ui-modifiers.md) | `typealias uiModifiers = UInt` |
| [uiModifiersVar](ui-modifiers-var.md) | `typealias uiModifiersVar = UIntVarOf<`[`uiModifiers`](ui-modifiers.md)`>` |
| [uiMultilineEntry](ui-multiline-entry.md) | `typealias uiMultilineEntry = CPointed` |
| [uiOpenTypeFeatures](ui-open-type-features.md) | `typealias uiOpenTypeFeatures = CPointed` |
| [uiOpenTypeFeaturesForEachFunc](ui-open-type-features-for-each-func.md) | `typealias uiOpenTypeFeaturesForEachFunc = CPointer<CFunction<(CPointer<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?, Byte, Byte, Byte, Byte, uint32_t, COpaquePointer?) -> `[`uiForEach`](ui-for-each.md)`>>` |
| [uiOpenTypeFeaturesForEachFuncVar](ui-open-type-features-for-each-func-var.md) | `typealias uiOpenTypeFeaturesForEachFuncVar = CPointerVarOf<`[`uiOpenTypeFeaturesForEachFunc`](ui-open-type-features-for-each-func.md)`>` |
| [uiProgressBar](ui-progress-bar.md) | `typealias uiProgressBar = CPointed` |
| [uiRadioButtons](ui-radio-buttons.md) | `typealias uiRadioButtons = CPointed` |
| [uiSeparator](ui-separator.md) | `typealias uiSeparator = CPointed` |
| [uiSlider](ui-slider.md) | `typealias uiSlider = CPointed` |
| [uiSpinbox](ui-spinbox.md) | `typealias uiSpinbox = CPointed` |
| [uiTab](ui-tab.md) | `typealias uiTab = CPointed` |
| [uiTable](ui-table.md) | `typealias uiTable = CPointed` |
| [uiTableModel](ui-table-model.md) | `typealias uiTableModel = CPointed` |
| [uiTableValue](ui-table-value.md) | `typealias uiTableValue = CPointed` |
| [uiTableValueType](ui-table-value-type.md) | `typealias uiTableValueType = UInt` |
| [uiTableValueTypeVar](ui-table-value-type-var.md) | `typealias uiTableValueTypeVar = UIntVarOf<`[`uiTableValueType`](ui-table-value-type.md)`>` |
| [uiTextItalic](ui-text-italic.md) | `typealias uiTextItalic = UInt` |
| [uiTextItalicVar](ui-text-italic-var.md) | `typealias uiTextItalicVar = UIntVarOf<`[`uiTextItalic`](ui-text-italic.md)`>` |
| [uiTextStretch](ui-text-stretch.md) | `typealias uiTextStretch = UInt` |
| [uiTextStretchVar](ui-text-stretch-var.md) | `typealias uiTextStretchVar = UIntVarOf<`[`uiTextStretch`](ui-text-stretch.md)`>` |
| [uiTextWeight](ui-text-weight.md) | `typealias uiTextWeight = UInt` |
| [uiTextWeightVar](ui-text-weight-var.md) | `typealias uiTextWeightVar = UIntVarOf<`[`uiTextWeight`](ui-text-weight.md)`>` |
| [uiUnderline](ui-underline.md) | `typealias uiUnderline = UInt` |
| [uiUnderlineColor](ui-underline-color.md) | `typealias uiUnderlineColor = UInt` |
| [uiUnderlineColorVar](ui-underline-color-var.md) | `typealias uiUnderlineColorVar = UIntVarOf<`[`uiUnderlineColor`](ui-underline-color.md)`>` |
| [uiUnderlineVar](ui-underline-var.md) | `typealias uiUnderlineVar = UIntVarOf<`[`uiUnderline`](ui-underline.md)`>` |
| [uiWindow](ui-window.md) | `typealias uiWindow = CPointed` |
| [uiWindowResizeEdge](ui-window-resize-edge.md) | `typealias uiWindowResizeEdge = UInt` |
| [uiWindowResizeEdgeVar](ui-window-resize-edge-var.md) | `typealias uiWindowResizeEdgeVar = UIntVarOf<`[`uiWindowResizeEdge`](ui-window-resize-edge.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [uiAlignCenter](ui-align-center.md) | `val uiAlignCenter: UInt` |
| [uiAlignEnd](ui-align-end.md) | `val uiAlignEnd: UInt` |
| [uiAlignFill](ui-align-fill.md) | `val uiAlignFill: UInt` |
| [uiAlignStart](ui-align-start.md) | `val uiAlignStart: UInt` |
| [uiAtBottom](ui-at-bottom.md) | `val uiAtBottom: UInt` |
| [uiAtLeading](ui-at-leading.md) | `val uiAtLeading: UInt` |
| [uiAtTop](ui-at-top.md) | `val uiAtTop: UInt` |
| [uiAtTrailing](ui-at-trailing.md) | `val uiAtTrailing: UInt` |
| [uiAttributeTypeBackground](ui-attribute-type-background.md) | `val uiAttributeTypeBackground: UInt` |
| [uiAttributeTypeColor](ui-attribute-type-color.md) | `val uiAttributeTypeColor: UInt` |
| [uiAttributeTypeFamily](ui-attribute-type-family.md) | `val uiAttributeTypeFamily: UInt` |
| [uiAttributeTypeFeatures](ui-attribute-type-features.md) | `val uiAttributeTypeFeatures: UInt` |
| [uiAttributeTypeItalic](ui-attribute-type-italic.md) | `val uiAttributeTypeItalic: UInt` |
| [uiAttributeTypeSize](ui-attribute-type-size.md) | `val uiAttributeTypeSize: UInt` |
| [uiAttributeTypeStretch](ui-attribute-type-stretch.md) | `val uiAttributeTypeStretch: UInt` |
| [uiAttributeTypeUnderline](ui-attribute-type-underline.md) | `val uiAttributeTypeUnderline: UInt` |
| [uiAttributeTypeUnderlineColor](ui-attribute-type-underline-color.md) | `val uiAttributeTypeUnderlineColor: UInt` |
| [uiAttributeTypeWeight](ui-attribute-type-weight.md) | `val uiAttributeTypeWeight: UInt` |
| [uiDrawBrushTypeImage](ui-draw-brush-type-image.md) | `val uiDrawBrushTypeImage: UInt` |
| [uiDrawBrushTypeLinearGradient](ui-draw-brush-type-linear-gradient.md) | `val uiDrawBrushTypeLinearGradient: UInt` |
| [uiDrawBrushTypeRadialGradient](ui-draw-brush-type-radial-gradient.md) | `val uiDrawBrushTypeRadialGradient: UInt` |
| [uiDrawBrushTypeSolid](ui-draw-brush-type-solid.md) | `val uiDrawBrushTypeSolid: UInt` |
| [uiDrawDefaultMiterLimit](ui-draw-default-miter-limit.md) | `val uiDrawDefaultMiterLimit: Double` |
| [uiDrawFillModeAlternate](ui-draw-fill-mode-alternate.md) | `val uiDrawFillModeAlternate: UInt` |
| [uiDrawFillModeWinding](ui-draw-fill-mode-winding.md) | `val uiDrawFillModeWinding: UInt` |
| [uiDrawLineCapFlat](ui-draw-line-cap-flat.md) | `val uiDrawLineCapFlat: UInt` |
| [uiDrawLineCapRound](ui-draw-line-cap-round.md) | `val uiDrawLineCapRound: UInt` |
| [uiDrawLineCapSquare](ui-draw-line-cap-square.md) | `val uiDrawLineCapSquare: UInt` |
| [uiDrawLineJoinBevel](ui-draw-line-join-bevel.md) | `val uiDrawLineJoinBevel: UInt` |
| [uiDrawLineJoinMiter](ui-draw-line-join-miter.md) | `val uiDrawLineJoinMiter: UInt` |
| [uiDrawLineJoinRound](ui-draw-line-join-round.md) | `val uiDrawLineJoinRound: UInt` |
| [uiDrawTextAlignCenter](ui-draw-text-align-center.md) | `val uiDrawTextAlignCenter: UInt` |
| [uiDrawTextAlignLeft](ui-draw-text-align-left.md) | `val uiDrawTextAlignLeft: UInt` |
| [uiDrawTextAlignRight](ui-draw-text-align-right.md) | `val uiDrawTextAlignRight: UInt` |
| [uiExtKeyDelete](ui-ext-key-delete.md) | `val uiExtKeyDelete: UInt` |
| [uiExtKeyDown](ui-ext-key-down.md) | `val uiExtKeyDown: UInt` |
| [uiExtKeyEnd](ui-ext-key-end.md) | `val uiExtKeyEnd: UInt` |
| [uiExtKeyEscape](ui-ext-key-escape.md) | `val uiExtKeyEscape: UInt` |
| [uiExtKeyF1](ui-ext-key-f1.md) | `val uiExtKeyF1: UInt` |
| [uiExtKeyF10](ui-ext-key-f10.md) | `val uiExtKeyF10: UInt` |
| [uiExtKeyF11](ui-ext-key-f11.md) | `val uiExtKeyF11: UInt` |
| [uiExtKeyF12](ui-ext-key-f12.md) | `val uiExtKeyF12: UInt` |
| [uiExtKeyF2](ui-ext-key-f2.md) | `val uiExtKeyF2: UInt` |
| [uiExtKeyF3](ui-ext-key-f3.md) | `val uiExtKeyF3: UInt` |
| [uiExtKeyF4](ui-ext-key-f4.md) | `val uiExtKeyF4: UInt` |
| [uiExtKeyF5](ui-ext-key-f5.md) | `val uiExtKeyF5: UInt` |
| [uiExtKeyF6](ui-ext-key-f6.md) | `val uiExtKeyF6: UInt` |
| [uiExtKeyF7](ui-ext-key-f7.md) | `val uiExtKeyF7: UInt` |
| [uiExtKeyF8](ui-ext-key-f8.md) | `val uiExtKeyF8: UInt` |
| [uiExtKeyF9](ui-ext-key-f9.md) | `val uiExtKeyF9: UInt` |
| [uiExtKeyHome](ui-ext-key-home.md) | `val uiExtKeyHome: UInt` |
| [uiExtKeyInsert](ui-ext-key-insert.md) | `val uiExtKeyInsert: UInt` |
| [uiExtKeyLeft](ui-ext-key-left.md) | `val uiExtKeyLeft: UInt` |
| [uiExtKeyN0](ui-ext-key-n0.md) | `val uiExtKeyN0: UInt` |
| [uiExtKeyN1](ui-ext-key-n1.md) | `val uiExtKeyN1: UInt` |
| [uiExtKeyN2](ui-ext-key-n2.md) | `val uiExtKeyN2: UInt` |
| [uiExtKeyN3](ui-ext-key-n3.md) | `val uiExtKeyN3: UInt` |
| [uiExtKeyN4](ui-ext-key-n4.md) | `val uiExtKeyN4: UInt` |
| [uiExtKeyN5](ui-ext-key-n5.md) | `val uiExtKeyN5: UInt` |
| [uiExtKeyN6](ui-ext-key-n6.md) | `val uiExtKeyN6: UInt` |
| [uiExtKeyN7](ui-ext-key-n7.md) | `val uiExtKeyN7: UInt` |
| [uiExtKeyN8](ui-ext-key-n8.md) | `val uiExtKeyN8: UInt` |
| [uiExtKeyN9](ui-ext-key-n9.md) | `val uiExtKeyN9: UInt` |
| [uiExtKeyNAdd](ui-ext-key-n-add.md) | `val uiExtKeyNAdd: UInt` |
| [uiExtKeyNDivide](ui-ext-key-n-divide.md) | `val uiExtKeyNDivide: UInt` |
| [uiExtKeyNDot](ui-ext-key-n-dot.md) | `val uiExtKeyNDot: UInt` |
| [uiExtKeyNEnter](ui-ext-key-n-enter.md) | `val uiExtKeyNEnter: UInt` |
| [uiExtKeyNMultiply](ui-ext-key-n-multiply.md) | `val uiExtKeyNMultiply: UInt` |
| [uiExtKeyNSubtract](ui-ext-key-n-subtract.md) | `val uiExtKeyNSubtract: UInt` |
| [uiExtKeyPageDown](ui-ext-key-page-down.md) | `val uiExtKeyPageDown: UInt` |
| [uiExtKeyPageUp](ui-ext-key-page-up.md) | `val uiExtKeyPageUp: UInt` |
| [uiExtKeyRight](ui-ext-key-right.md) | `val uiExtKeyRight: UInt` |
| [uiExtKeyUp](ui-ext-key-up.md) | `val uiExtKeyUp: UInt` |
| [uiForEachContinue](ui-for-each-continue.md) | `val uiForEachContinue: UInt` |
| [uiForEachStop](ui-for-each-stop.md) | `val uiForEachStop: UInt` |
| [uiModifierAlt](ui-modifier-alt.md) | `val uiModifierAlt: UInt` |
| [uiModifierCtrl](ui-modifier-ctrl.md) | `val uiModifierCtrl: UInt` |
| [uiModifierShift](ui-modifier-shift.md) | `val uiModifierShift: UInt` |
| [uiModifierSuper](ui-modifier-super.md) | `val uiModifierSuper: UInt` |
| [uiPi](ui-pi.md) | `val uiPi: Double` |
| [uiTableModelColumnAlwaysEditable](ui-table-model-column-always-editable.md) | `const val uiTableModelColumnAlwaysEditable: Int` |
| [uiTableModelColumnNeverEditable](ui-table-model-column-never-editable.md) | `const val uiTableModelColumnNeverEditable: Int` |
| [uiTableValueTypeColor](ui-table-value-type-color.md) | `val uiTableValueTypeColor: UInt` |
| [uiTableValueTypeImage](ui-table-value-type-image.md) | `val uiTableValueTypeImage: UInt` |
| [uiTableValueTypeInt](ui-table-value-type-int.md) | `val uiTableValueTypeInt: UInt` |
| [uiTableValueTypeString](ui-table-value-type-string.md) | `val uiTableValueTypeString: UInt` |
| [uiTextItalicItalic](ui-text-italic-italic.md) | `val uiTextItalicItalic: UInt` |
| [uiTextItalicNormal](ui-text-italic-normal.md) | `val uiTextItalicNormal: UInt` |
| [uiTextItalicOblique](ui-text-italic-oblique.md) | `val uiTextItalicOblique: UInt` |
| [uiTextStretchCondensed](ui-text-stretch-condensed.md) | `val uiTextStretchCondensed: UInt` |
| [uiTextStretchExpanded](ui-text-stretch-expanded.md) | `val uiTextStretchExpanded: UInt` |
| [uiTextStretchExtraCondensed](ui-text-stretch-extra-condensed.md) | `val uiTextStretchExtraCondensed: UInt` |
| [uiTextStretchExtraExpanded](ui-text-stretch-extra-expanded.md) | `val uiTextStretchExtraExpanded: UInt` |
| [uiTextStretchNormal](ui-text-stretch-normal.md) | `val uiTextStretchNormal: UInt` |
| [uiTextStretchSemiCondensed](ui-text-stretch-semi-condensed.md) | `val uiTextStretchSemiCondensed: UInt` |
| [uiTextStretchSemiExpanded](ui-text-stretch-semi-expanded.md) | `val uiTextStretchSemiExpanded: UInt` |
| [uiTextStretchUltraCondensed](ui-text-stretch-ultra-condensed.md) | `val uiTextStretchUltraCondensed: UInt` |
| [uiTextStretchUltraExpanded](ui-text-stretch-ultra-expanded.md) | `val uiTextStretchUltraExpanded: UInt` |
| [uiTextWeightBold](ui-text-weight-bold.md) | `val uiTextWeightBold: UInt` |
| [uiTextWeightBook](ui-text-weight-book.md) | `val uiTextWeightBook: UInt` |
| [uiTextWeightHeavy](ui-text-weight-heavy.md) | `val uiTextWeightHeavy: UInt` |
| [uiTextWeightLight](ui-text-weight-light.md) | `val uiTextWeightLight: UInt` |
| [uiTextWeightMaximum](ui-text-weight-maximum.md) | `val uiTextWeightMaximum: UInt` |
| [uiTextWeightMedium](ui-text-weight-medium.md) | `val uiTextWeightMedium: UInt` |
| [uiTextWeightMinimum](ui-text-weight-minimum.md) | `val uiTextWeightMinimum: UInt` |
| [uiTextWeightNormal](ui-text-weight-normal.md) | `val uiTextWeightNormal: UInt` |
| [uiTextWeightSemiBold](ui-text-weight-semi-bold.md) | `val uiTextWeightSemiBold: UInt` |
| [uiTextWeightThin](ui-text-weight-thin.md) | `val uiTextWeightThin: UInt` |
| [uiTextWeightUltraBold](ui-text-weight-ultra-bold.md) | `val uiTextWeightUltraBold: UInt` |
| [uiTextWeightUltraHeavy](ui-text-weight-ultra-heavy.md) | `val uiTextWeightUltraHeavy: UInt` |
| [uiTextWeightUltraLight](ui-text-weight-ultra-light.md) | `val uiTextWeightUltraLight: UInt` |
| [uiUnderlineColorAuxiliary](ui-underline-color-auxiliary.md) | `val uiUnderlineColorAuxiliary: UInt` |
| [uiUnderlineColorCustom](ui-underline-color-custom.md) | `val uiUnderlineColorCustom: UInt` |
| [uiUnderlineColorGrammar](ui-underline-color-grammar.md) | `val uiUnderlineColorGrammar: UInt` |
| [uiUnderlineColorSpelling](ui-underline-color-spelling.md) | `val uiUnderlineColorSpelling: UInt` |
| [uiUnderlineDouble](ui-underline-double.md) | `val uiUnderlineDouble: UInt` |
| [uiUnderlineNone](ui-underline-none.md) | `val uiUnderlineNone: UInt` |
| [uiUnderlineSingle](ui-underline-single.md) | `val uiUnderlineSingle: UInt` |
| [uiUnderlineSuggestion](ui-underline-suggestion.md) | `val uiUnderlineSuggestion: UInt` |
| [uiWindowResizeEdgeBottom](ui-window-resize-edge-bottom.md) | `val uiWindowResizeEdgeBottom: UInt` |
| [uiWindowResizeEdgeBottomLeft](ui-window-resize-edge-bottom-left.md) | `val uiWindowResizeEdgeBottomLeft: UInt` |
| [uiWindowResizeEdgeBottomRight](ui-window-resize-edge-bottom-right.md) | `val uiWindowResizeEdgeBottomRight: UInt` |
| [uiWindowResizeEdgeLeft](ui-window-resize-edge-left.md) | `val uiWindowResizeEdgeLeft: UInt` |
| [uiWindowResizeEdgeRight](ui-window-resize-edge-right.md) | `val uiWindowResizeEdgeRight: UInt` |
| [uiWindowResizeEdgeTop](ui-window-resize-edge-top.md) | `val uiWindowResizeEdgeTop: UInt` |
| [uiWindowResizeEdgeTopLeft](ui-window-resize-edge-top-left.md) | `val uiWindowResizeEdgeTopLeft: UInt` |
| [uiWindowResizeEdgeTopRight](ui-window-resize-edge-top-right.md) | `val uiWindowResizeEdgeTopRight: UInt` |

### Functions

| Name | Summary |
|---|---|
| [uiAllocControl](ui-alloc-control.md) | `fun uiAllocControl(n: size_t, OSsig: uint32_t, typesig: uint32_t, typenamestr: String?): CPointer<`[`uiControl`](ui-control/README.md)`>?` |
| [uiAreaBeginUserWindowMove](ui-area-begin-user-window-move.md) | `fun uiAreaBeginUserWindowMove(a: CValuesRef<`[`uiArea`](ui-area.md)`>?)` |
| [uiAreaBeginUserWindowResize](ui-area-begin-user-window-resize.md) | `fun uiAreaBeginUserWindowResize(a: CValuesRef<`[`uiArea`](ui-area.md)`>?, edge: `[`uiWindowResizeEdge`](ui-window-resize-edge.md)`)` |
| [uiAreaQueueRedrawAll](ui-area-queue-redraw-all.md) | `fun uiAreaQueueRedrawAll(a: CValuesRef<`[`uiArea`](ui-area.md)`>?)` |
| [uiAreaScrollTo](ui-area-scroll-to.md) | `fun uiAreaScrollTo(a: CValuesRef<`[`uiArea`](ui-area.md)`>?, x: Double, y: Double, width: Double, height: Double)` |
| [uiAreaSetSize](ui-area-set-size.md) | `fun uiAreaSetSize(a: CValuesRef<`[`uiArea`](ui-area.md)`>?, width: Int, height: Int)` |
| [uiAttributeColor](ui-attribute-color.md) | `fun uiAttributeColor(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?, r: CValuesRef<DoubleVar>?, g: CValuesRef<DoubleVar>?, b: CValuesRef<DoubleVar>?, alpha: CValuesRef<DoubleVar>?)` |
| [uiAttributeFamily](ui-attribute-family.md) | `fun uiAttributeFamily(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): CPointer<ByteVar>?` |
| [uiAttributeFeatures](ui-attribute-features.md) | `fun uiAttributeFeatures(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): CPointer<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?` |
| [uiAttributeGetType](ui-attribute-get-type.md) | `fun uiAttributeGetType(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): `[`uiAttributeType`](ui-attribute-type.md) |
| [uiAttributeItalic](ui-attribute-italic.md) | `fun uiAttributeItalic(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): `[`uiTextItalic`](ui-text-italic.md) |
| [uiAttributeSize](ui-attribute-size.md) | `fun uiAttributeSize(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): Double` |
| [uiAttributeStretch](ui-attribute-stretch.md) | `fun uiAttributeStretch(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): `[`uiTextStretch`](ui-text-stretch.md) |
| [uiAttributeUnderline](ui-attribute-underline.md) | `fun uiAttributeUnderline(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): `[`uiUnderline`](ui-underline.md) |
| [uiAttributeUnderlineColor](ui-attribute-underline-color.md) | `fun uiAttributeUnderlineColor(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?, u: CValuesRef<`[`uiUnderlineColorVar`](ui-underline-color-var.md)`>?, r: CValuesRef<DoubleVar>?, g: CValuesRef<DoubleVar>?, b: CValuesRef<DoubleVar>?, alpha: CValuesRef<DoubleVar>?)` |
| [uiAttributeWeight](ui-attribute-weight.md) | `fun uiAttributeWeight(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?): `[`uiTextWeight`](ui-text-weight.md) |
| [uiAttributedStringAppendUnattributed](ui-attributed-string-append-unattributed.md) | `fun uiAttributedStringAppendUnattributed(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, str: String?)` |
| [uiAttributedStringByteIndexToGrapheme](ui-attributed-string-byte-index-to-grapheme.md) | `fun uiAttributedStringByteIndexToGrapheme(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, pos: size_t): size_t` |
| [uiAttributedStringDelete](ui-attributed-string-delete.md) | `fun uiAttributedStringDelete(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, start: size_t, end: size_t)` |
| [uiAttributedStringForEachAttribute](ui-attributed-string-for-each-attribute.md) | `fun uiAttributedStringForEachAttribute(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, f: `[`uiAttributedStringForEachAttributeFunc`](ui-attributed-string-for-each-attribute-func.md)`?, data: CValuesRef<*>?)` |
| [uiAttributedStringGraphemeToByteIndex](ui-attributed-string-grapheme-to-byte-index.md) | `fun uiAttributedStringGraphemeToByteIndex(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, pos: size_t): size_t` |
| [uiAttributedStringInsertAtUnattributed](ui-attributed-string-insert-at-unattributed.md) | `fun uiAttributedStringInsertAtUnattributed(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, str: String?, at: size_t)` |
| [uiAttributedStringLen](ui-attributed-string-len.md) | `fun uiAttributedStringLen(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?): size_t` |
| [uiAttributedStringNumGraphemes](ui-attributed-string-num-graphemes.md) | `fun uiAttributedStringNumGraphemes(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?): size_t` |
| [uiAttributedStringSetAttribute](ui-attributed-string-set-attribute.md) | `fun uiAttributedStringSetAttribute(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?, a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?, start: size_t, end: size_t)` |
| [uiAttributedStringString](ui-attributed-string-string.md) | `fun uiAttributedStringString(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?): CPointer<ByteVar>?` |
| [uiBoxAppend](ui-box-append.md) | `fun uiBoxAppend(b: CValuesRef<`[`uiBox`](ui-box.md)`>?, child: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, stretchy: Int)` |
| [uiBoxDelete](ui-box-delete.md) | `fun uiBoxDelete(b: CValuesRef<`[`uiBox`](ui-box.md)`>?, index: Int)` |
| [uiBoxPadded](ui-box-padded.md) | `fun uiBoxPadded(b: CValuesRef<`[`uiBox`](ui-box.md)`>?): Int` |
| [uiBoxSetPadded](ui-box-set-padded.md) | `fun uiBoxSetPadded(b: CValuesRef<`[`uiBox`](ui-box.md)`>?, padded: Int)` |
| [uiButtonOnClicked](ui-button-on-clicked.md) | `fun uiButtonOnClicked(b: CValuesRef<`[`uiButton`](ui-button.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiButton`](ui-button.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiButtonSetText](ui-button-set-text.md) | `fun uiButtonSetText(b: CValuesRef<`[`uiButton`](ui-button.md)`>?, text: String?)` |
| [uiButtonText](ui-button-text.md) | `fun uiButtonText(b: CValuesRef<`[`uiButton`](ui-button.md)`>?): CPointer<ByteVar>?` |
| [uiCheckboxChecked](ui-checkbox-checked.md) | `fun uiCheckboxChecked(c: CValuesRef<`[`uiCheckbox`](ui-checkbox.md)`>?): Int` |
| [uiCheckboxOnToggled](ui-checkbox-on-toggled.md) | `fun uiCheckboxOnToggled(c: CValuesRef<`[`uiCheckbox`](ui-checkbox.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiCheckbox`](ui-checkbox.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiCheckboxSetChecked](ui-checkbox-set-checked.md) | `fun uiCheckboxSetChecked(c: CValuesRef<`[`uiCheckbox`](ui-checkbox.md)`>?, checked: Int)` |
| [uiCheckboxSetText](ui-checkbox-set-text.md) | `fun uiCheckboxSetText(c: CValuesRef<`[`uiCheckbox`](ui-checkbox.md)`>?, text: String?)` |
| [uiCheckboxText](ui-checkbox-text.md) | `fun uiCheckboxText(c: CValuesRef<`[`uiCheckbox`](ui-checkbox.md)`>?): CPointer<ByteVar>?` |
| [uiColorButtonColor](ui-color-button-color.md) | `fun uiColorButtonColor(b: CValuesRef<`[`uiColorButton`](ui-color-button.md)`>?, r: CValuesRef<DoubleVar>?, g: CValuesRef<DoubleVar>?, bl: CValuesRef<DoubleVar>?, a: CValuesRef<DoubleVar>?)` |
| [uiColorButtonOnChanged](ui-color-button-on-changed.md) | `fun uiColorButtonOnChanged(b: CValuesRef<`[`uiColorButton`](ui-color-button.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiColorButton`](ui-color-button.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiColorButtonSetColor](ui-color-button-set-color.md) | `fun uiColorButtonSetColor(b: CValuesRef<`[`uiColorButton`](ui-color-button.md)`>?, r: Double, g: Double, bl: Double, a: Double)` |
| [uiComboboxAppend](ui-combobox-append.md) | `fun uiComboboxAppend(c: CValuesRef<`[`uiCombobox`](ui-combobox.md)`>?, text: String?)` |
| [uiComboboxOnSelected](ui-combobox-on-selected.md) | `fun uiComboboxOnSelected(c: CValuesRef<`[`uiCombobox`](ui-combobox.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiCombobox`](ui-combobox.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiComboboxSelected](ui-combobox-selected.md) | `fun uiComboboxSelected(c: CValuesRef<`[`uiCombobox`](ui-combobox.md)`>?): Int` |
| [uiComboboxSetSelected](ui-combobox-set-selected.md) | `fun uiComboboxSetSelected(c: CValuesRef<`[`uiCombobox`](ui-combobox.md)`>?, n: Int)` |
| [uiControlDestroy](ui-control-destroy.md) | `fun uiControlDestroy(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlDisable](ui-control-disable.md) | `fun uiControlDisable(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlEnable](ui-control-enable.md) | `fun uiControlEnable(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlEnabled](ui-control-enabled.md) | `fun uiControlEnabled(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): Int` |
| [uiControlEnabledToUser](ui-control-enabled-to-user.md) | `fun uiControlEnabledToUser(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): Int` |
| [uiControlHandle](ui-control-handle.md) | `fun uiControlHandle(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): uintptr_t` |
| [uiControlHide](ui-control-hide.md) | `fun uiControlHide(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlParent](ui-control-parent.md) | `fun uiControlParent(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): CPointer<`[`uiControl`](ui-control/README.md)`>?` |
| [uiControlSetParent](ui-control-set-parent.md) | `fun uiControlSetParent(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, arg1: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlShow](ui-control-show.md) | `fun uiControlShow(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlToplevel](ui-control-toplevel.md) | `fun uiControlToplevel(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): Int` |
| [uiControlVerifySetParent](ui-control-verify-set-parent.md) | `fun uiControlVerifySetParent(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, arg1: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiControlVisible](ui-control-visible.md) | `fun uiControlVisible(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?): Int` |
| [uiDateTimePickerOnChanged](ui-date-time-picker-on-changed.md) | `fun uiDateTimePickerOnChanged(d: CValuesRef<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiDateTimePickerSetTime](ui-date-time-picker-set-time.md) | `fun uiDateTimePickerSetTime(d: CValuesRef<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?, time: CValuesRef<`[`tm`](tm.md)`>?)` |
| [uiDateTimePickerTime](ui-date-time-picker-time.md) | `fun uiDateTimePickerTime(d: CValuesRef<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?, time: CValuesRef<`[`tm`](tm.md)`>?)` |
| [uiDrawClip](ui-draw-clip.md) | `fun uiDrawClip(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?, path: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?)` |
| [uiDrawFill](ui-draw-fill.md) | `fun uiDrawFill(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?, path: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, b: CValuesRef<`[`uiDrawBrush`](ui-draw-brush/README.md)`>?)` |
| [uiDrawFreePath](ui-draw-free-path.md) | `fun uiDrawFreePath(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?)` |
| [uiDrawFreeTextLayout](ui-draw-free-text-layout.md) | `fun uiDrawFreeTextLayout(tl: CValuesRef<`[`uiDrawTextLayout`](ui-draw-text-layout.md)`>?)` |
| [uiDrawMatrixInvert](ui-draw-matrix-invert.md) | `fun uiDrawMatrixInvert(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?): Int` |
| [uiDrawMatrixInvertible](ui-draw-matrix-invertible.md) | `fun uiDrawMatrixInvertible(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?): Int` |
| [uiDrawMatrixMultiply](ui-draw-matrix-multiply.md) | `fun uiDrawMatrixMultiply(dest: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, src: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?)` |
| [uiDrawMatrixRotate](ui-draw-matrix-rotate.md) | `fun uiDrawMatrixRotate(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, x: Double, y: Double, amount: Double)` |
| [uiDrawMatrixScale](ui-draw-matrix-scale.md) | `fun uiDrawMatrixScale(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, xCenter: Double, yCenter: Double, x: Double, y: Double)` |
| [uiDrawMatrixSetIdentity](ui-draw-matrix-set-identity.md) | `fun uiDrawMatrixSetIdentity(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?)` |
| [uiDrawMatrixSkew](ui-draw-matrix-skew.md) | `fun uiDrawMatrixSkew(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, x: Double, y: Double, xamount: Double, yamount: Double)` |
| [uiDrawMatrixTransformPoint](ui-draw-matrix-transform-point.md) | `fun uiDrawMatrixTransformPoint(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, x: CValuesRef<DoubleVar>?, y: CValuesRef<DoubleVar>?)` |
| [uiDrawMatrixTransformSize](ui-draw-matrix-transform-size.md) | `fun uiDrawMatrixTransformSize(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, x: CValuesRef<DoubleVar>?, y: CValuesRef<DoubleVar>?)` |
| [uiDrawMatrixTranslate](ui-draw-matrix-translate.md) | `fun uiDrawMatrixTranslate(m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?, x: Double, y: Double)` |
| [uiDrawNewPath](ui-draw-new-path.md) | `fun uiDrawNewPath(fillMode: `[`uiDrawFillMode`](ui-draw-fill-mode.md)`): CPointer<`[`uiDrawPath`](ui-draw-path.md)`>?` |
| [uiDrawNewTextLayout](ui-draw-new-text-layout.md) | `fun uiDrawNewTextLayout(params: CValuesRef<`[`uiDrawTextLayoutParams`](ui-draw-text-layout-params/README.md)`>?): CPointer<`[`uiDrawTextLayout`](ui-draw-text-layout.md)`>?` |
| [uiDrawPathAddRectangle](ui-draw-path-add-rectangle.md) | `fun uiDrawPathAddRectangle(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, x: Double, y: Double, width: Double, height: Double)` |
| [uiDrawPathArcTo](ui-draw-path-arc-to.md) | `fun uiDrawPathArcTo(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int)` |
| [uiDrawPathBezierTo](ui-draw-path-bezier-to.md) | `fun uiDrawPathBezierTo(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, c1x: Double, c1y: Double, c2x: Double, c2y: Double, endX: Double, endY: Double)` |
| [uiDrawPathCloseFigure](ui-draw-path-close-figure.md) | `fun uiDrawPathCloseFigure(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?)` |
| [uiDrawPathEnd](ui-draw-path-end.md) | `fun uiDrawPathEnd(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?)` |
| [uiDrawPathLineTo](ui-draw-path-line-to.md) | `fun uiDrawPathLineTo(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, x: Double, y: Double)` |
| [uiDrawPathNewFigure](ui-draw-path-new-figure.md) | `fun uiDrawPathNewFigure(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, x: Double, y: Double)` |
| [uiDrawPathNewFigureWithArc](ui-draw-path-new-figure-with-arc.md) | `fun uiDrawPathNewFigureWithArc(p: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, xCenter: Double, yCenter: Double, radius: Double, startAngle: Double, sweep: Double, negative: Int)` |
| [uiDrawRestore](ui-draw-restore.md) | `fun uiDrawRestore(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?)` |
| [uiDrawSave](ui-draw-save.md) | `fun uiDrawSave(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?)` |
| [uiDrawStroke](ui-draw-stroke.md) | `fun uiDrawStroke(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?, path: CValuesRef<`[`uiDrawPath`](ui-draw-path.md)`>?, b: CValuesRef<`[`uiDrawBrush`](ui-draw-brush/README.md)`>?, p: CValuesRef<`[`uiDrawStrokeParams`](ui-draw-stroke-params/README.md)`>?)` |
| [uiDrawText](ui-draw-text.md) | `fun uiDrawText(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?, tl: CValuesRef<`[`uiDrawTextLayout`](ui-draw-text-layout.md)`>?, x: Double, y: Double)` |
| [uiDrawTextLayoutExtents](ui-draw-text-layout-extents.md) | `fun uiDrawTextLayoutExtents(tl: CValuesRef<`[`uiDrawTextLayout`](ui-draw-text-layout.md)`>?, width: CValuesRef<DoubleVar>?, height: CValuesRef<DoubleVar>?)` |
| [uiDrawTransform](ui-draw-transform.md) | `fun uiDrawTransform(c: CValuesRef<`[`uiDrawContext`](ui-draw-context.md)`>?, m: CValuesRef<`[`uiDrawMatrix`](ui-draw-matrix/README.md)`>?)` |
| [uiEditableComboboxAppend](ui-editable-combobox-append.md) | `fun uiEditableComboboxAppend(c: CValuesRef<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?, text: String?)` |
| [uiEditableComboboxOnChanged](ui-editable-combobox-on-changed.md) | `fun uiEditableComboboxOnChanged(c: CValuesRef<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiEditableComboboxSetText](ui-editable-combobox-set-text.md) | `fun uiEditableComboboxSetText(c: CValuesRef<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?, text: String?)` |
| [uiEditableComboboxText](ui-editable-combobox-text.md) | `fun uiEditableComboboxText(c: CValuesRef<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?): CPointer<ByteVar>?` |
| [uiEntryOnChanged](ui-entry-on-changed.md) | `fun uiEntryOnChanged(e: CValuesRef<`[`uiEntry`](ui-entry.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiEntry`](ui-entry.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiEntryReadOnly](ui-entry-read-only.md) | `fun uiEntryReadOnly(e: CValuesRef<`[`uiEntry`](ui-entry.md)`>?): Int` |
| [uiEntrySetReadOnly](ui-entry-set-read-only.md) | `fun uiEntrySetReadOnly(e: CValuesRef<`[`uiEntry`](ui-entry.md)`>?, readonly: Int)` |
| [uiEntrySetText](ui-entry-set-text.md) | `fun uiEntrySetText(e: CValuesRef<`[`uiEntry`](ui-entry.md)`>?, text: String?)` |
| [uiEntryText](ui-entry-text.md) | `fun uiEntryText(e: CValuesRef<`[`uiEntry`](ui-entry.md)`>?): CPointer<ByteVar>?` |
| [uiFontButtonFont](ui-font-button-font.md) | `fun uiFontButtonFont(b: CValuesRef<`[`uiFontButton`](ui-font-button.md)`>?, desc: CValuesRef<`[`uiFontDescriptor`](ui-font-descriptor/README.md)`>?)` |
| [uiFontButtonOnChanged](ui-font-button-on-changed.md) | `fun uiFontButtonOnChanged(b: CValuesRef<`[`uiFontButton`](ui-font-button.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiFontButton`](ui-font-button.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiFormAppend](ui-form-append.md) | `fun uiFormAppend(f: CValuesRef<`[`uiForm`](ui-form.md)`>?, label: String?, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, stretchy: Int)` |
| [uiFormDelete](ui-form-delete.md) | `fun uiFormDelete(f: CValuesRef<`[`uiForm`](ui-form.md)`>?, index: Int)` |
| [uiFormPadded](ui-form-padded.md) | `fun uiFormPadded(f: CValuesRef<`[`uiForm`](ui-form.md)`>?): Int` |
| [uiFormSetPadded](ui-form-set-padded.md) | `fun uiFormSetPadded(f: CValuesRef<`[`uiForm`](ui-form.md)`>?, padded: Int)` |
| [uiFreeAttribute](ui-free-attribute.md) | `fun uiFreeAttribute(a: CValuesRef<`[`uiAttribute`](ui-attribute.md)`>?)` |
| [uiFreeAttributedString](ui-free-attributed-string.md) | `fun uiFreeAttributedString(s: CValuesRef<`[`uiAttributedString`](ui-attributed-string.md)`>?)` |
| [uiFreeControl](ui-free-control.md) | `fun uiFreeControl(arg0: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiFreeFontButtonFont](ui-free-font-button-font.md) | `fun uiFreeFontButtonFont(desc: CValuesRef<`[`uiFontDescriptor`](ui-font-descriptor/README.md)`>?)` |
| [uiFreeImage](ui-free-image.md) | `fun uiFreeImage(i: CValuesRef<`[`uiImage`](ui-image.md)`>?)` |
| [uiFreeInitError](ui-free-init-error.md) | `fun uiFreeInitError(err: CValuesRef<ByteVar>?)` |
| [uiFreeOpenTypeFeatures](ui-free-open-type-features.md) | `fun uiFreeOpenTypeFeatures(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?)` |
| [uiFreeTableModel](ui-free-table-model.md) | `fun uiFreeTableModel(m: CValuesRef<`[`uiTableModel`](ui-table-model.md)`>?)` |
| [uiFreeTableValue](ui-free-table-value.md) | `fun uiFreeTableValue(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?)` |
| [uiFreeText](ui-free-text.md) | `fun uiFreeText(text: CValuesRef<ByteVar>?)` |
| [uiGridAppend](ui-grid-append.md) | `fun uiGridAppend(g: CValuesRef<`[`uiGrid`](ui-grid.md)`>?, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, left: Int, top: Int, xspan: Int, yspan: Int, hexpand: Int, halign: `[`uiAlign`](ui-align.md)`, vexpand: Int, valign: `[`uiAlign`](ui-align.md)`)` |
| [uiGridInsertAt](ui-grid-insert-at.md) | `fun uiGridInsertAt(g: CValuesRef<`[`uiGrid`](ui-grid.md)`>?, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, existing: CValuesRef<`[`uiControl`](ui-control/README.md)`>?, at: `[`uiAt`](ui-at.md)`, xspan: Int, yspan: Int, hexpand: Int, halign: `[`uiAlign`](ui-align.md)`, vexpand: Int, valign: `[`uiAlign`](ui-align.md)`)` |
| [uiGridPadded](ui-grid-padded.md) | `fun uiGridPadded(g: CValuesRef<`[`uiGrid`](ui-grid.md)`>?): Int` |
| [uiGridSetPadded](ui-grid-set-padded.md) | `fun uiGridSetPadded(g: CValuesRef<`[`uiGrid`](ui-grid.md)`>?, padded: Int)` |
| [uiGroupMargined](ui-group-margined.md) | `fun uiGroupMargined(g: CValuesRef<`[`uiGroup`](ui-group.md)`>?): Int` |
| [uiGroupSetChild](ui-group-set-child.md) | `fun uiGroupSetChild(g: CValuesRef<`[`uiGroup`](ui-group.md)`>?, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiGroupSetMargined](ui-group-set-margined.md) | `fun uiGroupSetMargined(g: CValuesRef<`[`uiGroup`](ui-group.md)`>?, margined: Int)` |
| [uiGroupSetTitle](ui-group-set-title.md) | `fun uiGroupSetTitle(g: CValuesRef<`[`uiGroup`](ui-group.md)`>?, title: String?)` |
| [uiGroupTitle](ui-group-title.md) | `fun uiGroupTitle(g: CValuesRef<`[`uiGroup`](ui-group.md)`>?): CPointer<ByteVar>?` |
| [uiImageAppend](ui-image-append.md) | `fun uiImageAppend(i: CValuesRef<`[`uiImage`](ui-image.md)`>?, pixels: CValuesRef<*>?, pixelWidth: Int, pixelHeight: Int, byteStride: Int)` |
| [uiInit](ui-init.md) | `fun uiInit(options: CValuesRef<`[`uiInitOptions`](ui-init-options/README.md)`>?): CPointer<ByteVar>?` |
| [uiLabelSetText](ui-label-set-text.md) | `fun uiLabelSetText(l: CValuesRef<`[`uiLabel`](ui-label.md)`>?, text: String?)` |
| [uiLabelText](ui-label-text.md) | `fun uiLabelText(l: CValuesRef<`[`uiLabel`](ui-label.md)`>?): CPointer<ByteVar>?` |
| [uiMain](ui-main.md) | `fun uiMain()` |
| [uiMainStep](ui-main-step.md) | `fun uiMainStep(wait: Int): Int` |
| [uiMainSteps](ui-main-steps.md) | `fun uiMainSteps()` |
| [uiMenuAppendAboutItem](ui-menu-append-about-item.md) | `fun uiMenuAppendAboutItem(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?): CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?` |
| [uiMenuAppendCheckItem](ui-menu-append-check-item.md) | `fun uiMenuAppendCheckItem(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?, name: String?): CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?` |
| [uiMenuAppendItem](ui-menu-append-item.md) | `fun uiMenuAppendItem(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?, name: String?): CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?` |
| [uiMenuAppendPreferencesItem](ui-menu-append-preferences-item.md) | `fun uiMenuAppendPreferencesItem(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?): CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?` |
| [uiMenuAppendQuitItem](ui-menu-append-quit-item.md) | `fun uiMenuAppendQuitItem(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?): CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?` |
| [uiMenuAppendSeparator](ui-menu-append-separator.md) | `fun uiMenuAppendSeparator(m: CValuesRef<`[`uiMenu`](ui-menu.md)`>?)` |
| [uiMenuItemChecked](ui-menu-item-checked.md) | `fun uiMenuItemChecked(m: CValuesRef<`[`uiMenuItem`](ui-menu-item.md)`>?): Int` |
| [uiMenuItemDisable](ui-menu-item-disable.md) | `fun uiMenuItemDisable(m: CValuesRef<`[`uiMenuItem`](ui-menu-item.md)`>?)` |
| [uiMenuItemEnable](ui-menu-item-enable.md) | `fun uiMenuItemEnable(m: CValuesRef<`[`uiMenuItem`](ui-menu-item.md)`>?)` |
| [uiMenuItemOnClicked](ui-menu-item-on-clicked.md) | `fun uiMenuItemOnClicked(m: CValuesRef<`[`uiMenuItem`](ui-menu-item.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiMenuItem`](ui-menu-item.md)`>?, CPointer<`[`uiWindow`](ui-window.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiMenuItemSetChecked](ui-menu-item-set-checked.md) | `fun uiMenuItemSetChecked(m: CValuesRef<`[`uiMenuItem`](ui-menu-item.md)`>?, checked: Int)` |
| [uiMsgBox](ui-msg-box.md) | `fun uiMsgBox(parent: CValuesRef<`[`uiWindow`](ui-window.md)`>?, title: String?, description: String?)` |
| [uiMsgBoxError](ui-msg-box-error.md) | `fun uiMsgBoxError(parent: CValuesRef<`[`uiWindow`](ui-window.md)`>?, title: String?, description: String?)` |
| [uiMultilineEntryAppend](ui-multiline-entry-append.md) | `fun uiMultilineEntryAppend(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?, text: String?)` |
| [uiMultilineEntryOnChanged](ui-multiline-entry-on-changed.md) | `fun uiMultilineEntryOnChanged(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiMultilineEntryReadOnly](ui-multiline-entry-read-only.md) | `fun uiMultilineEntryReadOnly(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?): Int` |
| [uiMultilineEntrySetReadOnly](ui-multiline-entry-set-read-only.md) | `fun uiMultilineEntrySetReadOnly(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?, readonly: Int)` |
| [uiMultilineEntrySetText](ui-multiline-entry-set-text.md) | `fun uiMultilineEntrySetText(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?, text: String?)` |
| [uiMultilineEntryText](ui-multiline-entry-text.md) | `fun uiMultilineEntryText(e: CValuesRef<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?): CPointer<ByteVar>?` |
| [uiNewArea](ui-new-area.md) | `fun uiNewArea(ah: CValuesRef<`[`uiAreaHandler`](ui-area-handler/README.md)`>?): CPointer<`[`uiArea`](ui-area.md)`>?` |
| [uiNewAttributedString](ui-new-attributed-string.md) | `fun uiNewAttributedString(initialString: String?): CPointer<`[`uiAttributedString`](ui-attributed-string.md)`>?` |
| [uiNewBackgroundAttribute](ui-new-background-attribute.md) | `fun uiNewBackgroundAttribute(r: Double, g: Double, b: Double, a: Double): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewButton](ui-new-button.md) | `fun uiNewButton(text: String?): CPointer<`[`uiButton`](ui-button.md)`>?` |
| [uiNewCheckbox](ui-new-checkbox.md) | `fun uiNewCheckbox(text: String?): CPointer<`[`uiCheckbox`](ui-checkbox.md)`>?` |
| [uiNewColorAttribute](ui-new-color-attribute.md) | `fun uiNewColorAttribute(r: Double, g: Double, b: Double, a: Double): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewColorButton](ui-new-color-button.md) | `fun uiNewColorButton(): CPointer<`[`uiColorButton`](ui-color-button.md)`>?` |
| [uiNewCombobox](ui-new-combobox.md) | `fun uiNewCombobox(): CPointer<`[`uiCombobox`](ui-combobox.md)`>?` |
| [uiNewDatePicker](ui-new-date-picker.md) | `fun uiNewDatePicker(): CPointer<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?` |
| [uiNewDateTimePicker](ui-new-date-time-picker.md) | `fun uiNewDateTimePicker(): CPointer<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?` |
| [uiNewEditableCombobox](ui-new-editable-combobox.md) | `fun uiNewEditableCombobox(): CPointer<`[`uiEditableCombobox`](ui-editable-combobox.md)`>?` |
| [uiNewEntry](ui-new-entry.md) | `fun uiNewEntry(): CPointer<`[`uiEntry`](ui-entry.md)`>?` |
| [uiNewFamilyAttribute](ui-new-family-attribute.md) | `fun uiNewFamilyAttribute(family: String?): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewFeaturesAttribute](ui-new-features-attribute.md) | `fun uiNewFeaturesAttribute(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewFontButton](ui-new-font-button.md) | `fun uiNewFontButton(): CPointer<`[`uiFontButton`](ui-font-button.md)`>?` |
| [uiNewForm](ui-new-form.md) | `fun uiNewForm(): CPointer<`[`uiForm`](ui-form.md)`>?` |
| [uiNewGrid](ui-new-grid.md) | `fun uiNewGrid(): CPointer<`[`uiGrid`](ui-grid.md)`>?` |
| [uiNewGroup](ui-new-group.md) | `fun uiNewGroup(title: String?): CPointer<`[`uiGroup`](ui-group.md)`>?` |
| [uiNewHorizontalBox](ui-new-horizontal-box.md) | `fun uiNewHorizontalBox(): CPointer<`[`uiBox`](ui-box.md)`>?` |
| [uiNewHorizontalSeparator](ui-new-horizontal-separator.md) | `fun uiNewHorizontalSeparator(): CPointer<`[`uiSeparator`](ui-separator.md)`>?` |
| [uiNewImage](ui-new-image.md) | `fun uiNewImage(width: Double, height: Double): CPointer<`[`uiImage`](ui-image.md)`>?` |
| [uiNewItalicAttribute](ui-new-italic-attribute.md) | `fun uiNewItalicAttribute(italic: `[`uiTextItalic`](ui-text-italic.md)`): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewLabel](ui-new-label.md) | `fun uiNewLabel(text: String?): CPointer<`[`uiLabel`](ui-label.md)`>?` |
| [uiNewMenu](ui-new-menu.md) | `fun uiNewMenu(name: String?): CPointer<`[`uiMenu`](ui-menu.md)`>?` |
| [uiNewMultilineEntry](ui-new-multiline-entry.md) | `fun uiNewMultilineEntry(): CPointer<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?` |
| [uiNewNonWrappingMultilineEntry](ui-new-non-wrapping-multiline-entry.md) | `fun uiNewNonWrappingMultilineEntry(): CPointer<`[`uiMultilineEntry`](ui-multiline-entry.md)`>?` |
| [uiNewOpenTypeFeatures](ui-new-open-type-features.md) | `fun uiNewOpenTypeFeatures(): CPointer<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?` |
| [uiNewPasswordEntry](ui-new-password-entry.md) | `fun uiNewPasswordEntry(): CPointer<`[`uiEntry`](ui-entry.md)`>?` |
| [uiNewProgressBar](ui-new-progress-bar.md) | `fun uiNewProgressBar(): CPointer<`[`uiProgressBar`](ui-progress-bar.md)`>?` |
| [uiNewRadioButtons](ui-new-radio-buttons.md) | `fun uiNewRadioButtons(): CPointer<`[`uiRadioButtons`](ui-radio-buttons.md)`>?` |
| [uiNewScrollingArea](ui-new-scrolling-area.md) | `fun uiNewScrollingArea(ah: CValuesRef<`[`uiAreaHandler`](ui-area-handler/README.md)`>?, width: Int, height: Int): CPointer<`[`uiArea`](ui-area.md)`>?` |
| [uiNewSearchEntry](ui-new-search-entry.md) | `fun uiNewSearchEntry(): CPointer<`[`uiEntry`](ui-entry.md)`>?` |
| [uiNewSizeAttribute](ui-new-size-attribute.md) | `fun uiNewSizeAttribute(size: Double): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewSlider](ui-new-slider.md) | `fun uiNewSlider(min: Int, max: Int): CPointer<`[`uiSlider`](ui-slider.md)`>?` |
| [uiNewSpinbox](ui-new-spinbox.md) | `fun uiNewSpinbox(min: Int, max: Int): CPointer<`[`uiSpinbox`](ui-spinbox.md)`>?` |
| [uiNewStretchAttribute](ui-new-stretch-attribute.md) | `fun uiNewStretchAttribute(stretch: `[`uiTextStretch`](ui-text-stretch.md)`): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewTab](ui-new-tab.md) | `fun uiNewTab(): CPointer<`[`uiTab`](ui-tab.md)`>?` |
| [uiNewTable](ui-new-table.md) | `fun uiNewTable(params: CValuesRef<`[`uiTableParams`](ui-table-params/README.md)`>?): CPointer<`[`uiTable`](ui-table.md)`>?` |
| [uiNewTableModel](ui-new-table-model.md) | `fun uiNewTableModel(mh: CValuesRef<`[`uiTableModelHandler`](ui-table-model-handler/README.md)`>?): CPointer<`[`uiTableModel`](ui-table-model.md)`>?` |
| [uiNewTableValueColor](ui-new-table-value-color.md) | `fun uiNewTableValueColor(r: Double, g: Double, b: Double, a: Double): CPointer<`[`uiTableValue`](ui-table-value.md)`>?` |
| [uiNewTableValueImage](ui-new-table-value-image.md) | `fun uiNewTableValueImage(img: CValuesRef<`[`uiImage`](ui-image.md)`>?): CPointer<`[`uiTableValue`](ui-table-value.md)`>?` |
| [uiNewTableValueInt](ui-new-table-value-int.md) | `fun uiNewTableValueInt(i: Int): CPointer<`[`uiTableValue`](ui-table-value.md)`>?` |
| [uiNewTableValueString](ui-new-table-value-string.md) | `fun uiNewTableValueString(str: String?): CPointer<`[`uiTableValue`](ui-table-value.md)`>?` |
| [uiNewTimePicker](ui-new-time-picker.md) | `fun uiNewTimePicker(): CPointer<`[`uiDateTimePicker`](ui-date-time-picker.md)`>?` |
| [uiNewUnderlineAttribute](ui-new-underline-attribute.md) | `fun uiNewUnderlineAttribute(u: `[`uiUnderline`](ui-underline.md)`): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewUnderlineColorAttribute](ui-new-underline-color-attribute.md) | `fun uiNewUnderlineColorAttribute(u: `[`uiUnderlineColor`](ui-underline-color.md)`, r: Double, g: Double, b: Double, a: Double): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewVerticalBox](ui-new-vertical-box.md) | `fun uiNewVerticalBox(): CPointer<`[`uiBox`](ui-box.md)`>?` |
| [uiNewVerticalSeparator](ui-new-vertical-separator.md) | `fun uiNewVerticalSeparator(): CPointer<`[`uiSeparator`](ui-separator.md)`>?` |
| [uiNewWeightAttribute](ui-new-weight-attribute.md) | `fun uiNewWeightAttribute(weight: `[`uiTextWeight`](ui-text-weight.md)`): CPointer<`[`uiAttribute`](ui-attribute.md)`>?` |
| [uiNewWindow](ui-new-window.md) | `fun uiNewWindow(title: String?, width: Int, height: Int, hasMenubar: Int): CPointer<`[`uiWindow`](ui-window.md)`>?` |
| [uiOnShouldQuit](ui-on-should-quit.md) | `fun uiOnShouldQuit(f: CPointer<CFunction<(COpaquePointer?) -> Int>>?, data: CValuesRef<*>?)` |
| [uiOpenFile](ui-open-file.md) | `fun uiOpenFile(parent: CValuesRef<`[`uiWindow`](ui-window.md)`>?): CPointer<ByteVar>?` |
| [uiOpenFolder](ui-open-folder.md) | `fun uiOpenFolder(parent: CValuesRef<`[`uiWindow`](ui-window.md)`>?): CPointer<ByteVar>?` |
| [uiOpenTypeFeaturesAdd](ui-open-type-features-add.md) | `fun uiOpenTypeFeaturesAdd(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?, a: Byte, b: Byte, c: Byte, d: Byte, value: uint32_t)` |
| [uiOpenTypeFeaturesClone](ui-open-type-features-clone.md) | `fun uiOpenTypeFeaturesClone(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?): CPointer<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?` |
| [uiOpenTypeFeaturesForEach](ui-open-type-features-for-each.md) | `fun uiOpenTypeFeaturesForEach(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?, f: `[`uiOpenTypeFeaturesForEachFunc`](ui-open-type-features-for-each-func.md)`?, data: CValuesRef<*>?)` |
| [uiOpenTypeFeaturesGet](ui-open-type-features-get.md) | `fun uiOpenTypeFeaturesGet(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?, a: Byte, b: Byte, c: Byte, d: Byte, value: CValuesRef<<ERROR CLASS><uint32_t>>?): Int` |
| [uiOpenTypeFeaturesRemove](ui-open-type-features-remove.md) | `fun uiOpenTypeFeaturesRemove(otf: CValuesRef<`[`uiOpenTypeFeatures`](ui-open-type-features.md)`>?, a: Byte, b: Byte, c: Byte, d: Byte)` |
| [uiProgressBarSetValue](ui-progress-bar-set-value.md) | `fun uiProgressBarSetValue(p: CValuesRef<`[`uiProgressBar`](ui-progress-bar.md)`>?, n: Int)` |
| [uiProgressBarValue](ui-progress-bar-value.md) | `fun uiProgressBarValue(p: CValuesRef<`[`uiProgressBar`](ui-progress-bar.md)`>?): Int` |
| [uiQueueMain](ui-queue-main.md) | `fun uiQueueMain(f: CPointer<CFunction<(COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiQuit](ui-quit.md) | `fun uiQuit()` |
| [uiRadioButtonsAppend](ui-radio-buttons-append.md) | `fun uiRadioButtonsAppend(r: CValuesRef<`[`uiRadioButtons`](ui-radio-buttons.md)`>?, text: String?)` |
| [uiRadioButtonsOnSelected](ui-radio-buttons-on-selected.md) | `fun uiRadioButtonsOnSelected(r: CValuesRef<`[`uiRadioButtons`](ui-radio-buttons.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiRadioButtons`](ui-radio-buttons.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiRadioButtonsSelected](ui-radio-buttons-selected.md) | `fun uiRadioButtonsSelected(r: CValuesRef<`[`uiRadioButtons`](ui-radio-buttons.md)`>?): Int` |
| [uiRadioButtonsSetSelected](ui-radio-buttons-set-selected.md) | `fun uiRadioButtonsSetSelected(r: CValuesRef<`[`uiRadioButtons`](ui-radio-buttons.md)`>?, n: Int)` |
| [uiSaveFile](ui-save-file.md) | `fun uiSaveFile(parent: CValuesRef<`[`uiWindow`](ui-window.md)`>?): CPointer<ByteVar>?` |
| [uiSliderOnChanged](ui-slider-on-changed.md) | `fun uiSliderOnChanged(s: CValuesRef<`[`uiSlider`](ui-slider.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiSlider`](ui-slider.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiSliderSetValue](ui-slider-set-value.md) | `fun uiSliderSetValue(s: CValuesRef<`[`uiSlider`](ui-slider.md)`>?, value: Int)` |
| [uiSliderValue](ui-slider-value.md) | `fun uiSliderValue(s: CValuesRef<`[`uiSlider`](ui-slider.md)`>?): Int` |
| [uiSpinboxOnChanged](ui-spinbox-on-changed.md) | `fun uiSpinboxOnChanged(s: CValuesRef<`[`uiSpinbox`](ui-spinbox.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiSpinbox`](ui-spinbox.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiSpinboxSetValue](ui-spinbox-set-value.md) | `fun uiSpinboxSetValue(s: CValuesRef<`[`uiSpinbox`](ui-spinbox.md)`>?, value: Int)` |
| [uiSpinboxValue](ui-spinbox-value.md) | `fun uiSpinboxValue(s: CValuesRef<`[`uiSpinbox`](ui-spinbox.md)`>?): Int` |
| [uiTabAppend](ui-tab-append.md) | `fun uiTabAppend(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?, name: String?, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiTabDelete](ui-tab-delete.md) | `fun uiTabDelete(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?, index: Int)` |
| [uiTabInsertAt](ui-tab-insert-at.md) | `fun uiTabInsertAt(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?, name: String?, before: Int, c: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiTabMargined](ui-tab-margined.md) | `fun uiTabMargined(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?, page: Int): Int` |
| [uiTabNumPages](ui-tab-num-pages.md) | `fun uiTabNumPages(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?): Int` |
| [uiTabSetMargined](ui-tab-set-margined.md) | `fun uiTabSetMargined(t: CValuesRef<`[`uiTab`](ui-tab.md)`>?, page: Int, margined: Int)` |
| [uiTableAppendButtonColumn](ui-table-append-button-column.md) | `fun uiTableAppendButtonColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, buttonModelColumn: Int, buttonClickableModelColumn: Int)` |
| [uiTableAppendCheckboxColumn](ui-table-append-checkbox-column.md) | `fun uiTableAppendCheckboxColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, checkboxModelColumn: Int, checkboxEditableModelColumn: Int)` |
| [uiTableAppendCheckboxTextColumn](ui-table-append-checkbox-text-column.md) | `fun uiTableAppendCheckboxTextColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, checkboxModelColumn: Int, checkboxEditableModelColumn: Int, textModelColumn: Int, textEditableModelColumn: Int, textParams: CValuesRef<`[`uiTableTextColumnOptionalParams`](ui-table-text-column-optional-params/README.md)`>?)` |
| [uiTableAppendImageColumn](ui-table-append-image-column.md) | `fun uiTableAppendImageColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, imageModelColumn: Int)` |
| [uiTableAppendImageTextColumn](ui-table-append-image-text-column.md) | `fun uiTableAppendImageTextColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, imageModelColumn: Int, textModelColumn: Int, textEditableModelColumn: Int, textParams: CValuesRef<`[`uiTableTextColumnOptionalParams`](ui-table-text-column-optional-params/README.md)`>?)` |
| [uiTableAppendProgressBarColumn](ui-table-append-progress-bar-column.md) | `fun uiTableAppendProgressBarColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, progressModelColumn: Int)` |
| [uiTableAppendTextColumn](ui-table-append-text-column.md) | `fun uiTableAppendTextColumn(t: CValuesRef<`[`uiTable`](ui-table.md)`>?, name: String?, textModelColumn: Int, textEditableModelColumn: Int, textParams: CValuesRef<`[`uiTableTextColumnOptionalParams`](ui-table-text-column-optional-params/README.md)`>?)` |
| [uiTableModelRowChanged](ui-table-model-row-changed.md) | `fun uiTableModelRowChanged(m: CValuesRef<`[`uiTableModel`](ui-table-model.md)`>?, index: Int)` |
| [uiTableModelRowDeleted](ui-table-model-row-deleted.md) | `fun uiTableModelRowDeleted(m: CValuesRef<`[`uiTableModel`](ui-table-model.md)`>?, oldIndex: Int)` |
| [uiTableModelRowInserted](ui-table-model-row-inserted.md) | `fun uiTableModelRowInserted(m: CValuesRef<`[`uiTableModel`](ui-table-model.md)`>?, newIndex: Int)` |
| [uiTableValueColor](ui-table-value-color.md) | `fun uiTableValueColor(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?, r: CValuesRef<DoubleVar>?, g: CValuesRef<DoubleVar>?, b: CValuesRef<DoubleVar>?, a: CValuesRef<DoubleVar>?)` |
| [uiTableValueGetType](ui-table-value-get-type.md) | `fun uiTableValueGetType(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?): `[`uiTableValueType`](ui-table-value-type.md) |
| [uiTableValueImage](ui-table-value-image.md) | `fun uiTableValueImage(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?): CPointer<`[`uiImage`](ui-image.md)`>?` |
| [uiTableValueInt](ui-table-value-int.md) | `fun uiTableValueInt(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?): Int` |
| [uiTableValueString](ui-table-value-string.md) | `fun uiTableValueString(v: CValuesRef<`[`uiTableValue`](ui-table-value.md)`>?): CPointer<ByteVar>?` |
| [uiTimer](ui-timer.md) | `fun uiTimer(milliseconds: Int, f: CPointer<CFunction<(COpaquePointer?) -> Int>>?, data: CValuesRef<*>?)` |
| [uiUninit](ui-uninit.md) | `fun uiUninit()` |
| [uiUserBugCannotSetParentOnToplevel](ui-user-bug-cannot-set-parent-on-toplevel.md) | `fun uiUserBugCannotSetParentOnToplevel(type: String?)` |
| [uiWindowBorderless](ui-window-borderless.md) | `fun uiWindowBorderless(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?): Int` |
| [uiWindowContentSize](ui-window-content-size.md) | `fun uiWindowContentSize(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, width: CValuesRef<IntVar>?, height: CValuesRef<IntVar>?)` |
| [uiWindowFullscreen](ui-window-fullscreen.md) | `fun uiWindowFullscreen(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?): Int` |
| [uiWindowMargined](ui-window-margined.md) | `fun uiWindowMargined(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?): Int` |
| [uiWindowOnClosing](ui-window-on-closing.md) | `fun uiWindowOnClosing(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiWindow`](ui-window.md)`>?, COpaquePointer?) -> Int>>?, data: CValuesRef<*>?)` |
| [uiWindowOnContentSizeChanged](ui-window-on-content-size-changed.md) | `fun uiWindowOnContentSizeChanged(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, f: CPointer<CFunction<(CPointer<`[`uiWindow`](ui-window.md)`>?, COpaquePointer?) -> Unit>>?, data: CValuesRef<*>?)` |
| [uiWindowSetBorderless](ui-window-set-borderless.md) | `fun uiWindowSetBorderless(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, borderless: Int)` |
| [uiWindowSetChild](ui-window-set-child.md) | `fun uiWindowSetChild(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, child: CValuesRef<`[`uiControl`](ui-control/README.md)`>?)` |
| [uiWindowSetContentSize](ui-window-set-content-size.md) | `fun uiWindowSetContentSize(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, width: Int, height: Int)` |
| [uiWindowSetFullscreen](ui-window-set-fullscreen.md) | `fun uiWindowSetFullscreen(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, fullscreen: Int)` |
| [uiWindowSetMargined](ui-window-set-margined.md) | `fun uiWindowSetMargined(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, margined: Int)` |
| [uiWindowSetTitle](ui-window-set-title.md) | `fun uiWindowSetTitle(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?, title: String?)` |
| [uiWindowTitle](ui-window-title.md) | `fun uiWindowTitle(w: CValuesRef<`[`uiWindow`](ui-window.md)`>?): CPointer<ByteVar>?` |
