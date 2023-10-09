package org.kotpot.cosmos.desktop.locale

import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.locale.string.*
import java.util.Locale
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

object CurrentLocale {

    var default: Locale = Locale.getDefault()

    private val resourceTypeMapper: MutableMap<KClass<out LocaleR>, Map<String, LocaleR>> = hashMapOf(
        LocaleString::class to mapOf(
            Locale.SIMPLIFIED_CHINESE.language to localeStringZh,
            Locale.JAPANESE.language to localeStringJa,
            Locale.ENGLISH.language to localeStringEn
        ),
    )

    //type->language->propertyName
    private val resourceTypeCatch: MutableMap<String, Any> by lazy(::hashMapOf)

    fun <L : LocaleR, T : Any> getLocaleResource(
        type: KClass<*>,
        name: String,
        locale: Locale = default,
        doGet: (L) -> T
    ): T {
        val getLocaleR = {
            (resourceTypeMapper[type]?.get(locale.language)
                ?: error("${locale.language} is not support")) as L
        }
        return resourceTypeCatch.computeIfAbsent(type.qualifiedName + locale.language + name) { doGet(getLocaleR()) } as T
    }

}

interface LocaleR

inline fun <reified L : LocaleR, T : Any> KProperty1<L, T>.locale(locale: Locale = CurrentLocale.default) =
    CurrentLocale.getLocaleResource(L::class, name, locale, ::get)

