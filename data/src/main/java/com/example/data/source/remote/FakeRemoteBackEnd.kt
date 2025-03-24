package com.example.data.source.remote

import com.example.data.dto.PublicationDTO

interface FakeRemoteBackEnd {
    suspend fun getPublications(): List<PublicationDTO>
}