package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.data.request.CreatePublicationRequest
import com.example.domain.constant.User
import com.example.domain.helper.Clock
import com.example.domain.models.UserAddress
import com.example.domain.models.UserPreview
import kotlinx.coroutines.delay
import java.util.UUID

internal class FakeRemoteBackEndImpl(
    private val clock: Clock
) : FakeRemoteBackEnd {
    override suspend fun getPublications(): List<PublicationDTO> {
        return getMockedPublicationDTOs()
    }

    override suspend fun createPublication(request: CreatePublicationRequest): PublicationDTO {
        delay(FAKED_NETWORK_CALL_TIME_MS)

        val now = clock.nowMillis()
        val publicationDTO = PublicationDTO(
            id = UUID.randomUUID().toString(),
            userPreview = UserPreview(
                userId = User.USER_ID,
                name = User.USERNAME,
                pictureUri = User.PICTURE,
                address = UserAddress(
                    city = "Toulouse",
                    country = "France"
                )
            ),
            imageUriString = request.imageUriString,
            timestamp = now
        )

        return publicationDTO
    }

    private fun getMockedPublicationDTOs(): List<PublicationDTO> {
        return listOf(
            PublicationDTO(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "Bobby",
                    pictureUri = "",
                    address = UserAddress(
                        city = "Paris",
                        country = "France"
                    )
                ),
                imageUriString = "android.resource://com.example.woof/drawable/corgi",
                timestamp = 1732567800000
            ),
            PublicationDTO(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "King",
                    pictureUri = "",
                    address = UserAddress(
                        city = "Bruxelles",
                        country = "Belgique"
                    )
                ),
                imageUriString = "android.resource://com.example.woof/drawable/cavalier_king",
                timestamp = 1732777800000
            ),
            PublicationDTO(
                id = UUID.randomUUID().toString(),
                userPreview = UserPreview(
                    userId = UUID.randomUUID().toString(),
                    name = "Doudou",
                    pictureUri = "",
                    address = UserAddress(
                        city = "Bordeaux",
                        country = "France"
                    )
                ),
                imageUriString = "android.resource://com.example.woof/drawable/doudou",
                timestamp = 1730067800000
            )
        )
    }

    companion object {
        private const val FAKED_NETWORK_CALL_TIME_MS = 2000L
    }
}