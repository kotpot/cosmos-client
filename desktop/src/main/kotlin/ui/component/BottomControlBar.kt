package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.ui.icon.*
import org.kotpot.cosmos.desktop.ui.state.BottomControlBarState
import org.kotpot.cosmos.desktop.ui.util.formatMilliseconds

@Composable
fun BottomControlBar(
    bottomControlBarState: BottomControlBarState,
    modifier: Modifier
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        SongInfo(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.19f),
            title = bottomControlBarState.title,
            artist = bottomControlBarState.artist
        )
        MusicControl(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.62f),
            playedLength = bottomControlBarState.playedLength,
            songLength = bottomControlBarState.songLength,
            isPaused = bottomControlBarState.isPaused
        )
        VolumeControl(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.19f),
            volume = bottomControlBarState.volume
        )
    }
}

@Composable
fun SongInfo(
    modifier: Modifier,
    title: String,
    artist: String
) {
    Column(
        modifier
    ) {
        var _title by remember { mutableStateOf(title) }
        var _artist by remember { mutableStateOf(artist) }

        Row {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.hasVisualOverflow) {
                        _title = _title.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                    }
                }
            )
            Icon(
                imageVector = CosmosIcons.ExpandMore,
                contentDescription = "Expand",
                modifier = Modifier
                    .padding(start = 6.dp)
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = _artist,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResult ->
                if (textLayoutResult.hasVisualOverflow) {
                    _artist = _artist.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                }
            }
        )
    }
}

@Composable
fun MusicControl(
    songLength: Long,
    playedLength: Long,
    isPaused: Boolean,
    modifier: Modifier
) {
    Column(modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = CosmosIcons.SkipPrevious,
                contentDescription = "Previous"
            )
            Icon(
                imageVector = when (isPaused) {
                    true -> CosmosIcons.Play
                    false -> CosmosIcons.Pause
                },
                contentDescription = "Pause/Resume",
                modifier = Modifier.clickable { !isPaused } //TODO: LOGIC
            )
            Icon(
                imageVector = CosmosIcons.SkipNext,
                contentDescription = "Next"
            )
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = CosmosIcons.ChatBubble,
                contentDescription = "Chat"
            )
        }
        Spacer(Modifier.weight(1f))
        Row(
            modifier = Modifier.padding(bottom = 3.dp)
        ) {
            Text(
                text = playedLength.formatMilliseconds(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "-${(songLength - playedLength).formatMilliseconds()}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        CosmosSlider(
            value = playedLength.toFloat().div(songLength),
            onValueChange = {}, //TODO: LOGIC
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun VolumeControl(
    modifier: Modifier,
    volume: Float
) {
    Column(modifier) {
        Row {
            Spacer(Modifier.weight(1f))
            Text(
                text = "BROADCASTING",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Icon(
                imageVector = CosmosIcons.Broadcast,
                contentDescription = "BROADCASTING",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(start = 6.dp).size(24.dp)
            )
        }
        Spacer(Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = CosmosIcons.VolumeDown,
                contentDescription = "Volume"
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "${volume.toInt()}%",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        CosmosSlider(
            value = volume,
            onValueChange = {}, //TODO: LOGIC
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}