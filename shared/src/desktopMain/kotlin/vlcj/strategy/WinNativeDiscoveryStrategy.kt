package org.kotpot.cosmos.shared.vlcj.strategy

import uk.co.caprica.vlcj.binding.lib.LibC
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil

class WinNativeDiscoveryStrategy: DirectoryProviderDiscoveryStrategy(FILENAME_PATTERNS, PLUGIN_PATH_FORMATS) {
    override fun supported(): Boolean {
        return RuntimeUtil.isWindows()
    }

    override fun setPluginPath(pluginPath: String): Boolean {
        return LibC.INSTANCE._putenv(String.format("%s=%s", PLUGIN_ENV_NAME, pluginPath)) == 0
    }

    companion object {
        private val FILENAME_PATTERNS = arrayOf(
            "libvlc\\.dll",
            "libvlccore\\.dll"
        )

        private val PLUGIN_PATH_FORMATS = arrayOf(
            "%s\\..\\win64Plugins"
        )
    }
}