package org.kotpot.cosmos.shared.model

data class Album(
    val type: String,
    val id: String,
    val title: String,
    val altTitle: String?,
    val imgUrl: String?,
    val songs: List<Song>?,
    val artists: List<Artist>?,
)
