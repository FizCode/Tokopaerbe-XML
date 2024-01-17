package dev.fizcode.tokopaerbe_xml.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.OnboardingRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingRepository: OnboardingRepository
): ViewModel() {

    fun completeOnboarding() {
        viewModelScope.launch {
            onBoardingRepository.updateOnboarding(true)
        }
    }
}