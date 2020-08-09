package com.sample.domain.todo

interface GetToDosUseCase {
    suspend operator fun invoke(userId: String): List<ToDoModel>
}