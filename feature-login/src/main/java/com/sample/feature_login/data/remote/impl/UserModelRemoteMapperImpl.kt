package com.sample.feature_login.data.remote.impl

import com.sample.domain.login.UserModel
import com.sample.feature_login.data.remote.UserModelNetworkDTO
import com.sample.feature_login.data.remote.UserModelRemoteMapper

class UserModelRemoteMapperImpl : UserModelRemoteMapper {
    override fun transform(dto: UserModelNetworkDTO): UserModel {
        return UserModel(id = dto.id, name = dto.name, email = dto.email)
    }

}