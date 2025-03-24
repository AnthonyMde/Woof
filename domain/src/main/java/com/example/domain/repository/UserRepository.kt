package com.example.domain.repository

import com.example.domain.models.UserSession

interface UserRepository {
    suspend fun getUserSession(): UserSession
}
