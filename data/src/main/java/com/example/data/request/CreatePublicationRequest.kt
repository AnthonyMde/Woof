package com.example.data.request

import com.example.domain.models.publication.Publication

internal data class CreatePublicationRequest(
    val userId: String,
    val imageUriString: String,
    val petTalk: String?,
    val petColor: Publication.Color
)
