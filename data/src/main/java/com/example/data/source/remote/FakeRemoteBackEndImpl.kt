package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.domain.models.UserPreview
import kotlinx.coroutines.delay
import java.util.UUID

class FakeRemoteBackEndImpl : FakeRemoteBackEnd {
    override suspend fun getPublications(): List<PublicationDTO> {
        delay(2000) // Fake request time.
        return getMockedPublicationDTOs()
    }

    private fun getMockedPublicationDTOs(): List<PublicationDTO> {
        return listOf(
            PublicationDTO(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "Bobby",
                    pictureUri = ""
                ),
                imageUriString = "android.resource://com.example.woof/drawable/corgi",
                timestamp = 1732567800000
            ),
            PublicationDTO(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "King",
                    pictureUri = ""
                ),
                imageUriString = "android.resource://com.example.woof/drawable/cavalier_king",
                timestamp = 1732777800000
            ),
            PublicationDTO(
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