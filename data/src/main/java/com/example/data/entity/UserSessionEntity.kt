package com.example.data.entity

import com.example.domain.models.UserSession

// Entity is equal to UserSession
// Only for showcase purpose of clean data models separation.
internal data class UserSessionEntity(
    val id: String,
    val name: String,
    val pictureUriString: String
) {
    fun toUserSession() = UserSession(
        id = id,
        name = name,
        pictureUriString = pictureUriString
    )
}
