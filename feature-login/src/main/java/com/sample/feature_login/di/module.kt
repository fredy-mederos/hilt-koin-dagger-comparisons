package com.sample.feature_login.di

import androidx.lifecycle.ViewModel
import com.sample.base_android.ComponentDependencies
import com.sample.base_android.FragmentScope
import com.sample.base_android.ViewModelFactoryModule
import com.sample.base_android.ViewModelKey
import com.sample.domain.login.GetCurrentUserUseCase
import com.sample.domain.login.LoginUseCase
import com.sample.domain.login.LogoutUseCase
import com.sample.feature_login.data.local.CurrentUserDAO
import com.sample.feature_login.data.local.UserModelMapper
import com.sample.feature_login.data.local.impl.CurrentUserDAOInMemoryImpl
import com.sample.feature_login.data.local.impl.UserModelMapperImpl
import com.sample.feature_login.data.remote.UserModelRemoteMapper
import com.sample.feature_login.data.remote.UserServicesAPI
import com.sample.feature_login.data.remote.impl.UserModelRemoteMapperImpl
import com.sample.feature_login.data.remote.impl.UserServicesAPIFakeImpl
import com.sample.feature_login.domain.impl.GetCurrentUserUseCaseImpl
import com.sample.feature_login.domain.impl.LoginUseCaseImpl
import com.sample.feature_login.domain.impl.LogoutUseCaseImpl
import com.sample.feature_login.ui.LoginFragment
import com.sample.feature_login.ui.LoginNavigator
import com.sample.feature_login.ui.LoginViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

interface LoginDependencies : ComponentDependencies {
    fun currentUserDAO(): CurrentUserDAO
}

interface LoginNavigationDependencies : ComponentDependencies {
    fun loginNavigator(): LoginNavigator
}

@FragmentScope
@Component(
    modules = [
        LoginModule::class,
        ViewModelFactoryModule::class
    ],
    dependencies = [
        LoginDependencies::class,
        LoginNavigationDependencies::class
    ]
)
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)
}

@Module
abstract class CurrentUserDaoModule {

    @Binds
    @Singleton
    abstract fun bindCurrentUserDao(impl: CurrentUserDAOInMemoryImpl): CurrentUserDAO
}

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindUserModelMapper(impl: UserModelMapperImpl): UserModelMapper

    @Binds
    abstract fun bindUserModelRemoteMapperImpl(impl: UserModelRemoteMapperImpl): UserModelRemoteMapper

    @Binds
    abstract fun bindUserServicesAPIFakeImpl(impl: UserServicesAPIFakeImpl): UserServicesAPI

    @Binds
    abstract fun bindGetCurrentUserUseCaseImpl(impl: GetCurrentUserUseCaseImpl): GetCurrentUserUseCase

    @Binds
    abstract fun bindLoginUseCaseImpl(impl: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindLogoutUseCaseImpl(impl: LogoutUseCaseImpl): LogoutUseCase

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(vm: LoginViewModel): ViewModel
}