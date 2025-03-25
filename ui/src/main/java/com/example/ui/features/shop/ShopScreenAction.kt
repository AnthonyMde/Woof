package com.example.ui.features.shop

sealed interface ShopScreenAction {
    data object OnProductClicked : ShopScreenAction
    data class OnSearchInputChanged(val search: String) : ShopScreenAction
}
