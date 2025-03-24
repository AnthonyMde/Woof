package com.example.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.models.Resource
import com.example.domain.usecase.GetPublicationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPublicationsUseCase: GetPublicationsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow().onStart {
        viewModelScope.launch { loadPublications() }
    }

    private suspend fun loadPublications() {
        getPublicationsUseCase().collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    // TODO
                }

                is Resource.Loading -> {
                    // TODO
                }

                is Resource.Success -> {
                    _state.update { it.copy(publications = result.data ?: emptyList()) }
                }
            }
        }
    }
}
