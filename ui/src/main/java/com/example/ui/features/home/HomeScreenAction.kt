package com.example.ui.features.home

sealed interface HomeScreenAction {
    data object OnMyProfileClicked : HomeScreenAction
    data class OnPublicationHeaderClicked(val userId: String) : HomeScreenAction
    data class OnPublicationLikeClicked(val publicationId: String): HomeScreenAction
}
