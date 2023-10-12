package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.model.QueueSong

@Composable
fun SongGrid(title: String, queueSongList: List<QueueSong>) {
    Column {
        Text(
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, bottom = 8.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(queueSongList.size) { SongGridItem(queueSongList[it]) }
        }
    }
}


@Composable
fun SongGridItem(queueSong: QueueSong) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 5.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(size = 5.dp)
                )
                .size(36.dp),
            painter = painterResource(queueSong.albumCover),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            var title by remember { mutableStateOf(queueSong.title) }
            var artist by remember { mutableStateOf(queueSong.artist) }
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
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


