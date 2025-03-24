package com.example.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.features.home.component.HomeHeaderView
import com.example.ui.features.home.component.PublicationItemView
import com.example.ui.theme.LocalDimensions
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle(HomeScreenState())

    HomeScreen(
        state = state
    )
}

@Composable
fun HomeScreen(
    state: HomeScreenState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.userSession != null) {
            HomeHeaderView(
                userSession = state.userSession,
                modifier = Modifier.padding(horizontal = LocalDimensions.current.l)
            )
        }

        LazyColumn {
            items(state.publications) { publication ->
                PublicationItemView(publication)
            }
        }
    }
}