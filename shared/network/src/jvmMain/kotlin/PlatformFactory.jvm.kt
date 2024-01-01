package com.kotpot.cosmos.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.logging.*
import okio.ByteString


actual val platformFactory: PlatformFactory = object : PlatformFactory {
    override val devBackendUrl: String
        get() = "http://192.168.3.34:8002"

    override fun httpClient(): HttpClient {
        return HttpClient(OkHttp) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}