package com.sample.feature_login.domain.impl

import com.sample.domain.login.GetCurrentUserUseCase
import com.sample.domain.login.UserModel
import com.sample.feature_login.data.local.CurrentUserDAO
import com.sample.feature_login.data.local.UserModelMapper

class GetCurrentUserUseCaseImpl(
    val dao: CurrentUserDAO,
    val mapper: UserModelMapper
) : GetCurrentUserUseCase {

    override suspend fun invoke(): UserModel? {
        val userDAO = dao.getCurrentUser() ?: return null
        return mapper.transform(userDAO)
    }

}