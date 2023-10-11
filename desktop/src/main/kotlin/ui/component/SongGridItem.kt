package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.model.QueueSong
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.MoreVert
import org.kotpot.cosmos.desktop.ui.util.checkLength

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
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
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

        Column {
            Text(
                text = queueSong.title.checkLength(8),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = queueSong.artist.checkLength(8),
                style = MaterialTheme.typography.titleSmall
            )
        }
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = CosmosIcons.MoreVert,
            contentDescription = null,
        )
    }
}


