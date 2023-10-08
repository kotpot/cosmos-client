package org.kotpot.cosmos.desktop.global

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState

object GlobalWindowManager {

    val windowState = WindowState(
        position = WindowPosition.Aligned(Alignment.Center),
        width = 1225.dp,
        height = 736.dp
    )
}