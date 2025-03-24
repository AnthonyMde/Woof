package com.example.data

import com.example.domain.models.Publication
import com.example.domain.models.Resource
import com.example.domain.repository.PublicationsRepository

class PublicationsRepositoryImpl : PublicationsRepository {
    override suspend fun getPublications(): Resource<List<Publication>> {
        TODO("Not yet implemented")
    }
}