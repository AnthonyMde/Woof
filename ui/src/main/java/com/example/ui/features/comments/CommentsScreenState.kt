package com.example.ui.features.comments

import com.example.domain.models.Comment

data class CommentsScreenState(
    val comments: List<Comment> = emptyList(),
    val userCommentInputValue: String = "",
    val userCommentInputError: String? = null,
    val isSendCommentLoading: Boolean = false
)
