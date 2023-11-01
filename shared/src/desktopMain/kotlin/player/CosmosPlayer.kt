package org.kotpot.cosmos.shared.player

import org.kotpot.cosmos.shared.model.Song
import uk.co.caprica.vlcj.factory.MediaPlayerFactory
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import uk.co.caprica.vlcj.factory.discovery.strategy.LinuxNativeDiscoveryStrategy
import uk.co.caprica.vlcj.factory.discovery.strategy.WindowsNativeDiscoveryStrategy
import uk.co.caprica.vlcj.media.MediaRef
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent
import uk.co.caprica.vlcj.support.Info
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
        val nativeDiscovery = NativeDiscovery(
            LinuxNativeDiscoveryStrategy(),
            WindowsNativeDiscoveryStrategy(),
            OsxNativeDiscoveryStrategy()
        )

        println(nativeDiscovery.discover())
        println(nativeDiscovery.discoveredPath())
        println(nativeDiscovery.successfulStrategy())

        println(System.getenv("LD_LIBRARY_PATH"))
        println(System.getenv("VLC_PLUGIN_PATH"))

        mediaPlayer = AudioPlayerComponent(
            MediaPlayerFactory(
                nativeDiscovery,
//                "--quiet",
//                "--intf=dummy",
            )
        ).mediaPlayer()

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

//    fun directories(): Array<String?> {
//        var reader: Reader? = null
//        try {
//            val configurationFile: File = File(System.getProperty("user.dir"), "vlcj.config")
//            val properties = Properties()
//            reader = FileReader(configurationFile)
//            properties.load(reader)
//            val directory = properties.getProperty("nativeDirectory")
//            if (directory != null) {
//                return arrayOf(directory)
//            }
//        } catch (e: FileNotFoundException) {
//            // Nothing
//        } catch (e: IOException) {
//            System.err.printf("Failed to load configuration file: %s%n", e.message)
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close()
//                } catch (e: IOException) {
//                }
//            }
//        }
//        return arrayOfNulls(0)
//    }

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