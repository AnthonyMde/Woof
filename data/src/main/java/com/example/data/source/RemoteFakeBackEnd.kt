package com.example.data.source

import com.example.domain.models.Publication
import com.example.domain.models.UserPreview
import kotlinx.coroutines.delay
import java.util.UUID

class RemoteFakeBackEnd {
    suspend fun getPublications(): List<Publication> {
        delay(2000) // Fake request time.
        return getMockedPublications()
    }

    private fun getMockedPublications(): List<Publication> {
        return listOf(
            Publication(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "Bobby",
                    pictureUri = ""
                ),
                imageUriString = "android.resource://com.example.woof/drawable/corgi",
                timestamp = 1732567800000
            ),
            Publication(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "King",
                    pictureUri = ""
                ),
                imageUriString = "android.resource://com.example.woof/drawable/cavalier_king",
                timestamp = 1732777800000
            ),
            Publication(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "Doudou",
                    pictureUri = ""
                ),
                imageUriString = "android.resource://com.example.woof/drawable/doudou",
                timestamp = 1730067800000
            )
        )
    }
}