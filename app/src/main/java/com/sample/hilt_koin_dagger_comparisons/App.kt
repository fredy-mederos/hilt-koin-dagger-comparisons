package com.sample.hilt_koin_dagger_comparisons

import android.app.Application
import com.sample.feature_login.di.featureLoginModule
import com.sample.feature_todo.di.featureToDoModule
import com.sample.hilt_koin_dagger_comparisons.di.navigatorModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(navigatorModule + featureToDoModule + featureLoginModule)
        }
    }
}