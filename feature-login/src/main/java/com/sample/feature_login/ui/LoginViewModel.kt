package com.sample.feature_login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.domain.login.LoginUseCase
import com.sample.domain.login.UserModel
import com.sample.base_android.ActionLiveData
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    val onLogedIn: LiveData<UserModel> = com.sample.base_android.ActionLiveData()
    val onError: LiveData<String> = com.sample.base_android.ActionLiveData()

    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = loginUseCase(email, password)
                (onLogedIn as com.sample.base_android.ActionLiveData).sendAction(user)
            } catch (ex: Exception) {
                (onError as com.sample.base_android.ActionLiveData).sendAction(ex.message ?: "Unknown Error")
            }
        }
    }
}