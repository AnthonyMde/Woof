package com.example.data.source.remote

import com.example.data.dto.PublicationDTO
import com.example.data.request.CreatePublicationRequest
import com.example.domain.models.comment.PostCommentModel
import com.example.domain.models.shop.ShopProduct
import com.example.domain.models.user.UserProfile

internal interface FakeRemoteBackEnd {
    suspend fun getPublications(): List<PublicationDTO>
    suspend fun createPublication(request: CreatePublicationRequest): PublicationDTO
    suspend fun getUserProfileById(id: String): UserProfile?
    suspend fun togglePublicationLike(likerId: String, publicationId: String): List<PublicationDTO>
    suspend fun postPublicationComment(postCommentModel: PostCommentModel): List<PublicationDTO>
    suspend fun generatePetTalkWithAI(userId: String, imageUriString: String): String
    suspend fun getShopProducts(): List<ShopProduct>
}