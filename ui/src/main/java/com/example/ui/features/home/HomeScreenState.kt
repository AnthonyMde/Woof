package com.example.ui.features.home

import androidx.annotation.StringRes
import com.example.domain.models.UserSession
import com.example.ui.features.home.model.PublicationUIModel

data class HomeScreenState(
    val publications: List<PublicationUIModel> = emptyList(),
    val isPublicationsLoading: Boolean = false,
    @StringRes val publicationError: Int? = null,
    val userSession: UserSession? = null,
    val isLikeLoading: Boolean = false,
)