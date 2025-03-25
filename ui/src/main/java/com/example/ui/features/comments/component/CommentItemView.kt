package com.example.ui.features.comments.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.domain.models.comment.Comment
import com.example.ui.helper.TimeHelper
import com.example.ui.theme.LocalDimensions


@Composable
fun CommentItemView(
    comment: Comment
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.s),
        modifier = Modifier
            .padding(LocalDimensions.current.m)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = comment.userInfo.pictureUriString,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(LocalDimensions.current.icon)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(LocalDimensions.current.s))
            Text(
                comment.userInfo.name,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(TimeHelper.timestampToFormattedDate(comment.timestamp),
                style = MaterialTheme.typography.labelSmall)
        }

        Text(
            comment.text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
