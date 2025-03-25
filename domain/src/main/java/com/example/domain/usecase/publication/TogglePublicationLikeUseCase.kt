package com.example.domain.usecase.publication

import com.example.domain.models.Publication
import com.example.domain.models.Resource
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TogglePublicationLikeUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(publicationId: String): Flow<Resource<List<Publication>>> = flow {
        emit(Resource.Loading())

        try {
            val userId = userRepository.getUserSession().id
            val publications = userRepository.togglePublicationLike(userId, publicationId)

            emit(Resource.Success(publications.reversed()))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}
