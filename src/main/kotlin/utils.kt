package libui                                                                  

import kotlinx.cinterop.*

data class Size(val width: Int, val height: Int)

fun disposeStableRefs() = _stableRefs.forEach { it.dispose() }

internal var _stableRefs = mutableListOf<StableRef<Any>>()
