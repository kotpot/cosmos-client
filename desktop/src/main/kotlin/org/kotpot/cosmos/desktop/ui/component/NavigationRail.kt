package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.ui.theme.CosmosTheme

enum class NavRailItem(val icon: String, val filledIcon: String, val title: String, val selected: Boolean = false) {
    HOME(
        icon = "icon/ic_home.svg",
        filledIcon = "icon/ic_home_fill.svg",
        title = "Home",
        selected = true
    ),
    LIBRARY(
        icon = "icon/ic_music_library.svg",
        filledIcon = "icon/ic_music_library_fill.svg",
        title = "Library"
    ),
    SETTINGS(
        icon = "icon/ic_settings.svg",
        filledIcon = "icon/ic_settings_fill.svg",
        title = "Settings"
    )
}

@Composable
@Preview
fun NavigationRail(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        LazyColumn {
            items(NavRailItem.entries.size) {
                NavRailItem(NavRailItem.entries[it])
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource("image/album.jpg"),
            contentDescription = "Album cover",
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun NavRailItem(item: NavRailItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(
                when (item.selected) {
                    true -> MaterialTheme.colorScheme.primaryContainer
                    false -> Color.Transparent },
                RoundedCornerShape(24.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = when (item.selected) {
                true -> painterResource(item.filledIcon)
                false -> painterResource(item.icon)
            },
            contentDescription = item.title,
            modifier = Modifier
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
        )
        Text(
            text = item.title,
            style = when (item.selected) {
                true -> MaterialTheme.typography.titleMedium
                false -> MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal
                ) },
            color = when (item.selected) {
                true -> MaterialTheme.colorScheme.onPrimaryContainer
                false -> MaterialTheme.colorScheme.onSurface
            },
        )
    }
}