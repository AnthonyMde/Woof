package com.example.data.source.local

import com.example.data.entity.PublicationEntity

interface FakeLocalDatabase {
    suspend fun savePublications(vararg publication: PublicationEntity)
    suspend fun getPublications(): List<PublicationEntity>
}