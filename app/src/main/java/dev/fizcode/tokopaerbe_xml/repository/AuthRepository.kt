package dev.fizcode.tokopaerbe_xml.repository

import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val sharedPrefDatastore: SharedPrefDatastore
) {
    suspend fun getToken(): String? {
        return sharedPrefDatastore.getToken().firstOrNull()
    }
    suspend fun updateToken(value: String) {
        sharedPrefDatastore.setToken(value)
    }

    suspend fun clearToken() {
        updateToken("")
    }
}