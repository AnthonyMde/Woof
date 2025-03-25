package com.example.data.repository

import com.example.data.source.remote.FakeRemoteBackEnd
import com.example.domain.models.shop.ShopProduct
import com.example.domain.repository.ShopRepository

internal class ShopRepositoryImpl(
    private val fakeRemoteBackEnd: FakeRemoteBackEnd
) : ShopRepository {
    override suspend fun getShopProducts(): List<ShopProduct> {
        return fakeRemoteBackEnd.getShopProducts()
    }
}