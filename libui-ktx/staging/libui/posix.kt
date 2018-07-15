package platform.posix

fun srand(seed: Int) {}
fun rand() = 0
fun time(prt: Int?) = 0L
fun memset(dst: CValuesRef<*>?, valut: Int, size: Long) {}

typealias size_tVar = LongVarOf<size_t>
typealias size_t = Long

typealias uint32_tVar = IntVarOf<uint32_t>
typealias uint32_t = Int

typealias uint64_tVar = LongVarOf<uint64_t>
typealias uint64_t = Long

typealias uintptr_t = Long
