package com.sample.feature_login.data.remote

import com.sample.domain.login.UserModel
import com.sample.feature_login.data.local.UserModelDTO

interface UserModelRemoteMapper {
    fun transform(dto: UserModelNetworkDTO): UserModel
}