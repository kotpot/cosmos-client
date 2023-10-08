package org.kotpot.cosmos.desktop.router

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable

private const val DEFAULT_ANIME_DURATION = 300

@Composable
fun <T : RouterDefine> AnimationRouteScreen(
    controller: RouteController<T>,
    enter: EnterTransition = fadeIn(tween(DEFAULT_ANIME_DURATION)),
    exit: ExitTransition = fadeOut(snap(DEFAULT_ANIME_DURATION)),
    screen: @Composable (T) -> Unit
) {

    AnimatedContent(
        targetState = controller.curRouteState.value,
        transitionSpec = {
            enter togetherWith exit
        }
    ) {
        screen(it)
    }

}