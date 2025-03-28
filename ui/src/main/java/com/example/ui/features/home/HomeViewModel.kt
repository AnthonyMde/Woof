package com.example.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.publication.Publication
import com.example.domain.models.Resource
import com.example.domain.usecase.publication.GetPublicationsUseCase
import com.example.domain.usecase.user.GetUserSessionUseCase
import com.example.domain.usecase.publication.TogglePublicationLikeUseCase
import com.example.ui.R
import com.example.ui.features.home.model.PublicationUIModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPublicationsUseCase: GetPublicationsUseCase,
    private val getUserSessionUseCase: GetUserSessionUseCase,
    private val togglePublicationLikeUseCase: TogglePublicationLikeUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow().onStart {
        viewModelScope.launch { loadUserSession() }
        viewModelScope.launch { loadPublications() }
    }
    private val _navigationEvent = MutableSharedFlow<HomeScreenNavigationEvent>(
        extraBufferCapacity = 1,
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val navigationEvent = _navigationEvent.asSharedFlow()


    fun onAction(action: HomeScreenAction) {
        when (action) {
            HomeScreenAction.OnMyProfileClicked -> onMyProfileClicked()
            is HomeScreenAction.OnPublicationHeaderClicked -> onPublicationHeaderClicked(action.userId)
            is HomeScreenAction.OnPublicationLikeClicked -> togglePublicationLike(action.publicationId)
            else -> {}
        }
    }

    private fun togglePublicationLike(publicationId: String) = viewModelScope.launch {
        togglePublicationLikeUseCase(publicationId).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update { it.copy(isLikeLoading = false) }
                }

                is Resource.Loading -> {
                    _state.update { it.copy(isLikeLoading = true) }
                }

                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isLikeLoading = true,
                            publications = result.data.toPublicationUIModels()
                        )
                    }
                }
            }
        }
    }

    private fun onPublicationHeaderClicked(userId: String) {
        _navigationEvent.tryEmit(HomeScreenNavigationEvent.GoToUserDetails(userId))
    }

    private fun onMyProfileClicked() = viewModelScope.launch {
        val userId = getUserSessionUseCase().id
        _navigationEvent.tryEmit(HomeScreenNavigationEvent.GoToUserDetails(userId))
    }

    private suspend fun loadUserSession() {
        val userSession = getUserSessionUseCase()
        _state.update { it.copy(userSession = userSession) }
    }

    private suspend fun loadPublications() {
        getPublicationsUseCase().collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isPublicationsLoading = false,
                            publicationError = R.string.unknown_error
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isPublicationsLoading = true,
                            publicationError = null
                        )
                    }
                }

                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isPublicationsLoading = false,
                            publications = result.data.toPublicationUIModels()
                        )
                    }
                }
            }
        }
    }

    private fun List<Publication>?.toPublicationUIModels(): List<PublicationUIModel> {
        val userId = _state.value.userSession?.id
        if (this == null || userId == null) return emptyList()

        return this.map { publication ->
            val isLiked = publication.likes.contains(userId)
            PublicationUIModel.from(publication, isLiked)
        }
    }
}
