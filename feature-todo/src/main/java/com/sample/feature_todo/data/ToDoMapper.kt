package com.sample.feature_todo.data

import com.sample.domain.todo.ToDoModel

interface ToDoMapper {
    fun transform(dto: ToDoDTO): ToDoModel
}