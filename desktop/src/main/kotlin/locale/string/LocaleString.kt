package org.kotpot.cosmos.desktop.locale.string

import org.kotpot.cosmos.desktop.locale.LocaleR

interface LocaleString : LocaleR {

    val setupTitle: String
        get() =
            "Let’s listen together"

    val setupHint: String
        get() =
            "Enter your broadcast server link down below to get started"

    val searchHint: String
        get() =
            "Search for something..."

}
