package com.sample.feature_todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.base_android.ActionLiveData
import com.sample.domain.login.LogoutUseCase
import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.domain.GetCurrentUserToDosUseCase
import kotlinx.coroutines.launch

class ToDosViewModel(
    val getCurrentUserToDosUseCase: GetCurrentUserToDosUseCase,
    val logoutUseCase: LogoutUseCase
) : ViewModel() {

    val onLogout: LiveData<Unit> = ActionLiveData()

    val todos: LiveData<List<ToDoModel>> = MutableLiveData()

    init {
        viewModelScope.launch {
            (todos as MutableLiveData).value = getCurrentUserToDosUseCase()
        }
    }

    fun logout() {
        viewModelScope.launch {
            logoutUseCase()
            (onLogout as ActionLiveData).sendAction(Unit)
        }
    }
}