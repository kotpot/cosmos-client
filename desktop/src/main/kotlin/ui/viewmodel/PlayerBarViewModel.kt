package org.kotpot.cosmos.desktop.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.java.KoinJavaComponent.inject
import org.kotpot.cosmos.desktop.player.CosmosAudioPlayer
import org.kotpot.cosmos.desktop.ui.state.PlayerBarState
import org.kotpot.cosmos.shared.viewmodel.ViewModel
import java.io.File

class PlayerBarViewModel : ViewModel() {

    private val audioPlayer by inject<CosmosAudioPlayer>(CosmosAudioPlayer::class.java)

    private val _uiState = MutableStateFlow(PlayerBarState())
    val uiState = _uiState.asStateFlow()

    fun onSongClick(url: String) {
        audioPlayer.open(File(url))
    }

    fun onPlayPauseClick() {
        if (audioPlayer.isPaused) {
            audioPlayer.resume()
        } else if (audioPlayer.isOpened) {
            audioPlayer.play()
        } else {
            audioPlayer.pause()
        }
    }

    fun onSkipBackClick() {
    }

    fun onSkipForwardClick() {
    }

    fun onVolumeChange(volume: Float) {
        _uiState.update {
            it.copy(volume = volume)
        }
        if (volume == 0f) {
            audioPlayer.mute = true
        } else {
            audioPlayer.mute = false
            audioPlayer.setGain(
                volume.toInt().toDouble().div(100)
            )
        }
    }
}