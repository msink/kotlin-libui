// SPDX-License-Identifier: Apache-2.0

package androidx.compose

internal val keyInfo = mutableMapOf<Int, String>()

internal actual fun recordSourceKeyInfo(key: Any) {
    TODO()
}

actual fun keySourceInfoOf(key: Any): String? = keyInfo[key]
