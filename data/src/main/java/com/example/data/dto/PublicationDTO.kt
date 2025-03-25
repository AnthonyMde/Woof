package com.example.data.dto

import com.example.domain.models.comment.Comment
import com.example.domain.models.publication.Publication
import com.example.domain.models.user.UserPreview

// Simulates DTO from back-end.
internal data class PublicationDTO(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>,
    val comments: List<Comment>,
    val petTalk: String?,
    val color: Publication.Color
) {
    fun toPublication() =
        Publication(
            id = id,
            userPreview = userPreview,
            imageUriString = imageUriString,
            timestamp = timestamp,
            likes = likes,
            comments = comments,
            petTalk = petTalk,
            color = color
        )
}