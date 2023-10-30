package org.kotpot.cosmos.desktop.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.ui.component.SongGrid
import org.kotpot.cosmos.desktop.ui.viewmodel.PlayerBarViewModel
import org.kotpot.cosmos.shared.model.Album
import org.kotpot.cosmos.shared.model.Artist
import org.kotpot.cosmos.shared.model.Song

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
        .padding(8.dp),
) {
    val viewModel = koinInject<PlayerBarViewModel>()
    val state by viewModel.uiState.collectAsState()

    val queueSongList = (0..11).map {
        Song(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            url = "desktop/src/main/resources/song/Chocolaterie.mp3",
            duration = null,
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
        )
    }

    Column(
        modifier = modifier
    ) {
        SongGrid(title = LocaleString::homeMostTitle.from(), queueSongList, { viewModel.onSongClick(it) })
        SongGrid(title = LocaleString::homeRecentlyTitle.from(), queueSongList, { viewModel.onSongClick(it) })
    }

}