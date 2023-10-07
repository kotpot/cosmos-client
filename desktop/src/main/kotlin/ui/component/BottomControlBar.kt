package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
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
        Row {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                painter = painterResource("icon/ic_expand_more.svg"),
                contentDescription = "Expand",
                modifier = Modifier
                    .padding(start = 6.dp)
                    .rotate(180f)
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = artist,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
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
                painter = painterResource("icon/ic_skip_previous.svg"),
                contentDescription = "Previous"
            )
            Icon(
                painter = when (isPaused) {
                    true -> painterResource("icon/ic_play.svg")
                    false -> painterResource("icon/ic_pause.svg")
                },
                contentDescription = "Pause/Resume",
                modifier = Modifier.clickable { !isPaused } //TODO: LOGIC
            )
            Icon(
                painter = painterResource("icon/ic_skip_next.svg"),
                contentDescription = "Next"
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource("icon/ic_chat_bubble.svg"),
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
        ProgressBar(playedLength.toFloat().div(songLength))
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
                painter = painterResource("icon/ic_broadcast.svg"),
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
                painter = painterResource("icon/ic_volume_down.svg"),
                contentDescription = "Volume"
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "${volume.times(100).toInt()}%",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        ProgressBar(volume)
    }
}

@Composable
fun ProgressBar(
    progress: Float
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(100))
        ) { }
        Column(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth(progress)
                .align(Alignment.CenterStart)
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(100))
        ) { }
    }
}