package com.example.ui.features.profile.component

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
import com.example.domain.models.UserProfile
import com.example.ui.theme.LocalDimensions

@Composable
fun ProfileDetailsHeaderView(profile: UserProfile) {
    Column {
        AsyncImage(
            model = profile.picture,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 125.dp,
                        bottomEnd = 125.dp
                    )
                )
        )
        Spacer(modifier = Modifier.height(LocalDimensions.current.xs))
        ProfileDetailsInfoView(profile)
    }
}
