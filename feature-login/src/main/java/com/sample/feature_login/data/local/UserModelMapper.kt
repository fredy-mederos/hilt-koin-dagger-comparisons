package com.sample.feature_login.data.local

import com.sample.domain.login.UserModel

interface UserModelMapper {
    fun transform(dto: UserModelDTO): UserModel
    fun transform(model: UserModel): UserModelDTO
}