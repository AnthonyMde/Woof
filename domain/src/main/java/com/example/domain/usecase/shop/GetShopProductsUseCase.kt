package com.example.domain.usecase.shop

import com.example.domain.models.Resource
import com.example.domain.models.shop.ShopProduct
import com.example.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetShopProductsUseCase(
    private val shopRepository: ShopRepository
) {
    operator fun invoke(): Flow<Resource<List<ShopProduct>>> = flow {
        emit(Resource.Loading())

        try {
            val products = shopRepository.getShopProducts()
            emit(Resource.Success(products))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}