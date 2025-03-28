package com.example.data.repository

import com.example.data.entity.PublicationEntity
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.publication.Publication
import com.example.domain.models.user.UserProfile
import com.example.domain.models.user.UserSession
import com.example.domain.repository.UserRepository

internal class UserRepositoryImpl(
    private val fakeLocalDatabase: FakeLocalDatabase,
    private val fakeRemoteBackEnd: FakeRemoteBackEnd
) : UserRepository {
    override suspend fun getUserSession(): UserSession {
        return fakeLocalDatabase.getUserSession().toUserSession()
    }

    override suspend fun getUserProfile(userId: String): UserProfile? {
        return fakeRemoteBackEnd.getUserProfileById(userId)
    }

    override suspend fun togglePublicationLike(
        likerId: String,
        publicationId: String
    ): List<Publication> {
        val updatedPublication = fakeRemoteBackEnd
            .togglePublicationLike(likerId, publicationId)
            .map { it.toPublication() }

        fakeLocalDatabase
            .savePublications(*updatedPublication.map { PublicationEntity.from(it) }
            .toTypedArray())

        return fakeLocalDatabase.getPublications().map { it.toPublication() }
    }
}
