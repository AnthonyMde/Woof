package com.example.domain.models

data class PostPublicationModel(
    val userId: String,
    val imageUriString: String,
    val petTalk: String?,
    val color: Publication.Color
)