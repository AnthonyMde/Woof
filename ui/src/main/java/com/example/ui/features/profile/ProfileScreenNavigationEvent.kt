package com.example.ui.features.profile

sealed class ProfileScreenNavigationEvent {
    data object GoBack : ProfileScreenNavigationEvent()
}
