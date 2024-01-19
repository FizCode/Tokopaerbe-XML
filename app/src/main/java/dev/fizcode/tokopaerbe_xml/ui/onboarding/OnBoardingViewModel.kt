package dev.fizcode.tokopaerbe_xml.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.OnBoardingRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
): ViewModel() {

    fun completeOnboarding() {
        viewModelScope.launch {
            onBoardingRepository.updateOnboarding("Complete")
        }
    }

}