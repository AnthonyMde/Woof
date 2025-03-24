package com.example.data

import com.example.data.entity.PublicationEntity
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.Publication
import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository

class PublicationsRepositoryImpl(
    private val fakeRemoteBackEnd: FakeRemoteBackEnd,
    private val fakeLocalDatabase: FakeLocalDatabase
) : PublicationsRepository {
    override suspend fun getPublications(): Resource<List<Publication>> {
        val publications = fakeRemoteBackEnd.getPublications().map { it.toPublication() }
        fakeLocalDatabase.savePublications(
            *publications.map { PublicationEntity.from(it) }.toTypedArray()
        )
        val savedPublications = fakeLocalDatabase.getPublications().map { it.toPublication() }

        return Resource.Success(savedPublications)
    }
}