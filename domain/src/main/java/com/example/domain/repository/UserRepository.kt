package com.example.domain.repository

import com.example.domain.models.publication.Publication
import com.example.domain.models.user.UserProfile
import com.example.domain.models.user.UserSession

interface UserRepository {
    suspend fun getUserSession(): UserSession
    suspend fun getUserProfile(userId: String): UserProfile?
    suspend fun togglePublicationLike(likerId: String, publicationId: String): List<Publication>
}
