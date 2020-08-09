package com.sample.feature_todo.domain.impl

import com.sample.domain.login.GetCurrentUserUseCase
import com.sample.domain.todo.GetToDosUseCase
import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.domain.GetCurrentUserToDosUseCase

class GetCurrentUserToDosUseCaseImpl(
    val currentUserUseCase: GetCurrentUserUseCase,
    val getToDosUseCase: GetToDosUseCase
) : GetCurrentUserToDosUseCase {

    override suspend fun invoke(): List<ToDoModel> {
        val user = currentUserUseCase() ?: return emptyList()
        return getToDosUseCase(user.id)
    }

}