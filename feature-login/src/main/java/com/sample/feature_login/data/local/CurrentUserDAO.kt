package com.sample.feature_login.data.local

interface CurrentUserDAO {
    suspend fun getCurrentUser(): UserModelDTO?
    suspend fun saveCurrentUser(user: UserModelDTO)
    suspend fun clearCurrentUser()
}