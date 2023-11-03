package org.kotpot.cosmos.desktop.ui.state.component

import org.kotpot.cosmos.shared.model.Member
import org.kotpot.cosmos.shared.model.Song

@Deprecated("An unreasonable combination of states")
data class MemberSongState(
    val member: List<Member> = emptyList(),
    val queue: List<Song> = emptyList(),
    val isMemberFolded: Boolean = false,
    val isQueueFolded: Boolean = false,
)


