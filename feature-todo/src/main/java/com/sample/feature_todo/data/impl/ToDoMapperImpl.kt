package com.sample.feature_todo.data.impl

import com.sample.domain.todo.ToDoModel
import com.sample.domain.todo.ToDoStatus
import com.sample.feature_todo.data.ToDoDTO
import com.sample.feature_todo.data.ToDoMapper
import com.sample.feature_todo.data.ToDoStatusDTO
import com.sample.feature_todo.data.ToDoStatusMapper
import javax.inject.Inject

class ToDoMapperImpl @Inject constructor() : ToDoMapper {
    override fun transform(dto: ToDoDTO): ToDoModel {
        return ToDoModel(id = dto.id, title = dto.title, body = dto.title)
    }
}

class ToDoStatusMapperImpl @Inject constructor() : ToDoStatusMapper {
    override fun transform(dto: ToDoStatusDTO): ToDoStatus {
        return when (dto.value) {
            0 -> ToDoStatus.DONE
            1 -> ToDoStatus.DRAFT
            else -> ToDoStatus.UNKNOWN
        }
    }
}