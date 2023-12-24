package org.kotpot.krpc

import com.squareup.wire.schema.SchemaHandler

class KrpcSchemaHandlerFactory: SchemaHandler.Factory {
    @Deprecated("Wire does not call this method anymore. Implement the other 'create' method to receive the payload associated with the schema handler.")
    override fun create(): SchemaHandler {
        TODO("Not yet implemented")
    }

    override fun create(
        includes: List<String>,
        excludes: List<String>,
        exclusive: Boolean,
        outDirectory: String,
        options: Map<String, String>
    ): SchemaHandler {
        return KrpcSchemaHandler(includes, excludes, exclusive, outDirectory, options)
    }
}