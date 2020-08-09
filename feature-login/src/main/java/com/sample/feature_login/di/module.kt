package com.sample.feature_login.di

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
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class SingletonModule {

    @Binds
    @Singleton
    abstract fun bindDao(impl: CurrentUserDAOInMemoryImpl): CurrentUserDAO
}

@Module
@InstallIn(ActivityComponent::class)
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
}