package com.example.data.source.local

import com.example.data.entity.PublicationEntity
import com.example.data.entity.UserSessionEntity

internal interface FakeLocalDatabase {
    suspend fun savePublications(vararg publication: PublicationEntity)
    suspend fun getPublications(): List<PublicationEntity>

    suspend fun getUserSession(): UserSessionEntity
}