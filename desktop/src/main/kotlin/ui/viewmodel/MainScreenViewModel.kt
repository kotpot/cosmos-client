package org.kotpot.cosmos.desktop.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.java.KoinJavaComponent
import org.kotpot.cosmos.shared.player.CosmosPlayer
import org.kotpot.cosmos.shared.viewmodel.ViewModel

class MainScreenViewModel : ViewModel() {
    private val player by KoinJavaComponent.inject<CosmosPlayer>(CosmosPlayer::class.java)

    private val _uiState = MutableStateFlow("") //TEMP TODO: change to MainScreenState
    val uiState = _uiState.asStateFlow()

    fun getAlbumCover() {
        player.subscribeToCurrentSong {
            _uiState.value = it?.album?.imgUrl ?: ""
        }
    }

}