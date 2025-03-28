package com.example.ui.features.home.component

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.domain.models.user.UserPreview
import com.example.ui.R
import com.example.ui.features.home.HomeScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun PublicationHeaderView(
    userPreview: UserPreview,
    onAction: (HomeScreenAction) -> Unit
) {
    Row(modifier = Modifier
        .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {
            onAction(HomeScreenAction.OnPublicationHeaderClicked(userPreview.userId))
        }
        .padding(horizontal = LocalDimensions.current.m)
    ) {
        AsyncImage(
            model = userPreview.pictureUri,
            contentDescription = stringResource(R.string.publication_header_view_profile_picture_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(LocalDimensions.current.iconLarge)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LocalDimensions.current.sm)
        ) {
            Text(
                userPreview.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
            )
            Text(
                "${userPreview.address.city}, ${userPreview.address.country}",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}
