package com.example.domain.models

data class UserProfile(
    val id: String,
    val name: String,
    val picture: String,
    val address: UserAddress,
    val age: Int,
    val bio: String,
    val socialMetrics: SocialMetrics,
    val publicationImages: List<String>
) {
    data class SocialMetrics(
        val postCount: Int,
        val followerCount: Int,
        val followingCount: Int
    )
}
