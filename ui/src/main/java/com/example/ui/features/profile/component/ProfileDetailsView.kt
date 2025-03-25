package com.example.ui.features.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
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
fun ProfileDetailsView(profile: UserProfile) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.m)) {
                AsyncImage(
                    model = profile.picture,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 125.dp,
                                bottomEnd = 125.dp
                            )
                        )
                )

                ProfileDetailsInfoView(profile)
            }
        }

        // TODO
//        LazyVerticalGrid(columns = 2) {
//
//        }
    }
}