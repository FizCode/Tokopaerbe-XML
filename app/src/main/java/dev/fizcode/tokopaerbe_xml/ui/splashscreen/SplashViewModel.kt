package dev.fizcode.tokopaerbe_xml.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.AuthRepository
import dev.fizcode.tokopaerbe_xml.repository.HomeRepository
import dev.fizcode.tokopaerbe_xml.repository.OnBoardingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository,
    private val authRepository: AuthRepository,
    private val homeRepository: HomeRepository
) : ViewModel() {

    val shouldSkipOnboarding: MutableLiveData<Boolean> = MutableLiveData()
    val shouldSkipAuth: MutableLiveData<Boolean> = MutableLiveData()
    val shouldCheckAppTheme: MutableLiveData<String?> = MutableLiveData()

    fun onViewLoaded() {
        getOnboardingValue()
        getTokenValue()
        getTheme()
    }

    private fun getOnboardingValue() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = onBoardingRepository.getOnboarding()
            withContext(Dispatchers.Main) {
                if (response!!.isNotEmpty()) shouldSkipOnboarding.postValue(true)
                else shouldSkipOnboarding.postValue(false)
            }
        }
    }

    private fun getTokenValue() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = authRepository.getToken()
            withContext(Dispatchers.Main) {
                if (response != null) {
                    shouldSkipAuth.postValue(true)
                } else {
                    shouldSkipAuth.postValue(false)
                }
            }
        }
    }

    private fun getTheme() {
        CoroutineScope(Dispatchers.IO).launch{
            val response = homeRepository.getDarkTheme()
            withContext(Dispatchers.Main) {
                shouldCheckAppTheme.postValue(response)
            }
        }
    }

    fun setTheme(value: String) {
        viewModelScope.launch {
            homeRepository.setDarkTheme(value)
        }
    }
}