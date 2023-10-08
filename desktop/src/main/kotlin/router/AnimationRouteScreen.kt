package org.kotpot.cosmos.desktop.router

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset

private const val DEFAULT_ANIME_DURATION = 500

private fun <T> tween() = tween<T>(DEFAULT_ANIME_DURATION)

fun defaultRouteScreenEnter(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween()
    ) + fadeIn(tween())
}

fun defaultRouteScreenExit(): ExitTransition {
    return slideOutHorizontally(
        animationSpec = tween()
    ) + fadeOut(tween())
}

@Composable
fun <T : RouterDefine> AnimationRouteScreen(
    controller: RouteController<T>,
    routers: Array<T>,
    enter: (T) -> EnterTransition = { defaultRouteScreenEnter() },
    exit: (T) -> ExitTransition = { defaultRouteScreenExit() },
    screen: @Composable (T) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        for (router in routers) {
            AnimatedVisibility(
                visible = controller.curRouteState.value == router,
                enter = enter(router),
                exit = exit(router)
            ) {
                screen(router)
            }
        }
    }
}