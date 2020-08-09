package com.sample.feature_todo.data.impl

import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoDTO
import kotlinx.coroutines.delay

class ToDoAPIFakeImpl : ToDoAPI {
    override suspend fun getTodos(userId: String): List<ToDoDTO> {
        delay(2_000)
        return listOf(
            ToDoDTO("1", "Todo1", "This is the todo 1"),
            ToDoDTO("2", "Todo2", "This is the todo 2"),
            ToDoDTO("3", "Todo3", "This is the todo 3")
        )
    }

}