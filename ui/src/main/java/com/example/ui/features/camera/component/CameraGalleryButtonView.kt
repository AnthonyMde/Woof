package com.example.ui.features.camera.component

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.features.camera.CameraScreenAction

@Composable
fun CameraGalleryButtonView(
    onAction: (CameraScreenAction) -> Unit
) {
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            onAction(CameraScreenAction.OnPickPhoto(uri))
        }
    }
    IconButton(
        onClick = {
            singlePhotoPickerLauncher.launch(
                input = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_gallery_outlined),
            contentDescription = stringResource(R.string.camera_take_photo_view_gallery_description)
        )
    }
}