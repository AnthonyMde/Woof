package com.example.ui.features.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Resource
import com.example.domain.usecase.shop.GetShopProductsUseCase
import com.example.ui.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShopViewModel(
    private val getShopProductsUseCase: GetShopProductsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ShopScreenState())
    val state = _state.asStateFlow().onStart {
        loadProducts()
    }

    fun onAction(action: ShopScreenAction) {
        when (action) {
            is ShopScreenAction.OnSearchInputChanged -> {
                // TODO
            }
            else -> {}
        }
    }

    private fun loadProducts() = viewModelScope.launch {
        getShopProductsUseCase().collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update { it.copy(
                        productsError = R.string.shop_cannot_load_products_error,
                        isProductsLoading = false
                    ) }
                }
                is Resource.Loading -> {
                    _state.update { it.copy(
                        productsError = null,
                        isProductsLoading = true
                    ) }
                }
                is Resource.Success -> {
                    _state.update { it.copy(
                        productsError = null,
                        isProductsLoading = false,
                        products = result.data ?: emptyList()
                    ) }
                }
            }
        }
    }
}
