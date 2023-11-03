package org.kotpot.cosmos.shared.ui.ext

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
