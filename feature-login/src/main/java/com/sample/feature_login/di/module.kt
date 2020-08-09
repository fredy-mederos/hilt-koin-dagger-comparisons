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
import com.sample.feature_login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureLoginModule = module {
    single<CurrentUserDAO> { CurrentUserDAOInMemoryImpl() }
    factory<UserModelMapper> { UserModelMapperImpl() }
    factory<UserModelRemoteMapper> { UserModelRemoteMapperImpl() }
    factory<UserServicesAPI> { UserServicesAPIFakeImpl() }
    factory<GetCurrentUserUseCase> { GetCurrentUserUseCaseImpl(get(), get()) }
    factory<LoginUseCase> { LoginUseCaseImpl(get(), get(), get(), get()) }
    factory<LogoutUseCase> { LogoutUseCaseImpl(get()) }

    viewModel { LoginViewModel(get()) }
}