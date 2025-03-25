package com.example.ui.features.home.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.domain.models.comment.Comment
import com.example.domain.models.publication.Publication
import com.example.domain.models.user.UserPreview

data class PublicationUIModel(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>,
    val comments: List<Comment>,
    val petTalk: String?,
    val color: Publication.Color,
    val isLiked: Boolean,
) {
    companion object {
        fun from(publication: Publication, isLiked: Boolean) = PublicationUIModel(
            id = publication.id,
            userPreview = publication.userPreview,
            imageUriString = publication.imageUriString,
            timestamp = publication.timestamp,
            likes = publication.likes,
            comments = publication.comments,
            petTalk = publication.petTalk,
            color = publication.color,
            isLiked = isLiked
        )

        @Composable
        fun getMaterialColorFrom(color: Publication.Color): Color {
            return when (color) {
                Publication.Color.PRIMARY -> MaterialTheme.colorScheme.primary
                Publication.Color.SECONDARY -> MaterialTheme.colorScheme.secondary
                Publication.Color.TERTIARY -> MaterialTheme.colorScheme.tertiary
            }
        }
    }
}
