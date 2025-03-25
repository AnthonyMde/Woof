package com.example.domain.models.shop

import java.text.NumberFormat
import java.util.Locale

data class ShopProduct(
    val id: String,
    val name: String,
    val brand: String,
    val price: Long,
    val imageUriString: String,
    val affiliatedLink: String
) {
    fun priceToEuros(): String {
        val euros = price / 100.0
        val formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE)
        return formatter.format(euros)
    }
}
