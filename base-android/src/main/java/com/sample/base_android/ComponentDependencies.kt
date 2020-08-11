@file:Suppress("UNCHECKED_CAST")
@file:JvmName("ComponentDependenciesUtils")

package com.sample.base_android

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment

interface ComponentDependencies

interface ComponentDependenciesProvider {
    val dependencies: List<ComponentDependencies>
}

inline fun <reified COMPONENT : ComponentDependencies> View.getComponentDependencies(): COMPONENT =
    context.getComponentDependencies()

inline fun <reified COMPONENT : ComponentDependencies> Fragment.getComponentDependencies(): COMPONENT =
    requireContext().getComponentDependencies()

inline fun <reified COMPONENT : ComponentDependencies> Context.getComponentDependencies(): COMPONENT {
    check(applicationContext is ComponentDependenciesProvider) { "App class must implement CoreComponentProvider" }
    val component = (applicationContext as ComponentDependenciesProvider).dependencies
    return try {
        component.first { it is COMPONENT } as COMPONENT
    } catch (ex: Throwable) {
        error("The app provided component is not an instance of desired one")
    }
}