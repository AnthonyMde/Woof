package com.example.domain.models.user

data class UserPreview(
    val userId: String,
    val name: String,
    val pictureUri: String,
    val address: UserAddress
)