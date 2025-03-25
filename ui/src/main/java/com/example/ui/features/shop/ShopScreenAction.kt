package com.example.ui.features.shop

sealed interface ShopScreenAction {
    data class OnProductClicked(val productUri: String) : ShopScreenAction
    data class OnSearchInputChanged(val search: String) : ShopScreenAction
}
