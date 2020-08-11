package com.sample.feature_todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sample.base_android.getComponentDependencies
import com.sample.domain.todo.GetTodoStatus
import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.R
import com.sample.feature_todo.di.DaggerTodoComponent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_todo.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

class ToDoAdapter(private val items: List<ToDoModel>) :
    RecyclerView.Adapter<ToDoAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapterViewHolder {
        return ToDoAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ToDoAdapterViewHolder, position: Int) {
        holder.bind(items[position])
    }

}

class ToDoAdapterViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer, CoroutineScope by MainScope() {

    val getTodoStatus: GetTodoStatus = DaggerTodoComponent.builder()
        .todoDependencies(containerView.context.getComponentDependencies())
        .todoNavigationDependencies(containerView.context.getComponentDependencies())
        .build()
        .getTodoStatus()

    fun bind(item: ToDoModel) {
        coroutineContext.cancelChildren()

        titleTextView.text = item.title
        bodyTextView.text = item.body

        launch {
            statusText?.isVisible = false
            progressBar?.isVisible = true

            val status = getTodoStatus(item.id)
            statusText?.text = status.toString()

            progressBar?.isVisible = false
            statusText?.isVisible = true
        }
    }
}