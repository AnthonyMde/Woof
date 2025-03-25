package com.example.domain.models.publication

data class PostPublicationModel(
    val userId: String,
    val imageUriString: String,
    val petTalk: String?,
    val color: Publication.Color
)