package com.sample.feature_todo.data

import com.sample.domain.todo.ToDoModel
import com.sample.domain.todo.ToDoStatus

interface ToDoMapper {
    fun transform(dto: ToDoDTO): ToDoModel
}

interface ToDoStatusMapper {
    fun transform(dto: ToDoStatusDTO): ToDoStatus
}