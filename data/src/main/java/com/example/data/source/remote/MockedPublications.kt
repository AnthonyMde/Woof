package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.domain.constant.User
import com.example.domain.models.Comment
import com.example.domain.models.Publication
import com.example.domain.models.UserAddress
import com.example.domain.models.UserPreview
import java.util.UUID

internal var mockedPublications = listOf(
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "2",
            name = "Bobby",
            pictureUri = "android.resource://com.example.woof/drawable/berger_australien",
            address = UserAddress(
                city = "Paris",
                country = "France"
            )
        ),
        imageUriString = "android.resource://com.example.woof/drawable/corgi",
        timestamp = 1732567800000,
        likes = listOf(
            "1", "7", "12", "23", "31",
            "42", "56", "63", "74", "81",
            "92", "103", "114", "125", "136",
            "147", "158", "169", "180", "191",
            "202", "213", "224", "235", "246"
        ),
        comments = emptyList(),
        petTalk = null,
        color = Publication.Color.TERTIARY
    ),
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "3",
            name = "King",
            pictureUri = "android.resource://com.example.woof/drawable/cat",
            address = UserAddress(
                city = "Bruxelles",
                country = "Belgique"
            )
        ),
        imageUriString = "android.resource://com.example.woof/drawable/cavalier_king",
        timestamp = 1732777800000,
        likes = listOf(
            "3", "7", "12", "23", "31",
            "42", "56", "63", "74", "81",
            "92", "103", "114", "125", "136",
            "147", "158", "169", "180", "191",
            "202", "213", "224", "235", "246"
        ),
        comments = listOf(
            Comment(
                userInfo = Comment.UserInfo(
                    id = "4",
                    name = "Doudou",
                    pictureUriString = "android.resource://com.example.woof/drawable/doudou"
                ),
                text = "That smile made my day! 😄",
                timestamp = 1732590000000
            ),
        ),
        petTalk = null,
        color = Publication.Color.SECONDARY
    ),
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "4",
            name = "Doudou",
            pictureUri = "android.resource://com.example.woof/drawable/doudou2",
            address = UserAddress(
                city = "Bordeaux",
                country = "France"
            )
        ),
        imageUriString = "android.resource://com.example.woof/drawable/doudou",
        timestamp = 1730067800000,
        likes = listOf(
            "1", "7", "12", "23", "31",
            "42", "56", "63", "74", "81",
            "92", "103", "114", "125", "136",
            "147", "158", "169", "180", "191",
            "202", "213", "224", "235", "246"
        ),
        comments = listOf(
            Comment(
                userInfo = Comment.UserInfo(
                    id = User.USER_ID,
                    name = User.USERNAME,
                    pictureUriString = "android.resource://com.example.woof/drawable/cavalier_king"
                ),
                text = "Such a cute pup! 🐶💕",
                timestamp = 1732580000000
            ),
            Comment(
                userInfo = Comment.UserInfo(
                    id = "4",
                    name = "Doudou",
                    pictureUriString = "android.resource://com.example.woof/drawable/doudou"
                ),
                text = "That smile made my day! 😄",
                timestamp = 1732590000000
            ),
            Comment(
                userInfo = Comment.UserInfo(
                    id = "3",
                    name = "King",
                    pictureUriString = "android.resource://com.example.woof/drawable/corgi"
                ),
                text = "Where was this taken? The background is beautiful! 🌅",
                timestamp = 1732600000000
            )
        ),
        petTalk = null,
        color = Publication.Color.PRIMARY
    )
)
