package com.example.domain.models.shop

data class ShopProduct(
    val id: String,
    val name: String,
    val brand: String,
    val price: Long,
    val imageUriString: String
)