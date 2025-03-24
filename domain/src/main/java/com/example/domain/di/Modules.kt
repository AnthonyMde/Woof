package com.example.domain.di
import com.example.domain.usecase.GetPublicationsUseCase
import org.koin.dsl.module

val domainModules = module {
    single { GetPublicationsUseCase(get()) }
}