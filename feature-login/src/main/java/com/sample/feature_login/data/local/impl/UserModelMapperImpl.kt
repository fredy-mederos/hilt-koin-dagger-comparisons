package com.sample.feature_login.data.local.impl

import com.sample.domain.login.UserModel
import com.sample.feature_login.data.local.UserModelDTO
import com.sample.feature_login.data.local.UserModelMapper
import javax.inject.Inject

class UserModelMapperImpl @Inject constructor() : UserModelMapper {

    override fun transform(dto: UserModelDTO): UserModel {
        return UserModel(id = dto.id, name = dto.name, email = dto.email)
    }

    override fun transform(model: UserModel): UserModelDTO {
        return UserModelDTO(
            id = model.id,
            name = model.name,
            email = model.email
        )
    }

}