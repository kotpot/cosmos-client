package org.kotpot.cosmos.desktop.locale

import org.kotpot.cosmos.desktop.locale.string.*
import java.util.Locale
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

object CurrentLocale {

    val string: LocaleString = when (Locale.getDefault().language) {
        Locale.SIMPLIFIED_CHINESE.language -> LocaleStringZh()
        Locale.JAPANESE.language -> LocaleStringJa()
        Locale.ENGLISH.language -> LocaleStringEn()
        else -> LocaleStringEn()
    }

    internal val resourceTypeCatch :Array<Pair<KClass<*>,*>> = arrayOf(
        LocaleString::class to string,
    )

}

interface LocaleR<T>

@PublishedApi
internal val mappingCatch = CurrentLocale.resourceTypeCatch.associate { (type,instance) ->
    type to type.java.methods.associate { method ->
        method.name.substring(3).replaceFirstChar { it.lowercaseChar() } to method.invoke(instance)
    }
}

inline fun <reified L:LocaleR<T>, T> KProperty1<L, T>.locale(): T
    = (mappingCatch[L::class]?.get(name) as T)!!



