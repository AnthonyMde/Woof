package com.example.ui.features.profile

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.ui.features.profile.component.ProfileDetailsView
import com.example.ui.features.profile.component.ProfileErrorView
import com.example.ui.features.profile.component.ProfileLoadingView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreenRoot(
    userId: String,
    viewModel: ProfileViewModel = koinViewModel(),
    navigateUp: () -> Unit
) {
    val state by viewModel.state.collectAsState(ProfileScreenState.Loading)
    val scope = rememberCoroutineScope()

    LaunchedEffect(null) {
        scope.launch {
            viewModel.navigationEvent.collectLatest { event ->
                when (event) {
                    ProfileScreenNavigationEvent.GoBack -> {
                        navigateUp()
                    }
                }
            }
        }
    }

    LaunchedEffect(userId) {
        viewModel.loadProfile(userId)
    }

    ProfileScreen(
        state = state
    )
}

@Composable
fun ProfileScreen(state: ProfileScreenState) {
    when (state) {
        is ProfileScreenState.Error -> ProfileErrorView(state.error)
        ProfileScreenState.Loading -> ProfileLoadingView()
        is ProfileScreenState.Success -> ProfileDetailsView(state.profile)
    }
}