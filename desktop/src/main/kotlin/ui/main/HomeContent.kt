package org.kotpot.cosmos.desktop.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            title = "きら",
            artist = "KyoKa",
            songLength = 214000
        )
    }.toList()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        SongGrid(title = "Most played", queueSongList)
        SongGrid(title = "Recently Picked", queueSongList)
    }

}