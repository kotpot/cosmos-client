package org.kotpot.cosmos.shared.di

import org.koin.dsl.module
import org.kotpot.cosmos.shared.network.createHttpClient

val ktorModule = module {
    single { createHttpClient() }
}