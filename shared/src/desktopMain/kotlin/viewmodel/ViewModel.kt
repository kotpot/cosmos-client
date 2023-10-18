package org.kotpot.cosmos.shared.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class ViewModel {
    actual val coroutineScope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {
        coroutineScope.cancel()
    }

    fun clear() {
        onCleared()
    }
}