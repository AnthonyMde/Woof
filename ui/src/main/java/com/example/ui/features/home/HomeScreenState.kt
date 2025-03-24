package com.example.ui.features.home

import androidx.annotation.StringRes
import com.example.domain.models.Publication
import com.example.domain.models.UserSession

data class HomeScreenState(
    val publications: List<Publication> = emptyList(),
    val isPublicationsLoading: Boolean = false,
    @StringRes val publicationError: Int? = null,
    val userSession: UserSession? = null
)