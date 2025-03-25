package com.example.ui.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.features.home.HomeScreenAction
import com.example.ui.features.home.model.PublicationUIModel
import com.example.ui.theme.LocalDimensions

@Composable
fun PublicationItemView(
    publication: PublicationUIModel,
    onAction: (HomeScreenAction) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.s)) {
        PublicationHeaderView(
            userPreview = publication.userPreview,
            onAction = onAction
        )

        Spacer(modifier = Modifier.height(LocalDimensions.current.s))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(LocalDimensions.current.corners))
        ) {
            AsyncImage(
                model = publication.imageUriString,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            publication.petTalk?.let {
                PetTalkView(it)
            }
        }

        PublicationFooterView(
            publication = publication,
            onAction = onAction
        )
    }
}

@Composable
private fun BoxScope.PetTalkView(petTalk: String) {
    Box(
        modifier = Modifier
            .matchParentSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.3f)
                    ),
                    startY = 150f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
    )
    Text(
        text = petTalk,
        style = MaterialTheme.typography.bodyMedium,
        color = Color.White,
        modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(LocalDimensions.current.m)
    )
}
