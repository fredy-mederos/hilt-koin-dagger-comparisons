package com.sample.hilt_koin_dagger_comparisons.di

import com.sample.feature_login.ui.LoginNavigator
import com.sample.feature_todo.ui.ToDoListNavigator
import com.sample.hilt_koin_dagger_comparisons.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class BindModule {

    @Binds
    abstract fun bindLoginNavigator(impl: Navigator): LoginNavigator

    @Binds
    abstract fun bindTodoListNavigator(impl: Navigator): ToDoListNavigator
}