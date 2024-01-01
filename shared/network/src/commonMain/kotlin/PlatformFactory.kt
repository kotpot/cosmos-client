package com.kotpot.cosmos.network

import io.ktor.client.*


expect val platformFactory: PlatformFactory


interface PlatformFactory {

    val devBackendUrl: String

    fun httpClient(): HttpClient
}