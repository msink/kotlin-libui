// SPDX-License-Identifier: Apache-2.0

package androidx.compose

import kotlin.native.ref.WeakReference

/**
 * A map from a key to a set of values used for keeping the relation between some
 * entities and a models changes of which this entities are observing.
 *
 * Two main differences from a regular Map<K, Set<V>>:
 * 1) Object.hashCode is not used, so the values can be mutable and change their hashCode value
 * 2) Objects are stored with WeakReference to prevent leaking them.
*/

actual class ObserverMap<K : Any, V : Any> {
    private val keyToValue =
        mutableMapOf<IdentityWeakReference<K>, MutableSet<IdentityWeakReference<V>>>()

    /**
     * Adds a [value] into a set associated with this [key].
     */
    actual fun add(key: K, value: V) {
        val weakKey = IdentityWeakReference(key)
        val weakValue = IdentityWeakReference(value)
        var valueSet = keyToValue[weakKey]
        if (valueSet == null) {
            valueSet = mutableSetOf()
            keyToValue.put(weakKey, valueSet)
        }
        valueSet.add(weakValue)
    }

    /**
     * Removes all the values associated with this [key].
     */
    actual fun remove(key: K) {
        val weakKey = IdentityWeakReference(key)
        keyToValue.remove(weakKey)
    }

    /**
     * Removes exact [value] from the set associated with this [key].
     */
    actual fun remove(key: K, value: V) {
        val weakKey = IdentityWeakReference(key)
        val weakValue = IdentityWeakReference(value)
        keyToValue[weakKey]?.remove(weakValue)
    }

    /**
     * Returns `true` when the map contains the given key and value
     */
    actual fun contains(key: K, value: V): Boolean {
        val valueSet = keyToValue[IdentityWeakReference(key)]
        return valueSet?.contains(IdentityWeakReference(value)) ?: false
    }

    /**
     * Clears all the keys and values from the map.
     */
    actual fun clear() {
        keyToValue.clear()
    }

    /**
     * @return a list of values associated with the provided [keys].
     */
    actual operator fun get(keys: Iterable<K>): List<V> {
        val valueSet = mutableSetOf<IdentityWeakReference<V>>()
        keys.forEach { key ->
            val weakKey = IdentityWeakReference(key)
            keyToValue[weakKey]?.let(valueSet::addAll)
        }
        return valueSet.mapNotNull { it.get() }
    }

    /**
     * @return a list of values associated with the provided [key]
     */
    actual fun getValueOf(key: K): List<V> {
        val weakKey = IdentityWeakReference(key)
        return keyToValue[weakKey]?.mapNotNull { it.get() }?.toList() ?: emptyList<V>()
    }

    /**
     * Clears all the values that match the given [predicate] from all the sets.
     */
    actual fun clearValues(predicate: (V) -> Boolean) {
        val iterator = keyToValue.iterator()
        while (iterator.hasNext()) {
            val (key, valueSet) = iterator.next()
            if (key.get() == null) {
                iterator.remove()
            } else {
                valueSet.removeAll {
                    val v = it.get()
                    v == null || predicate(v)
                }
                if (valueSet.isEmpty()) {
                    iterator.remove()
                }
            }
        }
    }

    /**
     * Removes all values matching [value].
     */
    actual fun removeValue(value: V) {
        val weakValue = IdentityWeakReference(value)
        val iterator = keyToValue.iterator()
        while (iterator.hasNext()) {
            val (key, valueSet) = iterator.next()
            if (key.get() == null) {
                iterator.remove()
            } else {
                valueSet.removeAll {
                    it.get() == null || it == weakValue
                }
                if (valueSet.isEmpty()) {
                    iterator.remove()
                }
            }
        }
    }
}

private class IdentityWeakReference<T : Any>(value: T) {
    val ref = WeakReference<T>(value)
    val hash = identityHashCode(value)

    fun get() = ref.get()

    override fun equals(other: Any?): Boolean {
        if (other !is IdentityWeakReference<*>) {
            return false
        }
        return hash == other.hash && get() === other.get()
    }

    override fun hashCode(): Int = hash
}