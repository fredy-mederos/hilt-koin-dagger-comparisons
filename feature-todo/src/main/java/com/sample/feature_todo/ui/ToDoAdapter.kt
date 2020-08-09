package com.sample.feature_todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_todo.*

class ToDoAdapter(private val items: List<ToDoModel>) :
    RecyclerView.Adapter<ToDoAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapterViewHolder {
        return ToDoAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ToDoAdapterViewHolder, position: Int) {
        val item = items[position]
        holder.titleTextView.text = item.title
        holder.bodyTextView.text = item.body
    }

}

class ToDoAdapterViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer