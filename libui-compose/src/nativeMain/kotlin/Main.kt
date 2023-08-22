import androidx.compose.runtime.*
import kotlinx.coroutines.*
import libui.compose.*
import libui.uiQuit

fun main() {
    println("HELLOOOOOO!!!")

    runLibUI {
        val state = remember { WindowState(SizeInt(100, 100)) }

        Window(
            onCloseRequest = {
                println("CLOSE REQUEST!!!")
                uiQuit()
            },
            state = state,
            title = "LibUI and Compose!",
            content = {
                var num by remember { mutableStateOf(1) }
                val isOn = remember { mutableStateOf(true) }

                VBox {
                    Label("I did something here! $num")
                    Label("Look at this thing go ${num + 20}")

                    Checkbox("Enable disappearing label", isOn)
                    if (!isOn.value || num % 4 == 0) {
                        Label("I like to have stuff in here")
                    }
                    HorizontalSeparator()

                    Button("Click Me!", onClick = { println("You clicked me!") })

                    VerticalSeparator()

                    ProgressBar()
                    ProgressBar(value = num % 100)

                    val color = remember { mutableStateOf(Color(0xFFFFFF)) }
                    ColorButton(color)

                    val simpleText = remember { mutableStateOf("Type here...") }
                    TextField(simpleText)
                    PasswordField(simpleText)

                    HorizontalSeparator()

                    val slide = remember { mutableStateOf(5) }
                    Slider(slide, 1, 20 + num / 10)
                }

                LaunchedEffect(Unit) {
                    while (isActive) {
                        delay(1000)
                        num += 1
                    }
                }
            }
        )
    }
}
