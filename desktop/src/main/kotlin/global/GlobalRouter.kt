package org.kotpot.cosmos.desktop.global

import org.kotpot.cosmos.desktop.router.RouterDefine

enum class GlobalRouter : RouterDefine {
    Startup, Setup, Main;

    override fun key(): Any {
        return this
    }
}