package org.kotpot.cosmos.shared.ui.paging

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import org.kotpot.cosmos.shared.ui.ext.StatefulWidget


class PagingViews(
    val empty: @Composable () -> Unit,
    val error: @Composable () -> Unit,
    val last: @Composable () -> Unit,
    val loading: @Composable () -> Unit,
)

@Composable
fun <T> PagingList(
    controller: PagingController<T>,
    views: PagingViews,
    content: LazyListScope.() -> Unit
)  {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        content()

        item {
            when(controller.state) {
                PagingController.State.Empty -> views.empty()
                PagingController.State.Error -> views.error()
                PagingController.State.Last -> views.last()
                else -> views.loading()
            }
            LaunchedEffect(controller.state) {
                controller.load()
            }
        }
    }
}

