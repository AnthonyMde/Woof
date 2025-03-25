package com.example.ui.features.shop

import androidx.annotation.StringRes
import com.example.domain.models.shop.ShopProduct

data class ShopScreenState(
    val products: List<ShopProduct> = emptyList(),
    val isProductsLoading: Boolean = false,
    @StringRes val productsError: Int? = null,
    val searchInputValue: String = ""
)
