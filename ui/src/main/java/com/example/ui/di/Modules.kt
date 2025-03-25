package com.example.ui.di

import com.example.ui.features.camera.CameraViewModel
import com.example.ui.features.comments.CommentsViewModel
import com.example.ui.features.home.HomeViewModel
import com.example.ui.features.profile.ProfileViewModel
import com.example.ui.helper.FileHelper
import com.example.ui.helper.PermissionsHelper
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModules = module {
    // VIEWMODEL
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { CameraViewModel(get(), get(), get(), get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { CommentsViewModel(get(), get(), get()) }

    // HELPER
    single { PermissionsHelper(get()) }
    single { FileHelper(get()) }
}