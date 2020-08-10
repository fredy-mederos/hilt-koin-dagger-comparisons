package com.sample.feature_todo.di

import com.sample.domain.todo.GetToDosUseCase
import com.sample.domain.todo.GetTodoStatus
import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoMapper
import com.sample.feature_todo.data.ToDoStatusMapper
import com.sample.feature_todo.data.impl.ToDoAPIFakeImpl
import com.sample.feature_todo.data.impl.ToDoMapperImpl
import com.sample.feature_todo.data.impl.ToDoStatusMapperImpl
import com.sample.feature_todo.domain.GetCurrentUserToDosUseCase
import com.sample.feature_todo.domain.impl.GetCurrentUserToDosUseCaseImpl
import com.sample.feature_todo.domain.impl.GetToDosUseCaseImpl
import com.sample.feature_todo.domain.impl.GetTodoStatusImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class TodoModule {

    @Binds
    abstract fun bindToDoAPIFakeImpl(impl: ToDoAPIFakeImpl): ToDoAPI

    @Binds
    abstract fun bindToDoMapperImpl(impl: ToDoMapperImpl): ToDoMapper

    @Binds
    abstract fun bindGetCurrentUserToDosUseCaseImpl(impl: GetCurrentUserToDosUseCaseImpl): GetCurrentUserToDosUseCase

    @Binds
    abstract fun bindGetToDosUseCaseImpl(impl: GetToDosUseCaseImpl): GetToDosUseCase

    @Binds
    abstract fun bindGetTodoStatusImpl(impl: GetTodoStatusImpl): GetTodoStatus

    @Binds
    abstract fun bindToDoStatusMapperImpl(impl: ToDoStatusMapperImpl): ToDoStatusMapper
}

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewHoldersEntryPoint {
    fun getTodoStatus(): GetTodoStatus
}