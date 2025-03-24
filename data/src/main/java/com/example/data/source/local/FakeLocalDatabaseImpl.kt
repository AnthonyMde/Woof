package com.example.data.source.local

import com.example.data.entity.PublicationEntity
import com.example.data.entity.UserSessionEntity

class FakeLocalDatabaseImpl : FakeLocalDatabase {
    private val savedPublications = mutableListOf<PublicationEntity>()

    override suspend fun savePublications(vararg publication: PublicationEntity) {
        savedPublications.addAll(publication.toList())
    }

    override suspend fun getPublications(): List<PublicationEntity> {
        return savedPublications
    }

    override suspend fun getUserSession(): UserSessionEntity {
        return UserSessionEntity(
            id = "1",
            name = "Towny",
            pictureUriString = "android.resource://com.example.woof/drawable/user_pp"
        )
    }
}
