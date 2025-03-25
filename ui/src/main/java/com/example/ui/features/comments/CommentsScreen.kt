package com.example.ui.features.comments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.component.BackTopAppBar
import com.example.ui.features.comments.component.CommentItemView
import com.example.ui.features.comments.component.CommentTextFieldView
import com.example.ui.theme.LocalDimensions
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CommentScreenRoot(
    publicationId: String,
    navigateUp: () -> Unit,
    viewModel: CommentsViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(publicationId) {
        viewModel.loadComments(publicationId)
    }

    CommentScreen(
        state = state,
        onAction = { action ->
            when (action) {
                CommentsScreenAction.OnNavigateUpClicked -> navigateUp()
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun CommentScreen(
    state: CommentsScreenState,
    onAction: (CommentsScreenAction) -> Unit
) {
    Scaffold(
        topBar = {
            BackTopAppBar(
                title = stringResource(R.string.comments_screen_top_bar_title),
                onNavigateUp = { onAction(CommentsScreenAction.OnNavigateUpClicked) }
            )
        }
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(state.comments) { comment ->
                    CommentItemView(comment)
                }
            }

            CommentTextFieldView(
                value = state.userCommentInputValue,
                onAction = onAction,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .offset(y = -LocalDimensions.current.m)
                    .padding(horizontal = LocalDimensions.current.m)
            )
        }
    }
}
