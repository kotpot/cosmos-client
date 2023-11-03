package org.kotpot.cosmos.desktop.ui.component.business

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.QueueMusic
import org.kotpot.cosmos.desktop.ui.state.component.MemberSongState
import org.kotpot.cosmos.desktop.util.formatMilliseconds
import org.kotpot.cosmos.shared.model.Song
import org.kotpot.cosmos.shared.model.flattenName

@Composable
fun SongQueue(
    state: MemberSongState,
    onFoldClick: () -> Unit,
    modifier: Modifier,
) {
    Column(
        modifier
    ) {
        ListCard(
            icon = CosmosIcons.QueueMusic,
            title = LocaleString::mainQueueListTitle.from(),
            additionalText = "${state.queue.size} - ${state.queue.sumOf { it.duration ?: 0 }.formatMilliseconds()}",
            isFolded = state.isQueueFolded,
            onFoldClick = { onFoldClick() },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface.copy(0.72f), MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), MaterialTheme.shapes.small)
        ) {
            items(state.queue) {
                SongQueueItem(it)
            }
        }
    }
}

@Composable
fun SongQueueItem(
    song: Song
) {
    Row {
        Image(
            painter = painterResource(song.album?.imgUrl ?: ""),
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
            var artist by remember { mutableStateOf(song.artists.flattenName()) }

            Text(
                text = title,
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
                text = artist,
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