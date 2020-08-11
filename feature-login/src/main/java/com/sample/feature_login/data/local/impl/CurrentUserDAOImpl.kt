package com.sample.feature_login.data.local.impl

import com.sample.feature_login.data.local.CurrentUserDAO
import com.sample.feature_login.data.local.UserModelDTO
import javax.inject.Inject
import javax.inject.Singleton

class CurrentUserDAOInMemoryImpl @Inject constructor() : CurrentUserDAO {

    var currentUser: UserModelDTO? = null

    override suspend fun getCurrentUser() = currentUser

    override suspend fun saveCurrentUser(user: UserModelDTO) {
        currentUser = user
    }

    override suspend fun clearCurrentUser() {
        currentUser = null
    }

}