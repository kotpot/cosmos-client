package org.kotpot.cosmos.desktop.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowState
import org.kotpot.cosmos.desktop.locale.locale
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.model.Member
import org.kotpot.cosmos.desktop.model.QueueSong
import org.kotpot.cosmos.desktop.ui.component.*
import org.kotpot.cosmos.desktop.ui.main.HomeContent
import org.kotpot.cosmos.desktop.ui.main.LibraryContent
import org.kotpot.cosmos.desktop.ui.main.SettingContent
import org.kotpot.cosmos.desktop.ui.state.BottomControlBarState

@Composable
fun FrameWindowScope.MainScreen(
    windowState: WindowState,
    exitApplication: () -> Unit
) {
    val navRailState = rememberNavRailState(NavType.HOME)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val primary = MaterialTheme.colorScheme.primary
        Canvas(
            modifier = Modifier
                .size(800.dp)
                .align(Alignment.BottomEnd)
                .alpha(0.1f),
            onDraw = {
                drawCircle(
                    Brush.radialGradient(
                        listOf(primary, Color.Transparent),
                    )
                )
            }
        )
        AppTopBar(
            windowState,
            exitApplication
        )
        MainScreenContent(navRailState)
    }
}

@Composable
fun MainScreenContent(
    railState: NavRailState
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Spacer(modifier = Modifier.weight(0.2f))
            LargeTextField(
                textFieldValue = text,
                onTextFieldValueChange = { text = it },
                hintText = LocaleString::searchHint.locale(),
                showSearchIcon = true,
                modifier = Modifier
                    .weight(0.6f)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.weight(0.2f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.875f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.2f)
            ) {
                NavigationRail(railState)
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource("image/album_cover.png"),
                    contentDescription = "Album cover",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
            }

            AnimatedContent(
                railState.currentType,
                transitionSpec = { fadeIn(tween(300)) togetherWith fadeOut(tween(300)) },
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surface.copy(0.72f), MaterialTheme.shapes.small)
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), MaterialTheme.shapes.small),
            ) {
                when (it) {
                    NavType.HOME -> HomeContent()
                    NavType.LIBRARY -> LibraryContent()
                    NavType.SETTINGS -> SettingContent()
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                MemberList(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    members = memberList
                )
                SongQueue(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    songs = queueSongList
                )
            }
        }
        BottomControlBar(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.125f)
                .background(MaterialTheme.colorScheme.surface.copy(0.72f), MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            bottomControlBarState = bottomControlBarState
        )
    }
}


val bottomControlBarState = BottomControlBarState(
    title = "きらめき＊Chocolaterie",
    artist = "KyoKa",
    playedLength = 65000,
    songLength = 180000,
    volume = 50f,
    isPaused = false
)

val memberList = listOf(
    Member(
        avatar = "image/avatar.jpg",
        name = "Hoshino",
        role = "moderator",
    ),
    Member(
        avatar = "image/avatar.jpg",
        name = "Shiroko",
        role = "user",
    )
)

val queueSongList = listOf(
    QueueSong(
        albumCover = "image/album_cover.png",
        title = "きらめき＊Chocolaterie",
        artist = "KyoKa",
        songLength = 214000
    ),
    QueueSong(
        albumCover = "image/album_cover.png",
        title = "きらめき＊Chocolaterie",
        artist = "KyoKa",
        songLength = 214000
    ),
    QueueSong(
        albumCover = "image/album_cover.png",
        title = "きらめき＊Chocolaterie",
        artist = "KyoKa",
        songLength = 214000
    )
)