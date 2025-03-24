package com.example.ui.features.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.models.Publication
import com.example.ui.theme.LocalDimensions

@Composable
fun PublicationItemView(
    publication: Publication
) {
    Column(verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.s)) {
        PublicationHeaderView(
            userPreview = publication.userPreview
        )
        Spacer(modifier = Modifier.height(LocalDimensions.current.s))
        AsyncImage(
            model = publication.imageUriString,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(LocalDimensions.current.corners))
        )
    }
}
