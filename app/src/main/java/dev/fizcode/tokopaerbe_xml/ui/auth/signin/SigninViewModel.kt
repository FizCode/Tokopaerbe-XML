package dev.fizcode.tokopaerbe_xml.ui.auth.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.fizcode.tokopaerbe_xml.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    val shouldOpenMenuPage: MutableLiveData<Boolean> = MutableLiveData()

    // TODO: Change if already have a token
    fun insertToken() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = authRepository.updateToken("Signed In")
            withContext(Dispatchers.Main) {
                shouldOpenMenuPage.value = true
            }
        }
    }
}