package com.example.ui.di

import com.example.ui.features.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModules = module {
    viewModel { HomeViewModel(get(), get()) }
}