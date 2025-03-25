package com.example.data.source.remote

import com.example.domain.constant.User
import com.example.domain.models.UserAddress
import com.example.domain.models.UserProfile

internal val mockedProfiles = listOf(
    UserProfile(
        id = User.USER_ID,
        name = User.USERNAME,
        picture = User.PICTURE,
        address = UserAddress(
            city = User.CITY,
            country = User.COUNTRY
        ),
        age = 8,
        bio = "I might be tiny, but my coding is fastest than lightning ⚡\uD83D\uDC3E!",
        socialMetrics = UserProfile.SocialMetrics(
            postCount = 42,
            followerCount = 777,
            followingCount = 404
        ),
        publicationImages = listOf(
            "android.resource://com.example.woof/drawable/corgi",
            "android.resource://com.example.woof/drawable/doudou",
            "android.resource://com.example.woof/drawable/cavalier_king",
            "android.resource://com.example.woof/drawable/corgi",
            "android.resource://com.example.woof/drawable/doudou",
            "android.resource://com.example.woof/drawable/cavalier_king",
            "android.resource://com.example.woof/drawable/corgi",
            "android.resource://com.example.woof/drawable/doudou",
            "android.resource://com.example.woof/drawable/cavalier_king",
            "android.resource://com.example.woof/drawable/corgi",
            "android.resource://com.example.woof/drawable/doudou",
            "android.resource://com.example.woof/drawable/cavalier_king",
        )
    ),
    UserProfile(
        id = "2",
        name = "Bobby",
        picture = "android.resource://com.example.woof/drawable/berger_australien",
        address = UserAddress(
            city = "Paris",
            country = "France"
        ),
        age = 5,
        bio = "I may be small, but I’ve got the biggest heart and the fluffiest tail! \uD83D\uDC36",
        socialMetrics = UserProfile.SocialMetrics(
            postCount = 12,
            followerCount = 158,
            followingCount = 87
        ),
        publicationImages = listOf("android.resource://com.example.woof/drawable/corgi")
    ),
    UserProfile(
        id = "3",
        name = "King",
        picture = "android.resource://com.example.woof/drawable/cat",
        address = UserAddress(
            city = "Bruxelles",
            country = "Belgique"
        ),
        age = 8,
        bio = "I love belly rubs, long naps in the sun ☀\uFE0F, and stealing socks when you're not looking. \uD83D\uDE48",
        socialMetrics = UserProfile.SocialMetrics(
            postCount = 27,
            followerCount = 321,
            followingCount = 145
        ),
        publicationImages = listOf("android.resource://com.example.woof/drawable/cavalier_king")
    ),
    UserProfile(
        id = "4",
        name = "Doudou",
        picture = "android.resource://com.example.woof/drawable/doudou2",
        address = UserAddress(
            city = "Bordeaux",
            country = "France"
        ),
        age = 2,
        bio = "I’m basically a professional cuddler \uD83D\uDECF\uFE0F with a PhD in snack detection \uD83C\uDF6A\uD83C\uDF93.",
        socialMetrics = UserProfile.SocialMetrics(
            postCount = 8,
            followerCount = 73,
            followingCount = 64
        ),
        publicationImages = listOf("android.resource://com.example.woof/drawable/doudou")
    )
)
