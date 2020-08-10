package com.sample.feature_login.domain.impl

import com.sample.domain.login.LoginUseCase
import com.sample.domain.login.UserModel
import com.sample.feature_login.data.local.CurrentUserDAO
import com.sample.feature_login.data.local.UserModelMapper
import com.sample.feature_login.data.remote.UserModelRemoteMapper
import com.sample.feature_login.data.remote.UserServicesAPI
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    val dao: CurrentUserDAO,
    val api: UserServicesAPI,
    val remoteMapper: UserModelRemoteMapper,
    val localMapper: UserModelMapper
) : LoginUseCase {

    override suspend fun invoke(email: String, password: String): UserModel {
        val userFromNetwork = api.login(email, password)
        val userModel = remoteMapper.transform(userFromNetwork)
        val userModelLocal = localMapper.transform(userModel)
        dao.saveCurrentUser(userModelLocal)
        return userModel
    }
}