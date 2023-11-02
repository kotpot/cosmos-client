package org.kotpot.cosmos.desktop.ui.component.container

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.router.AnimationRouteController
import org.kotpot.cosmos.desktop.router.RouterDefine
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.icon.Home
import org.kotpot.cosmos.desktop.ui.icon.MusicLibrary
import org.kotpot.cosmos.desktop.ui.icon.Setting

enum class NavRailType(
    val icon: ImageVector,
    val filledIcon: ImageVector,
    val title: String
) {
    HOME(
        icon = CosmosIcons.Home,
        filledIcon = CosmosIcons.Filled.Home,
        title = LocaleString::mainNavHome.from()
    ),
    LIBRARY(
        icon = CosmosIcons.MusicLibrary,
        filledIcon = CosmosIcons.Filled.MusicLibrary,
        title = LocaleString::mainNavLibrary.from()
    ),
    SETTINGS(
        icon = CosmosIcons.Setting,
        filledIcon = CosmosIcons.Filled.Setting,
        title = LocaleString::mainNavSetting.from()
    );

    fun toNavType() = when (this) {
        HOME -> NavType.HOME
        LIBRARY -> NavType.LIBRARY
        SETTINGS -> NavType.SETTINGS
    }
}

@Composable
fun NavigationRail(
    navController: AnimationRouteController<NavType>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        NavRailType.entries.forEach { navType ->
            item {
                NavRailItem(
                    navController,
                    navType,
                    selected = navController.curRouteState.value.name == navType.name
                )
            }
        }
    }
}


enum class NavType : RouterDefine {
    HOME, LIBRARY, SETTINGS, SEARCH, PLAYLIST
}

@Composable
fun NavRailItem(navController: AnimationRouteController<NavType>, item: NavRailType, selected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .clickable {
                navController.push(item.toNavType())
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
