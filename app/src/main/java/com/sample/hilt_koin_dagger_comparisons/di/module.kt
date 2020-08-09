package com.sample.hilt_koin_dagger_comparisons.di

import com.sample.feature_login.ui.LoginNavigator
import com.sample.feature_todo.ui.ToDoListNavigator
import com.sample.hilt_koin_dagger_comparisons.Navigator
import org.koin.dsl.module

val navigatorModule = module {
    factory<LoginNavigator> { Navigator() }
    factory<ToDoListNavigator> { Navigator() }
}