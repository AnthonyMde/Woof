package com.example.data.source.remote.mock

import com.example.domain.models.shop.ShopProduct

internal val mockedShopProducts = listOf(
    ShopProduct(
        id = "1",
        name = "Cozy Dog Bed",
        brand = "PupNest",
        price = 3999,
        imageUriString = "android.resource://com.example.woof/drawable/dog_carpet"
    ),
    ShopProduct(
        id = "2",
        name = "Gourmet Treat Pack",
        brand = "Treatify",
        price = 1499,
        imageUriString = "android.resource://com.example.woof/drawable/kibbles"
    ),
    ShopProduct(
        id = "3",
        name = "Cat Kibbles",
        brand = "BiteFun",
        price = 899,
        imageUriString = "android.resource://com.example.woof/drawable/cat_kibbles"
    ),
    ShopProduct(
        id = "4",
        name = "Stylish Dog Collar",
        brand = "WoofWear",
        price = 1299,
        imageUriString = "android.resource://com.example.woof/drawable/dog_toy"
    ),
    ShopProduct(
        id = "5",
        name = "Cat Tree 2",
        brand = "SqueakTime",
        price = 599,
        imageUriString = "android.resource://com.example.woof/drawable/cat_tree"
    ),
    ShopProduct(
        id = "6",
        name = "Rainproof Cat Toy",
        brand = "PawShield",
        price = 2499,
        imageUriString = "android.resource://com.example.woof/drawable/cat_toy"
    )
)