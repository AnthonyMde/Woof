package com.example.data.entity

import com.example.domain.models.Publication
import com.example.domain.models.UserPreview

// Simulates entity for Room for example
internal data class PublicationEntity(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>
) {
    fun toPublication() = Publication(
        id = id,
        userPreview = userPreview,
        imageUriString = imageUriString,
        timestamp = timestamp,
        likes = likes
    )

    companion object {
        fun from(publication: Publication) = PublicationEntity(
            id = publication.id,
            userPreview = publication.userPreview,
            imageUriString = publication.imageUriString,
            timestamp = publication.timestamp,
            likes = publication.likes
        )
    }
}