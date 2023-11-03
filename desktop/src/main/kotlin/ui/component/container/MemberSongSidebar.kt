package org.kotpot.cosmos.desktop.ui.component.container

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.kotpot.cosmos.desktop.ui.component.business.MemberList
import org.kotpot.cosmos.desktop.ui.component.business.SongQueue
import org.kotpot.cosmos.desktop.ui.viewmodel.component.MemberSongViewModel

@Composable
fun MemberSongSidebar(
    modifier: Modifier = Modifier,
    viewModel: MemberSongViewModel = koinInject()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MemberList(
            modifier = if (state.isMemberFolded) Modifier.fillMaxWidth() else Modifier.fillMaxWidth().weight(1f),
            state = state,
            onFoldClick = { viewModel.foldList("Member") }
        )
        SongQueue(
            modifier = if (state.isQueueFolded) Modifier.fillMaxWidth() else Modifier.fillMaxWidth().weight(1f),
            state = state,
            onFoldClick = { viewModel.foldList("Queue") }
        )
    }
}