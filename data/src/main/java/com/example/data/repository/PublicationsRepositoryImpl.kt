package com.example.data.repository

import com.example.data.entity.PublicationEntity
import com.example.data.request.CreatePublicationRequest
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.comment.Comment
import com.example.domain.models.comment.PostCommentModel
import com.example.domain.models.publication.PostPublicationModel
import com.example.domain.models.publication.Publication
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

    override suspend fun postPublication(postPublicationModel: PostPublicationModel) {
        val request = CreatePublicationRequest(
            postPublicationModel.userId,
            postPublicationModel.imageUriString, // IRL we would upload image to back-end server.
            postPublicationModel.petTalk,
            postPublicationModel.color
        )

        val publication = fakeRemoteBackEnd.createPublication(request).toPublication()
        fakeLocalDatabase.savePublications(PublicationEntity.from(publication))
    }

    override suspend fun getPublicationComments(publicationId: String): List<Comment> {
        return fakeLocalDatabase.getPublicationComments(publicationId)
    }

    override suspend fun postPublicationComment(postCommentModel: PostCommentModel) {
        val publications = fakeRemoteBackEnd.postPublicationComment(postCommentModel)
            .map { it.toPublication() }
        fakeLocalDatabase.savePublications(*publications.map { PublicationEntity.from(it) }.toTypedArray())
    }

    override suspend fun generatePetTalk(userId: String, imageUriString: String): String {
        return fakeRemoteBackEnd.generatePetTalkWithAI(userId, imageUriString)
    }
}