package org.kotpot.cosmos.desktop.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.Home
import org.kotpot.cosmos.desktop.ui.icon.MusicLibrary
import org.kotpot.cosmos.desktop.ui.icon.Setting

enum class NavType(
    val icon: ImageVector,
    val filledIcon: ImageVector,
    val title: String
) {
    HOME(
        icon = CosmosIcons.Home,
        filledIcon = CosmosIcons.Filled.Home,
        title = "Home"
    ),
    LIBRARY(
        icon = CosmosIcons.MusicLibrary,
        filledIcon = CosmosIcons.Filled.MusicLibrary,
        title = "Library"
    ),
    SETTINGS(
        icon = CosmosIcons.Setting,
        filledIcon = CosmosIcons.Filled.Setting,
        title = "Settings"
    )
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun NavigationRail(
    railState: NavRailState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        NavType.entries.forEachIndexed { index, navType ->
            item {
                NavRailItem(
                    railState,
                    navType,
                    selected = railState.currentType == navType
                )
            }
        }
    }
}

@Composable
fun NavRailItem(railState: NavRailState, item: NavType, selected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .clickable {
                railState.navigateToType(item)
            }
            .background(
                when (selected) {
                    true -> MaterialTheme.colorScheme.primaryContainer
                    false -> Color.Transparent
                },
                RoundedCornerShape(24.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = when (selected) {
                true -> item.filledIcon
                false -> item.icon
            },
            contentDescription = item.title,
            modifier = Modifier
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
        )
        Text(
            text = item.title,
            style = when (selected) {
                true -> MaterialTheme.typography.titleMedium
                false -> MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal
                )
            },
            color = when (selected) {
                true -> MaterialTheme.colorScheme.onPrimaryContainer
                false -> MaterialTheme.colorScheme.onSurface
            },
        )
    }
}

@Composable
fun rememberNavRailState(
    initialType: NavType
): NavRailState {
    return rememberSaveable {
        NavRailState(
            initialType
        )
    }
}

class NavRailState(
    initialType: NavType,
) {
    var currentType by mutableStateOf(initialType)
    fun navigateToType(destinationType: NavType) {
        currentType = destinationType
    }
}