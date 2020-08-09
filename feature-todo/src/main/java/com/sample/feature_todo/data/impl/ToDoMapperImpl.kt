package com.sample.feature_todo.data.impl

import com.sample.domain.todo.ToDoModel
import com.sample.feature_todo.data.ToDoDTO
import com.sample.feature_todo.data.ToDoMapper

class ToDoMapperImpl : ToDoMapper {
    override fun transform(dto: ToDoDTO): ToDoModel {
        return ToDoModel(id = dto.id, title = dto.title, body = dto.title)
    }

}