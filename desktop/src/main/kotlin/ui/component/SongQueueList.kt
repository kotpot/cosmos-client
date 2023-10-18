package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.model.QueueSong
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.QueueMusic
import org.kotpot.cosmos.desktop.util.formatMilliseconds

@Composable
fun SongQueue(
    songs: List<QueueSong>,
    modifier: Modifier
) {
    Column(
        modifier
    ) {
        ListCard(
            icon = CosmosIcons.QueueMusic,
            title = LocaleString::mainQueueListTitle.from(),
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
            var title by remember { mutableStateOf(song.title) }
            var artist by remember { mutableStateOf(song.artist) }

            Text(
                text = song.title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.hasVisualOverflow) {
                        title = title.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                    }
                }
            )
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.hasVisualOverflow) {
                        artist = artist.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                    }
                }
            )
        }
    }
}