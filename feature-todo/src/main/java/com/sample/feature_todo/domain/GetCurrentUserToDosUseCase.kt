package com.sample.feature_todo.domain

import com.sample.domain.todo.ToDoModel

interface GetCurrentUserToDosUseCase {
    suspend operator fun invoke(): List<ToDoModel>
}