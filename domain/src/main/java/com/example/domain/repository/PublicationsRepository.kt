package com.example.domain.repository

import com.example.domain.models.Publication

interface PublicationsRepository {
    suspend fun getPublications(): List<Publication>
    suspend fun postPublication(userId: String, imageUriString: String)
}