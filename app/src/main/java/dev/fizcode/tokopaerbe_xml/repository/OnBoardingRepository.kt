package dev.fizcode.tokopaerbe_xml.repository

import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class OnBoardingRepository @Inject constructor(
    private val sharedPrefDatastore: SharedPrefDatastore
) {
    suspend fun getOnboarding(): String? {
        return sharedPrefDatastore.getOnboarding().firstOrNull()
    }
    suspend fun updateOnboarding(value: String) {
        return sharedPrefDatastore.setOnboarding(value)
    }
    suspend fun clearOnboarding() {
        updateOnboarding("")
    }
}