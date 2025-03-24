package com.example.ui.features.camera.component

import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.ui.R
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.theme.LocalDimensions

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

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .padding(horizontal = LocalDimensions.current.xs)
                .padding(top = LocalDimensions.current.m)
                .weight(3f)
                .clip(RoundedCornerShape(LocalDimensions.current.corners))
        ) {
            AndroidView(
                factory = { context ->
                    PreviewView(context).apply {
                        controller = cameraController
                        cameraController.bindToLifecycle(lifecycleOwner)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        // TODO
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_gallery_outlined),
                        contentDescription = stringResource(R.string.camera_take_photo_view_gallery_description)
                    )
                }
                CameraTakePhotoButtonView(
                    controller = cameraController,
                    onAction = onAction,
                    modifier = Modifier
                )
                IconButton(
                    onClick = {
                        // TODO
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_switch_camera_outlined),
                        contentDescription = stringResource(R.string.camera_take_photo_view_switch_description)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(LocalDimensions.current.m))
    }
}
