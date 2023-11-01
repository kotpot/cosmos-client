package org.kotpot.cosmos.shared.ui.paging

import androidx.compose.runtime.mutableStateListOf

abstract class PagingController<T> {

    companion object {
        const val DEFAULT_PAGING_SIZE = 30
        const val DEFAULT_PAGING_OFFSET = 0
    }

    open val size = DEFAULT_PAGING_SIZE

    private var offset  = DEFAULT_PAGING_OFFSET



    val list = mutableStateListOf<T>()

    // BUS logic impl to fetch next offset data
    abstract suspend fun onFetch(offset: Int, size: Int): Result<List<T>>

    suspend fun refresh() = next(DEFAULT_PAGING_OFFSET)

    suspend fun load() = next(offset + 1)

    private suspend fun next(offset: Int) {

    }
}