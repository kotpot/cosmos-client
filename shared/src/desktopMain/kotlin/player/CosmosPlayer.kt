package org.kotpot.cosmos.shared.player

import org.kotpot.cosmos.shared.model.Song
import uk.co.caprica.vlcj.factory.MediaPlayerFactory
import uk.co.caprica.vlcj.media.MediaRef
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import kotlin.math.log

actual class CosmosPlayer {
    private var mediaPlayer: MediaPlayer? = null
    private var listener: MediaPlayerListener? = null
    private var currentSong: Song? = null
    private var subscribers: MutableList<(Song?) -> Unit> = mutableListOf()

    var isReady: Boolean = false

    init {
        initPlayer()
    }

    private fun initPlayer() {
        // mediaPlayer = MediaPlayerFactory().mediaPlayers().newMediaPlayer()

        mediaPlayer?.events()?.addMediaPlayerEventListener(object : MediaPlayerEventAdapter() {
            override fun mediaPlayerReady(mediaPlayer: MediaPlayer?) {
                listener?.onReady()
            }

            override fun opening(mediaPlayer: MediaPlayer?) {
                isReady = true
            }

            override fun finished(mediaPlayer: MediaPlayer?) {
                isReady = false
                listener?.onFinish()
            }

            override fun timeChanged(mediaPlayer: MediaPlayer?, newTime: Long) {
                listener?.onTimeUpdate(newTime)
            }

            override fun mediaChanged(mediaPlayer: MediaPlayer?, media: MediaRef?) {
                listener?.onSongUpdate(currentSong)
                for (callback in subscribers) {
                    callback.invoke(currentSong)
                }
            }

            override fun error(mediaPlayer: MediaPlayer?) {
                listener?.onError()
            }
        })

    }

    fun setListener(listener: MediaPlayerListener) {
        this.listener = listener
    }

    actual fun prepare(
        pathSource: String
    ) {
        if (mediaPlayer == null) {
            initPlayer()
        }

        if (mediaPlayer?.status()?.isPlaying == true) {
            mediaPlayer?.controls()?.stop()
        }

        mediaPlayer?.media()?.startPaused(pathSource)
    }

    actual fun start() {
        mediaPlayer?.controls()?.start()
    }

    actual fun pause() {
        mediaPlayer?.controls()?.pause()
    }

    actual fun isPlaying(): Boolean {
        return mediaPlayer?.status()?.isPlaying ?: false
    }

    actual fun release() {
        mediaPlayer?.release()
    }

    fun setVolume(volume: Int) {
        mediaPlayer?.audio()?.setVolume(
            log(volume.plus(1f), 100f)
                .times(100).toInt()
        )
    }

    fun toggleMute() {
        mediaPlayer?.audio()?.mute()
    }

    fun isMute(): Boolean {
        return mediaPlayer?.audio()?.isMute ?: false
    }

    fun getSongLength(): Long {
        return mediaPlayer?.media()?.info()?.duration() ?: 0
    }

    actual fun seekTo(process: Float) {
        mediaPlayer?.controls()?.setPosition(process)
    }

    fun subscribeToCurrentSong(callback: (Song?) -> Unit) {
        subscribers.add(callback)
    }

    fun setCurrentSong(song: Song) {
        currentSong = song
        prepare(song.url ?: "")
    }
}