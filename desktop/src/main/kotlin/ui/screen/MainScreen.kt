package org.kotpot.cosmos.desktop.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowState
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.kotpot.cosmos.desktop.locale.from
import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.router.AnimationRouteContent
import org.kotpot.cosmos.desktop.router.AnimationRouteController
import org.kotpot.cosmos.desktop.ui.component.*
import org.kotpot.cosmos.desktop.ui.icon.ArrowForward
import org.kotpot.cosmos.desktop.ui.icon.CosmosIcons
import org.kotpot.cosmos.desktop.ui.main.HomeContent
import org.kotpot.cosmos.desktop.ui.main.LibraryContent
import org.kotpot.cosmos.desktop.ui.main.SettingContent
import org.kotpot.cosmos.desktop.ui.viewmodel.screen.MainScreenViewModel
import org.kotpot.cosmos.shared.model.Album
import org.kotpot.cosmos.shared.model.Artist
import org.kotpot.cosmos.shared.model.Member
import org.kotpot.cosmos.shared.model.Song

@Composable
fun FrameWindowScope.MainScreen(
    windowState: WindowState,
    exitApplication: () -> Unit
)= KoinContext {
    val navController by remember { mutableStateOf(AnimationRouteController(NavType.HOME, 6)) }

    val viewModel = koinInject<MainScreenViewModel>()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAlbumCover()
    }

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
        MainScreenContent(navController, state)
    }
}

@Composable
fun MainScreenContent(
    navController: AnimationRouteController<NavType>,
    state: String
) {
    var text by remember { mutableStateOf("") }
    val enableBackward = navController.curStackSize.value > 1

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Spacer(modifier = Modifier.weight(0.1575f))
            Column(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(100))
                    .clickable(
                        enabled = enableBackward,
                        onClick = { navController.pop() }
                    )
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(100))
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(100)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = CosmosIcons.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(180f),
                    tint = when (enableBackward) {
                        true -> MaterialTheme.colorScheme.onSurface
                        false -> MaterialTheme.colorScheme.onSurface.copy(0.38f)
                    }
                )
            }
            LargeTextField(
                textFieldValue = text,
                onTextFieldValueChange = { text = it },
                hintText = LocaleString::searchHint.from(),
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
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.2f)
            ) {
                NavigationRail(navController)
                Spacer(modifier = Modifier.weight(1f))
                Surface(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxSize()
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    if (state.isNotEmpty()) {
                        Image(
                            painter = painterResource(state),
                            contentDescription = "Album cover",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }
            }

            AnimationRouteContent(
                controller = navController,
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
                    else -> HomeContent()
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
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
        PlayerBar(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.125f)
                .background(MaterialTheme.colorScheme.surface.copy(0.72f), MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(0.72f), MaterialTheme.shapes.small)
                .padding(horizontal = 16.dp, vertical = 12.dp),
        )
    }
}

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
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    ),
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    ),
    Song(
        type = "netease",
        id = "123",
        title = "きらめき＊Chocolaterie",
        altTitle = null,
        url = null,
        duration = 214200,
        artists = listOf(
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            ),
            Artist(
                type = "netease",
                id = "123",
                name = "KyoKa",
                altName = null,
                imgUrl = null,
                songs = null,
                albums = null
            )
        ),
        album = Album(
            type = "netease",
            id = "123",
            title = "きらめき＊Chocolaterie",
            altTitle = null,
            imgUrl = "image/album_cover.png",
            songs = null,
            artists = null
        )
    )
)