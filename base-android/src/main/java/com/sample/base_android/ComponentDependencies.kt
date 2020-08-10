@file:Suppress("UNCHECKED_CAST")
@file:JvmName("ComponentDependenciesUtils")

package com.sample.base_android

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

interface ComponentDependencies

interface ComponentDependenciesProvider {
    val dependencies: ComponentDependencies
}

fun <COMPONENT : ComponentDependencies> View.getComponentDependencies(): COMPONENT = context.getComponentDependencies()

fun <COMPONENT : ComponentDependencies> Fragment.getComponentDependencies(): COMPONENT = requireContext().getComponentDependencies()

fun <COMPONENT : ComponentDependencies> Context.getComponentDependencies(): COMPONENT {
    check(applicationContext is ComponentDependenciesProvider) { "App class must implement CoreComponentProvider" }
    val component = (applicationContext as ComponentDependenciesProvider).dependencies
    return try {
        component as COMPONENT
    } catch (ex: Throwable) {
        error("The app provided component is not an instance of desired one")
    }
}