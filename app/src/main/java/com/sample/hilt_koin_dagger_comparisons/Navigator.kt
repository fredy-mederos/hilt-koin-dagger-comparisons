package com.sample.hilt_koin_dagger_comparisons

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sample.feature_login.ui.LoginNavigator
import com.sample.feature_todo.ui.ToDoListNavigator
import javax.inject.Inject

class Navigator @Inject constructor() : LoginNavigator, ToDoListNavigator {

    override fun goToTodoList(currentFragment: Fragment) {
        currentFragment.findNavController().navigate(R.id.action_loginFragment_to_toDosFragment)
    }

    override fun goToLogin(currentFragment: Fragment) {
        currentFragment.findNavController().popBackStack(R.id.loginFragment, false)
    }

}