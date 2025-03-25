package com.example.ui.features.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.domain.models.UserProfile
import com.example.ui.R
import com.example.ui.theme.LocalDimensions

@Composable
fun ProfileDetailsInfoView(
    userProfile: UserProfile
) {
    Column {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                userProfile.name,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(LocalDimensions.current.s))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    stringResource(R.string.profile_details_infos_age, userProfile.age),
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.width(LocalDimensions.current.m))

                Icon(
                    painter = painterResource(R.drawable.ic_location_outlined),
                    contentDescription = null
                )
                Text(
                    userProfile.address.city,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Spacer(modifier = Modifier.height(LocalDimensions.current.xl))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LocalDimensions.current.l)
            ) {
                Text(
                    userProfile.bio,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(LocalDimensions.current.xl))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LocalDimensions.current.l)
            ) {
                Text(
                    stringResource(
                        R.string.profile_details_post_count,
                        userProfile.socialMetrics.postCount
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    stringResource(
                        R.string.profile_details_follower_count,
                        userProfile.socialMetrics.followerCount
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    stringResource(
                        R.string.profile_details_following_count,
                        userProfile.socialMetrics.followingCount
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(LocalDimensions.current.s))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray.copy(alpha = 0.5f)
            )
        }
    }
}
