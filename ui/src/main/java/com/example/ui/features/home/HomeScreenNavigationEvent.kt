package com.example.ui.features.home

sealed interface HomeScreenNavigationEvent {
    data class GoToUserDetails(val userId: String) : HomeScreenNavigationEvent
}