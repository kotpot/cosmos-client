package org.kotpot.cosmos.desktop.di

import org.koin.dsl.module
import org.kotpot.cosmos.desktop.player.CosmosAudioPlayer
import org.kotpot.cosmos.desktop.ui.viewmodel.PlayerBarViewModel

val appModule = module {
    single { CosmosAudioPlayer() }
    single { PlayerBarViewModel() }
}