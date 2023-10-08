package org.kotpot.cosmos.desktop.locale

import java.util.Locale

object CurrentLocale {

    val S: LocaleString = when (Locale.getDefault().language) {
        Locale.SIMPLIFIED_CHINESE.language -> LocaleStringZh()
        Locale.JAPANESE.language -> LocaleStringJa()
        Locale.ENGLISH.language -> LocaleStringEn()
        else -> LocaleStringEn()
    }

}

//private val mappingCatch =
//    LocaleString::class.java.methods.associateBy { it.name.substring(3).trim() }
//
//val String.locale: String
//    get() = replace(Regex("[./\\\\]+"), "").trim().let { key ->
//        mappingCatch[key]?.let { it.invoke(S) as String }
//    } ?: this
