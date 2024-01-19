package dev.fizcode.tokopaerbe_xml.repository

import dev.fizcode.tokopaerbe_xml.datastore.SharedPrefDatastore
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class OnBoardingRepository @Inject constructor(
    private val sharedPrefDatastore: SharedPrefDatastore
) {
    suspend fun getOnboarding(): Boolean? {
        return sharedPrefDatastore.getOnboarding().firstOrNull()
    }
    suspend fun updateOnboarding(value: Boolean) {
        return sharedPrefDatastore.setOnboarding(value)
    }
    suspend fun clearOnboarding() {
        updateOnboarding(false)
    }
}