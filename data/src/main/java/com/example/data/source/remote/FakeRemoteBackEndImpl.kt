package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.data.request.CreatePublicationRequest
import com.example.domain.constant.User
import com.example.domain.helper.Clock
import com.example.domain.models.UserAddress
import com.example.domain.models.UserPreview
import com.example.domain.models.UserProfile
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
                    city = User.CITY,
                    country = User.COUNTRY
                )
            ),
            imageUriString = request.imageUriString,
            timestamp = now,
            likes = emptyList()
        )

        mockedPublications = mockedPublications.toMutableList().apply {
            add(publicationDTO)
        }

        return publicationDTO
    }

    override suspend fun getUserProfileById(id: String): UserProfile? {
        return mockedProfiles.find { it.id == id }
    }

    override suspend fun togglePublicationLike(
        likerId: String,
        publicationId: String
    ): List<PublicationDTO> {
        mockedPublications = mockedPublications.map { publication ->
            if (publication.id != publicationId) return@map publication

            val updatedLikes = publication.likes.toMutableList().apply {
                if (contains(likerId)) remove(likerId) else add(likerId)
            }

            publication.copy(likes = updatedLikes)
        }
        return mockedPublications
    }

    private fun getMockedPublicationDTOs(): List<PublicationDTO> {
        return mockedPublications
    }

    companion object {
        private const val FAKED_NETWORK_CALL_TIME_MS = 2000L
    }
}