package org.kotpot.cosmos.desktop

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.*
import org.kotpot.cosmos.desktop.global.GlobalRouteManager
import org.kotpot.cosmos.desktop.global.GlobalRouter
import org.kotpot.cosmos.desktop.global.GlobalWindowManager
import org.kotpot.cosmos.desktop.router.AnimationRouteScreen
import org.kotpot.cosmos.desktop.ui.screen.MainScreen
import org.kotpot.cosmos.desktop.ui.screen.SetupScreen
import org.kotpot.cosmos.desktop.ui.screen.Startup
import org.kotpot.cosmos.desktop.ui.theme.CosmosTheme

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        state = GlobalWindowManager.windowState,
        title = "Cosmos", //TODO: Use a constant instead of a hardcoded string
        icon = painterResource("image/logo.svg"),
        resizable = false,
        transparent = true,
        undecorated = true,
    ) {
        CosmosTheme {
            // Navigation
            AnimationRouteScreen(
                GlobalRouteManager.controller,
            ) {
                GlobalRouteScreen(it)
            }
        }
    }
}

context(FrameWindowScope, ApplicationScope)
@Composable
private fun GlobalRouteScreen(router: GlobalRouter) {
    when (router) {
        GlobalRouter.Startup -> Startup()

        GlobalRouter.Setup -> SetupScreen(
            windowState = GlobalWindowManager.windowState,
            exitApplication = ::exitApplication
        )

        GlobalRouter.Main -> MainScreen(
            windowState = GlobalWindowManager.windowState,
            exitApplication = ::exitApplication
        )
    }
}