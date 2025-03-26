package com.example.ui.features.camera.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.models.publication.Publication
import com.example.ui.R
import com.example.ui.component.OverlayIconButton
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.features.home.model.PublicationUIModel
import com.example.ui.helper.getPublicationColorFrom
import com.example.ui.helper.getRandomColor
import com.example.ui.theme.LocalDimensions

@Composable
fun ColumnScope.CameraImagePreviewView(
    selectedPhotoPath: String,
    tint: Publication.Color,
    onAction: (CameraScreenAction) -> Unit
) {
    val color = PublicationUIModel.getMaterialColorFrom(tint)

    Box(
        modifier = Modifier
            .padding(horizontal = LocalDimensions.current.xs)
            .padding(top = LocalDimensions.current.m)
            .weight(3f)
            .clip(RoundedCornerShape(LocalDimensions.current.corners))
            .border(
                width = 2.dp,
                color = color,
                shape = RoundedCornerShape(LocalDimensions.current.corners)
            )
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
                .align(Alignment.TopStart)
                .padding(top = LocalDimensions.current.m, start = LocalDimensions.current.m)
        )
        BrushColorView(
            tint = color,
            onAction = onAction,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = LocalDimensions.current.m, end = LocalDimensions.current.m)
        )
    }
}

@Composable
private fun BrushColorView(
    tint: Color,
    onAction: (CameraScreenAction) -> Unit,
    modifier: Modifier
) {
    val nextColor = getPublicationColorFrom(getRandomColor(tint))

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(LocalDimensions.current.iconLarge)
            .clip(CircleShape)
            .clickable {
                onAction(CameraScreenAction.OnChangeColorClicked(nextColor))
            }
            .background(tint.copy(alpha = 0.7f))
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_brush_filled),
            contentDescription = stringResource(R.string.camera_generate_random_color_brush_icon),
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.matchParentSize()
        )
    }
}
