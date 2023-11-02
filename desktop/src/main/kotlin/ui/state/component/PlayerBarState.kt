package org.kotpot.cosmos.desktop.ui.state.component

data class PlayerBarState(
    val title: String = "",
    val artist: String = "",
    val album: String = "",
    val songLength: Long = 0,
    val playedLength: Long = 0,
    val volume: Float = 0f,
    val isPaused: Boolean = false
)