package com.example.ui.features.camera.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.component.ErrorText
import com.example.ui.component.LoadingButton
import com.example.ui.component.OverlayIconButton
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun SelectedPhotoView(
    selectedPhotoPath: String,
    isSendPhotoLoading: Boolean,
    @StringRes sendError: Int? = null,
    onAction: (CameraScreenAction) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(horizontal = LocalDimensions.current.xs)
                .padding(top = LocalDimensions.current.m)
                .weight(3f)
                .clip(RoundedCornerShape(LocalDimensions.current.corners))
        ) {
            AsyncImage(
                model = selectedPhotoPath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            OverlayIconButton(
                icon = R.drawable.ic_close_filled,
                onClick = {
                    onAction(CameraScreenAction.OnClearPhoto)
                },
                contentDescription = stringResource(R.string.camera_selected_photo_view_clear_description),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = LocalDimensions.current.m, end = LocalDimensions.current.m)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = LocalDimensions.current.l)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.xs),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
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
                    label = stringResource(R.string.camera_take_photo_view_send_button_title),
                    style = MaterialTheme.typography.bodyLarge
                )
                sendError?.let {
                    ErrorText(stringResource(it))
                }
            }
        }
        Spacer(modifier = Modifier.height(LocalDimensions.current.m))
    }
}
