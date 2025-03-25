package com.example.ui.features.comments

import androidx.annotation.StringRes
import com.example.domain.models.comment.Comment

data class CommentsScreenState(
    val comments: List<Comment> = emptyList(),
    val isCommentsLoading: Boolean = false,
    @StringRes val commentsError: Int? = null,
    val userCommentInputValue: String = "",
    @StringRes val userCommentInputError: Int? = null,
    val isSendCommentLoading: Boolean = false
)
