package dev.fizcode.tokopaerbe_xml.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {

    val shouldBeDarkTheme: MutableLiveData<Boolean> = MutableLiveData()

    fun onViewLoaded() {
        isDarkTheme()
    }

    private fun isDarkTheme(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = homeRepository.getDarkTheme()
            withContext(Dispatchers.Main) {
                if (result == "DARK") {
                    shouldBeDarkTheme.postValue(true)
                } else {
                    shouldBeDarkTheme.postValue(false)
                }
            }
        }
    }

    fun setTheme(value: String) {
        viewModelScope.launch {
            homeRepository.setDarkTheme(value)
            println(value)
        }
    }
}