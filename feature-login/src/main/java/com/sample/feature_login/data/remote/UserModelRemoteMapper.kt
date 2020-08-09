package com.sample.feature_login.data.remote

import com.sample.domain.login.UserModel

interface UserModelRemoteMapper {
    fun transform(dto: UserModelNetworkDTO): UserModel
}