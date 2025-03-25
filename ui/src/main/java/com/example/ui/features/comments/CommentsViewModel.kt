package com.example.ui.features.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel() {
    private val _state = MutableStateFlow(CommentsScreenState())
    val state = _state.asStateFlow()

    fun onAction(onAction: CommentsScreenAction) {
        when (onAction) {
            is CommentsScreenAction.OnSendCommentClicked -> {
                // TODO
            }
            else -> {}
        }
    }

    fun loadComments(publicationId: String) = viewModelScope.launch {
        // TODO
    }
}
