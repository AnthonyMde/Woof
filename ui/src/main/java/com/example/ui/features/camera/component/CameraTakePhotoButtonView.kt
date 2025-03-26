package com.example.ui.features.camera.component

import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.helper.CameraControlHelper
import com.example.ui.theme.LocalDimensions

@Composable
fun CameraTakePhotoButtonView(
    controller: LifecycleCameraController,
    isLoading: Boolean,
    onAction: (CameraScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                onAction(CameraScreenAction.OnTakePhoto)

                CameraControlHelper.takePhoto(
                    context,
                    controller,
                    onPhotoTaken = { imageProxy ->
                        onAction(CameraScreenAction.OnPhotoTaken(imageProxy))
                    },
                    onError = { error ->
                        onAction(CameraScreenAction.OnPhotoTakenError(error))
                    }
                )
            }
            .padding(LocalDimensions.current.s)
    ) {
        if (!isLoading) {
            Icon(
                painter = painterResource(R.drawable.ic_take_photo),
                contentDescription = stringResource(R.string.camera_take_photo_view_capture_description),
                modifier = Modifier.size(LocalDimensions.current.iconExtraLarge)
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier.size(LocalDimensions.current.iconLarge),
                strokeWidth = LocalDimensions.current.stroke
            )
        }
    }
}
