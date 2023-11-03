package org.kotpot.cosmos.shared.ui.ext

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
inline fun ColumnScope.VerticallyAnimatedExpandable(
    visibility: Any,
    crossinline content: @Composable () -> Unit
) = StatefulWidget<Boolean>(visibility) { state ->

    val modifier = Modifier.fillMaxWidth()

    AnimatedVisibility(
        visible = state,
        modifier = if (state) modifier.weight(1f) else modifier,
        enter = expandVertically(),
        exit =  shrinkVertically(),
    ) {
        content()
    }
}
