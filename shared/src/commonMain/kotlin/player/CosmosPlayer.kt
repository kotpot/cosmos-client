package org.kotpot.cosmos.shared.player

expect class CosmosPlayer {
    fun prepare(pathSource: String)
    fun start()
    fun pause()
    fun isPlaying(): Boolean
    fun release()
    fun seekTo(process: Float)
}