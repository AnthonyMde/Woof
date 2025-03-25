package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.domain.models.UserAddress
import com.example.domain.models.UserPreview
import java.util.UUID

internal var mockedPublications = listOf(
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "2",
            name = "Bobby",
            pictureUri = "",
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
        )
    ),
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "3",
            name = "King",
            pictureUri = "",
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
        )
    ),
    PublicationDTO(
        id = UUID.randomUUID().toString(),
        userPreview = UserPreview(
            userId = "4",
            name = "Doudou",
            pictureUri = "",
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
        )
    )
)
