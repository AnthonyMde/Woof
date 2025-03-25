package com.example.data.source.local

import com.example.data.entity.PublicationEntity
import com.example.data.entity.UserSessionEntity
import com.example.domain.constant.User
import com.example.domain.models.comment.Comment

internal class FakeLocalDatabaseImpl : FakeLocalDatabase {
    private val savedPublications = mutableListOf<PublicationEntity>()

    override suspend fun savePublications(vararg publication: PublicationEntity) {
        publication.forEach { newItem ->
            val index = savedPublications.indexOfFirst { it.timestamp == newItem.timestamp }
            if (index != -1) {
                savedPublications[index] = newItem
            } else {
                savedPublications.add(newItem)
            }
        }
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

    override suspend fun getPublicationComments(publicationId: String): List<Comment> {
        return savedPublications.find { it.id == publicationId }?.comments ?: emptyList()
    }
}
