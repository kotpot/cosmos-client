package org.kotpot.cosmos.desktop.ui.state

data class BottomControlBarState(
    val title: String,
    val artist: String,
    val songLength: Long,
    val playedLength: Long,
    val volume: Float,
    val isPaused: Boolean
)