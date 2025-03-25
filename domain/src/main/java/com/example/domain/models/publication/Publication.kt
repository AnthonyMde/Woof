package com.example.domain.models.publication

import com.example.domain.models.comment.Comment
import com.example.domain.models.user.UserPreview

data class Publication(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long,
    val likes: List<String>,
    val comments: List<Comment>,
    val petTalk: String?,
    val color: Color
) {
    enum class Color {
        PRIMARY,
        SECONDARY,
        TERTIARY
    }
}