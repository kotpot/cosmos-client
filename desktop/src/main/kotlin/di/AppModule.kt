package org.kotpot.cosmos.desktop.di

import org.koin.dsl.module
import org.kotpot.cosmos.desktop.player.CosmosAudioPlayer
import org.kotpot.cosmos.desktop.ui.viewmodel.BottomControlBarViewModel

val appModule = module {
    single { CosmosAudioPlayer() }
    single { BottomControlBarViewModel() }
}