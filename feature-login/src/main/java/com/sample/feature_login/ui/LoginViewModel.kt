package com.sample.feature_login.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.base_android.ActionLiveData
import com.sample.domain.login.LoginUseCase
import com.sample.domain.login.UserModel
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val loginUseCase: LoginUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val onLogedIn: LiveData<UserModel> = ActionLiveData()
    val onError: LiveData<String> = ActionLiveData()

    fun logIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                val user = loginUseCase(email, password)
                (onLogedIn as ActionLiveData).sendAction(user)
            } catch (ex: Exception) {
                (onError as ActionLiveData).sendAction(
                    ex.message ?: "Unknown Error"
                )
            }
        }
    }
}