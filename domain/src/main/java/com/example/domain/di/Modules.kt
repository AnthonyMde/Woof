package com.example.domain.di
import com.example.domain.helper.Clock
import com.example.domain.helper.SystemClock
import com.example.domain.usecase.GetUserProfileUseCase
import com.example.domain.usecase.GetPublicationsUseCase
import com.example.domain.usecase.GetUserSessionUseCase
import com.example.domain.usecase.PostPublicationUseCase
import org.koin.dsl.module

val domainModules = module {
    // USE CASES
    single { GetUserSessionUseCase(get()) }
    single { GetPublicationsUseCase(get()) }
    single { PostPublicationUseCase(get()) }
    single { GetUserProfileUseCase(get()) }

    // HELPERS
    single<Clock> { SystemClock() }
}