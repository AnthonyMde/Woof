package com.example.domain.usecase

import com.example.domain.models.Publication
import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPublicationsUseCase(
    private val publicationRepository: PublicationsRepository
) {
    operator fun invoke(): Flow<Resource<List<Publication>>> = flow {
        emit(Resource.Loading())
        val result = when (val resource = publicationRepository.getPublications()) {
            is Resource.Success<List<Publication>> -> {
                val reversed = resource.data?.reversed()
                Resource.Success(reversed)
            }
            else -> resource
        }

        emit(result)
    }
}
