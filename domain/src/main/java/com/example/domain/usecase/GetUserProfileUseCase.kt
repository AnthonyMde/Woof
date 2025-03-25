package com.example.domain.usecase

import com.example.domain.error.DomainException
import com.example.domain.models.Resource
import com.example.domain.models.UserProfile
import com.example.domain.repository.UserRepository

class GetUserProfileUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: String): Resource<UserProfile> {
        return try {
            val profile = userRepository.getUserProfile(userId)
            if (profile == null) {
                Resource.Error(DomainException.NoProfileFoundError)
            } else {
                Resource.Success(profile)
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
