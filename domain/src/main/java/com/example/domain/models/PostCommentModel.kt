package com.example.domain.models

data class PostCommentModel(
    val publicationId: String,
    val userId: String,
    val commentText: String
)
