package com.example.ui.features.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.domain.constant.User
import com.example.domain.models.UserPreview
import com.example.ui.R
import com.example.ui.theme.LocalDimensions

@Composable
fun PublicationHeaderView(
    userPreview: UserPreview
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = LocalDimensions.current.m)
    ) {
        AsyncImage(
            model = User.PICTURE,
            contentDescription = stringResource(R.string.publication_header_view_profile_picture_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(LocalDimensions.current.iconLarge)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LocalDimensions.current.l)
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
