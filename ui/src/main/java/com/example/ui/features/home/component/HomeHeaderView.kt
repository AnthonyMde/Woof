package com.example.ui.features.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.domain.models.user.UserSession
import com.example.ui.R
import com.example.ui.features.home.HomeScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun HomeHeaderView(
    userSession: UserSession,
    onAction: (HomeScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.home_header_view_title, userSession.name),
            style = MaterialTheme.typography.headlineLarge
        )
        AsyncImage(
            model = userSession.pictureUriString,
            contentDescription = stringResource(R.string.home_header_view_profile_picture_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(LocalDimensions.current.iconLarge)
                .clip(CircleShape)
                .clickable {
                    onAction(HomeScreenAction.OnMyProfileClicked)
                }
        )
    }
}