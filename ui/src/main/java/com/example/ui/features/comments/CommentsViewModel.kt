package com.example.ui.features.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Resource
import com.example.domain.usecase.GetPublicationCommentsUseCase
import com.example.ui.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommentsViewModel(
    private val getPublicationCommentsUseCase: GetPublicationCommentsUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CommentsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CommentsScreenAction) {
        when (action) {
            is CommentsScreenAction.OnSendCommentClicked -> {
                // TODO
            }
            is CommentsScreenAction.OnCommentInputValueChanged -> {
               _state.update { it.copy(userCommentInputValue = action.comment) }
            }
            else -> {}
        }
    }

    fun loadComments(publicationId: String) = viewModelScope.launch {
        getPublicationCommentsUseCase(publicationId).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update { it.copy(
                        isCommentsLoading = false,
                        commentsError = R.string.comments_screen_cannot_load_comments_error
                    ) }
                }
                is Resource.Loading -> {
                    _state.update { it.copy(
                        isCommentsLoading = true,
                        commentsError = null
                    ) }
                }
                is Resource.Success -> {
                    _state.update { it.copy(
                        isCommentsLoading = false,
                        commentsError = null,
                        comments = result.data ?: emptyList()
                    ) }
                }
            }
        }
    }
}
