package com.sample.feature_login.data.remote.impl

import com.sample.feature_login.data.remote.UserModelNetworkDTO
import com.sample.feature_login.data.remote.UserServicesAPI
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserServicesAPIFakeImpl @Inject constructor() : UserServicesAPI {

    override suspend fun login(email: String, password: String): UserModelNetworkDTO {
        delay(2_000)
        if (email != "admin" || password != "admin") {
            error("403 invalid credentials")
        }

        return UserModelNetworkDTO(
            "1",
            "Admin",
            "admin@mail.com"
        )
    }
}