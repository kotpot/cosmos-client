package com.kotpot.cosmos.network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

interface RequestHandler {

    suspend fun handle(url: String, request: ByteArray): ByteArray
}

object KtorRequestHandler : RequestHandler {

    private val client = platformFactory.httpClient()

    override suspend fun handle(url: String, request: ByteArray): ByteArray {
        val response = client.post(url) {
            contentType(ContentType.Application.Any)
            setBody(request)
        }
        return response.body()
    }

}