package com.example.ui.features.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.error.DomainException
import com.example.domain.models.Resource
import com.example.domain.usecase.user.GetUserProfileUseCase
import com.example.ui.R
import com.example.ui.navigation.Route
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)
    val state = _state.asStateFlow().onStart {
        loadProfile(userId)
    }

    private val _navigationEvent = MutableSharedFlow<ProfileScreenNavigationEvent>(
        extraBufferCapacity = 1,
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val navigationEvent = _navigationEvent.asSharedFlow()

    private val userId: String

    init {
        savedStateHandle.toRoute<Route.Profile>().let {
            userId = it.userId
        }
    }

    private fun loadProfile(userId: String) = viewModelScope.launch {
        getUserProfileUseCase(userId).let { result ->
            when (result) {
                is Resource.Error -> {
                    if (result.throwable is DomainException.NoProfileFoundError) {
                        _navigationEvent.tryEmit(ProfileScreenNavigationEvent.GoBack)
                    } else {
                        _state.update { ProfileScreenState.Error(R.string.profile_unknown_error) }
                    }
                }

                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    result.data?.let { profile ->
                        _state.update { ProfileScreenState.Success(profile) }
                    }
                }
            }
        }
    }
}