package com.example.data.repository

import com.example.data.entity.PublicationEntity
import com.example.data.request.CreatePublicationRequest
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.Comment
import com.example.domain.models.Publication
import com.example.domain.repository.PublicationsRepository

internal class PublicationsRepositoryImpl(
    private val fakeRemoteBackEnd: FakeRemoteBackEnd,
    private val fakeLocalDatabase: FakeLocalDatabase
) : PublicationsRepository {
    override suspend fun getPublications(): List<Publication> {
        val publications = fakeRemoteBackEnd.getPublications().map { it.toPublication() }
        fakeLocalDatabase.savePublications(
            *publications.map { PublicationEntity.from(it) }.toTypedArray()
        )
        val savedPublications = fakeLocalDatabase.getPublications().map { it.toPublication() }

        return savedPublications
    }

    override suspend fun postPublication(userId: String, imageUriString: String) {
        val request = CreatePublicationRequest(
            userId,
            imageUriString // IRL we would upload image to back-end server.
        )

        val publication = fakeRemoteBackEnd.createPublication(request).toPublication()
        fakeLocalDatabase.savePublications(PublicationEntity.from(publication))
    }

    override suspend fun getPublicationComments(publicationId: String): List<Comment> {
        return fakeLocalDatabase.getPublicationComments(publicationId)
    }
}