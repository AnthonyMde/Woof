package com.example.ui.features.comments

sealed interface CommentsScreenAction {
    data class OnSendCommentClicked(val text: String) : CommentsScreenAction
    data object OnNavigateUpClicked : CommentsScreenAction
    data class OnCommentInputValueChanged(val comment: String) : CommentsScreenAction
}
