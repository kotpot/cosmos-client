package org.kotpot.cosmos.desktop.router

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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

fun defaultRouteContentEnter(): EnterTransition {
    return fadeIn(tween(400, 200))
}

fun defaultRouteContentExit(): ExitTransition {
    return fadeOut(tween(200))
}

@Composable
fun <T : RouterDefine> AnimationRouteScreen(
    controller: RouteController<T>,
    routers: Array<T>,
    enter: (T) -> EnterTransition = { defaultRouteScreenEnter() },
    exit: (T) -> ExitTransition = { defaultRouteScreenExit() },
    modifier: Modifier = Modifier.fillMaxSize(),
    screen: @Composable (T) -> Unit
) {

    Box(modifier) {
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

@Composable
fun <T> AnimationRouteContent(
    controller: RouteController<T>,
    enter: (T) -> EnterTransition = { defaultRouteContentEnter() },
    exit: (T) -> ExitTransition = { defaultRouteContentExit() },
    modifier: Modifier = Modifier.fillMaxSize(),
    screen: @Composable (T) -> Unit
) {
    Box(modifier) {
        AnimatedContent(
            controller.curRouteState.value,
            transitionSpec = {
                enter(targetState) togetherWith exit(initialState)
            }) {
            screen(it)
        }
    }
}