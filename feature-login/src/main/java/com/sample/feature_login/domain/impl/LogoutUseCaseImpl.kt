package com.sample.feature_login.domain.impl

import com.sample.domain.login.LogoutUseCase
import com.sample.feature_login.data.local.CurrentUserDAO

class LogoutUseCaseImpl(val dao: CurrentUserDAO) : LogoutUseCase {
    override suspend fun invoke() {
        dao.clearCurrentUser()
    }
}