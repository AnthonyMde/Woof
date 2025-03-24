package com.example.data.source.local

import com.example.data.entity.PublicationEntity

class FakeLocalDatabaseImpl : FakeLocalDatabase {
    override suspend fun getPublications(): List<PublicationEntity> {
        return emptyList()
    }
}