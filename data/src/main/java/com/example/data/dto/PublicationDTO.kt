package com.example.data.dto

import com.example.domain.models.Publication
import com.example.domain.models.UserPreview

// Simulates DTO from back-end.
internal data class PublicationDTO(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long
) {
    fun toPublication() =
        Publication(
            id = id,
            userPreview = userPreview,
            imageUriString = imageUriString,
            timestamp = timestamp
        )
}