package com.sample.feature_todo.data

interface ToDoAPI {
    suspend fun getTodos(userId: String): List<ToDoDTO>
}