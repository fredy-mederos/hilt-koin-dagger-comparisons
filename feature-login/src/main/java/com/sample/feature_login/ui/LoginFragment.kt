package com.sample.feature_login.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.base_android.getComponentDependencies
import com.sample.feature_login.R
import com.sample.feature_login.di.DaggerLoginComponent
import com.sample.feature_login.di.LoginComponent
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.login_fragment) {

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory

    lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var navigator: LoginNavigator

    var scopedComponent: LoginComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedComponent =
            DaggerLoginComponent.builder()
                .loginDependencies(getComponentDependencies())
                .loginNavigationDependencies(getComponentDependencies())
                .build()
        scopedComponent?.inject(this)
        viewModel =
            ViewModelProvider(this, this.viewModeFactory).get(LoginViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        scopedComponent = null
    }

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