package com.kotpot.cosmos.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import okio.ByteString

actual val platformFactory: PlatformFactory = object : PlatformFactory {

    override val devBackendUrl: String
        get() = TODO()

    override fun httpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
        }
    }
}