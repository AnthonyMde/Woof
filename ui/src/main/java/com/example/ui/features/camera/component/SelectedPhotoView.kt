package com.example.ui.features.camera.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.component.ErrorText
import com.example.ui.component.LoadingButton
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun SelectedPhotoView(
    selectedPhotoPath: String,
    isSendPhotoLoading: Boolean,
    sendError: String? = null,
    onAction: (CameraScreenAction) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = selectedPhotoPath,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = {
                onAction(CameraScreenAction.OnClearPhoto)
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(LocalDimensions.current.m)
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear photo"
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.xs),
            modifier = Modifier
                .padding(horizontal = LocalDimensions.current.l)
                .align(Alignment.BottomCenter)
                .offset(y = -LocalDimensions.current.m)
        ) {
            LoadingButton(
                onClick = {
                    onAction(CameraScreenAction.OnPhotoValidated)
                },
                buttonColors = ButtonDefaults.buttonColors().copy(
                    disabledContainerColor = Color.Gray
                ),
                isLoading = isSendPhotoLoading,
                enabled = !isSendPhotoLoading,
                label = stringResource(R.string.camera_take_photo_view_send_button_title)
                    .uppercase()
            )
            sendError?.let {
                ErrorText(it)
            }
        }
    }
}
