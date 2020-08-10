package com.sample.feature_todo.di

import androidx.lifecycle.ViewModel
import com.sample.base_android.ComponentDependencies
import com.sample.base_android.ViewModelFactoryModule
import com.sample.base_android.ViewModelKey
import com.sample.domain.login.GetCurrentUserUseCase
import com.sample.domain.login.LoginUseCase
import com.sample.domain.login.LogoutUseCase
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
import com.sample.feature_todo.ui.ToDoListNavigator
import com.sample.feature_todo.ui.ToDosFragment
import com.sample.feature_todo.ui.ToDosViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

interface TodoDependencies : ComponentDependencies {
    fun todoNavigator(): ToDoListNavigator
    fun logoutUseCase(): LogoutUseCase
    fun currentUser(): GetCurrentUserUseCase
}

@Singleton
@Component(
    modules = [TodoModule::class, ViewModelFactoryModule::class],
    dependencies = [TodoDependencies::class]
)
interface TodoComponent {
    fun inject(fragment: ToDosFragment)
    fun getTodoStatus(): GetTodoStatus
}

@Module
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
    abstract fun bindGetToDosStatusImpl(impl: GetTodoStatusImpl): GetTodoStatus

    @Binds
    abstract fun bindToDoStatusMapperImpl(impl: ToDoStatusMapperImpl): ToDoStatusMapper

    @Binds
    @IntoMap
    @ViewModelKey(ToDosViewModel::class)
    abstract fun bindToDosViewModel(vm: ToDosViewModel): ViewModel
}