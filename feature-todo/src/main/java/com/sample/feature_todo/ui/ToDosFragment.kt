package com.sample.feature_todo.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.base_android.getComponentDependencies
import com.sample.feature_todo.R
import com.sample.feature_todo.di.DaggerTodoComponent
import com.sample.feature_todo.di.TodoComponent
import kotlinx.android.synthetic.main.fragment_todos.*
import javax.inject.Inject

class ToDosFragment : Fragment(R.layout.fragment_todos) {

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory

    lateinit var viewModel: ToDosViewModel

    @Inject
    lateinit var navigator: ToDoListNavigator

    var scopedComponent: TodoComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


        scopedComponent = DaggerTodoComponent.builder()
            .todoDependencies(getComponentDependencies())
            .todoNavigationDependencies(getComponentDependencies())
            .build()
        scopedComponent?.inject(this)
        viewModel = ViewModelProvider(this, this.viewModeFactory).get(ToDosViewModel::class.java)

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