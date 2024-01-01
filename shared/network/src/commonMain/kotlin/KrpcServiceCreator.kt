package com.kotpot.cosmos.network

import okio.ByteString
import okio.ByteString.Companion.toByteString
import org.kotpot.cosmos.pb.common.ProtocolServiceCall
import org.kotpot.cosmos.pb.test.rpc.KrpcTestService
import org.kotpot.cosmos.pb.test.rpc.TestService

object KrpcServiceCreator {

    private val BASE_URL = platformFactory.devBackendUrl
    private const val PATH = "/api/protocol/call"

    private val handler = KtorRequestHandler

    private suspend fun callProxy(serviceName: String, funcName: String, request: ByteArray): ByteArray {
        val call = ProtocolServiceCall(
            service_name = serviceName,
            call_function = funcName,
            placeholder = request.toByteString()
        )
        val url = BASE_URL + PATH
        return handler.handle(url, call.encode())
    }


    fun testService(): TestService = KrpcTestService(::callProxy)
}