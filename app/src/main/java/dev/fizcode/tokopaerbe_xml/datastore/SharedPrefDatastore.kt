package dev.fizcode.tokopaerbe_xml.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dev.fizcode.tokopaerbe_xml.common.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SharedPrefDatastore @Inject constructor(private val context: Context) {

    companion object {
        val Context.datastoreOnboarding: DataStore<Preferences> by preferencesDataStore(
            name = Constant.PrefDatastore.PREF_NAME,
            produceMigrations = ::sharedPreferencesMigration
        )

        private fun sharedPreferencesMigration(context: Context) =
            listOf(SharedPreferencesMigration(context, Constant.PrefDatastore.PREF_NAME))
    }

    // Getting Onboarding datastore True or False
    fun getOnboarding(): Flow<Boolean> {
        return context.datastoreOnboarding.data.map { preferences ->
            preferences[Constant.PrefDatastore.ONBOARDING] as Boolean
        }
    }

    // Set Onboarding datastore value as True
    suspend fun setOnboarding(value: Boolean) {
        context.datastoreOnboarding.edit { preferences ->
            preferences[Constant.PrefDatastore.ONBOARDING] = value
        }
    }

    // Getting Login Token
    suspend fun getToken(): Flow<String> {
        return context.datastoreOnboarding.data.map { preferences ->
            preferences[Constant.PrefDatastore.ACCESS_TOKEN].orEmpty()
        }
    }

    // Inputting Login Token
    suspend fun setToken(value: String) {
        context.datastoreOnboarding.edit { preferences ->
            preferences[Constant.PrefDatastore.ACCESS_TOKEN] = value
        }
    }
}