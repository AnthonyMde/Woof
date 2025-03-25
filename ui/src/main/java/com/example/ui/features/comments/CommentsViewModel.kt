package com.example.ui.features.comments

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.models.Resource
import com.example.domain.usecase.GetPublicationCommentsUseCase
import com.example.domain.usecase.PostPublicationCommentUseCase
import com.example.ui.R
import com.example.ui.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommentsViewModel(
    private val getPublicationCommentsUseCase: GetPublicationCommentsUseCase,
    private val postPublicationCommentUseCase: PostPublicationCommentUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(CommentsScreenState())
    val state = _state.asStateFlow().onStart {
        loadComments(publicationId)
    }
    private val publicationId: String

    init {
        savedStateHandle.toRoute<Route.Comments>().let {
            publicationId = it.publicationId
        }
    }

    fun onAction(action: CommentsScreenAction) {
        when (action) {
            is CommentsScreenAction.OnSendCommentClicked -> sendComment(action.text)
            is CommentsScreenAction.OnCommentInputValueChanged -> {
                _state.update { it.copy(
                    userCommentInputValue = action.comment,
                    userCommentInputError = null
                ) }
            }

            else -> {}
        }
    }

    private fun sendComment(commentText: String) = viewModelScope.launch {
        postPublicationCommentUseCase(publicationId, commentText).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            userCommentInputError = R.string.comments_screen_cannot_send_comment_error,
                            isSendCommentLoading = false
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            userCommentInputError = null,
                            isSendCommentLoading = true
                        )
                    }
                }
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            userCommentInputError = null,
                            userCommentInputValue = "",
                            isSendCommentLoading = false,
                        )
                    }
                    loadComments(publicationId)
                }
            }
        }
    }

    private fun loadComments(publicationId: String) = viewModelScope.launch {
        getPublicationCommentsUseCase(publicationId).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isCommentsLoading = false,
                            commentsError = R.string.comments_screen_cannot_load_comments_error
                        )
                    }
                }

                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isCommentsLoading = true,
                            commentsError = null
                        )
                    }
                }

                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isCommentsLoading = false,
                            commentsError = null,
                            comments = result.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }
}
