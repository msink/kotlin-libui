/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose

/**
 * A map from a key to a set of values used for keeping the relation between some
 * entities and a models changes of which this entities are observing.
 *
 * Two main differences from a regular Map<K, Set<V>>:
 * 1) Object.hashCode is not used, so the values can be mutable and change their hashCode value
 * 2) Objects are stored with WeakReference to prevent leaking them.
*/
expect class ObserverMap<K : Any, V : Any>() {

    /**
     * Adds a [value] into a set associated with this [key].
     */
    fun add(key: K, value: V)

    /**
     * Removes all the values associated with this [key].
     *
     * @return the list of values removed from the set as a result of this operation.
     */
    fun remove(key: K)

    /**
     * Removes exact [value] from the set associated with this [key].
     */
    fun remove(key: K, value: V)

    /**
     * Returns `true` when the map contains the given key and value
     */
    fun contains(key: K, value: V): Boolean

    /**
     * Clears all the keys and values from the map.
     */
    fun clear()

    /**
     * @return a list of values associated with the provided [keys].
     */
    operator fun get(keys: Iterable<K>): List<V>

    /**
     * @return a list of values associated with the provided [key]
     */
    fun getValueOf(key: K): List<V>

    /**
     * Clears all the values that match the given [predicate] from all the sets.
     */
    fun clearValues(predicate: (V) -> Boolean)

    /**
     * Removes all values matching [value].
     */
    fun removeValue(value: V)
}
