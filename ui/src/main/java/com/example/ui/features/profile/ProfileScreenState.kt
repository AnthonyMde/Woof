package com.example.ui.features.profile

import com.example.domain.models.UserProfile

sealed class ProfileScreenState{
    data object Loading : ProfileScreenState()
    data object Error : ProfileScreenState()
    data class Success(val data: UserProfile) : ProfileScreenState()
}
