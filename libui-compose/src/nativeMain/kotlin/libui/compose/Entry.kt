@file:Suppress("FunctionName")

package libui.compose

import cnames.structs.uiWindow
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.cinterop.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import libui.*
import kotlin.coroutines.CoroutineContext

fun runLibUI(content: @Composable WindowScope.() -> Unit) = withLibUI {
    runBlocking {
        @OptIn(ExperimentalStdlibApi::class)
        val uiDispatcher = LibUiDispatcher(coroutineContext[CoroutineDispatcher.Key]!!)

        val clock = BroadcastFrameClock()

        val scope = CoroutineScope(clock + uiDispatcher)

        scope.launch {
            while (isActive) {
                clock.sendFrame(0L) // Frame time value is not used by Compose runtime.
                delay(50)
            }
        }

        Snapshot.globalWrites()
            .conflate()
            .onEach { Snapshot.sendApplyNotifications() }
            .launchIn(scope)

        val recomposer = Recomposer(scope.coroutineContext)
        // Will be cancelled when recomposerJob cancels
        scope.launch { recomposer.runRecomposeAndApplyChanges() }

        composeLibUI(recomposer, content) {
            uiMain()
            uiDispatcher.close()
        }

        recomposer.close()
        recomposer.join()

        scope.cancel()
    }
}

private inline fun composeLibUI(
    parent: CompositionContext,
    noinline content: @Composable WindowScope.() -> Unit,
    block: () -> Unit
) {
    val applier = MutableListApplier<CPointer<uiWindow>>(mutableListOf())
    val composition = Composition(applier, parent)
    composition.setContent { WindowScope().content() }

    block()

    // Free libui controls
    composition.dispose()
}

private class LibUiDispatcher(private val backup: CoroutineDispatcher) : CloseableCoroutineDispatcher() {
    private var isClosed: Boolean = false

    override fun close() {
        // There's a race condition between close() and dispatch() to fix.
        isClosed = true

//        val onShouldQuit = { println("QUIT!") }
//        val lol = StableRef.create(onShouldQuit)
//        try {
//            uiOnShouldQuit(
//                staticCFunction { senderData ->
//                                1
//                },
//                lol.asCPointer()
//            )
//        } finally {
//            lol.dispose()
//        }
    }

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        if (!isClosed) {
            val stableRef = StableRef.create(block)
            uiQueueMain(
                staticCFunction { ptr ->
                    val ref = ptr!!.asStableRef<Runnable>()
                    val runnable = ref.get()
                    ref.dispose()
                    runnable.run()
                },
                stableRef.asCPointer()
            )
        } else {
            backup.dispatch(context, block)
        }
    }
}
