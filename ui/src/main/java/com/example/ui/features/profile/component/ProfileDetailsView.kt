package com.example.ui.features.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.domain.models.user.UserProfile
import com.example.ui.features.profile.ProfileScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun ProfileDetailsView(
    profile: UserProfile,
    onAction: (ProfileScreenAction) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = LocalDimensions.current.sm,
        horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.sm),
        modifier = Modifier.fillMaxSize()
    ) {
        item(span = StaggeredGridItemSpan.FullLine, content = {
            ProfileDetailsHeaderView(profile, onAction)
        })

        items(profile.publicationImages) { image ->
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(LocalDimensions.current.corners))
            )
        }
    }
}
