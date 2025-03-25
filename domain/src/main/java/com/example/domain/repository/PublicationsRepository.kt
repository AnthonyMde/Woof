package com.example.domain.repository

import com.example.domain.models.Comment
import com.example.domain.models.Publication

interface PublicationsRepository {
    suspend fun getPublications(): List<Publication>
    suspend fun postPublication(userId: String, imageUriString: String)
    suspend fun getPublicationComments(publicationId: String): List<Comment>
}