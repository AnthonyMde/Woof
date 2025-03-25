package com.example.data.repository

import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.UserProfile
import com.example.domain.models.UserSession
import com.example.domain.repository.UserRepository

internal class UserRepositoryImpl(
    private val fakeLocalDatabase: FakeLocalDatabase,
    private val fakeRemoteBackEnd: FakeRemoteBackEnd
): UserRepository {
    override suspend fun getUserSession(): UserSession {
        return fakeLocalDatabase.getUserSession().toUserSession()
    }

    override suspend fun getUserProfile(userId: String): UserProfile? {
        return fakeRemoteBackEnd.getUserProfileById(userId)
    }
}
