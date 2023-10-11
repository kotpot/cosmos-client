package org.kotpot.cosmos.desktop.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.model.QueueSong
import org.kotpot.cosmos.desktop.ui.component.SongGrid
import java.util.stream.IntStream
import kotlin.streams.toList

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
) {
    val queueSongList = IntStream.range(0, 12).mapToObj {
        QueueSong(
            albumCover = "image/album_cover.png",
            title = "きらめき＊Chocolaterie",
            artist = "KyoKa",
            songLength = it.toLong()
        )
    }.toList()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        SongGrid(title = LocaleString::homeMostTitle.from(), queueSongList)
        SongGrid(title = LocaleString::homeRecentlyTitle.from(), queueSongList)
    }

}