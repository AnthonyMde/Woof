package com.example.ui.features.camera.component

import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
    onAction: (CameraScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                CameraControlHelper.takePhoto(
                    context,
                    controller,
                    onPhotoTaken = { imageProxy ->
                        onAction(CameraScreenAction.OnTakePhoto(imageProxy))
                    },
                    onError = { error ->
                        onAction(CameraScreenAction.OnTakePhotoError(error))
                    }
                )
            }
            .padding(LocalDimensions.current.s)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_camera_outlined),
            contentDescription = stringResource(R.string.camera_take_photo_view_capture_description),
            modifier = Modifier.size(LocalDimensions.current.iconExtraLarge)
        )
    }
}
