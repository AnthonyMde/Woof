package com.example.domain.models.comment

data class PostCommentModel(
    val publicationId: String,
    val userId: String,
    val commentText: String
)
