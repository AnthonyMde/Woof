package com.example.domain.di
import com.example.domain.helper.Clock
import com.example.domain.helper.SystemClock
import com.example.domain.usecase.publication.GetPublicationCommentsUseCase
import com.example.domain.usecase.publication.GetPublicationsUseCase
import com.example.domain.usecase.user.GetUserProfileUseCase
import com.example.domain.usecase.user.GetUserSessionUseCase
import com.example.domain.usecase.publication.PostPublicationCommentUseCase
import com.example.domain.usecase.publication.PostPublicationUseCase
import com.example.domain.usecase.publication.TogglePublicationLikeUseCase
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