package org.kotpot.cosmos.desktop.locale.string

import org.kotpot.cosmos.desktop.locale.LocaleR

class LocaleString : LocaleR {

    internal var setupTitle: String =
        "Let’s listen together"

    internal var setupHint: String =
        "Enter your broadcast server link down below to get started"

    internal var searchHint: String =
        "Search for something..."

    internal var homeMostTitle: String =
        "Most played"

    internal var homeRecentlyTitle: String =
        "Recently Picked"

}

fun localeString(init: LocaleString.() -> Unit = {}): LocaleString =
    LocaleString().apply(init)
