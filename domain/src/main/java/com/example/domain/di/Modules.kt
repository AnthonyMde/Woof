package com.example.domain.di
import com.example.domain.helper.Clock
import com.example.domain.helper.SystemClock
import com.example.domain.usecase.GetPublicationCommentsUseCase
import com.example.domain.usecase.GetPublicationsUseCase
import com.example.domain.usecase.GetUserProfileUseCase
import com.example.domain.usecase.GetUserSessionUseCase
import com.example.domain.usecase.PostPublicationCommentUseCase
import com.example.domain.usecase.PostPublicationUseCase
import com.example.domain.usecase.TogglePublicationLikeUseCase
import org.koin.dsl.module

val domainModules = module {
    // USE CASES
    single { GetUserSessionUseCase(get()) }
    single { GetPublicationsUseCase(get()) }
    single { PostPublicationUseCase(get()) }
    single { GetUserProfileUseCase(get()) }
    single { TogglePublicationLikeUseCase(get()) }
    single { GetPublicationCommentsUseCase(get()) }
    single { PostPublicationCommentUseCase(get(), get()) }

    // HELPERS
    single<Clock> { SystemClock() }
}