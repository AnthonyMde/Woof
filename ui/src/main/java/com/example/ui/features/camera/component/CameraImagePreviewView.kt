package com.example.ui.features.camera.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.component.OverlayIconButton
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun ColumnScope.CameraImagePreviewView(
    selectedPhotoPath: String,
    onAction: (CameraScreenAction) -> Unit
) {
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
}
