package com.sample.feature_todo.data.impl

import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoDTO
import com.sample.feature_todo.data.ToDoStatusDTO
import kotlinx.coroutines.delay

class ToDoAPIFakeImpl : ToDoAPI {
    override suspend fun getTodos(userId: String): List<ToDoDTO> {
        delay(2_000)
        return listOf(
            ToDoDTO("1", "Todo1", "This is the todo 1"),
            ToDoDTO("2", "Todo2", "This is the todo 2"),
            ToDoDTO("3", "Todo3", "This is the todo 3"),
            ToDoDTO("4", "Todo4", "This is the todo 4"),
            ToDoDTO("5", "Todo5", "This is the todo 5"),
            ToDoDTO("6", "Todo6", "This is the todo 6"),
            ToDoDTO("7", "Todo7", "This is the todo 7"),
            ToDoDTO("8", "Todo8", "This is the todo 8"),
            ToDoDTO("9", "Todo9", "This is the todo 9"),
            ToDoDTO("10", "Todo10", "This is the todo 10"),
            ToDoDTO("11", "Todo11", "This is the todo 11"),
            ToDoDTO("12", "Todo12", "This is the todo 12")
        )
    }

    override suspend fun getTodoStatus(userId: String, todoId: String): ToDoStatusDTO {
        delay(2_000)
        return when (todoId) {
            "1", "2", "12", "11" -> ToDoStatusDTO(0)
            "3", "6", "0" -> ToDoStatusDTO(1)
            else -> ToDoStatusDTO(-1)
        }
    }

}