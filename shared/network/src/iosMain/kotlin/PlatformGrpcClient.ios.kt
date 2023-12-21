package com.kotpot.cosmos.network

import com.squareup.wire.GrpcCall
import com.squareup.wire.GrpcClient
import com.squareup.wire.GrpcMethod
import com.squareup.wire.GrpcStreamingCall
import okio.Timeout

actual fun platformGrpcClient(
    url: String,
    header: CommonHeader,
    params: CommonParams,
): GrpcClient {
    TODO("Not yet implemented")
}

private class IosGrpcClient: GrpcClient() {


    override fun <S : Any, R : Any> newCall(method: GrpcMethod<S, R>): GrpcCall<S, R> {
        TODO("Not yet implemented")
    }

    override fun <S : Any, R : Any> newStreamingCall(method: GrpcMethod<S, R>): GrpcStreamingCall<S, R> {
        TODO("Not yet implemented")
    }

}