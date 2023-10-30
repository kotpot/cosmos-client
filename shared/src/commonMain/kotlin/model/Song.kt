package org.kotpot.cosmos.shared.model

data class Song(
    val type: String,
    val id: String,
    val title: String,
    val altTitle: String?,
    val url: String?,
    val duration: Long?,
    val artists: List<Artist>,
    val album: Album?,
)
