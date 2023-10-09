package org.kotpot.cosmos.desktop.locale

import org.kotpot.cosmos.desktop.locale.string.LocaleString
import org.kotpot.cosmos.desktop.locale.string.LocaleStringEn
import org.kotpot.cosmos.desktop.locale.string.LocaleStringJa
import org.kotpot.cosmos.desktop.locale.string.LocaleStringZh
import java.util.Locale
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

object CurrentLocale {

    var default: Locale = Locale.getDefault()


    private val resourceTypeMapper: MutableMap<KClass<out LocaleR>, Map<String, LocaleR>> = hashMapOf(
        LocaleString::class to mapOf(
            Locale.SIMPLIFIED_CHINESE.language to LocaleStringZh,
            Locale.JAPANESE.language to LocaleStringJa,
            Locale.ENGLISH.language to LocaleStringEn
        ),
    )

    //type->language->propertyName
    private val resourceTypeCatch: Map<KClass<out LocaleR>, MutableMap<String, MutableMap<String, Any>>> =
        resourceTypeMapper.keys.associateWith { hashMapOf() }

    fun <L : LocaleR, T : Any> getLocaleResource(
        type: KClass<*>,
        name: String,
        locale: Locale = default,
        getter: (L) -> T
    ): T {
        val getResource = {
            getter(
                (resourceTypeMapper[type]?.get(locale.language)
                    ?: error("${locale.language} is not support")) as L
            )
        }
        return (resourceTypeCatch[type]?.computeIfAbsent(locale.language) {
            hashMapOf(name to getResource())
        }?.computeIfAbsent(name) {
            getResource()
        } ?: error("local resource is not register")) as T
    }

}

interface LocaleR

inline fun <reified L : LocaleR, T : Any> KProperty1<L, T>.locale(locale: Locale = CurrentLocale.default) =
    CurrentLocale.getLocaleResource(L::class, name, locale, ::get)

