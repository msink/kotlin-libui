// SPDX-License-Identifier: Apache-2.0

package androidx.compose

private class LibuiRecomposer : Recomposer() {
    override fun scheduleChangesDispatch() {}
    override fun hasPendingChanges(): Boolean = false
    override fun recomposeSync() {}
}

internal actual fun createRecomposer(): Recomposer {
    return LibuiRecomposer()
}
