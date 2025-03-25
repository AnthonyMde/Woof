package com.example.domain.usecase

import com.example.domain.models.PostCommentModel
import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostPublicationCommentUseCase(
    private val publicationsRepository: PublicationsRepository,
    private val userRepository: UserRepository
) {
    companion object {
        private const val MAX_CHAR_LENGTH = 250
    }

    operator fun invoke(publicationId: String, commentText: String): Flow<Resource<Unit>> = flow {
        if (commentText.isBlank()) return@flow

        emit(Resource.Loading())

        val sanitizedText = commentText.take(MAX_CHAR_LENGTH)
        val userId = userRepository.getUserSession().id
        val postCommentModel = PostCommentModel(
            publicationId = publicationId,
            userId = userId,
            commentText = sanitizedText
        )

        try {
            publicationsRepository.postPublicationComment(postCommentModel)
            emit(Resource.Success())
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}
