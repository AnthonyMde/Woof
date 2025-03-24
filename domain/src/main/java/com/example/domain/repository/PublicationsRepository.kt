package com.example.domain.repository

import com.example.domain.models.Publication
import com.example.domain.models.Resource

interface PublicationsRepository {
    suspend fun getPublications(): Resource<List<Publication>>
}