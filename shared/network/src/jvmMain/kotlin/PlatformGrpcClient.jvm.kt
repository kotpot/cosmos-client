package com.kotpot.cosmos.network

import com.squareup.wire.GrpcClient
import okhttp3.OkHttpClient

actual fun platformGrpcClient(
    url: String,
    header: CommonHeader,
    params: CommonParams,
): GrpcClient {
    return GrpcClient.Builder().apply {
        client(OkHttpClient())
        baseUrl(url)
    }.build()
}
