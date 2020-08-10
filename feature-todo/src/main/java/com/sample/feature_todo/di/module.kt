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
import com.sample.feature_todo.ui.ToDosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureToDoModule = module {
    factory<ToDoAPI> { ToDoAPIFakeImpl() }
    factory<ToDoMapper> { ToDoMapperImpl() }
    factory<GetCurrentUserToDosUseCase> { GetCurrentUserToDosUseCaseImpl(get(), get()) }
    factory<GetToDosUseCase> { GetToDosUseCaseImpl(get(), get()) }
    factory<GetTodoStatus> { GetTodoStatusImpl(get(), get(), get()) }
    factory<ToDoStatusMapper> { ToDoStatusMapperImpl() }

    viewModel { ToDosViewModel(get(), get()) }
}