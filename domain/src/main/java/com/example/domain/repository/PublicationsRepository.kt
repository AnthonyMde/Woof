package com.example.domain.repository

import com.example.domain.models.Comment
import com.example.domain.models.PostCommentModel
import com.example.domain.models.PostPublicationModel
import com.example.domain.models.Publication

interface PublicationsRepository {
    suspend fun getPublications(): List<Publication>
    suspend fun postPublication(postPublicationModel: PostPublicationModel)
    suspend fun getPublicationComments(publicationId: String): List<Comment>
    suspend fun postPublicationComment(postCommentModel: PostCommentModel)
    suspend fun generatePetTalk(userId: String, imageUriString: String): String
}