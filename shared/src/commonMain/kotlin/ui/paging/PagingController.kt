package org.kotpot.cosmos.shared.ui.paging

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PagingController<T>(
    val onLoad: suspend (offset: Int) -> Result<State>
) {

    companion object {
        const val DEFAULT_PAGING_SIZE = 30
        const val DEFAULT_PAGING_OFFSET = 0
    }

    enum class State {
        Empty, More, Loading, Last, Error
    }

    private var offset = DEFAULT_PAGING_OFFSET

    var state by mutableStateOf(State.More)
        private set


    // BUS logic impl to fetch next offset data

    suspend fun load() {
        if (state != State.More) return
        state = State.Loading
        next(offset + 1)
    }

    private suspend fun next(offset: Int) {
        val result = onLoad(offset)
        result.onSuccess {
            changeState(it)
        }.onFailure {
            changeState(State.Error)
        }
    }

    private fun changeState(next: State) {
        if (state == next) return
        state = next
    }
}