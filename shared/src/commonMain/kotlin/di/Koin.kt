package org.kotpot.cosmos.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(
    appDeclaration: KoinAppDeclaration
) {
    startKoin {
        modules(ktorModule)
        appDeclaration()
    }
}