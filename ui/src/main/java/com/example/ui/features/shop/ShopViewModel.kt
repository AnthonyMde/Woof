package com.example.ui.features.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Resource
import com.example.domain.models.shop.ShopProduct
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
    private var loadedProducts: List<ShopProduct> = emptyList()

    fun onAction(action: ShopScreenAction) {
        when (action) {
            is ShopScreenAction.OnSearchInputChanged -> onSearch(action.search)
            else -> {}
        }
    }

    private fun onSearch(search: String) {
        val query = search.trim().lowercase()

        val filteredProducts = if (query.isBlank()) {
            loadedProducts
        } else {
            loadedProducts.filter {
                it.name.contains(search, ignoreCase = true) ||
                        it.brand.contains(search, ignoreCase = true)
            }
        }
        _state.update {
            it.copy(
                searchInputValue = search,
                products = filteredProducts
            )
        }
    }

    private fun loadProducts() = viewModelScope.launch {
        getShopProductsUseCase().collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            productsError = R.string.shop_cannot_load_products_error,
                            isProductsLoading = false
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            productsError = null,
                            isProductsLoading = true
                        )
                    }
                }

                is Resource.Success -> {
                    val products = result.data ?: emptyList()

                    loadedProducts = products
                    _state.update {
                        it.copy(
                            productsError = null,
                            isProductsLoading = false,
                            products = products
                        )
                    }
                }
            }
        }
    }
}
