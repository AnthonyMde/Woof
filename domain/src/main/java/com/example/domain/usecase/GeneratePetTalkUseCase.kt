package com.example.domain.usecase

import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GeneratePetTalkUseCase(
    private val publicationsRepository: PublicationsRepository,
    private val userRepository: UserRepository
) {
    operator fun invoke(imageUriString: String): Flow<Resource<String>> = flow {
        emit(Resource.Loading())

        val userId = userRepository.getUserSession().id
        try {
            val petTalk = publicationsRepository.generatePetTalk(userId, imageUriString)
            emit(Resource.Success(petTalk))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}
