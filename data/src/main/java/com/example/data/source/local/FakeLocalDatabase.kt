package com.example.data.source.local

import com.example.data.entity.PublicationEntity

interface FakeLocalDatabase {
    suspend fun getPublications(): List<PublicationEntity>
}