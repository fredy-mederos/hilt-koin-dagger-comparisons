package com.sample.feature_todo.data.impl

import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoDTO
import com.sample.feature_todo.data.ToDoStatusDTO
import kotlinx.coroutines.delay
import javax.inject.Inject

class ToDoAPIFakeImpl @Inject constructor() : ToDoAPI {
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
            ToDoDTO("12", "Todo12", "This is the todo 12"),
            ToDoDTO("13", "Todo13", "This is the todo 13"),
            ToDoDTO("14", "Todo14", "This is the todo 14"),
            ToDoDTO("15", "Todo15", "This is the todo 15"),
            ToDoDTO("16", "Todo16", "This is the todo 16"),
            ToDoDTO("17", "Todo17", "This is the todo 17"),
            ToDoDTO("18", "Todo18", "This is the todo 18"),
            ToDoDTO("19", "Todo19", "This is the todo 19"),
            ToDoDTO("20", "Todo20", "This is the todo 20")
        )
    }

    override suspend fun getTodoStatus(userId: String, todoId: String): ToDoStatusDTO {
        delay(1_000)
        return when (todoId) {
            "1", "2", "12", "11", "20" -> ToDoStatusDTO(0)
            "3", "6", "0", "19" -> ToDoStatusDTO(1)
            else -> ToDoStatusDTO(-1)
        }
    }

}