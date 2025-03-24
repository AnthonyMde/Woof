package com.example.ui.features.camera

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.features.camera.component.CameraNoPermissionsView
import com.example.ui.features.camera.component.CameraPreviewView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CameraScreenRoot(
    viewModel: CameraViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle(CameraScreenState())

    CameraScreen(
        state = state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
fun CameraScreen(
    state: CameraScreenState,
    onAction: (CameraScreenAction) -> Unit
) {
    val launcherPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted)
            onAction(CameraScreenAction.OnCameraPermissionGranted)
    }

    LaunchedEffect(state.hasCameraPermission) {
        if (state.hasCameraPermission != null && !state.hasCameraPermission) {
            launcherPermission.launch(Manifest.permission.CAMERA)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        when {
            state.hasCameraPermission != true -> {
                CameraNoPermissionsView(modifier = Modifier.fillMaxSize())
            }

            else -> CameraPreviewView(
                onAction = onAction,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}