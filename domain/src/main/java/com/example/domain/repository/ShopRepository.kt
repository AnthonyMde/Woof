package com.example.domain.repository

import com.example.domain.models.shop.ShopProduct

interface ShopRepository {
    suspend fun getShopProducts(): List<ShopProduct>
}