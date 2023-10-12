package org.kotpot.cosmos.desktop.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.model.QueueSong
import org.kotpot.cosmos.desktop.ui.component.SongGrid

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
        .padding(8.dp)
) {
    val queueSongList = (0..11).map {
        QueueSong(
            albumCover = "image/album_cover.png",
            title = "きらめき＊Chocolaterie",
            artist = "KyoKa",
            songLength = 0,
        )
    }

    Column(
        modifier = modifier
    ) {
        SongGrid(title = LocaleString::homeMostTitle.from(), queueSongList)
        SongGrid(title = LocaleString::homeRecentlyTitle.from(), queueSongList)
    }

}