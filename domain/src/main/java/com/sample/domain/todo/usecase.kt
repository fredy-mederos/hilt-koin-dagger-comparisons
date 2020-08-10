package com.sample.domain.todo

interface GetToDosUseCase {
    suspend operator fun invoke(userId: String): List<ToDoModel>
}

interface GetTodoStatus {
    suspend operator fun invoke(toDoId: String): ToDoStatus
}