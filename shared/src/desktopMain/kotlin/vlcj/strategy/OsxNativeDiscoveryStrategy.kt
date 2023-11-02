package org.kotpot.cosmos.shared.vlcj.strategy

import com.sun.jna.NativeLibrary
import uk.co.caprica.vlcj.binding.lib.LibC
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil


class OsxNativeDiscoveryStrategy : DirectoryProviderDiscoveryStrategy(FILENAME_PATTERNS, PLUGIN_PATH_FORMATS) {
    override fun supported(): Boolean {
        return RuntimeUtil.isMac()
    }

    override fun onFound(path: String): Boolean {
        forceLoadLibVlcCore(path)
        return true
    }

    private fun forceLoadLibVlcCore(path: String) {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcCoreLibraryName(), path)
        NativeLibrary.getInstance(RuntimeUtil.getLibVlcCoreLibraryName())
    }

    override fun setPluginPath(pluginPath: String): Boolean {
        return LibC.INSTANCE.setenv(PLUGIN_ENV_NAME, pluginPath, 1) == 0
    }

    companion object {
        private val FILENAME_PATTERNS = arrayOf(
            "libvlc\\.dylib",
            "libvlccore\\.dylib"
        )

        private val PLUGIN_PATH_FORMATS = arrayOf(
            "%s/../osxX86Plugins"
        )
    }
}
