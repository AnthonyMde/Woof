package com.example.ui.features.camera.component

import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.ui.features.camera.CameraScreenAction

@Composable
fun CameraPreviewView(
    modifier: Modifier = Modifier,
    onAction: (CameraScreenAction) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraController = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }

    Box(modifier = modifier) {
        AndroidView(
            factory = { context ->
                PreviewView(context).apply {
                    controller = cameraController
                    cameraController.bindToLifecycle(lifecycleOwner)
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        CameraTakePhotoButtonView(
            controller = cameraController,
            onAction = onAction,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
