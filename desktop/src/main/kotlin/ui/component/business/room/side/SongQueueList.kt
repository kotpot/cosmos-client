package org.kotpot.cosmos.desktop.ui.component.business.room.side

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
import org.kotpot.cosmos.desktop.ui.icon.Group
import org.kotpot.cosmos.desktop.util.formatMilliseconds
import org.kotpot.cosmos.shared.model.Song
import org.kotpot.cosmos.shared.model.flattenName


class SongQueueCardStateProvider(
    val requireSongs: () -> List<Song>,
    val isExpand: () -> Boolean
) {
    val additional get() = requireSongs().let {songs ->
        "${songs.size} - ${songs.sumOf { it.duration ?: 0 }.formatMilliseconds()}"
    }
}

class SongQueueCardStateActions(
    val expand: () -> Unit
)

@Composable
fun ColumnScope.SongQueueCard(
    provider: SongQueueCardStateProvider,
    action: SongQueueCardStateActions,
) = RoomSideExpandableListCard(
    provider.isExpand,
    header = {
        Header( { provider.additional },
        action.expand
    ) }
) {
    items(provider.requireSongs()) {
        SongQueueItem(it)
    }
}

@Composable
private fun Header(
    additional: () -> String,
    onFoldClick: () -> Unit
) = RoomSideListHeader(
    icon = CosmosIcons.Group,
    title = LocaleString::mainQueueListTitle.from(),
    additional = additional,
    onFoldClick = onFoldClick
)


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