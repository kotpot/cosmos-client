package org.kotpot.cosmos.shared.viewmodel

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    protected val coroutineScope: CoroutineScope

    protected open fun onCleared()
}