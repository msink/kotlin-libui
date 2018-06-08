import libui.*

/*
fun appendWithAttribute(const char *what, uiAttribute *attr, uiAttribute *attr2)
{
    size_t start, end

    start = uiAttributedStringLen(attrstr)
    end = start + strlen(what)
    uiAttributedStringAppendUnattributed(attrstr, what)
    uiAttributedStringSetAttribute(attrstr, attr, start, end)
    if (attr2 != NULL)
        uiAttributedStringSetAttribute(attrstr, attr2, start, end)
}

fun makeAttributedString(void)
{
    uiAttribute *attr, *attr2
    uiOpenTypeFeatures *otf

    attrstr = uiNewAttributedString(
        "Drawing strings with libui is done with the uiAttributedString and uiDrawTextLayout objects.\n"
        "uiAttributedString lets you have a variety of attributes: ")

    attr = uiNewFamilyAttribute("Courier New")
    appendWithAttribute("font family", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewSizeAttribute(18)
    appendWithAttribute("font size", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewWeightAttribute(uiTextWeightBold)
    appendWithAttribute("font weight", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewItalicAttribute(uiTextItalicItalic)
    appendWithAttribute("font italicness", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewStretchAttribute(uiTextStretchCondensed)
    appendWithAttribute("font stretch", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewColorAttribute(0.75, 0.25, 0.5, 0.75)
    appendWithAttribute("text color", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    attr = uiNewBackgroundAttribute(0.5, 0.5, 0.25, 0.5)
    appendWithAttribute("text background color", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")


    attr = uiNewUnderlineAttribute(uiUnderlineSingle)
    appendWithAttribute("underline style", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, ", ")

    uiAttributedStringAppendUnattributed(attrstr, "and ")
    attr = uiNewUnderlineAttribute(uiUnderlineDouble)
    attr2 = uiNewUnderlineColorAttribute(uiUnderlineColorCustom, 1.0, 0.0, 0.5, 1.0)
    appendWithAttribute("underline color", attr, attr2)
    uiAttributedStringAppendUnattributed(attrstr, ". ")

    uiAttributedStringAppendUnattributed(attrstr, "Furthermore, there are attributes allowing for ")
    attr = uiNewUnderlineAttribute(uiUnderlineSuggestion)
    attr2 = uiNewUnderlineColorAttribute(uiUnderlineColorSpelling, 0, 0, 0, 0)
    appendWithAttribute("special underlines for indicating spelling errors", attr, attr2)
    uiAttributedStringAppendUnattributed(attrstr, " (and other types of errors) ")

    uiAttributedStringAppendUnattributed(attrstr, "and control over OpenType features such as ligatures (for instance, ")
    otf = uiNewOpenTypeFeatures()
    uiOpenTypeFeaturesAdd(otf, 'l', 'i', 'g', 'a', 0)
    attr = uiNewFeaturesAttribute(otf)
    appendWithAttribute("afford", attr, NULL)
    uiAttributedStringAppendUnattributed(attrstr, " vs. ")
    uiOpenTypeFeaturesAdd(otf, 'l', 'i', 'g', 'a', 1)
    attr = uiNewFeaturesAttribute(otf)
    appendWithAttribute("afford", attr, NULL)
    uiFreeOpenTypeFeatures(otf)
    uiAttributedStringAppendUnattributed(attrstr, ").\n")

    uiAttributedStringAppendUnattributed(attrstr, "Use the controls opposite to the text to control properties of the text.")
}
*/

fun main(args: Array<String>) = application {

    Window("libui Text-Drawing Example", 640, 480) {
        margined = true
        onClose { uiQuit(); true }
        onShouldQuit { destroy(); true }

//      val attrstr = makeAttributedString()

        val fontButton = FontButton()

        val alignment = Combobox {
            append("Left")
            append("Center")
            append("Right")
            selected = 0
        }

        val area = Area(AreaHandler(draw = { /*draw ->
            uiDrawTextLayout *textLayout
            uiFontDescriptor defaultFont
            uiDrawTextLayoutParams params
        
            params.String = attrstr
            uiFontButtonFont(fontButton, &defaultFont)
            params.DefaultFont = &defaultFont
            params.Width = draw.AreaWidth
            params.Align = alignment.selected
            textLayout = uiDrawNewTextLayout(&params)
            uiDrawText(draw.Context, textLayout, 0, 0)
            uiDrawFreeTextLayout(textLayout)
            uiFreeFontButtonFont(&defaultFont)*/
        }))

        fontButton.action { area.queueRedrawAll() }
        alignment.action { area.queueRedrawAll() }

        setChild(HorizontalBox {
            padded = true
            append(VerticalBox {
                padded = true
                append(fontButton)
                append(Form {
                    padded = true
                    append("Alignment", alignment)
                })
            })
            append(area, stretchy = true)
        })
        show()
    }
//  uiFreeAttributedString(attrstr)
}
