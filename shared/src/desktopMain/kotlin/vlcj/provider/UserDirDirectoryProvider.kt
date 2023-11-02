package org.kotpot.cosmos.shared.vlcj.provider

import uk.co.caprica.vlcj.factory.discovery.provider.DiscoveryDirectoryProvider
import uk.co.caprica.vlcj.factory.discovery.provider.DiscoveryProviderPriority

abstract class UserDirDirectoryProvider: DiscoveryDirectoryProvider {

    val path: String = System.getProperty("user.dir")

    override fun priority(): Int {
        return DiscoveryProviderPriority.USER_DIR
    }

}