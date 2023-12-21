package com.kotpot.cosmos.network

import com.squareup.wire.GrpcClient


expect fun platformGrpcClient(
    url: String,
    header: CommonHeader,
    params: CommonParams,
): GrpcClient