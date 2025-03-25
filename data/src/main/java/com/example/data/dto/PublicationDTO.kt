package com.example.data.dto

import com.example.domain.models.Comment
import com.example.domain.models.Publication
import com.example.domain.models.UserPreview

// Simulates DTO from back-end.
internal data class PublicationDTO(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>,
    val comments: List<Comment>,
    val petTalk: String?
) {
    fun toPublication() =
        Publication(
            id = id,
            userPreview = userPreview,
            imageUriString = imageUriString,
            timestamp = timestamp,
            likes = likes,
            comments = comments,
            petTalk = petTalk
        )
}