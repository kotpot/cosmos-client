package org.kotpot.cosmos.desktop

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.kotpot.cosmos.desktop.ui.screen.MainScreen
import org.kotpot.cosmos.desktop.ui.theme.CosmosTheme

fun main() = application {

    val windowState = rememberWindowState(
        position = WindowPosition.Aligned(Alignment.Center),
        width = 1225.dp,
        height = 736.dp
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Cosmos", //TODO: Use a constant instead of a hardcoded string
        icon = painterResource("image/logo.svg"),
        resizable = false,
        transparent = true,
        undecorated = true,
    ) {
        CosmosTheme {
            // Navigation
            MainScreen(
                windowState = windowState,
                exitApplication = { exitApplication() }
            )
        }
    }
}