package com.example.data.di

import com.example.data.repository.PublicationsRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.local.FakeLocalDatabaseImpl
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.data.source.remote.FakeRemoteBackEndImpl
import com.example.domain.repository.PublicationsRepository
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val dataModules = module {
    // REPOSITORY
    single<PublicationsRepository> { PublicationsRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }

    // SOURCES
    single<FakeRemoteBackEnd> { FakeRemoteBackEndImpl(get()) }
    single<FakeLocalDatabase> { FakeLocalDatabaseImpl() }
}