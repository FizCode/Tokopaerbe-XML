package dev.fizcode.tokopaerbe_xml.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.OnBoardingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : ViewModel() {

    val shouldSkipOnboarding: MutableLiveData<Boolean> = MutableLiveData()

    fun onViewLoaded() {
        getOnboardingValue()
    }

    private fun getOnboardingValue() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = onBoardingRepository.getOnboarding()
            withContext(Dispatchers.Main) {
                if (response == true) shouldSkipOnboarding.postValue(true)
                else shouldSkipOnboarding.postValue(false)
            }
        }
    }
}