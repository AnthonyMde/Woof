package com.example.domain.usecase

import com.example.domain.models.Resource
import com.example.domain.repository.UserRepository

class TogglePublicationLikeUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(likerId: String, publicationId: String): Resource<Unit> {
        return try {
            userRepository.togglePublicationLike(likerId, publicationId)
            Resource.Success()
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
