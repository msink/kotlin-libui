package libui.ktx.coroutines

import kotlinx.cinterop.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import libui.*

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
object uiDispatcher : CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        val ref: StableRef<Runnable> = StableRef.create(block).also { actions.add(it) }
        uiQueueMain(data = ref.asCPointer(), f = staticCFunction { data: COpaquePointer? ->
            val ref: StableRef<Runnable> = data!!.asStableRef()
            val block: Runnable = ref.get()
            block.run()
        })
    }

    override fun scheduleResumeAfterDelay(timeMillis: Long, continuation: CancellableContinuation<Unit>) {
        val ref: StableRef<CancellableContinuation<Unit>> = StableRef.create(continuation).also { actions.add(it) }
        uiTimer(timeMillis.toInt(), data = ref.asCPointer(), f = staticCFunction { data: COpaquePointer? ->
            val ref: StableRef<CancellableContinuation<Unit>> = data!!.asStableRef()
            val continuation: CancellableContinuation<Unit> = ref.get()
            with(continuation) {
                resumeUndispatched(Unit)
            }
            0
        })
    }

    override fun invokeOnTimeout(timeMillis: Long, block: Runnable): DisposableHandle {
        val handle = DisposableRunnable(block)
        val ref: StableRef<DisposableRunnable> = StableRef.create(handle).also { actions.add(it) }
        uiTimer(timeMillis.toInt(), data = ref.asCPointer(), f = staticCFunction { data: COpaquePointer? ->
            val ref: StableRef<DisposableRunnable> = data!!.asStableRef()
            val handle: DisposableRunnable = ref.get()
            handle.block?.run();
            0
        })
        return handle
    }

    class DisposableRunnable(
        var block: Runnable?
    ) : DisposableHandle {
        override fun dispose() {
            block = null
        }
    }

    private val actions = mutableListOf<StableRef<Any>>()

    fun onExit() {
        actions.forEach { it.dispose() }
    }
}
