package com.example.domain.models

data class Publication(
    val id: String,
    val userPreview: UserPreview,
    val imageUriString: String,
    val timestamp: Long
)