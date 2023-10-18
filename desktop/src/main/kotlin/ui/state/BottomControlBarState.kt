package org.kotpot.cosmos.desktop.ui.state

data class BottomControlBarState(
    val title: String = "",
    val artist: String = "",
    val songLength: Long = 0,
    val playedLength: Long = 0,
    val volume: Float = 0f,
    val isPaused: Boolean = false
)