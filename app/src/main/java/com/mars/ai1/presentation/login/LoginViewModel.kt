package com.mars.ai1.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mars.ai1.data.repository.user.UserRepository
import com.mars.ai1.utils.livedata.EmptySingleLiveData
import com.mars.ai1.utils.livedata.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private var userName: String = ""

    private val _navigateToQuestionsLiveData: EmptySingleLiveData = SingleLiveData()
    val navigateToQuestionsLiveData: LiveData<Unit> = _navigateToQuestionsLiveData

    private val _isLoginEnabledLiveData: MutableLiveData<Boolean> = MutableLiveData(isUsernameValid())
    val isLoginEnabledLiveData: LiveData<Boolean> = _isLoginEnabledLiveData

    fun login() {
        viewModelScope.launch {
            userRepository.loginUser(userName)
            _navigateToQuestionsLiveData.call()
        }
    }

    fun onUsernameChanged(userName: String) {
        this.userName = userName
        _isLoginEnabledLiveData.value = isUsernameValid()
    }

    private fun isUsernameValid() = userName.isNotBlank()
}