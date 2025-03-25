package com.example.domain.repository

import com.example.domain.models.UserProfile
import com.example.domain.models.UserSession

interface UserRepository {
    suspend fun getUserSession(): UserSession
    suspend fun getUserProfile(userId: String): UserProfile?
    suspend fun togglePublicationLike(likerId: String, publicationId: String)
}
