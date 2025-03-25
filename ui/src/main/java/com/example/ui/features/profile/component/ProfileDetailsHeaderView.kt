package com.example.ui.features.profile.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.models.UserProfile
import com.example.ui.R
import com.example.ui.component.OverlayIconButton
import com.example.ui.features.profile.ProfileScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun ProfileDetailsHeaderView(
    profile: UserProfile,
    onAction: (ProfileScreenAction) -> Unit
) {
    Column {
        Box {
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
            OverlayIconButton(
                icon = R.drawable.ic_back_arrow,
                contentDescription = stringResource(R.string.profile_details_back_arrow_description),
                onClick = {
                    onAction(ProfileScreenAction.OnNavigateUpClicked)
                },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = LocalDimensions.current.m, top= LocalDimensions.current.m)
            )
        }
        Spacer(modifier = Modifier.height(LocalDimensions.current.xs))
        ProfileDetailsInfoView(profile)
    }
}
