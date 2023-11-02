package org.kotpot.cosmos.desktop.ui.component.business

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import org.kotpot.cosmos.shared.model.Song

@Composable
fun SongGrid(title: String, songList: List<Song>, onSongClicked: (Song) -> Unit) {
    Column {
        Text(
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, bottom = 8.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 2.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(songList.size) {
                SongGridItem(songList[it]) {
                    onSongClicked(songList[it])
                }
            }
        }
    }
}


@Composable
fun SongGridItem(song: Song, onSongClick: () -> Unit) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .clickable { onSongClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp)
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
            painter = painterResource(song.album?.imgUrl ?: ""),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            var title by remember { mutableStateOf(song.title) }
            var artist by remember { mutableStateOf(song.artists.first().name) }
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


