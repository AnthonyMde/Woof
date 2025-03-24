package com.example.ui.features.home

sealed interface HomeScreenAction {
    data object OnMyProfileClicked : HomeScreenAction
}
