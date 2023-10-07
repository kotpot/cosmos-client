package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.ui.Model.QueueSong
import org.kotpot.cosmos.desktop.ui.util.formatMilliseconds

@Composable
fun SongQueue(
    songs: List<QueueSong>,
    modifier: Modifier
) {
    Column(
        modifier
    ) {
        ListCard(
            icon = "icon/ic_queue_music.svg",
            title = "Queue",
            additionalText = "${songs.size} - ${songs.sumOf { it.songLength }.formatMilliseconds()}"
        ) {
            items(songs) {
                SongQueueItem(it)
            }
        }
    }
}

@Composable
fun SongQueueItem(
    song: QueueSong
) {
    Row {
        Image(
            painter = painterResource(song.albumCover),
            contentDescription = "Queue album cover",
            modifier = Modifier
                .padding(end = 12.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(5.dp))
        )
        Column(
            modifier = Modifier.offset(0.dp, (-2).dp)
        ) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,

                )
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}