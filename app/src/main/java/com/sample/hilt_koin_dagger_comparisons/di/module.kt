package com.sample.hilt_koin_dagger_comparisons.di

import com.sample.base_android.FragmentScope
import com.sample.feature_login.di.CurrentUserDaoModule
import com.sample.feature_login.di.LoginDependencies
import com.sample.feature_login.di.LoginModule
import com.sample.feature_login.di.LoginNavigationDependencies
import com.sample.feature_login.ui.LoginNavigator
import com.sample.feature_todo.di.TodoDependencies
import com.sample.feature_todo.di.TodoNavigationDependencies
import com.sample.feature_todo.ui.ToDoListNavigator
import com.sample.hilt_koin_dagger_comparisons.Navigator
import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigatorModule {

    @Binds
    @FragmentScope
    fun bindLoginNavigator(impl: Navigator): LoginNavigator

    @Binds
    @FragmentScope
    fun bindTodoNavigator(impl: Navigator): ToDoListNavigator
}

@Singleton
@Component(
    modules = [
        LoginModule::class,
        CurrentUserDaoModule::class
    ]
)
interface MainComponent : LoginDependencies, TodoDependencies

@FragmentScope
@Component(modules = [NavigatorModule::class])
interface NavigationComponent : LoginNavigationDependencies, TodoNavigationDependencies
