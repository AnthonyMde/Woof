package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.data.request.CreatePublicationRequest
import com.example.domain.constant.User
import com.example.domain.error.DomainException
import com.example.domain.helper.Clock
import com.example.domain.models.Comment
import com.example.domain.models.PostCommentModel
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
            likes = emptyList(),
            comments = emptyList(),
            petTalk = request.petTalk,
            color = request.petColor
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

    override suspend fun postPublicationComment(postCommentModel: PostCommentModel): List<PublicationDTO> {
        delay(QUICK_FAKED_NETWORK_CALL_TIME_MS)

        val userProfile =
            getUserProfileById(postCommentModel.userId) ?: throw DomainException.NoProfileFoundError
        val comment = Comment(
            userInfo = Comment.UserInfo(
                id = userProfile.id,
                name = userProfile.name,
                pictureUriString = userProfile.picture
            ),
            text = postCommentModel.commentText,
            timestamp = clock.nowMillis()
        )

        mockedPublications = mockedPublications.map { publication ->
            if (publication.id != postCommentModel.publicationId) return@map publication

            val updatedComments = publication.comments.toMutableList()
                .apply { add(comment) }

            publication.copy(comments = updatedComments)
        }

        return mockedPublications
    }

    // Note: here the imageUriString + userId (infos) params is just to fake that we are analysing
    // the content of the image by AI to generate a accurate pet talk.
    override suspend fun generatePetTalkWithAI(userId: String, imageUriString: String): String {
        delay(QUICK_FAKED_NETWORK_CALL_TIME_MS)

        return mockedPetTalks.random()
    }

    private fun getMockedPublicationDTOs(): List<PublicationDTO> {
        return mockedPublications
    }

    companion object {
        private const val FAKED_NETWORK_CALL_TIME_MS = 2000L
        private const val QUICK_FAKED_NETWORK_CALL_TIME_MS = 1000L
    }
}