package com.example.domain.usecase

import com.example.domain.models.Comment
import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPublicationCommentsUseCase(
    private val publicationsRepository: PublicationsRepository
) {
    operator fun invoke(publicationId: String): Flow<Resource<List<Comment>>> = flow {
        emit(Resource.Loading())

        try {
            val comments = publicationsRepository.getPublicationComments(publicationId)
            emit(Resource.Success(comments))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}