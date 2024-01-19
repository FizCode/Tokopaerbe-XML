package dev.fizcode.tokopaerbe_xml.repository

import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val sharedPrefDatastore: SharedPrefDatastore
) {

    suspend fun getDarkTheme(): String? {
        return sharedPrefDatastore.getDarkTheme().firstOrNull()
    }

    suspend fun setDarkTheme(value: String){
        sharedPrefDatastore.setDarkTheme(value)
        println("home repository: $value")
    }

    suspend fun clearToken() {
        setDarkTheme("")
    }
}