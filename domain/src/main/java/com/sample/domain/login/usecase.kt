package com.sample.domain.login

interface LoginUseCase {
    suspend operator fun invoke(email: String, password: String): UserModel
}

interface LogoutUseCase {
    suspend operator fun invoke()
}

interface GetCurrentUserUseCase {
    suspend operator fun invoke(): UserModel?
}