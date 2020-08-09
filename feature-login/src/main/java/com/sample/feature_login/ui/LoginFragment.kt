package com.sample.feature_login.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sample.feature_login.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var viewModel: LoginViewModel
    lateinit var navigator: LoginNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onLogedIn.observe(viewLifecycleOwner, Observer { user ->
            navigator.goToTodoList(this)
            showMessage("Welcome ${user.name}")
        })
        viewModel.onError.observe(viewLifecycleOwner, Observer { error ->
            showMessage(error)
        })

        button?.setOnClickListener {
            viewModel.logIn(
                email = emailInputLayout.editText?.text?.toString().orEmpty(),
                password = passwordInputLayout.editText?.text?.toString().orEmpty()
            )
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}