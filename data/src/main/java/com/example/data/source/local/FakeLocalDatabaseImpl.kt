package com.example.data.source.local

import com.example.data.entity.PublicationEntity
import com.example.data.entity.UserSessionEntity
import com.example.domain.constant.User

class FakeLocalDatabaseImpl : FakeLocalDatabase {
    private val savedPublications = mutableListOf<PublicationEntity>()

    override suspend fun savePublications(vararg publication: PublicationEntity) {
        val existingItemsTimestamp = savedPublications.map { it.timestamp }
        val newItems = publication.filter { it.timestamp !in existingItemsTimestamp }
        savedPublications.addAll(newItems)
    }

    override suspend fun getPublications(): List<PublicationEntity> {
        return savedPublications
    }

    override suspend fun getUserSession(): UserSessionEntity {
        return UserSessionEntity(
            id = User.USER_ID,
            name = User.USERNAME,
            pictureUriString = User.PICTURE
        )
    }
}
