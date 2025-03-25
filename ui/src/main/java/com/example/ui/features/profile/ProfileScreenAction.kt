package com.example.ui.features.profile

sealed interface ProfileScreenAction {
    data object OnNavigateUpClicked : ProfileScreenAction
}
