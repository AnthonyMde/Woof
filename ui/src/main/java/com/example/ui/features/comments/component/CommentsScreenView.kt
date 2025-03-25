package com.example.ui.features.comments.component

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui.features.comments.CommentsScreenAction
import com.example.ui.features.comments.CommentsScreenState
import com.example.ui.theme.LocalDimensions

@Composable
fun BoxScope.CommentsScreenView(
    state: CommentsScreenState,
    onAction: (CommentsScreenAction) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.comments) { comment ->
            CommentItemView(comment)
        }
    }

    CommentTextFieldView(
        value = state.userCommentInputValue,
        isLoading = state.isSendCommentLoading,
        error = state.userCommentInputError,
        onAction = onAction,
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(horizontal = LocalDimensions.current.m)
    )
}
