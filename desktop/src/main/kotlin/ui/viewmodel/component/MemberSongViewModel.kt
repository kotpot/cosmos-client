package org.kotpot.cosmos.desktop.ui.viewmodel.component

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.kotpot.cosmos.desktop.ui.state.component.MemberSongState
import org.kotpot.cosmos.shared.model.Album
import org.kotpot.cosmos.shared.model.Artist
import org.kotpot.cosmos.shared.model.Member
import org.kotpot.cosmos.shared.model.Song
import org.kotpot.cosmos.shared.viewmodel.ViewModel

class MemberSongViewModel : ViewModel() {

    @Deprecated("")
    private val _uiState = MutableStateFlow(MemberSongState())
    @Deprecated("")
    val uiState = _uiState.asStateFlow()

    val members = mutableStateListOf<Member>()
    val songs = mutableStateListOf<Song>()

    val expandState = mutableStateOf(ExpandType.Member)

    enum class ExpandType {
        Member, Queue;

        fun isMember() = this == Member
        fun isQueue() = this == Queue
    }

    init {
        members.addAll(memberList)
        songs.addAll(queueSongList)
        _uiState.update {
            it.copy(
                member = memberList,
                queue = queueSongList
            )
        }
    }

    fun expand(type: ExpandType) {
        expandState.value = type
    }

    @Deprecated("use expand")
    fun foldList(targetList: String) {
//        _uiState.update { state ->
//            when (targetList) {
//                "Member" -> state.copy(
//                    isMemberFolded = !state.isMemberFolded,
//                    isQueueFolded = state.isQueueFolded && state.isMemberFolded
//                )
//
//                "Queue" -> state.copy(
//                    isQueueFolded = !state.isQueueFolded,
//                    isMemberFolded = state.isMemberFolded && state.isQueueFolded
//                )
//
//                else -> state
//            }
//        }
        val type = when(targetList) {
            "Member" -> ExpandType.Member
            else -> ExpandType.Queue
        }
        expandState.value = type
    }
}

val memberList = listOf(
    Member(
        avatar = "image/avatar.jpg",
        name = "Hoshino",
        role = "moderator",
    ),
    Member(
        avatar = "image/avatar.jpg",
        name = "Shiroko",
        role = "user",
    )
)

val queueSongList = listOf(
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    ),
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    ),
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    )
)