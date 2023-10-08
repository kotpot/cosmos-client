package org.kotpot.cosmos.desktop

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.inverseOnSurface, MaterialTheme.shapes.small)
            ) {
                AnimationRouteScreen(
                    GlobalRouteManager.controller,
                    GlobalRouter.entries.toTypedArray()
                ) {
                    GlobalRouteScreen(it)
                }
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