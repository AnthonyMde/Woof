package com.example.data.repository

import com.example.data.source.local.FakeLocalDatabase
import com.example.domain.models.UserSession
import com.example.domain.repository.UserRepository

internal class UserRepositoryImpl(
    private val fakeLocalDatabase: FakeLocalDatabase
): UserRepository {
    override suspend fun getUserSession(): UserSession {
        return fakeLocalDatabase.getUserSession().toUserSession()
    }
}
