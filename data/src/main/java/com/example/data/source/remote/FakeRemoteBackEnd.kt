package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.data.request.CreatePublicationRequest

internal interface FakeRemoteBackEnd {
    suspend fun getPublications(): List<PublicationDTO>
    suspend fun createPublication(request: CreatePublicationRequest): PublicationDTO
}