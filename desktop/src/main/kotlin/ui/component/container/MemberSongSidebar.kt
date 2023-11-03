package org.kotpot.cosmos.desktop.ui.component.container

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.koin.compose.rememberKoinInject
import org.kotpot.cosmos.desktop.ui.component.business.room.side.*
import org.kotpot.cosmos.desktop.ui.viewmodel.component.MemberSongViewModel

@Composable
fun MemberSongSidebar(
    modifier: Modifier = Modifier,
) {
    val viewModel = rememberKoinInject<MemberSongViewModel>()

    Column(
        modifier = modifier,
    ) {

        MemberListCardImpl(viewModel)
        Spacer(Modifier.height(8.dp))
        SongQueueCardImpl(viewModel)
    }
}

@Composable
fun ColumnScope.MemberListCardImpl(viewModel: MemberSongViewModel) {
    val provider = MemberListCardStateProvider(
        requireMembers = { viewModel.members },
        isExpand = { viewModel.expandState.value.isMember() }
    )
    val actions = MemberListCardStateActions(
        expand = { viewModel.expand(MemberSongViewModel.ExpandType.Member) }
    )
    MemberListCard(provider, actions)
}


@Composable
fun ColumnScope.SongQueueCardImpl(viewModel: MemberSongViewModel) {
    val provider = SongQueueCardStateProvider(
        requireSongs = { viewModel.songs },
        isExpand = { viewModel.expandState.value.isQueue() }
    )
    val actions = SongQueueCardStateActions(
        expand = { viewModel.expand(MemberSongViewModel.ExpandType.Queue) }
    )
    SongQueueCard(provider, actions)
}





