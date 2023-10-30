package org.kotpot.cosmos.shared.player

import org.kotpot.cosmos.shared.model.Song

interface MediaPlayerListener {
    fun onReady()
    fun onFinish()
    fun onError()
    fun onTimeUpdate(time: Long)
    fun onSongUpdate(song: Song?)
}