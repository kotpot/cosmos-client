package org.kotpot.cosmos.shared.di

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.protobuf.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(commonModule)
    }
}

val commonModule = module {
    single { createHttpClient() }
}

@OptIn(ExperimentalSerializationApi::class)
fun createHttpClient(): HttpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        protobuf()
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}