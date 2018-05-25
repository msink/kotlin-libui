package libui                                                                  

import kotlinx.cinterop.*

fun disposeStableRefs() = _stableRefs.forEach { it.dispose() }

internal var _stableRefs = mutableListOf<StableRef<Any>>()
