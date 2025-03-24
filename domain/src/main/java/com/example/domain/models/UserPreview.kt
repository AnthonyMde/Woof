package com.example.domain.models

data class UserPreview(
    val userId: String,
    val name: String,
    val pictureUri: String,
    val address: Address
) {
    data class Address(
        val country: String,
        val city: String
    )
}