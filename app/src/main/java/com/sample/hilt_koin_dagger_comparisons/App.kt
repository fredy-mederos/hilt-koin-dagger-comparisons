package com.sample.hilt_koin_dagger_comparisons

import android.app.Application
import com.sample.base_android.ComponentDependencies
import com.sample.base_android.ComponentDependenciesProvider
import com.sample.hilt_koin_dagger_comparisons.di.DaggerMainComponent
import com.sample.hilt_koin_dagger_comparisons.di.MainComponent

class App : Application(), ComponentDependenciesProvider {

    lateinit var mainComponent: MainComponent
    override val dependencies: ComponentDependencies get() = mainComponent

    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.builder().build()
    }

}