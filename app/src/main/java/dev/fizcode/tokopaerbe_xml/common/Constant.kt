package dev.fizcode.tokopaerbe_xml.common

import androidx.datastore.preferences.core.booleanPreferencesKey

object Constant {

    object PrefDatastore{
        const val PREF_NAME = "Tokopaerbe"
        val ONBOARDING = booleanPreferencesKey("ONBOARDING")
    }
}