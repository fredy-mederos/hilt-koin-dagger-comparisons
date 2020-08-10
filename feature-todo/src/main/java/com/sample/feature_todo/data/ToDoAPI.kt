package com.sample.feature_todo.data

interface ToDoAPI {
    suspend fun getTodos(userId: String): List<ToDoDTO>
    suspend fun getTodoStatus(userId: String, todoId: String): ToDoStatusDTO
}