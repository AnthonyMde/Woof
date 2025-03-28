package com.example.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.features.home.component.HomeHeaderView
import com.example.ui.features.home.component.PublicationItemView
import com.example.ui.theme.LocalDimensions
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel(),
    goToUserProfile: (String) -> Unit,
    goToCommentScreen: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle(HomeScreenState())
    val scope = rememberCoroutineScope()

    LaunchedEffect(null) {
        scope.launch {
            viewModel.navigationEvent.collectLatest { event ->
                when (event) {
                    is HomeScreenNavigationEvent.GoToUserDetails -> goToUserProfile(event.userId)
                }
            }
        }
    }

    HomeScreen(
        state = state,
        onAction = { action ->
            if (action is HomeScreenAction.OnPublicationCommentClicked) {
                goToCommentScreen(action.publicationId)
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun HomeScreen(
    state: HomeScreenState,
    onAction: (HomeScreenAction) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            if (state.userSession != null) {
                item {
                    HomeHeaderView(
                        userSession = state.userSession,
                        onAction = onAction,
                        modifier = Modifier
                            .padding(horizontal = LocalDimensions.current.l)
                            .padding(top = LocalDimensions.current.m)
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(LocalDimensions.current.m))
            }

            items(state.publications) { publication ->
                PublicationItemView(publication, onAction)
                Spacer(modifier = Modifier.height(LocalDimensions.current.l))
            }
        }
    }
}
