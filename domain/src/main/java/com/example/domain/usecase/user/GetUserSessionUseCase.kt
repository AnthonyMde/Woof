package com.example.domain.usecase.user

import com.example.domain.models.UserSession
import com.example.domain.repository.UserRepository

class GetUserSessionUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): UserSession {
        return userRepository.getUserSession()
    }
}
