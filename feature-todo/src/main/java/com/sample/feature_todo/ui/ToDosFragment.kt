package com.sample.feature_todo.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sample.feature_todo.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_todos.*
import javax.inject.Inject

@AndroidEntryPoint
class ToDosFragment : Fragment(R.layout.fragment_todos) {

    val viewModel: ToDosViewModel by viewModels()

    @Inject
    lateinit var navigator: ToDoListNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.todos.observe(viewLifecycleOwner, Observer { items ->
            recyclerView.adapter = ToDoAdapter(items)
        })
        viewModel.onLogout.observe(viewLifecycleOwner, Observer {
            navigator.goToLogin(this)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.logout()
        return super.onOptionsItemSelected(item)
    }
}