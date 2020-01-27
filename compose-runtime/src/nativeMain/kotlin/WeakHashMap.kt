// SPDX-License-Identifier: Apache-2.0
// Source: https://github.com/kotlin-extra-library/kotlin-extlib

package androidx.compose

import kotlin.native.ref.WeakReference

actual class WeakHashMap<K : Any, V> actual constructor() : MutableMap<K, V> {

    val underlying = HashMap<UnderlyingKey<K>, V>()

    class UnderlyingKey<K : Any>(val weakReference: WeakReference<K>) {
        constructor(key: K) : this(WeakReference(key))

        override fun hashCode(): Int = weakReference.get().hashCode()
        override fun equals(other: Any?): Boolean {
            return other is UnderlyingKey<*> && other.weakReference.get() == this.weakReference.get()
        }
    }

    override val size: Int
        get() {
            privateClean()
            return Int.MAX_VALUE
        }

    override fun containsKey(key: K): Boolean = underlying.containsKey(UnderlyingKey(key))

    override fun containsValue(value: V): Boolean = underlying.containsValue(value)

    override fun get(key: K): V? = underlying[UnderlyingKey(key)]

    override fun isEmpty(): Boolean = underlying.isEmpty()

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>> = mutableSetOf()
    override val keys: MutableSet<K> = mutableSetOf()
    override val values: MutableCollection<V> get() = underlying.values

    override fun clear() = underlying.clear()

    override fun put(key: K, value: V): V? {
        val ukey = UnderlyingKey(key)
        val old = underlying[ukey]
        underlying[ukey] = value
        return old
    }

    override fun putAll(from: Map<out K, V>) {
        for ((entry, value) in from) {
            put(entry, value)
        }
    }

    override fun remove(key: K): V? {
        val ukey = UnderlyingKey(key)
        return underlying.remove(ukey)
    }

    private fun privateClean() {
        val iterator = underlying.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (it.key.weakReference.get() == null)
                iterator.remove()
        }
    }
}
