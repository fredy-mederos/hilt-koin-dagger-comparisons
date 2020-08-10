package com.sample.feature_todo.domain.impl

import com.sample.domain.todo.GetToDosUseCase
import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoMapper
import javax.inject.Inject

class GetToDosUseCaseImpl @Inject constructor(
    val api: ToDoAPI,
    val mapper: ToDoMapper
) : GetToDosUseCase {
    override suspend fun invoke(userId: String): List<ToDoModel> {
        val todosDtos = api.getTodos(userId)
        return todosDtos.map { mapper.transform(it) }
    }

}