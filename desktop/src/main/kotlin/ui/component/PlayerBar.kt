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
import org.koin.compose.koinInject
import org.kotpot.cosmos.desktop.ui.icon.*
import org.kotpot.cosmos.desktop.ui.viewmodel.PlayerBarViewModel
import org.kotpot.cosmos.desktop.util.formatMilliseconds

@Composable
fun PlayerBar(
    modifier: Modifier
) {
    val viewModel = koinInject<PlayerBarViewModel>()
    val state by viewModel.uiState.collectAsState()

    Row(
        modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        SongInfo(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.19f),
            title = state.title,
            artist = state.artist
        )
        MusicControl(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.62f),
            playedLength = state.playedLength,
            songLength = state.songLength,
            isPaused = state.isPaused,
            onPauseClick = { viewModel.onPlayPauseClick() },
            onProgressBarClick = { viewModel.onProgressBarClick(it) }
        )
        VolumeControl(
            volume = state.volume,
            onVolumeChange = { viewModel.onVolumeChange(it) },
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.19f)
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
                text = _title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayoutResult ->
                    _title = if (textLayoutResult.hasVisualOverflow) {
                        _title.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                    } else {
                        title
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
                _artist = if (textLayoutResult.hasVisualOverflow) {
                    _artist.dropLast(4).plus("...") //TODO: Remove once compose-multiplatform#1888 is fixed
                } else {
                    artist
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
    onPauseClick: () -> Unit,
    onProgressBarClick: (Float) -> Unit,
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
                modifier = Modifier.clickable { onPauseClick() } //TODO: LOGIC
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
            onValueChange = { onProgressBarClick(it) },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun VolumeControl(
    volume: Float,
    onVolumeChange: (Float) -> Unit,
    modifier: Modifier
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
            onValueChange = { onVolumeChange(it) },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}