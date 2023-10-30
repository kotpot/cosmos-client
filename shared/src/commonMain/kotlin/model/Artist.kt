package org.kotpot.cosmos.shared.model

data class Artist(
    val type: String,
    val id: String,
    val name: String,
    val altName: String?,
    val imgUrl: String?,
    val songs: List<Song>?,
    val albums: List<Album>?,
)

fun List<Artist>.flattenName(): String {
    return this.joinToString { it.name }
}