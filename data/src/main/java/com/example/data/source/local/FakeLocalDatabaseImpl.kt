package com.example.data.source.local

import com.example.data.entity.PublicationEntity

class FakeLocalDatabaseImpl : FakeLocalDatabase {
    private val savedPublications = mutableListOf<PublicationEntity>()

    override suspend fun savePublications(vararg publication: PublicationEntity) {
        savedPublications.addAll(publication.toList())
    }

    override suspend fun getPublications(): List<PublicationEntity> {
        return savedPublications
    }
}
