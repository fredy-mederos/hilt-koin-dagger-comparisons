package com.sample.feature_todo.di

import com.sample.domain.todo.GetToDosUseCase
import com.sample.feature_todo.data.ToDoAPI
import com.sample.feature_todo.data.ToDoMapper
import com.sample.feature_todo.data.impl.ToDoAPIFakeImpl
import com.sample.feature_todo.data.impl.ToDoMapperImpl
import com.sample.feature_todo.domain.GetCurrentUserToDosUseCase
import com.sample.feature_todo.domain.impl.GetCurrentUserToDosUseCaseImpl
import com.sample.feature_todo.domain.impl.GetToDosUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

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
}