package com.sample.domain.todo

class ToDoModel(
    val id: String,
    val title: String,
    val body: String
)

enum class ToDoStatus{
    DRAFT,
    DONE,
    UNKNOWN
}