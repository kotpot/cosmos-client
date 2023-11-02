package org.kotpot.cosmos.shared.vlcj.provider

import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil

class MacDirectoryProvider: UserDirDirectoryProvider() {

    private val arch = System.getProperty("os.arch")

    private val DIRECTORIES = if (arch == "x86_64") {
        arrayOf(
            "$path/lib/osxX86Core",
        )
    } else {
        arrayOf(
            "$path/lib/osxArmCore",
        )
    }


    override fun directories(): Array<String> {
        return DIRECTORIES
    }

    override fun supported(): Boolean {
        return RuntimeUtil.isMac()
    }
}