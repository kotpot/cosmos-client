package org.kotpot.cosmos.desktop.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.java.KoinJavaComponent.inject
import org.kotpot.cosmos.desktop.ui.state.PlayerBarState
import org.kotpot.cosmos.shared.model.Song
import org.kotpot.cosmos.shared.model.flattenName
import org.kotpot.cosmos.shared.player.CosmosPlayer
import org.kotpot.cosmos.shared.player.MediaPlayerListener
import org.kotpot.cosmos.shared.viewmodel.ViewModel

class PlayerBarViewModel : ViewModel() {

    private val player by inject<CosmosPlayer>(CosmosPlayer::class.java)

    private val _uiState = MutableStateFlow(PlayerBarState())
    val uiState = _uiState.asStateFlow()

    init {
        player.setListener(
            object : MediaPlayerListener {
                override fun onReady() {

                }

                override fun onFinish() {

                }

                override fun onError() {

                }

                override fun onTimeUpdate(time: Long) {
                    _uiState.update {
                        it.copy(
                            playedLength = time
                        )
                    }
                }

                override fun onSongUpdate(song: Song?) {
                    _uiState.update {
                        it.copy(
                            title = song?.title ?: "",
                            artist = song?.artists?.flattenName() ?: "",
                            playedLength = 0,
                        )
                    }
                }
            }
        )
        onVolumeChange(20f) // TODO: get from datastore
    }

    //Local logic
    fun onSongClick(song: Song) {
        player.setCurrentSong(song)
        _uiState.update {
            it.copy(
                songLength = player.getSongLength()
            )
        }
    }

    //Local logic
    fun onPlayPauseClick() {
        if (player.isReady) {
            if (!player.isPlaying()) {
                player.start()
                _uiState.update {
                    it.copy(
                        isPaused = false
                    )
                }
            } else {
                player.pause()
                _uiState.update {
                    it.copy(
                        isPaused = true
                    )
                }
            }
        }
    }

    fun onSkipBackClick() {
    }

    fun onSkipForwardClick() {
    }

    fun onVolumeChange(volume: Float) {
        player.setVolume(
            volume.toInt()
        )
        _uiState.update {
            it.copy(volume = volume)
        }
    }

    //Local logic
    fun onProgressBarClick(progress: Float) {
        _uiState.update {
            it.copy(
                playedLength = it.songLength.times(progress).toLong()
            )
        }
        player.seekTo(progress)
    }
}