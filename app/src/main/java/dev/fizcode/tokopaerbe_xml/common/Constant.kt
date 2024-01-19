package dev.fizcode.tokopaerbe_xml.common

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object Constant {

    object PrefDatastore{
        const val PREF_NAME = "Tokopaerbe"
        val ONBOARDING = booleanPreferencesKey("ONBOARDING")
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val SETTING_LANG_ID = booleanPreferencesKey("SETTING_LANG_ID")
        val SETTING_DARK = booleanPreferencesKey("SETTING_DARK")

    }
}