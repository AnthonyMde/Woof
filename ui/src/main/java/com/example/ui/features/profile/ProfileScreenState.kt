package com.example.ui.features.profile

import androidx.annotation.StringRes
import com.example.domain.models.user.UserProfile

sealed interface ProfileScreenState {
    data class Success(val profile: UserProfile): ProfileScreenState
    data object Loading : ProfileScreenState
    data class Error(@StringRes val error: Int) : ProfileScreenState
}
