package com.example.domain.usecase.publication

import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostPublicationUseCase(
    private val publicationsRepository: PublicationsRepository
) {
    operator fun invoke(userId: String, imageUriString: String): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())

        try {
            publicationsRepository.postPublication(userId, imageUriString)
            emit(Resource.Success())
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}
