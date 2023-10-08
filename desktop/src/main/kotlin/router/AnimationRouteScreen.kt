package org.kotpot.cosmos.desktop.router

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun <T : RouterDefine> AnimationRouteScreen(
    controller: RouteController<T>,
    screen: @Composable (T) -> Unit
) {

    Box(Modifier.fillMaxSize()) {
        for (router in controller.routers) {
            AnimatedVisibility(
                visible = controller.curRoute == router,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                screen(router)
            }
        }
    }

}