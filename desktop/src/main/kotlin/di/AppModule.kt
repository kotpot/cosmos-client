package org.kotpot.cosmos.desktop.di

import org.koin.dsl.module
import org.kotpot.cosmos.desktop.ui.viewmodel.screen.MainScreenViewModel
import org.kotpot.cosmos.desktop.ui.viewmodel.component.PlayerBarViewModel
import org.kotpot.cosmos.shared.player.CosmosPlayer

val appModule = module {
    single(createdAtStart = true) { CosmosPlayer() }
    single { MainScreenViewModel() }
    single { PlayerBarViewModel() }
}