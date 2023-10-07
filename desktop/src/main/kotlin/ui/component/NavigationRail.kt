package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(NavRailItem.entries.size) {
            NavRailItem(NavRailItem.entries[it])
        }
    }
}

@Composable
fun NavRailItem(item: NavRailItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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