package org.kotpot.cosmos.shared.vlcj.provider

import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil

class WinDirectoryProvider : UserDirDirectoryProvider() {

    private val DIRECTORIES = arrayOf(
        "$path/lib/winX86Core",
    )

    override fun directories(): Array<String> {
        return DIRECTORIES
    }

    override fun supported(): Boolean {
        return RuntimeUtil.isWindows()
    }
}