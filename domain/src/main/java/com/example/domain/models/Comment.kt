package com.example.domain.models

data class Comment(
    val userInfo: UserInfo,
    val text: String,
    val timestamp: Long
) {
    data class UserInfo(
        val id: String,
        val name: String,
        val pictureUriString: String
    )
}
