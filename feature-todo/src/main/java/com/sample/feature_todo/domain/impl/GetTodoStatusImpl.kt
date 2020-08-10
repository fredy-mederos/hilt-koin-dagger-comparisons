package com.sample.feature_todo.domain.impl

import com.sample.domain.login.GetCurrentUserUseCase
import com.sample.domain.todo.GetTodoStatus
import com.sample.domain.todo.ToDoStatus
import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoStatusMapper

class GetTodoStatusImpl(
    val api: ToDoAPI,
    val mapper: ToDoStatusMapper,
    val currentUserUseCase: GetCurrentUserUseCase
) : GetTodoStatus {

    override suspend fun invoke(toDoId: String): ToDoStatus {
        val userId = currentUserUseCase()?.id ?: error("No user")
        val res = api.getTodoStatus(userId, toDoId)
        return mapper.transform(res)
    }
}