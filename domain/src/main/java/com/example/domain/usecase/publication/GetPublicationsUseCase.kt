package com.example.domain.usecase.publication

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

        try {
            val publications = publicationRepository.getPublications()
            val reversed = publications.reversed()
            emit(Resource.Success(reversed))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}
