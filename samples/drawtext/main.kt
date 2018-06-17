import libui.*

fun AttributedString.append(what: String, attr: Attribute, attr2: Attribute? = null) {
    val start = length
    val end = start + what.length
    append(what)
    setAttribute(attr, start, end)
    if (attr2 != null)
        setAttribute(attr2, start, end)
}

fun Area.makeAttributedString() = AttributedString(
    "Drawing strings with libui is done with the uiAttributedString and uiDrawTextLayout objects.\n" +
    "uiAttributedString lets you have a variety of attributes: ").apply {
    append("font family", FamilyAttribute("Courier New"))
    append(", ")
    append("font size", SizeAttribute(18.0))
    append(", ")
    append("font weight", WeightAttribute(uiTextWeightBold))
    append(", ")
    append("font italicness", ItalicAttribute(uiTextItalicItalic))
    append(", ")
    append("font stretch", StretchAttribute(uiTextStretchCondensed))
    append(", ")
    append("text color", ColorAttribute(RGBA(0.75, 0.25, 0.5, 0.75)))
    append(", ")
    append("text background color", BackgroundAttribute(RGBA(0.5, 0.5, 0.25, 0.5)))
    append(", ")
    append("underline style", UnderlineAttribute(uiUnderlineSingle))
    append(", ")
    append("and ")
    append("underline color",
           UnderlineAttribute(uiUnderlineDouble),
           UnderlineColorAttribute(uiUnderlineColorCustom, RGBA(1.0, 0.0, 0.5, 1.0)))
    append(". ")
    append("Furthermore, there are attributes allowing for ")
    append("special underlines for indicating spelling errors",
           UnderlineAttribute(uiUnderlineSuggestion),
           UnderlineColorAttribute(uiUnderlineColorSpelling, RGBA(0.0, 0.0, 0.0, 0.0)))
    append(" (and other types of errors) ")
    append("and control over OpenType features such as ligatures (for instance, ")

    val otf = OpenTypeFeatures()
    otf.add("liga", 0)
    append("afford", FeaturesAttribute(otf))
    append(" vs. ")
    otf.add("liga", 1)
    append("afford", FeaturesAttribute(otf))
    otf.dispose()
    append(").\n")

    append("Use the controls opposite to the text to control properties of the text.")
}

fun main(args: Array<String>) = libuiApplication {

    Window("libui Text-Drawing Example", 640, 480) {
        margined = true
        onClose { uiQuit(); true }
        onShouldQuit { destroy(); true }

        val defaultFont = FontButton()

        val alignment = Combobox {
            add("Left")
            add("Center")
            add("Right")
            value = 0
        }

        val area = Area {
            val astr = makeAttributedString()
            draw { draw ->
                val context = draw.Context!!
                context.draw(astr, defaultFont.value, draw.AreaWidth, alignment.value, 0.0, 0.0)
            }
        }

        defaultFont.action { area.queueRedrawAll() }
        alignment.action { area.queueRedrawAll() }

        add(HorizontalBox {
            padded = true
            add(VerticalBox {
                padded = true
                add(defaultFont)
                add(Form {
                    padded = true
                    add("Alignment", alignment)
                })
            })
            add(area, stretchy = true)
        })

        show()
    }
}
