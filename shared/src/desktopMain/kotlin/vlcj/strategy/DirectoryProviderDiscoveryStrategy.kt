package org.kotpot.cosmos.shared.vlcj.strategy

import org.kotpot.cosmos.shared.vlcj.provider.MacDirectoryProvider
import org.kotpot.cosmos.shared.vlcj.provider.WinDirectoryProvider
import uk.co.caprica.vlcj.factory.discovery.provider.DiscoveryDirectoryProvider
import uk.co.caprica.vlcj.factory.discovery.strategy.BaseNativeDiscoveryStrategy


abstract class DirectoryProviderDiscoveryStrategy(
    filenamePatterns: Array<String>,
    pluginPathFormats: Array<String>
): BaseNativeDiscoveryStrategy(filenamePatterns, pluginPathFormats) {

    private val directoryProviders = listOf(
            MacDirectoryProvider(),
            WinDirectoryProvider(),
        )

    public override fun discoveryDirectories(): List<String> {
        val directories: MutableList<String> = ArrayList()
        for (provider in supportedProviders) {
            directories.addAll(listOf(*provider.directories()))
        }
        return directories
    }

    private val supportedProviders: List<DiscoveryDirectoryProvider>
        get() {
            val result: MutableList<DiscoveryDirectoryProvider> = ArrayList()
            for (service in directoryProviders) {
                if (service.supported()) {
                    result.add(service)
                }
            }
            return sort(result)
        }

    private fun sort(providers: List<DiscoveryDirectoryProvider>): List<DiscoveryDirectoryProvider> {
        return providers.sortedBy { it.priority() }
    }
}
