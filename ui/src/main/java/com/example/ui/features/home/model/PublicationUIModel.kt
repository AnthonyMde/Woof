package com.example.ui.features.home.model

import com.example.domain.models.Publication
import com.example.domain.models.UserPreview

data class PublicationUIModel(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>,
    val isLiked: Boolean
) {
    companion object {
        fun from(publication: Publication, isLiked: Boolean) = PublicationUIModel(
            id = publication.id,
            userPreview = publication.userPreview,
            imageUriString = publication.imageUriString,
            timestamp = publication.timestamp,
            likes = publication.likes,
            isLiked = isLiked
        )
    }
}
