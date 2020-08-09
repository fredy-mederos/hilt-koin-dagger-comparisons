package com.sample.feature_login.data.remote

interface UserServicesAPI {
    suspend fun login(email: String, password: String): UserModelNetworkDTO
}