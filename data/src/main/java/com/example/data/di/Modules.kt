package com.example.data.di

import com.example.data.PublicationsRepositoryImpl
import com.example.data.source.local.FakeLocalDatabase
import com.example.data.source.local.FakeLocalDatabaseImpl
import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.data.source.remote.FakeRemoteBackEndImpl
import com.example.domain.repository.PublicationsRepository
import org.koin.dsl.module

val dataModules = module {
    // REPOSITORY
    single<PublicationsRepository> { PublicationsRepositoryImpl(get(), get()) }

    // SOURCES
    single<FakeRemoteBackEnd> { FakeRemoteBackEndImpl() }
    single<FakeLocalDatabase> { FakeLocalDatabaseImpl() }
}